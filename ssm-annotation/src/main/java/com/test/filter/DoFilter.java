package com.test.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class DoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        httpServletRequest.setCharacterEncoding("utf-8");

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        System.out.println("------------");
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("text/html;charset=UTF-8");

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    @Override
    public void destroy() {
    }
}
