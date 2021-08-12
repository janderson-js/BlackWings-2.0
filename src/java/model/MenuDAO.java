package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MenuDAO extends DataBase {
    public ArrayList<Menu> listaMenus() throws Exception{
     String sql = "SELECT * FROM Menu";
     ArrayList<Menu> lista = new ArrayList<Menu>();
     this.conectar();
     PreparedStatement pstm = conn.prepareStatement(sql);
     ResultSet rs = pstm.executeQuery();
        while (rs.next()) {            
            Menu m = new Menu();
            m.setId(rs.getInt("id"));
            m.setTitulo(rs.getString("titulo"));
            m.setLink(rs.getString("link"));
            lista.add(m);
        }
     this.desconectar();
     return lista;
    }
    
    public Menu carregarPorId(int id) throws Exception{
        Menu m= new Menu();
        String sql = "SELECT * FROM Menu WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            m.setId(rs.getInt("id"));
            m.setTitulo(rs.getString("titulo"));
            m.setLink(rs.getString("link"));
        }
        this.desconectar();
        return m;
    }
    
    public void inserirMenu(Menu m) throws Exception{
        String sql = "INSERT INTO Menu (titulo, link) VALUES (?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, m.getTitulo());
        pstm.setString(2, m.getLink());
        pstm.execute();
        this.desconectar();
    }
    
    public void alterarMenu(Menu m) throws Exception{
        String sql = "UPDATE Menu SET titulo=?, link=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, m.getTitulo());
        pstm.setString(2, m.getLink());;
        pstm.setInt(3, m.getId());
        pstm.execute();
        this.desconectar();
    }
    public void deletarMenu(int id) throws Exception{
        String sql = "DELETE  FROM Menu WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    public ArrayList<Menu> listarMenusPerfil(int id_perfil) throws Exception {
        ArrayList<Menu> lista = new ArrayList<Menu>();
        String sql = "SELECT m.* FROM menu as m, perfil_menu as pm WHERE m.id=pm.id_menu AND pm.id_perfil=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_perfil);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Menu m = new Menu();
            m.setId(rs.getInt("id"));
            m.setTitulo(rs.getString("titulo"));
            m.setLink(rs.getString("link"));
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }

    public ArrayList<Menu> listarMenusNaoPerfil(int id_perfil) throws Exception {
        ArrayList<Menu> lista = new ArrayList<Menu>();
        String sql = "SELECT * FROM menu "
                + "WHERE id NOT IN(SELECT pm.id_menu FROM perfil_menu as pm WHERE pm.id_perfil=?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_perfil);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Menu m = new Menu();
            m.setId(rs.getInt("id"));
            m.setTitulo(rs.getString("titulo"));
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }
}
