<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>未登录</title>

    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="css/login/framelogin.css">
    <script type="text/javascript" src="/js/login/framelogin.js"></script>
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