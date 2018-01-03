package ca.nskoretz;


import ca.nskoretz.BarExceptions.BadCategoryException;


/**
 * Category.java
 * Nicholas Skoretz
 * 2017-12-10
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
    public Category( String glass, String type, String prep ) throws BadCategoryException {
        setGlass( glass );
        setType( type );
        setPrepMethod( prep );
    }


    public Category() throws BadCategoryException {
        this( "Shot", "Shooter", "straight" );
    }


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
    public String getGlass() {
        return glass;
    }


    public String getPrepMethod() {
        return prepMethod;
    }


    public String getType() {
        return type;
    }




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

        Category ot = ( Category ) o;
        if( this.getGlass().equals( ot.getGlass() ) && this.getPrepMethod().equals( ot.getPrepMethod() ) &&
                this.getType().equals( ot.getType() ) ) {
            return true;
        } else {
            return false;
        }
    }




    //toString
    @Override
    public String toString() {
        return "Category[" + getGlass() + ":" + getPrepMethod() + ":" + getType() + "]";
    }
} //class
