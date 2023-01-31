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
public class ListaLibroBibliotecaBL {

    private ListaLibroBiblioteca listaLibro;

    public ListaLibroBibliotecaBL() {
        listaLibro = new ListaLibroBiblioteca();
    }

    public boolean AgregarLibro(String codigo, Documento documento, int cantidad) {
        if (!"".equals(codigo.trim()) && cantidad >= 0 && !"".equals(documento.getTitulo().trim())) {
            for (int i = 0; i < getTamaño(); i++) {
                if (getLibro(i).getCodigo().equals(codigo)) {
                    return false;
                }
            }
            listaLibro.AgregarLibro(codigo, documento, cantidad);
        } else {
            return false;
        }
        return true;
    }

    public boolean AgregarLibro(LibroBiblioteca libro) {
        if (!"".equals(libro.getCodigo().trim()) && libro.getCantidad() >= 0 && !"".equals(libro.getDocumento().getTitulo().trim())) {
            for (int i = 0; i < getTamaño(); i++) {
                if (getLibro(i).getCodigo().equals(libro.getCodigo())) {
                    return false;
                }
            }
            listaLibro.AgregarLibro(libro);
        } else {
            return false;
        }
        return true;
    }

    public LibroBiblioteca getLibro(int pos) {
        if (pos >= 0 && pos < getTamaño()) {
            return listaLibro.getLibro(pos);
        }
        return null;
    }

    public int getTamaño() {
        return listaLibro.getTamaño();
    }

    public ArrayList<LibroBiblioteca> getLista() {
        return listaLibro.getLista();
    }

    @Override
    public String toString() {
        return listaLibro.toString();
    }

    public boolean CodigoEnUso(String codigo) {
        if (getTamaño() > 0) {
            return buscarCodigo(codigo) != -1;
        }
        return false;
    }

    public int buscarCodigo(String codigo) {
        return listaLibro.buscarCodigo(codigo);
    }

    public boolean PrestarLibro(int pos, boolean v) {

        if (pos != -1) {
            if (v) {
                if (getLibro(pos).getCantidad() > 0) {
                    listaLibro.PrestarLibro(pos);
                    return true;
                }
            } else {
                listaLibro.DevolverLibro(pos);
                return true;
            }
        }
        return false;
    }
    
    public int getNumRegistros() {
        return listaLibro.getNumRegistros();
    }
    
    public void RecuperarArchivos() {
        File f1 = new File("Archivos\\LibrosBiblioteca.datos"); 
            if (f1.exists()) {
                listaLibro.recuperarArchivo();
            }        
    }

}
