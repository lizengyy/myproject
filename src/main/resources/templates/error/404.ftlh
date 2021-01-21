<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>系统异常</title>

    <style type="text/css">
        body{
            margin:0;
            padding:0;
            position:fixed;
            width:100%;
            height:100%;
            background-image:url("/img/error/404.jpg");
            background-position:center center;
            background-repeat:no-repeat;
            background-attachment:fixed;
            background-size:100% 100%;
            -moz-filter:blur(10px);
            filter:
        }
        .dev404{
            width:5%;
            height:3%;
            margin-left: 1%;
            margin-top: 1%;
        }
        .img404{
            max-width: 100%;
            max-height: 100%;
        }
    </style>

    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>

    <script type="text/javascript">
        $(function(){
            if (window.top != window.self) {
                $("#back404").hide();
            }
        });
        function goBack(){
            window.history.go(-1);
        }
    </script>

</head>
<body>
<div class="dev404">
    <img id="back404" src="/img/btn/backBtn.svg" alt="" onclick="goBack()" class="img404">
</div>

</body>
</html>