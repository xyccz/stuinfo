package main.java.fresh.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CharacterFilter", urlPatterns = {"/*"}, initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class CharacterFilter implements Filter {
    String encoding = null;
    public CharacterFilter() {
    }

    public void destroy() {
        encoding = null;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        if (encoding != null){
            //设置request的编码格式
            req.setCharacterEncoding(encoding);
            res.setCharacterEncoding(encoding);
            //设置response字符编码
            //response.setContentType("text/html; charset="+encoding);
        }

        //传递给下一过滤器
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        encoding = fConfig.getInitParameter("encoding");
    }
}
