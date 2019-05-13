<#import "style.ftl" as st>
<html>

<body>
<@st.style>
</@st.style>
<div class="main">
    <div>
        <form method="post">
            <button type="button" id="openDialog">Add Company</button>
            <dialog>
                <input type="text" name="companyName" placeholder="company name">
                <input type="text" name="country" placeholder="country">
                <input type="text" name="numberOfEmployees" placeholder="number of employees">
                <input type="text" name="address" placeholder="address">
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
            <th>company_name</th>
            <th>country</th>
            <th>number_of_employees</th>
            <th>address</th>
            <th>phone</th>
            <th>delete</th>
            <th>update</th>
        </tr>
        <#list companies as company>
            <tr>
                <td>${company.id}</td>
                <td>${company.companyName}</td>
                <td>${company.country}</td>
                <td>${company.numberOfEmployees}</td>
                <td>${company.address}</td>
                <td>${company.phone}</td>
                <td><a href="/companies/delete/${company.id}">Delete</a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>