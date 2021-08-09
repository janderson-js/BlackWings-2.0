<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
        <h1>Funcionario!</h1>
        <a href="index.jsp">HOME</a><br/>
        <%
            ArrayList<Atendimento> listaHorario = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String[] horarios = {"09:00:00", "09:30:00", "10:00:00", "10:30:00", "11:00:00", "11:30:00", "14:00:00", "14:30:00", "15:00:00", "15:30:00", "16:00:00", "16:30:00", "17:00:00", "17:30:00", "18:00:00", "18:30:00"};
            try {
                FuncionarioDAO fDAO = new FuncionarioDAO();
                Atendimento atendimento = new Atendimento();
                atendimento = (Atendimento) session.getAttribute("atendimento");

                listaHorario = fDAO.horariosFuncionario(atendimento.getFuncionario().getId(), atendimento.getData());
        %>
        <form method="post" action="gerenciar_atendimento.do?op=3">
            <%
                int size = horarios.length;
                Date horaAtual = new Date(System.currentTimeMillis());
                String[] horas = new String[size];
                String[] disponivel = new String[size];
                String data = sdf2.format(horaAtual);
                Date[] horariosFormatado = new Date[size];

                for (int i = 0; i < horarios.length; i++) {
                    horariosFormatado[i] = df.parse(data + "  " + horarios[i]);
                    disponivel[i] = "";
                    if (horariosFormatado[i].getTime() < horaAtual.getTime()) {
                        disponivel[i] = "disabled";
                    }
                }
                for (int i = 0; i < horarios.length; i++) {
                    horas[i] = " ";
                    for (Atendimento a : listaHorario) {

                        if (sdf.format(a.getHora()).equals(sdf.format(sdf.parse(horarios[i])))) {
                            horas[i] = "1";
                        }
                    }
                    if (!horas[i].equals("1") && !disponivel[i].equals("disabled")) {
            %>
            <input type="radio" <%=disponivel[i]%> name="hora" id="hora" value="<%=horarios[i]%>" /><label for="funcionario"><%=sdf.format(sdf.parse(horarios[i]))%></label></br>
            <%
                    }
                }
            %>
            <select id="pagamento" name="pagamento" required="">
                <option value="">Selecione...</option>
                <option value="Cartão">Cartão</option>
                <option value="Dinheiro">Dinheiro</option>
                <option value="PIX">PIX</option>
            </select>
            <input type="submit" value="Proximo">
        </form>
        <%
            } catch (Exception e) {
                out.print("ERRO = " + e);
            }
        %>
        <script>
            function excluir(id, nome) {
                if (confirm("Tem certeza que quer excluir o Funcionario : " + nome + "?\n\nIsso apagarar todos os registro relacionados a ele tambem!!")) {
                    window.open("excluir_funcionario.do?id=" + id, "_self")
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
