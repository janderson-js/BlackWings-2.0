<%@page import="model.AtendimentoDAO"%>
<%@page import="model.Atendimento"%>
<%@page import="model.Servico"%>
<%@page import="model.FuncionarioDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        <main>
            <h2>Servi?os para hoje</h2>
        <%
            ArrayList<Atendimento> listaHoje = new ArrayList<>();
            ArrayList<Atendimento> listaAgendado = new ArrayList<>();
            ArrayList<Servico> listaServicos = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
            try{
                FuncionarioDAO fDAO = new FuncionarioDAO();
                Funcionario f = new Funcionario();
                f = (Funcionario) session.getAttribute("funcionario");
                listaHoje = fDAO.funcionarioServicoDoDia(f.getId());
                listaAgendado = fDAO.funcionarioServicoAgendado(f.getId());
                AtendimentoDAO aDAO = new AtendimentoDAO();
                %>
                <table class="table  table   table-hover" style="background-color: white; text-align: center;vertical-align: middle; ">
                    <thead class="table-dark">
                        <tr>
                            <th><strong>ID<strong></th>
                            <th><strong>NOME<strong></th>
                            <th><strong>DATA<strong></th>
                            <th><strong>SERVI?O(S)<strong></th>
                            <th><strong>VALOR<strong></th>            
                            <th><strong>OP??ES(<%if(listaHoje.isEmpty()){out.print("vazia"+"  "+ f.getId());}%>)</strong></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                           
                          for(Atendimento a : listaHoje){
                          listaServicos = aDAO.carregaServicos(a.getId());
                        %>
                            <tr>
                                <td> <%=a.getId()%> </td>
                                <td><%=a.getCliente().getNome()%></td>
                                <td><%=sdf.format(a.getData()) +" ?s "+sdf2.format(a.getHora())%></td>
                                <td>
                                    <%
                                        for (Servico s : listaServicos) {
                                    %>
                                    <label><%=s.getNome()%></label></br>
                                    <%
                                    }
                                    %>
                                </td>
                                <td><%=a.getPreco()%></td>
                                <td> 
                                    <a href="dados_atendimento.jsp?id=<%=a.getId()%>"><input type="button" value="dados" name="dados" /></a>
                                    <a href="#"><input type="button" value="excluir" onclick="excluir(<%=a.getId()%>,'<%=a.getCliente().getNome()%>')" name="excluir" /></a>
                                </td>
                            </tr>
                        <% }%>
                    </tbody>
                </table>
                    </br>
                    <h2>Servi?os Agendados</h2>
                <table class="table  table   table-hover" style="background-color: white; text-align: center;vertical-align: middle; ">
                    <thead class="table-dark">
                        <tr>
                            <th><strong>ID<strong></th>
                            <th><strong>NOME<strong></th>
                            <th><strong>DATA<strong></th>
                            <th><strong>SERVI?O(S)<strong></th>
                            <th><strong>VALOR<strong></th>            
                            <th><strong>OP??ES(<%if(listaHoje.isEmpty()){out.print("vazia"+"  "+ f.getId());}%>)</strong></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                           
                          for(Atendimento a : listaAgendado){
                              listaServicos = aDAO.carregaServicos(a.getId());
                        %>
                            <tr>
                                <td> <%=a.getId()%> </td>
                                <td><%=a.getCliente().getNome()%></td>
                                <td><%=sdf.format(a.getData()) +" ?s "+sdf2.format(a.getHora())%></td>
                                <td>
                                    <%
                                        for (Servico s : listaServicos) {
                                    %>
                                    <label><%=s.getNome()%></label></br>
                                    <%
                                    }
                                    %>
                                </td>
                                <td><%=a.getPreco()%></td>
                                <td> 
                                    <a href="dados_atendimento.jsp?id=<%=a.getId()%>"><input type="button" value="dados" name="dados" /></a>
                                    <a href="#"><input type="button" value="excluir" onclick="excluir(<%=a.getId()%>,'<%=a.getCliente().getNome()%>')" name="excluir" /></a>
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
        </main>
        <footer>

        </footer>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
