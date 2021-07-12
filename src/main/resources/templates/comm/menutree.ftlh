
<!-- 递归  宏定义 -->
<#macro menuTree childrenList>
    <#if childrenList?? && childrenList?size gt 0>
        <#list childrenList as child>
            <#if child.menuSecond?? && child.menuSecond?size gt 0>
            <ul class="treeulcoll">
                <li class="treeli" onclick="ex_coll('branch_${child.menuId}', this, nodecallback)" isparent="1">
                    <span>${child.menuName}</span>
                </li>
                <ul class="treeulex css-hide" id="branch_${child.menuId}">
                    <@menuTree childrenList=child.menuSecond/>
                </ul>
            </ul>
            <#else>
            <ul class="treeulcoll">
                <li class="treeli" onclick="ex_coll('branch_${child.menuId}', this, nodecallback)"  isparent="0">
                    <span>${child.menuName}</span>
                </li>
            </ul>
            </#if>
        </#list>
    </#if>
</#macro>
</ul>

<script type="text/javascript">
    function ex_coll(ulId, _this, nodecallback){
        var isparent = $(_this).attr("isparent");
        var parentul = $(_this).parent();
        if(parentul.hasClass("treeulcoll")){
            parentul.removeClass("treeulcoll");
            parentul.addClass("treeulex");
        }else if(parentul.hasClass("treeulex")){
            parentul.removeClass("treeulex");
            parentul.addClass("treeulcoll");
        }
        if(isparent=="1"){
            if(parentul.hasClass("treeulcoll")){
                $("#"+ulId).hide();
            }else if(parentul.hasClass("treeulex")){
                $("#"+ulId).show();
            }
        }
        $(".treeli").removeClass("choosebkg");
        $(_this).addClass("choosebkg");
        if(nodecallback!=undefined && typeof nodecallback=='function'){
            nodecallback(ulId.replace('branch_', ''));
        }else{
            console.info("组件调用页JS未定义点击回调函数nodecallback()");
        }
    }
</script>