<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>未登录</title>

    <#include "../comm/common.ftlh">

</head>

<body>
<script type="text/javascript">
    $(function(){
        if (window.top != window.self) {
            window.top.reLogShow();
        }else{
            window.location.href = _root_path + "/loginPage";
        }
    });
</script>
</body>
</html>