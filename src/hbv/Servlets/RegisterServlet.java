package hbv.Servlets;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import hbv.Counter;
import hbv.MyLogger;
import hbv.ThreadCounter;
import hbv.DAO.PersonDAO;
import hbv.DTO.PersonDTO;
import hbv.Enum.Path;
import hbv.Enum.Roles;
import hbv.View.Html;
import hbv.View.RegisterView;

public class RegisterServlet extends HttpServlet {
    private ServletContext ctx;
    private PersonDAO DAO;
    private RegisterView view;

    public void init() throws ServletException {
        ctx = getServletContext();
        DAO = new PersonDAO();
        view = new RegisterView("Register");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        if (session != null) {
            response.sendRedirect(Path.STUDIENGANG.getPath());
        }
        view.update();
        out.print(view.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        ThreadCounter.incrCounter();
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String studiengang = request.getParameter("studiengang");
        String role = request.getParameter("role");
        PersonDTO person = new PersonDTO(username, password);
        person.setStudiengang(studiengang);
        person.setRole(role);

        if (username.isEmpty() || password.isEmpty()) {
            view.update();
            view.registerFail();
            out.println(view.toString());
            return;
        }

        if (DAO.insert(person)) {
            ThreadCounter.decrCounter();
            response.sendRedirect(Path.LOGIN.getPath());
            return;
        }

        view.update();
        view.registerFail();
        out.println(view.toString());
    }
}
