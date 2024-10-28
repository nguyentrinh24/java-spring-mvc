<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Administrator - Dự án laptopshop" />
                <meta name="author" content="Administrator" />
                <title>Dashboard - Administrator</title>
                <link href="/admin/css/style.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manager Product</h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active"><a href="/admin/user"> user</a></li>
                                </ol>
                                <form:form method="get" action="/admin/user/update" modelAttribute="userCreate">

                                    <div class="container mt-5">
                                        <div class="row">
                                            <div class="col-md-6 col-12 mx-auto">
                                                <h3>Update a user</h3>
                                                <hr />
                                                <div class="mb-3" style="display: none;">
                                                    <label class="form-label">ID:</label>
                                                    <form:input type="text" class="form-control" placeholder="ID"
                                                        path="id" />
                                                </div>

                                                <div class="mb-3">
                                                    <label class="form-label">Email:</label>
                                                    <form:input type="email" class="form-control"
                                                        placeholder="Enter email" path="email" readonly="true" />
                                                </div>

                                                <div class="mb-3">
                                                    <label class="form-label">Full Name:</label>
                                                    <form:input type="text" class="form-control"
                                                        placeholder="Enter full name" path="fullName" />
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label">Address:</label>
                                                    <form:input type="text" class="form-control"
                                                        placeholder="Enter Address" path="address" />
                                                </div>
                                                <div class="mb-3">
                                                    <label class="form-label">Phone:</label>
                                                    <form:input type="text" class="form-control"
                                                        placeholder="Enter number" path="phone" />
                                                </div>

                                                <div>
                                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                                        <button type="submit" class="btn btn-warning"
                                                            style="width: 15%;">Submit</button>
                                                        <a href="/admin/user" type="button" class="btn btn-success"
                                                            style="width: 15%;">Back</a>
                                                    </div>

                                                </div>

                                            </div>
                                        </div>
                                    </div>

                                </form:form>
                            </div>
                        </main>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/admin/js/scripts.js"></script>

            </body>

            </html>