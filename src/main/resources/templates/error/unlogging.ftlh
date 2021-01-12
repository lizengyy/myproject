<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>未登录</title>

    <#include "../comm/common.ftlh">

</head>

<script type="text/javascript">
    $(function(){
        if (window.top != window.self) {
            location.href = _root_path + "/frameLogin";
        }else{
            window.location.href = _root_path + "/loginPage";
        }
    });
</script>

<body>
</body>
</html>