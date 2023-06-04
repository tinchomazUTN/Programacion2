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
public class Consultora {

    public ArrayList<Programador> programadores;
    public ArrayList<Analista> analistas;
    public ArrayList<Cliente> clientes;

    public Consultora() {
        programadores = new ArrayList<>();
        analistas = new ArrayList<>();
        clientes = new ArrayList<>();
    }
    
    public int recorrerSueldosProg(int mes, int año){
        int mayorSueldoProg=0;
        int posicionProg=0;
        for (int i = 0; i < programadores.size(); i++) {
            if (programadores.get(i).getSueldoMes(mes, año)>mayorSueldoProg){
                mayorSueldoProg=programadores.get(i).getSueldoMes(mes, año);
                posicionProg=i;
            }
            
        }
        
        return posicionProg;
        }
    
    public int recorrerSueldosAnal(int mes, int año){
        int mayorSueldoAnalista=0;
        int posicionAnal=0;
        for (int i = 0; i < analistas.size(); i++) {
            if (analistas.get(i).getSueldoMes(mes, año)>mayorSueldoAnalista){
                mayorSueldoAnalista=analistas.get(i).getSueldoMes(mes, año);
                posicionAnal=i;
            }
            
        }
         
        return posicionAnal;
        }
    
    public int meyorSueldo(int mes, int año){
        int mayor=0;
       int a=recorrerSueldosAnal( mes,año);
       int b=recorrerSueldosProg( mes,año);
        if (a>b) {
            return a;
        }else {
        return b;}
 
    }
    
    
   public ArrayList<Programador> getProgramadores() {
        return programadores;
    }

    public ArrayList<Analista> getAnalistas() {
        return analistas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
   
    public void agregarProgramador(Programador programador) {
        programadores.add(programador);
    }
    public void agregarAnalista(Analista analista) {
        analistas.add(analista);
    }  
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void setProgramadores(ArrayList<Programador> programadores) {
        this.programadores = programadores;
    }
    
    public void setAnalistas(ArrayList<Analista> analistas) {
        this.analistas = analistas;
       
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
   
    public double liquidacionDesde( int mes1, int año1, int mes2, int año2) {
        // nos ingresaran dos fechas, debemos recorrer los arrays de cobros de los programadores y 
        //sumar todos los cobros entre esas dos fechas, 
        //luego devolver la sumatoria de la plata que han cobrado los programadores entre esas dos fechas
        return 1;
    }
    
    public int horasTrabajadasEn(Programador programador) {
        
        return 1;
    }
    
    public double empleadoMejorPago(int mes, int año) {
         // nos ingresaran un mes y un año, debemos recorrer los arrays de sueldos de cada empleado }
         //y devolver los que tienen un sueldo en ese mes y año, y de esos devolver cual es el mayor   
        return 1;
    }
    
    
}
