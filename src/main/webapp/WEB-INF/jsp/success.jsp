<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
    <style>

        a{
            display:inline-block;
            height:40px;
            line-height: 40px;
        }

    </style>
</head>
<body>

<input type="button" id="btn" value="修改"> <a href="#" id="a">${requestScope.filepath}</a>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
        var file=$("a").text();
        $("#btn").click(function () {

                $.ajax({
                            url:"update",
                            type:"GET",
                            data:"filename="+file,
                            dataType:"text",
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