/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JAVI
 */
public class Libro {
    int idlibro;
    String nomlibro;
    String nomautor;
    String nomcategoria;
    
    public Libro() {
    }
    
    public Libro(int idlibro, String nomlibro, String nomautor, String nomcategoria)
    {
        this.idlibro=idlibro;
        this.nomlibro=nomlibro;
        this.nomautor=nomautor;
        this.nomcategoria=nomcategoria;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getNomlibro() {
        return nomlibro;
    }

    public void setNomlibro(String nomlibro) {
        this.nomlibro = nomlibro;
    }

    public String getNomautor() {
        return nomautor;
    }

    public void setNomautor(String nomautor) {
        this.nomautor = nomautor;
    }

    public String getNomcategoria() {
        return nomcategoria;
    }

    public void setNomcategoria(String nomcategoria) {
        this.nomcategoria = nomcategoria;
    }
}
