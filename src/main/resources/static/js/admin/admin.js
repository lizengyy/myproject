function chgPwd(){
    $(".chgInput").show();
    $("#chgBtnTd").hide();
    $("#submitChgTd").show();
}

function chgPwdSubmit(){
    var opwd = $("#opwd").val();
    var npwd = $("#npwd").val();
    var cpwd = $("#cpwd").val();

    if(opwd=='' || opwd==undefined){
        $("#chgErrTd").text("请输入旧密码");
        $("#chgErrTr").show();
        return;
    }
    if(npwd=='' || npwd==undefined){
        $("#chgErrTd").text("请输入新密码");
        $("#chgErrTr").show();
        return;
    }
    if(cpwd=='' || cpwd==undefined){
        $("#chgErrTd").text("请确认新密码");
        $("#chgErrTr").show();
        return;
    }

    if(npwd != cpwd){
        $("#chgErrTd").text("新密码输入不一致");
        $("#chgErrTr").show();
        return;
    }

    opwd = $.base64.encode(opwd);
    npwd = $.base64.encode(npwd);
    cpwd = $.base64.encode(cpwd);


    $.ajax({
        url: "/chgPwd",
        data: {opwd: opwd, npwd: npwd, cpwd: cpwd},
        type: "POST",
        success: function(data) {
            if(data=="1"){
                $("#opwd").val("");
                $("#npwd").val("");
                $("#cpwd").val("");
                $(".chgInput").hide();
                $("#chgBtnTd").show();
                $("#submitChgTd").hide();
                $("#chgErrTr").hide();
                popMsg("密码修改成功！");
            }else{
                $("#chgErrTd").text(data);
                $("#chgErrTr").show();
            }
        }
    });

}