<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy a Mobile Phone</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<section class="vh-100 gradient-custom">
    <div class="container py-5 h-100">
        <div class="row justify-content-center align-items-left h-100">
            <div class="col-12 col-lg-9 col-xl-7">
                <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Buy a Mobile Phone</h3>
                        <form method="post" action="buyProduct">
                            <div class="">
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input type="text" id="product" name="product"
                                               class="form-control form-control-lg" placeholder="Mobile Phone"/>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input type="text" name="streetAddress" id="streetAddress"
                                               class="form-control form-control-lg" placeholder="Street Address"/>
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <input type="number" id="postalCode" name="postalCode"
                                               class="form-control form-control-lg" placeholder="Postal Code"/>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4">

                                    <div class="form-outline">
                                        <input type="number" id="phoneNumber" name="phoneNumber"
                                               class="form-control form-control-lg" placeholder="Phone Number"/>
                                    </div>

                                </div>
                            </div>

                            <div class="mt-4 pt-2">
                                <input class="btn btn-primary btn-lg w-100" type="submit" value="Buy"/>
                                <a class="nav-link" href="success.jsp">Reserve</a>
                            </div>
                            <div class="text-center" style="padding-top: 20px;">
                                <p>Back to products list? <a href="products">Products</a></p>
                            </div>
                        </form>
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