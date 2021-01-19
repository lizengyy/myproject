<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">

    <#--重登录遮罩层组件样式/js-start-->
    <link rel="stylesheet" href="${rootPath}/css/frameworktools/frameworktools.css">
    <script type="text/javascript" src="${rootPath}/js/login/login.js"></script>
    <#--重登录遮罩层组件样式/js-end-->

</head>

<body>

<div id="cover-fixed" class="cover-fixed">
</div>

<div id="cover-div" class="cover-div">
</div>

<div id="relogin-div" class="relog-form">
    <img src="/img/login/point.jpg" alt="" class="relog-avatar">
    <h2>重新登录</h2>
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

<div id="msg-div" class="col-xs-4 col-sm-4 col-md-4 col-lg-4 top-div msg-div">
    <div class="msg-content">
        <span id="msg-div-text"></span>
    </div>
    <div class="msg-bottom">
        <img src="/img/btn/queren.svg" alt="" class="btn-icon" onclick="okey('msg-div');">
    </div>
</div>

<div id="msg-confirm" class="col-xs-4 col-sm-4 col-md-4 col-lg-4 top-div msg-div c-info">
    <div class="msg-content">
        <span id="msg-confirm-text"></span>
    </div>
    <div class="msg-bottom">
        <img src="/img/btn/queren.svg" alt="" class="btn-icon">
        <img src="/img/btn/cancel.svg" alt="" class="btn-icon">
    </div>
</div>

</body>
<script type="text/javascript">
    function reLogShow(){
        $("#cover-fixed").show();
        $("#relogin-div").show();
    }
    function reLogHide(){
        $("#cover-fixed").hide();
        $("#relogin-div").hide();
    }

    function popErrMsg(str){
        if (window.top != window.self) {
            window.self.$("#cover-div").show();
            window.self.$("#msg-div-text").text(str);
            window.self.$("#msg-div").removeClass("c-info");
            window.self.$("#msg-div").addClass("c-err");
            window.self.$("#msg-div").show();
        }else{
            $("#cover-fixed").show();
            $("#msg-div-text").text(str);
            $("#msg-div").removeClass("c-info");
            $("#msg-div").addClass("c-err");
            $("#msg-div").show();
        }
    }

    function popMsg(str){
        if (window.top != window.self) {
            window.self.$("#cover-div").show();
            window.self.$("#msg-div-text").text(str);
            window.self.$("#msg-div").removeClass("c-err");
            window.self.$("#msg-div").addClass("c-info");
            window.self.$("#msg-div").show();
        }else{
            $("#cover-fixed").show();
            $("#msg-div-text").text(str);
            $("#msg-div").removeClass("c-err");
            $("#msg-div").addClass("c-info");
            $("#msg-div").show();
        }
    }

    function okey(perfix){
        if (window.top != window.self) {
            window.self.$("#cover-div").hide();
            window.self.$("#"+perfix+"-text").text("");
            window.self.$("#"+perfix).hide();
        }else{
            $("#cover-fixed").hide();
            $("#cover-div").hide();
            $("#"+perfix+"-text").text("");
            $("#"+perfix).hide();
        }
    }

</script>
</html>