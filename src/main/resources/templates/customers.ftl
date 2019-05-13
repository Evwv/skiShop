<#import "style.ftl" as st>
<html>

<body>
<@st.style>
</@st.style>
<div class="main">
    <div>
        <form method="post">
            <button type="button" id="openDialog">Add Customer</button>
            <dialog>
                <input type="text" name="name" placeholder="name">
                <input type="text" name="surname" placeholder="surname">
                <input type="text" name="phone" placeholder="phone">
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
            <th>surname</th>
            <th>phone</th>
            <th>delete</th>
            <th>update</th>
        </tr>
        <#list customers as customer>
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.surname}</td>
                <td>${customer.phone}</td>
                <td><a href="/customers/delete/${customer.id}">Delete</a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>