<#import "/spring.ftl" as spring />

<@layout.extends name="account/account-template.ftl">
    <@layout.put block="account-content">
        <#if personObj.belongToGroups?has_content>
            Oto twoje osiedla:
            <#list personObj.belongToGroups as group>
                <p>${group.name}</p>
            </#list>
        <#else>
            <p>Nie zostałeś jeszcze przypisany do żadnego osiedla</p>
        </#if>
    </@layout.put>
</@layout.extends>