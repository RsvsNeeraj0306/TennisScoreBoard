package com.learning.hello.controller.game2048;

public class Main {
	public static void main(String[] args) {
		Board b = new Board();
//		b.spawn();
		System.out.println("Game 2584");
		b.verticalMove(2,2,"up");
		b.print();
	}
}
