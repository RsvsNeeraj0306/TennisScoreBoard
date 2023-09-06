package com.learning.hello;

import java.io.IOException;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
import com.learning.hello.controller.OdometerController;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import com.learning.hello.contoller.OdometerController;

@WebServlet("/odometer")
public class OdometerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OdometerController odometerController;
    private JakartaServletWebApplication application;
    private TemplateEngine templateEngine;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        odometerController = new OdometerController(123);
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
        if (req.getParameter("getNextReading") != null) {
            odometerController.getNextReading();
        } else if (req.getParameter("getPreviousReading") != null) {
            odometerController.getPreviousReading();
        }

//      String action = req.getParameter("action");
        var out = resp.getWriter();
        final IWebExchange webExchange = this.application.buildExchange(req, resp);
        final WebContext ctx = new WebContext(webExchange);
        ctx.setVariable("reading", odometerController.getCurrentReading());
        templateEngine.process("odometer", ctx, out);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final IWebExchange webExchange = this.application.buildExchange(req, resp);
        final WebContext ctx = new WebContext(webExchange);
        ctx.setVariable("reading", odometerController.getCurrentReading());
        templateEngine.process("odometer", ctx, resp.getWriter());
    }

}