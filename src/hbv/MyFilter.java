package hbv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import hbv.Enum.Path;

public class MyFilter implements Filter {
    ServletContext ctx;

    public void init(FilterConfig config) throws ServletException {
        ctx = config.getServletContext();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        
        chain.doFilter(request, res);
    }

    public void destroy() {
    }
}
