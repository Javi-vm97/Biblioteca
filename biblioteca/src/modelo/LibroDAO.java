/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JAVI
 */
public class LibroDAO {
    Conexion conectar=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Libro l=new Libro();
    
    public List listarlibro(){
        List<Libro>datoslibro=new ArrayList<>();
        String sql="select*from libros";
        try {
            con =conectar.getConnection();
            ps =con.prepareStatement("select * from Libros");
            rs = ps.executeQuery();
            while (rs.next()){
                Libro l=new Libro();
                l.setIdlibro(rs.getInt(1));
                l.setNomlibro(rs.getString(2));
                l.setNomautor(rs.getString(3));
                l.setNomcategoria(rs.getString(4));
                datoslibro.add(l);
            }
        } catch (Exception e){
            
        }return datoslibro;
        
    }
    public int crear(Libro lib)
    {
        int r=0;
        String sql="insert into libros(id, titulo, autor) values(?,?,?)";
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);    
            ps.setInt(1, lib.getIdlibro());
            ps.setString(2, lib.getNomlibro());
            ps.setString(3, lib.getNomautor());
            r=ps.executeUpdate();
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e){
      
    }
        return r;
    }
     public int Actualizar (Libro lib){
         int r=0;
        String sql="update libros set titulo=?, autor=?, categoria=? where id=?";
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, lib.getIdlibro());
            ps.setString(2, lib.getNomautor());
            ps.setString(3, lib.getNomlibro());
            ps.setString(4,lib.getNomcategoria());
            r=ps.executeUpdate();
            if(r==1){
                return 1;
            }else {
                return 0;
            }
        }catch (Exception e){
            
        }return r;
    }
    public int eliminar (int idlibro){
        int r=0;
        String sql="delete from libros where id="+idlibro;
         try {
             con=conectar.getConnection();
             ps=con.prepareStatement(sql);
             r= ps.executeUpdate();
         } catch (Exception e){
             
         }
         return r;
     }
    
}
