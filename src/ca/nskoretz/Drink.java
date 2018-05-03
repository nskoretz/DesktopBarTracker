package ca.nskoretz;

import java.util.ArrayList;

import ca.nskoretz.BarExceptions.BadCategoryException;
import ca.nskoretz.BarExceptions.BadDrinkException;
import ca.nskoretz.BarExceptions.BadIngredientException;

public class Drink {
    //Attributes
    ArrayList<Ingredient> ingredients;
    ArrayList<String> prepSteps;
    Boolean isAlcoholic;
    Category categories;
    Index index;
    Ingredient baseAlc;
    int serves;
    String name;


    //Constructors
    public Drink( String name, int serves, Category categ, ArrayList<Ingredient> ingredients,
                  ArrayList<String> prepSteps ) throws BadDrinkException {
        setName( name );
        setServingSize( serves );
        setCategory( categ );
        setIngredients( ingredients );
        setPrepSteps( prepSteps );
    }

    public Drink( String name, int serves, Category categ, ArrayList<Ingredient> ingredients,
                  ArrayList<String> prepSteps, Boolean isAlcoholic ) throws BadDrinkException {
        this( name, serves, categ, ingredients, prepSteps);
        setAlcoholic( isAlcoholic );
    }

    public Drink( String name, int serves, Category categ, ArrayList<Ingredient> ingredients,
                  ArrayList<String> prepSteps, Boolean isAlcoholic, Ingredient baseAlc ) throws BadDrinkException {
        this( name, serves, categ, ingredients, prepSteps, isAlcoholic);
        setBaseAlc( baseAlc );
    }

    public Drink( String name, int serves, Category categ, ArrayList<Ingredient> ingredients,
                  ArrayList<String> prepSteps, Boolean isAlcoholic, Ingredient baseAlc,
                  Index index ) throws BadDrinkException {
        this( name, serves, categ, ingredients, prepSteps, isAlcoholic, baseAlc);
        setIndex( index );
    }

    public Drink( Drink toCopy ) throws BadDrinkException {
        if( toCopy != null ) {
            setName( toCopy.name );
            setServingSize( toCopy.serves );

            try {
                this.categories = new Category(toCopy.categories);
            } catch( BadCategoryException e ) {
                throw new BadDrinkException( "Exception while trying to copy the Category of the Drink.::" +
                        e.getMessage() );
            }

            ArrayList<Ingredient> newIngredients = new ArrayList<>( 5 );
            for( Ingredient ing : ingredients ) {
                try {
                    newIngredients.add( new Ingredient( ing ) );
                } catch( BadIngredientException e ) {
                    throw new BadDrinkException( "Exception while trying to copy an Ingredient in the Drink.::" +
                            e.getMessage() );
                }
            }
            setIngredients( newIngredients );

            ArrayList<String> newSteps = new ArrayList<>( 5 );
            for( String step : prepSteps ) {
                newSteps.add( step );
            }
            setPrepSteps( newSteps );

            //setAlcoholic( toCopy.isAlcoholic );
            //TODO the rest of these

        }
    }


    //Mutators
    public void setName(String name) throws BadDrinkException {
        if( ! name.isEmpty() ) {
            this.name = name;
        } else {
            throw new BadDrinkException( "The name attribute of Drink cannot be empty" );
        }
    }

    public void setServingSize( int serves ) throws BadDrinkException {
        if( serves > 0 ) {
            this.serves = serves;
        } else {
            throw new BadDrinkException( "The serving size of a Drink cannot be 0 or negative" );
        }
    }

    public void setCategory( Category categ ) {
        this.categories = categ;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) throws BadDrinkException {
        if( ingredients.isEmpty() ) {
            throw new BadDrinkException( "A drink must have ingredients" );
        } else {
            this.ingredients = ingredients;
        }
    }

    public void setPrepSteps( ArrayList<String> prepSteps ) throws BadDrinkException {
        if ( prepSteps.isEmpty() ) {
            throw new BadDrinkException( "A drink cannot have no preparation steps" );
        } else {
            this.prepSteps = prepSteps;
        }
    }

    public void setAlcoholic(Boolean alcoholic) {
        isAlcoholic = alcoholic;
    }

    public void setBaseAlc(Ingredient baseAlc) {
        this.baseAlc = baseAlc;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    //Accessors
}
