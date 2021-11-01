package com.example.blogpagestage.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "ContextTypeFilter",urlPatterns = "/*")
public class ContextTypeFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("文本编码过滤器启动了！");
    }

    public void destroy() {
        System.out.println("文本编码过滤器被销毁了！");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
//        System.out.println("触发！");
        chain.doFilter(request, response);
    }
}
