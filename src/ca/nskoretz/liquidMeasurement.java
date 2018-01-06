package ca.nskoretz;


import ca.nskoretz.BarExceptions.BadMeasurementException;

/**
 * file     liquidMeasurement.java
 * @author  Nicholas Skoretz
 * date     2018-01-06
 *
 * This class defines the liquidMeasurement object. This class is a child of the abstract Measurement class, it holds
 * data for liquid Ingredients.
 *
 * TODO list
 * need to incorporate the system attribute in the constructors.
 * Incorporate the idea that this object may measure Garnishes too. Or we make a common parent class for
 *      liquid measurement and garnish measurement.
 * Finish the conversion methods.
 */
public class liquidMeasurement extends Measurement {
    //Constructors
    /**
     * The main constructor for the liquidMeasurement object. Calls the parent constructor with the passed values to
     * create a new liquidMeasurement.
     * @param amount The numerical amount of the measurement.
     * @param ratioTop The top of the ratio.
     * @param ratioBot The bottom of the ratio.
     * @param measureName The name of the measurement that is being counted. Eg. mL.
     * @throws BadMeasurementException Thrown if any of the passed params are invalid.
     */
    public liquidMeasurement(int amount, int ratioTop, int ratioBot, String measureName) throws BadMeasurementException {
        super(amount, ratioTop, ratioBot, measureName);
    }


    /**
     * A no-arg constructor for the liquidMeasurement object. Calls the main constructor with default values.
     * @throws BadMeasurementException Thrown if any of the passed params are invalid.
     */
    public liquidMeasurement() throws BadMeasurementException {
        this( 1, 1, 2, "oz" );
    }


    /**
     * A copy constructor for the liquidMeasurement type. Will create a deep copy of the passed Measurement.
     * @param toCopy The measurement to copy.
     * @throws BadMeasurementException Thrown if any of the passed params are invalid.
     */
    public liquidMeasurement( liquidMeasurement toCopy) throws BadMeasurementException {
        super(toCopy);
    }




    //Mutators
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




    //equals
    /**
     * Provides a way to compare liquidMeasurement objects. Calls the parent equals().
     * @param o The Measurement with which to be compared.
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }




    //toString
    /**
     * Returns most attributes in a readable String format. Calls the parent toString().
     * @return String
     */
    @Override
    public String toString() {
        return super.toString();
    }
}

