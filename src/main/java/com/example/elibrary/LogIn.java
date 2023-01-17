package com.example.elibrary;

import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet("/login")
public class LogIn extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            ResultSet user = Database.instance.checkCredentials(request.getParameter("username"));
            if(user.next()){
                Cookie cookie = new Cookie("UserID", user.getString("id"));
                cookie.setMaxAge(60*60*24);
                response.addCookie(cookie);

                Cookie cookie1 = new Cookie("UserType", user.getString("type"));
                cookie1.setMaxAge(60*60*24);
                response.addCookie(cookie1);

                if (user.getString("password").equals(request.getParameter("password"))){
                    if(user.getString("type").equals("admin")){
                        response.sendRedirect(request.getContextPath() + "/adminMenu.jsp");
                    } else {
                        response.sendRedirect(request.getContextPath() + "/userMenu.jsp");
                    }
                } else {
                    response.setContentType("text/html;charset=UTF-8");
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Password is incorrect');");
                    out.println("history.back();");
                    out.println("</script>");
                }
            } else {
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Username is incorrect');");
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