<%@ page import="java.util.List" %>
<%@ page import="com.neuedu.pojo.Product" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/12
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: 1px #000 solid;
            border-collapse: collapse;
        }
        table thead tr th ,table tbody tr td{
            border: 1px #000 solid;
            padding: 5px 10px;
        }
        table tbody tr:nth-child(odd){
            background-color: antiquewhite;
        }
    </style>
</head>
<body>

    <form action="exit">
        欢迎${user.username}
        <input type="submit" value="退出">
    </form>

    <table>
        <thead>
            <tr>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品图片</th>
                <th>商品详情</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <%--tl--%>
            <c:forEach items="${lists}" var="p">
                <tr>
                    <td>${p.productId}</td>
                    <td>${p.productName}</td>
                    <td>${p.price}</td>
                    <td><img src="${p.url}"></td>
                    <td>${p.productDes}</td>
                    <td><a href="delete?productId=${p.productId}">删除</a>|<a href="update?productId=${p.productId}">修改</a></td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
    <a href="add"><input type="button"value="添加"></a>

</body>
</html>
