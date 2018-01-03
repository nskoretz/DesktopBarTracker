package ca.nskoretz.BarExceptions;


/**
 * file     BadIngredientException.java
 * @author Nicholas Skoretz
 * date     2018-01-04
 *
 * This class is a BarException that is thrown if an attribute in an Ingredient object is incorrect.
 */
public class BadIngredientException extends Exception {
    //Constructors
    /**
     * No-arg constructor for the BadIngredientException object. This supplies a default message to the message attribute
     * inherited from the Exception class.
     */
    public BadIngredientException() {
        super( "One or more attributes of the Ingredient are incorrect" );
    }


    /**
     * Constructor for the BadIngredientException object. This allows a custom message to be passed as the message
     * attribute.
     * @param message A custom message to become the message attribute of the BadCategoryException object.
     */
    public BadIngredientException( String message ) {
        super( message );
    }
}
