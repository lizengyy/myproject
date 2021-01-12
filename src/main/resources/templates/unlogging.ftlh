<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>未登录</title>

    <script type="text/javascript">
        $(function{
            if (window.top != window.self) {
                location.href = location.href.substr(0,location.href.indexOf("/"))+"/welcome";
            }else{
                window.location.href=location.href.substr(0,location.href.indexOf("/"))+"/loginPage";
            }
        });
    </script>

</head>
<body>
</body>
</html>