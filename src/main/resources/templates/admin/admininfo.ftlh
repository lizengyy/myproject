<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>我的信息</title>

    <#include "../comm/frameworktools.ftlh">

</head>
<body>

<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

    <table>
        <tr>
            您好，${UserInfo.name}
        </tr>
        <tr>
            <td>账号:</td>
            <td>${UserInfo.user}</td>
        </tr>
        <tr>
            <td>状态:</td>
            <td>${state}</td>
        </tr>
        <tr>
            <td>部门:</td>
            <td>${PartName}</td>
        </tr>
        <tr>
            <td>入会时间:</td>
            <td>${UserInfo.crtDate}</td>
        </tr>
        <tr>
            <td>会龄:</td>
            <td>${Age}</td>
        </tr>
        <div id="chgInputTr" class="css-hide">
            <tr>
                <td>旧密码:</td>
                <td><input id="opwd" type="password" maxlength="64"></td>
            </tr>
            <tr>
                <td>新密码:</td>
                <td><input id="npwd" type="password" maxlength="64"></td>
            </tr>
            <tr>
                <td>新密码确认:</td>
                <td><input id="cpwd" type="password" maxlength="64"></td>
            </tr>
            <tr>
                <td>新密码确认:</td>
                <td><input id="cpwd" type="password" maxlength="64"></td>
            </tr>
        </div>
        <tr>
            <td id="chgBtnTd"><input type="button" value="修改密码" onclick="chgPwd()"></td>
            <td id="submitChgTd"class="css-hide"><input type="button" value="确认修改" onclick="chgPwdSubmit()"></td>
        </tr>
    </table>

</div>

<script type="text/javascript" src="/js/admin/admin.js"></script>

</body>
</html>