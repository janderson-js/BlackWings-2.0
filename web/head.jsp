<%@page import="model.Funcionario"%>
<%@page import="model.MenuDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Menu"%>
<%

    
    try {
        String[] user = session.getValueNames();
        ArrayList<Menu> lista = new ArrayList<>();
        MenuDAO mDAO = new MenuDAO();
        if (session.getAttribute("cliente") != null || session.getAttribute("funcionario") != null) {
            if (user[0].equals("funcionario")) {
                Funcionario f = new Funcionario();
                f = (Funcionario) session.getAttribute("funcionario");
                lista = mDAO.listarMenusPerfil(f.getPerifl().getId());

                for (Menu m : lista) {
%>        
                    <a href="<%=m.getLink()%>" ><%=m.getTitulo()%> / </a>
<%
                }
            } else if (user[0].equals("cliente")) {
%>        
                <a href="index.jsp">Home / </a>
                <a href="agendamentos.jsp">Agendar / </a>
                <a href="sair.jsp">Sair</a>
<%
            }
        } else {
%>
        <a href="index.jsp">Home / </a>
        <a href="agendamentos.jsp">Agendar / </a>
        <a href="login_cliente.jsp">Login / </a>
        <a href="inserir_cliente.jsp">Cadastre-se</a>             
<%
        }

    } catch (Exception e) {
%>
        <a href="index.jsp">Home / </a>
        <a href="agendamentos.jsp">Agendar</a>
        <a href="login_cliente.jsp">Login / </a>
        <a href="inserir_cliente.jsp">Cadastre-se</a>
<%
    } 
%>