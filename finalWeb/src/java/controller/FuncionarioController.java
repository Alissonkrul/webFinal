/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.entities.Employee;

/**
 *
 * @author Alisson
 */
@WebServlet(name = "FuncionarioController", urlPatterns = {"/FuncionarioController"})
public class FuncionarioController extends HttpServlet {

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
        Client client = ClientBuilder.newClient();
        String uri = "http://172.20.171.200:8084/WSfuncionario/webresources/employees";
        Response res = null;
        //Get the request data
        String type = (String) request.getParameter("type");
        switch (type) {
            case "add":
                String cpf = (String) request.getParameter("cpf");
                String nome = (String) request.getParameter("nome");
                String endereco = (String) request.getParameter("endereco");
                String email = (String) request.getParameter("email");
                String celular = (String) request.getParameter("celular");
//                int companyId = Integer.parseInt(request.getParameter("companyId"));
                int companyId = 12;

                Employee e = new Employee();
                e.setCelular(celular);
                e.setCompanyId(companyId);
                e.setCpf(cpf);
                e.setNome(nome);
                e.setEndereco(endereco);
                e.setEmail(email);

                res = client
                        .target(uri)
                        .request(MediaType.APPLICATION_JSON)
                        .post(Entity.json(e));
                if (res.getStatus() == 204) {
                    response.sendRedirect("FuncionarioController?type=list");
                } else {
                    request.setAttribute("errorMessage", "Funcionario não pode ser adicionado");
                    response.sendRedirect("errorReport.jsp");
                }
//        Pessoa p = client.target(uri).request(MediaType.APPLICATION_JSON).

//        request.setAttribute("status", res.getStatus());
//        request.setAttribute("pessoa", res.readEntity(Pessoa.class));
//        request.getRequestDispatcher("mostrar.jsp").forward(request, response);
                break;
            case "delete":
                break;
            case "get":

                break;

            case "list":
                res = client
                        .target(uri)
                        .request(MediaType.APPLICATION_JSON)
                        .get();
                
                ArrayList<Employee> list = new ArrayList();
                for(Employee e1 : res.readEntity(new GenericType<List<Employee>>(){})){
                    list.add(e1);
                }
                
                request.setAttribute("listFuncionarios", list);
                
                //Return to List
                request.getRequestDispatcher("empresas.jsp").forward(request, response);

                break;
            case "update":

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
