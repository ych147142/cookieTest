package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.getId();//获取session 的ID
        session.setMaxInactiveInterval(20);//设置Session最大活跃时间的间隔
        session.invalidate();//销毁session
       //创建一个Cookie对象
        Cookie cookie = new Cookie("username","admin");
        /*设置Cookie存储时间 默认为秒
        * 括号里设置为负数为默认浏览器会话结束时到期   存在内存中
        * 括号里设置为正数  持久化存储  存在硬盘中
        * */
        cookie.setMaxAge(60*60*24*7);//7天
        resp.addCookie(cookie);
    }



}
