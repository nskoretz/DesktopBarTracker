package ca.nskoretz;


import ca.nskoretz.BarExceptions.BadCategoryException;


/**
 * file     Category.java
 * @author Nicholas Skoretz
 * date     2018-01-03
 *
 * This class defines the Category object. This object holds the type of glass that the drink uses, the type that the
 * drink falls into, and the method of preparation used to prepare the drink.
 */
public class Category {
    //Attributes
    private String glass;
    private String prepMethod;
    private String type;

    public static final String drinkTypes[] = { "Heavy", "Long", "Shooter" };
    public static final String glassTypes[] = { "Beer", "Champagne Flute", "Collins" , "Coupe", "Coupette", "Hurricane",
            "Martini", "Old Fashioned", "Shot", "Sling", "Snifter" };
    public static final String prepMethods[] = { "blend", "shake", "stir", "straight" };




    //Constructors

    /**
     * The main constructor for the Category object. This constructor will create an instance with valid 'glass',
     * 'prepMethod', and 'type' attributes. Calls the mutator methods of the object with the passed params.
     * @param glass The type of glass that the drink will be using.
     * @param type The type of the drink.
     * @param prep The method of preparation for the drink.
     * @throws BadCategoryException Thrown if any of the Strings are empty or invalid.
     */
    public Category( String glass, String type, String prep ) throws BadCategoryException {
        setGlass( glass );
        setType( type );
        setPrepMethod( prep );
    }


    /**
     * A no-arg constructor for the Category object. This constructor will create an instance with valid but default
     * values for the three attributes of the Category object.
     * @throws BadCategoryException Throws if any of the Strings are empty or invalid.
     */
    public Category() throws BadCategoryException {
        this( "Shot", "Shooter", "straight" );
    }


    /**
     * A copy copy constructor for the Category object. Will provide a deep copy of the passed Category object.
     * @param toCopy The passed Category to copy.
     * @throws BadCategoryException Thrown if any of the Strings are empty or invalid.
     */
    public Category( Category toCopy ) throws BadCategoryException {
        if( toCopy != null ) {
            setGlass( toCopy.getGlass() );
            setType( toCopy.getType() );
            setPrepMethod( toCopy.getPrepMethod() );
        } else {
            throw new BadCategoryException( "The Category you are trying to copy is null." );
        }
    }




    //Mutators

    /**
     * Allows for the safe mutation of the glass attribute of the Category instance. Checks to see if the passed String
     * is valid by comparing it to the values in glassTypes[], throws a BadCategoryException if invalid.
     * @param glass The type of glass that the drink will be using.
     * @throws BadCategoryException Thrown if the passed String is empty or invalid.
     */
    public void setGlass( String glass ) throws BadCategoryException {
        //Attributes
        Boolean isFound = false;


        //Body
        if( ! glass.isEmpty() ) {
            for( int i = 0; i < glassTypes.length; i++ ) {
                if( glass.equals( glassTypes[i] ) ) {
                    isFound = true;
                    i = glassTypes.length;
                }
            }
        }

        if( isFound ) {
            this.glass = glass;
        } else {
            throw new BadCategoryException( "The 'glass' attribute of the Category is incorrect." );
        }
    }


    /**
     * Allows for the safe mutation of the prepMethod attribute of the Category instance. Checks to see if the passed
     * String is valid by comparing it to the values in prepMethods[], throws a BadCategoryException if invalid.
     * @param prepMethod The method of preparation of the drink.
     * @throws BadCategoryException Thrown if the passed String is empty or invalid.
     */
    public void setPrepMethod( String prepMethod ) throws BadCategoryException {
        //Attributes
        Boolean isFound = false;


        //Body
        if( ! prepMethod.isEmpty() ) {
            for( int i = 0; i < prepMethods.length; i++ ) {
                if( prepMethod.equals( prepMethods[i] ) ) {
                    isFound = true;
                    i = prepMethods.length;
                }
            }
        }

        if( isFound ) {
            this.prepMethod = prepMethod;
        } else {
            throw new BadCategoryException( "The 'prepMethod' attribute of the Category is incorrect." );
        }
    }


    /**
     * Allows for the safe mutation of the type attribute of the Category instance. Checks to see if the passed String
     * is valid by comparing it to the values in drinkTypes[], throws a BadCategoryException if invalid.
     * @param type The type of the drink.
     * @throws BadCategoryException Thrown if the passed String is empty or invalid.
     */
    public void setType( String type ) throws BadCategoryException {
        //Attributes
        Boolean isFound = false;


        //Body
        if( ! type.isEmpty() ) {
            for( int i = 0; i < drinkTypes.length; i++ ) {
                if( type.equals( drinkTypes[i] ) ) {
                    isFound = true;
                    i = drinkTypes.length;
                }
            }
        }

        if( isFound ) {
            this.type = type;
        } else {
            throw new BadCategoryException( "The 'type' attribute of the Category is incorrect." );
        }
    }




    //Accessors

    /**
     * Allows access to the glass attribute.
     * @return The String value of the glass attribute.
     */
    public String getGlass() {
        return glass;
    }


    /**
     * Allows access to the prepMethod attribute.
     * @return The String value of the prepMethod attribute.
     */
    public String getPrepMethod() {
        return prepMethod;
    }


    /**
     * Allows access to the type attribute.
     * @return The String value of the type attribute.
     */
    public String getType() {
        return type;
    }




    //equals

    /**
     * Provides a way to compare Category objects. Overrides the parent equals().
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

        Category ot = ( Category ) o;
        if( this.getGlass().equals( ot.getGlass() ) && this.getPrepMethod().equals( ot.getPrepMethod() ) &&
                this.getType().equals( ot.getType() ) ) {
            return true;
        } else {
            return false;
        }
    }




    //toString

    /**
     * Returns all attributes in a readable String format. Overrides the parent toString().
     * @return String
     */
    @Override
    public String toString() {
        return "Category[" + getGlass() + ":" + getPrepMethod() + ":" + getType() + "]";
    }
} //class
