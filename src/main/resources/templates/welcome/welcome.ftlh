<!doctype html>
<html lang="ch">
<head>
    <meta charset="utf-8">
    <title>主界面</title>

    <#include "../comm/frameworktools.ftlh">

</head>
<body>
    <h3>憋瞅啦! 现在啥也妹有，赶紧开发去！</h3>
    <input type="button" value="弹" onclick="popConfirm('请确认是否需要操作', su)">


    <script type="text/javascript">
        function su(){
            popMsg("操作成功！");
        }
    </script>

</body>
</html>