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
    
    private int tiempoTrabajado;
    private int dineroTotalGanado;
    private int [] sueldoMes= new int[12];
    private ArrayList<int[]> sueldoAnual= new ArrayList();
    
    
    public Programador(int tiempoTrabajado, String nombre, String domicilio, int DNI, double sueldo) {
        super(nombre, domicilio, DNI, sueldo);
        this.tiempoTrabajado = tiempoTrabajado;
    }


}
