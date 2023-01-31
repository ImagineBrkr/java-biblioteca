/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Salvattore
 */
public class Fecha {

    private int dia;
    private int mes;
    private int año;

    public Fecha() {
        dia = 1;
        mes = 1;
        año = 1111;
    }

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public Fecha getFecha() {
        return new Fecha(this.dia, this.mes, this.año);
    }

    public int DiasPorMes(int mes, int año) {
        if (mes <= 12 && mes >= 1) {
            switch (mes) {
                case 1:
                    return 31;
                case 2:
                    if (año % 4 == 0 && (año % 100 != 0 || año % 400 == 0)) {
                        return 29;
                    }
                    return 28;
                case 3:
                    return 31;
                case 4:
                    return 30;
                case 5:
                    return 31;
                case 6:
                    return 30;
                case 7:
                    return 31;
                case 8:
                    return 31;
                case 9:
                    return 30;
                case 10:
                    return 31;
                case 11:
                    return 30;
                case 12:
                    return 31;
            }
        }
        return -1;
    }

    public boolean AumentarDias(int dias) {
        int nuevoDia;
        if (dias >= 0) {
            nuevoDia = getDia() + dias;
            while (nuevoDia > DiasPorMes(mes, año)) {
                if (nuevoDia > DiasPorMes(mes, año)) {
                    nuevoDia -= DiasPorMes(mes, año);
                    mes += 1;
                    if (mes > 12) {
                        año += 1;
                        mes -= 12;
                    }
                }
            }
            dia = nuevoDia;
            return true;
        }
        return false;
    }

    public int getValor() {
        return getAño() * 365 + getMes() * 30 + getDia();
    }

    @Override
    public String toString() {
        String fecha = (getDia() < 10 ? "0" + Integer.toString(getDia()) : Integer.toString(getDia())) + "/"
                + (getMes() < 10 ? "0" + Integer.toString(getMes()) : Integer.toString(getMes())) + "/"
                + Integer.toString(getAño());
        return fecha;
    }
}
