package com.learning.hello;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class HelloServlet extends GenericServlet{

	@Override
	public void init() {
		
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am processing!");
		
	}
	
	public void destroy() {
		
	}

}
