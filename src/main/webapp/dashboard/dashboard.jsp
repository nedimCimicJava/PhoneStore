<%@ page import="ba.shop.phonestore.ejb.user.entity.User" %>
<%@ page import="ba.shop.phonestore.controller.login.UserSession" %>
<%@ page import="ba.shop.phonestore.ejb.user.privilege.entity.Privilege" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
</head>
<body>

        <%User sessionUser = UserSession.USER.getFromSession(request);
        Privilege privilege = sessionUser.getPrivilege();
        String nameOfPrivilege = privilege.getPrivileges();%>

        <% if (nameOfPrivilege.equalsIgnoreCase("administrator")){%>
              <%@include file="nav/adminDashboard.jsp"%>
        <%} else {%>
              <%@include file="nav/userDashboard.jsp" %>
        <%}%>

</body>
</html>
