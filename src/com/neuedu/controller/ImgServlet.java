package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig  //图片上传注解
@WebServlet("/img")
public class ImgServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("url");
        /*文件上传后的路径和名称*/
        String str = "C:\\Users\\Administrator\\IdeaProjects\\cookieTest\\web\\img\\"+part.getSubmittedFileName();
        File file = new File(str);
        String url = str.substring(str.indexOf("img"));
        System.out.println(url);
        /*输出流 向指定位置写数据*/
        OutputStream os = new FileOutputStream(file);
        /*文件接收*/
        byte [] b = new byte[1024];
        InputStream is = req.getInputStream();
        int a = is.read(b,0,b.length);
        while (a != -1){
            os.write(b);
            a = is.read(b,0,b.length);
        }
        req.getRequestDispatcher("WEB-INF/pages/add.jsp").forward(req,resp);
         /*InputStream is = req.getInputStream();//获取字节流
        byte [] b = new byte[1024];
        is.read(b);
        File file = new File("");//图片存储路径
        part.getSubmittedFileName();//获取上传图片文件名*/

}
}
