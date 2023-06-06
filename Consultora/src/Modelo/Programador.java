/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


/**
 *
 * @author joaco
 */
public class Programador extends Empleado {
    private int id;
    
    private Cliente cliente = new Cliente();
        
    private int tiempoTrabajadoTotal=0;
    
    private int [][] sueldoMes = new int[12][3];
    
    
    public Programador() {
    }
    
    public Programador(String nombre, String domicilio, int DNI) {
        super(nombre, domicilio, DNI);
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

    public int getTiempoTrabajadoTotal() {
        return tiempoTrabajadoTotal;
    }

    public void setTiempoTrabajadoTotal(int tiempoTrabajadoTotal) {
        this.tiempoTrabajadoTotal = tiempoTrabajadoTotal;
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


    public int getSueldoMes(int mes, int año) {
        return sueldoMes[mes][año];
    }
    public void setSueldoMes(int[][] sueldomes){
        this.sueldoMes = sueldomes;
    }

    public void setSueldoMes(int mes ,int año,int tiempo) {
        this.sueldoMes[mes][año] = (int) (tiempo * this.cliente.getPrecioHora());
    }

    
    public void aumentarHoras (int a){
        this.tiempoTrabajadoTotal+=a;
        
    }
    
}
