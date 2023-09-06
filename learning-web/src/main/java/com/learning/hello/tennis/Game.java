package com.learning.hello.tennis;

import java.util.Scanner;

public class Game {

	Player p1 = new Player();
	Player p2 = new Player();

	public void reset() {
		p1.name="player1";
		p2.name="player2";
		p1.match=0;
		p1.score=0;
		p1.set=0;
		p2.match=0;
		p2.score=0;
		p2.set=0;
	}
	
	public void player1name(String name) {
		p1.setName(name);
	}
	
	public void player2name(String name) {
		p2.setName(name);
	}
	
	
	public void getGame() {

		if ((p1.getScore() >= 40 && p2.getScore() >= 40)) {
			if (p1.getScore() - p2.getScore() == 20) {
				gameOver1();

			}

			else if (p2.getScore() - p1.getScore() == 20) {

				gameOver2();

			}

		}

		else if (p1.getScore() > 40 && p2.getScore() <= 30) {

			gameOver1();

		}

		else if (p2.getScore() > 40 && p1.getScore() <= 30) {

			gameOver2();

		}
		System.out.println("game " + p1.score);
		System.out.println("match " + p1.match);
		System.out.println("set " + p1.set);
		System.out.println("game " + p2.score);
		System.out.println("match " + p2.match);
		System.out.println("set " + p2.set);
		
	}

	public void gameOver1() {
		p1.resetScore();
		p2.resetScore();
		p1.updateMatch();
		if ((p1.match >= 6 && (p1.match - p2.match) >= 2) || (p1.match == 7 && p2.match == 6)) {
			p1.updateSet();
			if (p1.set == 3) {
				p1.resetSet();
				p2.resetSet();

			}

			p1.resetMatch();
			p2.resetMatch();
		}
	}

	public void gameOver2() {
		p1.resetScore();
		p2.resetScore();
		p2.updateMatch();
		if ((p2.match >= 6 && (p2.match - p1.match) >= 2) || (p2.match == 7 && p1.match == 6)) {
			p2.updateSet();
			if (p2.set == 3) {
				p2.resetSet();
				p1.resetSet();
				
			}

			p2.resetMatch();
			p1.resetMatch();


		}
	}
	
	public void updateScore1() {
			p1.updateScore();
	}
		
	public void updateScore2() {
		p2.updateScore();
		}	
	
	
	
	public int getPlayer1Score() {
		return p1.score;
	}
	
	public int getPlayer2Score() {
		return p2.score;
	}
	
	public int getPlayer1Match() {
		return p1.match;
	}
	public int getPlayer2Match() {
		return p2.match;
	}
	public int getPlayer1Set() {
		return p1.set;
	}
	public int getPlayer2set() {
		return p2.set;
	}
	
	public void setName1(String player1name) {
		// TODO Auto-generated method stub
		this.p1.name=player1name;
	}

	public void setName2(String player2name) {
		// TODO Auto-generated method stub
		this.p2.name=player2name;

	}
	
	public String getName1() {
		// TODO Auto-generated method stub
		return this.p1.name;
	}
	
	public String getName2() {
		// TODO Auto-generated method stub
		return this.p2.name;
	}
	
	
	
	
	
	



}
