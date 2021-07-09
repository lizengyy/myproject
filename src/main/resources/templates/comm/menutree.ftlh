
<!-- 递归  宏定义 -->
<#macro menuTree childrenList>
    <#if childrenList?? && childrenList?size gt 0>
        <#list childrenList as child>
            <#if child.menuSecond?? && child.menuSecond?size gt 0>
            <ul class="treeulcoll">
                <li class="treeli">
                    <span onclick="ex_coll('branch_${child.menuId}', this)">${child.menuName}</span>
                </li>
                <ul class="treeulex css-hide" id="branch_${child.menuId}">
                    <@menuTree childrenList=child.menuSecond/>
                </ul>
            </ul>
            <#else>
            <ul class="treeulcoll">
                <li class="treeli">
                    <span onclick="ex_coll('', this)">${child.menuName}</span>
                </li>
            </ul>
            </#if>
        </#list>
    </#if>
</#macro>
</ul>

<script type="text/javascript">
    function ex_coll(ulId, _this){
        var parentul = $(_this).parent().parent();
        if(parentul.hasClass("treeulcoll")){
            parentul.removeClass("treeulcoll");
            parentul.addClass("treeulex");
        }else if(parentul.hasClass("treeulex")){
            parentul.removeClass("treeulex");
            parentul.addClass("treeulcoll");
        }
        if(ulId!=="" && $("#"+ulId)){
            if(parentul.hasClass("treeulcoll")){
                $("#"+ulId).hide();
            }else if(parentul.hasClass("treeulex")){
                $("#"+ulId).show();
            }
        }
    }
</script>