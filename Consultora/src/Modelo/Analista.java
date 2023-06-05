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
    private String categoria;

    private int [][] sueldoMes= new int[12][3];

    public Analista() {
    }
    public Analista(String categoria, String nombre, String domicilio, int DNI) {
        super(nombre, domicilio, DNI);
        this.categoria = categoria;
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

    public void setSueldoMes(int mes ,int año) {
        if (this.categoria.equals("Junior")) {
            this.sueldoMes[mes][año]=500;
        }else if(this.categoria.equals("Semi Senior")){
            this.sueldoMes[mes][año]=1000;
        }else if(this.categoria.equals("Senior")){
            this.sueldoMes[mes][año]=1500;}
       
        System.out.println("sueldo: "+this.sueldoMes[mes][año]);
    }

    @Override
    public String toString() {
        return "Analista{" + "categoria=" + categoria + super.toString() + "}";
    }
    
    
}
