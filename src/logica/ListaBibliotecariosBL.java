/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.*;
import entidades.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author Salvattore
 */
public class ListaBibliotecariosBL {

    private ListaBibliotecarios listaBibliotecarios;

    public ListaBibliotecariosBL() {
        listaBibliotecarios = new ListaBibliotecarios();
    }

    public String listarBibliotecario(String nombres, String apellidos, String dni, String telefono, String codigo, String contraseña) {
        String mensaje;
        if (!"".equals(nombres.trim()) && !"".equals(apellidos.trim()) && !"".equals(dni.trim()) && !"".equals(codigo.trim()) && !"".equals(contraseña.trim())) {
            mensaje =listaBibliotecarios.listarBibliotecario(nombres, apellidos, dni, telefono, codigo, contraseña);
        } else {
            mensaje = "Datos no válidos";
        }
        return mensaje;
    }

    public boolean listarBibliotecario(Bibliotecario bibliotecario) {
        if (!"".equals(bibliotecario.getNombres().trim()) && !"".equals(bibliotecario.getApellidos().trim())
                && !"".equals(bibliotecario.getDni().trim()) && !"".equals(bibliotecario.getCodigo().trim()) && !"".equals(bibliotecario.getContraseña().trim())) {
            if (CodigoEnUso(bibliotecario.getCodigo())) {
                return false;
            }
            listaBibliotecarios.listarBibliotecario(bibliotecario);
        } else {
            return false;
        }
        return true;
    }

    public Bibliotecario getBibliotecario(int pos) {
        if (pos >= 0 && pos < getTamaño()) {
            return listaBibliotecarios.getBibliotecario(pos);
        }
        return null;
    }

    public int getTamaño() {
        return listaBibliotecarios.getTamaño();
    }

    public ArrayList<Bibliotecario> getLista() {
        return listaBibliotecarios.getLista();
    }

    @Override
    public String toString() {
        return listaBibliotecarios.toString();
    }

    public boolean CodigoEnUso(String codigo) {
        if (getTamaño() > 0) {
            return buscarCodigo(codigo) != -1;
        }
        return false;
    }

    public int buscarCodigo(String codigo) {
        return listaBibliotecarios.buscarCodigo(codigo);
    }

    public int getNumRegistros() {
        return listaBibliotecarios.getNumRegistros();
    }
    
    public void RecuperarArchivos() {
        File f1 = new File("Archivos\\Bibliotecarios.datos"); 
            if (f1.exists()) {
                listaBibliotecarios.recuperarArchivo();
            }        
    }
}
