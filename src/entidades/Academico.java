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
public class Academico extends Documento {

    private String universidad;
    private String genero;

    public Academico() {
        universidad = "Desconocido";
        genero = "Desconocido";
        this.setTipo("Académico");
    }

    public Academico(String autor, String titulo, String año, String universidad, String genero) {
        super(autor, titulo, año);
        this.universidad = universidad;
        this.genero = genero;
        this.setTipo("Académico");
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return super.toString() + "\nUniversidad: " + universidad + "\nGenero: " + genero;
    }
    
    @Override
    public int getTamañoBytes() {
        return super.getTamañoBytes() + (getGenero() + getUniversidad()).length() * 2 + 4;
    }
}
