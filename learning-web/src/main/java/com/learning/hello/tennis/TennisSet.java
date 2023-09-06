//package com.learning.hello.tennis;
//
//public class TennisSet {
//	
//	public int p1Sets=0;
//	public int p2Sets=0;
//	
//	public void setReset() {
//		this.p1Sets=0;
//		this.p2Sets=0;
//	}
//	
//	public void setP1(int s)
//	{
//		this.p1Sets =s;
//	}
//	
//	public void setP2(int s)
//	{
//		this.p2Sets =s;
//	}
//	
//	public int getP1()
//	{
//		return this.p1Sets;
//	}
//	
//	public int getP2()
//	{
//		return this.p2Sets;
//	}
//	
//	public void updateSet(Match m, int m1, int m2){
//		
//		if(m.result(m1,m2) ==1)
//		{
//			this.p1Sets+=1;
//		}
//		else if(m.result(m1,m2)==2)
//		{
//			this.p2Sets+=1;
//		}
//		System.out.println(this.p1Sets+" :Player 1 won set");
//		System.out.println(this.p2Sets+" :Player 2 won set");
//		
//
//	}
//	
//	
//	public int setResult(int p1Sets, int p2Sets) {
//		
//		if(p1Sets>=3 ) 
//		{
//			setReset();
//			return 1;
//			
//		}
//		
//		else if(p2Sets>=3) {
//			setReset();
//			return 2;
//			
//		}
//		
//	return 0;
//		
//		
//	}
//	
//	
//
//}