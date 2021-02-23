<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>我的信息</title>

    <#include "../comm/frameworktools.ftlh">

    <style>
        table{
            margin-left: 1rem;
        }
        table tbody td{
            padding: .2rem .5rem;
        }
        .top-tips {
            margin: 1rem 1rem;
            font-size: large;
        }
    </style>

</head>
<body>

<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
    <span class="top-tips">您好，${UserInfo.name}，个人信息如下，请勿泄露</span>
    <table>
        <tr>
            <td class="title-td">账号:</td>
            <td>${UserInfo.user}</td>
        </tr>
        <tr>
            <td class="title-td">状态:</td>
            <td>${state}</td>
        </tr>
        <tr>
            <td class="title-td">部门:</td>
            <td>${PartName}</td>
        </tr>
        <tr>
            <td class="title-td">入会时间:</td>
            <td>${UserInfo.crtDate}</td>
        </tr>
        <tr>
            <td class="title-td">会龄:</td>
            <td>${Age}</td>
        </tr>
        <tr class="chgInput css-hide">
            <td class="title-td">旧密码:</td>
            <td><input id="opwd" type="password" maxlength="64" class="comm-input mr-sm-2"></td>
        </tr>
        <tr class="chgInput css-hide">
            <td class="title-td">新密码:</td>
            <td><input id="npwd" type="password" maxlength="64" class="comm-input mr-sm-2"></td>
        </tr>
        <tr class="chgInput css-hide">
            <td class="title-td">新密码确认:</td>
            <td><input id="cpwd" type="password" maxlength="64" class="comm-input mr-sm-2"></td>
        </tr>
        <tr id="chgErrTr" class="css-hide"><td id="chgErrTd" class="err-tips" colspan="2"></td></tr>
        <tr>
            <td id="chgBtnTd"><input type="button" value="修改密码" class="comm-btn" onclick="chgPwd()"></td>
            <td id="submitChgTd"class="css-hide"><input type="button" value="确认修改" class="comm-btn" onclick="chgPwdSubmit()"></td>
        </tr>
    </table>

</div>

<script type="text/javascript" src="/js/admin/admin.js"></script>

</body>
</html>