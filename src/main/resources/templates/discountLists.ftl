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
        <form method="post" action="/discountLists">
            <button type="button" id="openDialog">Add Discount</button>
            <dialog>
                <select name="company" style="width:150px;">
                    <#if companies??>
                        <#list companies as company>
                            <option value="${company.id}">${company.companyName}</option>
                        </#list>
                    </#if>
                </select>
                <input type="text" name="startDate" placeholder="start_date">
                <input type="text" name="finalDate" placeholder="final_date">
                <input type="text" name="discount" placeholder="discount">
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
        <form method="post" action="/discountListsUpdate">
            <dialog id="dialogUpdate">
                <select name="company" style="width:150px;">
                    <#if companies??>
                        <#list companies as company>
                            <option value="${company.id}">${company.companyName}</option>
                        </#list>
                    </#if>
                </select>
                <input type="text" name="startDate" placeholder="start_date">
                <input type="text" name="finalDate" placeholder="final_date">
                <input type="text" name="discount" placeholder="discount">
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
                        var company = btn.data("company");
                        var startDate = btn.data("start");
                        var finalDate = btn.data("final");
                        var discount = btn.data("discount");
                        var id = btn.data("id");
                        $('input[name=company').val(company);
                        $('input[name=startDate]').val(startDate);
                        $('input[name=finalDate]').val(finalDate);
                        $('input[name=discount]').val(discount);
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
            <th>company_name</th>
            <th>start_date</th>
            <th>final_date</th>
            <th>discount</th>
            <th>delete</th>
            <th>update</th>
        </tr>
        <#list discountLists as discountList>
            <tr>
                <td>${discountList.id}</td>
                <td>${discountList.company.companyName}</td>
                <td>${discountList.startDate}</td>
                <td>${discountList.finalDate}</td>
                <td>${discountList.discount}</td>
                <td><button><a href="/discountLists/delete/${discountList.id}">Delete</a></button></td>
                <td>
                    <button type="button" class="openDialogUpdate" data-company="${discountList.company.companyName}"
                            data-start="${discountList.startDate}" data-final="${discountList.finalDate}" data-discount="${discountList.discount}" data-id="${discountList.id}">
                        Update
                    </button>
                </td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>