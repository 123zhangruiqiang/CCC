<%--
  Created by IntelliJ IDEA.
  User: zhangruiqiang
  Date: 2017/11/1
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>

    <meta charset="UTF-8">
</head>
<body>
        <div>
            <form action="${pageContext.request.contextPath}/doFile1" method="post" enctype="multipart/form-data">
                <input type="file" name="file">选择文件
                <input type="submit" value="上床">
            </form>

        </div>

</body>
</html>
