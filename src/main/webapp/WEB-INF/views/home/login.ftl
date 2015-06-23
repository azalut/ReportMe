<@layout.extends name="template.ftl">
    <@layout.put block="content">
    <form action="/login" method="post">
        <input type="text" name="username" placeholder="your username.."/>
        <input type="text" name="password" placeholder="your password.."/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <input type="submit" value="Login"/>
    </form>

    </@layout.put>
</@layout.extends>