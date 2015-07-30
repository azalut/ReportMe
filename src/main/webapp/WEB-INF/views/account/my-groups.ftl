<#import "/spring.ftl" as spring />

<@layout.extends name="account/account-template.ftl">
    <@layout.put block="account-content">
        <#if personObj.myGroups??>
            <p class="group-header">Moje osiedla <span class="grey-bold">administrator</span></p>
            <#list personObj.myGroups?sort_by("name") as group>
                <a href="/account/group/${group.name}" class="group-option">${group.name}</a>
            </#list>
        <#else>
            <p class="group-header">Nie stworzyłeś jeszcze osiedla</p>
        </#if>

        <hr>
        <a href="<@spring.url '/account/newgroup'/>" class="account-menu-option">Dodaj nowe osiedle</a>
    </@layout.put>
</@layout.extends>