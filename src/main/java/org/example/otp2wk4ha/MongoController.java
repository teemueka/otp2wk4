package org.example.otp2wk4ha;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MongoController {
    public TextField id;
    public TextField name;
    public TextField age;
    public TextField city;
    private final UserCRUD userCRUD;

    public MongoController() {
        userCRUD = new UserCRUD();
    }


    @FXML
    protected void add() {
        userCRUD.createUser(new User
                (Integer.parseInt(id.getText()),
                name.getText(),
                Integer.parseInt(age.getText()),
                city.getText()));
    }

    @FXML
    protected void read() {
        userCRUD.readUsers();
    }

    // ota id ja updatee sen kautta
    @FXML
    protected void update() {
        userCRUD.updateUser(Integer.parseInt(id.getText()), name.getText(), Integer.parseInt(age.getText()), city.getText());
    }

    @FXML
    protected void delete() {
        userCRUD.deleteUser(Integer.parseInt(id.getText()));
    }

}