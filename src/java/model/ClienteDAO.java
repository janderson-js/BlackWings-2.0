package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO extends DataBase {

    public ArrayList<Cliente> listaClientes() throws Exception {
        String sql = "SELECT * FROM Cliente";
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Cliente c = new Cliente();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setCpf(rs.getString("cpf"));
            c.setSenha(rs.getString("senha"));
            c.setTelefone(rs.getString("telefone"));
            c.setTelefoneContato(rs.getString("telefone_contato"));
            c.setTermos(rs.getString("termos"));
            c.setStatus(rs.getString("status"));
            c.setDataCadastro(rs.getTimestamp("data_cadastro"));
            lista.add(c);
        }
        this.desconectar();
        return lista;
    }

    public Cliente carregarPorId(int id) throws Exception {
        Cliente c = new Cliente();
        String sql = "SELECT * FROM Cliente WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setCpf(rs.getString("cpf"));
            c.setSenha(rs.getString("senha"));
            c.setTelefone(rs.getString("telefone"));
            c.setTelefoneContato(rs.getString("telefone_conatato"));
            c.setTermos(rs.getString("termos"));
            c.setStatus(rs.getString("status"));
            c.setDataCadastro(rs.getTimestamp("data_cadastro"));
        }
        this.desconectar();
        return c;
    }

    public void inserirCliente(Cliente c) throws Exception {
        String sql = "INSET INTO Cliente (nome, cpf, senha, telefone, telefone_contato, termos, data_cadastro) VALUES (?,?,?,?,?,?,NOW())";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, c.getNome());
        pstm.setString(2, c.getCpf());
        pstm.setString(3, c.getSenha());
        pstm.setString(4, c.getTelefone());
        pstm.setString(5, c.getTelefoneContato());
        pstm.setString(6, c.getTermos());
        pstm.execute();
        this.desconectar();
    }

    public void alterarCliente(Cliente c) throws Exception {
        String sql = "UPDATE Cliente SET nome=?, cpf=?, senha=?, telefone=?, telefone_contato=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, c.getNome());
        pstm.setString(2, c.getCpf());
        pstm.setString(3, c.getSenha());
        pstm.setString(4, c.getTelefone());
        pstm.setString(5, c.getTelefoneContato());
        pstm.setInt(6, c.getId());
        pstm.execute();
        this.desconectar();
    }

    public void deletarCliente(int id) throws Exception {
        String sql = "DELETE * FROM Cliente WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
}
