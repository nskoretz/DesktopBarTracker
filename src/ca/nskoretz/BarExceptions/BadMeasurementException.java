package ca.nskoretz.BarExceptions;

/**
 * file     BadMeasurementException.java
 * @author Nicholas Skoretz
 * date     2017-12-10
 *
 * This class is a BarException that is thrown if an attribute in a Measurement object is incorrect.
 */
public class BadMeasurementException extends Exception {
    //Constructors

    /**
     * A no-arg constructor for the BadMeasurementException. Supplies a default message for the Exception.
     */
    public BadMeasurementException() {
        super( "One or more attributes of the Measurement are incorrect." );
    }


    /**
     * A constructor for the BadMeasurementException. Allows the calling function to supply a message for the Exception.
     * @param message A message for the Exception supplied by the calling function.
     */
    public BadMeasurementException( String message ) {
        super( message );
    }
}
