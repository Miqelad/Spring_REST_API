<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
<body>
<h2>Employee info</h2>
<%--action срабатывает при кнопке ок --%>
<form:form action="saveEmployee" modelAttribute="employee">
<%--    создаем скрытую форму чтобы у нас было поле id сотрудника--%>
    <form:hidden path="id"/>
    Name<form:input path="name"/>
    <br><br>
    Surname<form:input path="surname"/>
    <br><br>
    Department<form:input path="department"/>
    <br><br>
    Salary<form:input path="salary"/>
    <br><br>
<%--    после нажатия на кнопку ок, должен вызваться метод работника,--%>
<%--    который мы прописали в action--%>
    <input type="submit" value="ok">
</form:form>

</body>
</html>
