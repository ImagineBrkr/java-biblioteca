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
public class ListaLibrosPrestados extends LibroPrestado {

    private ArrayList<LibroPrestado> listaLibrosPrestados;
    private RandomAccessFile flujo;
    private final int TAMREG = 100;
    private int numRegistros;
    private String nomArchivo = "Archivos\\LibrosPrestados.datos";

    public String crearArchivo() {
        try {
            flujo = new RandomAccessFile(nomArchivo, "rw");
            numRegistros = (int) Math.ceil((double) flujo.length() / (double) TAMREG);
        } catch (IOException ex) {
            return "Problema al crear el flujo: " + ex.getMessage();
        }
        return null;
    }

    public String escribirLibroPrestadoArchivo(LibroPrestado libro) {
        String mensaje = "";
        try {
            crearArchivo();
            flujo.close();
            mensaje = setLibroPrestadoArchivo(numRegistros, libro);
            if (mensaje.compareTo("ok") == 0) {
                numRegistros++;
            }
        } catch (IOException ex) {
            mensaje = "Excepción: " + ex.getMessage();
        } finally {
            return mensaje;
        }
    }

    public String setLibroPrestadoArchivo(int pos, LibroPrestado libro) {
        String mensaje = "";
        try {
            if (libro.getTamañoBytes() + 2 > TAMREG) {
                mensaje = "Tamaño de registro insuficiente";
            } else {
                crearArchivo();
                flujo.seek(pos * TAMREG);
                flujo.writeBoolean(libro.getDevuelto());
                flujo.writeUTF(libro.getCodigoEmpleado());
                flujo.writeUTF(libro.getCodigoCarnet());
                flujo.writeUTF(libro.getCodigoLibro());
                flujo.writeInt(libro.getFechaPrestamo().getDia());
                flujo.writeInt(libro.getFechaPrestamo().getMes());
                flujo.writeInt(libro.getFechaPrestamo().getAño());
                flujo.writeInt(libro.getFechaPlazo().getDia());
                flujo.writeInt(libro.getFechaPlazo().getMes());
                flujo.writeInt(libro.getFechaPlazo().getAño());
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

    public LibroPrestado getLibroPrestadoArchivo(int pos) {
        String codigoEmpleado, codigoCarnet, codigoLibro;
        int dia1, mes1, año1, dia2, mes2, año2;
        boolean devuelto;
        LibroPrestado libro = new LibroPrestado();
        try {
            crearArchivo();
            flujo.seek(pos * TAMREG);
            devuelto = flujo.readBoolean();
            codigoEmpleado = flujo.readUTF();
            codigoCarnet = flujo.readUTF();
            codigoLibro = flujo.readUTF();
            dia1 = flujo.readInt();
            mes1 = flujo.readInt();
            año1 = flujo.readInt();
            dia2 = flujo.readInt();
            mes2 = flujo.readInt();
            año2 = flujo.readInt();
            libro = new LibroPrestado(codigoEmpleado, codigoCarnet, codigoLibro, new Fecha(dia1, mes1, año1));
            libro.setFechaPlazo(new Fecha(dia2, mes2, año2));
            libro.setDevuelto(devuelto);
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
        return libro;
    }

    public List<LibroPrestado> getContenido() {
        List<LibroPrestado> lista = new ArrayList<>();
        try {
            crearArchivo();
            for (int i = 0; i < numRegistros; i++) {
                lista.add(getLibroPrestadoArchivo(i));
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

    public void recuperarArchivo() {
        List<LibroPrestado> lista = getContenido();
        LibroPrestado libro;
        for (int i = 0; i < lista.size(); i++) {
            libro = lista.get(i);
            if (!libro.getDevuelto()) {
                listaLibrosPrestados.add(libro);
            }
        }
    }

    public int getNumRegistros() {
        return numRegistros;
    }

    public ListaLibrosPrestados() {
        listaLibrosPrestados = new ArrayList<>();
    }

    public String AgregarLibro(String codigoEmpleado, String codigoCarnet, String codigoLibro, Fecha fechaPrestamo) {
        listaLibrosPrestados.add(new LibroPrestado(codigoEmpleado, codigoCarnet, codigoLibro, fechaPrestamo));
        return escribirLibroPrestadoArchivo(new LibroPrestado(codigoEmpleado, codigoCarnet, codigoLibro, fechaPrestamo));
    }

    public String AgregarLibro(LibroPrestado libro) {
        listaLibrosPrestados.add(libro);
        return escribirLibroPrestadoArchivo(libro);
    }

    public LibroPrestado getLibro(int pos) {
        return listaLibrosPrestados.get(pos);
    }

    public int getTamaño() {
        return listaLibrosPrestados.size();
    }

    public ArrayList<LibroPrestado> getLista() {
        return listaLibrosPrestados;
    }

    @Override
    public String toString() {
        String mostrarLista = "";
        for (int k = 0; k <= listaLibrosPrestados.size() - 1; k++) {
            mostrarLista += listaLibrosPrestados.get(k) + "\n\n";
        }
        return mostrarLista;
    }

    public int buscarCodigo1(String codigoPrestatario) {
        return listaLibrosPrestados.indexOf(new LibroPrestado("", codigoPrestatario, "", new Fecha()));
    }

    public int buscarCodigo2(String codigoPrestatario) {
        return listaLibrosPrestados.lastIndexOf(new LibroPrestado("", codigoPrestatario, "", new Fecha()));
    }

    public void EliminarLibro(int pos) {
        LibroPrestado libro = getLibro(pos);
        libro.setDevuelto(true);
        setLibroPrestadoArchivo(pos, libro);
        listaLibrosPrestados.remove(pos);
    }

    public void Aplazar(int pos) {
        LibroPrestado libro = getLibro(pos);
        libro.AumentarPlazo();
        setLibroPrestadoArchivo(pos, libro);
        listaLibrosPrestados.remove(pos);
        listaLibrosPrestados.add(pos, libro);
    }

//    public void EliminarLibroArchivo(int pos) {
//        LibroPrestado libro, aux;
//        libro = getLibroPrestadoArchivo(pos);
//        aux = getLibroPrestadoArchivo(0);
//        setLibroPrestadoArchivo(0, libro);
//        setLibroPrestadoArchivo(pos, aux);
//    }
}
