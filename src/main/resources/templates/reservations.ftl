<#import "style.ftl" as st>
<html>
<body>
<@st.style>
</@st.style>
<div class="main">
    <div>
        <form method="post">
            <button type="button" id="openDialog">Add Reservations</button>
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
                <input type="text" name="startDate" placeholder="start_date">
                <input type="text" name="finalDate" placeholder="final_date">
                <input type="text" name="count" placeholder=count>
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
            <th>start_date</th>
            <th>final_date</th>
            <th>count</th>
            <th>delete</th>
            <th>update</th>
        </tr>
        <#list reservations as reservation>
            <tr>
                <td>${reservation.id}</td>
                <td>${reservation.customer.name}</td>
                <td>${reservation.ski.name}</td>
                <td>${reservation.startDate}</td>
                <td>${reservation.finalDate}</td>
                <td>${reservation.count}</td>
                <td><button><a href="/reservations/delete/${reservation.id}">Delete</a></button></td>
                <td><button type="button" id="openDialog">Update</button></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>