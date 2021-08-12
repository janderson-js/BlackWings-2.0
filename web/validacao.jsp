<%@page import="model.MenuDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Menu"%>
<%@page import="model.Funcionario"%>

<%
    String url = request.getRequestURL().substring(37);
    String[] user = session.getValueNames();
    String redirect = "";
    boolean acesso = false;
    if (!url.equals("index.jsp")) {
        if (session.getAttribute("cliente") != null || session.getAttribute("funcionario") != null) {
            if (user[0].equals("funcionario")) {

                Funcionario f = new Funcionario();
                f = (Funcionario) session.getAttribute("funcionario");

                if (f.getPerifl().getTitulo().equals("Atendente")) {
                    if (url.equals("listar_atendimento.jsp") || url.equals("listar_cliente.jsp")) {
                        acesso = true;
                    }
                } else if (f.getPerifl().getTitulo().equals("Barbeiro")) {
                    if (url.equals("barbeiro.jsp")) {
                        acesso = true;
                    }
                } else if (f.getPerifl().getTitulo().equals("Gerente")) {
                    if (url.equals("listar_menu.jsp") || url.equals("listar_perfil.jsp") || url.equals("inserir_menu.jsp") || url.equals("inserir_perfil.jsp")) {
                        acesso = false;
                    } else {
                        acesso = true;
                    }
                } else if (f.getPerifl().getTitulo().equals("Admin")) {
                    acesso = true;
                    out.print(url + " / " + acesso + " / " + f.getNome());
                }
                redirect = "login_funcionario.jsp";
                
            } else if (user[0].equals("cliente")) {
                if(url.equals("alterar_cliente.jsp") || url.equals("dados_cliente.jsp") || url.equals("agendamento_cliente.jsp") || url.equals("meus_agendamentos.jsp")){
                    acesso = true;
                }
                redirect = "login_cliente.jsp";
            }

            if (!acesso) {
               response.sendRedirect(redirect);
            }
            
        } else {
            response.sendRedirect("login_cliente.jsp");
        }
    }

%> 