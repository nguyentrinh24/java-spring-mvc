<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
                                    <li class="breadcrumb-item active"><a href="/admin/product"> Products</a></li>
                                </ol>
                                <div class="container mt-5">
                                    <div class="d-flex justify-content-between align-items-center mb-3">
                                        <h2 class="mb-0"> Product Details with ${id}</h2>

                                    </div>
                                    <tbody>
                                        <div class="card" style="width: 60%;">
                                            <div class="card-header">
                                                Product information
                                            </div>
                                            <div>

                                                <ul class="list-group list-group-flush">

                                                    <li class="list-group-item">ID:${showProductPage.id}</li>
                                                    <li class="list-group-item">Name:${showProductPage.name}</li>
                                                    <li class="list-group-item">Price:${showProductPage.price}</li>
                                                    <li class="list-group-item">Factory:${showProductPage.factory}</li>
                                                    <li class="list-group-item">quanity:${showProductPage.quanity}</li>
                                                    <li class="list-group-item">detailDesc:${showProductPage.detailDesc}
                                                    </li>
                                                    <li class="list-group-item">shortDesc:${showProductPage.shortDesc}
                                                    </li>
                                                    <li class="list-group-item">target:${showProductPage.target}</li>
                                                    <li class="list-group-item">sold:${showProductPage.sold}</li>



                                                </ul>

                                            </div>

                                        </div>

                                        <a href="/admin/product" type="button" class="btn btn-success"
                                            style="width: 10%;">Back</a>
                                    </tbody>

                                </div>
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