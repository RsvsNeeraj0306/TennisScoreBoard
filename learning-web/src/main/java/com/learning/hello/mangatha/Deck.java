package com.learning.hello.mangatha;

import java.util.*;

public class Deck {
	
	public List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		for(int rank = Card.MIN_RANK;rank<=Card.MAX_RANK;rank++) {
			for(int suit = Card.MIN_SUIT;suit<=Card.MAX_SUIT;suit++) {
				cards.add(new Card(rank,suit));
			}
		}
	}
	
	public void shuffleDeck(){
		Collections.shuffle(cards);
	}
	
	
	public Card drawFromTop(){
		if(cards.isEmpty()) {
			System.out.println("No more cards left.");
		}
		Card c = cards.get(0);
		cards.remove(0);
		return c;
	}
	
	public Card drawFromBottom() {
		int lastIndex = cards.size()- 1;
		Card card = cards.get(lastIndex);
		cards.remove(0);
		return card;
	}
	
	public void insertAtTop(Card c){
		cards.add(0,c);
	}
	
	public Card drawRandom() {
		int index = (int)Math.random();
		Card c = cards.get(index);
		cards.remove(0);
		return c;
	}
	
	
	public void insertRandom(Card c) {
		int index = (int)Math.random();
		cards.add(index,c);
	}
	
}