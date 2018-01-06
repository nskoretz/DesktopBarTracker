package ca.nskoretz;


import ca.nskoretz.BarExceptions.BadMeasurementException;


/**
 * file     Measurement.java
 * @author  Nicholas Skoretz
 * date     2018-01-06
 *
 * This class defines the Measurement object. It is abstract, its direct descendants 'liquidMeasurement' and
 * 'solidMeasurement' implement different mutator methods.

 */
public abstract class Measurement {
    //Attributes
    int amount;
    int ratioBot;
    int ratioTop;
    String measureName;
    String system;

    public static final String measuresBar[] = { "bar spoon", "bar spoons", "dash", "dashes", "jigger", "jiggers",
            "pony", "ponies" };
    public static final String measuresGarnish[] = { "drop", "drops", "leaves", "piece", "pieces", "pinch", "pinches",
            "slice", "slices", "sprig", "sprigs", "sprinkling", "spritz", "spritzes", "twist", "twists", "wedge",
            "wedges", "wheel", "wheels" };
    public static final String measuresImperial[] = { "cup", "cups", "gallon", "gallons", "oz", "pint", "pints",
            "quart", "quarts", "tbsp", "tsp" };
    public static final String measuresMetric[] = { "L", "mL" };
    public static final String systems[] = { "Bar Measures", "Garnishes", "Imperial", "Metric" };




    //Constructors
    /**
     * The main constructor for the Measurement object. Calls mutator methods with the passed values to create a new
     * Measurement.
     * @param amount The numerical amount of the measurement.
     * @param ratioTop The top of the ratio.
     * @param ratioBot The bottom of the ratio.
     * @param measureName The name of the measurement that is being counted. Eg. mL.
     * @throws BadMeasurementException Thrown if any of the passed params are invalid.
     */
    public Measurement( int amount, int ratioTop, int ratioBot, String measureName ) throws
    BadMeasurementException {
        setAmount( amount );
        setRatio( ratioBot, ratioTop );
        setMeasureName( measureName );
    }


    /**
     * A no-arg constructor for the Measurement object. Calls mutator methods with default values.
     * @throws BadMeasurementException Thrown if any of the passed params are invalid.
     */
    public Measurement() throws BadMeasurementException {
        this( 1, 1, 2, "oz" );
    }


    /**
     * A copy constructor for the Measurement type. Will create a deep copy of the passed Measurement.
     * @param toCopy The measurement to copy.
     * @throws BadMeasurementException Thrown if any of the passed params are invalid.
     */
    public Measurement( Measurement toCopy ) throws BadMeasurementException {
        if( toCopy != null ) {
            setAmount( toCopy.getAmount() );
            setRatio( toCopy.getRatioBot(), toCopy.getRatioTop() );
            setMeasureName( toCopy.getMeasureName() );
            setSystem( toCopy.getSystem() );
        } else {
            throw new BadMeasurementException( "The Measurement you were trying to copy is incorrect." );
        }
    }




    //Mutators

    /**
     * Allows for the safe mutation of the amount attribute. Checks to see if the passed amount is greater than 0, if
     * not, will throw an exception.
     * @param amount The numerical amount of the Measurement.
     * @throws BadMeasurementException Thrown if the amount passed is less than or equal to 0.
     */
    public void setAmount(int amount) throws BadMeasurementException {
        if( amount > 0 ) {
            this.amount = amount;
        } else {
            throw new BadMeasurementException( "The amount of the Measurement must be greater then 0." );
        }
    }


    /**
     * Allows for the safe mutation of the ratio of the Measurement. This mutator takes both the top and the bottom of
     * the ratio as params and makes sure that the top is less than the bottom, and if the ratio exists at all.
     * @param ratioBot The bottom half of the ratio.
     * @param ratioTop The top half of the ratio.
     * @throws BadMeasurementException Thrown if the ratioTop is greater than RatioBot.
     */
    public abstract void setRatio(int ratioBot, int ratioTop ) throws BadMeasurementException;


    /**
     * Allows for the safe mutation of the measureName attribute. Checks to see if the measureName is valid by
     * comparing it to the entries in measures<...>[]</...> list. Throws exception if invalid.
     * @param measureName The name of the measurement that is being counted. Eg. mL.
     * @throws BadMeasurementException Thrown if the measurementName is invalid.
     */
    public abstract void setMeasureName(String measureName ) throws BadMeasurementException;


    /**
     * Allows for the safe mutation of the system attribute. Checks to see if the system is valid by comparing it to
     * the entries in the systems[] list. Throws exception if invalid.
     * @param system The measurement system to which this Measurement object belongs to.
     * @throws BadMeasurementException Thrown if the system is invalid.
     */
    public void setSystem(String system) throws BadMeasurementException {
        //Attributes
        Boolean isFound = false;


        //Body
        if( ! system.isEmpty() ) {
            for( int i = 0; i < systems.length; i++ ) {
                if( system.equals( systems[i] ) ) {
                    isFound = true;
                    i = systems.length;
                }
            }
        }

        if( isFound ) {
            this.system = system;
        } else {
            throw new BadMeasurementException( "The 'system' attribute of the Measurement is incorrect." );
        }
    }




    //Accessors

    /**
     * Allows access to the amount attribute.
     * @return int
     */
    public int getAmount() {
        return amount;
    }


    /**
     * Allows access to the RatioTop attribute.
     * @return int
     */
    public int getRatioTop() {
        return ratioTop;
    }


    /**
     * Allows access to the RatioBot attribute.
     * @return int
     */
    public int getRatioBot() {
        return ratioBot;
    }


    /**
     * Allows access to the measureName attribute.
     * @return String
     */
    public String getMeasureName() {
        return measureName;
    }


    /**
     * Allows access to the system attribute.
     * @return String
     */
    public String getSystem() {
        return system;
    }




    //equals
    /**
     * Provides a way to compare Measurement objects. Overrides the parent equals().
     * @param o The Measurement with which to be compared.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if( this == o ) {
            return true;
        }

        if( o == null ) {
            return false;
        }

        if( this.getClass() != o.getClass() ) {
            return false;
        }

        Measurement ot = ( Measurement ) o;
        if( ( this.getAmount() == ot.getAmount() ) && ( this.getRatioBot() == ot.getRatioBot()) &&
                ( this.getRatioTop() == ot.getRatioTop() ) && this.getMeasureName().equals( ot.getMeasureName() ) &&
                this.getSystem().equals( ot.getSystem() ) ) {
            return true;
        } else {
            return false;
        }
    }




    //toString
    /**
     * Returns most attributes in a readable String format. Overrides the parent toString().
     * @return String
     */
    @Override
    public String toString() {
        return getAmount() + " " + getRatioTop() + "/" + getRatioBot() + " " + getMeasureName();
    }
} //class
