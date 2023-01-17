package com.example.elibrary;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/recommend")
public class Recommend extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            List<Book> books = new ArrayList<>();

            request.setAttribute("books", books);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/userRecommendations.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response){
        doGet(request,response);
    }

    public void destroy() {
    }
}