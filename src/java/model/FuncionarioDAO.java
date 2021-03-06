package model;

import java.sql.Timestamp;
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

    public Funcionario loginFuncionario(String login, String senha) throws Exception {
        String sql = "SELECT * FROM funcionario WHERE matricula=?";
        Funcionario f = new Funcionario();
        PerfilDAO pDAO = new PerfilDAO();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, login);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            if (senha.equals(rs.getString("senha"))) {
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setMatricula(rs.getString("matricula"));
                f.setSenha(rs.getString("senha"));
                f.setTelefoneContato(rs.getString("telefone_contato"));
                f.setTelefone(rs.getString("telefone"));
                f.setCep(rs.getString("cep"));
                f.setCidade(rs.getString("cidade"));
                f.setBairro(rs.getString("bairro"));
                f.setEndereco(rs.getString("endereco"));
                f.setCasa(rs.getString("casa"));
                f.setComplemento(rs.getString("complemento"));
                f.setPerifl(pDAO.carregarPorId(rs.getInt("id_perfil")));
            }
        }
        this.desconectar();
        return f;
    }

    public ArrayList<Atendimento> horariosFuncionario(int idFuncionario, Timestamp data) throws Exception {
        ArrayList<Atendimento> lista = new ArrayList<>();
        String sql = "SELECT data, hora FROM atendimento WHERE id_funcionario=? AND data=? AND status='Agendado'";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idFuncionario);
        pstm.setTimestamp(2, data);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Atendimento a = new Atendimento();
            a.setData(rs.getTimestamp("data"));
            a.setHora(rs.getTimestamp("hora"));
            lista.add(a);
        }
        this.desconectar();
        return lista;
    }
    
    public ArrayList<Funcionario> listarFuncionarioInativo() throws  Exception {
        String sql = "SELECT * FROM Funcionario WHERE status='Inativo'";
        PerfilDAO pDAO = new PerfilDAO();
        ArrayList<Funcionario> lista = new ArrayList<>();
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
    
    public ArrayList<Funcionario> buscarFuncionario(String matricula) throws Exception{
        ArrayList<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario WHERE matricula=?";
        PerfilDAO pDAO = new PerfilDAO();
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
    
    public void alterarStatusFuncionario(Funcionario f) throws Exception{
        String sql = "UPDATE Funcionario SET status=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, f.getStatus());
        pstm.setInt(2, f.getId());
        pstm.execute();
        this.desconectar();
    }
    
    public ArrayList<Atendimento> funcionarioServicoDoDia(int id) throws Exception{
        ArrayList<Atendimento> lista = new ArrayList<>();   
        String sql = "SELECT * FROM Atendimento WHERE status='Agendado' AND data=CURDATE() AND id_funcionario=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {            
            Atendimento a = new Atendimento();
            ClienteDAO cDAO = new ClienteDAO();
            AtendimentoDAO aDAO = new AtendimentoDAO();
            
            a.setId(rs.getInt("id"));
            a.setCliente(cDAO.carregarPorId(rs.getInt("id_cliente")));
            a.setFuncionario(this.carregarPorId(rs.getInt("id_funcionario")));
            a.setData(rs.getTimestamp("data"));
            a.setHora(rs.getTimestamp("hora"));
            a.setServico(aDAO.carregaServicos(id));
            a.setPreco(aDAO.valorServico(rs.getInt("id")));
            lista.add(a);
        }
        this.desconectar();
        return lista;
    }
    
    public ArrayList<Atendimento> funcionarioServicoAgendado(int id) throws Exception{
        ArrayList<Atendimento> lista = new ArrayList<>();   
        String sql = "SELECT * FROM Atendimento WHERE status='Agendado' AND data!=CURDATE() AND id_funcionario=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {            
            Atendimento a = new Atendimento();
            ClienteDAO cDAO = new ClienteDAO();
            AtendimentoDAO aDAO = new AtendimentoDAO();
            
            a.setId(rs.getInt("id"));
            a.setCliente(cDAO.carregarPorId(rs.getInt("id_cliente")));
            a.setFuncionario(this.carregarPorId(rs.getInt("id_funcionario")));
            a.setData(rs.getTimestamp("data"));
            a.setHora(rs.getTimestamp("hora"));
            a.setServico(aDAO.carregaServicos(id));
            a.setPreco(aDAO.valorServico(rs.getInt("id")));
            lista.add(a);
        }
        this.desconectar();
        return lista;
    }
    
    public void servicoRealizado(int id) throws Exception {
        String sql = "UPDATE Atendimento SET status='Realizado' WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(2, id);
        pstm.execute();
        this.desconectar();
    }
}
