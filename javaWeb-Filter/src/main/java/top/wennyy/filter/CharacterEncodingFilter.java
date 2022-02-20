package top.wennyy.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author HanWen
 * @Date 2022/2/17 10:03
 * @Version 1.0
 */
public class CharacterEncodingFilter implements Filter {
    @Override
    //初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=UTF-8");
        System.out.println("执行前");
        chain.doFilter(request,response);//让我们的请求继续走，如果不写，程序到这里拦截
        System.out.println("执行后");
    }

    @Override
    //销毁:web服务器关闭时，过滤会销毁
    public void destroy() {
        System.out.println("销毁");
    }
}
