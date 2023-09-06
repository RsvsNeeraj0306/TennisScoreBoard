package com.learning.hello.mangatha;

import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

public class PlayGame {
	private  String name;
	private  Card guess;
	private  int bet;
	private  String position;
	private static int totalAmount;
	public static  List<Player> players = new ArrayList<Player>();
	Deck deck = new Deck();
	
//	public static void main(String[] args) {
//
//		System.out.println("Lets PLay Mangatha :)!\n\n");
//		Scanner scanner = new Scanner(System.in);
//		int i=1;
//		while(i<3) {
//			System.out.printf("\nEnter player%d name: ",i);
//			String n = scanner.next();
//			
//			System.out.printf("\nEnter player%d guess: ",i);
//			String temp = scanner.next();
//			Card guess = new Card(temp);
//			
//			System.out.printf("\nEnter player%d position: ",i);
//			String p = scanner.next();
//			
//			System.out.printf("\nEnter player%d bet: ",i);
//			int b = scanner.nextInt();
//			
//			Player player1 = new Player(n, guess, b, p);
//			players.add(player1);
//			totalAmount += players.get(i-1).getBet();	 
//			i+=1;
//		}
//		System.out.println(totalAmount);
//		System.out.println(playGame());
////		Game game = new Game();
////		for(Player player:players) {
//////			totalAmount += player.getBet();
////			System.out.println(game.compare(player));
////			
////			switch(game.compare(player)) {
////			case -1:
////				System.out.printf("%s : You Loose!"+player.getName());
////				players.remove(i);
////				break;
////			case 0:
////				System.out.println("%s : ");
////				Game game1 = new Game();
////				
////				break;
////			case 1:
////				System.out.printf("%s : You Win! Total Amount :%d"+player.getName()+ totalAmount);
////				break;
////			
////				
////			}
////			break;
////		}
//		
//		
//	}
	public String playGame() {
	    Game game = new Game();
	    while (players.size() > 1) {
	        List<Player> playersToRemove = new ArrayList<>();
	        for (Player player : players) {
	            int result = game.compare(player);
	            if (result == -1) {
	                playersToRemove.add(player);
	            } else if (result == 1) {
	                return String.format("%s : You Win! Total Amount: %d", player.getName(), totalAmount);
	            }
	        }
	        players.removeAll(playersToRemove);

//	        // Add a card to either the in or out decks
	        game.distributeCards();
//
//	        // Display the contents of the in and out decks
	        System.out.println("In Deck: " + game.getInPile());
	        System.out.println("Out Deck: " + game.getOutPile());
	    }

	    if (!players.isEmpty()) {
	        Player winner = players.get(0);
	        return String.format("%s : You Win! Total Amount: %d", winner.getName(), totalAmount);
	    }

	    return "No winner.";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Card getGuess() {
		return guess;
	}

	public void setGuess(Card guess) {
		this.guess = guess;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}