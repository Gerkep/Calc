package pl.gerkeprojects.calcinjava.logic;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Methods {

    public void buttonsSettings(Button button, TextField textField) {
        button.setOnAction(event -> {
            textField.appendText(button.getText());
        });
    }

    public void transfer(Button button, TextField previous, TextField current){
        button.setOnAction(event -> {
            previous.appendText(current.getText() + button.getText());
            current.clear();
        });
    }
}
