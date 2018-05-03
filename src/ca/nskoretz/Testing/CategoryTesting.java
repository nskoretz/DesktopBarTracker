package ca.nskoretz;

import ca.nskoretz.BarExceptions.BadCategoryException;

public class CategoryTesting {

    public static void main( String args[] ) {
        System.out.printf( "Testing for the Category class.\n" );

        //Testing constructors
        //No argument construtor
        try {
            Category noarg = new Category();
            System.out.print( noarg.toString() + '\n');
        } catch (BadCategoryException e) {
            System.out.print( e.getMessage() );
        }

        //All arguments, correct
        try {
            Category withArgs = new Category( "Beer", "Heavy", "stir" );
            System.out.print( withArgs.toString() + '\n' );
        } catch( BadCategoryException e ) {
            System.out.print( e.getMessage() );
        }

        try {
            Category badArgs = new Category( "Beer", "Heavt", "stir");
            System.out.printf( badArgs.toString() );
        } catch( BadCategoryException e ) {
            System.out.printf( e.getMessage() );
        }
    }
}
