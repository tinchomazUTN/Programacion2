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
public class Programador extends Empleado {
    private Cliente cliente;
    private int tiempoTrabajado=0;

    private int [] sueldoMes= new int[12];
    private ArrayList<int[]> sueldoAnual= new ArrayList();

    public Programador() {
    }
    
    public Programador(String nombre, String domicilio, int DNI) {
        super(nombre, domicilio, DNI);
    }

}
