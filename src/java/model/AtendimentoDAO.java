package model;

import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AtendimentoDAO extends DataBase {

    public ArrayList<Atendimento> listaAtendimentos() throws Exception {
        String sql = "SELECT * FROM Atendimento";
        FuncionarioDAO fDAO = new FuncionarioDAO();
        ClienteDAO cDAO = new ClienteDAO();
        ArrayList<Atendimento> lista = new ArrayList<Atendimento>();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Atendimento a = new Atendimento();
            a.setId(rs.getInt("id"));
            a.setPreco(rs.getDouble("preco"));
            a.setFormaPagamento(rs.getString("forma_pagamento"));
            a.setStatus(rs.getString("status"));
            a.setFuncionario(fDAO.carregarPorId(rs.getInt("id_funcionario")));
            a.setCliente(cDAO.carregarPorId(rs.getInt("id_cliente")));
            a.setData(rs.getTimestamp("data"));
            a.setHora(rs.getTimestamp("hora"));
            a.setDataPagamento(rs.getTimestamp("data_pagamento"));
            a.setRegistroAtendimento(rs.getTimestamp("registro_atendimento"));
            a.setCancelamento(rs.getTimestamp("cancelamento"));
            a.setServico(this.carregaServicos(rs.getInt("id")));
            lista.add(a);
        }
        this.desconectar();
        return lista;
    }
    public ArrayList<Servico> carregaServicos(int id_atendimento) throws Exception {
        ArrayList<Servico> lista = new ArrayList<Servico>();
        String sql = "SELECT s.id, s.nome, sa.valor_unitario "
                   + "FROM servico as s, servico_atendimento as sa "
                   + "WHERE s.id=sa.id_servico AND sa.id_atendimento=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_atendimento);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Servico s = new Servico();
            s.setId(rs.getInt("id"));
            s.setNome(rs.getString("nome"));
            s.setValor(rs.getDouble("valor_unitario")); 
            lista.add(s);
        }
        this.desconectar();
        return lista;
    }
    public Atendimento carregarPorId(int id) throws Exception {
        Atendimento a = new Atendimento();
        String sql = "SELECT * FROM Atendimento WHERE id=?";
        FuncionarioDAO fDAO = new FuncionarioDAO();
        ClienteDAO cDAO = new ClienteDAO();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            a.setId(rs.getInt("id"));
            a.setPreco(rs.getDouble("preco"));
            a.setFormaPagamento(rs.getString("forma_pagamento"));
            a.setStatus(rs.getString("status"));
            a.setFuncionario(fDAO.carregarPorId(rs.getInt("id_funcionario")));
            a.setCliente(cDAO.carregarPorId(rs.getInt("id_cliente")));
            a.setData(rs.getTimestamp("data"));
            a.setHora(rs.getTimestamp("hora"));
            a.setDataPagamento(rs.getTimestamp("data_pagamento"));
            a.setRegistroAtendimento(rs.getTimestamp("registro_atendimento"));
            a.setCancelamento(rs.getTimestamp("cancelamento"));
        }
        this.desconectar();
        return a;
    }

    public void inserirAtendimento(Atendimento a) throws Exception {
        String sql = "INSERT INTO Atendimento (data, hora, preco, forma_pagamento, data_pagamento, data_atendimento, registro_atendimento, cancelamento, id_funcionario, id_cliente) VALUES (?,?,?,?,?,?,?,?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        pstm.setTimestamp(1, a.getData());
        pstm.setTimestamp(2, a.getHora());
        pstm.setDouble(3, a.getPreco());
        pstm.setString(4, a.getFormaPagamento());
        pstm.setTimestamp(5, a.getDataPagamento());
        pstm.setTimestamp(6, a.getDataAtendimento());
        pstm.setTimestamp(7, a.getRegistroAtendimento());
        pstm.setTimestamp(8, a.getCancelamento());
        pstm.setInt(9, a.getFuncionario().getId());
        pstm.setInt(10, a.getCliente().getId());
        pstm.execute();
        
        int id = 0;
        ResultSet rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        for(Servico s : a.getServico()){
            String sql_servico = "INSERT INTO Servico_atendimento (id_servico, id_atendimento,data,valor_unitario) VALUES (?,?,NOW(),?)";
            PreparedStatement pstm_servico = conn.prepareStatement(sql_servico);
            pstm_servico.setInt(1, s.getId());
            pstm_servico.setInt(2, id);
            pstm_servico.setDouble(3, s.getValor());
            pstm_servico.execute();
        }
        this.desconectar();
    }

    public void deletarAtendimento(int id) throws Exception {
        String sql = "DELETE FROM Atendimento WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    
}
