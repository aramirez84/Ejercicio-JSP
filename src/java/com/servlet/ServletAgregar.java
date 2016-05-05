/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.db.Operaciones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.db.Usuario;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author alejandro.ramirez
 */
@WebServlet(name = "ServletAgregar", urlPatterns = {"/ServletAgregar"})
public class ServletAgregar extends HttpServlet {

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
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
         /*   out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
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
        String nombre=request.getParameter("nombre");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        int id=Operaciones.getUltimoID();
        id++;
        
        if(!nombre.equalsIgnoreCase(""))
        {
            PrintWriter out = response.getWriter();
            Usuario newUser= new Usuario(id,nombre, password, username);
            boolean respuesta=Operaciones.insertUsuario(newUser);
            if(respuesta)
            {
                //RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                //dispatcher.forward(request, response);
                //response.sendRedirect("index.jsp");
                out.println("Usuario agregado correctamente");
            }
            else
            {
                out.println("Error al ingresar usuario intentelo de nuevo");
            }
        }
        
        
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
