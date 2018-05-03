package ca.nskoretz.BarExceptions;

/**
 * file     BadDrinkException.java
 * @author Nicholas Skoretz
 * date     2018-05-03
 *
 * This class is a BarException that is thrown if an attribute in a Drink object is incorrect.
 */
public class BadDrinkException extends Exception {
    //Constructors
    /**
     * No-arg constructor for the BadDrinkException object. This supplies a default message to the message attribute
     * inherited from the Exception class.
     */
    public BadDrinkException() {
        super( "One or more attributes of Drink are incorrect" );
    }


    /**
     * Constructor for the BadDrinkException object. This allows a custom message to be passed as the message
     * attribute.
     * @param message A custom message to become the message attribute of the BadDrinkException object.
     */
    public BadDrinkException( String message ) {
        super( message );
    }
}
