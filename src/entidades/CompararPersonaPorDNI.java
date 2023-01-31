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
public class CompararPersonaPorDNI implements Comparator<Persona> {

    @Override
    public int compare(Persona t, Persona t1) {
        return t.getDni().compareToIgnoreCase(t1.getDni());
    }

}
