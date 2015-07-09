<#import "/spring.ftl" as spring />

<@layout.extends name="template.ftl">
    <@layout.put block="content">
        <p><h2>Tworzenie nowego konta</h2></p>
        <p>Wypełnij formularz poniżej</p>

        <form action="<@spring.url '/register'/>" method="post">
            <table>
                <tr>
                    <td><@spring.formInput "person.personData.name", "placeholder='twoje imie..' class='css-input'"/></td>
                    <td><@spring.showErrors ""/></td>
                </tr>
                <tr>
                    <td><@spring.formInput "person.personData.lastname", "placeholder='twoje nazwisko..' class='css-input'"/></td>
                    <td><@spring.showErrors ""/></td>
                </tr>
                <tr>
                    <td><@spring.formInput "person.personData.email", "placeholder='twój email..' class='css-input'", "email"/></td>
                    <td><@spring.showErrors ""/></td>
                </tr>
                <tr>
                    <td><hr></td>
                </tr>
                <tr>
                    <td><@spring.formInput "person.personData.username", "placeholder='twoja nazwa użytkownika..' class='css-input'"/></td>
                    <td><@spring.showErrors ""/></td>
                </tr>
                <tr>
                    <td><@spring.formPasswordInput "person.personData.password", "placeholder='twoje hasło..' class='css-input'"/></td>
                    <td><@spring.showErrors ""/></td>
                </tr>
                <tr>
                    <td><hr></td>
                </tr>
                <tr>
                    <td><@spring.formInput "person.address.street", "placeholder='twoja ulica..' class='css-input'"/></td>
                    <td><@spring.showErrors ""/></td>
                </tr>
                <tr>
                    <td><@spring.formInput "person.address.postCode", "placeholder='twój kod pocztowy..' class='css-input'"/></td>
                    <td><@spring.showErrors ""/></td>
                </tr>
                <tr>
                    <td><@spring.formInput "person.address.city", "placeholder='twoje miasto..' class='css-input'"/></td>
                    <td><@spring.showErrors ""/></td>
                </tr>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <tr>
                    <td><input type="submit" value="Stwórz" class="btn"/></td>
                </tr>
            </table>
        </form>
    </@layout.put>
</@layout.extends>