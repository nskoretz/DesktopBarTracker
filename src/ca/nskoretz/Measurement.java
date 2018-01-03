package ca.nskoretz;


import ca.nskoretz.BarExceptions.BadMeasurementException;


/**
 * file     Measurement.java
 * @author  Nicholas Skoretz
 * date     2018-01-04
 *
 * This class defines the Measurement object. This object holds the amount in whole numbers and fractions as well as
 * the measure and the system, whether Bar Measures, Imperial, or Metric.
 *
 * TODO list
 * need to incorporate the system attribute in the constructors.
 * Incorporate the idea that this object may measure Garnishes too. Or we make a common parent class for
 *      liquid measurement and garnish measurement.
 * Finish the conversion methods.
 */
public class Measurement {
    //Attributes
    private int amount;
    private int ratioBot;
    private int ratioTop;
    private String measureName;
    private String system;

    public static final String measuresBar[] = { "bar spoon", "bar spoons", "dash", "dashes", "jigger", "jiggers",
            "pony", "ponies" };
    public static final String measuresImperial[] = { "cup", "cups", "gallon", "gallons", "oz", "pint", "pints",
            "quart", "quarts", "tbsp", "tsp" };
    public static final String measuresMetric[] = { "L", "mL" };
    public static final String systems[] = { "Bar Measures", "Imperial", "Metric" };




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
    public void setRatio(int ratioBot, int ratioTop ) throws BadMeasurementException {
        if( ( ratioTop > 0 ) && ( ratioBot > ratioTop ) ) {
            this.ratioBot = ratioBot;
            this.ratioTop = ratioTop;
        } else if ( ( ratioTop == 0 ) && ( ratioBot == 0 ) ) {
            this.ratioBot = 0;
            this.ratioBot = 0;
        } else {
            throw new BadMeasurementException( "The ratio of Measurement is incorrect." );
        }
    }


    /**
     * Allows for the safe mutation of the measureName attribute. Checks to see if the measureName is valid by
     * comparing it to the entries in measures<...>[]</...> list. Throws exception if invalid.
     * @param measureName The name of the measurement that is being counted. Eg. mL.
     * @throws BadMeasurementException Thrown if the measurementName is invalid.
     */
    public void setMeasureName(String measureName ) throws BadMeasurementException {
        //Attributes
        Boolean isFound = false;


        //Body
        if( ! measureName.isEmpty() ) {
            for( int i = 0; i < measuresImperial.length; i++ ) {
                if( ( i < measuresBar.length ) && ( measureName.equals( measuresBar[i] ) ) ) {
                    isFound = true;
                } else if( ( i < measuresMetric.length ) && ( measureName.equals( measuresMetric[i] ) ) ) {
                    isFound = true;
                } else if ( measureName.equals( measuresImperial[i] ) ) {
                    isFound = true;
                }

                if( isFound ) {
                    i = measuresImperial.length;
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




    //Public Functions
    /*
    TODO all of the conversion stuff.
    public String printMeasure() {
        if ((getRatioTop() == 0) || (getRatioBot() == 0)) {
            return getAmount() + " " + getMeasureName();
        } else {
            return toString();
        }
    }


    public void convert( String system1, String system2 ) {
        if( system1.equals( systems[0] ) ) {
            if( system2.equals( systems[1] ) ) {
                barMeasuresToImperial();
            } else if( system2.equals( systems[2] ) ) {
                barMeasuresToMetric();
            }
        } else if( system1.equals( systems[1] ) ) {
            if( system2.equals( systems[0] ) ) {
                imperialToBarMeasures();
            } else if( system2.equals( systems[2] ) ) {
                imperialToMetric();
            }
        } else if( system1.equals( systems[3] ) ) {
            if( system2.equals( systems[0] ) ) {
                metricToBarMeasures();
            } else if( system2.equals( systems[1] ) ) {
                metricToImperial();
            }
        }
    }




    //Private Functions
    private int greatestCommonDenominator( int a, int b ) {
        if( b == 0 ) {
            return a;
        }

        return greatestCommonDenominator( b, a%b );
    }


    private void barMeasuresToImperial() {

    }


    private void barMeasuresToMetric() {
        //Attributes
        double newMetric = 0.0;
        double fraction = 0.0;
        int gcd = 0;
        int rTop = 0;
        int rBot = 0;

        //Body
        if( ( this.getMeasureName() == measuresBar[2] ) || ( this.getMeasureName() == measuresBar[3] ) ) {
            //if dash(es)
            //multiply the amount by its mL equivalent
            newMetric += ( this.getAmount() * 0.6 );
            if( this.getRatioTop() > 0 ) {
                //if the ratio attributes aren't empty, then add these to the newMetric total.
                newMetric += ( this.getRatioTop() / this.getRatioBot() );
                //TODO here
                rTop = this.getRatioTop() * 3;
                rBot = this.getRatioBot() * 5;
                gcd = greatestCommonDenominator( rTop, rBot );
                rTop /= gcd;
                rBot /= gcd;
            }
        } else if( ( this.getMeasureName() == measuresBar[0] ) || ( this.getMeasureName() == measuresBar[1] ) ) {
            //if bar spoon(s)
        }
    }


    private void imperialToBarMeasures() {

    }


    private void imperialToMetric() {

    }


    private void metricToBarMeasures() {

    }


    private void metricToImperial() {

    }
    */



    //Static Functions



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
