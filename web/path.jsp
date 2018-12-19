<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/19
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        String path ="";
        if (request.getServerPort() == 80){
            path = request.getScheme()+"://"+request.getServerName()+request.getContextPath();
        }else {
            path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        }
        pageContext.setAttribute("path",path);
        /*System.out.println(request.getScheme()); 协议名
        System.out.println(request.getServerName()); 本地IP
        System.out.println(request.getServerPort()); 端口号
        System.out.println(request.getContextPath()); 项目名*/

    %>

