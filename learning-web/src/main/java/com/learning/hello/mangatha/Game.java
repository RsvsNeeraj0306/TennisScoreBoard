package com.learning.hello.mangatha;



import java.util.ArrayList;
import java.util.List;

public class Game {
	
	public  List<Card> inPile = new ArrayList<Card>();
	public  List<Card> outPile= new ArrayList<Card>();
	private static  Deck deck = new Deck();
	private static  Card card = deck.drawFromTop();

	private  Player player1;
	private  Player player2;
	private static  boolean turn;
	
	public  Card initializeCard() {
		deck.shuffleDeck();
		return card;
	}
	public void distributeCards() {
		if(turn) {
			inPile();
			turn = false;
		}
		else{
			outPile();
			turn = true;
		}
	}
	
	private  void inPile() {
		inPile.add(initializeCard());
		card = deck.drawFromTop();
	}
	
	private  void outPile() {
		outPile.add(initializeCard());
		card = deck.drawFromTop();
	}
	
	public int compare(Player player ) {
		System.out.println("card compare: "+ card + " "+player.getGuess() +" "+( player.getGuess().toString().equals(card.toString()) ));
		System.out.println(" turn comapre "+turn +" "+player.getPosition()+"  "+(player.getPosition().equals("in")));
		if(( player.getGuess().toString().equals(card.toString()) )) {
			if((player.getPosition().equals("in")) && turn) 
				return 1;
			else
				return -1;
		}
		return 0;
	}
    public List<Card> getInPile() {
        return inPile;
    }

    public List<Card> getOutPile() {
        return outPile;
    }

}