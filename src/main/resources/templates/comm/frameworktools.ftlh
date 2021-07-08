<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">

    <#include "../comm/common.ftlh">

    <link rel="stylesheet" href="${rootPath}/css/frameworktools/frameworktools.css">

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
        <img id="confirm-btn" src="/img/btn/queren.svg" alt="" class="btn-icon">
        <img src="/img/btn/cancel.svg" alt="" class="btn-icon" onclick="okey('msg-confirm');">
    </div>
</div>

<!-- 递归  宏定义 -->
<#macro menuTree childrenList>
    <#if childrenList?? && childrenList?size gt 0>
        <#list childrenList as child>
            <#if child.menuSecond?? && child.menuSecond?size gt 0>
                <li class="treeview">
                    <a href="javascript:void(0)">
                        <i class="" aria-hidden="true"></i> <span>${child.menuName}</span>
                        <i class="fa fa-angle-left pull-right" aria-hidden="true"></i>
                    </a>
                    <ul class="treeview-menu">
                        <@menuTree childrenList=child.menuSecond/>
                    </ul>
                </li>
            <#else>
                <li><a href="javascript:void(0)"><i class="" aria-hidden="true"></i> ${child.menuName}</a></li>
            </#if>
        </#list>
    </#if>
</#macro>

<script type="text/javascript" src="${rootPath}/js/login/login.js"></script>
<script type="text/javascript" src="/js/comm/frametools.js"></script>
</body>
</html>