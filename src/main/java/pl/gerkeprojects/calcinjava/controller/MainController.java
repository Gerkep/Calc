package pl.gerkeprojects.calcinjava.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import pl.gerkeprojects.calcinjava.logic.Main;
import pl.gerkeprojects.calcinjava.logic.Methods;

import java.util.Scanner;

public class MainController {

    @FXML
    private TextField previous;

    @FXML
    private TextField current;

    @FXML
    private Button acButton;

    @FXML
    private Button signButton;

    @FXML
    private Button percentButton;

    @FXML
    private Button divideButton;

    @FXML
    private Button sevenButton;

    @FXML
    private Button eightButton;

    @FXML
    private Button nineButton;

    @FXML
    private Button multiplyButton;

    @FXML
    private Button fourButton;

    @FXML
    private Button fiveButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button substractButton;

    @FXML
    private Button oneButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button threeButton;

    @FXML
    private Button addButton;

    @FXML
    private Button zeroButton;

    @FXML
    private Button commaButton;

    @FXML
    private Button equalsButton;

    Main main = new Main();
    Methods method = new Methods();

public void initialize(){
    setTextFields();
    display();
    transferAbove();
    allClear();
    action();
    signConfig();
}
public void setTextFields(){
    TextField textCurrent = current;
    TextField textPrevious = previous;
    current.setEditable(false);
    previous.setEditable(false);
}
public void display(){
    method.buttonsSettings(zeroButton, current);
    method.buttonsSettings(oneButton, current);
    method.buttonsSettings(twoButton, current);
    method.buttonsSettings(threeButton, current);
    method.buttonsSettings(fourButton, current);
    method.buttonsSettings(fiveButton, current);
    method.buttonsSettings(sixButton, current);
    method.buttonsSettings(sevenButton, current);
    method.buttonsSettings(eightButton, current);
    method.buttonsSettings(nineButton, current);
    method.buttonsSettings(equalsButton, current);
    method.buttonsSettings(substractButton, current);
    method.buttonsSettings(multiplyButton, current);
    method.buttonsSettings(addButton, current);
    method.buttonsSettings(divideButton, current);
    commaButton.setOnAction(event -> {
        current.appendText(".");
    });
}
public void transferAbove(){
    method.transfer(substractButton, previous, current);
    method.transfer(addButton, previous, current);
    method.transfer(multiplyButton, previous, current);
    method.transfer(divideButton, previous, current);
}
public void allClear(){
    acButton.setOnAction(event -> {
        current.setText("");
        previous.setText("");
    });
}
public void action(){
    equalsButton.setOnAction(event -> {
        String prevNum = previous.getText().substring(0, previous.getText().length() - 1);//zwrócić double ze stringa bez ostatniej litery
        double a = Double.parseDouble(prevNum);
        String operator = previous.getText().substring(previous.getText().length() - 1);
        double b = Double.parseDouble(current.getText());
        previous.setText("");
        current.setText(String.valueOf(main.calculate(a, operator, b)));
    });
}
public void signConfig(){
    signButton.setOnAction(event -> {
        if(current.getText().contains("-")){
            current.setText(current.getText(1, current.getText().length()));
        }else {
            current.setText("-" + current.getText());
        }
    });
}

}