package ba.shop.phonestore.controller.login;

import ba.shop.phonestore.controller.router.Routes;
import ba.shop.phonestore.ejb.user.entity.User;
import ba.shop.phonestore.ejb.user.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

//http://localhost:8080/PhoneStore-1.0-SNAPSHOT/authentication
@WebServlet(name = "authenticationControllerServlet", value = "/authentication")
public class AuthenticationControllerServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userService.login(email, password);
        if (user == null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.LOGIN);
            requestDispatcher.forward(request, response);
        }else{
            UserSession.USER.addToSession(user, request);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.DASHBOARD_ACCESS);
            requestDispatcher.forward(request, response);
        }
    }
}
