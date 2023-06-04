/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author joaco
 */
public class Analista extends Empleado {
    private String categoria;

    private int [] sueldoMes= new int[12];
    private int [] sueldoAño= new int[5];

    public Analista() {
    }
    public Analista(String categoria, String nombre, String domicilio, int DNI) {
        super(nombre, domicilio, DNI);
        this.categoria = categoria;
    }
     public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
    
    public void setDocumento(int documento) {
        super.setDNI(documento);
    }
    
    public void setDomicilio(String domicilio) {
        super.setDomicilio(domicilio);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int[] getSueldoMes() {
        return sueldoMes;
    }

    public void setSueldoMes(int[] sueldoMes) {
        this.sueldoMes = sueldoMes;
    }

    public int[] getSueldoAnual() {
        return sueldoAño;
    }

    public void setSueldoAnual(int[] sueldoAnual) {
        this.sueldoAño = sueldoAnual;
    }

    @Override
    public String toString() {
        return "Analista{" + "categoria=" + categoria + super.toString() + "}";
    }
    
    
}
