<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>欢迎欢迎！热烈欢迎！</title>

    <#include "./comm/common.ftlh">

    <link rel="stylesheet" href="css/login/login.css">
    <script type="text/javascript" src="/js/login/login.js"></script>

    <script type="text/javascript">
        $("#saveUserInfo").click(function() {
            var formObject = {};
            var formArray =$("#loginForm").serializeArray();
            $.each(formArray,function(i,item){
                formObject[item.name] = item.value;
            });
            $.ajax({
                url:"/login",
                type:"post",
                // contentType: "application/json; charset=utf-8",
                data: formObject,//JSON.stringify(formObject),
                // dataType: "json",
                success:function(data){
                    alert(data.msg);
                },
                error:function(e){
                }
            });
        });
    </script>
</head>
<body>
<div class="contact-form">
    <img src="/img/login/point.jpg" alt="" class="avatar">
    <h2>来者何人！</h2>
    <form id="loginForm" name="loginForm" method="post" action="/login">
        <p>账号：</p>
        <input id="userName" name="userName" type="text" placeholder="你的账号是啥">
        <p>密码：</p>
        <input id="pwd" name="pwd" type="password" placeholder="输入我悄悄告诉你的密码">
        <#if errMsg?exists>
            <p style="color: red">${errMsg}</p>
        </#if>
        <input type="submit" value="咻~">
        <p><input id="storeBtn" type="checkbox" onchange="storeUserInfo()"/>下回来还认得你</p>
    </form>
</div>
</body>
</html>