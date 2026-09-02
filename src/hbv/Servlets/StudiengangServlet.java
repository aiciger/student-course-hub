package hbv.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import hbv.Counter;
import hbv.ThreadCounter;
import hbv.DAO.StudiengangDAO;
import hbv.DTO.StudiengangDTO;
import hbv.Enum.Path;
import hbv.View.StudiengangView;

public class StudiengangServlet extends HttpServlet {
    private ServletContext ctx;
    private StudiengangDAO DAO;
    private StudiengangView view;

    public void init() throws ServletException {
        ctx = getServletContext();
        DAO = new StudiengangDAO();
        view = new StudiengangView("Studiengänge");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        long then = System.currentTimeMillis();
        ThreadCounter.incrCounter();
        String path = request.getPathInfo();
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        if (session == null) {
            response.sendRedirect(Path.LOGIN.getPath());
            return;
        }

        if (path == null) {
            List<StudiengangDTO> studiengaenge = DAO.findAll();
            view.update(studiengaenge);
            out.print(view.toString());
            return;
        }

        StudiengangDTO studiengang = DAO.findKurse(path.split("/")[1]);
        if (studiengang == null) {
            response.sendRedirect(Path.NOT_FOUND.getPath());
            return;
        }

        view.update(studiengang);
        out.print(view.toString());

        Counter.incrCounter();
        long now = System.currentTimeMillis();
        // MyLogger.log("time: " + (now - then));
        ThreadCounter.decrCounter();
    }
}