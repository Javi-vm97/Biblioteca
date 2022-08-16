/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.LibroDAO;
import modelo.Libro;
import vista.Vista;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author JAVI
 */
public class Controladorlibro implements ActionListener{
    LibroDAO dao=new LibroDAO();
    Libro l=new Libro();
    Vista vista=new Vista();
    DefaultTableModel modelo=new DefaultTableModel();
    public Controladorlibro(Vista v){
        this.vista=v;
        this.vista.btnListarlibro.addActionListener(this);
        this.vista.btnCrearlibro.addActionListener(this);
        this.vista.btnVerlibro.addActionListener(this);
        this.vista.btnActualizarlibro.addActionListener(this);
        this.vista.btnBorrarlibro.addActionListener(this);
        //confi
        this.vista.btnbuscar.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnListarlibro)
        {
            limpiarTabla();
            listar(vista.tablalibro);
            nuevolibro();
        }
        if(e.getSource()==vista.btnCrearlibro){
            crear();
            listar(vista.tablalibro);
            nuevolibro();
        }
        if(e.getSource()==vista.btnVerlibro) {
            int fila=vista.tablalibro.getSelectedRow();
            if (fila== -1){
                JOptionPane.showMessageDialog(vista,"Por favor, seleccione una fila");
            }
            else{
                int idlibro=Integer.parseInt((String)vista.tablalibro.getValueAt(fila,0).toString());
                String nomlibro=(String)vista.tablalibro.getValueAt(fila,1);
                String nomautor=(String)vista.tablalibro.getValueAt(fila,2);
                String nomcategoria=(String)vista.tablalibro.getValueAt(fila,3);
                vista.txtidlibro.setText(""+idlibro);
                vista.txtnomlibro.setText(nomlibro);
                vista.txtautorlibro.setText(nomautor);
                //se le agrega la categoria
            } 
        }
        if(e.getSource()==vista.btnActualizarlibro){
            Actualizar();
            listar(vista.tablalibro);
            nuevolibro();
        }
        if(e.getSource()==vista.btnBorrarlibro){
                eliminar();
                listar(vista.tablalibro);
                nuevolibro();
            }
        if (e.getSource() == vista.btnnuevolibro){
            nuevolibro();
        }
        //En esta opcion se intenta relacionar las consultas para buscar
        if(e.getSource()==vista.btnbuscar){
            int opbuscar=vista.combo.getSelectedIndex();
            String valor=vista.txtbuscar.getText();
            Mostraropciones(opbuscar,valor);
        }

    }
    void nuevolibro(){
        vista.txtidlibro.setText("");
        vista.txtnomlibro.setText("");
        vista.txtautorlibro.setText("");
        vista.txtnomlibro.requestFocus();
    }
    
    public void eliminar(){
           int fila=vista.tablalibro.getSelectedRow();
            if (fila==-1){
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila:");
            }else{
                int idlibro=Integer.parseInt((String)vista.tablalibro.getValueAt(fila, 0).toString());
                dao.eliminar(idlibro);
                System.out.println("El libro eliminado es "+idlibro);
                JOptionPane.showMessageDialog(vista, "El libro ha sido eliminado"); 
            }
            limpiarTabla();
}
    
    public void crear (){
        int idlibro=Integer.parseInt(vista.txtidlibro.getText());
        String nomlibro=vista.txtnomlibro.getText();
        String nomautor=vista.txtautorlibro.getText();
        l.setIdlibro(idlibro);
        l.setNomlibro(nomlibro);
        l.setNomautor(nomautor);
        int r=dao.crear(l);
        if(r==1){
            JOptionPane.showMessageDialog(vista, "Se ha añadido el libro con exito");
        } else{
            JOptionPane.showMessageDialog(vista, "Ha ocurrido un error al añadir el libro,por favor, intentelo de nuevo");
        }
        limpiarTabla();
        
    }
    public void listar(JTable tablalibro){
        centrarCeldas(tablalibro);
        modelo=(DefaultTableModel)tablalibro.getModel();
        tablalibro.setModel(modelo);
        List<Libro>lista=dao.listarlibro();
        Object[]objeto=new Object[4];
        for (int i=0; i<lista.size();i++)
        {
            objeto[0]=lista.get(i).getIdlibro();
            objeto[1]=lista.get(i).getNomlibro();
            objeto[2]=lista.get(i).getNomautor();
            objeto[3]=lista.get(i).getNomcategoria();
            modelo.addRow(objeto);
        }
        vista.tablalibro.setModel(modelo);
        tablalibro.setRowHeight(35);
        tablalibro.setRowMargin(10);
    }
    void limpiarTabla(){
        for(int i=0;i<vista.tablalibro.getRowCount();i++){
            modelo.removeRow(i);
            i=i-1;
        }
    }
    
    //metodo para hacer las consultas en sql y devolverlas a la tabla
    public void Mostraropciones(int opbuscar, String valor){
        String codsql;
        if(opbuscar ==0 && valor==null){
            codsql ="SELECT * FROM libros";
        }else {
            if (opbuscar == 1 && valor!=null){
                codsql="SELECT *FROM libros WHERE id=´"+valor+"´";
            }else {
                if(opbuscar == 2 && valor !=null){
                    codsql="SELECT *FROM libros WHERE titulo=´"+valor+"´";
                }else {
                    if (opbuscar == 2 && valor !=null){
                        codsql="SELECT *FROM libros WHERE autor=´"+valor+"´";
                    }if (opbuscar == 2 && valor!=null){
                        codsql="SELECT *FROM libros WHERE categoria=´"+valor+"´";
                    }else{
                        codsql="SELECT *FROM libros";
                    }
                }
            }
        }
    }
    public void Actualizar(){
        if (vista.txtidlibro.getText().equals("")){
            JOptionPane.showMessageDialog(vista, "No se Identifica el Id debe selecionar la opcion Ver/Editar");
        }else {
            int idlibro=Integer.parseInt(vista.txtidlibro.getText());
            String nomlibro=vista.txtnomlibro.getText();
            String nomautor=vista.txtautorlibro.getText();
            l.setIdlibro(idlibro);
            l.setNomlibro(nomlibro);
            l.setNomautor(nomautor);
            int r=dao.Actualizar(l);
            if (r == 1){
                JOptionPane.showMessageDialog(vista, "Libro actualizado con exito");
            
            }else {
                JOptionPane.showMessageDialog(vista, "Ha ocurrido u  error al actualizar el libro, intente de nuevo");
        }
    }
        limpiarTabla();
        }

    private void centrarCeldas(JTable tablalibro) {
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vista.tablalibro.getColumnCount(); i++) {
        tablalibro.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }
}
    