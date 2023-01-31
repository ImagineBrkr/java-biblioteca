/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author USUARIO
 */
public class Revista extends Documento {

    public String editorial;

    public Revista() {
        super();
        editorial = "Desconocido";
        this.setTipo("Revista");
    }

    public Revista(String autor, String titulo, String año, String editorial) {
        super(autor, titulo, año);
        this.editorial = editorial;
        this.setTipo("Revista");
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEditorial: " + editorial;
    }
    
    @Override
    public int getTamañoBytes() {
        return super.getTamañoBytes() + (getEditorial().length() * 2) + 4;
    }
}
