<#import "/spring.ftl" as spring />

<@layout.extends name="account/account-template.ftl">
    <@layout.put block="account-content">
        <#if personObj.myGroups?has_content>
            Oto twoje osiedla:
            <#list personObj.myGroups as group>
                <p>${group.name}</p>
            </#list>
        <#else>
            <p>Nie stworzyłeś jeszcze osiedla</p>
            <a href="<@spring.url '/account/newgroup'/>" class="account-menu-option">Stwórz</a>
        </#if>
    </@layout.put>
</@layout.extends>