package ca.nskoretz;

import ca.nskoretz.BarExceptions.BadIndexException;

import java.util.ArrayList;

/**
 * file     Index.java
 * @author Nicholas Skoretz
 * date     2018-01-03
 *
 * This class defines the Index object. This object holds information that identifies where the original recipe came
 * from, which can be used for metrics, or for example, if more detail is provided in the book then the copied recipe.
 * Contains fields for the name of the book and the authors, as well as the page number and a symbol to represent the
 * book.
 */
public class Index {
    //Attributes
    ArrayList<String> authors;
    int pageNumber;
    String bookTitle;
    String symbol;




    //Constructors

    /**
     * A default constructor for the Index object. This constructor will create an Index with valid 'authors',
     * 'pageNumber', 'bookTitle', and 'symbol' attributes from the passed params. Calls the mutator methods of the
     * object.
     * @param authors An ArrayList of Strings of the authors names of the book that the recipe comes from. Can be
     *                empty.
     * @param pageNumber The page number of the book where the recipe is located. Can be empty.
     * @param bookTitle The title of the book where the recipe is located. Cannot be empty.
     * @param symbol A symbol that represents the book's title in short form, for better readability. Cannot be empty.
     * @throws BadIndexException Thrown if either the bookTitle or symbol is empty.
     */
    public Index( ArrayList<String> authors, int pageNumber, String bookTitle, String symbol )
            throws BadIndexException {
        setAuthors( authors );
        setPageNumber( pageNumber );
        setBookTitle( bookTitle );
        setSymbol( symbol );
    }


    /**
     * A constructor for the index object that accepts only one author instead of an ArrayList. Internally transforms
     * the String into an ArrayList<String> and then calls the mutator methods of the object.
     * @param author The author of the book where the recipe is located. Can be empty.
     * @param pageNumber The page number of the book where the recipe is located. Can be empty.
     * @param bookTitle The title of the book where the recipe is located. Cannot be empty.
     * @param symbol A symbol that represents the book's title in short form, for better readability. Cannot be empty.
     * @throws BadIndexException Thrown if either the bookTitle or symbol is empty.
     */
    public Index( String author, int pageNumber, String bookTitle, String symbol ) throws BadIndexException {
        ArrayList<String> auths = new ArrayList<>( 5 );
        auths.add( author );

        setAuthors( auths );
        setPageNumber( pageNumber );
        setBookTitle( bookTitle );
        setSymbol( symbol );
    }


    /**
     * A constructor for creating an Index without a known author. Calls the default constructor with the
     * passed values except for authors, where a default, empty ArrayList is passed in lieu.
     * @param pageNumber The page number of the book where the recipe is located. Can be empty.
     * @param bookTitle The title of the book where the recipe is located. Cannot be empty.
     * @param symbol A symbol that represents the book's title in short form, for better readability. Cannot be empty.
     * @throws BadIndexException Thrown if either the bookTitle or symbol is empty.
     */
    public Index( int pageNumber, String bookTitle, String symbol ) throws BadIndexException {
        this( new ArrayList<String>( 2 ), pageNumber, bookTitle, symbol );
    }


    /**
     * A constructor for creating an Index without a known author or page number. Calls the default constructor with
     * the passed values except for authors and page number, where a default, empty ArrayList and '-1' is passed in
     * lieu.
     * @param bookTitle The title of the book where the recipe is located. Cannot be empty.
     * @param symbol A symbol that represents the book's title in short form, for better readability. Cannot be empty.
     * @throws BadIndexException Thrown if either the bookTitle or symbol is empty.
     */
    public Index( String bookTitle, String symbol ) throws BadIndexException {
        this( new ArrayList<String>( 2 ), -1, bookTitle, symbol );
    }


    /**
     * A copy constructor for creating a copy of the passed Index.
     * @param toCopy The passed category to be copied.
     * @throws BadIndexException Thrown if the passed Index is invalid.
     */
    public Index( Index toCopy ) throws BadIndexException {
        if( toCopy != null ) {
            setAuthors( toCopy.getAuthors() );
            setPageNumber( toCopy.getPageNumber() );
            setBookTitle( toCopy.getBookTitle() );
            setSymbol( toCopy.getSymbol() );
        } else {
            throw new BadIndexException( "The Index you were trying to copy is incorrect." );
        }
    }




    //Mutators

    /**
     * Allows for the safe mutation of the authors attribute.
     * @param authors The authors of the index book.
     */
    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }


    /**
     * Allows for the safe mutation of the pageNumber attribute.
     * @param pageNumber The page number on which the recipe is located.
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }


    /**
     * Allows for the safe mutation of the bookTitle attribute.
     * @param bookTitle The title of the book in which the recipe is located.
     * @throws BadIndexException Thrown if the title is empty.
     */
    public void setBookTitle(String bookTitle) throws BadIndexException {
        if( bookTitle.isEmpty() ) {
            throw new BadIndexException();
        } else {
            this.bookTitle = bookTitle;
        }
    }


    /**
     * Allows for the safe mutation of the symbol attribute.
     * @param symbol The symbol representation of the bookTitle.
     * @throws BadIndexException Thrown if the title is empty.
     */
    public void setSymbol(String symbol) throws BadIndexException {
        if( symbol.isEmpty() ) {
            throw new BadIndexException();
        } else {
            this.symbol = symbol;
        }
    }




    //Accessors

    /**
     * Allows access to the authors attribute.
     * @return ArrayList<String></String>
     */
    public ArrayList<String> getAuthors() {
        return authors;
    }


    /**
     * Allows access to the pageNumber attribute.
     * @return int
     */
    public int getPageNumber() {
        return pageNumber;
    }


    /**
     * Allows access to the bookTitle attribute.
     * @return String
     */
    public String getBookTitle() {
        return bookTitle;
    }


    /**
     * Allows access to the symbol attribute.
     * @return String
     */
    public String getSymbol() {
        return symbol;
    }




    //equals

    /**
     * Provides a way to compare Index objects. Overrides the parent equals().
     * @param o The object with which to compare.
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

        Index ot = ( Index ) o;
        if( ( this.getBookTitle().equals( ot.getBookTitle() ) )
                && ( this.getSymbol().equals( ot.getSymbol() ) )
                && ( this.getPageNumber() == ot.getPageNumber() )
                && ( this.getAuthors().equals( ot.getAuthors() ) ) ) {
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
        return this.getSymbol() + " " + this.getPageNumber() + " : " + this.getBookTitle();
    }
}
