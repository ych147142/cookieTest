package com.neuedu.controller;

import com.neuedu.pojo.User;
import com.neuedu.service.IUserService;
import com.neuedu.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doRegister")
public class DoRegisterServlet extends HttpServlet {
    private IUserService service = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String pwds =req.getParameter("pwds");
        String tele = req.getParameter("tele");
        if (uname!=""){
            User user = service.getOne(uname);
            if (user == null){
                resp.getWriter().write("4");
                if (pwd!="" && pwds!=""){
                    if (pwd.equals(pwds)){
                        resp.getWriter().write("3");
                    }else {
                        resp.getWriter().write("2");
                    }
                }

            }else {
                resp.getWriter().write("1");
            }
        }


    }
}
