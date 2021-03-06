<%-- 
    Document   : index
    Created on : 27 de jul. de 2021, 17:05:37
    Author     : Jandy
--%>

<%@page import="model.PerfilDAO"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.ArrayList"%>
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
        <h1>Inserir Funcionario!</h1>
        <a href="index.jsp">HOME</a><br/>
        <a href="listar_funcionario.jsp">Funcionario</a><br/><br/>

        <form name="inserirFuncionario" method="post" action="inserir_funcionario.do">
            <table>
                <tr>
                    <td>Nome</td>
                    <td><input type="text" name="nome" required></td>
                </tr>
                <tr>
                    <td>Data de Nascimento</td>
                    <td><input type="date" name="dataN" required></td>
                </tr>
                <tr>
                    <td>Perfil</td>
                    <%
                        ArrayList<Perfil> lista = new ArrayList<>();
                        try {
                            PerfilDAO pDAO = new PerfilDAO();
                            lista = pDAO.listaPerfils();
                    %>
                    <td>
                        <select id="perfil" name="idPerfil" required="">
                            <option value="">Selecione...</option>
                            <%
                                for (Perfil p : lista) {%>
                            <option value="<%=p.getId()%>"><%=p.getTitulo()%></option>   
                            <%}%>
                        </select>
                    </td>
                    <%
                        } catch (Exception e) {
                            out.print("erro ao carregar perfis" + e);
                        }
                    %>

                </tr>
                <tr>
                    <td>matricula</td>
                    <td><input type="text" name="matricula" required></td>
                </tr>
                <tr>
                    <td>Senha</td>
                    <td><input type="password" id="senha" name="senha" minlength="8" required></td>
                </tr>
                <tr>
                    <td>telefone de Contato</td>
                    <td><input type="tel" id="telefoneContato" name="telefoneContato" required></td>
                </tr>
                <tr>
                    <td>telefone</td>
                    <td><input type="tel" id="telefone" name="telefone" ></td>
                </tr>
                <tr>
                    <td>CEP</td>
                    <td><input type="text" name="cep" required></td>
                </tr>
                <tr>
                    <td>Cidade</td>
                    <td><input type="text" name="cidade" required></td>
                </tr>
                <tr>
                    <td>Bairro</td>
                    <td><input type="text" name="bairro" required></td>
                </tr>
                <tr>
                    <td>Endereco</td>
                    <td><input type="text" name="endereco" required></td>
                </tr>
                <tr>
                    <td>casa</td>
                    <td><input type="text" name="casa" required></td>
                </tr>
                <tr>
                    <td>complemento</td>
                    <td><input type="text" name="complemento"></td>
                </tr>
                <tr>
                    <td>Data de contrato</td>
                    <td><input type="date" name="dataCon" required></td>
                </tr>
                <tr>
                    <td>Validade de Contrato</td>
                    <td><input type="date" name="dataVali" required></td>
                </tr>
                <tr>
                    <td colspan="2"> <input type="submit" value="Cadastrar"> </td>
                </tr>
            </table>
        </form>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
