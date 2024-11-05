<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <li class="breadcrumb-item active"><a href="/admin/product"> Product</a></li>
                            </ol>

                            <div class="d-flex justify-content-between align-items-center mb-3">
                                <h2 class="mb-0">Table Product</h2>
                                <a href="/admin/product/createProduct">
                                    <button class="btn btn-primary">Create a Product</button>
                                </a>
                            </div>
                            <table class="table table-bordered mt-4">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Factory</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="product" items="${arrProduct}">
                                        <tr>
                                            <th scope="row">${product.id}</th>
                                            <td>${product.name}</td>
                                            <td>${product.price}</td>
                                            <td>${product.factory}</td>
                                            <td>
                                                <a href="/admin/product/{product.id}" type="button"
                                                    class="btn btn-success">View</a>
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
                    </main>
                    <jsp:include page="../layout/footer.jsp" />
                </div>
            </div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                crossorigin="anonymous"></script>
            <script src="/admin/js/scripts.js"></script>

        </body>

        </html>