<#import "style.ftl" as st>
<html>

<body>
<@st.style>
</@st.style>
<div class="main">
    <div>
        <form method="post">
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
                <td><button type="button" id="openDialog">Update</button></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>