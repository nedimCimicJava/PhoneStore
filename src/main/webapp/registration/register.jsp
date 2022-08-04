<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col-12 col-lg-9 col-xl-7">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration</h3>
                        <form method="post" action="register">
                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="firstName" name="firstName"
                                               class="form-control form-control-lg" placeholder="Name"/>
                                    </div>

                                </div>
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input type="text" name="lastName" id="lastName"
                                               class="form-control form-control-lg" placeholder="Surname"/>
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="email" name="email"
                                               class="form-control form-control-lg" placeholder="Email"/>
                                        <p style="color: red"><%=request.getAttribute("message")==null?"":request.getAttribute("message")%></p>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="password" id="password" name="password"
                                               class="form-control form-control-lg" placeholder="Password"/>
                                    </div>

                                </div>
                            </div>

                            <div>
                                <p style="color: red"><%=request.getAttribute("emptyFieldMessage")==null?"":request.getAttribute("emptyFieldMessage")%></p>
                            </div>

                            <div class="mt-4 pt-2">
                                <input class="btn btn-primary btn-lg w-100" type="submit" value="Register"/>
                            </div>
                            <div class="text-center" style="padding-top: 20px;">
                                <p>Back to login? <a href="login">Login</a></p>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>