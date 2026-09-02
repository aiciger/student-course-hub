package hbv;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

public class MyLogger {
    private static ServletContext ctx = null;

    public static void log(String msg) {
        ctx.log(msg);
    }

    public static void init(ServletContextEvent e) {
        ctx = e.getServletContext();
    }
}
