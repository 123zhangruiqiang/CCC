<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/13
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <style>
        *{
            margin:0;
            padding:0;
        }

        body{

        }
        #content{
            width:1080px;
            margin: 0 auto;


        }
        input{
            width:100px;

        }
        ul li{
            list-style: none;
            margin-left: 20px;
            margin-top:10px;
            float: left;
            margin-bottom: 10px;
        }
        #bar ul li a {
            text-decoration: none;
            color:#444444;
            display: inline-block;
            width:100px;
            height:32px;
            line-height: 32px;
        }
        #bar ul li a:hover{
            background:#0A7EC3;
            color:white;
        }
        #bar{
            overflow: hidden;
            background:#00B0E7;


        }

        .head,.nav{
            overflow: hidden;

        }
        .nav{
            background: #033851;
            box-shadow: 0px 5px 3px #033851;
        }
        .nav ul li{
            margin-left: 50px;
            text-align: center;
        }
        .nav a{
            display: inline-block;
            height:40px;
            text-align: center;
            line-height: 40px;
            color: darkgray;
            text-decoration: none;
            padding-right: 10px;
            padding-left: 10px;
        }
        .nav a:hover{

            color: white;
        }
        .head	.top{
            width:100%;
            height:20px;
            background: #033851;
        }


        .cen button{
            margin-right: 15px;
        }
        #mes{
            margin-top:10px;
            width:1080px;
            margin:0 auto;
            padding: 10px 20px;
        }
    </style>
</head>
<body>
<div id="content">

    <div class="head">
        <div class="top"></div>
        <div class="nav">
            <ul>
                <li><a href="${pageContext.request.contextPath}/index">生成压缩文件</a></li>
                <li><a href="#">计费流程执行</a></li>
                <li><a href="">测试3</a></li>
                <li><a href="">测试4</a></li>
            </ul>

        </div>


    </div>
    <div>
        <div class="cen">

            <button id="btn1" class="btn">创建下载任务</button>
            <button id="btn2" class="btn">下载计费任务</button>
            <button id="btn3" class="btn">执行扣费任务</button>
            <button id="btn4" class="btn">生成计费账单</button>
            <button id="btn5" class="btn">生成扣费账单</button>
            <button id="btn6" class="btn">执行扣费任务</button>
            <button id="btn7" class="btn">获取状态更新</button>
            
        </div>


        <div id="mes">


        </div>


    </div>

</div>
</body>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">

    $("#btn1").click(function () {

        $.ajax({
            url:"index/dohttp1",
            type:"GET",
            dataType:"text",
            success:function (data) {
                console.log(data);
                $("#btn1").addClass("btn-success");

                var value=$("#btn1").html();
                console.log(value);
                //var div=document.getElementById("mes");
                showMessage(data,value);



                /*showMessage(JSON.stringify(data));
                alert("success");*/
            },
            error:function (data) {
                alert("false");
            }



        });

    });

    $("#btn2").click(function () {

        $.ajax({
            url:"index/download1",
            type:"GET",
            dataType:"text",
            success:function (data) {
                console.log(data);
                $("#btn2").addClass("btn-success");
                showMessage(data);
            },
            error:function (data) {
                alert("false");
            }



        });

    });
    $("#btn3").click(function () {

        $.ajax({
            url:"index/fee1",
            type:"GET",
            dataType:"text",
            success:function (data) {

                $("#btn3").addClass("btn-success");
                showMessage(data);
            },
            error:function (data) {
                alert("false");
            }



        });

    });
    $("#btn4").click(function () {

        $.ajax({
            url:"index/Bill1",
            type:"GET",
            dataType:"text",
            success:function (data) {
                $("#btn4").addClass("btn-success");
                showMessage(data);
            },
            error:function (data) {
                alert("false");
            }



        });

    });
    $("#btn5").click(function () {

        $.ajax({
            url:"index/kf1",
            type:"GET",
            dataType:"text",
            success:function (data) {
                $("#btn5").addClass("btn-success");
                showMessage(data);
            },
            error:function (data) {
                alert("false");
            }



        });

    });
    $("#btn6").click(function () {

        $.ajax({
            url:"index/zxkf1",
            type:"GET",
            dataType:"text",
            success:function (data) {
                $("#btn6").addClass("btn-success");
                showMessage(data);
            },
            error:function (data) {
                alert("false");
            }



        });

    });
    $("#btn7").click(function () {

        $.ajax({
            url:"index/kf1",
            type:"GET",
            dataType:"text",
            success:function (data) {
                $("#btn7").addClass("btn-success");
                showMessage(data);
            },
            error:function (data) {
                alert("false");
            }



        });

    });

    function showMessage(response,value){

        var div=document.getElementById("mes");
        div.style.background="#F0F0F0";
        var div1=document.createElement("div");
        div1.style.marginTop="5px";
        var panel=document.createElement("h3");
        var obj=JSON.parse(response);
        var status=obj['success'];
        if(status){
            panel.style.color="blue";

        }else {
        panel.style.color="red";
        }
        panel.style.background="white";
        panel.style.border="1px solid dark";
        panel.innerHTML=value+":"+response;
        panel.style.boxShadow="1px 3px #E0E0E0";
        div1.appendChild(panel);
        div.appendChild(div1);


    }
</script>
</html>
