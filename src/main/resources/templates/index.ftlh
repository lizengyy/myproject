<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="SpringBoot FreeMaker"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>管理室</title>

    <#include "./comm/common.ftlh">

    <script type="text/javascript" src="/js/index/index.js"></script>
</head>
<body class="bg-manager">

<div class="container-fluid">

    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-manager">

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <div class="navbar-brand">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="navbar-toggler-icon"></span>
                        </button> <a class="navbar-brand" href="#">管理室</a>
                    </div>

                    <div class="navbar-expand-lg">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="#" id="welcome-tab">
                                    <img class="comm-icon" src="/img/icons/house-fill.svg" alt="主界面" title="主界面">
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">模块1</a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="#">行动</a>
                                    <a class="dropdown-item" href="#">另一个动作</a>
                                    <a class="dropdown-item" href="#">这里还有其他</a>
                                    <div class="dropdown-divider">
                                    </div> <a class="dropdown-item" href="#">分隔链接</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">模块2</a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="#">行动</a> <a class="dropdown-item" href="#">另一个动作</a> <a class="dropdown-item" href="#">这里还有其他</a>
                                    <div class="dropdown-divider">
                                    </div> <a class="dropdown-item" href="#">分隔链接</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">模块3</a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="#">行动</a> <a class="dropdown-item" href="#">另一个动作</a> <a class="dropdown-item" href="#">这里还有其他</a>
                                    <div class="dropdown-divider">
                                    </div> <a class="dropdown-item" href="#">分隔链接</a>
                                </div>
                            </li>
                        </ul>

                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="#"">测试测试测试测试测试测试</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"">测试测试测试测试测试测试</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"">测试测试测试测试测试测试</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"">测试测试测试测试测试测试</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"">测试测试测试测试测试测试</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"">测试测试测试测试测试测试</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"">测试测试测试测试测试测试</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#"">测试测试测试测试测试测试</a>
                            </li>
                        </ul>

                    </div>

                    <div class="navbar-collapse">
                        <input class="comm-input mr-sm-2" type="text" />
                        <img class="comm-icon" src="/img/icons/search.svg" alt="搜索" title="搜索">
                    </div>

                    <div class="ml-md-auto">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <img class="comm-icon help-icon" src="/img/icons/question-diamond.svg" alt="使用指南"  title="使用指南">
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">
                                    <img class="comm-icon" src="/img/icons/people.svg" alt="个人中心" title="个人中心">
                                </a>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="#">行动</a> <a class="dropdown-item" href="#">另一个动作</a> <a class="dropdown-item" href="#">这里还有其他</a>
                                    <div class="dropdown-divider">
                                    </div> <a class="dropdown-item" href="#">分隔链接</a>
                                </div>
                            </li>
                        </ul>
                    </div>

                </div>
            </nav>

        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="iframe-div">



                <!--添加左侧菜单栏 -->
                <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                    <div class="pannel-group" id="accordion">
                        <div id="left-nav" class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title"><a data-toggle="collapse" class="nav-header collapsed" data-parent="#accordion" href="#tag20"><iclass="glyphiconglyphicon-cog"></i>&nbsp;&nbsp;项目管理<span class="pull-right glyphiconglyphicon-chevron-toggle"></span></a></h4>
                            </div>
                            <div id="tag20" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <ulclass="navnav-list">
                                    <li class="active"><a href="#" onclick="addtab({'menuid':'21', 'father':'navtab', 'tabname':'项目管理1', 'tabcontentid':'tabcontent', 'taburl':'/testulr'})"><iclass="glyphiconglyphicon-cog"></i>&nbsp;&nbsp;项目管理1</a></li>
                                    <li class="active"><a href="#" onclick="addtab({'menuid':'22', 'father':'navtab', 'tabname':'项目管理2', 'tabcontentid':'tabcontent', 'taburl':''})"><iclass="glyphiconglyphicon-cog"></i>&nbsp;&nbsp;项目管理2</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <!--添加tab页面 -->
                <div class="col-xs-10 col-sm-10 col-md-10 col-lg-10">
                    <ulid="navtab" class="navnav-tabs">
                    <!--通过js获取 tab-->
                    </ul>

                    <!-- tab页面的内容 -->
                    <div id="tabcontent" class="tab-content">
                        <!--通过js获取 tab对应的页面内容-->
                    </div>
                </div>



            </div>
        </div>
    </div>

</div>

</body>
</html>