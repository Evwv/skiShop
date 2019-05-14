<#import "style.ftl" as st>
<html>
<body>
<@st.style>
</@st.style>
<div class="main">
    <div>
        <form method="post">
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
                <td><button type="button" id="openDialog">Update</button></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>