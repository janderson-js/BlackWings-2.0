<%-- 
    Document   : index
    Created on : 27 de jul. de 2021, 17:05:37
    Author     : Jandy
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.PerfilDAO"%>
<%@page import="model.Perfil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.FuncionarioDAO"%>
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
        <h1>Dados do funcionario!</h1>
        <a href="listar_funcionario.jsp">Listar Funcionario</a><br/><br/>
        <%
            ArrayList<Perfil> lista = new ArrayList<>();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                int id = Integer.parseInt(request.getParameter("id"));

                Funcionario f = new Funcionario();
                FuncionarioDAO fDAO = new FuncionarioDAO();
                PerfilDAO pDAO = new PerfilDAO();
                f = fDAO.carregarPorId(id);
                lista = pDAO.listaPerfils();

        %>
        <form name="inserirFuncionario" method="post" action="alterar_funcionario.do">
            <table>
                <input type="hidden" id="id" name="id" value="<%=f.getId()%>">
                <tr>
                    <td>Nome</td>
                    <td><input type="text" name="nome" value="<%=f.getNome()%>"></td>
                </tr>
                <tr>
                    <td>Data de Nascimento</td>
                    <td><input type="date" name="dataN" value="<%=df.format(f.getDataNascimento())%>"></td>
                </tr>
                <tr>
                    <td>Perfil</td>
                    <td>
                        <select id="perfil" name="idPerfil" required="">
                            <option value="">Selecione...</option>
                            <%
                                String select;
                                for (Perfil p : lista) {
                                    select = "";
                                    if (p.getTitulo().equals(f.getPerifl().getTitulo())) {
                                        select = "selected";
                                    }
                            %>
                            <option value="<%=p.getId()%>" <%=select%>><%=p.getTitulo()%></option>   
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>matricula</td>
                    <td><input type="text" name="matricula" value="<%=f.getMatricula()%>"></td>
                </tr>
                <tr>
                    <td>Senha</td>
                    <td><input type="password" id="senha" name="senha" minlength="8" value="<%=f.getSenha()%>"></td>
                </tr>
                <tr>
                    <td>telefone de Contato</td>
                    <td><input type="tel" id="telefoneContato" name="telefoneContato" value="<%=f.getTelefoneContato()%>"></td>
                </tr>
                <tr>
                    <td>telefone</td>
                    <td><input type="tel" id="telefone" name="telefone" value="<%=f.getTelefone()%>"></td>
                </tr>
                <tr>
                    <td>CEP</td>
                    <td><input type="text" name="cep" value="<%=f.getCep()%>"></td>
                </tr>
                <tr>
                    <td>Cidade</td>
                    <td><input type="text" name="cidade" value="<%=f.getCidade()%>"></td>
                </tr>
                <tr>
                    <td>Bairro</td>
                    <td><input type="text" name="bairro" value="<%=f.getBairro()%>"></td>
                </tr>
                <tr>
                    <td>Endereco</td>
                    <td><input type="text" name="endereco" value="<%=f.getEndereco()%>"></td>
                </tr>
                <tr>
                    <td>casa</td>
                    <td><input type="text" name="casa" value="<%=f.getCasa()%>"></td>
                </tr>
                <tr>
                    <td>complemento</td>
                    <td><input type="text" name="complemento" value="<%=f.getComplemento()%>"></td>
                </tr>
                <tr>
                    <td>Data de contrato</td>
                    <td><input type="date" name="dataCon" value="<%=df.format(f.getDataContrato())%>"></td>
                </tr>
                <tr>
                    <td>Validade de Contrato</td>
                    <td><input type="date" name="dataVali" value="<%=df.format(f.getValidadeContrato())%>"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Alterar"></td>
                </tr>
            </table>
        </form>
        <%
            } catch (Exception e) {
                out.print("Erro ao carregar dados do funcionario: " + e);
            }
        %>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
