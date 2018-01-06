package ca.nskoretz;


import ca.nskoretz.BarExceptions.BadMeasurementException;

/**
 * file     solidMeasurement.java
 * @author  Nicholas Skoretz
 * date     2018-01-06
 *
 * This class defines the solidMeasurement object. This class is a child of the abstract Measurement class, it holds
 * data for solid Ingredients.
 */
public class solidMeasurement extends Measurement {
    //Attributes
    private boolean isNamePost;



    //Constructors
    /**
     * The main constructor for the solidMeasurement object. Calls the parent constructor with the passed values to
     * create a new solidMeasurement.
     * @param amount The numerical amount of the measurement.
     * @param measureName The name of the measurement that is being counted. Eg. wheels
     * @throws BadMeasurementException Thrown if any of the passed params are invalid.
     */
    public solidMeasurement(int amount, String measureName, boolean namePost) throws BadMeasurementException {
        super(amount, 0, 0, measureName);
        setNamePost( namePost );
    }


    /**
     * A no-arg constructor for the solidMeasurement object. Calls the main constructor with default values.
     * @throws BadMeasurementException Thrown if any of the passed params are invalid.
     */
    public solidMeasurement() throws BadMeasurementException {
        this( 1, "spritz", false );

    }


    /**
     * A copy constructor for the solidMeasurement type. Will create a deep copy of the passed Measurement.
     * @param toCopy The measurement to copy.
     * @throws BadMeasurementException Thrown if any of the passed params are invalid.
     */
    public solidMeasurement( solidMeasurement toCopy) throws BadMeasurementException {
        super(toCopy);
        this.setNamePost( toCopy.isNamePost);
    }




    //Mutators
    /**
     * As the ratios are not needed for solid measurements, the attributes are set to 0.
     * @param ratioBot The bottom half of the ratio.
     * @param ratioTop The top half of the ratio.
     */
    @Override
    public void setRatio(int ratioBot, int ratioTop) {
        this.ratioBot = 0;
        this.ratioTop = 0;
    }


    /**
     * Allows for the safe mutation of the measureName attribute. Checks to see if the measureName is valid by
     * comparing it to the entries in measuresGarnish list. Throws exception if invalid.
     * @param measureName The name of the measurement that is being counted. Eg. slices
     * @throws BadMeasurementException Thrown if the measurementName is invalid.
     */
    @Override
    public void setMeasureName(String measureName) throws BadMeasurementException {
        //Attributes
        Boolean isFound = false;


        //Body
        if( ! measureName.isEmpty() ) {
            for( int i = 0; i < measuresGarnish.length; i++ ) {
                if( measureName.equals( measuresGarnish[i] ) ) {
                    isFound = true;
                }
            }
        }

        if( isFound ) {
            this.measureName = measureName;
        } else {
            throw new BadMeasurementException( "The 'measurementName' attribute of Measurement is incorrect." );
        }
    }


    /**
     * Allows for the safe mutation of the isNamePost attribute. If the name of an ingredient comes after the measure
     * name, such as, 'a spritz of Aperol' then isNamePost is true, as opposed to, 'a lemon twist', where the name
     * 'lemon' comes before 'twist'.
     * @param namePost Whether the name of the ingredient or measurement is first.
     */
    public void setNamePost( boolean namePost ) {
            isNamePost = namePost;
    }




    //Accessors
    /**
     * Allows access to the isNamePost attribute.
     * @return boolean
     */
    public boolean isNamePost() {
        return isNamePost;
    }




    //equals
    /**
     * Provides a way to compare solidMeasurement objects. Overrides the parent equals().
     * @param o The Measurement with which to be compared.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        boolean parentEqRes = super.equals(o);

        solidMeasurement ot = ( solidMeasurement ) o ;
        return (parentEqRes && ( this.isNamePost() == ot.isNamePost() ) );
    }




    //toString
    /**
     * Returns most attributes in a readable String format. Calls the parent toString().
     * @return String
     */
    @Override
    public String toString() {
        return getAmount() + " " + getMeasureName();
    }
}
