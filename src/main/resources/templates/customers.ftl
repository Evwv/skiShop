<#import "style.ftl" as st>
<html>
<head>
    <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
<@st.style>
</@st.style>
<div class="main">
    <div>
        <form method="post" action="/customers">
            <button type="button" id="openDialogAdd">Add Customer</button>
            <dialog id="dialogAdd">
                <input type="text" name="name" placeholder="name">
                <input type="text" name="surname" placeholder="surname">
                <input type="text" name="phone" placeholder="phone">
                <button type="submit" id="closeDialogAdd">Add</button>
                <button type="button" id="closeAdd">Cancel</button>
            </dialog>
            <script>
                $(document).ready(function () {
                    console.log("ready!");
                    var dialog = document.getElementById('dialogAdd');
                    document.querySelector('#openDialogAdd').onclick = function () {
                        dialog.show(); // Показываем диалоговое окно
                    }
                    document.querySelector('#closeDialogAdd').onclick = function () {
                        dialog.close(); // Прячем диалоговое окно
                    }
                    document.querySelector('#closeAdd').onclick = function () {
                        dialog.close(); // Прячем диалоговое окно
                    }
                });
            </script>
        </form>
        <form method="post" action="/customersUpdates">
            <dialog id="dialogUpdate">
                <input type="text" name="name" placeholder="name">
                <input type="text" name="surname" placeholder="surname">
                <input type="text" name="phone" placeholder="phone">
                <input type="hidden" name="id">
                <button type="submit" class="closeDialogUpdate">Update</button>
                <button type="button" id="closeUpdate">Cancel</button>
            </dialog>
            <script>
                $(document).ready(function () {
                    console.log("ready!");
                    var dialog = document.getElementById('dialogUpdate');
                    document.getElementsByClassName('closeDialogUpdate').onclick = function () {
                        dialog.close(); // Прячем диалоговое окно
                    }
                    document.querySelector('#closeUpdate').onclick = function () {
                        dialog.close(); // Прячем диалоговое окно
                    }
                    $(".openDialogUpdate").click(function (e) {
                        var btn = $(this);
                        var name = btn.data("name");
                        var surname = btn.data("surname");
                        var phone = btn.data("phone");
                        var id = btn.data("id");
                        $('input[name=name]').val(name);
                        $('input[name=surname]').val(surname);
                        $('input[name=phone]').val(phone);
                        $('input[name=id]').val(id);
                        dialog.show(); // Показываем диалоговое окно
                    })
                });
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
                <td>
                    <button><a href="/customers/delete/${customer.id}">Delete</a></button>
                </td>
                <td>
                    <button type="button" class="openDialogUpdate" data-name="${customer.name}"
                            data-surname="${customer.surname}" data-phone="${customer.phone}" data-id="${customer.id}">
                        Update
                    </button>
                </td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>