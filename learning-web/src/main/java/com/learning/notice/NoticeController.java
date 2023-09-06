package com.learning.notice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class NoticeController {
	
	public String title;;
	public String content;
	public String contact_name;
	public String contact_phone;
	
	private Connection cnx= null;
	private Statement st =null;
	private ResultSet rs =null;
	
	public void selectQuery() {
		
		try {
		
		cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/Notice","Revathi","ankem");
		st = cnx.createStatement();
		rs = st.executeQuery("SELECT * from notice");
		//System.out.println("likes_id , user_id, post_id, other_user_id");
		while(rs.next()) {
		this.title= rs.getString("title");
		this.content= rs.getString("content");
		this.contact_name=rs.getString("contact_name");
		this.contact_phone=rs.getString("contact_phone");
		}
		rs.close();
		st.close();
		cnx.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public String getTitle() {
		return this.title;
	}
	
	public String getName() {
		return this.contact_name;
	}

	public String getContent() {
		return this.content;
	}
	
	public String getNumber() {
		return this.contact_phone;
	}
	
	public void saveNotice(String title,String content,String contact_name,String contact_phone) {
		String insert = "insert into notice (title,content,contact_name,contact_phone) values(?,?,?,?)";
		try {
			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Notice", "Revathi", "ankem");
			PreparedStatement st = cnx.prepareStatement(insert);
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, contact_name);
			st.setString(4, contact_phone);
			st.executeUpdate();
			st.close();
			cnx.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
