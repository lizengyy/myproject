<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">

    <#--重登录遮罩层组件样式/js-start-->
    <link rel="stylesheet" href="${rootPath}/css/login/framelogin.css">
    <script type="text/javascript" src="${rootPath}/js/login/login.js"></script>
    <#--重登录遮罩层组件样式/js-end-->

</head>

<body>

<div id="cover-div" class="cover-div">
</div>

<div id="relogin-div" class="relog-form">
    <img src="/img/login/point.jpg" alt="" class="relog-avatar">
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

<div id="msg-err" class="col-xs-4 col-sm-4 col-md-4 col-lg-4 top-div">
</div>

</body>
<script type="text/javascript">
    function reLogin(){
        $("#cover-div").show();
        $("#relogin-div").show();
    }
    function reLogSuccess(){
        $("#cover-div").hide();
        $("#relogin-div").hide();
    }
</script>
</html>