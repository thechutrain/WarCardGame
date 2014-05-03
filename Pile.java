///////////////////////////////////////////////////////////
// Alan Chu 
// CS 110, Assignment 10 - WarCardGame
// Pile class - for holding multiple Card objects
///////////////////////////////////////////////////////////

import java.util.ArrayList; // for private field of cardPile
import java.util.Collections;

public class Pile {
	// private fields
	private ArrayList<Card> cardPile;
	private boolean empty;
	private int size; 
	//private Card[] preShuffle;
	
	/*
	 * Constructor
	 */
	
	public Pile() {
		cardPile = new ArrayList<Card>(52);
		empty = true;
		size = 0;
	}
	
	/*
	 * addCard method
	 * @param card is a card object that will be put into the pile
	 */
	public void addCard(Card c) {
		cardPile.add(c);	
		size +=1; //prevents private field from getting stale.
	}
	/*
	 * size method
	 *@return int the size of the cardPile
	 */
	public int size() {
		size =  cardPile.size();
		return size;
	}
	
	/*
	 * getCard method .... throws Exception, write exception                                                                                                                                      
	 */
	public Card getCard(int i) throws ArrayListOutOfBoundsException{
		Card nc;
		if (i >= cardPile.size()){
			throw new ArrayListOutOfBoundsException();
			}
		else{
			nc = cardPile.get(i);
		}
		
		return nc;
	}
	
	/*
	 * remove - method
	 * removes the first element only
	 */
	public void remove(){ //throws EmptyArrayListException {
		cardPile.remove(0);
	}
	
	/*
	 * isEmpty method
	 * @return boolean of whether the pile is empty or not
	 */
	public boolean isEmpty() {
		if (cardPile.size() == 0)
			empty = true;
		else
			empty = false;
		return empty;
	}
	
	/*
	 * shuffle method
	 */
	public void shuffle(){
//		//determine the size of arraylist;
//		size = cardPile.size();
//		preShuffle = new Card[size];
//		
//		//create an array from Array list
		Collections.shuffle(cardPile);
	}

	/*
	 * toString method
	 * @return a string of all card objects in pile
	 */
	public String toString() {
		String str = "";
		size = cardPile.size();
		//for loop to read each card object in array
		for (int index = 0; index < size; index++)
			{
			str+=cardPile.get(index).toString();
			str+= ", \n";
			}
		str = str.substring(0, str.length() - 3); // take off the last ",\n"
		return str;
	}

	
//MAIN TEST
	public static void main(String[] args)
	{
		//Create card object
		Card c = new Card(0,1, "jackd.jpg");	 //Ace of Spades
		Card c2 = new Card(2,2,"jackd.jpg" );
		Card c3 = new Card(3,2, "jackd.jpg");
		Pile p = new Pile();
		p.addCard(c);
		p.addCard(c2);
		p.addCard(c3);
		//System.out.println(p.size());
		System.out.println(p);	
		p.shuffle();
		//After shuffle
		System.out.println(p);
//		try{
//		Card gotcard = p.getCard(2);
//		System.out.println(gotcard);
//		}
//		catch(ArrayListOutOfBoundsException e)
//		{
//			System.out.println(e);
//		}
	}
}

	

