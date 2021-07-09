<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>系统菜单设置</title>

    <#include "../comm/frameworktools.ftlh">
    <#include "../comm/menutree.ftlh">

    <style>
    </style>

</head>
<body>

<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 floatl fitfull">
    <!-- 调用宏 生成递归树 -->
    <@menuTree childrenList=MenuTree />
</div>
<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8 floatl fitfull">操作区域</div>

<script type="text/javascript" src="/js/admin/menumanage.js"></script>

</body>
</html>