package com.learning.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String val=req.getParameter("value");
		if(val==null || val.equals("")) {
			resp.setContentType("text/html");
			PrintWriter outer=resp.getWriter();
			outer.print(String.format("<h3>This is a wrong way. Enter a integer to get fibanocci series</h3>"));
			outer.close();
			return;
		}
		int m= Integer.parseInt(val);
		List<Integer> n= new ArrayList<Integer>();
		PrintWriter out=resp.getWriter();
		out.print(String.format("<h1>%s</h1>",GenerateFibonacci(m)));
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String val=req.getParameter("Limit");
		if(val==null) {
			PrintWriter outer=resp.getWriter();
			outer.print("<h2>This is a wrong way. Enter a integer to get fibanocci series</h2>");
		}
		int m= Integer.parseInt(val);
		List<Integer> n= new ArrayList<Integer>();
		PrintWriter out=resp.getWriter();
		out.print(String.format("<h1>%s</h1>",GenerateFibonacci(m)));
	}
	public List<Integer> GenerateFibonacci(int n){
		List<Integer> fib= new ArrayList<Integer>();
		for( int i=0; i<n;i++)
		{
			if(i==0) { fib.add(0); }
			else if(i==1) { fib.add(1); }
			else { fib.add(fib.get(i-1)+fib.get(i-2)); }
			
		}
		return fib;
	}

}
