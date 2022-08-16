/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import modelo.CategoriaDAO;
import modelo.Categoria;
import vista.Vista;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author JAVI
 */
public class Controlador implements ActionListener{
    CategoriaDAO dao=new CategoriaDAO();
    Categoria c=new Categoria();
    Vista vista=new Vista();
    DefaultTableModel modelo=new DefaultTableModel();
    
    public Controlador(Vista v){
        this.vista=v;
        this.vista.btnListarcat.addActionListener(this);
        this.vista.btnCrearcat.addActionListener(this);
        this.vista.btnVercat.addActionListener(this);
        this.vista.btnActualizarcat.addActionListener(this);
        this.vista.btnBorrarcat.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnListarcat)
        {
            limpiarTabla();
            listar(vista.tablacat);
        }
        if(e.getSource()==vista.btnCrearcat){
            crear();
            limpiarTabla();
            listar(vista.tablacat);
        }
        if(e.getSource()==vista.btnVercat) {
            int fila=vista.tablacat.getSelectedRow();
            if (fila==-1){
                JOptionPane.showMessageDialog(vista,"Seleccione una fila");
            }
            else{
                int idcat=Integer.parseInt((String)vista.tablacat.getValueAt(fila,0).toString());
                String nomcat=(String)vista.tablacat.getValueAt(fila,1);
                vista.txtidcat.setText(""+idcat);
                vista.txtnomcat.setText(nomcat);
            } 
        }
        if(e.getSource()==vista.btnActualizarcat){
            Actualizar();
            limpiarTabla();
            listar(vista.tablacat);
        }
        if(e.getSource()==vista.btnBorrarcat){
            eliminar();
            limpiarTabla();
            listar(vista.tablacat);
        }
            
    }
    public void eliminar(){
            int fila=vista.tablacat.getSelectedRow();
            if (fila==-1){
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una categoria:");
            }else{
                String idcat=((String)vista.tablacat.getValueAt(fila, 0).toString());
                dao.eliminar(idcat);
                JOptionPane.showMessageDialog(vista, "Categoria eliminada");
            }
    }
    public void crear (){
        String idcat=vista.txtidcat.getText();
        String nomcat=vista.txtnomcat.getText();
        c.setIdcat(idcat);
        c.setNomcat(nomcat);
        int r=dao.crear(c);
        if(r==1){
            JOptionPane.showMessageDialog(vista, "Categoria creada con exito");
        } else{
            JOptionPane.showMessageDialog(vista, "Ha ocurrido un error al agregar la categoria, intentelo de nuevo");
        }
        
    }
            
    public void listar(JTable tabla){
        modelo=(DefaultTableModel)tabla.getModel();
        List<Categoria>lista=dao.listar();
        Object[]object=new Object[2];
        for (int i=0; i<lista.size();i++)
        {
            object[0]=lista.get(i).getIdcat();
            object[1]=lista.get(i).getNomcat();
            modelo.addRow(object);
        }
        vista.tablacat.setModel(modelo);
        
        
    }
    void limpiarTabla(){
        for(int i=0;i<vista.tablacat.getRowCount();i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }
    public void Actualizar(){
        String idcat=vista.txtidcat.getText();
        String nomcat=vista.txtnomcat.getText();
        c.setIdcat(idcat);
        c.setNomcat(nomcat);
        int r=dao.Actualizar(c);
        if (r==1){
            JOptionPane.showMessageDialog(vista, "Categoria Actualizada con exito");
            
        }else {
            JOptionPane.showMessageDialog(vista, "Ha ocurrido un error, por favor, intente de nuevo");
        }
    }
    
}
