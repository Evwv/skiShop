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
        <form method="post" action="/shoppingLists">
            <button type="button" id="openDialog">Add Purchase</button>
            <dialog>
                <select name="customers" style="width:150px;">
                    <#if customers??>
                        <#list customers as customer>
                            <option value="${customer.id}">${customer.name}</option>
                        </#list>
                    </#if>
                </select>
                <select name="skis" style="width:150px;">
                    <#if skis??>
                        <#list skis as ski>
                            <option value="${ski.id}">${ski.name}</option>
                        </#list>
                    </#if>
                </select>
                <input type="text" name="purchaseDay" placeholder="purchaseDay">
                <input type="text" name="count" placeholder="count">
                <button type="submit" id="closeDialog">Add</button>
                <button type="button" id="closeAdd">Cancel</button>
            </dialog>
            <script>
                var dialog = document.querySelector('dialog');
                document.querySelector('#openDialog').onclick = function() {
                    dialog.show(); // Показываем диалоговое окно
                }
                document.querySelector('#closeDialog').onclick = function() {
                    dialog.close(); // Прячем диалоговое окно
                }
                document.querySelector('#closeAdd').onclick = function () {
                    dialog.close(); // Прячем диалоговое окно
                }
            </script>
        </form>
        <form method="post" action="/shoppingListsUpdate">
            <dialog id="dialogUpdate">
                <select name="customer" style="width:150px;">
                    <#if customers??>
                        <#list customers as customer>
                            <option value="${customer.id}">${customer.name}</option>
                        </#list>
                    </#if>
                </select>
                <select name="ski" style="width:150px;">
                    <#if skis??>
                        <#list skis as ski>
                            <option value="${ski.id}">${ski.name}</option>
                        </#list>
                    </#if>
                </select>
                <input type="text" name="purchase" placeholder="purchaseDay">
                <input type="text" name="count" placeholder="count">
                <input type="hidden" name="id">
                <button type="submit" id="closeDialogUpdate">Update</button>
                <button type="button" id="closeUpdate">Cancel</button>
            </dialog>
            <script>
                $(document).ready(function () {
                    console.log("ready!");
                    var dialog = document.getElementById('dialogUpdate');
                    document.querySelector('#closeDialogUpdate').onclick = function () {
                        dialog.close(); // Прячем диалоговое окно
                    }
                    document.querySelector('#closeUpdate').onclick = function () {
                        dialog.close(); // Прячем диалоговое окно
                    }
                    $(".openDialogUpdate").click(function (e) {
                        var btn = $(this);
                        var customer = btn.data("customer");
                        var ski = btn.data("ski");
                        var purchase = btn.data("purchase");
                        var count = btn.data("count");
                        var id = btn.data("id");
                        $('input[name=customer').val(customer);
                        $('input[name=ski]').val(ski);
                        $('input[name=purchase]').val(purchase);
                        $('input[name=count]').val(count);
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
            <th>customer_name</th>
            <th>ski_name</th>
            <th>purchaseDay</th>
            <th>count</th>
            <th>totalPrice</th>
            <th>delete</th>
            <th>update</th>
        </tr>
        <#list shoppingLists as shoppingList>
            <tr>
                <td>${shoppingList.id}</td>
                <td>${shoppingList.customer.name}</td>
                <td>${shoppingList.ski.name}</td>
                <td>${shoppingList.purchaseDay}</td>
                <td>${shoppingList.count}</td>
                <td>${shoppingList.count*shoppingList.ski.price}</td>
                <td><button><a href="/shoppingLists/delete/${shoppingList.id}">Delete</a></button></td>
                <td>
                    <button type="button" class="openDialogUpdate" data-customer="${shoppingList.customer.name}"
                            data-ski="${shoppingList.ski.name}" data-purchase="${shoppingList.purchaseDay}" data-count="${shoppingList.count}" data-id="${shoppingList.id}">
                        Update
                    </button>
                </td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>