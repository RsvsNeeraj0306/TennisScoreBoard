package com.learning.notice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

@WebServlet("/notices")
public class NoticeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JakartaServletWebApplication application;
	private TemplateEngine templateEngine;
	NoticeController n = new NoticeController();
	NoticeController n6 = new NoticeController();
	NoticeController n2 = new NoticeController();
	NoticeController n3 = new NoticeController();
	NoticeController n4 = new NoticeController();
	NoticeController n5 = new NoticeController();
	public String title;
	public String name;
	public String number;
	public String comment;
	public int count=0;

	static {

		try {

			// Load the MySQL JDBC driver

			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		}

	}

	@Override
	public void init() throws ServletException {
		super.init();

		
		application = JakartaServletWebApplication.buildApplication(getServletContext());
		final WebApplicationTemplateResolver templateResolver = new WebApplicationTemplateResolver(application);
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		var out = res.getWriter();
		final IWebExchange webExchange = this.application.buildExchange(req, res);
		final WebContext ctx = new WebContext(webExchange);
		ctx.setVariable("getcard1", n.getContent());
		ctx.setVariable("getcard2", n2.getContent());
		ctx.setVariable("getcard3", n3.getContent());
		ctx.setVariable("getcard4", n4.getContent());
		ctx.setVariable("getcard5", n5.getContent());
		ctx.setVariable("getcard6", n6.getContent());
		
		templateEngine.process("Notice", ctx, out);

	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		final IWebExchange webExchange = this.application.buildExchange(req, res);
		final WebContext ctx = new WebContext(webExchange);
		
		//n.saveNotice(name,temp,content);
		
		System.out.println(req.getParameter("button").equals("Submit"));
		if (req.getParameter("button").equals("Submit")) {
			
			count++;
			if(count==1) {
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				String contact_name = req.getParameter("contact_name");
				String contact_phone = req.getParameter("contact_phone");
				n.saveNotice(title,content,contact_name,contact_phone);
				n.selectQuery();
				System.out.println(n.getName() + "Name");
				System.out.println("count: "+count);
				
			}
			else if(count==2) {
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				String contact_name = req.getParameter("contact_name");
				String contact_phone = req.getParameter("contact_phone");
				n2.saveNotice(title,content,contact_name,contact_phone);
				n2.selectQuery();
				System.out.println(n2.getName() + "Name");
				System.out.println("count: "+count);
				
			}
			else if(count==3) {
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				String contact_name = req.getParameter("contact_name");
				String contact_phone = req.getParameter("contact_phone");
				n3.saveNotice(title,content,contact_name,contact_phone);
				n3.selectQuery();
				System.out.println(n3.getName() + "Name");
				System.out.println("count: "+count);
				
			}
			else if(count==4) {
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				String contact_name = req.getParameter("contact_name");
				String contact_phone = req.getParameter("contact_phone");
				n4.saveNotice(title,content,contact_name,contact_phone);
				n4.selectQuery();
				System.out.println(n4.getName() + "Name");
				System.out.println("count: "+count);
				
			}
			else if(count==5) {
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				String contact_name = req.getParameter("contact_name");
				String contact_phone = req.getParameter("contact_phone");
				n5.saveNotice(title,content,contact_name,contact_phone);
				n5.selectQuery();
				System.out.println(n5.getName() + "Name");
				System.out.println("count: "+count);
				
			}
			else if(count==6) {
				String title = req.getParameter("title");
				String content = req.getParameter("content");
				String contact_name = req.getParameter("contact_name");
				String contact_phone = req.getParameter("contact_phone");
				n6.saveNotice(title,content,contact_name,contact_phone);
				n6.selectQuery();
				System.out.println(n6.getName() + "Name");
				System.out.println("count: "+count);
				count=0;
			}
			
		}
		ctx.setVariable("getcard1", n.getContent());
		ctx.setVariable("getcard2", n2.getContent());
		ctx.setVariable("getcard3", n3.getContent());
		ctx.setVariable("getcard4", n4.getContent());
		ctx.setVariable("getcard5", n5.getContent());
		ctx.setVariable("getcard6", n6.getContent());


		doGet(req, res);
	}

	

	

}
