<%@ include file="common/header.jspf" %>

<body>
<%@ include file="common/navigation.jspf" %>

    <div class="container mt-4">
        <h1>Update Todo</h1>
        <form id="updateTodoForm" data-todo-id="${todo.id}">
            <div class="mb-3">
                <label for="taskName" class="form-label">Task : </label>
                <input id="taskName" value="${todo.name}"  placeholder="Enter Todo here" name="todo" type="text" class="form-control mb-2" required>
                <label for="targetDate">Target Date:</label>
                <input type="date" value="${todo.targetDate}" id="targetDate" name="targetDate" class="form-control mb-2">
                <label for="isCompleted" class="form-label">Is Completed :  </label>
                <input id="isCompleted"type="checkbox" 
                <c:if test="${todo.isCompleted}"> checked </c:if>
                />
            </div>
            <button type="button" class="btn btn-primary" onclick="submitUpdateTodo()">Update Todo</button>
        </form>
    </div>
    <script>
        function submitUpdateTodo(){
            const form = document.getElementById('updateTodoForm');
            const data = new URLSearchParams(new FormData(form));
            const todoId = form.getAttribute('data-todo-id');
            data.append('id', todoId);
            const isCompletedCheckbox = document.getElementById('isCompleted');
            data.set('isCompleted', isCompletedCheckbox.checked ? 'true' : 'false');


            // Convert FormData to URLSearchParams for x-www-form-urlencoded
            const params = new URLSearchParams(data);
            fetch('/update-todo', {
                method: 'PUT',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                body: params
            }).then(response => {
              if (response.redirected) {
                                  window.location.href = response.url;
                              }
            });
        }
    </script>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>