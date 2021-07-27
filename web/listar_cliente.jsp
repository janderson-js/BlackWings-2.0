<%-- 
    Document   : listar_cliente
    Created on : 27 de jul. de 2021, 17:07:55
    Author     : Jandy
--%>

<%@page import="java.text.ParseException"%>
<%@page import="model.ClienteDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            try{
                ClienteDAO cDAO = new ClienteDAO();
                lista = cDAO.listaClientes();
                
                for(Cliente c : lista){
                %>
                <p>Nome<%= c.getNome() %></p>
                <%}
            }catch(Exception e){
                out.print("ERRO = "+ e);
            }
        %>
    </body>
</html>
