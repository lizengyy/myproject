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
                                            <#if menu_o.menuType==2>
                                                <a class="nav-link" href="#" id="${menu_o.menuId}-link" target-url="/welcome" onclick="addtab(this)" fun-name="${menu_o.menuName}">
                                                    <img class="comm-icon" src="/img/icons/house-fill.svg" alt="${menu_o.menuName}" title="${menu_o.menuName}">
                                                </a>
                                            <#elseif menu_o.menuSecond??>
                                                <a class="nav-link" href="#" id="${menu_o.menuId}-link" data-toggle="dropdown">${menu_o.menuName}</a>
                                                <div class="dropdown-menu" aria-labelledby="${menu_o.menuId}-link">
                                                    <#list menu_o.menuSecond as menu_s>
                                                        <a class="dropdown-item" href="#" id="${menu_s.menuId}-link" target-url="${menu_s.menuUrl}" onclick="addtab(this)" fun-name="${menu_s.menuName}">${menu_s.menuName}</a>
                                                    </#list>
                                                </div>
                                            <#else >
                                                <a class="nav-link" href="#" id="${menu_o.menuId}-link" data-toggle="dropdown">${menu_o.menuName}</a>
                                            </#if>
                                        </li>
                                    </#list>
                                </ul>
                            </#list>
                        </#if>
                    </div>

                    <div class="navbar-collapse">
                        <input class="comm-input mr-sm-2" type="text"/>
                        <img class="comm-icon" src="/img/icons/search.svg" alt="搜索" title="搜索">
                    </div>

                    <div class="ml-md-auto">
                        <ul class="navbar-nav">
                            <#if HelpMenu?exists>
                                <li class="nav-item">
                                    <a class="nav-link" href="#" id="${HelpMenu.menuId}-link" onclick="addtab(this)" fun-name="${HelpMenu.menuName}" target-url="${HelpMenu.menuUrl}">
                                        <img class="comm-icon help-icon" src="/img/icons/question-diamond.svg" alt="${HelpMenu.menuName}" title="${HelpMenu.menuName}">
                                    </a>
                                </li>
                            </#if>
                            <#if UserMenu?exists>
                                <li class="nav-item">
                                    <a class="nav-link" href="#" id="${UserMenu.menuId}-link" data-toggle="dropdown">
                                        <img class="comm-icon" src="/img/icons/people.svg" alt="${UserMenu.menuName}" title="${UserMenu.menuName}">
                                    </a>
                                    <#if UserMenu.menuType==1&&UserMenu.menuSecond??>
                                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="${UserMenu.menuId}-link">
                                            <span class="welcome-tips">这不${UserName}嘛!欢迎欢迎!</span>
                                            <#list UserMenu.menuSecond as menu_s>
                                                <a class="dropdown-item" href="#" id="${menu_s.menuId}-link" onclick="addtab(this)" fun-name="${menu_s.menuName}" target-url="${menu_s.menuUrl}">${menu_s.menuName}</a>
                                            </#list>
                                            <a class="dropdown-item logout-tip" href="#" onclick="logout()">退出登录</a>
                                        </div>
                                    </#if>
                                </li>
                            </#if>
                        </ul>
                    </div>

                </div>
            </nav>

            <div id="tabcontent">
                <ul id="tab-ul" class="tab-ul">
                </ul>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div id="iframe-div" class="iframe-div">
            </div>
        </div>
    </div>

</div>

</body>
</html>