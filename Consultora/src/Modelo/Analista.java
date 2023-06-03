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
    private ArrayList<int[]> sueldoAnual= new ArrayList();

    public Analista() {
    }
    public Analista(String categoria, String nombre, String domicilio, int DNI) {
        super(nombre, domicilio, DNI);
        this.categoria = categoria;
    }

}
