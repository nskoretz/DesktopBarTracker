package ca.nskoretz.BarExceptions;

/**
 * BadMeasurementException.java
 * Nicholas Skoretz
 * 2017-12-10
 *
 * This class is a BarException that is thrown if an attribute in a Measurement object is incorrect.
 */
public class BadMeasurementException extends Exception {
    //Constructors
    public BadMeasurementException() {
        super( "One or more attributes of the Measurement are incorrect." );
    }


    public BadMeasurementException( String message ) {
        super( message );
    }
}
