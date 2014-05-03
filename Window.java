///////////////////////////////////////////////////////////
// Alan Chu 
// CS 110, Assignment 10 - GUI
// 
///////////////////////////////////////////////////////////


import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.event.*;

public class Window extends JFrame{
	//private members for actual Card function
	private Deck deck;
	private Pile player_1, player_2, holdingPile;
	private Card nc, card_1, card_2;
	//private members for GUI
	final int WINDOW_WIDTH = 850;
	final int WINDOW_HEIGHT = 550;
	private JLabel welcomeBanner;
	private JPanel panel;
	private JButton drawButton;
	private ImageIcon card1_image, card2_image;
	private String backImage = "back.jpg";
	///Private members ... still working with images
	private JLabel card1_label, card2_label;
	private int card1_num, card2_num;
	private String str;
	
	public Window()
	{
	/// Initialize GAME //////
		//OPENING MESSAGE:
				System.out.println("Preparing the card game war ...");
				//create a deck
				deck = new Deck();
				//shuffle the deck;
				deck.shuffle();
				//initialize new piles for both player_1 & _2
				player_1 = new Pile();
				player_2 = new Pile();
				//INTERMEDIATE message
				System.out.println("Dealing the shuffled deck ...");
				//get the first half of the cards and give it to player_1
				for (int index = 0; index < 26; index++) // CORRECT NUMBERS WITH VARIABLES LATER
				{
					nc = deck.getCard(index);
					player_1.addCard(nc);
				}
				//give the second half of cards to player_2
				for (int index = 26; index < 52; index ++)
				{
					nc = deck.getCard(index);
					player_2.addCard(nc);
				}
		
		
	/// Make the GUI ////
		//set title
		setTitle("A Simple window");
		
		//set size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//specify default
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//build panel
		buildPanel();
		
		//add panel
		add(panel);
		
		//display window
		setVisible(true);
	}
	
	/*
	 * buildPanel method
	 */
	private void buildPanel()
	{
		//create a label to display instructions
		welcomeBanner = new JLabel("Welcome to the card game war! Press <Draw Card> to play!");
		card1_num = player_1.size();
		card2_num = player_2.size();
		card1_image = new ImageIcon(backImage);
		card2_image = new ImageIcon(backImage);
		str = "Number of cards for player 1: " + card1_num;
		card1_label = new JLabel(str, card1_image,JLabel.TRAILING);
		card2_label = new JLabel("Number of cards for player 2: " + card2_num, card2_image, JLabel.TRAILING);
		drawButton = new JButton("Draw Card");
		drawButton.addActionListener(new DrawCardActionListener());
		
		//create a panel & add labels/button to is
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(welcomeBanner, BorderLayout.NORTH);
		panel.add(drawButton, BorderLayout.SOUTH);
		panel.add(card1_label, BorderLayout.WEST);
		panel.add(card2_label, BorderLayout.EAST);
	}

/////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * private class for CalcButtonListener
	 */
	private class DrawCardActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			//get the first card from player one and two & delete from pile
			card_1 = player_1.getCard(0);
			player_1.remove();
			card_2 = player_2.getCard(0);
			player_2.remove();
			holdingPile = new Pile();
			holdingPile.addCard(card_1);
			holdingPile.addCard(card_2);
			if (card_1.getRank() > card_2.getRank()){
				//add cards to player_1
				int size = holdingPile.size();
				for (int index = 0; index < size; index++){
					player_1.addCard(holdingPile.getCard(index));
					}
				
				}// close if statement
				else if (card_1.getRank() < card_2.getRank()){
					int size = holdingPile.size();
					for (int index = 0; index < size; index++){
						player_2.addCard(holdingPile.getCard(index));
					}
				}
				else {
					System.out.println("War!!");
					for (int index = 0; index < 3; index++){
						//get card for player 1 & add to pile
						//System.out.println("Player 1 card #" + index + " : "+ player_1.getCard(index).toString());
						holdingPile.addCard(player_1.getCard(index));
						player_1.remove();
						//System.out.println("Player 2 card #" + index + " : "+ player_2.getCard(index).toString());
						holdingPile.addCard(player_2.getCard(index));
						player_2.remove();
						}
					
					}	
			
			
			
			//Change the CARDS	
			welcomeBanner = new JLabel("Welcome to the card game war! Press <Draw Card> to play!");
			card1_image = new ImageIcon(card_1.getImageName());
			card2_image = new ImageIcon(card_2.getImageName());
			card1_num = player_1.size();
			card2_num = player_2.size();
			
			card1_label = new JLabel("Number of cards for player 1: " + card1_num, card1_image, JLabel.TRAILING);
			card2_label = new JLabel("Number of cards for player 2: " + card2_num, card2_image, JLabel.TRAILING);
			drawButton = new JButton("Draw Card");
			//drawButton.addActionListener(new DrawCardActionListener());
			//create a panel & add labels/button to is
			panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.add(welcomeBanner, BorderLayout.NORTH);
			panel.add(drawButton, BorderLayout.SOUTH);
			panel.add(card1_label, BorderLayout.WEST);
			panel.add(card2_label, BorderLayout.EAST);
			//add panel
			add(panel);
			//display window
			setVisible(true);
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * compareCards - method
	 * @param c1 is card1
	 * @paramc2 is card2
	 */
	private void compareCards(){
		//get the first card from player one and two & delete from pile
		card_1 = player_1.getCard(0);
		player_1.remove();
		card_2 = player_2.getCard(0);
		player_2.remove();
		//add cards to pile!
		//holdingPile = new Pile();
		holdingPile.addCard(card_1);
		holdingPile.addCard(card_2);
		//CHECK
		//System.out.println("Holding pile # of cards: " + holdingPile.size());
		//System.out.println("Holdingpile cards: " + holdingPile.toString());
		//if, else-if, and else statements
		if (card_1.getRank() > card_2.getRank()){ //if player 1 wins!
//			System.out.println("Player 1 card: " + card_1.toString());
//			System.out.println("Player 2 card: " + card_2.toString());
//			System.out.println(".......... Player 1 wins!!");
			//add cards to player_1
			int size = holdingPile.size();
			for (int index = 0; index < size; index++){
				player_1.addCard(holdingPile.getCard(index));
			}
			
			
			//holdingPile = new Pile(); // reinitiate the pile
			}// close if statement
			else if (card_1.getRank() < card_2.getRank()){
//				System.out.println("Player 1 card: " + card_1.toString());
//				System.out.println("Player 2 card: " + card_2.toString());
//				System.out.println("........ Player 2 wins!!");
				//add cards to player_2
				int size = holdingPile.size();
				for (int index = 0; index < size; index++){
					player_2.addCard(holdingPile.getCard(index));
				}
			}
			else {
//				System.out.println("Player 1 card: " + card_1.toString());
//				System.out.println("Player 2 card: " + card_2.toString());
//				System.out.println("TIED!");
//				System.out.println(".... this means war!");
				//call tied function
				this.tied();
			}	
		}	

	/*
	 * tied method
	 * 
	 */
	private void tied(){
		//add the next three cards from each pile to holdingPile ... for loop
		for (int index = 0; index < 3; index++){
			//get card for player 1 & add to pile
			//System.out.println("Player 1 card #" + index + " : "+ player_1.getCard(index).toString());
			holdingPile.addCard(player_1.getCard(index));
			player_1.remove();
			//System.out.println("Player 2 card #" + index + " : "+ player_2.getCard(index).toString());
			holdingPile.addCard(player_2.getCard(index));
			player_2.remove();
		}
		compareCards();	
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
		
			
			
////////////////////////////////////////////////////////////////////

	public static void main(String[] args)
	{
		Window demo = new Window();
	}
}






/////////////////////////////////////////////////////////////
//// Alan Chu 
//// CS 110, Assignment 10 - GUI
//// 
/////////////////////////////////////////////////////////////
//
//
//import javax.swing.JFrame;
//import javax.swing.*;
//
//public class Window extends JFrame{
//	final int WINDOW_WIDTH = 650;
//	final int WINDOW_HEIGHT = 550;
//	private JLabel welcomeBanner;
//	private JPanel panel;
//	private JButton drawButton;
//	
//	public Window()
//	{
//		//set title
//		setTitle("A Simple God dam window");
//		
//		//set size
//		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
//		
//		//specify default
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		//build panel
//		buildPanel();
//		
//		//add panel
//		add(panel);
//		
//		//display window
//		setVisible(true);
//	}
//	
//	/*
//	 * buildPanel method
//	 */
//	private void buildPanel()
//	{
//		//create a label to display instructions
//		welcomeBanner = new JLabel("Welcome to the card game war! Press <Draw Card> to play!");
//		drawButton = new JButton("Draw Card");
//		
//		//create a panel & add labels/button to is
//		panel = new JPanel();
//		panel.add(welcomeBanner);
//		panel.add(drawButton);
//	}
//	
//	public static void main(String[] args)
//	{
//		Window demo = new Window();
//	}
//}
