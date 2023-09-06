//package com.learning.hello.tennis;
//
//public class Match {
//	
//	public int p1Matches=0;
//	public int p2Matches=0; 
//	
//	public void matchReset() {
//		this.p1Matches=0;
//		this.p2Matches=0;
//	}
//	
//	
//	public void setP1(int s)
//	{
//		this.p1Matches =s;
//	}
//	
//	public void setP2(int s)
//	{
//		this.p2Matches =s;
//	}
//	
//	public int getP1()
//	{
//		return this.p1Matches;
//	}
//	
//	public int getP2()
//	{
//		return this.p2Matches;
//	}
//	
//	public void updateMatch(Player p1, Player p2) {
//		Game g = new Game();
//		
//		if(g.getGame(p1, p2) ==1)
//		{
//			this.p1Matches+=1;
//			p1.reset();
//			p2.reset();
//		}
//		else if(g.getGame(p1, p2)==2)
//		{
//			this.p2Matches+=1;
//			p1.reset();
//			p2.reset();
//		}
//		
//		System.out.println(this.p1Matches+" :P1Score");
//		System.out.println(this.p2Matches+" :P2Score");
//		
//		 
//	}
//	
//	
//	public int result(int p1Matches, int p2Matches) {
//		
//		if((p1Matches>=6 && (p1Matches-p2Matches) >=2 )|| (p1Matches==7 && p2Matches ==6)) 
//		{
//			matchReset();
//			return 1;
//			
//			
//			
//		}
//		
//		else if((p2Matches>=6 && (p2Matches-p1Matches) >=2 )|| (p2Matches==7 && p1Matches ==6)) {
//			matchReset();
//			return 2;
//			
//			
//		}
//		System.out.println(p1Matches+"  "+p2Matches);
//		
//	return 0;
//		
//		
//	}
//	
//	
//	
//}