<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Welcome Page</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ include file="common/navigation.jspf" %>

    <div class="container mt-5">
        <h1 class="mb-4">Welcome, ${name}!</h1>
        <hr/>
        <a href="/list-todos" class="btn btn-success">Manage your todos</a>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>