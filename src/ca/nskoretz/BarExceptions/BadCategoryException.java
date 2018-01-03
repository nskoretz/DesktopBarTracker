package ca.nskoretz.BarExceptions;

/**
 * BadCategoryException.java
 * Nicholas Skoretz
 * 2017-12-10
 *
 * This class is a BarException that is thrown if an attribute in a Category object is incorrect.
 */
public class BadCategoryException extends Exception {
    //Constructors
    public BadCategoryException() {
        super( "One or more attributes of Category are incorrect" );
    }

    public BadCategoryException( String message ) {
        super( message );
    }
}
