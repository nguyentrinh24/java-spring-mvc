<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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

                <script src="https: //ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"> </script>
                <script>
                    $(document).ready(() => {
                        const avatarFile = $("#avatarFile");
                        avatarFile.change(function (e) {
                            const imgURL = URL.createObjectURL(e.target.files[0]);
                            $("#avatarPreview").attr("src", imgURL);
                            $("#avatarPreview").css({ "display": "block" });
                        });
                    });
                </script>
            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <main>
                            <div class="container-fluid px-4">
                                <h1 class="mt-4">Manager Order </h1>
                                <ol class="breadcrumb mb-4">
                                    <li class="breadcrumb-item active"><a href="/admin">Dashboard</a></li>
                                    <li class="breadcrumb-item active"><a href="/admin/product">Product</a></li>
                                </ol>
                                <form:form method="POST" action="/admin/product/update" modelAttribute="productCreate"
                                    enctype="multipart/form-data">

                                    <div class="row">
                                        <div class="col-md-6 col-12 mx-auto">
                                            <h3>update a product</h3>
                                            <hr />
                                            <div class="mb-3" style="display: none;">
                                                <label class="form-label">ID:</label>
                                                <form:input type="text" class="form-control" placeholder="ID"
                                                    path="id" />
                                            </div>
                                            <div class="row g-3">
                                                <div class="col">
                                                    <div class="mb-3">
                                                        <label class="form-label">Name:</label>
                                                        <form:input type="name" class="form-control"
                                                            placeholder="Enter name" path="name" />
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="mb-3">
                                                        <label class="form-label">Price:</label>
                                                        <form:input type="number" step="0.01" class="form-control"
                                                            placeholder="Enter Price" path="price" />
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row g-3">
                                                <div class="col">
                                                    <div class="mb-3">
                                                        <label class="form-label">Detail Decscription:</label>
                                                        <form:input type="text" class="form-control"
                                                            placeholder="Enter detail description" path="detailDesc" />
                                                    </div>
                                                </div>


                                            </div>
                                            <div class="row g-3">
                                                <div class="col">
                                                    <div class="mb-3">
                                                        <label class="form-label">Short decscription:</label>
                                                        <form:input type="text" class="form-control"
                                                            placeholder="Enter short decscription" path="shortDesc" />
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="mb-3">
                                                        <label class="form-label">Quantity:</label>
                                                        <form:input type="number" class="form-control"
                                                            placeholder="Enter " path="quantity" />
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <!-- Danh sách hãng sản xuất -->
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Factory</label>
                                                    <form:select class="form-select" path="factory">
                                                        <form:option value="apple">Apple</form:option>
                                                        <form:option value="asus">Asus</form:option>
                                                        <form:option value="dell">Dell</form:option>
                                                        <form:option value="hp">HP</form:option>
                                                        <form:option value="lenovo">Lenovo</form:option>
                                                        <form:option value="acer">Acer</form:option>
                                                        <form:option value="msi">MSI</form:option>
                                                        <form:option value="microsoft">Microsoft</form:option>
                                                        <form:option value="samsung">Samsung</form:option>
                                                        <form:option value="huawei">Huawei</form:option>
                                                    </form:select>
                                                </div>

                                                <!-- Mục tiêu người dùng -->
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Target</label>
                                                    <form:select class="form-select" path="target">
                                                        <form:option value="sinhvien">Sinh viên</form:option>
                                                        <form:option value="vanphong">Văn phòng</form:option>
                                                        <form:option value="doanhnhan">Doanh nhân</form:option>
                                                        <form:option value="gamers">Game thủ</form:option>
                                                    </form:select>
                                                </div>


                                                <div class="mb-3 col-12 col-md-6">
                                                    <label for="avatarFile" class="form-label">Avatar:</label>
                                                    <input class="form-control" type="file" id="avatarFile"
                                                        accept=".png, .jpg, .jpeg" name="hoidanitFile" />
                                                </div>

                                                <div class="col-12 mb-3">
                                                    <img style="max-height: 250px; display: none;" alt="avatar preview"
                                                        id="avatarPreview" />
                                                </div>
                                            </div>



                                            <button type="submit" class="btn btn-primary">Submit</button>
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