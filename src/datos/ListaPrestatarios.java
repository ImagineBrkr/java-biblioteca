/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.*;
import entidades.*;
import java.io.*;

/**
 *
 * @author Jara
 */
public class ListaPrestatarios {

    private RandomAccessFile flujo;
    private final int TAMREG = 280;
    private int numRegistros;
    private String nomArchivo = "Archivos\\Prestatarios.datos";
    private ArrayList<Prestatario> listaPrestatarios;

    public String crearArchivo() {
        try {
            flujo = new RandomAccessFile(nomArchivo, "rw");
            numRegistros = (int) Math.ceil((double) flujo.length() / (double) TAMREG);
        } catch (IOException ex) {
            return "Problema al crear el flujo: " + ex.getMessage();
        }
        return null;
    }
    

    public String escribirPrestatarioArchivo(Prestatario prestatario) {
        String mensaje = "";
        try {
            crearArchivo();
            flujo.close();
            mensaje = setPrestatario(numRegistros, prestatario);
            if (mensaje.compareTo("ok") == 0) {
                numRegistros++;
            }
        } catch (IOException ex) {
            mensaje = "Excepción: " + ex.getMessage();
        } finally {
            return mensaje;
        }
    }

    public String setPrestatario(int pos, Prestatario prestatario) {
        String mensaje = "";
        try {
            if (prestatario.getTamañoBytes() + 2 > TAMREG) {
                mensaje = "Tamaño de registro insuficiente";
            } else {
                crearArchivo();
                flujo.seek(pos * TAMREG);
                flujo.writeUTF(prestatario.getNombres());
                flujo.writeUTF(prestatario.getApellidos());
                flujo.writeUTF(prestatario.getDni());
                flujo.writeUTF(prestatario.getTelefono());
                flujo.writeUTF(prestatario.getDireccion());
                flujo.writeUTF(prestatario.getCodigoCarnet());
                flujo.writeInt(prestatario.getPrestados());
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

    public Prestatario getPrestatarioArchivo(int pos) {
        String nombres, apellidos, dni, telefono, direccion, codigo;
        int prestados;
        Prestatario prestatario = new Prestatario();
        try {
            crearArchivo();
            flujo.seek(pos * TAMREG);
            nombres = flujo.readUTF();
            apellidos = flujo.readUTF();
            dni = flujo.readUTF();
            telefono = flujo.readUTF();
            direccion = flujo.readUTF();
            codigo = flujo.readUTF();
            prestados = flujo.readInt();
            prestatario = new Prestatario(nombres, apellidos, dni, telefono, codigo, direccion);
            prestatario.setPrestados(prestados);
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
        return prestatario;
    }

    public List<Prestatario> getContenido() {
        List<Prestatario> lista = new ArrayList<>();
        try {
            crearArchivo();
            for (int i = 0; i < numRegistros; i++) {
                lista.add(getPrestatarioArchivo(i));
            }
        } finally {
            try {
                flujo.close();
            } catch (IOException ex) {
                System.out.println("El flujo ya estaba cerrado: " + ex.getMessage());
            }
        }
        return lista;
    }

    public int getNumRegistros() {
        return numRegistros;
    } 
    
    public ListaPrestatarios() {
        listaPrestatarios = new ArrayList<>();
    }

    public String listarPrestatario(String nombres, String apellidos, String dni, String telefono, String codigoCarnet, String direccion) {
        listaPrestatarios.add(new Prestatario(nombres, apellidos, dni, telefono, codigoCarnet, direccion));
        return escribirPrestatarioArchivo(new Prestatario(nombres, apellidos, dni, telefono, direccion, codigoCarnet));
    }

    public String listarPrestatario(Prestatario prestatario) {
        listaPrestatarios.add(prestatario);
        return escribirPrestatarioArchivo(prestatario);
    }

    public Prestatario getPrestatario(int pos) {
        return listaPrestatarios.get(pos);
    }

    public int getTamaño() {
        return listaPrestatarios.size();
    }

    public ArrayList<Prestatario> getLista() {
        return listaPrestatarios;
    }

    @Override
    public String toString() {
        String mostrarLista = "";
        for (int k = 0; k <= listaPrestatarios.size() - 1; k++) {
            mostrarLista += listaPrestatarios.get(k) + "\n\n";
        }
        return mostrarLista;
    }

    public boolean CodigoEnUso(String codigo) {
        return buscarCodigo(codigo) != -1;
    }
    
    public void recuperarArchivo() {
        List<Prestatario> lista = getContenido();
        for (int i = 0; i < lista.size(); i++){
            listaPrestatarios.add(lista.get(i));
        }        
    }

    public int buscarCodigo(String codigo) {
        Prestatario l = new Prestatario();
        l.setCodigoCarnet(codigo);
        return listaPrestatarios.indexOf(l);
    }

    public void PrestarLibro(int pos) {
        Prestatario prestatario = getPrestatario(pos);
        prestatario.PrestarLibro();
        setPrestatario(pos, prestatario);
        listaPrestatarios.remove(pos);
        listaPrestatarios.add(pos, prestatario);
    }

    public void DevolverLibro(int pos) {
        Prestatario prestatario = getPrestatario(pos);
        prestatario.DevolverLibro();
        setPrestatario(pos, prestatario);
        listaPrestatarios.remove(pos);
        listaPrestatarios.add(pos, prestatario);
    }
}
