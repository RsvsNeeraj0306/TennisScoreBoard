package com.learning.hello;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HiLoServlet")
public class HiLoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int randomNumber;
    private int guesses;
    
    @Override
    public void init() throws ServletException {
        randomNumber = (int) (Math.random() * 100) + 1;
        guesses = 0;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userGuessStr = request.getParameter("guess");
        int userGuess = -1;
        if (userGuessStr != null && !userGuessStr.isEmpty()) {
            userGuess = Integer.parseInt(userGuessStr);
            String message = "";
            if (userGuess == randomNumber) {
                message = "Correct number! ";
            } else if (userGuess < randomNumber) {
                message = "Try Higher!";
            } else {
                message = "Try Lower!";
            }
//            out.println(message); 
        out.println("<html><head><title>Hi-Lo Game</title></head><body>");
        out.println("<h1>HiLo Game</h1>");
        out.println("<form action='' method='post'>");
        out.println("<label for=\"guess\">Enter your guess: </label>");
        out.println("<input type=\"number\" id=\"guess\" name=\"guess\" required>");
        out.println("<button type=\"submit\">Submit</button>");
        out.println("</form>");

        // Display the message if it's not empty
        if (!message.isEmpty()) {
        	out.println("<h2>Computer Generated Response:</h2>");
            out.println("<p>" + message + "</p>");
        }

        out.println("</body></html>");
        out.close();
    }
    }
}
    