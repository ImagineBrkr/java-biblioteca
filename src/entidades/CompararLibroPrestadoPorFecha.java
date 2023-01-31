/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Comparator;

/**
 *
 * @author Salvattore
 */
public class CompararLibroPrestadoPorFecha implements Comparator<LibroPrestado> {

    @Override
    public int compare(LibroPrestado t, LibroPrestado t1) {
        return t.getFechaPrestamo().getValor() - t.getFechaPrestamo().getValor();
    }

}
