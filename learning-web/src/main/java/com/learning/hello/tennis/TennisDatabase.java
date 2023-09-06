package com.learning.hello.tennis;
import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TennisDatabase {
	
	public String player1;
	public String player2;
	public int match1=0;
	public int score1=0;
	public int set1=0;
	public int match2=0;
	public int score2=0;
	public int set2=0;
	
    public void insertPlayer(String PlayerName) {
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
	    try {
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis" ,
					"Revathi",
					"ankem");
			String command = "INSERT INTO players (name) VALUES (?);";
			PreparedStatement stamt=cnx.prepareStatement(command);
			stamt.setString(1, PlayerName);
//			stamt.setInt(2, game);
//			stamt.setInt(3, match);
//			stamt.setInt(4, set);
			stamt.executeUpdate();
			System.out.println("Liked the post");
		}catch(SQLException e) {
			e.printStackTrace();
		}	
    }
    
    
 public void insertPoints1(int score, int matches, int set) {
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
	    try {
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis" ,
					"Revathi",
					"ankem");
			String command = "INSERT INTO points1 (score,matches,sets) VALUES (?,?,?);";
			PreparedStatement stamt=cnx.prepareStatement(command);
			stamt.setInt(1, score);
			stamt.setInt(2, matches);
			stamt.setInt(3, set);
			stamt.executeUpdate();
			System.out.println("Liked the post");
		}catch(SQLException e) {
			e.printStackTrace();
		}	
    }
    
 public void insertPoints2(int score, int matches, int set) {
 	
 	try {
 		Class.forName("com.mysql.cj.jdbc.Driver");
 	}
 	catch(ClassNotFoundException e) {
 		e.printStackTrace();
 	}
 	
	    try {
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis" ,
					"Revathi",
					"ankem");
			String command = "INSERT INTO points2 (score,matches,sets) VALUES (?,?,?);";
			PreparedStatement stamt=cnx.prepareStatement(command);
			stamt.setInt(1, score);
			stamt.setInt(2, matches);
			stamt.setInt(3, set);
			stamt.executeUpdate();
			System.out.println("Liked the post");
		}catch(SQLException e) {
			e.printStackTrace();
		}	
 }
 
 	public  void getPlayer1() {
		try {
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis" ,
					"Revathi",
					"ankem");
			Statement stmt = cnx.createStatement();
			String str = "select score,matches,sets from points1 order by id desc limit 1" ;
			ResultSet rs = stmt.executeQuery(str);
			while(rs.next()) {
				this.score1= rs.getInt("score");
				this.match1=rs.getInt("matches");
				this.set1=rs.getInt("sets");
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
 	}
		
		
		public void getPlayer2() {
			try {
				Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/tennis" ,
						"Revathi",
						"ankem");
				Statement stmt = cnx.createStatement();
				String str = "select score ,matches,sets from points2 order by id desc limit 1" ;
				ResultSet rs = stmt.executeQuery(str);
				while(rs.next()) {
					this.score2= rs.getInt("score");
					this.match2=rs.getInt("matches");
					this.set2=rs.getInt("sets");
				}	
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
}	
		
		public void getNames() {
			try {
				Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice" ,
						"Revathi",
						"ankem");
				Statement stmt = cnx.createStatement();
				String str = "select name from players order by id desc limit 1 offset 1" ;
				ResultSet rs = stmt.executeQuery(str);
				while(rs.next()) {
					this.player1=rs.getString("name");
				}
				
				String str1 = "select name from players order by id desc limit 1 " ;
				ResultSet rs1 = stmt.executeQuery(str1);
				while(rs1.next()) {
					this.player2=rs.getString("name");
				}
				}	
			catch(SQLException e) {
				e.printStackTrace();
			}
		
		}
		
 
 
 
   
    	
    }
    
    

  
