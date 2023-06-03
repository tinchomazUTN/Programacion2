/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author joaco
 */
public abstract class Empleado{
    private String nombre;
    private String domicilio;
    private  int DNI;
    private double sueldo;
    // Agrega otros atributos según sea necesario
    

    
    // Agrega los getters y setters necesarios

    public Empleado() {
    }

    public Empleado(String nombre, String domicilio, int DNI, double sueldo) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.DNI = DNI;
        this.sueldo = sueldo;
    }
}
