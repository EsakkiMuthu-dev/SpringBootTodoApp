<%@ include file="common/header.jspf" %>
<body>
<%@ include file="common/navigation.jspf" %>
    <div class="container mt-4">
        <h1>Your Todos:</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th> ID </th>
                    <th>Task</th>
                    <th>Target Date</th>
                    <th>Is Completed</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${empty todos}">
                        <tr>
                            <td colspan="3" class="text-center">No todos found.</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${todos}" var="todo">
                            <tr>
                                <td> ${todo.id} </td>
                                <td>${todo.name}</td>
                                <td>${todo.targetDate}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${todo.isCompleted}">Yes</c:when>
                                        <c:otherwise>No</c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <a href="/update-todo?id=${todo.id}" class="btn btn-warning btn-sm">
                                        update
                                    </a>
                                </td>
                                <td>
                                    <button class="btn btn-danger btn-sm"
                                        onclick="deleteTodo(${todo.id}); return false;">
                                        Delete
                                    </button>
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
        <a href="/add-todo" class="btn btn-success">Add Todo</a>
    </div>
    <script>
        function deleteTodo(id) {
            if(confirm('Are you sure you want to delete this todo?')) {
                fetch('/delete-todo?id=' + id, { method: 'DELETE' })
                    .then(() => 
                    {
                        alert('Todo deleted successfully!')
                        window.location.reload();
                    })
            }
        }
</script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>