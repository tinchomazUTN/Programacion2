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
    private  Integer DNI;
    
    public Empleado() {
    }

    public Empleado(String nombre, String domicilio, int DNI) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", domicilio=" + domicilio + ", DNI=" + DNI + '}';
    }
    
}
