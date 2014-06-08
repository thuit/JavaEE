package day4.demo.util;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Administrator on 14-6-8.
 */
//过滤器
public class Encoding implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");//ISO8859-1
        filterChain.doFilter(servletRequest, servletResponse);//*****
    }

    @Override
    public void destroy() {

    }
}
