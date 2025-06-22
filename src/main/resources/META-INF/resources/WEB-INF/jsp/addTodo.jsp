<%@ include file="common/header.jspf" %>

<body>
<%@ include file="common/navigation.jspf" %>

    <div class="container mt-4">
        <pre>${errorMsg}</pre>
        <h1>Add Todo</h1>
        <form method="post">
            <div class="mb-3">
                <label for="taskName" class="form-label">Task</label>
                <input id="taskName"  placeholder="Enter Todo here" name="todo" type="text" class="form-control" required>

                <label for="targetDate">Target Date:</label>
                <input type="date" id="targetDate" name="targetDate" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Todo</button>
        </form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>