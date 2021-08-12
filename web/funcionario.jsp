<%@page import="model.ServicoDAO"%>
<%@page import="model.Atendimento"%>
<%@page import="java.text.ParseException"%>
<%@page import="model.FuncionarioDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Funcionario"%>
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
        <header>
            <%@include file="head.jsp"%>
            <%@include file="validacao.jsp"%>
        </header>
        <h1>Funcionario!</h1>
        <a href="index.jsp">HOME</a><br/>
        <%
            ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
            try{
                FuncionarioDAO cDAO = new FuncionarioDAO();
                lista = cDAO.listaFuncionarios();
                Atendimento atendimento = new Atendimento();
                atendimento = (Atendimento) session.getAttribute("atendimento");
                ServicoDAO sDAO = new ServicoDAO();
                

                %>
                <form method="post" action="gerenciar_atendimento.do?op=2">
                    
                    <%
                        for (Funcionario f : lista) {
                    %>
                    <input type="radio" name="funcionario" required="" id="funcionario" value="<%=f.getId()%>" /><label for="funcionario"><%=f.getNome()%></label>
                    <%
                        }
                    %>
                    <input type="date" id="data" name="data" required="">
                    <input type="submit" value="Proximo">
                </form>
        <%
            }catch(Exception e){
                out.print("ERRO = "+ e);
            }
        %>
        <script>
            function excluir(id,nome){
                if(confirm("Tem certeza que quer excluir o Funcionario : "+ nome+"?\n\nIsso apagarar todos os registro relacionados a ele tambem!!")){
                    window.open("excluir_funcionario.do?id="+ id, "_self")
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
