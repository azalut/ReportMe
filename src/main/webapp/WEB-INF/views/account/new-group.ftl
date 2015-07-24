<#import '/spring.ftl' as spring />

<@layout.extends name="account/account-template.ftl">
    <@layout.put block="account-content">
        <@spring.bind "newGroup"/>
        <div class="center-content">
            <p class="group-header">Podaj nazwę nowego osiedla</p>

            <form action="<@spring.url '/account/newgroup'/>" method="post">
                <table>
                    <tr>
                        <td><@spring.formInput "newGroup.name", "placeholder='nazwa osiedla..' class='css-input'"/></td>
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