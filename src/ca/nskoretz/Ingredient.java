package ca.nskoretz;


import ca.nskoretz.BarExceptions.BadIngredientException;

/**
 * file     Ingredient.java
 * @author Nicholas Skoretz
 * date     2018-01-04
 *
 * This class will define the ingredients of the drink. It will contain a name for the ingredient, a Measurement
 * object, and whether it is a garnish or not.
 */
public class Ingredient {
    //Attributes
    private boolean isGarnish;
    private Measurement measure;
    private String name;




    //Constructors

    /**
     * A default constructor for the Ingredient object. This constructor will create an Ingredient with valid
     * attributes from the passed params. Calls the mutator methods of the object.
     * @param isGarnish Whether the Ingredient is a garnish or not.
     * @param measure The measurement of the ingredient. Eg. 3 oz.
     * @param name The name of the Ingredient.
     * @throws BadIngredientException Thrown if the name field is empty, or the measure is null.
     */
    public Ingredient( boolean isGarnish, Measurement measure, String name ) throws BadIngredientException {
        setGarnish( isGarnish );
        setMeasure( measure );
        setName( name );
    }




    //Mutators

    /**
     * Allows for the safe mutation of the isGarnish attribute. Set to true if the Ingredient is a garnish, false
     * otherwise.
     * @param garnish Whether the Ingredient is a garnish or not.
     */
    public void setGarnish( boolean garnish ) {
        isGarnish = garnish;
    }


    /**
     * Allows for the safe mutation of the measure attribute.
     * @param measure The measurement of the ingredient. Eg. 3 oz.
     * @throws BadIngredientException Thrown if the passed measure is null.
     */
    public void setMeasure( Measurement measure ) throws BadIngredientException {
        if( measure != null ) {
            this.measure = measure;
        } else {
            throw new BadIngredientException( "The measure attribute of the Ingredient is incorrect." );
        }
    }


    /**
     * Allows for the safe mutation of the name attribute.
     * @param name The name of the Ingredient.
     * @throws BadIngredientException Thrown if the passed name is empty.
     */
    public void setName( String name ) throws BadIngredientException {
        if( name.isEmpty() ) {
            throw new BadIngredientException( "The name attribute of the Ingredient is incorrect." );
        } else {
            this.name = name;
        }
    }




    //Accessors

    /**
     * Allows access to the isGarnish attribute.
     * @return boolean
     */
    public boolean isGarnish() {
        return isGarnish;
    }


    /**
     * Allows access to the measure attribute.
     * @return Measurement
     */
    public Measurement getMeasure() {
        return measure;
    }


    /**
     * Allows access to the name attribute.
     * @return String
     */
    public String getName() {
        return name;
    }




    //equals

    /**
     * Provides a way to compare Ingredient objects. Overrides the parent equals().
     * @param o The object with which to be compared.
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

        Ingredient ot = ( Ingredient ) o;
        if ( ( this.isGarnish == ot.isGarnish ) &&
                ( this.getMeasure().equals( ot.getMeasure() ) ) &&
                ( this.getName().equals( ot.getName() ) ) ) {
            return true;
        } else {
            return false;
        }
    }




    //toString

    /**
     * Returns useful attributes in a readable format. Overrides the parent toString().
     * @return String
     */
    @Override
    public String toString() {
        String ending = ".";

        if( isGarnish() ) {
            ending = " (Garnish).";
        }

        return getMeasure() + " " + getName() + ending;
    }
}
