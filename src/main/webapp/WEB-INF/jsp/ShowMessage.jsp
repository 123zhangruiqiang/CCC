
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>修改页面</title>
</head>
<body>

<h5>${requestScope.filename}</h5>
<input type="button" value="修改数据" id="but">
<div id="message"></div>


</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
        var file=$("h5").html();

        $("#but").click(function (){

                $.ajax(
                    {

                        url:"update",
                        type:"GET",
                        dataType:"text",
                        success:function(data){
                            alert("success");

                            var dataObject=JSON.parse(data);
                            $.each(dataObject,function (index,item){
                                var userid=dataObject[index].userid;
                                var data=dataObject[index].date;
                                var time=dataObject[index].time;
                                var money=dataObject[index].money;
                                var token1=dataObject[index].token1;
                                var token2=dataObject[index].token2;
                                $("#message").append("<div>商户编号：<input name='userid' type='text' value="+userid+" /> 交易日期：<input name='data' type='date' value="+data+" />" +
                                    "<input name='time' type='time' value="+time+" />" +
                                    "交易金额度：<input name='money' type='text' value="+money+" />" +
                                        "交易编码1：<input name='token1' type='text' value="+token1+" />"+
                                        "交易编码2：<input name='token2' type='text' value="+token2+" /></div>"

                                    );

                            }


                            );
                            $("#message").append("<input id='update' type='button' value='提交' onclick='subfile()' />");

                        },
                        error:function(data){
                            alert("faild");
                        }






                    }




                );


        });


        function subfile(){

            alert('hahhaha');
            var name=$("input[name='userid']");
            var date=$("input[name='data']");
            var time=$("input[name='time']");
            var money=$("input[name='money']");
            var token1=$("input[name='token1']");;
            var token2=$("input[name='token2']");;
        var msg=[]

        for(var i=0;i<name.length;i++){
              var ms={"text_name":file,"userid":name[i].value,"date":date[i].value,"time":time[0].value,"money":money[i].value,"token1":token1[i].value,"token2":token2[i].value};
                msg.push(ms);
                console.log(JSON.stringify(msg));
        }


            $.ajax({


                url:"updateFile",
                cache:false,
                asyn:false,
                type:"POST",
                dataType:"json",
                data:{sfc:JSON.stringify(msg)},
                success:function(data){
                    alert("success");
                },
                error:function(data){
                    alert("error");
                }


            });










            // toupfile(msg);
        }

        function toupfile(msg){

            $.ajax({


                url:"updateFile",
                type:"POST",
                dataType:"json",
                data:msg,
                success:function(data){
                    alert("success");
                },
                error:function(data){
                    alert("error");
                }


            });

        }


      /*  $("#update").click(function () {

            alert("break");
           alert("hahaha");

           $.ajax({

               url:"makeFile",
               type:"POST",
               dataType:"json",
               success:function(data){
                   alert("success");
               },
               error:function (data) {
                   alert("faild");
               }



           });


        });

*/

</script>
</html>
