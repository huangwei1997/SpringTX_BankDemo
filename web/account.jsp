<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/24
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转账页面</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        //页面加载成功添加响应的事件
        $(function () {
            //校验转账账户信息
            $("#outPwd").blur(function () {
                //发起ajax请求
                $.get("/SpringTX_BankDemo/transfer",{oper:"out",outId:$("#outId").val(),outPwd:$("#outPwd").val()},function (data) {
                    //获取span对象
                    var span = $("#outPwdSpan");
                    if(eval(data)){
                        span.html("√").css("color","green").addClass("success").removeClass("error");
                    }else{
                        span.html("×").css("color","red").addClass("error").removeClass("success");
                    }
                });
            })
            //校验转账金额
            $("#money").blur(function () {
                //发起ajax请求
                $.get("/SpringTX_BankDemo/transfer",{oper:"money",outId:$("#outId").val(),outPwd:$("#outPwd").val(),money:$("#money").val()},function (data) {
                    //获取span对象
                    var span = $("#moneySpan");
                    if(eval(data)){
                        span.html("√").css("color","green").addClass("success").removeClass("error");
                    }else{
                        span.html("×").css("color","red").addClass("error").removeClass("success");
                    }
                });
            })
            //检验入账账户信息
            $("#inName").blur(function () {
                //发起ajax请求
                $.get("/SpringTX_BankDemo/transfer",{oper:"in",inId:$("#inId").val(),inName:$("#inName").val()},function (data) {
                    //获取span对象
                    var span = $("#inNameSpan");
                    if(eval(data)){
                        span.html("√").css("color","green").addClass("success").removeClass("error");
                    }else{
                        span.html("×").css("color","red").addClass("error").removeClass("success");
                    }
                });
            })
            //转账
            $("#fm").submit(function () {
                $("#outPwd,#money,#inName").trigger("blur");
                if($(".error").length>0){
                    return false;
                }else{
                    return true;
                }
            })
        })
    </script>
</head>
<body>
    <h3>银行转账</h3>
    <hr/>
    <form action="/SpringTX_BankDemo/transfer" method="post" id="fm" >
        <input type="hidden" name="oper" value="transfer">
        转账账户：<input type="text" name="outId" value="" id="outId"/><br/>
        账户密码：<input type="password" name="outPwd" value="" id="outPwd" /><span id="outPwdSpan"></span><br/>
        转账金额：<input type="text" name="money" id="money" value="" /><span id="moneySpan"></span><br/>
        入账账户：<input type="text" name="inId" id="inId" value="" /><br/>
        账户名称：<input type="text" name="inName" id="inName" value=""><span id="inNameSpan"></span><br/>
        <input type="submit" id="sub" value="转账" />
    </form>
</body>
</html>
