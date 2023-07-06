package controller;

import java.io.IOException;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonDAO;
import model.PersonDTO;

@WebServlet(urlPatterns = "/")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getParameter("action");

        switch (action == null ? "default" : action) {
            case "delete":
                PersonDAO.deletePerson(new PersonDTO(Integer.parseInt(request.getParameter("id"))));
                this.refrestWindow(request, response);
                break;
            case "openCreate":
                request.getRequestDispatcher("/WEB-INF/view/createPerson.jsp").forward(request, response);
                break;
            case "openUpdate":
                request.setAttribute("id", request.getParameter("id"));
                request.setAttribute("name", request.getParameter("name"));
                request.getRequestDispatcher("/WEB-INF/view/updatePerson.jsp").forward(request, response);
                break;
            default:
                this.refrestWindow(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String action = request.getParameter("action");

        switch (action == null || "".equals(action) ? "default" : action) {

            case "insert":
                PersonDAO.insertPerson(new PersonDTO(request.getParameter("name")));
                this.refrestWindow(request, response);
                break;

            case "update":
                PersonDAO.updatePerson(new PersonDTO(Integer.parseInt(request.getParameter("id")), request.getParameter("name")));
                this.refrestWindow(request, response);
                break;

            default:
                this.refrestWindow(request, response);

        }

    }

    private void refrestWindow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<PersonDTO> people = PersonDAO.getPeople();
        request.getSession().setAttribute("people", people);

        //request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
        response.sendRedirect("index.jsp");

    }

}
