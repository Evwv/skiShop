<#import "style.ftl" as st>
<html>

<body>
<@st.style>
</@st.style>
<div class="main">
    <div>
        <form method="post" action="/skisAdd">
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
        <form method="post" action="/skisUpdates">
            <dialog id="dialogUpdate">
                <input type="text" name="name" placeholder="name">
                <input type="text" name="firm" placeholder="firm">
                <input type="text" name="length" placeholder="length">
                <input type="text" name="price" placeholder="price">
                <input type="hidden" name="id">
                <button type="submit" id="closeDialogUpdate">Update</button>
            </dialog>
            <script>
                $(document).ready(function () {
                    console.log("ready!");
                    var dialog = document.getElementById('dialogUpdate');
                    document.querySelector('#closeDialogUpdate').onclick = function () {
                        dialog.close(); // Прячем диалоговое окно
                    }
                    $(".openDialogUpdate").click(function (e) {
                        var btn = $(this);
                        var name = btn.data("name");
                        var firm = btn.data("firm");
                        var length = btn.data("length");
                        var price = btn.data("price");
                        var id = btn.data("id");
                        $('input[name=name]').val(name);
                        $('input[name=firm]').val(firm);
                        $('input[name=length]').val(length);
                        $('input[name=price]').val(price);
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
                <td>
                    <button type="button" class="openDialogUpdate" data-name="${ski.name}"
                            data-firm="${ski.firm}" data-length="${ski.length}" data-price="${ski.price}" data-id="${ski.id}">
                        Update
                    </button>
                </td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>