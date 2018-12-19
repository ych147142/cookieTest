<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/13
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="doAdd" method="post" enctype="multipart/form-data">
      商品名称：<input type="text" name="name"><br>
      商品价格：<input type="text" name="price"><br>
      商品图片：<input type="file" name="url" onchange="imgChange(this)"> <br>
        <img id="img" height="100" width="100"> <br>
        商品描述：<input type="text" name="des"><br>

        <input type="submit" value="添加">
    </form>
    <script type="text/javascript">
        function imgChange(obj) {
            if ((obj.files[0].name).substring((obj.files[0].name).indexOf(".") + 1) =="png" || (obj.files[0].name).substring((obj.files[0].name).indexOf(".") + 1) =="jpg" ){
                console.log(obj.files[0].name);
                /*文件读取器*/
                var reader = new FileReader();
                console.log(reader);
                reader.onload = function (ev) {
                    var img = document.getElementById("img")
                    img.src = ev.target.result;
                }
                reader.readAsDataURL(obj.files[0]);
            }else {
                alert("图片格式不正确，请重新选择")
                img.src = "";
            }

        }
    </script>
</body>
</html>
