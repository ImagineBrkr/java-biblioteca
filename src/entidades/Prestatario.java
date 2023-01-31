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
public class Prestatario extends Persona implements Comparable<Prestatario> {

    private String codigoCarnet;
    private String direccion;
    private int prestados;

    public Prestatario() {
        super();
        codigoCarnet = "NCT";
        direccion = "SD";
        prestados = 0;
    }

    public Prestatario(String nombres, String apellidos, String dni, String telefono, String codigoCarnet, String direccion) {
        super(nombres, apellidos, dni, telefono);
        this.codigoCarnet = codigoCarnet;
        this.direccion = direccion;
        prestados = 0;
    }

    public String getCodigoCarnet() {
        return codigoCarnet;
    }

    public void setCodigoCarnet(String codigoCarnet) {
        this.codigoCarnet = codigoCarnet;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCódigo de carnet: " + codigoCarnet + "\nDirección: " + direccion + "\nLibros prestados: " + getPrestados();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.codigoCarnet);
        return hash;
    }

    public int getPrestados() {
        return prestados;
    }

    public void setPrestados(int prestados) {
        this.prestados = prestados;
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
        final Prestatario other = (Prestatario) obj;
        if (!Objects.equals(this.codigoCarnet, other.codigoCarnet)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Prestatario t) {
        return this.getCodigoCarnet().compareToIgnoreCase(t.getCodigoCarnet());
    }

    public void PrestarLibro() {
        prestados += 1;
    }

    public void DevolverLibro() {
        prestados -= 1;
    }
    
    @Override
    public int getTamañoBytes() {
        return super.getTamañoBytes() + (getDireccion() + getCodigoCarnet()).length() * 2 + 6;
    }
}
