<%@page language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<html>
<body>
    <div class="container-fluid">
        <section class="">
            <div class="px-4 py-5 px-md-5 text-center text-lg-start" style="background-color: hsl(0, 0%, 96%)">
                    <div class="card col-sm-4 mx-auto">
                        <div class="card-body py-5 px-md-5" style="background-color: lightblue">
                            <form action="/loginAction" method="post">
                                <div class="text-center">
                                    <h2 class="fw-bold ls-tight text-center" style="color: blue">
                                        Dang Nhap <br/>
                                    </h2>
                                </div>
                                <div class="row">
                                    <div class="form-outline mb-4">
                                        <div class="form-outline">
                                            <label class="form-label" for="form3Example1">User Name</label>
                                            <input name="username" type="text" id="form3Example1"
                                                   class="form-control"/>
                                        </div>
                                        <!-- Password input -->
                                        <div class="form-outline mb-4">
                                            <label class="form-label" for="form3Example4">Password</label>
                                            <input name="password" type="password" id="form3Example4"
                                                   class="form-control"/>
                                        </div>
                                            <% if (request.getAttribute("success") != null) { %>
                                        <div class="alert alert-success" role="alert">
                                            <%= request.getAttribute("success") %>
                                        </div>
                                            <% } %>

                                        <span style="color: red">${message}</span>
                                        <br>
                                        <!-- Submit button -->
                                        <button type="submit" class="btn btn-block mb-4"
                                                style="background-color: cornflowerblue">
                                            Login
                                        </button>
                                        <span class="mb-4" style="display: block">Bạn chưa có tài khoản? <a
                                                style="color: blue" href="#">Singup</a></span>

                                        <!-- Register buttons -->
                            </form>
                        </div>
                    </div>
                </div>
            <!-- Jumbotron -->
        </section>
        <!-- Section: Design Block -->
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>

</body>
</html>