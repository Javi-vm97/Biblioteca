/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.*;

/**
 *
 * @author JAVI
 */
public class CategoriaDAO {
    Conexion conectar=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<Categoria>datos=new ArrayList<>();
        String sql="select*from categoria";
        try {
            con =conectar.getConnection();
            ps =con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Categoria c=new Categoria();
                c.setIdcat(rs.getString(1));
                c.setNomcat(rs.getString(2));
                datos.add(c);
            }
        } catch (Exception e){
            
        }return datos;
        
    }
    public int crear(Categoria c)
    {
        String sql="insert into categoria(id, nombreCAT) values(?,?)";
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);    
            ps.setString(1, c.getIdcat());
            ps.setString(2, c.getNomcat());
            ps.executeUpdate();
        } catch (Exception e){
      
    }
        return 1;
    }
     public int Actualizar (Categoria c){
        String sql="update categoria set nombreCAT=? where id=?";
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.getIdcat());
            ps.setString(2, c.getNomcat());
            ps.executeUpdate();
        }catch (Exception e){
            
        }return 1;
    }
     public void eliminar (String idcat){
         String sql="delete from categoria where id="+idcat;
         try {
             con=conectar.getConnection();
             ps=con.prepareStatement(sql);
             ps.executeUpdate();
         } catch (Exception e){
             
         }
         
     }
    
}
