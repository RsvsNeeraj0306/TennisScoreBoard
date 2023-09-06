package com.learning.hello.tennis;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tennis")

public class TennisServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public Game game ;
	public TennisDatabase  tb;
	private JakartaServletWebApplication application;
	private TemplateEngine templateEngine;
	
	@Override
	  public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    game = new Game();
	    tb = new  TennisDatabase();
	    application = JakartaServletWebApplication.buildApplication(getServletContext());
	    final WebApplicationTemplateResolver templateResolver = 
	        new WebApplicationTemplateResolver(application);
	    templateResolver.setTemplateMode(TemplateMode.HTML);
	    templateResolver.setPrefix("/WEB-INF/templates/");
	    templateResolver.setSuffix(".html");
	    templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	  }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		var out = resp.getWriter();
		final IWebExchange webExchange = this.application.buildExchange(req, resp);
		    final WebContext ctx = new WebContext(webExchange);
		    if(req.getParameter("submitDetails")!=null) {
		    	String player1Name=req.getParameter("player1name");
		    	String player2Name=req.getParameter("player2name");
		    	game.setName1(player1Name);
		    	game.setName2(player2Name);
		    	tb.insertPlayer(player1Name);
		    	tb.insertPlayer(player2Name);
		    	tb.getPlayer1();
		    	tb.getPlayer2();
		    	tb.getNames();
		    
		    }
		    
		    if(req.getParameter("player1")!=null) {
		    	game.updateScore1();
		    	game.getGame();
		    	tb.insertPoints1(game.getPlayer1Score(), game.getPlayer1Match(), game.getPlayer1Set());
			}
		    if(req.getParameter("player2")!=null){
		    	game.updateScore2();
		    	game.getGame();
		    	tb.insertPoints2(game.getPlayer2Score(), game.getPlayer2Match(), game.getPlayer2set());
				
		    }
		    if(req.getParameter("reset")!=null) {
		    	game.reset();
		    	tb.insertPoints1(game.getPlayer1Score(), game.getPlayer1Match(), game.getPlayer1Set());
		    	tb.insertPoints2(game.getPlayer2Score(), game.getPlayer2Match(), game.getPlayer2set());
		    	
		    }
		    ctx.setVariable("player1Name",game.getName1());
	    	ctx.setVariable("player2Name",game.getName2());
		    ctx.setVariable("player1score",game.getPlayer1Score());
			ctx.setVariable("player2score",game.getPlayer2Score());
			ctx.setVariable("player1match",game.getPlayer1Match());
			ctx.setVariable("player2match",game.getPlayer2Match());
			ctx.setVariable("player1set",game.getPlayer1Set());
			ctx.setVariable("player2set",game.getPlayer2set());
			
			
			
		    templateEngine.process("tennis", ctx, out);
		    resp.sendRedirect(req.getServletPath());
	}
	
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    final IWebExchange webExchange = this.application.buildExchange(req, resp);
	    final WebContext ctx = new WebContext(webExchange);
	    templateEngine.process("tennis", ctx, resp.getWriter());
	    if (req.getParameter("previous") != null) {
	        
	        String previousPlayer1Name = tb.player1; 
	        String previousPlayer2Name = tb.player2; 
	        int previousPlayer1Score = tb.score1;   
	        int previousPlayer2Score = tb.score2;   
	        int previousPlayer1matches = tb.match1;   
	        int previousPlayer2matches = tb.match2; 
	        int previousPlayer1Set = tb.set1;   
	        int previousPlayer2Set = tb.set2; 
	        
	        
	        ctx.setVariable("player1Name", previousPlayer1Name);
	        ctx.setVariable("player2Name", previousPlayer2Name);
	        ctx.setVariable("player1score", previousPlayer1Score);
	        ctx.setVariable("player2score", previousPlayer2Score);
	        ctx.setVariable("player1match", previousPlayer1matches);
	        ctx.setVariable("player2macth", previousPlayer2matches);
	        ctx.setVariable("player1set", previousPlayer1Set);
	        ctx.setVariable("player2set", previousPlayer2Set);
	    }

	    ctx.setVariable("player1Name",tb.player1);
    	ctx.setVariable("player2Name",tb.player2);
	    ctx.setVariable("player1score",tb.score1);
		ctx.setVariable("player2score",tb.score2);
		ctx.setVariable("player1match",tb.match1);
		ctx.setVariable("player2match",tb.match2);
		ctx.setVariable("player1set",tb.set1);
		ctx.setVariable("player2set",tb.set2);
		
	    //doPost(req,resp);
	  }
}
	