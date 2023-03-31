package filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter(urlPatterns="/index.jsp")
public class MyFilter implements Filter {

    /**
     * Default constructor.
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see MyFilter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see MyFilter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest hq = (HttpServletRequest) request;

        HttpSession session = hq.getSession();

        Object user = session.getAttribute("log");

        if(user==null) {
            hq.getRequestDispatcher("/login.jsp").forward(hq, response);
            return;
        }
        else {
            chain.doFilter(hq, response);
        }
    }

    /**
     * @see MyFilter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
