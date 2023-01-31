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
public class Persona {

    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;

    public Persona() {
        nombres = "NN";
        apellidos = "NA";
        dni = "00000000";
        telefono = "00000000";
    }

    public Persona(String nombres, String apellidos, String dni, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "\nNombres: " + nombres + "\nApellidos: " + apellidos + "\nDNI: " + dni + "\nTeléfono: " + telefono;
    }

    public int getTamañoBytes() {
        return (getNombres() + getApellidos() + getDni() + getTelefono()).length() * 2 + 8;
    }
    
}
