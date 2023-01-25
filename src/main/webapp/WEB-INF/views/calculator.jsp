calculator.jsp:

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<form action="calculate" method="get">
    <input type="text" name="firstNumber" placeholder="First Number"/><br>
    <input type="text" name="secondNumber" placeholder="Second Number"/><br>
    <input type="submit" name="operator" value="add"/>
    <input type="submit" name="operator" value="subtract"/>
    <input type="submit" name="operator" value="multiply"/>
    <input type="submit" name="operator" value="divide"/><br>
</form>

<% if (request.getAttribute("result") != null) { %>
    <h2>Result: <%= request.getAttribute("result") %></h2>
<% } %>

</body>
</html>
