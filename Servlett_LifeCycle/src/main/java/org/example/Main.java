package org.example;

// Using Jetty for local running
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Add servlet to server
        context.addServlet(new ServletHolder( new LifeCycleServlet()), "/LifeCycleServlet");

        // Server start
        server.start();
        server.join();
    }
}
