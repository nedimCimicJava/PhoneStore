package ba.shop.phonestore.controller.dashboard.products;

import ba.shop.phonestore.controller.login.UserSession;
import ba.shop.phonestore.controller.router.Routes;
import ba.shop.phonestore.ejb.products.entity.Products;
import ba.shop.phonestore.ejb.products.service.ProductService;
import ba.shop.phonestore.ejb.user.entity.User;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productsControllerServlet", value = "/products")
public class ProductsControllerServlet extends HttpServlet {

    @Inject
    private ProductService productService;

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
            List<Products> productsList = productService.findAll();
            request.setAttribute("products", productsList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.PRODUCTS);
            requestDispatcher.forward(request, response);
        }else{
           RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.LOGIN);
           requestDispatcher.forward(request, response);
        }
    }
}
