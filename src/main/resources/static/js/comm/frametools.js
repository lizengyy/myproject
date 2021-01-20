function reLogShow(){
    $("#cover-fixed").show();
    $("#relogin-div").show();
}
function reLogHide(){
    $("#cover-fixed").hide();
    $("#relogin-div").hide();
}

function popErrMsg(str){
    if (window.top != window.self) {
        window.self.$("#cover-div").show();
        window.self.$("#msg-div-text").text(str);
        window.self.$("#msg-div").removeClass("c-info");
        window.self.$("#msg-div").addClass("c-err");
        window.self.$("#msg-div").show();
    }else{
        $("#cover-fixed").show();
        $("#msg-div-text").text(str);
        $("#msg-div").removeClass("c-info");
        $("#msg-div").addClass("c-err");
        $("#msg-div").show();
    }
}

function popMsg(str){
    if (window.top != window.self) {
        window.self.$("#cover-div").show();
        window.self.$("#msg-div-text").text(str);
        window.self.$("#msg-div").removeClass("c-err");
        window.self.$("#msg-div").addClass("c-info");
        window.self.$("#msg-div").show();
    }else{
        $("#cover-fixed").show();
        $("#msg-div-text").text(str);
        $("#msg-div").removeClass("c-err");
        $("#msg-div").addClass("c-info");
        $("#msg-div").show();
    }
}

function popConfirm(str, callback){
    if (window.top != window.self) {
        window.self.$("#cover-div").show();
        window.self.$("#msg-confirm-text").text(str);
        window.self.$("#confirm-btn").attr("onclick", "confirmokey("+callback+")");
        window.self.$("#msg-confirm").show();
    }else{
        $("#cover-fixed").show();
        $("#msg-confirm-text").text(str);
        $("#confirm-btn").attr("onclick", "confirmokey("+callback+")");
        $("#msg-confirm").show();
    }
}

function okey(perfix){
    if (window.top != window.self) {
        window.self.$("#cover-div").hide();
        window.self.$("#"+perfix+"-text").text("");
        window.self.$("#"+perfix).hide();
    }else{
        $("#cover-fixed").hide();
        $("#cover-div").hide();
        $("#"+perfix+"-text").text("");
        $("#"+perfix).hide();
    }
}

function confirmokey(callback){
    okey('msg-confirm');
    callback();
}
