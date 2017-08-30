package by.training.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class RequestListener implements ServletContextListener{



    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("DBNAME", "epamLab");
        sce.getServletContext().setInitParameter("DBNAME", "epamLab");
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
