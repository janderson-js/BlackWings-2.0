/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;
import model.FuncionarioDAO;
import model.Perfil;

/**
 *
 * @author Jandy
 */
public class InserirFuncionario extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InserirFuncionario</title>");            
            out.println("</head>");
            out.println("<body>");
            try {
                Funcionario f = new Funcionario();
                FuncionarioDAO fDAO = new FuncionarioDAO();
                Perfil p = new Perfil();
                
                String nome = request.getParameter("nome");
                String dataN = request.getParameter("dataN");
                String telefoneContato = request.getParameter("telefoneContato");
                String telefone = request.getParameter("telefone");
                String matricula = request.getParameter("matricula");
                String senha  = request.getParameter("senha");
                String cep = request.getParameter("cep");
                String cidade = request.getParameter("cidade");
                String bairro = request.getParameter("bairro");
                String endereco = request.getParameter("endereco");
                String casa = request.getParameter("casa");
                String complemento = request.getParameter("complemento");
                String dataCon =request.getParameter("dataCon");
                String dataVali = request.getParameter("dataVali");
                int idPerfil = Integer.parseInt(request.getParameter("idPerfil"));
                
                
                Timestamp dataNascimento = Timestamp.valueOf(dataN+" 00:00:00");
                Timestamp dataContrato = Timestamp.valueOf(dataCon+" 00:00:00");
                Timestamp validade = Timestamp.valueOf(dataVali+" 00:00:00");
                      
                p.setId(idPerfil);
                
                f.setNome(nome);
                f.setDataNascimento(dataNascimento);
                f.setTelefoneContato(telefoneContato);
                f.setTelefone(telefone);
                f.setMatricula(matricula);
                f.setSenha(senha);
                f.setCep(cep);
                f.setCidade(cidade);
                f.setBairro(bairro);
                f.setEndereco(endereco);
                f.setCasa(casa);
                f.setComplemento(complemento);
                f.setDataContrato(dataContrato);
                f.setValidadeContrato(validade);
                f.setPerifl(p);
                
                fDAO.inserirFuncionario(f);
                
                response.sendRedirect("listar_funcionario.jsp");
                
            } catch (Exception e) {
                out.print("Erro ao  inserir o funcionario"+ e);          
            }
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
