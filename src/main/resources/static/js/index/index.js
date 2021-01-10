var menuArr = [];

/**
 * 增加tab标签页
 * @param options：
 * menuidtab标签页对应的左侧导航菜单在数据库表中的id，作为tab元素id的组成部分
 * tabname       tab标签页名称
 * taburl        tab“装载”的url
 * tabcontentid  tab标签页的页面内容所在的父级元素（div容器）
 *
 * @returns {boolean}
 * */

function addtab(_this) {
    var $this=$(_this);
    var taburl = $this.attr("target-url");
    var menuid = $this.attr("id");
    var menuname = $this.attr("fun-name");
    menuid = menuid.substr(0,menuid.lastIndexOf("-"))
    var isexists = istabexists(menuid);
    if (isexists) { // 如果tab标签页已打开，则选中、激活
        if($("#tab-li-" + menuid).hasClass("li-choose")){
            return;
        }
        $("#tab-li-" + menuid).click(); // 注意，必须是点击 a标签才起作用
    } else {
        // 新增 tab 标签页
        //按钮图标 '<i class="glyphiconglyphicon-remove"></i></a>'
        $("#tab-ul").append(
            '<li id="tab-li-' + menuid + '" class="tab-ul-li">' +
            '    <a href="#" id="tab-a-' + menuid + '" title="'+menuname+'" onclick="popuptab(\''+menuid+'\')">' + menuname +
            '    </a><img seq-id="'+menuid+'" class="sm-icon" src="/img/icons/x.svg" alt="x" title="关闭" onclick="closetab(this);"></li>');
        // 设置 tab标签页的内容
        var content = '<iframe id="iframe-' + menuid + '" name="iframe-tab" src="' + taburl + '" scrolling="no" allowtransparency="true" frameborder="0" class="hide"></iframe>';
        $("#iframe-div").append(content);
        $("#tab-a-" + menuid).click();
    }
}

function popuptab(menuid){
    var idx = menuArr.indexOf(menuid);
    if(idx>0){
        menuArr.splice(idx, 1);
    }
    $("#tab-ul").find("li").removeClass("li-choose");
    $("#tab-li-" + menuid).addClass("li-choose");
    $("#iframe-div").find("iframe").hide();
    $("#iframe-" + menuid).show();
    if(menuArr.indexOf(menuid)==-1){
        menuArr.push(menuid)
    }
}

/***
 * 判断tab页是否已经打开
 * @paramtabname当前tab的名称
 * @returns {boolean}
 * */
function istabexists(menuid) {
    var tab = $('#tab-a-' + menuid);
    return tab.length > 0;
}

function closetab(_this){
    var $this = $(_this);
    var seqid = $this.attr("seq-id");
    var hasNext = false;
    if($("#tab-li-" + seqid).hasClass("li-choose") && menuArr.length>1){
        hasNext = true;
    }
    $("#iframe-"+seqid).remove();
    $("#tab-li-"+seqid).remove();
    var idx = menuArr.indexOf(seqid);
    if(idx > -1){
        menuArr.splice(idx, 1);
    }
    if(hasNext){
        var nextMenu = menuArr.pop();
        popuptab(nextMenu);
    }
}

function logout(){

}






