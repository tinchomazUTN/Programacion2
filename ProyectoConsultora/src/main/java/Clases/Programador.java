/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author joaco
 */
public class Programador extends Empleado {
    private double precioHora;
    // Agrega otros atributos según sea necesario
    
    public Programador(String nombre, double sueldo, double precioHora) {
        super(nombre, sueldo);
        this.precioHora = precioHora;
    }
    
    // Agrega los getters y setters necesarios
}
