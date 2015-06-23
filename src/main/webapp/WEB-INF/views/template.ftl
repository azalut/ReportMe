<html>
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ek+Mukta">
    <link rel="stylesheet" type="text/css" href="resources/styles/style.css"/>
</head>
<body>
<div class="page-wrap">
    <div class="menu-wrap">
        <nav class="menu">
            <ul class="clearfix">
                <li><a href="#">Strona główna</a></li>
                <li>
                    <a href="#">Oferta</a>

                    <ul class="sub-menu">
                        <li><a href="#">Opcja 1</a></li>
                        <li><a href="#">Opcja 2</a></li>
                        <li><a href="#">Opcja 3</a></li>
                        <li><a href="#">Opcja 4</a></li>
                    </ul>
                </li>
                <li><a href="#">Projekty</a></li>
                <li><a href="#">Kontakt</a></li>
                <li><a href="/login">Zaloguj</a></li>
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