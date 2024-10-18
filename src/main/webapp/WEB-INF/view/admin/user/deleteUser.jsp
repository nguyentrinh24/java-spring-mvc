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
                <title>User Details ${id}</title>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h2 class="mb-0">Delete user with ${id}</h2>

                    </div>
                    <tbody>
                        <div class="card" style="width: 60%;">
                            <div class="card-header">
                                Delete user
                            </div>
                            <div>

                                <div class="alert alert-warning" role="alert">
                                    are you sure delete ${user.fullName}
                                </div>



                            </div>
                            <form:form action="/admin/user/delete/${id}" method="post" modelAttribute="deleteUser">
                                <div class="mb-3" style="display: none;">
                                    <label class="form-label">ID:</label>
                                    <form:input type="text" class="form-control" placeholder="ID" value="${id}"
                                        path="id" />
                                </div>
                                <button class="btn btn-danger"> Confrim</button>
                            </form:form>
                        </div>

                        <a href="/admin/user" type="button" class="btn btn-success" style="width: 10%;">Back</a>
                    </tbody>

                </div>
            </body>

            </html>