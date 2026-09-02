package hbv.Servlets;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import hbv.MyLogger;
import hbv.DAO.PersonDAO;
import hbv.DTO.PersonDTO;
import hbv.Enum.Path;
import hbv.View.Html;
import hbv.View.LoginView;

public class LoginServlet extends HttpServlet {
    private ServletContext ctx;
    private PersonDAO DAO;
    private LoginView view;

    public void init() throws ServletException {
        ctx = getServletContext();
        DAO = new PersonDAO();
        view = new LoginView("Login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        view.update();
        out.print(view.toString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        PersonDTO person = new PersonDTO(username, password);
        if (DAO.authenticate(person)) {
            HttpSession session = request.getSession();
            session.setAttribute("login-state", person);
            response.sendRedirect(Path.STUDIENGANG.getPath());
        } else {
            view.update();
            view.loginFail();
            out.print(view.toString());
        }
    }
}
