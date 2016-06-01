/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.entities.Company;

/**
 *
 * @author Alisson
 */
@WebServlet(name = "EmpresaController", urlPatterns = {"/EmpresaController"})
public class EmpresaController extends HttpServlet {

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

        //Get the request data
        String type = (String) request.getParameter("type");
        switch (type) {
            case "add":
                String name = (String) request.getParameter("name");
                String cnpj = (String) request.getParameter("cnpj");
                String razaoSocial = (String) request.getParameter("razaoSocial");
                String endereco = (String) request.getParameter("endereco");
                String email = (String) request.getParameter("email");
                Company company = new Company();
                company.setName(name);
                company.setCnpj(cnpj);
                company.setEmail(email);
                company.setRazaoSocial(razaoSocial);
                company.setEndereco(endereco);
                company.add();
                //Return to List
                response.sendRedirect("EmpresaController?type=list");

                break;
            case "delete":
                break;
            case "get":

                Integer idCompany = Integer.parseInt(request.getParameter("empresaId"));

                Company company2 = new Company();
                company2.setId(idCompany);
                company2 = company2.getCompany();

                request.setAttribute("company", company2);
               
                request.getRequestDispatcher("editEmpresa.jsp").forward(request, response);

                break;

            case "list":
                List<Company> companies = Company.getAll();
                request.setAttribute("listEmpresas", companies);
                //Return to List
                request.getRequestDispatcher("empresas.jsp").forward(request, response);
                break;
            case "update":
                String id = (String) request.getParameter("id");
                String name1 = (String) request.getParameter("name");
                String cnpj1 = (String) request.getParameter("cnpj");
                String razaoSocial1 = (String) request.getParameter("razaoSocial");
                String endereco1 = (String) request.getParameter("endereco");
                String email1 = (String) request.getParameter("email");
                Company company1 = new Company();
                company1.setId(Integer.parseInt(id));
                company1.setName(name1);
                company1.setCnpj(cnpj1);
                company1.setEmail(email1);
                company1.setRazaoSocial(razaoSocial1);
                company1.setEndereco(endereco1);
                company1.update();
                //Return to List
                response.sendRedirect("EmpresaController?type=list");
                break;
            default:
                break;
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
