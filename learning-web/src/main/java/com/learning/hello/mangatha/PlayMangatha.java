package com.learning.hello.mangatha;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
//import org.thymeleaf.web.IWebApplication;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PlayMangatha")
public class PlayMangatha extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private JakartaServletWebApplication application;
    private TemplateEngine templateEngine;
    private PlayGame game;
    private Player player1;
    private Player player2;
 
//    public PlayMangatha() {
//        super();
//    }
    @Override
    public void init(ServletConfig config) throws ServletException {
	    super.init(config);
    	
    	game = new PlayGame();

    	application = JakartaServletWebApplication.buildApplication(getServletContext());
	    final WebApplicationTemplateResolver templateResolver = 
	        new WebApplicationTemplateResolver(application);
	    templateResolver.setTemplateMode(TemplateMode.HTML);
	    templateResolver.setPrefix("/WEB-INF/templates/");
	    templateResolver.setSuffix(".html");
	    templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	  }
    
    @Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    final IWebExchange webExchange = this.application.buildExchange(req, resp);
	    final WebContext ctx = new WebContext(webExchange);
	    templateEngine.process("mangatha", ctx, resp.getWriter());
	  }
    
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException , NullPointerException {

    	String player1Name = request.getParameter("player1Name");
        String player1CardNumber = request.getParameter("player1CardNumber");
        String player1CardType = request.getParameter("player1CardType");
        String player1BetStr = request.getParameter("player1BetStr");
        String player1Position = request.getParameter("player1Position");
        int player1Bet = Integer.parseInt(player1BetStr);

        String player2Name = request.getParameter("player2Name");
        String player2CardNumber = request.getParameter("player2CardNumber");
        String player2CardType = request.getParameter("player2CardType");
        String player2BetStr = request.getParameter("player2BetStr");
        String player2Position = request.getParameter("player2Position");
        int player2Bet = Integer.parseInt(player2BetStr);

        Card player1CardGuess = new Card(player1CardNumber + player1CardType);
        Card player2CardGuess = new Card(player2CardNumber + player2CardType);

        player1 = new Player(player1Name, player1CardGuess, player1Bet, player1Position);
        player2 = new Player(player2Name, player2CardGuess, player2Bet, player2Position);

       Game g = new Game();
        List<Card> inpile = new ArrayList<Card>();
        List<Card> outpile = new ArrayList<Card>();
        inpile = g.inPile;
        outpile = g.outPile;
       
        PlayGame game = new PlayGame();
        game.players.add(player1);
        game.players.add(player2);
       
        
        System.out.println(player1);
        
        String gameResult = game.playGame();
        var out = response.getWriter();
    	final IWebExchange webExchange = this.application.buildExchange(request, response);
       final WebContext ctx = new WebContext(webExchange);
        request.setAttribute("result", gameResult);
        templateEngine.process("PlayMangatha", ctx,out);
        

    }
}


	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String input = req.getParameter("card");
		String Pile = req.getParameter("pile");
		String pileName = "";
			if(Pile.equals("in")) {
				pileName = "InPile";
			}
			else if(Pile.equals("out")){
				pileName = "OutPile";
			}
			
		System.out.println(input);
		System.out.println(pileName);
		
		var out = resp.getWriter();
		final IWebExchange webExchange = 
		        this.application.buildExchange(req, resp);
		    final WebContext ctx = new WebContext(webExchange);
		    
		    
		    String list = game.distributeCards();
		    System.out.println(list);
		    //out.println(list);
		    ctx.setVariable("reading",game.verifyCardPosition(input, pileName) );  
		    ctx.setVariable("inpile",game.getInPile() );  
		    ctx.setVariable("outpile",game.getOutPile());  
		    templateEngine.process("Mankatha", ctx, out);
		    resp.sendRedirect(req.getServletPath());
	}
	
	
}
	
