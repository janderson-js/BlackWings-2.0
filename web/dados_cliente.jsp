<%-- 
    Document   : index
    Created on : 27 de jul. de 2021, 17:05:37
    Author     : Jandy
--%>

<%@page import="model.ClienteDAO"%>
<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
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
        <h1>Dados do cliente!</h1>
        <a href="listar_cliente.jsp">Listar Cliente</a><br/><br/>
        <%
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                
                Cliente c = new Cliente();
                ClienteDAO cDAO = new ClienteDAO();

                c = cDAO.carregarPorId(id);
        %>
            <table cellspacing="4" cellpadding="5" >
                <tr>
                    <td>Nome</td>
                    <td><input type="text" name="nome" value="<%=c.getNome()%>" disabled=""></td>
                </tr>
                <tr>
                    <td>CPF</td>
                    <td><input type="text" name="cpf" value="<%=c.getCpf()%>" disabled=""></td>
                </tr>
                <tr>
                    <td>Senha</td>
                    <td><input type="password" name="senha" value="<%=c.getSenha()%>" disabled=""></td>
                </tr>
                <tr>
                    <td>Telefone de contato</td>
                    <td><input type="tel" name="telefoneContato" value="<%=c.getTelefoneContato()%>" disabled=""></td>
                </tr>
                <tr>
                    <td>Telefone</td>
                    <td><input type="tel" name="telefone" value="<%=c.getTelefone()%>" disabled=""></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;"><a href="alterar_cliente.jsp?id=<%=c.getId()%>"><button>Alterar</button></a></td>
                </tr>
            </table>      
        <%        
                   
            } catch (Exception e) {
                out.print("Erro ao carregar dados do cliente: " + e);
            }
        %>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
