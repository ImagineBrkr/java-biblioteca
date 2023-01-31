/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Jara
 */
public class ListaLibroBiblioteca extends LibroBiblioteca {

    private RandomAccessFile flujo;
    private final int TAMREG = 400;
    private int numRegistros;
    private String nomArchivo = "Archivos\\LibrosBiblioteca.datos";
    private ArrayList<LibroBiblioteca> listaLibro;

    public ListaLibroBiblioteca() {
        listaLibro = new ArrayList<>();
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

    public String escribirLibroBibliotecaArchivo(LibroBiblioteca libro) {
        String mensaje = "";
        try {
            crearArchivo();
            flujo.close();
            mensaje = setLibroBiblioteca(numRegistros, libro);
            if (mensaje.compareTo("ok") == 0) {
                numRegistros++;
            }
        } catch (IOException ex) {
            mensaje = "Excepción: " + ex.getMessage();
        } finally {
            return mensaje;
        }
    }

    public String setLibroBiblioteca(int pos, LibroBiblioteca libro) {
        String mensaje = "";
        Documento doc = libro.getDocumento();
        String tipo = doc.getTipo();
        try {
            if (libro.getTamañoBytes() + 2 > TAMREG) {
                mensaje = "Tamaño de registro insuficiente";
            } else {
                crearArchivo();
                flujo.seek(pos * TAMREG);
                flujo.writeUTF(tipo);
                flujo.writeUTF(doc.getTitulo());
                flujo.writeUTF(doc.getAutor());
                flujo.writeUTF(doc.getAño());
                flujo.writeUTF(libro.getCodigo());
                flujo.writeInt(libro.getCantidad());

                if (tipo.equals("Libro")) {
                    flujo.writeUTF(((Libro) doc).getGenero());
                    flujo.writeUTF(((Libro) doc).getEditorial());
                }

                if (tipo.equals("Revista")) {
                    flujo.writeUTF(((Revista) doc).getEditorial());
                }

                if (tipo.equals("Académico")) {
                    flujo.writeUTF(((Academico) doc).getGenero());
                    flujo.writeUTF(((Academico) doc).getUniversidad());
                }

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

    public LibroBiblioteca getLibroBiblioteca(int pos) {
        String codigo, titulo, autor, año, tipo, genero, editorial, universidad;
        int cantidad;
        LibroBiblioteca libro = new LibroBiblioteca();
        try {
            crearArchivo();
            flujo.seek(pos * TAMREG);
            tipo = flujo.readUTF();
            titulo = flujo.readUTF();
            autor = flujo.readUTF();
            año = flujo.readUTF();
            codigo = flujo.readUTF();
            cantidad = flujo.readInt();
            
            if (tipo.equals("Libro")) {
                    genero = flujo.readUTF();
                    editorial = flujo.readUTF();
                    libro = new LibroBiblioteca(codigo, new Libro(autor, titulo, año, genero, editorial), cantidad);
                }

            else if (tipo.equals("Revista")) {
                    editorial = flujo.readUTF();
                    libro = new LibroBiblioteca(codigo, new Revista(autor, titulo, año, editorial), cantidad);
                }

            else if (tipo.equals("Académico")) {
                    genero = flujo.readUTF();
                    universidad = flujo.readUTF();
                    libro = new LibroBiblioteca(codigo, new Academico(autor, titulo, año, universidad, genero), cantidad);
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
        return libro;
    }

    public List<LibroBiblioteca> getContenido() {
        List<LibroBiblioteca> lista = new ArrayList<>();
        try {
            crearArchivo();
            for (int i = 0; i < numRegistros; i++) {
                lista.add(getLibroBiblioteca(i));
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
        List<LibroBiblioteca> lista = getContenido();
        for (int i = 0; i < lista.size(); i++){
            listaLibro.add(lista.get(i));
        }        
    }

    public int getNumRegistros() {
        return numRegistros;
    }

    public String AgregarLibro(String codigo, Documento documento, int cantidad) {
        listaLibro.add(new LibroBiblioteca(codigo, documento, cantidad));
        return escribirLibroBibliotecaArchivo(new LibroBiblioteca(codigo, documento, cantidad));
    }

    public String AgregarLibro(LibroBiblioteca libro) {
        listaLibro.add(libro);
        return escribirLibroBibliotecaArchivo(libro);
    }

    public LibroBiblioteca getLibro(int pos) {
        return listaLibro.get(pos);
    }

    public int getTamaño() {
        return listaLibro.size();
    }

    public ArrayList<LibroBiblioteca> getLista() {
        return listaLibro;
    }

    @Override
    public String toString() {
        String mostrarLista = "";
        for (int k = 0; k <= listaLibro.size() - 1; k++) {
            mostrarLista += listaLibro.get(k) + "\n\n";
        }
        return mostrarLista;
    }

    public boolean CodigoEnUso(String codigo) {
        return buscarCodigo(codigo) == -1;
    }

    public int buscarCodigo(String codigo) {
        LibroBiblioteca l = new LibroBiblioteca();
        l.setCodigo(codigo);
        return listaLibro.indexOf(l);
    }

    public void PrestarLibro(int pos) {
        LibroBiblioteca libro = getLibro(pos);
        libro.PrestarLibro();
        setLibroBiblioteca(pos, libro);
        listaLibro.remove(pos);
        listaLibro.add(pos, libro);
    }

    public void DevolverLibro(int pos) {
        LibroBiblioteca libro = getLibro(pos);
        libro.DevolverLibro();
        setLibroBiblioteca(pos, libro);
        listaLibro.remove(pos);
        listaLibro.add(pos, libro);
    }
}
