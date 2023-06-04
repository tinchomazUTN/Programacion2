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

    private int [] sueldoMes= new int[12];
    private ArrayList<int[]> sueldoAnual= new ArrayList();

    
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

    public int[] getSueldoMes() {
        return sueldoMes;
    }

    public void setSueldoMes(int[] sueldoMes) {
        this.sueldoMes = sueldoMes;
    }

    public ArrayList<int[]> getSueldoAnual() {
        return sueldoAnual;
    }

    public void setSueldoAnual(ArrayList<int[]> sueldoAnual) {
        this.sueldoAnual = sueldoAnual;
    }

    @Override
    public String toString() {
        return "Programador{"+ super.toString() + "cliente=" + cliente +'}';
    }
    
    
    
}
