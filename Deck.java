///////////////////////////////////////////////////////////
// Alan Chu 
// CS 110, Assignment 10 - WarCardGame
// Card class - object that will represent a Card
///////////////////////////////////////////////////////////


public class Deck extends Pile{
	private static final int SUIT_END = 4;
	private static final int SUIT_START = 0;
	private static final int RANK_END = 14;
	private static final int RANK_START = 1;
	private String[] card_jpg = {"acec.jpg", "2c.jpg", "3c.jpg", "4c.jpg", "5c.jpg", "6c.jpg", "7c.jpg", "8c.jpg", "9c.jpg", "10c.jpg", "jackc.jpg", "queenc.jpg", "kingc.jpg",
			"aced.jpg", "2d.jpg", "3d.jpg", "4d.jpg", "5d.jpg", "6d.jpg", "7d.jpg", "8d.jpg", "9d.jpg", "10d.jpg", "jackd.jpg", "queend.jpg", "kingd.jpg", "aceh.jpg", "2h.jpg", 
			"3h.jpg", "4h.jpg", "5h.jpg", "6h.jpg", "7h.jpg", "8h.jpg", "8h.jpg", "9h.jpg", "10h.jpg", "jackh.jpg", "queenh.jpg", "kingh.jpg", "aces.jpg", "2s.jpg", "3s.jpg", "4s.jpg",
			"5s.jpg", "6s.jpg", "7s.jpg", "8s.jpg", "9s.jpg", "10s.jpg", "jacks.jpg", "queens.jpg", "kings.jpg"};
	//private Pile deckpile;
	
	/*
	 * constructor - makes a pile of 52 cards
	 */
	public Deck(){
		// deckpile = new Pile(); // dont need anymore, because inheritance, will call super constructor and make arraylist
		Card nc;
		int count = 0;
		for (int suit = SUIT_START; suit < SUIT_END; suit++)
		{
			for (int rank = RANK_START; rank< RANK_END; rank++, count++)
			{
				nc = new Card(suit, rank, card_jpg[count]);
				//System.out.println(card_jpg[count]);  //COMMENT OUT
				super.addCard(nc);
			}
		}
		//System.out.println("Deck constructor");
	}
	
	/*
	 * toString method
	 * @return String containing all the details of each card object
	 */
	public String toString(){
		String str = "";
		int size = super.size();
		for (int index = 0; index < size; index++) {
			Card nc = super.getCard(index);
			str+= (nc.toString() + ", ");
		}
		return str;
	}
	
	
	public static void main(String[] args)
	{
		Deck d = new Deck();
		//System.out.println(d);
		System.out.println(d.getCard(0).getImageName());
		//System.out.println("Shitt");
//		d.shuffle();
//		System.out.println(d);
	}
}
