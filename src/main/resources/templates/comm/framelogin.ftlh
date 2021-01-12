<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>登录！</title>

    <#include "common.ftlh">

    <link rel="stylesheet" href="${rootPath}/css/login/framelogin.css">
    <script type="text/javascript" src="${rootPath}/js/login/login.js"></script>
</head>

<body>
<div class="container-fluid top-padd">
    <div class="col-md-12">
        <div class="contact-form">
            <img src="/img/login/point.jpg" alt="" class="avatar">
            <h2>掉线啦</h2>
            <form id="loginForm" name="loginForm" action="">
                <p>账号：</p>
                <input id="userName" name="userName" type="text" placeholder="例行检查，报上名来">
                <p>密码：</p>
                <input id="pwd" name="pwd" type="password" placeholder="还记得口令是啥不" onblur="toSecret(this)">
                <#if errMsg?exists>
                    <p id="err-msg" name="err-msg" style="color: red">${errMsg}</p>
                <#else>
                    <p id="err-msg" name="err-msg" style="color: red">&nbsp;</p>
                </#if>
                <input type="button" value="走你~" onclick="reLogin()">
                <p><input id="storeBtn" name="storeBtn" type="checkbox" onchange="storeUserInfo()"/>下回来还认得你</p>
            </form>
        </div>
    </div>
</div>
</body>
</html>