<!-- 递归  宏定义 -->
<#macro menuTree childrenList>
<ul class="treeview-menu">
    <#if childrenList?? && childrenList?size gt 0>
        <#list childrenList as child>
            <#if child.menuSecond?? && child.menuSecond?size gt 0>
                <li class="treeview">
                    <a href="javascript:void(0)">
                        <i class="" aria-hidden="true"></i> <span>${child.menuName}</span>
                        <i class="fa fa-angle-left pull-right" aria-hidden="true"></i>
                    </a>
                    <ul class="treeview-menu">
                        <@menuTree childrenList=child.menuSecond/>
                    </ul>
                </li>
            <#else>
                <li><a href="javascript:void(0)"><i class="" aria-hidden="true"></i> ${child.menuName}</a></li>
            </#if>
        </#list>
    </#if>
</ul>
</#macro>

<script type="text/javascript">

</script>