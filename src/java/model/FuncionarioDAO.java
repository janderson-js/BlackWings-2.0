package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioDAO extends DataBase {

    public ArrayList<Funcionario> listaFuncionarios() throws Exception {
        String sql = "SELECT * FROM Funcionario";
        PerfilDAO pDAO = new PerfilDAO();
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Funcionario f = new Funcionario();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setMatricula(rs.getString("matricula"));
            f.setSenha(rs.getString("senha"));
            f.setTelefone(rs.getString("telefone"));
            f.setTelefoneContato(rs.getString("telefone_contato"));
            f.setCep(rs.getString("cep"));
            f.setCidade(rs.getString("cidade"));
            f.setBairro(rs.getString("bairro"));
            f.setEndereco(rs.getString("endereco"));
            f.setCasa(rs.getString("casa"));
            f.setComplemento(rs.getString("complemento"));
            f.setStatus(rs.getString("status"));
            f.setDataContrato(rs.getTimestamp("data_contrato"));
            f.setValidadeContrato(rs.getTimestamp("validade"));
            f.setSaida(rs.getTimestamp("saida"));
            f.setDataNascimento(rs.getTimestamp("data_nascimento"));
            f.setPerifl(pDAO.carregarPorId(rs.getInt("id_perfil")));
            lista.add(f);
        }
        this.desconectar();
        return lista;
    }

    public Funcionario carregarPorId(int id) throws Exception {
        Funcionario f = new Funcionario();
        String sql = "SELECT * FROM Funcionario WHERE id=?";
        PerfilDAO pDAO = new PerfilDAO();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setMatricula(rs.getString("matricula"));
            f.setSenha(rs.getString("senha"));
            f.setTelefone(rs.getString("telefone"));
            f.setTelefoneContato(rs.getString("telefone_contato"));
            f.setCep(rs.getString("cep"));
            f.setCidade(rs.getString("cidade"));
            f.setBairro(rs.getString("bairro"));
            f.setEndereco(rs.getString("endereco"));
            f.setCasa(rs.getString("casa"));
            f.setComplemento(rs.getString("complemento"));
            f.setStatus(rs.getString("status"));
            f.setDataContrato(rs.getTimestamp("data_contrato"));
            f.setValidadeContrato(rs.getTimestamp("validade"));
            f.setSaida(rs.getTimestamp("saida"));
            f.setDataNascimento(rs.getTimestamp("data_nascimento"));
            f.setPerifl(pDAO.carregarPorId(rs.getInt("id_perfil")));
        }
        this.desconectar();
        return f;
    }

    public void inserirFuncionario(Funcionario f) throws Exception {
        String sql = "INSERT INTO Funcionario (nome, matricula, senha, telefone, telefone_contato, cep, cidade, bairro, endereco, casa, "
                + "complemento, data_nascimento, data_contrato, validade, saida, id_perfil) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, f.getNome());
        pstm.setString(2, f.getMatricula());
        pstm.setString(3, f.getSenha());
        pstm.setString(4, f.getTelefone());
        pstm.setString(5, f.getTelefoneContato());
        pstm.setString(6, f.getCep());
        pstm.setString(7, f.getCidade());
        pstm.setString(8, f.getBairro());
        pstm.setString(9, f.getEndereco());
        pstm.setString(10, f.getCasa());
        pstm.setString(11, f.getComplemento());
        pstm.setTimestamp(12, f.getDataNascimento());
        pstm.setTimestamp(13, f.getDataContrato());
        pstm.setTimestamp(14, f.getValidadeContrato());
        pstm.setTimestamp(15, f.getSaida());
        pstm.setInt(16, f.getPerifl().getId());
        pstm.execute();
        this.desconectar();
    }
 
    public void alterarFuncionario(Funcionario f) throws Exception {
        String sql = "UPDATE Funcionario SET nome=?, matricula=?, senha=?, telefone=?, telefone_contato=?, cep=?, cidade=?, bairro=?, endereco=?, casa=?, "
                + "complemento=?, data_nascimento=?, data_contrato=?, validade=?, saida=?, id_perfil=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, f.getNome());
        pstm.setString(2, f.getMatricula());
        pstm.setString(3, f.getSenha());
        pstm.setString(4, f.getTelefone());
        pstm.setString(5, f.getTelefoneContato());
        pstm.setString(6, f.getCep());
        pstm.setString(7, f.getCidade());
        pstm.setString(8, f.getBairro());
        pstm.setString(9, f.getEndereco());
        pstm.setString(10, f.getCasa());
        pstm.setString(11, f.getComplemento());
        pstm.setTimestamp(12, f.getDataNascimento());
        pstm.setTimestamp(13, f.getDataContrato());
        pstm.setTimestamp(14, f.getValidadeContrato());
        pstm.setTimestamp(15, f.getSaida());
        pstm.setInt(16, f.getPerifl().getId());
        pstm.setInt(17, f.getId());
        pstm.execute();
        this.desconectar();
    }

    public void deletarFuncionario(int id) throws Exception {
        String sql = "DELETE FROM Funcionario WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
}
