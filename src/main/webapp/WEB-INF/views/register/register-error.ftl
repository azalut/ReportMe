<#import "/spring.ftl" as spring/>

<@layout.extends name="template.ftl">
    <@layout.put block="content">
        <#if exception??>
            <p>${exception.message!""}</p>
        </#if>
    </@layout.put>
</@layout.extends>