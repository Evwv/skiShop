<#macro style>
    <header>

        <style>
            .table_dark {
                font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
                font-size: 14px;
                width: 640px;
                border-collapse: collapse;
                background: #252F48;
                margin: auto;
            }
            .table_dark th {
                color: #EDB749;
                border-bottom: 1px solid #37B5A5;
                padding: 12px 17px;
            }
            .table_dark td {
                color: #CAD4D6;
                border-bottom: 1px solid #37B5A5;
                border-right:1px solid #37B5A5;
                padding: 7px 17px;
                text-align: center;
            }
            .table_dark tr:last-child td {
                border-bottom: none;
            }
            .table_dark td:last-child {
                border-right: none;
            }
            .table_dark tr:hover td {
                text-decoration: underline;
            }

            nav{
                right:15px;
                color:darkgreen;
                font-size: 25px;
                font-style:italic;
                margin-bottom: 30px;
                background-color: antiquewhite;
            }
            div{
                text-align: center;
            }
            button{
                color: crimson;
                text-align: center;
            }
        </style>

        <nav align="center">
            <a href="/customers">Сustomers</a>/
            <a href="/skis">Ski</a>/
            <a href="/reservations">Reservation</a>/
            <a href="/shoppingLists">ShoppingList</a>/
        </nav>
    </header>
</#macro>


