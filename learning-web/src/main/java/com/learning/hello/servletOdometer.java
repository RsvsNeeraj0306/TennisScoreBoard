package com.learning.hello;
import java.io.IOException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import com.learning.hello.contoller.controllerOdometer;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/serverodometer")
public class servletOdometer extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private controllerOdometer ocl;
	private JakartaServletWebApplication application;
	private TemplateEngine templateEngine;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ocl = new controllerOdometer();
		application = JakartaServletWebApplication.buildApplication(getServletContext());
		final WebApplicationTemplateResolver templateResolver = new WebApplicationTemplateResolver(application);
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var out = resp.getWriter();
		final IWebExchange webExchange = this.application.buildExchange(req, resp);
		final WebContext ctx = new WebContext(webExchange);
		if(req.getParameter("button").equals("PreviousValue")) {
			ctx.setVariable("previous", ocl.previousOdometer());
			System.out.println(ocl.getOdometer());
		}
		else if(req.getParameter("button").equals("NextValue")) {
			ctx.setVariable("next", ocl.nextReading());
			System.out.println(ocl.getOdometer());
		}
		
		else if(req.getParameter("button").equals("RESET")) {
			ctx.setVariable("reset", ocl.reset());
			System.out.println(ocl.getOdometer());
		}
		
		else if(req.getParameter("button").equals("Enter")) {
			ctx.setVariable("next", ocl.input(Integer.parseInt(req.getParameter("input"))));
			System.out.println(ocl.getOdometer());
		}
		//System.out.println(ocl.input(Integer.parseInt(req.getParameter("input"))));
	
		templateEngine.process("odometer", ctx,resp.getWriter());

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final IWebExchange webExchange = this.application.buildExchange(req, resp);
		final WebContext ctx = new WebContext(webExchange);
		templateEngine.process("odometer", ctx, resp.getWriter());
	}

}