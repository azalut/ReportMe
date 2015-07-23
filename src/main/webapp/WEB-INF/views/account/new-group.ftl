<#import '/spring.ftl' as spring />

<@layout.extends name="template.ftl">
    <@layout.put block="content">
        <@spring.bind "newGroup"/>
        <div class="center-content">
            <p>Podaj nazwę nowej grupy</p>

            <form action="<@spring.url '/account/newgroup'/>" method="post">
                <table>
                    <tr>
                        <td><@spring.formInput "newGroup.name", "placeholder='nazwa grupy..' class='css-input'"/></td>
                        <td><@spring.showErrors ""/></td>
                    </tr>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    <tr>
                        <td><input type="submit" value="Stwórz" class="btn"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </@layout.put>
</@layout.extends>