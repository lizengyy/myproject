<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>系统菜单设置</title>

    <#include "../comm/frameworktools.ftlh">

    <style>
    </style>

</head>
<body>

<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 floatl fitfull" style="background-color: #7b4451;">
    树形结构
    <ul>
        <!-- 递归  宏定义 -->
        <#macro bpTree children>
            <#if children?? && children?size gt 0>
                <#list children as child>
                    <#if child.children?? && child.children?size gt 0>
                        <li class="treeview">
                            <a href="javascript:void(0)">
                                <i class="${(child.mIcon=='')?string('fa fa-share',child.mIcon) }" aria-hidden="true"></i> <span>${child.mCname}</span>
                                <i class="fa fa-angle-left pull-right" aria-hidden="true"></i>
                            </a>
                            <ul class="treeview-menu">
                                <@bpTree children=child.children />
                            </ul>
                        </li>
                    <#else>
                        <li><a href="javascript:void(0)" onclick="loadContent('${child.mUrl}')"><i class="${ (child.mIcon=='')?string('fa fa-circle-o',child.mIcon) }" aria-hidden="true"></i> ${child.mCname}</a></li>
                    </#if>
                </#list>
            </#if>
        </#macro>
        <!-- 调用宏 生成递归树 -->
        <@bpTree children=treeMenu />
    </ul>
</div>
<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8 floatl fitfull" style="background-color: aquamarine;">操作区域</div>

<script type="text/javascript" src="/js/admin/menumanage.js"></script>

</body>
</html>