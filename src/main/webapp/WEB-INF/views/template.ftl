<#import "spring.ftl" as spring/>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<html>
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ek+Mukta">
    <#-- this concrete path: '/resources/style.css' is needed to css be loaded on VPS properly with and wihtout '/' after URL -->
    <link rel="stylesheet" type="text/css" href="<@spring.url '/resources/style.css' />"/>

</head>
<body>
<div class="page-wrap">
    <div class="menu-wrap">
        <nav class="menu">
            <ul class="clearfix">
                <li><a href="<@spring.url '/'/>">Strona główna</a></li>
                <li>
                    <a href="#">Oferta</a>

                    <ul class="sub-menu">
                        <li><a href="#">Opcja 1</a></li>
                        <li><a href="#">Opcja 2</a></li>
                        <li><a href="#">Opcja 3</a></li>
                        <li><a href="#">Opcja 4</a></li>
                    </ul>
                </li>
                <li><a href="#">Kontakt</a></li>

                <@security.authorize access="!hasRole('ROLE_OCCUPANT')">
                    <li><a href="<@spring.url '/login'/>">Zaloguj</a></li>
                    <li><a href="<@spring.url '/register'/>">Rejestracja</a></li>
                </@security.authorize>
                <@security.authorize access="hasRole('ROLE_OCCUPANT')">
                    <li><a href="<@spring.url '/logout'/>">Wyloguj</a></li>
                </@security.authorize>

                <@layout.block name="menu-list">
                </@layout.block>
            </ul>
        </nav>
    </div>

    <div class="content-wrap">
        <div class="content">
        <@layout.block name="content">
        </@layout.block>
        </div>
    </div>


    <div class="footer-wrap">
        <footer class="footer">
            <p>Szablon stworzony przez Tułaza Maciej</p>

            <p>Wszelkie prawa zastrzeżone</p>
        </footer>
    </div>
</div>

</body>
</html>