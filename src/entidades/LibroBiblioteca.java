/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Objects;

/**
 *
 * @author Jara
 */
public class LibroBiblioteca implements Comparable<LibroBiblioteca> {

    private String codigo;
    private Documento documento;
    private int cantidad;

    public LibroBiblioteca() {
        codigo = "11111111";
        documento = new Documento();
        cantidad = 0;
    }

    public LibroBiblioteca(String codigo, Documento documento, int cantidad) {

        this.codigo = codigo;
        this.documento = documento;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "El documento: " + getDocumento().getTitulo() + "\n"
                + "Presenta el código: " + getCodigo() + "\n"
                + "Cantidad de este documento disponible: " + getCantidad();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LibroBiblioteca other = (LibroBiblioteca) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(LibroBiblioteca t) {
        return this.getCodigo().compareToIgnoreCase(t.getCodigo());
    }

    public void PrestarLibro() {
        cantidad -= 1;
    }

    public void DevolverLibro() {
        cantidad += 1;
    }
    
    public int getTamañoBytes() {
        return getCodigo().length() * 2 + documento.getTamañoBytes() + 4;
    }
}
