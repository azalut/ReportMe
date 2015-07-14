<#import "/spring.ftl" as spring/>

<@layout.extends name="template.ftl">
    <@layout.put block="content">
        <#if exception??>
            <p>${exception.message!""}</p>
        </#if>
        <p>${confirmationMessage!""}</p>

    </@layout.put>
</@layout.extends>