package ca.nskoretz.BarExceptions;


/**
 * file     BadIndexException.java
 * @author Nicholas Skoretz
 * date     2018-01-03
 *
 * This class is a BarException that is thrown if an attribute in an Index object is incorrect.
 */
public class BadIndexException extends Exception {
    //Constructors

    /**
     * A no-arg constructor for the BadIndexException. Supplies a default message for the Exception.
     */
    public BadIndexException() {
        super( "One or more attributes of the Index are incorrect." );
    }


    /**
     * A constructor for the BadIndexException that lets the calling function supply a message for the Exception.
     * @param message A message supplied by the calling function.
     */
    public BadIndexException( String message ) {
        super( message );
    }
}
