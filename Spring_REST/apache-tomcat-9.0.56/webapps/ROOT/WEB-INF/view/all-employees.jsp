<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<h2>All Employees</h2>
<%--создаем таблицу--%>
<table>
    <%--    строка таблици tr--%>
    <tr>
        <%--        Шапта таблицы th--%>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
<%--            для выбора действий--%>
        <th>Operations</th>
    </tr>
    <%--    значение полей н--%>
    <c:forEach var="emp" items="${allEmps}">
<%--        Добавляем во внутрь ссылки информацию об id работника--%>
        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>
<%--            это просто ссылка, она нигде не отображается,--%>
<%--            но будет использоваться при создание кнопки--%>
        </c:url>
        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
<%--            создаем кнопку название Update, при нажатие будет переходим по ссылку,--%>
<%--            которую создали вверху, которая содержит id работника--%>
            <td>
                <input type="button" value="Update"
                onclick="window.location.href= '${updateButton}'">
                <input type="button" value="Delete"
                       onclick="window.location.href= '${deleteButton}'">
            </td>
        </tr>

    </c:forEach>
</table>
<br>
<%--Создаем кнопку добавления сотрудника--%>
<input type="button" value="add"
onclick="window.location.href='addNewEmployee'">
</body>
</html>