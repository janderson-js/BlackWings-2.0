<%-- 
    Document   : sair
    Created on : 5 de ago. de 2021, 13:41:58
    Author     : Jandy
--%>

<%
    try {
        String[] user = session.getValueNames();
        if (session.getAttribute("cliente") != null || session.getAttribute("funcionario") != null) {

            if (user[0].equals("funcionario")) {
                session.removeAttribute("funcionario");
                response.sendRedirect("login_funcionario.jsp");
            } else if (user[0].equals("cliente")) {
                session.removeAttribute("cliente");
                response.sendRedirect("login_cliente.jsp");
            }
        }else{
            response.sendRedirect("index.jsp");
        }
    } catch (Exception e) {
        response.sendRedirect("index.jsp");
    }
%>