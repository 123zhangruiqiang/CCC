<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/18
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

        <button id="but">hahaha</button>
</body>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
    var data=[

        {
            "username":"zhangruiqiang",
            "password":"898989"
        },
        {
            "username":"zhenghuiwen",
            "password":"12354"
        },
        {
            "username":"zhang",
            "password":"xiaona"
        }

    ]
    var poj={"data":JSON.stringify(data)};
   /* $("#but").onclick(function () {

            $.ajax({
                url:"testajax",
                type:"post",
                dataType:"json",
                data:poj,
                success:function(data){
                    alert("success");
                },
                error:function(data){
                    alert("error");
                }



            });


    });
*/
    $("#but").click(function () {

        $.ajax({
            url:"testajax",
            type:"POST",
            data:poj,
            dataType:"json",
            success:function(data){
                alert("success");
                alert(data[0]['userid']);
            },
            error:function (data){
                alert("failed");
            }



        });

    });

</script>
</html>
