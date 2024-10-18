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


                <title>Update</title>
</head>

<body>
    <form:form method="get" action="/admin/user/update" modelAttribute="userCreate">

        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 col-12 mx-auto">
                    <h3>Update a user</h3>
                    <hr />
                    <div class="mb-3" style="display: none;">
                        <label class="form-label">ID:</label>
                        <form:input type="text" class="form-control" placeholder="ID" path="id" />
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Email:</label>
                        <form:input type="email" class="form-control" placeholder="Enter email" path="email"
                            readonly="true" />
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

                    <div>
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <button type="submit" class="btn btn-warning" style="width: 15%;">Submit</button>
                            <a href="/admin/user" type="button" class="btn btn-success" style="width: 15%;">Back</a>
                        </div>

                    </div>

                </div>
            </div>
        </div>

    </form:form>
</body>

</html>