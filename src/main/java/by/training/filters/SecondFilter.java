package by.training.filters;


import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(SecondFilter.class.getName());


    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info(filterConfig.getInitParameter("filter-param"));
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("Second Filter Do!");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
