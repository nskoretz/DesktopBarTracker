package ca.nskoretz.BarExceptions;

/**
 * file     BadCategoryException.java
 * @author Nicholas Skoretz
 * date     2018-01-03
 *
 * This class is a BarException that is thrown if an attribute in a Category object is incorrect.
 */
public class BadCategoryException extends Exception {
    //Constructors
    /**
     * No-arg constructor for the BadCategoryException object. This supplies a default message to the message attribute
     * inherited from the Exception class.
     */
    public BadCategoryException() {
        super( "One or more attributes of Category are incorrect" );
    }


    /**
     * Constructor for the BadCategoryException object. This allows a custom message to be passed as the message
     * attribute.
     * @param message A custom message to become the message attribute of the BadCategoryException object.
     */
    public BadCategoryException( String message ) {
        super( message );
    }
}
