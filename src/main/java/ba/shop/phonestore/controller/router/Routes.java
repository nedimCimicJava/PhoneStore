package ba.shop.phonestore.controller.router;

//every field inside Interface is public static final - constant
public interface Routes {

    //paths
    String LOGIN = "authentication/login.jsp";
    String DASHBOARD_ACCESS = "dashboardAccess";
    String DASHBOARD = "dashboard/dashboard.jsp";
    String REGISTRATION_FORM = "registration/register.jsp";
    String PRODUCTS = "dashboard/products.jsp";
    String FILE_UPLOAD = "dashboard/uploadPictureAdmin.jsp";
    String BUY_PRODUCT = "dashboard/buyProduct.jsp";
    String SUCCESS_MESSAGE = "dashboard/success.jsp";
}
