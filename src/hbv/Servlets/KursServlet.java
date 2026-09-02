package hbv.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;

import hbv.MyLogger;
import hbv.DAO.KursDAO;
import hbv.DTO.KursDTO;
import hbv.DTO.PersonDTO;
import hbv.Enum.Path;
import hbv.View.KursView;

public class KursServlet extends HttpServlet {
    private ServletContext ctx;
    private KursDAO DAO;
    private  KursView view;

    public void init() throws ServletException {
        ctx = getServletContext();
        DAO = new KursDAO();
        view = new KursView("Kurse");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = request.getPathInfo();
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        String query = request.getParameter("join");
        String kursName = path.split("/")[1];

        if (session == null) {
            response.sendRedirect(Path.LOGIN.getPath());
            return;
        }

        if (path == null) {
            response.sendRedirect(Path.NOT_FOUND.getPath());
            return;
        }

        PersonDTO person = (PersonDTO) session.getAttribute("login-state");
        KursDTO kurs = DAO.findKursUndTeilnehmer(kursName);

        if (kurs == null) {
            response.sendRedirect(Path.NOT_FOUND.getPath());
            return;
        }

        if (query != null) {
            if (Boolean.parseBoolean(query)) {
                DAO.insertPersonToKurs(person, kurs);
                kurs = DAO.findKursUndTeilnehmer(kursName);
            } else {
                DAO.deletePersonFromKurs(person, kurs);
                kurs = DAO.findKursUndTeilnehmer(kursName);
            }
        }

        view.update(kurs);
        out.print(view.toString());
    }
}