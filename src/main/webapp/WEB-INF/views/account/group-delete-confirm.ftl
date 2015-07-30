<#import '/spring.ftl' as spring/>

<@layout.extends name="account/account-template.ftl">
    <@layout.put block="account-content">
        <p>Czy aby na pewno chcesz usunąć grupę <span class="grey-bold">${groupName}?</span></p>

        <a href="<@spring.url '/account/delete/${groupName}?confirmed=yes'/>" class="account-button">Tak</a>
        <a href="<@spring.url '/account/delete/${groupName}?confirmed=no'/>" class="account-button">Nie</a>

    </@layout.put>
</@layout.extends>