package pl.gerkeprojects.calcinjava.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import pl.gerkeprojects.calcinjava.logic.Main;

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
    Scanner scanner = new Scanner(System.in);

public void initialize(){
    setTextFields();
    display();
    transferAbove();
    allClear();
    action();
}
public void setTextFields(){
    TextField textCurrent = current;
    TextField textPrevious = previous;
    current.setEditable(false);
    previous.setEditable(false);
}
public void display(){
    buttonsSettings(zeroButton);
    buttonsSettings(oneButton);
    buttonsSettings(twoButton);
    buttonsSettings(threeButton);
    buttonsSettings(fourButton);
    buttonsSettings(fiveButton);
    buttonsSettings(sixButton);
    buttonsSettings(sevenButton);
    buttonsSettings(eightButton);
    buttonsSettings(nineButton);
    buttonsSettings(equalsButton);
    buttonsSettings(substractButton);
    buttonsSettings(multiplyButton);
    buttonsSettings(addButton);
    buttonsSettings(divideButton);
    commaButton.setOnAction(event -> {
        current.appendText(".");
    });
}
public void transferAbove(){
    transfer(substractButton);
    transfer(addButton);
    transfer(multiplyButton);
    transfer(divideButton);
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
        Double a = Double.parseDouble(prevNum);
        String operator = previous.getText().substring(previous.getText().length() - 1);
        Double b = Double.parseDouble(current.getText());
        previous.setText("");
        current.setText(String.valueOf(main.calculate(a, operator, b)));
    });
}
public void buttonsSettings(Button button) {
    button.setOnAction(event -> {
       current.appendText(button.getText());
    });
}
public void transfer(Button button){
    button.setOnAction(event -> {
        previous.appendText(current.getText() + button.getText());
        current.clear();
    });
}
}