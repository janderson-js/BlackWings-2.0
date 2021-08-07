/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;
import model.Atendimento;
import model.AtendimentoDAO;
import model.Funcionario;
import model.FuncionarioDAO;
import model.Servico;
import model.ServicoDAO;

/**
 *
 * @author Jandy
 */
public class GerenciarAtendimento extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GerenciarAtendimento</title>");
            out.println("</head>");
            out.println("<body>");
            try {
                String op = request.getParameter("op");
                Atendimento atendimento = new Atendimento();
                ArrayList<Servico> servico = new ArrayList<>();

                String idServico[] = request.getParameterValues("servico");

                if (op.equals("1")) {
                    atendimento = (Atendimento) session.getAttribute("atendimento");

                    for (int i = 0; i < idServico.length; i++) {
                        ServicoDAO sDAO = new ServicoDAO();
                        Servico s = sDAO.carregarPorId(Integer.parseInt(idServico[i]));
                        servico.add(s);
                        atendimento.setServico(servico);
                    }

                    session.setAttribute("atendimento", atendimento);

                    response.sendRedirect("funcionario.jsp");
                } else if (op.equals("2")) {

                    atendimento = (Atendimento) session.getAttribute("atendimento");
                    FuncionarioDAO fDAO = new FuncionarioDAO();
                    Funcionario f = new Funcionario();

                    int idFun = Integer.parseInt(request.getParameter("funcionario"));
                    Timestamp data = Timestamp.valueOf(request.getParameter("data") + " 00:00:00");
                    f = fDAO.carregarPorId(idFun);

                    atendimento.setFuncionario(f);
                    atendimento.setData(data);

                    response.sendRedirect("horario.jsp");
                } else if (op.equals("3")) {
                    atendimento = (Atendimento) session.getAttribute("atendimento");
                    
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                    
                    String h = df.format(atendimento.getData());
                    String pagamento = request.getParameter("pagamento");
                    Date hora1 = sdf.parse(h+" "+request.getParameter("hora"));
                    
                    String hora = sdf.format(hora1.getTime());
                    Timestamp horaFormatada = Timestamp.valueOf(hora);
                    
                    atendimento.setHora(horaFormatada);
                    atendimento.setFormaPagamento(pagamento);
                    response.sendRedirect("resumo_atendimento.jsp");
                } else if (op.equals("4")) {
                    atendimento = (Atendimento) session.getAttribute("atendimento");
                    AtendimentoDAO aDAO = new AtendimentoDAO();
                    
                    aDAO.inserirAtendimento(atendimento);
                    
                    response.sendRedirect("listar_atendimento.jsp");
                            
                }
            } catch (Exception e) {
                out.print("Erro GerenciarAtendimento: " + e);
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
