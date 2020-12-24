<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="SpringBoot FreeMaker"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>管理室</title>

    <#include "./comm/common.ftlh">

    <link rel="stylesheet" href="css/index/index.css">
    <script type="text/javascript" src="/js/index/index.js"></script>
</head>
<body>

<div class="container-fluid">

    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-light">

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <div class="navbar-brand">
                        管理室
                    </div>

                    <div class="navbar-expand-lg">
                        <#if MenuData?exists>
                            <#list MenuData as menu_list>
                                <ul class="navbar-nav">
                                    <#list menu_list as menu_o>
                                        <li class="dropdown-header">
                                            <#if menu_o.MenuSecond?exists>
                                                <a class="nav-link" href="#" id="${menu_o.MenuId}-link" data-toggle="dropdown">${menu_o.MenuName}</a>
                                                <div class="dropdown-menu" aria-labelledby="${menu_o.MenuId}-link">
                                                    <#list menu_o.MenuSecond as menu_s>
                                                        <a class="dropdown-item" href="#" id="${menu_s.MenuId}-link">${menu_s.MenuName}</a>
                                                    </#list>
                                                </div>
                                            <#else>
                                                <a class="nav-link" href="#" id="${menu_o.MenuId}-link" target-url="/welcome" onclick="addtab(this)" fun-name="${menu_o.MenuName}">
                                                    <img class="comm-icon" src="/img/icons/house-fill.svg" alt="${menu_o.MenuName}" title="${menu_o.MenuName}">
                                                </a>
                                            </#if>
                                        </li>
                                    </#list>
                                </ul>
                            </#list>
                        </#if>
                    </div>

                    <div class="navbar-collapse">
                        <input class="comm-input mr-sm-2" type="text" />
                        <img class="comm-icon" src="/img/icons/search.svg" alt="搜索" title="搜索">
                    </div>

                    <div class="ml-md-auto">
                        <ul class="navbar-nav">
                            <#if HelpMenu?exists>
                                <li class="nav-item">
                                    <a class="nav-link" href="#" id="${HelpMenu["MenuId"]}-link" >
                                        <img class="comm-icon help-icon" src="/img/icons/question-diamond.svg" alt="${HelpMenu["MenuName"]}"  title="${HelpMenu["MenuName"]}">
                                    </a>
                                </li>
                            </#if>
                            <#if UserMenu?exists>
                                <li class="nav-item">
                                    <a class="nav-link" href="#" id="${UserMenu["MenuId"]}-link" data-toggle="dropdown">
                                        <img class="comm-icon" src="/img/icons/people.svg" alt="${UserMenu["MenuName"]}" title="${UserMenu["MenuName"]}">
                                    </a>
                                    <#if UserMenu["MenuSecond"]??>
                                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="${UserMenu["MenuId"]}-link">
                                            <span class="welcome-tips">这不${UserName}嘛!欢迎欢迎!</span>
                                            <#list UserMenu["MenuSecond"] as menu_s>
                                                <a class="dropdown-item" href="#" id="${menu_s["MenuId"]}-link">${menu_s["MenuName"]}</a>
                                            </#list>
                                        </div>
                                    </#if>
                                </li>
                            </#if>
                        </ul>
                    </div>

                </div>
            </nav>

        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <!--添加tab页面 -->
            <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                <ul id="tab-ul" class="navbar-nav no-warp">
                </ul>

                <!-- tab页面的内容 -->
                <div id="tabcontent" class="tab-content">
                    <!--通过js获取 tab对应的页面内容-->
                </div>
            </div>

            <div id="iframe-div" class="iframe-div">
            </div>
        </div>
    </div>

</div>

</body>
</html>