package ba.shop.phonestore.controller.login;

import ba.shop.phonestore.controller.router.Routes;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
//http://localhost:8080/PhoneStore-1.0-SNAPSHOT/login
//http://localhost:8080/PhoneStore-1.0-SNAPSHOT/authentication/login.jsp
@WebServlet(name = "loginControllerServlet", value = "/login")
public class LoginControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.LOGIN);
        //login.jsp has control and does not back to previous
        requestDispatcher.forward(request, response);
    }
}
