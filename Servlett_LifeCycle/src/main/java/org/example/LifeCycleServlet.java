package org.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class LifeCycleServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("in init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<h2>hello from life cycle servlet</h2>");
        System.out.println("in service");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("in destroy");
    }
}
