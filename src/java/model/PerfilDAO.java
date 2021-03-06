package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PerfilDAO extends DataBase {
    public ArrayList<Perfil> listaPerfils() throws Exception{
     String sql = "SELECT * FROM Perfil";
     ArrayList<Perfil> lista = new ArrayList<Perfil>();
     this.conectar();
     PreparedStatement pstm = conn.prepareStatement(sql);
     ResultSet rs = pstm.executeQuery();
        while (rs.next()) {            
            Perfil p = new Perfil();
            p.setId(rs.getInt("id"));
            p.setTitulo(rs.getString("titulo"));
            p.setDescricao(rs.getString("descricao"));
            lista.add(p);
        }
     this.desconectar();
     return lista;
    }
    
    public Perfil carregarPorId(int id) throws Exception{
        Perfil p = new Perfil();
        String sql = "SELECT * FROM Perfil WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            p.setId(rs.getInt("id"));
            p.setTitulo(rs.getString("titulo"));
            p.setDescricao(rs.getString("descricao"));
        }
        this.desconectar();
        return p;
    }
    
    public void inserirPerfil(Perfil p) throws Exception{
        String sql = "INSERT INTO Perfil (titulo, descricao) VALUES (?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, p.getTitulo());
        pstm.setString(2, p.getDescricao());
        pstm.execute();
        this.desconectar();
    }
    
    public void alterarPerfil(Perfil p) throws Exception{
        String sql = "UPDATE Perfil SET titulo=?, descricao=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, p.getTitulo());
        pstm.setString(2, p.getDescricao());
        pstm.setInt(3, p.getId());
        pstm.execute();
        this.desconectar();
    }
    public void deletarPerfil(int id) throws Exception{
        String sql = "DELETE FROM Perfil WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    public void vincularPerfilMenu(int idPerfil, int idMenu)throws Exception{
        String sql = "INSERT INTO perfil_menu (id_perfil,id_menu) VALUES (?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idPerfil);
        pstm.setInt(2, idMenu);
        pstm.execute();
        this.desconectar();
    }
    public void desvincularPerfilMenu(int idPerfil, int idMenu) throws Exception{
        String sql = "DELETE FROM perfil_menu WHERE id_perfil=? AND id_menu=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idPerfil);
        pstm.setInt(2, idMenu);
        pstm.execute();
        this.desconectar();
    }
}
