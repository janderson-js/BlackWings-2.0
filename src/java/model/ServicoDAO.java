package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ServicoDAO extends DataBase {
    public ArrayList<Servico> listaServicos() throws Exception{
     String sql = "SELECT * FROM Servico";
     ArrayList<Servico> lista = new ArrayList<Servico>();
     this.conectar();
     PreparedStatement pstm = conn.prepareStatement(sql);
     ResultSet rs = pstm.executeQuery();
        while (rs.next()) {            
            Servico s = new Servico();
            s.setId(rs.getInt("id"));
            s.setNome(rs.getString("nome"));
            s.setTipo(rs.getString("tipo"));
            s.setValor(rs.getDouble("valor"));
            lista.add(s);
        }
     this.desconectar();
     return lista;
    }
    
    public Servico carregarPorId(int id) throws Exception{
        Servico s = new Servico();
        String sql = "SELECT * FROM Servico WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            s.setId(rs.getInt("id"));
            s.setNome(rs.getString("nome"));
            s.setTipo(rs.getString("tipo"));
            s.setValor(rs.getDouble("valor"));
        }
        this.desconectar();
        return s;
    }
    
    public void inserirServico(Servico s) throws Exception{
        String sql = "INSET INTO Servico (nome, tipo, valor) VALUES (?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, s.getNome());
        pstm.setString(2, s.getTipo());
        pstm.setDouble(3, s.getValor());
        pstm.execute();
        this.desconectar();
    }
    
    public void alterarServico(Servico s) throws Exception{
        String sql = "UPDATE Servico SET nome=?, tipo=?, valor=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, s.getNome());
        pstm.setString(2, s.getTipo());
        pstm.setDouble(3, s.getValor());
        pstm.setInt(4, s.getId());
        pstm.execute();
        this.desconectar();
    }
    public void deletarServico(int id) throws Exception{
        String sql = "DELETE * FROM Servico WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
}
