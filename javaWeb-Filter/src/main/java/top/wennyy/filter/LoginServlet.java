package top.wennyy.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author HanWen
 * @Date 2022/2/17 12:08
 * @Version 1.0
 * 登录页面
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端请求的参数
        System.out.println("adwdeew");
        String username = req.getParameter("username");
        if ("admin".equals(username)) {
            //登陆成功
            req.getSession().setAttribute("USER_SESSION", req.getSession().getId());
            //重定向
            resp.sendRedirect("/success.jsp");
        } else {//登陆失败
            resp.sendRedirect("/error.jsp");
        }
    }
        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
            System.out.println("shdlads");

        }

}