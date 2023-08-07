package com.example.servletexample.servlets;

import com.example.servletexample.model.User;
import com.example.servletexample.runTimeRepository.Users;
import org.thymeleaf.util.ObjectUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@WebServlet(name = "IndexServlet", urlPatterns = {"/","/login/*"})
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Check if user is already connected, if not show login page */

        HttpSession session = request.getSession();

        User currentUser = (User) session.getAttribute("currentUser");

        /* If not logged */
        if(Objects.isNull(currentUser)) {
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/homeServlet").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Check has the right credentials and use HomeServlet */

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");

        String username = request.getParameter("username");
        session.setAttribute("name", username);

        Optional<User> userByUsername = Users.INSTANCE.findUserByUsername(username);

        session.setAttribute("userPoints", currentUser.getPoints());

        if (userByUsername.isPresent())
            getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);
        else {
            /* Otherwise, reload the form  */
            getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        }
    }
}