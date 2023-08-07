package com.example.servletexample.servlets;

import com.example.servletexample.model.User;
import com.example.servletexample.runTimeRepository.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register/*")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String userType = request.getParameter("userType");
        User user = new User();
        user.setUsername(username);

        if (!userType.toLowerCase().equals("employee") && !userType.toLowerCase().equals("client"))
        {
            user.setUserType("client");
        }
        else
        {
            user.setUserType(userType);
        }

        user.setPoints(0);
        user.setDiscount(0);

        System.out.println("REGISTER " + username);

        HttpSession session = request.getSession();

        session.setAttribute("currentUser", user);
        session.setAttribute("userType", user.getUserType());

        Users.INSTANCE.addUser(user);

        getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
    }
}
