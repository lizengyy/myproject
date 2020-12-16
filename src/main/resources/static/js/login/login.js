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
$("#saveUserInfo").click(function() {
    var formObject = {};
    var formArray =$("#loginForm").serializeArray();
    $.each(formArray,function(i,item){
        formObject[item.name] = item.value;
    });
    $.ajax({
        url:"/login",
        type:"post",
        // contentType: "application/json; charset=utf-8",
        data: formObject,//JSON.stringify(formObject),
        // dataType: "json",
        success:function(data){
            alert(data.msg);
        },
        error:function(e){
        }
    });
});