<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
                <title>Table Users</title>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h2 class="mb-0">Table Users</h2>
                        <a href="/admin/user/create">
                            <button class="btn btn-primary">Create a User</button>
                        </a>
                    </div>
                    <table class="table table-bordered mt-4">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Email</th>
                                <th scope="col">Full Name</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="users" items="${arrUser}">
                                <tr>
                                    <th scope="row">${users.id}</th>
                                    <td>${users.email}</td>
                                    <td>${users.fullName}</td>
                                    <td>
                                        <a href="/admin/user/${users.id}" type="button" class="btn btn-success">View</a>
                                        <a href="/admin/user/update/${users.id}" type="button"
                                            class="btn btn-warning">Update</a>
                                        <a href="/admin/user/delete/${users.id}" type="button"
                                            class="btn btn-danger">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </body>

            </html>