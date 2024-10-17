<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


                <title>Create</title>
</head>

<body>
    <form:form method="POST" action="/admin/user/create" modelAttribute="userCreate">
        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 col-12 mx-auto">
                    <h3>Create a user</h3>
                    <hr />


                    <div class="mb-3">
                        <label class="form-label">Email:</label>
                        <form:input type="email" class="form-control" placeholder="Enter email" path="email" />
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Password:</label>
                        <form:input type="password" class="form-control" placeholder="Enter password" path="passWord" />
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Full Name:</label>
                        <form:input type="text" class="form-control" placeholder="Enter full name" path="fullName" />
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Address:</label>
                        <form:input type="text" class="form-control" placeholder="Enter Address" path="address" />
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Phone:</label>
                        <form:input type="text" class="form-control" placeholder="Enter number" path="phone" />
                    </div>

                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </div>
        </div>

    </form:form>
</body>

</html>