<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style>
*{
	margin:0;
	padding:0;
}
input{
width:100px;

}
</style>
</head>
<body>


<form name="form" action=<%=request.getContextPath()%>/makeFile id ='form1'>

		文件名称：<input type="text" name="filename" value="XMTest_b01"/><br>

		<div style="float: left;margin-right:20px;overflow:hidden;">
		用户编号：<input type="text" name="userid" id="number" value="3000000001"/>
			<input type="text" name="userid" id="number" value="3000000002"/>
		交易日期：<input type="date" name="date"/> 
		<input type="time" name="time">
		交易金额：<input type="text" name="money">
		交易编码1：<input type="text" name="token1" value="fffffffffffffff">
		交易编码2：<input type="text" name="token2" value="mmmmmmmmmmmmmmm">
		
		</div>
		<div style="float: left;overflow:hidden;">
		
		<input type="button" value="添加" id="btn">
		<input type="submit" value="提交" id="sub" >
		</div><br>


</form>

</body>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">





	var btn=document.getElementById("btn");
	var sub=document.getElementById("sub");
	var flag=1;
	
	function check(){
		

		//document.getElementById("form1").submit();
	/* 	
		for(var i=1;i<=flag;i++){
			var userid=document.getElementById(userid);
		}
// 		console.log="zhangruiqinag";
		var list=document.getElementsByName("userid");
		for(var i = 0; i<list.length;i++)
		console.log(list[i].value);
// 	   var form1 =  document.getElememtById("form1");
// 	   if(1=1)
// 		   fom1.submit();
		return false; */
	}
	/* sub.onsubmit=function (){
		console.log="zhangruiqiang";
		
	} */
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