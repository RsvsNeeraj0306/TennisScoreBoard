package com.learning.hello;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class passwordValidator extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String BANNED_PASSWORDS = "/home/revathi/eclipse-workspace/learning-web/src/main/java/com/learning/hello/banned_password.txt";
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String password = request.getParameter("password");

        if (isPasswordBanned(password)) {
        	PrintWriter out=response.getWriter();
            out.print("<p>Password is not allowed<p>");
        } else {
        	PrintWriter out1=response.getWriter();
            out1.print("<p>Sucess! Password validation successful<p>");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String password = request.getParameter("password");

        if (isPasswordBanned(password)) {
        	PrintWriter out=response.getWriter();
            out.print("<h1>Password is not allowed<h1>");
        } else {
        	PrintWriter out1=response.getWriter();
            out1.print("<h1>Password validation successful<h1>");
        }
    }

    private boolean isPasswordBanned(String password) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(BANNED_PASSWORDS))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals(password)) {
                    return true;
                }
            }
        }
        catch(IOException e) {
            System.out.print("File error");
        }
        return false;
    }
}
