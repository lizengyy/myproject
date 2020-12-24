<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>欢迎欢迎！热烈欢迎！</title>

    <#include "./comm/common.ftlh">

    <link rel="stylesheet" href="css/login/login.css">
    <script type="text/javascript" src="/js/login/login.js"></script>
</head>

<body>
<div class="container-fluid top-padd">
    <div class="col-md-12">
        <div class="contact-form">
            <img src="/img/login/point.jpg" alt="" class="avatar">
            <h2>来者何人</h2>
            <form id="loginForm" name="loginForm" method="post" action="/login" onsubmit="return toVaild()">
                <p>账号：</p>
                <input id="userName" name="userName" type="text" placeholder="你的账号是啥">
                <p>密码：</p>
                <input id="pwd" name="pwd" type="password" placeholder="输入我悄悄告诉你的密码" onblur="toSecret(this)">
                <#if errMsg?exists>
                    <p id="err-msg" name="err-msg" style="color: red">${errMsg}</p>
                <#else>
                    <p id="err-msg" name="err-msg" style="color: red">&nbsp;</p>
                </#if>
                <input type="submit" value="咻~">
                <p><input id="storeBtn" name="storeBtn" type="checkbox" onchange="storeUserInfo()"/>下回来还认得你</p>
            </form>
        </div>
    </div>
</div>
</body>
</html>