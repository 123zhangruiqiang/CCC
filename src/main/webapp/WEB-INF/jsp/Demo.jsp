<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/4
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <form action="">
            <input type="text" value="haha" id="username">
            <input type="password" value="123" id="password">
            <input type="button" id="btn" value="提交">

        </form>

</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script>
    var username=$("#username").attr("value");
    var password=$("#password").attr("value");
    var dt={};
    dt.username=username;
    dt.password=password;

    $("#btn").click(function () {

        $.ajax({

            url:"login",
            type:"POST",
            dataType:"json",
            data:dt,
            success:function(data){
                alert("success");
                alert(data.username);
            },
            error:function(data){
                alert("faild");
            }



        });







    });


</script>
</html>
