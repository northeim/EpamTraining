package by.training.servlets;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@WebServlet(urlPatterns = "/test", initParams = @WebInitParam(name = "ddd", value = "ha-ha-ha"), loadOnStartup = 5)
//@WebInitParam(name = "fff", value = "ggg")
public class TestServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(TestServlet.class);

    private int hitCouter;


    @Override
    public void init() throws ServletException {
        super.init();
        LOGGER.debug("TestServlet has been loaded");
        hitCouter = 0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.debug("-------------------");
        LOGGER.debug(new Date(req.getSession().getCreationTime()).toString());
        LOGGER.debug("MaxInnactiveInterval " + req.getSession().getMaxInactiveInterval()/60);
        LOGGER.debug("-------------------");
        Enumeration<String> enumeration = req.getHeaderNames();
        while(enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = req.getHeader(name);
            LOGGER.debug(name + ": " + value);
        }
        LOGGER.debug("-------------------");
        enumeration = req.getAttributeNames();
        while(enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = (String) req.getAttribute(name);
            LOGGER.debug(name + ": " + value);
        }
        LOGGER.debug("-------------------");

        enumeration = req.getParameterNames();
        while(enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = req.getParameter(name);
            LOGGER.debug(name + ": " + value);
        }
        LOGGER.debug("-------------------");
        Cookie[] cookies = req.getCookies();
        for(int i = 0; i < cookies.length; i++) {
            LOGGER.debug(cookies[i].getName() + ": " + cookies[i].getValue());
            //cookies[i].setMaxAge(0);
            //resp.addCookie(cookies[i]);
        }
        LOGGER.debug("-------------------");


        //Cookie cookie = new Cookie("wewewe", "bebebe");
        //resp.addCookie(cookie);


        LOGGER.debug(req.getRequestedSessionId());
        LOGGER.debug("-------------------");
        Collection<String> collection = resp.getHeaderNames();
        for (String item : collection) {
            LOGGER.debug(item);
        }
        LOGGER.error("-------------------");
        HttpSession session = req.getSession();
        session.setAttribute("name", "dsf");
        session.setMaxInactiveInterval(0);
        String name = (String)session.getAttribute("name");

        //LOGGER.getAppender("stdout").getLayout().


        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Language", "es");

        PrintWriter out = resp.getWriter();

        out.println("<html><head><meta charset=\"utf-8\"></head><body>");


        out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()) + "<br>");
        out.println(++hitCouter + "<br>");

        out.println("Hash Qwerty :" + "qwerty".hashCode() + "<br>");
        out.println("Hash another Qwerty :" + "qwerty".hashCode() + "<br>");

//        try {
//            Properties properties = System.getProperties();
//            properties.setProperty("mail.smtp.host", "smtp.gmail.com");
//            properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//            properties.setProperty("mail.smtp.socketFactory.fallback", "false");
//            properties.setProperty("mail.smtp.port", "465");
//            properties.setProperty("mail.smtp.socketFactory.port", "465");
//            properties.put("mail.smtp.auth", "true");
//            properties.put("mail.debug", "true");
//            properties.put("mail.store.protocol", "pop3");
//            properties.put("mail.transport.protocol", "smtp");
//
//            Session session = Session.getDefaultInstance(properties, new Authenticator() {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return  new PasswordAuthentication("fedorov.pavel88@gmail.com", "Murmansk780453");
//                }
//            });
//
//
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("fedorov.pavel88@gmail.com"));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress("fedorov_p88@mail.ru"));
//            message.setSubject("HitCounter");
//            message.setText("HitCounter = " + hitCouter);
//
//
//            Transport.send(message);
//            out.println("Message send successfully");
//        } catch (MessagingException e) {
//            throw new RuntimeException(e);
//        }

        out.println("Locale = " + req.getLocale().toString() + "<br>");
        out.println("Country = " + req.getLocale().getCountry() + "<br>");
        out.println("DisplayCountry = " + req.getLocale().getDisplayCountry() + "<br>");
        out.println("DisplayLanguage = " + req.getLocale().getDisplayLanguage() + "<br>");
        out.println("ISO3Country = " + req.getLocale().getISO3Country() + "<br>");
        out.println("ISO3Language = " + req.getLocale().getISO3Language() + "<br>");
        out.println("Currency = " + NumberFormat.getCurrencyInstance(resp.getLocale()).format(1000000) + "<br>");
        out.println("Percentage = " + NumberFormat.getPercentInstance(resp.getLocale()).format(0.51) + "<br>");
        out.println(DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, resp.getLocale()).format(new Date()) + "<br>");
        out.println("Referer = " + req.getHeader("Referer")+ "<br>");
        out.println("User-Agent = " + req.getHeader("User-Agent")+ "<br>");
        out.println("CharacterEncoding = " + req.getCharacterEncoding()+ "<br>");
        out.println("ContextPath = " + req.getContextPath()+ "<br>");
        out.println("PathInfo = " + req.getPathInfo()+ "<br>");
        out.println("RequestURI = " + req.getRequestURI()+ "<br>");
        out.println("PathTranslated = " + req.getPathTranslated()+ "<br>");
        out.println("QueryString = " + req.getQueryString()+ "<br>");
        out.println("RequestURL = " + req.getRequestURL()+ "<br>");
        out.println("www.письма.рф = " + resp.encodeURL("www.письма.рф/ваы_4у")+ "<br>");
        out.println("SessionId = " + req.getSession().getId() + "<br>");
        out.println("AuthType = " + req.getAuthType() + "<br>");
        out.println("isUserInRole = " + req.isUserInRole("admin") + "<br>");
        out.println("UserPrincipal = " + req.getUserPrincipal().toString() + "<br>");
        out.println("RequestedSessionId = " + req.getRequestedSessionId() + "<br>");
        out.println("RemoteUser = " + req.getRemoteUser() + "<br>");

        ServletInputStream inputStream = req.getInputStream();
        int q = inputStream.available();
        byte[] arr = {};
        inputStream.read(arr, 0, q);
        out.println("InputStream = " + new String(arr) + "<br>");



        resp.setIntHeader("Refresh", 1);
        out.println("</body></html>");
        //resp.sendError(404, "Я сгенерил not found");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


}
