package ba.shop.phonestore.controller;

import ba.shop.phonestore.controller.router.Routes;
import ba.shop.phonestore.ejb.upload.FileUploadDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "fileUploadServlet", value = "/uploadServlet")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private FileUploadDao fileUploadDao;

    @Override
    public void init() {
        fileUploadDao = new FileUploadDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream fileInputStream = null;
        Part filePart = request.getPart("image");
        if (filePart != null) {
            fileInputStream = filePart.getInputStream();
        }
        int row = fileUploadDao.uploadFile(fileInputStream);
        if (row > 0) {
            request.setAttribute("Message", "Successfully uploaded");
        } else {
            request.setAttribute("Message", "Problem in uploading file");
        }
        getServletContext().getRequestDispatcher("/message.jsp")
                .forward(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.FILE_UPLOAD);
        requestDispatcher.forward(request, response);
    }
}

