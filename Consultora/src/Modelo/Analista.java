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

    private int id;
    private String categoria ="Junior";

    private int[][] sueldoMes = new int[12][3];

    public Analista() {
    }

    public Analista(String categoria, String nombre, String domicilio, int DNI) {
        super(nombre, domicilio, DNI);
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public void setDocumento(int documento) {
        super.setDNI(documento);
    }

    public void setDomicilio(String domicilio) {
        super.setDomicilio(domicilio);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getSueldoMes(int mes, int año) {
        return sueldoMes[mes][año];
    }

    public void setSueldoMes(int[][] sueldoMes){
        this.sueldoMes = sueldoMes;
    }
    
    public void setSueldoMes(int mes, int año) {
        if (this.categoria.equals("Junior")) {
            this.sueldoMes[mes][año] = 500;
        } else if (this.categoria.equals("Semi Senior")) {
            this.sueldoMes[mes][año] = 1000;
        } else if (this.categoria.equals("Senior")) {
            this.sueldoMes[mes][año] = 1500;
        }

        System.out.println("sueldo: " + this.sueldoMes[mes][año]);
    }
    
    public int categoriaRemunerada(String categoria){
        if (categoria.equals("Junior")) {
            return 500;
        } else if (categoria.equals("Semi Senior")) {
            return 1000;
        } else if (categoria.equals("Senior")) {
            return 1500;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Analista{" + "categoria=" + categoria + super.toString() + "}";
    }

}
