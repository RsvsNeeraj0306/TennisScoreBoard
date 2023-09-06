package com.learning.hello.mangatha;


public class Player {
	private  String name;
	private  Card guess;
	private  int bet;
	private  String position;
	
	public Player(String name, Card guess, int bet, String position){
		this.setName(name);
		this.setGuess(guess);
		this.setBet(bet);
		this.setPosition(position);
	}

	public  String getName() {
		return name;
	}

	public  void setName(String name) {
		this.name = name;
	}

	public  Card getGuess() {
		return guess;
	}
	

	public  void setGuess(Card guess) {
		this.guess = guess;
	}

	public  int getBet() {
		return bet;
	}

	public  void setBet(int bet) {
		this.bet = bet;
	}

	public String getPosition() {
		return position;
	}

	public  void setPosition(String position) {
		this.position = position;
	}
	
	

}