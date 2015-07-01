<@layout.extends name="template.ftl">
    <@layout.put block="content">

        <p>Zarejestruj się</p>
        <form method="post" action="<@spring.url '/createAccount' />">
            <table>
                <tr>
                    <td><input type="text" name="name" class="css-input" placeholder="your name.."/></td>
                </tr>
                <tr>
                    <td><input type="text" name="lastname" class="css-input" placeholder="your lastname.."/></td>
                </tr>
                <tr>
                    <td><input type="email" name="email" class="css-input" placeholder="your email.."/></td>
                </tr>
                <tr>
                    <td><hr></td>
                </tr>
                <tr>
                    <td><input type="text" name="username" class="css-input" placeholder="your username.."/></td>
                </tr>
                <tr>
                    <td><input type="password" name="password" class="css-input" placeholder="your password.."/></td>
                </tr>
                <tr>
                    <td><hr></td>
                </tr>
                <tr>
                    <td><input type="text" name="street" class="css-input" placeholder="your street.."/></td>
                </tr>
                <tr>
                    <td><input type="text" name="postcode" class="css-input" placeholder="your postcode.."/></td>
                </tr>
                <tr>
                    <td><input type="text" name="city" class="css-input" placeholder="your city.."/></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Stwórz" class="btn"/></td>
                </tr>
            </table>
        </form>

    </@layout.put>
</@layout.extends>