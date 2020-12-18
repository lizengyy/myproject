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

function addtab(options) {
    // setbreadcrumb(options.level1, options.level2, options.tabname);
    //taburl:当前tab所指向的url地址
    var isexists = istabexists(options.menuid);
    if (isexists) { // 如果tab标签页已打开，则选中、激活
        $("#tab-a-" + options.menuid).click(); // 注意，必须是点击 a标签才起作用
    } else {
        // 新增 tab 标签页
        //按钮图标 '<i class="glyphiconglyphicon-remove"></i></a>'
        $("#" + tabfatherelementid).append(
            '<li role="presentation" id="tab-li-' + options.menuid + '">' +
            '    <a href="#tab-content-' + options.menuid + '" data-toggle="tab" role="tab" id="tab-a-' + options.menuid + '">' + options.tabname + '<button class="close closetab" type="button" onclick="closetab(this,' + "'" + options.level1 + "','" + options.level2 + "','" + options.tabname + "'" + ');">×</button>' + '</a>' +
            '</li>');
        // 设置 tab标签页的内容
        var content = '<iframe name="tabiframe" src="' + options.taburl + '" width="100%" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes" onload="changeframeheight()"></iframe>';
        $("#" + options.tabcontentid).append('<div id="tab-content-' + options.menuid + '" role="tabpanel" class="tab-pane">' + content + '</div>');
        $("#tab-a-" + options.menuid).click(); // 选中打开的tab
        currentiframid = 'iframe' + options.menuid;
    }
}


/***
 * 判断tab页是否已经打开
 * @paramtabname当前tab的名称
 * @returns {boolean}
 * */
function istabexists(menuid) {
    var tab = $('#tab-li-' + menuid + ' > #tab-a-' + menuid);
    return tab.length > 0;
}

/**
 * 关闭tab标签页
 * @param button
 */

function closetab(button) {
    //通过所点击的x 按钮，找到对应li标签的id
    var li_id = $(button).parent().parent().attr('id');
    var id = li_id.replace('tab-li-', '');
    var li_active = $("#" + tabfatherelementid + " >li.active");

    if (li_active.attr('id') == li_id) { // 如果关闭的是当前处于选中状态的tab
        if (li_active.prev()[0]) { // 如果当前tab标签之前存在tab标签，则激活前一个标签页（前后顺序对应左右顺序
            li_active.prev().find("a").click();
        } else if (li_active.next()[0]) { // 如果当前tab标签之前不存在tab标签，并且在其之后存在tab标签，则激活后一个tab标签页
            li_active.next().find("a").click();
        }
    }

    //关闭tab
    $("#" + li_id).remove();
    $("#tab-content-" + id).remove(); // 移除内容
}


/**
 * 设置tab标签对应的iframe页面高度
 * */

function changeframeheight() {
    var iframes = document.getelementsbyname('tabiframe');
    var contentcontainer = $('#' + tabcontentid); // 获取tab标签对应的页面div容器对象 // 可能会出现获取不到的情况
    var offsettop = 0;
    if (contentcontainer.offset()) {
        offsettop = contentcontainer.offset().top;  //容器距离document顶部的距离
    }
    $.each(iframes, function (index, iframe) {
        var h = window.innerheight || document.documentelement.clientheight || document.body.clientheight;
        iframe.height = h - offsettop;// 这里offsettop可以替换成一个比较合理的常量值
    });
}

/**
 * 浏览器窗口大小发生变化时，自动调整iframe页面高度
 * 浏览器等因素导致改变浏览器窗口大小时，会发生多次resize事件，导致频繁调用changeframeheight()，* 所以函数中添加了延迟事件
 * */

$(function () {
    var resizetimer = null;
    window.onresize = function () {
        if (resizetimer) {
            cleartimeout(resizetimer); // 取消上次的延迟事件
        }
        resizetimer = settimeout('changeframeheight()', 500);  // //延迟500毫秒执行changeframeheight方法
    }
});
