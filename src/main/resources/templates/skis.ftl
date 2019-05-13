<#import "style.ftl" as st>
<html>

<body>
<@st.style>
</@st.style>
<div class="main">
    <div>
        <form method="post">
            <button type="button" id="openDialog">Add Ski</button>
            <dialog>
                <input type="text" name="name" placeholder="name">
                <input type="text" name="firm" placeholder="firm">
                <input type="text" name="length" placeholder="length">
                <input type="text" name="price" placeholder="price">
                <button type="submit" id="closeDialog">Add</button>
            </dialog>
            <script>
                var dialog = document.querySelector('dialog');
                document.querySelector('#openDialog').onclick = function() {
                    dialog.show(); // Показываем диалоговое окно
                }
                document.querySelector('#closeDialog').onclick = function() {
                    dialog.close(); // Прячем диалоговое окно
                }
            </script>
        </form>
    </div>

    <table class="table_dark">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>firm</th>
            <th>length</th>
            <th>price</th>
            <th>delete</th>
            <th>update</th>
        </tr>
        <#list skis as ski>
            <tr>
                <td>${ski.id}</td>
                <td>${ski.name}</td>
                <td>${ski.firm}</td>
                <td>${ski.length}</td>
                <td>${ski.price}</td>
                <td><button><a href="/skis/delete/${ski.id}">Delete</a></button></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>