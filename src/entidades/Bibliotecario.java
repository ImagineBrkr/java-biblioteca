/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Objects;

/**
 *
 * @author USUARIO
 */
public class Bibliotecario extends Persona implements Comparable<Bibliotecario> {

    private String codigo;
    private String contraseña;

    public Bibliotecario() {
        super();
        codigo = "NCC";
        contraseña = "NCA";
    }

    public Bibliotecario(String nombres, String apellidos, String dni, String telefono, String codigo, String contraseña) {
        super(nombres, apellidos, dni, telefono);
        this.codigo = codigo;
        this.contraseña = contraseña;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCódigo: " + codigo + "\nContraseña: " + contraseña;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.codigo);
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
        final Bibliotecario other = (Bibliotecario) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Bibliotecario bibliotecario) {
        return this.getCodigo().compareToIgnoreCase(bibliotecario.getCodigo());
    }
    
    @Override
    public int getTamañoBytes() {
        return super.getTamañoBytes() + (getCodigo() + getContraseña()).length() * 2 + 4;
    }

}
