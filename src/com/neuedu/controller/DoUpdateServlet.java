package com.neuedu.controller;


import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import com.neuedu.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doUpdate")
public class DoUpdateServlet extends HttpServlet {
    private IProductService service = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =  Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String url = req.getParameter("url");
        double price = Double.parseDouble(req.getParameter("price"));
        String des = req.getParameter("des");
        Product p = new Product();
        p.setPrice(price);
        p.setProductDes(des);
        p.setProductName(name);
        p.setUrl(url);
        p.setProductId(id);
        service.update(p);
        resp.sendRedirect("list");
    }
}
