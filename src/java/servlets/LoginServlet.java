package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 579957
 */
public class LoginServlet extends HttpServlet {



    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            
            
            if(username == null || password == null){
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
            
            if(username.trim().isEmpty() || password.trim().isEmpty()){
                request.setAttribute("errorMessage", "Both values are required!");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
            }
            
            UserService user = new UserService();
            if(user.login(username, password) == true){
                getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(request, response);
            }   
            
            if(user.login(username, password) == false){
                request.setAttribute("errorMessage", "Invalid username or password!");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }       
    }
}
