package ba.shop.phonestore.controller.filter;

import ba.shop.phonestore.controller.login.UserSession;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter(urlPatterns = {"/dashboard/*"})
public class LoginFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    //before any doGet or doPost request (before any ControllerServlet)
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        this.context.log("doFilter is called");
        if (UserSession.USER.getFromSession(request) == null){
            response.sendRedirect((request.getContextPath() + "/login"));
        }else{
            chain.doFilter(request, response);
        }
    }
}
