package by.training.filters;


import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

public class PriorFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(SecondFilter.class.getName());

    private int hitCounter;

    public void init(FilterConfig filterConfig) throws ServletException {
        hitCounter = 0;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.debug("First Filter Do!");
        //PrintWriter out = response.getWriter();
        //out.println("Filter hitCounter " + ++hitCounter + "<br>");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
