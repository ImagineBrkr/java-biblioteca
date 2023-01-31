/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.*;
import java.util.*;
import datos.*;
import java.io.File;

/**
 *
 * @author Salvattore
 */
public class ListaLibrosPrestadosBL {

    private ListaLibrosPrestados listaLibrosPrestados;

    public ListaLibrosPrestadosBL() {
        listaLibrosPrestados = new ListaLibrosPrestados();
    }

    public boolean AgregarLibro(String codigoEmpleado, String codigoCarnet, String codigoLibro, Fecha fechaPrestamo) {
        //Máximo dos libros por persona.
        int can = 0;
        if (!"".equals(codigoEmpleado.trim()) && !"".equals(codigoCarnet.trim()) && !"".equals(codigoLibro.trim())) {
            for (int i = 0; i < getTamaño(); i++) {
                if (getLibro(i).getCodigoCarnet().equals(codigoCarnet)) {
                    can += 1;
                    if (can >= 2) {
                        return false;
                    }
                }
            }
            listaLibrosPrestados.AgregarLibro(codigoEmpleado, codigoCarnet, codigoLibro, fechaPrestamo);
        } else {
            return false;
        }
        return true;
    }

    public boolean AgregarLibro(LibroPrestado libro) {
        int can = 0;
        if (!"".equals(libro.getCodigoEmpleado().trim()) && !"".equals(libro.getCodigoCarnet().trim()) && !"".equals(libro.getCodigoLibro().trim())) {
            for (int i = 0; i < getTamaño(); i++) {
                if (getLibro(i).getCodigoCarnet().equals(libro.getCodigoCarnet())) {
                    can += 1;
                    if (can >= 2) {
                        return false;
                    }
                }
            }
            listaLibrosPrestados.AgregarLibro(libro);
        } else {
            return false;
        }
        return true;
    }

    public LibroPrestado getLibro(int pos) {

        return listaLibrosPrestados.getLibro(pos);

    }

    public int getTamaño() {
        return listaLibrosPrestados.getTamaño();
    }

    public ArrayList<LibroPrestado> getLista() {
        return listaLibrosPrestados.getLista();
    }

    @Override
    public String toString() {
        return listaLibrosPrestados.toString();
    }

    public int buscarCodigo1(String codigoPrestatario) {
        return listaLibrosPrestados.buscarCodigo1(codigoPrestatario);
    }

    public int buscarCodigo2(String codigoPrestatario) {
        return listaLibrosPrestados.buscarCodigo2(codigoPrestatario);
    }

    public boolean EliminarLibro(int pos) {
        if (pos >= 0 && pos < getTamaño()) {
            listaLibrosPrestados.EliminarLibro(pos);
            return true;
        }
        return false;
    }

    public boolean Aplazar(int pos) {
        if (pos >= 0 && pos < getTamaño()) {
            listaLibrosPrestados.Aplazar(pos);
            return true;
        }
        return false;
    }

    public void RecuperarArchivos() {
        File f1 = new File("Archivos\\LibrosPrestados.datos");
        if (f1.exists()) {
            listaLibrosPrestados.recuperarArchivo();

        }
    }

    public int getNumRegistros() {
        return listaLibrosPrestados.getNumRegistros();
    }
}
