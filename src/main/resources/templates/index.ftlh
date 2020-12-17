<!DOCTYPE html>
<html lang="ch">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="SpringBoot FreeMaker"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>管理室</title>

    <#include "./comm/common.ftlh">

</head>
<body class="bg-manager">

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-manager">

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="navbar-toggler-icon"></span>
                </button> <a class="navbar-brand" href="#">管理室</a>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">模块1</a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">行动</a> <a class="dropdown-item" href="#">另一个动作</a> <a class="dropdown-item" href="#">这里还有其他</a>
                                <div class="dropdown-divider">
                                </div> <a class="dropdown-item" href="#">分隔链接</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">模块2</a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">行动</a> <a class="dropdown-item" href="#">另一个动作</a> <a class="dropdown-item" href="#">这里还有其他</a>
                                <div class="dropdown-divider">
                                </div> <a class="dropdown-item" href="#">分隔链接</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">模块3</a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">行动</a> <a class="dropdown-item" href="#">另一个动作</a> <a class="dropdown-item" href="#">这里还有其他</a>
                                <div class="dropdown-divider">
                                </div> <a class="dropdown-item" href="#">分隔链接</a>
                            </div>
                        </li>
                    </ul>
                    <form class="form-inline">
                        <input class="comm-input mr-sm-2" type="text" />
                        <#--<button class="btn btn-primary my-2 my-sm-0" type="submit">-->
                            <#--搜寻-->
                        <#--</button>-->
                        <img class="comm-icon" src="/img/icons/search.svg" alt="">
                    </form>
                    <ul class="navbar-nav ml-md-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <img class="comm-icon help-icon" src="/img/icons/question-diamond.svg" alt="">
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">
                                <img class="comm-icon" src="/img/icons/people.svg" alt="">
                            </a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">行动</a> <a class="dropdown-item" href="#">另一个动作</a> <a class="dropdown-item" href="#">这里还有其他</a>
                                <div class="dropdown-divider">
                                </div> <a class="dropdown-item" href="#">分隔链接</a>
                            </div>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="row">
                <div class="col-md-12">
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>