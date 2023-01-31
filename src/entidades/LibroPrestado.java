/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.*;
import java.text.*;

/**
 *
 * @author Jara
 */
public class LibroPrestado implements Comparable<LibroPrestado> {

    private boolean devuelto = false;
    private String codigoEmpleado;
    private String codigoCarnet;
    private String codigoLibro;
    private final int plazo = 7;
    private Fecha fechaPrestamo;
    private Fecha fechaPlazo;

    public LibroPrestado() {
        codigoEmpleado = "E0000";
        codigoCarnet = "P0000";
        codigoLibro = "00000";
        fechaPrestamo = new Fecha();
    }

    public LibroPrestado(String codigoEmpleado, String codigoCarnet, String codigoLibro, Fecha fechaPrestamo) {
        this.codigoEmpleado = codigoEmpleado;
        this.codigoCarnet = codigoCarnet;
        this.codigoLibro = codigoLibro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaPlazo = fechaPrestamo.getFecha();
        this.fechaPlazo.AumentarDias(getPlazo());
        this.devuelto = false;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getCodigoCarnet() {
        return codigoCarnet;
    }

    public void setCodigoCarnet(String codigoCarnet) {
        this.codigoCarnet = codigoCarnet;
    }

    public String getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(String codigoLibro) {
        this.codigoLibro = codigoLibro;
    }
    
    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }
    
    public boolean getDevuelto() {
        return devuelto;
    }

    public int getPlazo() {
        return plazo;
    }

    public Fecha getFechaPrestamo() {
        return fechaPrestamo.getFecha();
    }

    public void setFechaPrestamo(Fecha fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
        fechaPlazo = fechaPrestamo.getFecha();
        fechaPlazo.AumentarDias(getPlazo());
    }
    
    public void setFechaPlazo(Fecha fechaPlazo) {
        this.fechaPlazo = fechaPlazo;
    }

    public Fecha getFechaPlazo() {
        return fechaPlazo.getFecha();
    }

    public void AumentarPlazo() {
        this.fechaPlazo.AumentarDias(getPlazo());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigoCarnet);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LibroPrestado other = (LibroPrestado) obj;
        if (!Objects.equals(this.codigoCarnet, other.codigoCarnet)) {
            return false;
        }
        return true;
    }

    public boolean getDentroDelPlazo() {

        GregorianCalendar hoy = new GregorianCalendar();
        Fecha fechaMaxPlazo = getFechaPlazo();
        Fecha fechaHoy = new Fecha(hoy.get(Calendar.DAY_OF_MONTH), hoy.get(Calendar.MONTH) + 1, hoy.get(Calendar.YEAR));

        if (fechaHoy.getAño() <= fechaMaxPlazo.getAño()) {
            if (fechaHoy.getMes() <= fechaMaxPlazo.getMes()) {
                if (fechaHoy.getDia() <= fechaMaxPlazo.getDia()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getTiempoFueraPlazo() throws ParseException {
        GregorianCalendar hoy = new GregorianCalendar();
        Fecha fechaMaxPlazo = getFechaPlazo();
        Fecha fechaHoy = new Fecha(hoy.get(Calendar.DAY_OF_MONTH), hoy.get(Calendar.MONTH) + 1, hoy.get(Calendar.YEAR));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date fechaInicial = dateFormat.parse(fechaMaxPlazo.toString());
        Date fechaFinal = dateFormat.parse(fechaHoy.toString());

        return (int) ((fechaFinal.getTime() - fechaInicial.getTime()) / 86400000) / plazo;
    }

    @Override
    public String toString() {
        return "El código del empleado: " + getCodigoEmpleado() + "\n"
                + "El código del prestatario: " + getCodigoCarnet() + "\n"
                + "El código del libro a emprestar: " + getCodigoLibro() + "\n"
                + "Fecha de préstamo: " + getFechaPrestamo().toString() + "\n"
                + "Fecha límite de entrega del libro: " + getFechaPlazo().toString()
                + "\n" + (getDentroDelPlazo() ? "Dentro del plazo." : "Fuera del plazo");
    }

    @Override
    public int compareTo(LibroPrestado t) {
        return this.getCodigoCarnet().compareToIgnoreCase(t.getCodigoCarnet());
    }
    
    public int getTamañoBytes() {
        return (getCodigoEmpleado() + getCodigoCarnet() + getCodigoLibro()).length() * 2 + 18;
    }
}
