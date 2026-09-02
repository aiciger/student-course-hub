package hbv;

import javax.servlet.*;

import java.util.*;
import java.time.*;

public class MyContextListener implements ServletContextListener {
    Timer timer;

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        ctx.log("initialized");
        MyLogger.init(servletContextEvent);
        TimerTask task = new TimerTask() {
            public void run() {
                ctx.log("Threads: " + ThreadCounter.getCounter());
            }
        };
        timer = new Timer("timer." + ctx.getContextPath(), true);
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        ctx.log("cancel timer");
        // timer.cancel();
    }
}
