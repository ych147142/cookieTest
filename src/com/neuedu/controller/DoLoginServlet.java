package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/doLogin")
public class DoLoginServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        User user = service.getOne(uname);
        if (user == null){
            resp.sendRedirect("register");
        }else {
            if (user.getPassword().equals(pwd)){
                /*长时间存储*/
                Cookie coon= new Cookie("username",uname);//设置用户名cookie
                Cookie coop = new Cookie("password",pwd);//设置密码cookie
                coon.setMaxAge(60*60*24*7);//账户保存时间
                coop.setMaxAge(60*60*24*7);//密码保存时间
                resp.addCookie(coon);
                resp.addCookie(coop);
                HttpSession session = req.getSession();
                session.setAttribute("user",user);
                resp.sendRedirect("list");

            }
        }
    }
}
