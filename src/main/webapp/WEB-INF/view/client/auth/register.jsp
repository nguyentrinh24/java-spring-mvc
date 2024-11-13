<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
            <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="utf-8" />
                    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                    <meta name="description" content="" />
                    <meta name="author" content="" />
                    <title>Register - SB Admin</title>
                    <link href="/client/css/style.css" rel="stylesheet" />
                    <link href="/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
                    <link href="/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

                    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
                        crossorigin="anonymous"></script>

                    <style>
                        body,
                        html {
                            height: 100%;
                            margin: 0;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            background-color: #007bff;
                        }

                        .container {
                            width: 100%;
                            max-width: 600px;
                            padding: 40px;
                            background-color: white;
                            border-radius: 8px;
                            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
                        }

                        .card-header h3 {
                            text-align: center;
                            font-size: 1.75rem;
                            color: #333;
                            font-weight: bold;
                        }

                        .form-floating {
                            margin-bottom: 15px;
                        }

                        .form-control {
                            width: 100%;
                            border-radius: 5px;
                            padding: 12px;
                            font-size: 1rem;
                            border: 1px solid #ccc;
                            transition: all 0.3s ease;
                        }

                        .form-control:focus {
                            border-color: #007bff;
                            box-shadow: 0 0 5px rgba(0, 123, 255, 0.3);
                            outline: none;
                        }

                        .btn-primary {
                            width: 100%;
                            background-color: #007bff;
                            border: none;
                            padding: 14px;
                            font-size: 1.1rem;
                            font-weight: bold;
                            border-radius: 5px;
                            transition: background-color 0.3s ease;
                        }

                        .btn-primary:hover {
                            background-color: #0056b3;
                        }

                        .card-footer .small a {
                            color: #007bff;
                            text-decoration: none;
                        }

                        .card-footer .small a:hover {
                            text-decoration: underline;
                        }

                        @media (max-width: 768px) {
                            .container {
                                width: 90%;
                            }
                        }

                        .invalid-feedback {
                            color: red;
                            font-size: 0.875rem;
                        }
                    </style>
                </head>

                <body class="bg-primary">
                    <div id="layoutAuthentication">
                        <div id="layoutAuthentication_content">
                            <main>
                                <div class="container">
                                    <div class="row justify-content-center">
                                        <div class="col-lg-7">
                                            <div class="card shadow-lg border-0 rounded-lg mt-5">
                                                <div class="card-header">
                                                    <h3 class="text-center font-weight-light my-4">Create Account</h3>
                                                </div>
                                                <div class="card-body">
                                                    <form:form action="/register" method="POST"
                                                        modelAttribute="registerUser">

                                                        <div class="row mb-3">
                                                            <div class="col-md-6">
                                                                <label for="inputFirstName" class="form-label">First
                                                                    Name</label>
                                                                <div class="form-floating mb-3 mb-md-0">
                                                                    <form:input class="form-control" id="inputFirstName"
                                                                        path="firstName"
                                                                        placeholder="Enter your first name" />
                                                                    <form:errors path="firstName"
                                                                        cssClass="invalid-feedback" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <label for="inputLastName" class="form-label">Last
                                                                    Name</label>
                                                                <div class="form-floating">
                                                                    <form:input class="form-control" id="inputLastName"
                                                                        path="lastName"
                                                                        placeholder="Enter your last name" />
                                                                    <form:errors path="lastName"
                                                                        cssClass="invalid-feedback" />
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="form-floating mb-3">
                                                            <label for="inputEmail" class="form-label">Email
                                                                Address</label>
                                                            <form:input
                                                                class="form-control ${not empty errorsEmail ? 'is-invalid' : ''}"
                                                                id="inputEmail" path="email"
                                                                placeholder="name@example.com" />
                                                            <form:errors path="email" cssClass="invalid-feedback" />
                                                        </div>

                                                        <div class="row mb-3">
                                                            <div class="col-md-6">
                                                                <label for="inputPassword"
                                                                    class="form-label">Password</label>
                                                                <div class="form-floating mb-3 mb-md-0">
                                                                    <form:input
                                                                        class="form-control ${not empty errorsConfirmPassword ? 'is-invalid' : ''}"
                                                                        id="inputPassword" path="password"
                                                                        placeholder="Create a password"
                                                                        type="password" />
                                                                    <form:errors path="password"
                                                                        cssClass="invalid-feedback" />
                                                                </div>
                                                            </div>
                                                            <div class="col-md-6">
                                                                <label for="inputPasswordConfirm"
                                                                    class="form-label">Confirm Password</label>
                                                                <div class="form-floating mb-3 mb-md-0">
                                                                    <form:input class="form-control"
                                                                        id="inputPasswordConfirm" path="confirmPassword"
                                                                        placeholder="Confirm password"
                                                                        type="password" />
                                                                    <form:errors path="confirmPassword"
                                                                        cssClass="invalid-feedback" />
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <div class="mt-4 mb-0">
                                                            <button type="submit"
                                                                class="btn btn-primary btn-block">Create
                                                                Account</button>
                                                        </div>
                                                    </form:form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </main>
                        </div>

                        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
                        <script src="/client/lib/owlcarousel/owl.carousel.min.js"></script>
                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                            crossorigin="anonymous"></script>
                        <script src="/client/js/main.js"></script>
                    </div>
                </body>

                </html>