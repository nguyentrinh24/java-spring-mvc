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

                <script src="https: //ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js">
                </script>
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
                                    <li class="breadcrumb-item active"><a href="/admin/user"> user</a></li>
                                </ol>
                                <form:form method="POST" action="/admin/user/create" modelAttribute="userCreate"
                                    enctype="multipart/form-data">

                                    <div class="row">
                                        <div class="col-md-6 col-12 mx-auto">
                                            <h3>Create a user</h3>
                                            <hr />

                                            <div class="row g-3">
                                                <div class="col">
                                                    <div class="mb-3">
                                                        <label class="form-label">Email:</label>
                                                        <form:input type="email" class="form-control"
                                                            placeholder="Enter email" path="email" />
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="mb-3">
                                                        <label class="form-label">Password:</label>
                                                        <form:input type="password" class="form-control"
                                                            placeholder="Enter password" path="passWord" />
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row g-3">
                                                <div class="col">
                                                    <div class="mb-3">
                                                        <label class="form-label">Full Name:</label>
                                                        <form:input type="text" class="form-control"
                                                            placeholder="Enter full name" path="fullName" />
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="mb-3">
                                                        <label class="form-label">Phone:</label>
                                                        <form:input type="text" class="form-control"
                                                            placeholder="Enter number" path="phone" />
                                                    </div>
                                                </div>
                                            </div>


                                            <div class="mb-3">
                                                <label class="form-label">Address:</label>
                                                <form:input type="text" class="form-control" placeholder="Enter Address"
                                                    path="address" />
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <label class="form-label">Role</label>
                                                    <form:select class="form-select" path="role.name">

                                                        <form:option value="Admin">Admin</form:option>
                                                        <form:option value="Admin">User</form:option>

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