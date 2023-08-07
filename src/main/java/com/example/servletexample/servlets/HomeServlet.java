package com.example.servletexample.servlets;

import com.example.servletexample.model.User;
import com.example.servletexample.runTimeRepository.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "HomeServlet", value = "/homeServlet")
public class HomeServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);

        session.getAttribute("userPoints");
        session.getAttribute("name");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        User currentUser = (User) session.getAttribute("currentUser");

        String priceInput = request.getParameter("priceInput");
        int price =  Integer.parseInt(priceInput);

        if (price >= 100) {
            currentUser.setPoints(currentUser.getPoints() +  10);
            session.setAttribute("userPoints", currentUser.getPoints());
        };

        //sa scoti if-ul asta
        //sa bagi if daca e client ii dai si cadouri (o data la 100 de p primeste cadou)
        if (currentUser.getPoints() >= 100 && currentUser.getPoints() < 200) {
                currentUser.setDiscount(5);
        }
        if (currentUser.getPoints() >= 200 && currentUser.getPoints() < 300) {
                currentUser.setDiscount(10);
        }
        if (currentUser.getPoints() >= 300 && currentUser.getPoints() < 400) {
                currentUser.setDiscount(15);
        }
        if (currentUser.getPoints() >= 400) {
                currentUser.setDiscount(20);
        }



        session.setAttribute("discount", currentUser.getDiscount());
        session.setAttribute("initialPrice", price);
        session.setAttribute("finalPrice", price - currentUser.getDiscount());

        getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);
    }
}
