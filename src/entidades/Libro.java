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
public class Libro extends Documento {

    private String genero;
    private String editorial;

    public Libro() {
        super();
        genero = "Desconocido";
        editorial = "Desconocido";
    }

    public Libro(String autor, String titulo, String año, String genero, String editorial) {
        super(autor, titulo, año);
        this.genero = genero;
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return super.toString() + "\nGénero: " + genero + "\nEditorial: " + editorial;
    }
    
    @Override
    public int getTamañoBytes() {
        return super.getTamañoBytes() + (getGenero() + getEditorial()).length() * 2 + 4;
    }
}
