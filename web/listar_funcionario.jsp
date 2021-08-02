<%@page import="java.text.ParseException"%>
<%@page import="model.PerfilDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Perfil"%>
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
        <h1>Lista Perfil!</h1>
        <a href="index.jsp">HOME</a><br/>
        <a href="inserir_perfil.jsp">Inserir Perfil</a><br/><br/>
        <%
            ArrayList<Perfil> lista = new ArrayList<Perfil>();
            try{
                PerfilDAO cDAO = new PerfilDAO();
                lista = cDAO.listaPerfils();
                %>
                <table class="table  table   table-hover" style="background-color: white; text-align: center; ">
                    <thead class="table-dark">
                        <tr>
                            <th><strong>ID<strong></th>
                            <th><strong>TITULO<strong></th>
                            <th><strong>DESCRIÇÃO<strong></th>
                            <th><strong>OPÇÕES</strong></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                          for(Perfil p : lista){%>
                            <tr>
                                <td> <%=p.getId()%> </td>
                                <td><%=p.getTitulo()%></td>
                                <td><%=p.getDescricao()%></td>
                                <td> 
                                    <a href="alterar_perfil.jsp?id=<%=p.getId()%>"><input type="button" value="alterar" name="alterar" /></a>
                                    <a href="#"><input type="button" value="excluir" onclick="excluir(<%=p.getId()%>,'<%=p.getTitulo()%>')" name="excluir" /></a>
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
        <script>
            function excluir(id,nome){
                if(confirm("Tem certeza que quer excluir o Perfil : "+ nome+"?\n\nIsso apagarar todos os registro relacionados a ele tambem!!")){
                    window.open("excluir_perfil.do?id="+ id, "_self")
                }
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
