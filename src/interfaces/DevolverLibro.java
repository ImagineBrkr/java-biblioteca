/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Salvattore
 */
public interface DevolverLibro {

    float base = 200f;

    public double multaLibro(int pos);

    public boolean DevolverLibro(String codigoLibro, String codigoPrestatario, int pos);
}
