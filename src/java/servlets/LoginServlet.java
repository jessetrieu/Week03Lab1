package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import beans.User;
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
            
            String userName = request.getParameter("user");
            String password = request.getParameter("pass");
            
            User u = new User(userName, password);
            
            request.setAttribute("username", u.getUserName());
            request.setAttribute("password", u.getPassword());
            
            
            if(u.getUserName() == null || u.getPassword() == null){
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
            
            if(u.getUserName().trim().isEmpty() || u.getPassword().trim().isEmpty()){
                request.setAttribute("errorMessage", "Both values are required!");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
            }
            
            UserService user = new UserService();
            if(user.login(u.getUserName(), u.getPassword()) == true){
                getServletContext().getRequestDispatcher("/WEB-INF/mainPage.jsp").forward(request, response);
            }   
            
            if(user.login(u.getUserName(), u.getPassword()) == false){
                request.setAttribute("errorMessage", "Invalid username or password!");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }       
    }
}
