package com.learning.hello.noticeBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnector {

	public static void likeFuntion(int userId, int postId) {
		try {
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice" ,
					"Revathi",
					"ankem");
			Statement stmt = cnx.createStatement();
			String command = "INSERT INTO USER_LIKES VALUES(" + userId + "," + postId + ");";
			stmt.executeUpdate(command);
			System.out.println("Liked the post");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
}	
	public static void commentFuntion(int userId, int postId,String content) {
		try {
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice" ,
					"Revathi",
					"ankem");
			Statement stmt = cnx.createStatement();
			String str = "INSERT INTO USER_COMMENTS VALUES(" + userId + "," + postId + ",'"+ content.replace("'", "'") +"');";
			stmt.executeUpdate(str);
			System.out.println("You have succesfully commented");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
}	
	public static void retrieveFuntion(int postId) {
		try {
			Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/notice" ,
					"Revathi",
					"ankem");
			Statement stmt = cnx.createStatement();
			String str = "SELECT USER_ID FROM USER_LIKES WHERE POST_ID = " + postId + ";";
			ResultSet rs = stmt.executeQuery(str);
			while(rs.next()) {
				System.out.println(rs.getString("USER_ID"));
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
}	
	
	
	public static void main(String[] args) {
		int user_id=4;
		int post_id=5;
		String comment="HAPPY DAY!";
		likeFuntion(user_id,post_id);
		commentFuntion(user_id,post_id,comment);
		retrieveFuntion(post_id);
		}

	

}
