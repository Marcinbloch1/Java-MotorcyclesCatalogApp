package pl.polsl.lab.exception;

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
}