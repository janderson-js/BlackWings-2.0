<%@page import="java.text.ParseException"%>
<%@page import="model.ClienteDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilo.css">
        <title>Black Wings</title>
    </head>
    <body>
        <h1>Lista Cliente!</h1>
        <a href="index.jsp">HOME</a><br/>
        <a href="inserir_cliente.jsp">Inserir Cliente</a><br/><br/>
        <%
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            try{
                ClienteDAO cDAO = new ClienteDAO();
                lista = cDAO.listaClientes();
                %>
                <table class="table  table   table-hover" style="background-color: white; text-align: center; ">
                    <thead class="table-dark">
                        <tr>
                            <th><strong>ID<strong></th>
                            <th><strong>NOME<strong></th>
                            <th><strong>CPF<strong></th>
                            <th><strong>OPÇÕES</strong></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                          for(Cliente c : lista){%>
                            <tr>
                                <td> <%=c.getId()%> </td>
                                <td><%=c.getNome()%></td>
                                <td><%=c.getCpf()%></td>
                                <td> 
                                    <input type="button" value="dados" name="dados " />
                                    <input type="button" value="agendar" name="agendar" />
                                    <input type="button" value="excluir" name="excluir" />
                                </td>
                            </tr>
                        <% }%>
                    </tbody>
                </table>
        <%
            }catch(Exception e){
                out.print("ERRO = "+ e);
            }
        %>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
