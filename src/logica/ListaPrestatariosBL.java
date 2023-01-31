/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.*;
import entidades.*;
import datos.*;
import java.io.*;

/**
 *
 * @author Salvattore
 */
public class ListaPrestatariosBL {

    private ListaPrestatarios listaPrestatarios;

    public ListaPrestatariosBL() {
        listaPrestatarios = new ListaPrestatarios();
    }

    public boolean ListarPrestatarios(String nombres, String apellidos, String dni, String telefono, String codigoCarnet, String direccion) {
        if (!"".equals(nombres.trim()) && !"".equals(apellidos.trim()) && !"".equals(dni.trim()) && !"".equals(codigoCarnet.trim())) {
            for (int i = 0; i < getTamaño(); i++) {
                if (getPrestatario(i).getCodigoCarnet().equals(codigoCarnet)) {
                    return false;
                }
            }
            listaPrestatarios.listarPrestatario(nombres, apellidos, dni, telefono, codigoCarnet, direccion);
        } else {
            return false;
        }
        return true;
    }

    public boolean listarPrestatario(Prestatario prestatario) {
        if (!"".equals(prestatario.getNombres().trim()) && !"".equals(prestatario.getApellidos().trim())
                && !"".equals(prestatario.getDni().trim()) && !"".equals(prestatario.getCodigoCarnet().trim())) {
            for (int i = 0; i < getTamaño(); i++) {
                if (getPrestatario(i).getCodigoCarnet().equals(prestatario.getCodigoCarnet())) {
                    return false;
                }
            }
            listaPrestatarios.listarPrestatario(prestatario);
            return true;
        } else {
            return false;
        }
    }

    public Prestatario getPrestatario(int pos) {
        if (pos >= 0 && pos < getTamaño()) {
            return listaPrestatarios.getPrestatario(pos);
        }
        return null;
    }

    public int getTamaño() {
        return listaPrestatarios.getTamaño();
    }

    public ArrayList<Prestatario> getLista() {
        return listaPrestatarios.getLista();
    }

    @Override
    public String toString() {
        return listaPrestatarios.toString();
    }

    public boolean CodigoEnUso(String codigo) {
        if (getTamaño() > 0) {
            return buscarCodigo(codigo) != -1;
        }
        return false;
    }

    public int buscarCodigo(String codigo) {
        return listaPrestatarios.buscarCodigo(codigo);
    }

    public boolean PrestarLibro(int pos, boolean v) {
        if (pos != -1) {
            if (v) {
                if (getPrestatario(pos).getPrestados() < 2) {
                    listaPrestatarios.PrestarLibro(pos);
                    return true;
                }
            } else {
                listaPrestatarios.DevolverLibro(pos);
                return true;
            }
        }
        return false;
    }
    
    public void RecuperarArchivos() {
        File f1 = new File("Archivos\\Prestatarios.datos"); 
            if (f1.exists()) {
                listaPrestatarios.recuperarArchivo();
            }        
    }
}
