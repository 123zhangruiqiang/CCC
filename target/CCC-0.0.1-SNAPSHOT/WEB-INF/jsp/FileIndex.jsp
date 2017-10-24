<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css">
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
</style>
</head>
<body>

<div id="content">

<div class="head">
	<div class="top"></div>
	<div class="nav">
		<ul>
			<li><a href="">生成压缩文件</a></li>
			<li><a href="${pageContext.request.contextPath}/JFlc">计费流程执行</a></li>
			<li><a href="">测试3</a></li>
			<li><a href="">测试4</a></li>
		</ul>

	</div>


</div>
<div>
<form name="form" action=<%=request.getContextPath()%>/makeFile id ='form1'>
		<table id="tab" class="table table-striped table-hover table-bordered">
			<option value=""><span class="span">文件名称：</span><input  type="text" class="input-medium" name="filename" value="XMTest_b01"/>
				<input type="button" class="btn btn-info " value="添加" id="btn1">
				<input type="submit"  class="btn btn-active" value="提交" id="sub1" >

			</option>
			<tbody>
			<tr>
				<th>用户编号</th>
				<th>交易日期</th>
				<th>交易金额</th>
				<th>交易编码1</th>
				<th>交易编码2</th>
			</tr>
			<tr>
				<td><input type="text" name="userid" id="number" value="3000000001"/></td>
				<td><input type="date" name="date"/><input type="time" name="time"> </td>
				<td><input type="text" name="money"></td>
				<td><input type="text" name="token1" value="fffffffffffffff"></td>
				<td><input type="text" name="token2" value="mmmmmmmmmmmmmmm"></td>

			</tr>

			</tbody>

		</table>



</form>
</div>
</br>
<div id="bar">
<ul>
	<li><a href="${pageContext.request.contextPath}/index/dohttp" id="renwu">创建下载任务</a></li>
	<li><a href="${pageContext.request.contextPath}/index/download">下载计费任务</a></li>
	<li><a href="${pageContext.request.contextPath}/index/fee">执行扣费任务</a></li>
	<li><a href="${pageContext.request.contextPath}/index/Bill">生成计费账单</a></li>
	<li><a href="${pageContext.request.contextPath}/index/kf">生成扣费账单</a></li>
	<li><a href="${pageContext.request.contextPath}/index/zxkf">执行扣费任务</a></li>
	<li><a href="${pageContext.request.contextPath}/index/kf">获取状态更新</a></li>
</ul>
</div>


</div>

<div class="panel panel-default">
	<div class="panel-body">
		Panel content
	</div>

</div>

</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">


	var btn1=document.getElementById("btn1");
	var sub1=document.getElementById("sub1");


	btn1.onclick=function (){
        	var arr=new Array();
        	arr[0]="用户编号：";
        	arr[1]="交易日期：";
        	arr[2]="交易时间:";
        	arr[3]="交易金额：";
        	arr[4]="交易编码1：";
        	arr[5]="交易编码2：	";
			var table=document.getElementById("tab");
						var tr=document.createElement("tr");
						var tbody=document.getElementsByTagName("tbody")[0];
						for(var i=0;i<arr.length;i++){

							var input=document.createElement("input");
							var input1=document.createElement("input")
							var td=document.createElement("td");

							//input.style.marginRight="10px";

							switch (i) {
								case 0:
									input.setAttribute("name","userid");
									input.setAttribute("value","3000000001");

									break;
								case 1:
									input.setAttribute("name","date");
									input1.setAttribute("name","time");
									break;
								case 3:
									input.setAttribute("name","money");
									break;
								case 4:
									input.setAttribute("name","token1");
									break;
								case 5:
									input.setAttribute("name","token2");
							}



							if(arr[i].indexOf("交易日期")>=0){
								input.setAttribute("type","date");
								input1.setAttribute("type","time");
							}else{
								input.setAttribute("type","text");
							}
							if(i==4||i==5){
								input.setAttribute("value","fffffffffffffffff");
							}
							if(i==1){
								td.appendChild(input);
								td.appendChild(input1);
								tr.appendChild(td);
							}else if(i!=2){
							td.appendChild(input);
							tr.appendChild(td);
                            }

            }
           // tab.appendChild(tr);
			var i=Math.random();
			var color=["active","info","success","warning","danger"];
			console.log(i);
			console.log(Math.round(i*10/2));
			var j=Math.round(i*10/2);
			tr.setAttribute("class",color[j]);
			tbody.appendChild(tr);


	}


	var btn=document.getElementById("btn");
	var sub=document.getElementById("sub");
	var flag=1;
	

	btn.onclick=function(){

		var form=document.getElementsByName("form");
		var div=document.createElement("div");
		
		div.style.marginTop="10px";
		
		
		var arr=new Array();
		arr[0]="用户编号：";
		arr[1]="交易日期：";
		arr[2]="交易时间:";
		arr[3]="交易金额：";
		arr[4]="交易编码1：";
		arr[5]="交易编码2：	";
		
		for(var i=0 ;i<arr.length;i++){
			var input=document.createElement("input");
			var span=document.createElement("span");
			span.innerHTML=arr[i];
			input.style.marginRight="10px";

			switch (i) {
			case 0:
				input.setAttribute("name","userid");
				input.setAttribute("value","3000000001");
				break;
			case 1:
				input.setAttribute("name","date");
				break;
			case 2:
				input.setAttribute("name","time");
				break;
			case 3:
				input.setAttribute("name","money");
				break;
			case 4:
				input.setAttribute("name","token1");
				break;
			case 5:
				input.setAttribute("name","token2");
			}
			
			
			
			if(arr[i].indexOf("交易日期")>=0){
				input.setAttribute("type","date");
			}else{
			input.setAttribute("type","text");
			}
			
			if(i==4||i==5){
				input.setAttribute("value","fffffffffffffffff");
			}
			if(arr[i].indexOf("交易时间")>=0){
				input.setAttribute("type","time");
			}else{
			div.appendChild(span);
			}
			div.appendChild(input);
			
		}
		form[0].appendChild(div);
		flag++;

	}
		//alert(document.getElementsByName("pre")[0].innerHTML);

</script>

</html>