package by.training.servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/ErrorServlet")
public class ErrorServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ErrorServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception");
        int statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");
        String message = (String) req.getAttribute("javax.servlet.error.message");
        String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");



        LOGGER.debug(message, throwable);

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        if (throwable != null) {
            out.println("Name Exception - " + throwable.getClass().getName() + "<br>");
        }
        out.println("StatusCode - " + statusCode + "<br>");
        out.println("Message - " + message + "<br>");
        out.println("ServletName - " + servletName + "<br>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
