<%@page import="model.ServicoDAO"%>
<%@page import="org.apache.catalina.ant.ServerinfoTask"%>
<%@page import="model.Servico"%>
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

        </header>
        <main>
            <h1>Hello World!</h1>
            <a href="listar_servico.jsp">Listar Servico</a><br/>
            <a href="index.jsp">HOME</a><br/><br/>
            <%
                try {
                    int id = Integer.parseInt(request.getParameter("id"));

                    Servico s = new Servico();
                    ServicoDAO sDAO = new ServicoDAO();

                    s = sDAO.carregarPorId(id);
            %>
            <form name="inserirCliente" method="post" action="alterar_servico.do">
                <input type="hidden" id="id" name="id" value="<%=s.getId()%>">
                <table>
                    <tr>
                        <td>Nome</td>
                        <td><input type="text" value="<%=s.getNome()%>" name="nome" required></td>
                    </tr>
                    <tr>
                        <td>Tipo</td>
                        <td>
                            <select id="id" name="tipo">
                                <option value="">Selecione...</option>
                               <%
                                String[] tipo = {"Barba","Cabelo","Outros","Promoções"};
                                for (int i = 0; i < tipo.length; i++) {
                                        String select = "";
                                        if(s.getTipo().equals(tipo[i])){
                                            select = "selected";
                                        }
                                        %>
                                        <option value="<%=tipo[i]%>" <%=select%>><%=tipo[i]%></option>
                                        <%
                                    }
                            %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Valor</td>
                        <td><input type="number" value="<%=s.getValor()%>" id="senha" name="valor" minlength="8" required></td>
                    </tr>
                    <tr>
                        <td colspan="2"> <input type="submit" value="Alterar"> </td>
                    </tr>
                </table>
            </form>
            <%
                } catch (Exception e) {
                    out.print("Erro ao carregar os dados do servico: " + e);

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
