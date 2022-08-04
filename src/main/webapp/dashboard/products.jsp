<%@ page import="ba.shop.phonestore.ejb.products.entity.Products" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mobile Phones</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
</head>
<body>
<div class="card">
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">
        Mobile Phones
    </h3>
    <div style="padding: 20px">
        <%
            List<Products> product = (List<Products>) request.getAttribute("products");
        %>
        <form action="buy" method="post" class="row g-3 needs-validation" novalidate>

            <div class="col-8" style="padding: 20px;">
                <button class="nav-item">
                    <a class="nav-link" href="buyProduct">Buy</a>
                </button>

                <button class="btn btn-link" type="button"
                        onclick="location.href = '${pageContext.request.contextPath}/dashboardAccess';">Back to homepage
                </button>
            </div>
        </form>
        <div class="card-body" style="padding: 20px;">
            <div id="table" class="table-editable">
                    <span class="table-add float-right mb-3 mr-2">
                        <a href="#" class="text-success"><i class="fas fa-plus fa-2x" aria-hidden="true"></i></a>
                    </span>
                <table class="table table-bordered table-responsive-md table-striped text-center">
                    <thead>
                    <tr>
                        <th class="text-center">Product</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Description</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (Products products : product){
                    %>
                    <tr>
                        <td class="pt-3-half" contenteditable="true"><%=products.getName()%>
                        </td>
                        <td class="pt-3-half" contenteditable="true"><%=products.getPrice()%>
                        </td>
                        <td class="pt-3-half" contenteditable="true"><%=products.getDescription()%>
                        </td>
                    </tr>
                    <%}%>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
