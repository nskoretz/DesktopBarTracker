package ca.nskoretz;


import ca.nskoretz.BarExceptions.BadMeasurementException;


/**
 * Measurement.java
 * Nicholas Skoretz
 * 2017-12-10
 *
 * This class defines the Measurement object. This object holds the amount in whole numbers and fractions as well as
 * the measure and the system, whether Bar Measures, Imperial, or Metric.
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
    public Measurement( int amount, int ratioTop, int ratioBot, String measureName ) throws
    BadMeasurementException {
        setAmount( amount );
        setRatio( ratioBot, ratioTop );
        setMeasureName( measureName );
    }


    public Measurement() throws BadMeasurementException {
        this( 1, 1, 2, "oz" );
    }


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
    public void setAmount(int amount) throws BadMeasurementException {
        if( amount > 0 ) {
            this.amount = amount;
        } else {
            throw new BadMeasurementException( "The amount of Measument must be greater then 0." );
        }
    }


    public void setRatio(int ratioBot, int ratioTop ) throws BadMeasurementException {
        if( ( ratioTop > 0 ) && ( ratioBot > ratioTop ) ) {
            this.ratioBot = ratioBot;
            this.ratioTop = ratioTop;
        } else {
            throw new BadMeasurementException( "The ratio of Measurement is incorrect." );
        }
    }


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
    public int getAmount() {
        return amount;
    }


    public int getRatioTop() {
        return ratioTop;
    }


    public int getRatioBot() {
        return ratioBot;
    }


    public String getMeasureName() {
        return measureName;
    }


    public String getSystem() {
        return system;
    }




    //Public Functions
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




    //Static Functions



    //equals
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
    @Override
    public String toString() {
        return getAmount() + " " + getRatioTop() + "/" + getRatioBot() + " " + getMeasureName();
    }
} //class
