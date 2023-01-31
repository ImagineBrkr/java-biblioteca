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
public class Documento {

    private String autor;
    private String titulo;
    private String año;
    private String tipo;

    public Documento() {
        autor = "Anónimo";
        titulo = "Desconocido";
        año = "Desconocido";
        tipo = "";
    }

    public Documento(String autor, String titulo, String año) {
        this.autor = autor;
        this.titulo = titulo;
        this.año = año;
        tipo = "";
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\nAutor: " + autor + "\nTítulo: " + titulo + "\nAño de publicación: " + año;
    }
    
    public int getTamañoBytes() {
        return (getTitulo() + getAutor() + getAño() + getTipo()).length() + 8;
    }
}
