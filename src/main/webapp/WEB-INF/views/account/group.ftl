<#import '/spring.ftl' as spring />

<@layout.extends name="account/account-template.ftl">
    <@layout.put block="account-content">
        <p class="group-header">Osiedle: <span class="grey-bold">${group.name}</span></p>
        <hr>
        <#if group.notificationList?has_content>
            <p class="group-header">Lista powiadomień</p>
            <#list group.notificationList as notif>
                <div class="group-option">${notif.title}</div>
            </#list>
        <#else>
            <p class="group-header">To osiedle akutalnie nie ma powiadomień</p>
        </#if>
        <a href="<@spring.url '/account/mygroups'/>" class="account-button">Powrót do osiedli</a>
        <a href="<@spring.url '/account/delete/${group.name}'/>" class="account-button">Usuń tę grupę</a>
    </@layout.put>
</@layout.extends>