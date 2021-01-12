<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>未登录</title>

    <#include "../comm/common.ftlh">

<#--    <link rel="stylesheet" href="${rootPath}/css/login/framelogin.css">
    <script type="text/javascript" src="${rootPath}/js/login/framelogin.js"></script>-->
</head>

<script type="text/javascript">
    $(function(){
        if (window.top != window.self) {
            location.href = location.href.substr(0,location.href.indexOf("/"))+"/frameLogin";
        }else{
            window.location.href=location.href.substr(0,location.href.indexOf("/"))+"/loginPage";
        }
    });
</script>

<body>
</body>
</html>