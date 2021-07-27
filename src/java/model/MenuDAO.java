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
            m.setIcone(rs.getString("icone"));
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
            m.setIcone(rs.getString("icone"));
        }
        this.desconectar();
        return m;
    }
    
    public void inserirMenu(Menu m) throws Exception{
        String sql = "INSET INTO Menu (titulo, link, icone) VALUES (?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, m.getTitulo());
        pstm.setString(2, m.getLink());
        pstm.setString(3, m.getIcone());
        pstm.execute();
        this.desconectar();
    }
    
    public void alterarMenu(Menu m) throws Exception{
        String sql = "UPDATE Menu SET titulo=?, link=?, icone=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, m.getTitulo());
        pstm.setString(2, m.getLink());
        pstm.setString(3, m.getIcone());
        pstm.setInt(4, m.getId());
        pstm.execute();
        this.desconectar();
    }
    public void deletarMenu(int id) throws Exception{
        String sql = "DELETE * FROM Menu WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
}
