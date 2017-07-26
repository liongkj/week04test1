/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tp034196
 */
@WebServlet(name = "GreetingServlet", urlPatterns = {"/GreetingServlet"})
public class GreetingServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String title = "lala" ,grade = "";
        
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        double marks = Integer.parseInt(request.getParameter("marks"));
        
        if ("M".equals(gender) || "m".equals(gender) || "male".equals(gender) || "Male".equals(gender) ){
            title = "Mr. ";
        }
        else if ("f".equals(gender) || "F".equals(gender) || "Female".equals(gender) || "female".equals(gender)){
            title = "Ms. ";
        }
        
        if (marks < 0 || marks > 100){
            grade = "E";
        }
        else if (marks <=19) grade = "F-";
        else if (marks <=29) grade = "F";
        else if (marks <=39) grade = "F+";
        else if (marks <=49) grade = "D";
        else if (marks <=54) grade = "C-";
        else if (marks <=59) grade = "C";
        else if (marks <=64) grade = "C+";
        else if (marks <=69) grade = "B";
        else if (marks <=74) grade = "B+";
        else if (marks <=79) grade = "A";
        else if (marks <=100) grade = "A+";
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GreetingServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Good morning " + title + fName + " " + lName + "," + "</h1>");
            
            out.println("Your score grade for your EPDA is " + grade + "."); 
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
