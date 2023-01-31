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
public class ListaBibliotecarios {
    
    private RandomAccessFile flujo;
    private final int TAMREG = 200;
    private int numRegistros;
    private String nomArchivo = "Archivos\\Bibliotecarios.datos";
    private ArrayList<Bibliotecario> listaBibliotecarios;

    public String crearArchivo() {
        try {
            flujo = new RandomAccessFile(nomArchivo, "rw");
            numRegistros = (int) Math.ceil((double) flujo.length() / (double) TAMREG);
        } catch (IOException ex) {
            return "Problema al crear el flujo: " + ex.getMessage();
        }
        return null;
    }

    public String escribirBibliotecarioArchivo(Bibliotecario bibliotecario) {
        String mensaje = "";
        try {
            crearArchivo();
            flujo.close();
            mensaje = setBibliotecario(numRegistros, bibliotecario);
            if (mensaje.compareTo("ok") == 0) {
                numRegistros++;
            }
        } catch (IOException ex) {
            mensaje = "Excepción: " + ex.getMessage();
        } finally {
            return mensaje;
        }
    }

    public String setBibliotecario(int pos, Bibliotecario bibliotecario) {
        String mensaje = "";
        try {
            if (bibliotecario.getTamañoBytes() + 2 > TAMREG) {
                mensaje = "Tamaño de registro insuficiente";
            } else {
                crearArchivo();
                flujo.seek(pos * TAMREG);
                flujo.writeUTF(bibliotecario.getNombres());
                flujo.writeUTF(bibliotecario.getApellidos());
                flujo.writeUTF(bibliotecario.getDni());
                flujo.writeUTF(bibliotecario.getTelefono());
                flujo.writeUTF(bibliotecario.getCodigo());
                flujo.writeUTF(bibliotecario.getContraseña());
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

    public Bibliotecario getBibliotecarioArchivo(int pos) {
        String nombres, apellidos, dni, telefono, codigo, contraseña;
        Bibliotecario bibliotecario = new Bibliotecario();
        try {
            crearArchivo();
            flujo.seek(pos * TAMREG);
            nombres = flujo.readUTF();
            apellidos = flujo.readUTF();
            dni = flujo.readUTF();
            telefono = flujo.readUTF();
            codigo = flujo.readUTF();
            contraseña = flujo.readUTF();
            bibliotecario = new Bibliotecario(nombres, apellidos, dni, telefono, codigo, contraseña);
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
        return bibliotecario;
    }

    public List<Bibliotecario> getContenido() {
        List<Bibliotecario> lista = new ArrayList<>();
        try {
            crearArchivo();
            for (int i = 0; i < numRegistros; i++) {
                lista.add(getBibliotecarioArchivo(i));
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

    public ListaBibliotecarios() {
        listaBibliotecarios = new ArrayList<>();
    }

    public String listarBibliotecario(String nombres, String apellidos, String dni, String telefono, String codigo, String contraseña) {
        listaBibliotecarios.add(new Bibliotecario(nombres, apellidos, dni, telefono, codigo, contraseña));
        return escribirBibliotecarioArchivo(new Bibliotecario(nombres, apellidos, dni, telefono, codigo, contraseña));
    }

    public String listarBibliotecario(Bibliotecario bibliotecario) {
        listaBibliotecarios.add(bibliotecario);
        return escribirBibliotecarioArchivo(bibliotecario);
    }

    public Bibliotecario getBibliotecario(int pos) {
        return listaBibliotecarios.get(pos);
    }

    public int getTamaño() {
        return listaBibliotecarios.size();
    }

    public ArrayList<Bibliotecario> getLista() {
        return listaBibliotecarios;
    }
    
    public void recuperarArchivo() {
        List<Bibliotecario> lista = getContenido();
        for (int i = 0; i < lista.size(); i++){
            listaBibliotecarios.add(lista.get(i));
        }        
    }

    @Override
    public String toString() {
        String mostrarLista = "";
        for (int k = 0; k <= listaBibliotecarios.size() - 1; k++) {
            mostrarLista += listaBibliotecarios.get(k).toString() + "\n";
        }
        return mostrarLista;
    }

    public boolean CodigoEnUso(String codigo) {
        return buscarCodigo(codigo) != -1;
    }

    public int buscarCodigo(String codigo) {
        Bibliotecario b = new Bibliotecario();
        b.setCodigo(codigo);
        return listaBibliotecarios.indexOf(b);
    }
}
