<#import "/spring.ftl" as spring/>

<@layout.extends name="template.ftl">
    <@layout.put block="content">
    <div class="center-content">
        <p>Zaloguj się</p>
        <#-- after redirect from /register Controller -->
        <#if RequestParameters.registerSuccess??>
            Rejestracja przebiegła pomyślnie, aktywuj konto poprzez link wysłany na email i zaloguj się
        </#if>

        <#if SPRING_SECURITY_LAST_EXCEPTION?has_content>
            <p>${SPRING_SECURITY_LAST_EXCEPTION.message}</p>
        </#if>

        <form action="<@spring.url '/login' />" method="post">
            <input type="text" name="username" class="css-input" placeholder="nazwa użytkownika.."/><br>
            <input type="password" name="password" class="css-input" placeholder="hasło.."/><br>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <input type="submit" value="Login" class="btn"/>
        </form>
        <p>Jeśli nie posiadasz konta <a href="<@spring.url '/register'/>">Załóż teraz!</a></p>
    </div>
    </@layout.put>
</@layout.extends>