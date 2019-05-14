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
        <form method="post" action="/companies">
            <button type="button" id="openDialog">Add Company</button>
            <dialog id="dialog1">
                <input type="text" name="companyName" placeholder="company name">
                <input type="text" name="country" placeholder="country">
                <input type="text" name="numberOfEmployees" placeholder="number of employees">
                <input type="text" name="address" placeholder="address">
                <input type="text" name="phone" placeholder="phone">
                <button type="submit" id="closeDialog">Add</button>
            </dialog>
            <script>
                var dialog = document.getElementById("dialog1");
                document.querySelector('#openDialog').onclick = function() {
                    dialog.show(); // Показываем диалоговое окно
                }
                document.querySelector('#closeDialog').onclick = function() {
                    dialog.close(); // Прячем диалоговое окно
                }
            </script>
        </form>
        <form method="post" action="/companiesUpdates">
            <dialog id="dialogUpdate">
                <input type="text" name="companyName" placeholder="company name">
                <input type="text" name="country" placeholder="country">
                <input type="text" name="numberOfEmployees" placeholder="number of employees">
                <input type="text" name="address" placeholder="address">
                <input type="text" name="phone" placeholder="phone">
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
                        var companyName = btn.data("company");
                        var country = btn.data("country");
                        var numberOfEmployees = btn.data("employees");
                        var address = btn.data("address");
                        var phone = btn.data("phone");
                        var id = btn.data("id");
                        $('input[name=companyName]').val(companyName);
                        $('input[name=country]').val(country);
                        $('input[name=numberOfEmployees]').val(numberOfEmployees);
                        $('input[name=phone]').val(phone);
                        $('input[name=address]').val(address);
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
                <td><button><a href="/companies/delete/${company.id}">Delete</a></button></td>
                <td><button  class="openDialogUpdate" data-company="${company.companyName}"
                        data-country="${company.country}" data-employees="${company.numberOfEmployees}" data-address="${company.address}" data-phone="${company.phone}" data-id="${company.id}">
                    Update
                </button></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>