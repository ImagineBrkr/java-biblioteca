/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.*;

/**
 *
 * @author Salvattore
 */
public class CompararLibroPorCantidad implements Comparator<LibroBiblioteca> {

    @Override
    public int compare(LibroBiblioteca t, LibroBiblioteca t1) {
        return t.getCantidad() - t1.getCantidad();
    }

}
