package by.training;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Created by Pasha_1 on 24.08.2017.
 */
public class SessionObj implements HttpSessionBindingListener {


    public void valueBound(HttpSessionBindingEvent event) {

        System.out.println("Obj has been included in Session");
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("Obj has been removed from Session");
    }
}
