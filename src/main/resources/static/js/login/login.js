//页面初始化脚本
$(function(){
    var rem = $.cookie('remember');
    if(rem){
        $("#storeBtn").prop("checked",true);
        $("#userName").val($.cookie("username"));
        $("#pwd").val($.cookie("password"));
    }
});

//保存用户名密码
function storeUserInfo(){
    if($("#storeBtn").prop("checked")){
        var user = $("#userName").val();
        var pwd = $("#pwd").val();

        $.cookie("remember","true",{expires:7});
        $.cookie("username",user,{expires:7 });
        $.cookie("password",pwd,{expires:7 });
    }else{
        $.cookie("remember","false",{expires:-1});
        $.cookie("username","",{ expires:-1 });
        $.cookie("password","",{ expires:-1 });
    }
}

//表单提交前数据验证
function toVaild(){
    $("#err-msg").html("&nbsp;");
    var user = $("#userName").val();
    var pwd = $("#pwd").val();
    if(!user || user==""){
        $("#err-msg").html("你得告诉我你叫啥！输入账号！");
        return false;
    }

    if(!pwd || pwd==""){
        $("#err-msg").html("没口令一律不得入内！");
        return false;
    }

    $("#err-msg").html("&nbsp;");
    return true;
}

function toSecret(_this){
    var $this=$(_this);
    var pwd = $this.val();
    $this.val($.base64.encode(pwd));
}

function reLogin(){
    if(!toVaild()){
        return;
    }
    var user = $("#userName").val();
    var pwd = $("#pwd").val();
    $.ajax({
        url: "/reLogin",
        data: {userName: user, pwd: pwd},
        type: "POST",
        dataType: "json",
        success: function(data) {
            if(data.flag=="1"){
                $("#err-msg").html("&nbsp;");
                reLogSuccess();
            }else{
                $("#err-msg").html(data.flag);
            }
        }
    });
}