package ba.shop.phonestore.controller.dashboard;

import ba.shop.phonestore.controller.login.UserSession;
import ba.shop.phonestore.controller.router.Routes;
import ba.shop.phonestore.ejb.user.entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "dashboardControllerServlet", value = "/dashboardAccess")
public class DashboardControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User userSession = UserSession.USER.getFromSession(request);
        if (userSession != null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.DASHBOARD);
            requestDispatcher.forward(request, response);
        }else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.LOGIN);
            requestDispatcher.forward(request, response);
        }
    }
}
