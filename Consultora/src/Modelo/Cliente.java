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
    private int id;
    private String nombre = "";
    private String direccion = "";
    private int precioHora = 0;

    public Cliente() {
    }

    public Cliente(String nombre, String direccion, int precioHora) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.precioHora = precioHora;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(int precioHora) {
        this.precioHora = precioHora;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", precioHora=" + precioHora + '}';
    }
    
    
}
