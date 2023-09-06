//package com.learning.hello.tennis;
//
//import java.util.Scanner;
//
//
//	public class TestingTennis {
//		
//		Player neeraj = new Player();
//		Player karthik = new Player();
//		Game g = new Game();
//		Match m = new Match();
//		TennisSet t = new TennisSet();
//		
//		public void playerupdate() {
//			Scanner sc= new Scanner(System.in);
//			System.out.println("enter 1 for neeraj and 2 for karthik");
//			int n=sc.nextInt();
//			if(n==1) {
//			neeraj.updateScore();
//			}
//			else if(n==2) {
//			karthik.updateScore();
//
//			}
//		}
//		
//		public void updateMatch() {
//			m.updateMatch(neeraj, karthik);
//		}
//		
//		public boolean matchResult() {
//			if(m.result(m.getP1(),m.getP2())==0) {
//				return true;
//			}
//			return false;
//			
//		}
//		
//		public boolean gameResult() {
//			if(g.getGame(neeraj,karthik)==0) {
//				return true;
//			}
//			return false;
//		}
//		
//		public int setResult() {
//			if(t.setResult(t.p1Sets, t.p2Sets)==1) {
//				return 1;
//			}
//			else if(t.setResult(t.p1Sets, t.p2Sets)==1) {
//				return 2;
//			}
//			return 0;
//		}
//		
//		public void updateSet() {
//			t.updateSet(m,m.getP1(),m.getP2());
//		}
//
//		public static void main(String[] args) {
//			// TODO Auto-generated method stub
//			
//			
//			TestingTennis tt = new TestingTennis();
//			int m1=0;
//			int m2=0;
//			while(tt.matchResult()){
//				while(tt.gameResult()) {
//					tt.playerupdate();
//				}
//				
//				tt.updateMatch();
//				tt.updateSet();
//				if(tt.setResult()==1)
//				{
//					System.out.println("Neeraj won the game!!");
//					break;
//				}
//				else if(tt.setResult()==2) {
//					System.out.println("Karthik won the game!!");
//					break;
//				}
//			}
//		}
//	}
//
