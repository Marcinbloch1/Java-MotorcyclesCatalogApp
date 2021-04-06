package pl.polsl.lab;

import javafx.scene.control.Alert;

/**
 * Class of own exception
 * @author Marcin Bloch
 * @version 1.2.0
 */
public class MyException extends Exception{
    /**
     * Constructor of exception class.
     * Displays sent message
     * @param message that is sent when exception occurs
     */
    public MyException(String message){
        super(message);
    }

    /**
     * Alert dialog if exception is thrown
     * @param message that is sent when exception occurs
     */
    public void exceptionAlert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}