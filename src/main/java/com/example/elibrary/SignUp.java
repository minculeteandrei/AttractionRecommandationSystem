package com.example.elibrary;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet("/signup")
public class SignUp extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            ResultSet user = Database.instance.checkCredentials(request.getParameter("username"));
            if(!user.next()){
                Database.instance.addUser(request.getParameter("username"),request.getParameter("password"),request.getParameter("type"));
                ResultSet newUser = Database.instance.checkCredentials(request.getParameter("username"));
                newUser.next();

                Cookie cookie = new Cookie("UserID", newUser.getString("id"));
                cookie.setMaxAge(60*60*24);
                response.addCookie(cookie);

                Cookie cookie1 = new Cookie("UserType", newUser.getString("type"));
                cookie1.setMaxAge(60*60*24);
                response.addCookie(cookie1);

                if(request.getParameter("type").equals("admin"))
                    response.sendRedirect(request.getContextPath() + "/adminMenu.jsp");
                else
                    response.sendRedirect(request.getContextPath() + "/userMenu.jsp");
            } else {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User already exists');");
                out.println("history.back();");
                out.println("</script>");
            }
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