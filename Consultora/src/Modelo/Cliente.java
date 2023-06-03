/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author joaco
 */
public class Cliente {
    private String nombre;
    private String direccion;
    private double precioHora;
    private int duracionTrabajo;

    public Cliente() {
    }

    public Cliente(String nombre, String direccion, double precioHora, int duracionTrabajo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.precioHora = precioHora;
        this.duracionTrabajo = duracionTrabajo;
    }
}
