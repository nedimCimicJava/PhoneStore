<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Login to My Mobile Phone Shop</title>
</head>
<body>
<section class=" text-center text-lg-start">
    <style>
        .rounded-t-5 {
            border-top-left-radius: 0.5rem;
            border-top-right-radius: 0.5rem;
        }

        @media (min-width: 992px) {
            .rounded-tr-lg-0 {
                border-top-right-radius: 0;
            }

            .rounded-bl-lg-5 {
                border-bottom-left-radius: 0.5rem;
            }
        }
    </style>

    <div class="card mb-3">
        <div class="row g-0 d-flex align-items-center">
            <div class="col-lg-4 d-none d-lg-flex">
                <img src="https://mdbootstrap.com/img/new/ecommerce/vertical/004.jpg" alt="Trendy Pants and Shoes"
                     class="w-100 rounded-t-5 rounded-tr-lg-0 rounded-bl-lg-5" />
            </div>
            <div class="col-lg-8">
                <div class="card-body py-5 px-md-5">

                    <form action="authentication" method="post">
                        <!-- Email input -->
                        <div class="form-outline mb-4">
                            <label for="email" class="form-label">Email</label>
                            <input id="email" name="email" type="text" placeholder="Your Email.." required
                                   class="form-control"/>
                        </div>

                        <!-- Password input -->
                        <div class="form-outline mb-4">
                            <label for="password" class="form-label">Password</label>
                            <input id="password" name="password" type="password" placeholder="Enter password.." required
                                   class="form-control"/>
                        </div>

                        <!-- Submit button -->
                        <button type="submit" class="btn btn-primary btn-block mb-4">Log in</button>

                        <!--Go to registration-->
                        <div class="text-center">
                            <p>Not a member? <a href="registration">Register</a></p>
                        </div>

                    </form>

                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
