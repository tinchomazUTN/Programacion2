/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author joaco
 */
public class Programador extends Empleado {
    private int tiempoTrabajado;

    public Programador(int tiempoTrabajado, String nombre, String domicilio, int DNI, double sueldo) {
        super(nombre, domicilio, DNI, sueldo);
        this.tiempoTrabajado = tiempoTrabajado;
    }


}
