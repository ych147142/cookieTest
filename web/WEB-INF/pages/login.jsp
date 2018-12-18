<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/10
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
    
    </style>
  </head>
  <body>
  <form action="doLogin" method="post">
    用户名：<input type="text" name="username" id="uname">
    密码：<input type="password" name="pwd" id="pwd">
    <input type="submit" value="提交" id="btn">
  </form>
  <%--<script src="js/jquery-3.3.1.min.js"></script>
  <script>
    $(function () {
        $("#btn").click(function () {
            var fm = $("#fm").serialize();
            $.ajax({
                url:"doLogin",
                type:"post",
                data:fm,
                success:function (data) {
                    if (data == "1"){
                        alert("登录成功");
                        window.location.href="http://localhost:8080/ajaxTest/list"
                    }
                    if (data == "3"){
                        alert("密码错误");
                    }

                }

            });
        })
    })

  </script>--%>
  </body>
</html>
