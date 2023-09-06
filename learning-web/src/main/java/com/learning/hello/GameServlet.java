package com.learning.hello;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Random;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
import com.learning.hello.controller.game2048.Board;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/game2584")
public class GameServlet extends HttpServlet{
	private Board board ;
	private int currentScore = 0;
    private int highestScore = 0;
  
  private static final long serialVersionUID = 1L;
//  private HiLoController hlc;
  private JakartaServletWebApplication application;
  private TemplateEngine templateEngine;
  @Override
  public void init(ServletConfig config) throws ServletException {
	  board = new Board();
	  super.init(config);
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
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	  Game game = new Game();
	board = new Board();
    String action = req.getParameter("action");
    int row = Integer.parseInt(req.getParameter("row"));
    int col = Integer.parseInt(req.getParameter("col"));
    if ("move".equalsIgnoreCase(action)) {
        if ("up".equalsIgnoreCase(req.getParameter("direction")) || "down".equalsIgnoreCase(req.getParameter("direction"))) {
            board.verticalMove(row, col, req.getParameter("direction")); 
        } else if ("left".equalsIgnoreCase(req.getParameter("direction")) || "right".equalsIgnoreCase(req.getParameter("direction"))) {
            board.horizontalMove(row, col, req.getParameter("direction")); 
        }


        // currentScore += board.getScoreFromLastMove();
        // if (currentScore > highestScore) {
        //     highestScore = currentScore;
        // }

        // Generate the updated game board HTML and send it as a response
        Context ctx = new Context(req.getLocale());
//        WebContext ctx = new WebContext(req, resp, getServletContext(), req.getLocale());
        ctx.setVariable("board", board);
        String updatedBoardHtml = templateEngine.process("game2584", ctx);

        resp.setContentType("text/html");
        resp.getWriter().write(updatedBoardHtml);
    }

  }
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	  req.setAttribute("board", board);
//      req.getRequestDispatcher("/game2584.html").forward(req, resp);
    final IWebExchange webExchange = this.application.buildExchange(req, resp);
    final WebContext ctx = new WebContext(webExchange);
    templateEngine.process("game2584", ctx, resp.getWriter());
  }

}
