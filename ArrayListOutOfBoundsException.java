///////////////////////////////////////////////////////////
// Alan Chu 
// CS 110, Assignment 10 - WarCardGame
// ArrayListOUtOfBoundsException - exception that was created
///////////////////////////////////////////////////////////


public class ArrayListOutOfBoundsException extends IndexOutOfBoundsException{
	/*
	 * Constructor - to create a generic error message
	 */
	public ArrayListOutOfBoundsException()
	{
		super("Error!! Index requested for ArrayList was out of bounds");
	}

}
