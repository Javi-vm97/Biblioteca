/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JAVI
 */
public class Categoria {
    String idcat;
    String nomcat;
    
    public Categoria() {
    }
    
    public Categoria(String idcat, String nomcat)
    {
        this.idcat=idcat;
        this.nomcat=nomcat;
    }

    public String getIdcat() {
        return idcat;
    }

    public void setIdcat(String idcat) {
        this.idcat = idcat;
    }

    public String getNomcat() {
        return nomcat;
    }

    public void setNomcat(String nomcat) {
        this.nomcat = nomcat;
    }


    
}
