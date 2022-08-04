<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="padding-left: 50px;">
    <a class="navbar-brand" href="#" >Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="products">Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Credentials</a>
            </li>
            <li class="nav-item btn btn-link btn-logout"><a href="logout">Logout</a></li>
        </ul>
    </div>
    <div>
    </div>
    <div id="menuContent">
        <%--<script>
            var arr = ["images/img1.jpg","images/img2.jpg","images/img3.jpg","images/img4.jpeg","images/img5.png","images/img6.jpeg"];
            var allImages = arr.length;
            var actImage = 0;
            function switchImage()
            {
                var img = document.getElementById("imgPh");
                img.src="http://localhost:8080/PhoneStore-1.0-SNAPSHOT/" + arr[actImage];
                if(actImage<allImages-1)
                    actImage++;
                else
                    actImage=0;
                setTimeout("switchImage()",3000);
            }
        </script>--%>
        <img id="imgPh" src="http://localhost:8080/images"/>
    </div>
</nav>
</body>
</html>

