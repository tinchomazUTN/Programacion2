/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author joaco
 */
public class Analista extends Empleado {
    private String categoria;
    // Agrega otros atributos según sea necesario
    
    public Analista(String nombre, double sueldo, String categoria) {
        super(nombre, sueldo);
        this.categoria = categoria;
    }
    
    // Agrega los getters y setters necesarios
}
