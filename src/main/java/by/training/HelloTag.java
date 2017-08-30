package by.training;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;

/**
 * Created by Pasha_1 on 30.08.2017.
 */
public class HelloTag extends SimpleTagSupport {

    private StringWriter sw = new StringWriter();

    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspBody().invoke(sw);
        getJspContext().getOut().println("<p style=\"background-color: " + color + "\">" + sw.toString() + "</p>");
    }
}
