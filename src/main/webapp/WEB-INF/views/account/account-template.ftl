<#import "/spring.ftl" as spring/>

<@layout.extends name="template.ftl">
    <@layout.put block="content">

        <div class="account-wrapper">
            <div class="account-left-side">
                <a href="<@spring.url '/account/mygroups'/>" class="account-menu-option">Moje osiedla <span class="grey-bold">admin</span></a>
                <a href="<@spring.url '/account/belongtogroups'/>" class="account-menu-option">Moje osiedla</a>
            </div>

            <div class="account-right-side">
                <@layout.block name="account-content">
                </@layout.block>
            </div>
        </div>
    </@layout.put>
</@layout.extends>