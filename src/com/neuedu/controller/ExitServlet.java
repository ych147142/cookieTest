package com.neuedu.controller;

import com.neuedu.utilTest.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Map;

@WebServlet("/exit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie [] cookies = req.getCookies();
        Map<String,Cookie> maps = CookieUtil.getCookie(cookies);
        Cookie c = maps.get("username");
        c.setValue("");
        c.setMaxAge(0);
        resp.addCookie(c);
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("login");
    }
}
