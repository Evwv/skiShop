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
        <form method="post" action="/reservations">
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
        <form method="post" action="/reservationsUpdates">
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
                <input type="text" name="startDate" placeholder="start_date">
                <input type="text" name="finalDate" placeholder="final_date">
                <input type="text" name="count" placeholder=count>
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
                        var startDate = btn.data("start");
                        var finalDate = btn.data("final");
                        var count = btn.data("count");
                        var id = btn.data("id");
                        $('input[name=customer').val(customer);
                        $('input[name=ski]').val(ski);
                        $('input[name=startDate]').val(startDate);
                        $('input[name=finalDate]').val(finalDate);
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
                <td>
                    <button type="button" class="openDialogUpdate" data-customer="${reservation.customer.name}"
                            data-ski="${reservation.ski.name}" data-start="${reservation.startDate}" data-final="${reservation.finalDate}" data-count="${reservation.count}" data-id="${reservation.id}">
                        Update
                    </button>
                </td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>