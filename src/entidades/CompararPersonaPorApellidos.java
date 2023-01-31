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
public class CompararPersonaPorApellidos implements Comparator<Persona> {

    @Override
    public int compare(Persona t, Persona t1) {
        return t.getApellidos().compareToIgnoreCase(t1.getApellidos());
    }

}
