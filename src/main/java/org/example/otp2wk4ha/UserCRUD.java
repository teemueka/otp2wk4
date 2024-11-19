package org.example.otp2wk4ha;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import javax.swing.JOptionPane;

public class UserCRUD {
    private final MongoCollection<Document> collection;

    public UserCRUD() {
        MongoDatabase database = MongoDBConnection.getDatabase();
        this.collection = database.getCollection("users");
    }

    public void createUser(User user) {
        Document document = new Document("_id", user.getId())
                .append("name", user.getName())
                .append("age", user.getAge())
                .append("city", user.getCity());
        collection.insertOne(document);
        JOptionPane.showMessageDialog(null, "User created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void readUsers() {
        StringBuilder usersList = new StringBuilder();
        for (Document doc : collection.find()) {
            usersList.append(doc.toJson()).append("\n");
        }
        if (!usersList.isEmpty()) {
            JOptionPane.showMessageDialog(null, usersList.toString(), "Users List", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No users found.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void updateUser(int id, String newName, int newAge, String newCity) {
        Document updateFields = new Document()
                .append("name", newName)
                .append("age", newAge)
                .append("city", newCity);
        collection.updateOne(eq("_id", id), new Document("$set", updateFields));
        JOptionPane.showMessageDialog(null, "User updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public void deleteUser(int id) {
        collection.deleteOne(eq("_id", id));
        JOptionPane.showMessageDialog(null, "User deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
