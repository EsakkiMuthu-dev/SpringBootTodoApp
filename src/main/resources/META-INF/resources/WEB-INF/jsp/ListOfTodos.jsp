<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title> List of Todos Page </title>
</head>
<body>
<h1> Welcome ${name} </h1>
<hr/>
<h1>Your Todos : </h1>
<table>
  <thead>
    <tr>
      <th> name</th>
      <th> Author </th>
      <th> Target Date </th>
      <th> Is Completed </th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${todos}" var="todo">
      <tr>
        <td>${todo.name}</td>
        <td>${todo.author}</td>
        <td>${todo.targetDate}</td>
        <td>${todo.isCompleted}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>
