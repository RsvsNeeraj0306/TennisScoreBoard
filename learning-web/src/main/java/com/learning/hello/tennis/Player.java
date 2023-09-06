package com.learning.hello.tennis;

public class Player {
	
	public String name;
	public int score=0;
	public int match=0;
	public int set=0;
	
	public void resetScore() {
		this.score=0; 
		
	}
	
	public void resetMatch() {
		this.match=0;
	}
	
	
	public void resetSet() {
		this.set=0;
	}
	
	
	public void setName(String name) {
		this.name=name;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	
	
	public void setScore(int score)
	{
		this.score=score;
	}
	

	
	public void updateScore() {
		if(score == 0 || score==15) 
		{
			this.score+=15;
		}
		
		else if((score)>=30) 
		{
			this.score+=10;
		}
		System.out.println(this.score);
	}
	
		public void updateMatch() {
		
		this.match+=1;		 
	}
	
		public void updateSet() {
		
		this.set+=1;
		 
	}
	
	

}