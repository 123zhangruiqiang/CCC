<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/11
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input id="btn" type="button" value="测试">
</body>

<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script>
    data={list:"hjahahha"};
    $("#btn").click(function (){

        $.ajax({

            url:"dohttp/1",
            type:"GET",
            dataType:"text",
            success:function (data) {
                alert("success");
            },
            error:function (data) {
                alert("error");
            }


        });


    });

</script>
</html>
