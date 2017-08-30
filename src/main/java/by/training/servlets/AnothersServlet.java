package by.training.servlets;

import by.training.SessionObj;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(urlPatterns = "/another")
public class AnothersServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AnothersServlet.class.getName());

    private String filePath;
    private boolean isMultiPart;
    private File file;
    private int maxFileSize = 50000 * 1024;
    private int maxMemSize = 40000 * 1024;

    @Override
    public void init() throws ServletException {
        filePath = getServletContext().getInitParameter("file-upload");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        throw new ServletException("GET method used with " + getClass().getName() + ": POST method requred.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        isMultiPart = ServletFileUpload.isMultipartContent(req);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if(!isMultiPart) {
            out.println("No file Uploaded");
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(maxMemSize);
        factory.setRepository(new File("c:\\temp"));
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(maxFileSize);

        try {
            List<FileItem> fileItems = upload.parseRequest(req);
            Iterator<FileItem> i = fileItems.iterator();
            out.println("Servlet Upload");

            while(i.hasNext()) {
                FileItem fi = (FileItem)i.next();
                if(!fi.isFormField()) {
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    fi.write(file);
                    out.println("Upload FileName: " + fileName + "<br>");
                }


            }


        } catch (Exception e) {
            LOGGER.debug(e.getMessage(), e);
            throw new ServletException(e.getMessage());
        }




    }
}
