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
    private Cliente cliente = new Cliente();
    private int tiempoTrabajado=0;
    
    private int [][] sueldoMes= new int[12][5];
    

    
    public Programador() {
    }
    
    public Programador(String nombre, String domicilio, int DNI) {
        super(nombre, domicilio, DNI);
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
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getTiempoTrabajado() {
        return tiempoTrabajado;
    }

    public void setTiempoTrabajado(int tiempoTrabajado) {
        this.tiempoTrabajado = tiempoTrabajado;
    }

    public int getSueldoMes(int mes, int año) {
        return sueldoMes[mes][año];
    }

    public void setSueldoMes(int mes ,int año) {
        this.sueldoMes[mes][año] = (int) (this.tiempoTrabajado * this.cliente.getPrecioHora());
        System.out.println("sueldo: "+this.sueldoMes[mes][año]);
    }

    @Override
    public String toString() {
        return "Programador{"+ super.toString() + " tiempo trabajado:"+tiempoTrabajado+"cliente=" + cliente +'}';
    }
    
    public void aumentarHoras (int a){
        this.tiempoTrabajado+=a;
    
    }
    
}
