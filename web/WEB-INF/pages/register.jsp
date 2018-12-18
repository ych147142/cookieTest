<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/12
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="doRegister">
        用户名：<input type="text" name="username" id="uname" class="AC"><span id="message"></span><br>
        密码：<input type="password" name="pwd" id="pwd"><br>
        确认密码: <input type="password" name="pwds" class="AC"><span id="pmes"></span> <br>
        电话：<input type="text" name="tele" id="tele" class="AC"><br>
        <input type="button" value="注册" disabled="disabled" id="btn" >
    </form>

    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">

        $(function () {
            /*使用ajax*/
            var un ;
            var pwd;
            var pwds;
            var tele;
            $(".AC").blur(function () {
                un = $("#uname").val();
                pwd = $("#pwd").val();
                pwds = $("#pwds").val();
                tele = $("#tele").val();
                $.ajax({
                    url:"doRegister",
                    type:"get",
                    data:{"uname":un,"pwd":pwd,"pwds":pwd,"tele":tele},
                    success:function(result){
                        console.log(result);
                        if(result == "4"){
                            $("#message").text("✔");
                        }
                        if (result == "43"){
                            $("#message").text("✔");
                            $("#pmes").text("✔");
                            $("#btn").attr("disabled",false);
                        }
                        if (result == 1){
                            $("#message").text("用户已存在");
                        }
                        if(result == "42"){
                            $("#pmes").text("密码不一致");
                        }
                    }
                })
            });

            $("#btn").click(function () {
               $.ajax({
                   url:"doIt",
                   type:"post",
                   data:{"uname":un,"pwd":pwd,"pwds":pwd,"tele":tele},
                   success:function (data) {
                       if (data > 0){
                           alert("注册成功")
                            window.location.href="http://localhost:8080/ajaxTest/login"
                       }
                   }
               });
            });
        });

    </script>
</body>
</html>
