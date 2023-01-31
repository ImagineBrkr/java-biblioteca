/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import interfaces.*;
import java.io.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.*;

/**
 *
 * @author Jara
 */
public class Biblioteca implements DevolverLibro {

    private RandomAccessFile flujo;
    private final int TAMREG = 220;
    private int numRegistros;
    private String nomArchivo = "Archivos\\Biblioteca.datos";
    private String nombre;
    private Bibliotecario director;
    private ListaBibliotecariosBL listaBibliotecarios;
    private ListaLibroBibliotecaBL librosBiblioteca;
    private ListaPrestatariosBL listaPrestatarios;
    private ListaLibrosPrestadosBL listaLibrosPrestados;
    private float multas = 0;

    public Biblioteca() {
        nombre = "NN";
        director = new Bibliotecario();
        listaBibliotecarios = new ListaBibliotecariosBL();
        librosBiblioteca = new ListaLibroBibliotecaBL();
        listaPrestatarios = new ListaPrestatariosBL();
        listaLibrosPrestados = new ListaLibrosPrestadosBL();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Bibliotecario getDirector() {
        return director;
    }

    public void setDirector(Bibliotecario director) {
        this.director = director;
    }

    public ListaBibliotecariosBL getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public void setListaBibliotecarios(ListaBibliotecariosBL listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }

    public ListaLibroBibliotecaBL getLibrosBiblioteca() {
        return librosBiblioteca;
    }

    public void setLibrosBiblioteca(ListaLibroBibliotecaBL librosBiblioteca) {
        this.librosBiblioteca = librosBiblioteca;
    }

    public ListaPrestatariosBL getListaPrestatarios() {
        return listaPrestatarios;
    }

    public void setListaPrestatarios(ListaPrestatariosBL listaPrestatarios) {
        this.listaPrestatarios = listaPrestatarios;
    }

    public ListaLibrosPrestadosBL getListaLibrosPrestados() {
        return listaLibrosPrestados;
    }

    public void setListaLibrosPrestados(ListaLibrosPrestadosBL listaLibrosPrestados) {
        this.listaLibrosPrestados = listaLibrosPrestados;
    }

    public boolean AgregarPrestatario(Prestatario prestatario) {
        return listaPrestatarios.listarPrestatario(prestatario);
    }

    public boolean AgregarBibliotecario(Bibliotecario bibliotecario) {
        return listaBibliotecarios.listarBibliotecario(bibliotecario);
    }

    public boolean AgregarLibroBiblioteca(LibroBiblioteca libroBiblioteca) {
        return librosBiblioteca.AgregarLibro(libroBiblioteca);
    }

    public boolean AgregarLibroPrestado(LibroPrestado libroPrestado) {
        return listaLibrosPrestados.AgregarLibro(libroPrestado);
    }

    public boolean PrestarLibro(String codigoLibro, String codigoPrestatario) {
        return librosBiblioteca.PrestarLibro(librosBiblioteca.buscarCodigo(codigoLibro), true)
                && listaPrestatarios.PrestarLibro(listaPrestatarios.buscarCodigo(codigoPrestatario), true);
    }

    @Override
    public boolean DevolverLibro(String codigoLibro, String codigoPrestatario, int pos) {
        multas += multaLibro(pos);
        listaLibrosPrestados.EliminarLibro(pos);
        return librosBiblioteca.PrestarLibro(librosBiblioteca.buscarCodigo(codigoLibro), false)
                && listaPrestatarios.PrestarLibro(listaPrestatarios.buscarCodigo(codigoPrestatario), false);
    }

    @Override
    public String toString() {
        return "\nEl nombre de la biblioteca es: " + getNombre() + "\n"
                + "El nombre del director encargado es: " + getDirector().toString() + "\n"
                + "Datos de los bibliotecarios: " + listaBibliotecarios.toString() + "\n"
                + "Datos de libros en la biblioteca: " + librosBiblioteca.toString() + "\n"
                + "Los prestatarios actualmente son: " + listaPrestatarios.toString() + "\n"
                + "Libros prestados actualmente: " + listaLibrosPrestados.toString();
    }

    public boolean ComprobarPrestatarioPlazo(String codigo) {
        int pos1 = listaLibrosPrestados.buscarCodigo1(codigo), pos2 = listaLibrosPrestados.buscarCodigo2(codigo);
        boolean v1 = true, v2 = true;
        if (pos1 != -1) {
            v1 = listaLibrosPrestados.getLibro(pos1).getDentroDelPlazo();
        }
        if (pos2 != -1) {
            v2 = listaLibrosPrestados.getLibro(pos2).getDentroDelPlazo();
        }
        return v1 && v2;
    }

    public void Aplazar(int pos) {
        listaLibrosPrestados.Aplazar(pos);
    }

    public void setMultas(float multas) {
        this.multas = multas;
    }

    public float getMultas() {
        return multas;
    }

    @Override
    public double multaLibro(int pos) {
        LibroPrestado libro = listaLibrosPrestados.getLibro(pos);
        if (!libro.getDentroDelPlazo()) {
            try {
                return base * 0.1 * (1 + libro.getTiempoFueraPlazo());
            } catch (ParseException ex) {
                Logger.getLogger(Biblioteca.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }

    public String crearArchivo() {
        try {
            flujo = new RandomAccessFile(nomArchivo, "rw");
            numRegistros = (int) Math.ceil((double) flujo.length() / (double) TAMREG);
        } catch (IOException ex) {
            return "Problema al crear el flujo: " + ex.getMessage();
        }
        return null;
    }

    public int getTamañoBytes() {
        return getNombre().length() * 2 + director.getTamañoBytes() + 2;
    }

    public String escribirBiblioteca(Biblioteca biblioteca) {
        String mensaje = "";
        try {
            crearArchivo();
            flujo.close();
            mensaje = setBiblioteca(numRegistros, biblioteca);
            if (mensaje.compareTo("ok") == 0) {
                numRegistros++;
            }
        } catch (IOException ex) {
            mensaje = "Excepción: " + ex.getMessage();
        } finally {
            return mensaje;
        }
    }

    public String setBiblioteca(int pos, Biblioteca biblioteca) {
        String mensaje = "";
        Bibliotecario director = biblioteca.getDirector();
        try {
            if (biblioteca.getTamañoBytes() + 2 > TAMREG) {
                mensaje = "Tamaño de registro insuficiente";
            } else {
                crearArchivo();
                flujo.seek(pos * TAMREG);
                flujo.writeUTF(biblioteca.getNombre());
                flujo.writeUTF(director.getNombres());
                flujo.writeUTF(director.getApellidos());
                flujo.writeUTF(director.getDni());
                flujo.writeUTF(director.getTelefono());
                flujo.writeUTF(director.getCodigo());
                flujo.writeUTF(director.getContraseña());
                flujo.writeFloat(biblioteca.getMultas());
                mensaje = "ok";
            }
        } catch (IOException ex) {
            mensaje = "Excepción: " + ex.getMessage();
        } finally {
            try {
                flujo.close();
            } catch (IOException ex) {
                mensaje = "El flujo ya estaba cerrado: " + ex.getMessage();
            }
        }
        return mensaje;
    }

    public boolean recuperarBiblioteca() {
        String nombreB, nombreD, apellidos, dni, telefono, codigo, contraseña;
        float multas;
        Bibliotecario director;
        File f = new File("Archivos\\Biblioteca.datos");
        if (f.exists()) {
            try {
                crearArchivo();
                nombreB = flujo.readUTF();
                nombreD = flujo.readUTF();
                apellidos = flujo.readUTF();
                dni = flujo.readUTF();
                telefono = flujo.readUTF();
                codigo = flujo.readUTF();
                contraseña = flujo.readUTF();
                multas = flujo.readFloat();
                director = new Bibliotecario(nombreD, apellidos, dni, telefono, codigo, contraseña);
                this.setDirector(director);
                this.setNombre(nombreB);
                this.setMultas(multas);
                File f1 = new File("Archivos\\Bibliotecarios.datos"), f2 = new File("Archivos\\Prestatarios.datos"), 
                        f3 = new File("Archivos\\LibrosBiblioteca.datos"), f4 = new File("Archivos\\LibrosPrestados.datos");
                
                if (f1.exists()) {
                    listaBibliotecarios.RecuperarArchivos();
                }
                if (f2.exists()) {
                    listaPrestatarios.RecuperarArchivos();
                }
                if (f3.exists()) {
                    librosBiblioteca.RecuperarArchivos();
                }
                if (f4.exists()) {
                    listaLibrosPrestados.RecuperarArchivos();
                }

            } catch (IOException ex) {
                System.out.println("Problema de E/S: " + ex.getMessage());
            } finally {
                try {
                    flujo.close();
                } catch (IOException ex) {
                    System.out.println("El flujo ya estaba cerrado: "
                            + ex.getMessage());
                }
            }
            return true;
        }
        return false;
    }

}
