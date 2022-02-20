package top.wennyy.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author HanWen
 * @Date 2022/2/17 15:31
 * @Version 1.0
 *退出登陆后无法进入主页中
 */
public class LginoutServet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object user_session = req.getSession().getAttribute("USER_SESSION");
        if (user_session !=null){
            req.getSession().removeAttribute("USER_SESSION");
            resp.sendRedirect("/Login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
