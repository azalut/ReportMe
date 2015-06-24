<#import "/spring.ftl" as spring/>

<@layout.extends name="template.ftl">
    <@layout.put block="content">
    <div class="center-content">
        <p>Zaloguj się</p>

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