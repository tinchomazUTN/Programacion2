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
    //Recorre los sueldos de todos los programadores en un mes y año en concreto
    //devuelve la posicion donde se encuentra ese sueldo
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
    //Recorre los sueldos de todos los analistas en un mes y año en concreto
    //devuelve la posicion donde se encuentra ese sueldo
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
    //Segun la posicion de un programador y un analista,en un mes y año
    //devuelve cual es mas grande y cual es el sueldo.
    public String mayorSueldo(int mes, int año,int posA,int posP){
        int mayor=0;
       posA=recorrerSueldosAnal( mes,año);
       posP=recorrerSueldosProg( mes,año);
        if ((analistas.get(posA).getSueldoMes(mes, año))>(programadores.get(posP).getSueldoMes(mes, año))) {
            return "Analista " + analistas.get(posA).getNombre() + " Sueldo : " + analistas.get(posA).getSueldoMes(mes,año);
        }else {
           return "Programador " + analistas.get(posP).getNombre() + " Sueldo : " + analistas.get(posP).getSueldoMes(mes,año);}
    }
    //Suma todos los sueldos de los programadores y analistas en dos periodos de tiempos
    public int sumatoriaSueldos(int mes1, int año1, int mes2, int año2){
        int sumatoria=0;
        if (año1==año2) {
            System.out.println("entre en año1==año2");
            for (int i = 0; i < this.programadores.size(); i++) {
              for (int j = mes1; j <= mes2; j++) {
               sumatoria+=this.programadores.get(i).getSueldoMes(j, año1);
                }  
            }
            for (int i = 0; i < this.analistas.size(); i++) {
                
              for (int j = mes1; j <= mes2; j++) {
                  System.out.println("entre en analistas"+j);
               sumatoria+=this.analistas.get(i).getSueldoMes(j, año1);
               
                }  
            }
        }
        else if (año1<año2) {
            if (año2-año1==1) {
                 System.out.println("entre en año 2 - año1 ==1 ");
                for (int i = 0; i < this.programadores.size(); i++) {
                
                    for (int k = mes1; k < 12; k++) {
                        sumatoria+=this.programadores.get(i).getSueldoMes(k, año1);
                    } 
                    for (int j = 0; j <= mes2; j++) {
                        sumatoria+=this.programadores.get(i).getSueldoMes(j, año1+1);
                    }  
                }
                for (int i = 0; i < this.analistas.size(); i++) {
                
                    for (int k = mes1; k < 12; k++) {
                        sumatoria+=this.analistas.get(i).getSueldoMes(k, año1);
                    } 
                    for (int j = 0; j <= mes2; j++) {
                        sumatoria+=this.analistas.get(i).getSueldoMes(j, año1+1);
                    }  
                }
            }
            if (año2-año1==2) {
                System.out.println("entre en año 2 - año1 ==2 ");
                for (int i = 0; i < this.programadores.size(); i++) {
                
                    for (int k = mes1; k < 12; k++) {
                        sumatoria+=this.programadores.get(i).getSueldoMes(k, año1);
                    } 
                    for (int j = 0; j < 12; j++) {
                        sumatoria+=this.programadores.get(i).getSueldoMes(j, año1+1);
                    }  
                    for (int h = 0; h <= mes2; h++) {
                        sumatoria+=this.programadores.get(i).getSueldoMes(h, año1+2);
                    } 
                }
                for (int i = 0; i < this.analistas.size(); i++) {
                
                    for (int k = mes1; k < 12; k++) {
                        sumatoria+=this.analistas.get(i).getSueldoMes(k, año1);
                    } 
                    for (int j = 0; j <12; j++) {
                        sumatoria+=this.analistas.get(i).getSueldoMes(j, año1+1);
                    } 
                    for (int h = mes1; h <= mes2; h++) {
                        sumatoria+=this.analistas.get(i).getSueldoMes(h, año1+2);
                    } 
                     
                }
            }else {
                        System.out.println("no entre");
                        }
        }
        return sumatoria;
    }
    //Getters y Setters
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
}
