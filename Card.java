///////////////////////////////////////////////////////////
// Alan Chu 
// CS 110, Assignment 10 - WarCardGame
// Card class - object that will represent a Card
///////////////////////////////////////////////////////////

import javax.swing.ImageIcon;

public class Card {

	//static array of strings of .jpg images
	//private final static String[] images = ["aces.jpg", 
	//Class Final Variables!
	public final static int SPADES = 3,
							HEARTS = 2,
							DIAMONDS = 1,
							CLUBS = 0;
	
	public final static int ACE = 1,
							JACK = 11,
							QUEEN = 12,
							KING =13;
	//Instance Variables ... private
	private int suit;
	private int rank;
	private String image_name = ""; 
	/*
	 * Constructor
	 */
	public Card(int suit, int rank, String i) {
	this.suit = suit;
	this.rank = rank;
	this.image_name = i;
	}
	
	/*
	 * copy constructor
	 */
	public Card(Card c) {
		setSuit(c.getSuit());
		setRank(c.getRank());
		setImage(c.getImage());
	}
	
	private void setImage(String image) {
		image_name = image;
		// TODO Auto-generated method stub	
	}

	private String getImage() {
		// TODO Auto-generated method stub
		return image_name;
	}

	/*
	 * toString method
	 */
	public String toString() {
		String str = "";
		//Get rank
		if (rank == ACE)
			str+="Ace";
		else if (rank == JACK)
			str+="Jack";
		else if (rank == QUEEN)
			str+="Queen"; // Why can't I have? str.append("Queen");
		else if (rank == KING)
			str+="King";
		else{
			str+= rank;
		}
		//Get the suit
		if (suit == SPADES)
			{
			str+=(" of Spades");
			}
		else if (suit == HEARTS)
			{
			str+=(" of Hearts");
			}
		else if (suit == DIAMONDS)
			{
			str += (" of Diamonds");
			}
		else
			{
			str += (" of Clubs");
			}
		return str;
	}
	
	/*
	 * Setters & Getters for Suit
	 */
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	
	/*
	 * Setters & Getters for Rank
	 */
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	/*
	 * getImageName
	 * @return String of the image name
	 */
	public String getImageName(){
		return image_name;
	}
	
//MAIN TEST	
public static void main(String[] args)
	{
	Card c = new Card(0,1, "jackd.jpg");	 //Ace of Spades
	System.out.println(c.getImageName());
	}

	
	
}
