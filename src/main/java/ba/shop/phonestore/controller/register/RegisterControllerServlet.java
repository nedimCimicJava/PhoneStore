package ba.shop.phonestore.controller.register;

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

@WebServlet(name = "registerControllerServlet", value = "/register")
public class RegisterControllerServlet extends HttpServlet {

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
        RegisterModel registerModel = RegisterModel.builder()
                .firstName(request.getParameter("firstName"))
                .lastName(request.getParameter("lastName"))
                .email(request.getParameter("email"))
                .plainPassword(request.getParameter("password"))
                .build();

        RegisterController registerController = new RegisterController(userService, registerModel);
        if (registerController.isValidRegisterModel()){
            if (registerController.isEmailOccupied()){
                request.setAttribute("message", String.format("Email '%s' is already used", registerModel.getEmail()));
                RequestDispatcher registerDispatcher = request.getRequestDispatcher(Routes.REGISTRATION_FORM);
                registerDispatcher.forward(request, response);
            }else{
                User user = userService.register(registerModel);
                if (user != null){
                    RequestDispatcher registerDispatcher = request.getRequestDispatcher(Routes.LOGIN);
                    registerDispatcher.forward(request, response);
                }else{
                    RequestDispatcher registerDispatcher = request.getRequestDispatcher(Routes.REGISTRATION_FORM);
                    registerDispatcher.forward(request, response);
                }
            }
        }else{
            request.setAttribute("emptyFieldMessage", String.format("All fields must be filled out", registerModel.getEmail()));
            RequestDispatcher registerDispatcher = request.getRequestDispatcher(Routes.REGISTRATION_FORM);
            registerDispatcher.forward(request, response);
        }
    }
}
