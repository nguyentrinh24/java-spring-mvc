<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
                <!DOCTYPE html>
                <html lang="vi">

                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>403 - Truy cập bị từ chối</title>
                    <!-- Bootstrap CSS -->
                    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
                        rel="stylesheet">
                </head>

                <body class="bg-light">
                    <div class="container text-center mt-5">
                        <div class="row justify-content-center">
                            <div class="col-md-8">
                                <div class="card border-danger">
                                    <div class="card-header bg-danger text-white">
                                        <h2>403 - Truy cập bị từ chối</h2>
                                    </div>
                                    <div class="card-body">
                                        <p class="lead">Xin lỗi, bạn không có quyền truy cập vào trang này.</p>
                                        </p>
                                        <a href="/" class="btn btn-primary">Quay lại trang chủ</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Bootstrap JS (optional, nếu bạn cần các thành phần tương tác) -->
                    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
                    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
                </body>

                </html>