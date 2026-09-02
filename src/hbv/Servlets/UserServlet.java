package hbv.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import hbv.View.UserView;
import hbv.MyLogger;
import hbv.DAO.PersonDAO;
import hbv.DTO.PersonDTO;
import hbv.Enum.Path;

public class UserServlet extends HttpServlet {
    private ServletContext ctx;
    private PersonDAO DAO;
    private UserView view;

    public void init() throws ServletException {
        ctx = getServletContext();
        DAO = new PersonDAO();
        view = new UserView("User");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String path = request.getPathInfo();
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect(Path.LOGIN.getPath());
            return;
        }

        if (path == null) {
            List<PersonDTO> userlist = DAO.findAll();
            view.update(userlist);
            out.print(view.toString());
            return;
        }
        
        if (path.equalsIgnoreCase("/me")) {
            PersonDTO person = DAO.findByName(((PersonDTO) session.getAttribute("login-state")).getName());
            view.update(person);
            out.print(view.toString());
            return;
        }

        PersonDTO person = DAO.findByName(path.split("/")[1]);
        if (person == null) {
            response.sendRedirect(Path.NOT_FOUND.getPath());
            return;
        }

        view.update(person);
        out.print(view.toString());
    }
}