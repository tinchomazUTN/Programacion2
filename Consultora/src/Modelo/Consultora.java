/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author joaco
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consultora {
    private ArrayList<Programador> programadores= new ArrayList();
    private ArrayList<Analista> analistas= new ArrayList();
    private ArrayList<Cliente> clientes= new ArrayList();

    public Consultora() {
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
    
    public double liquidacionDesde( int mes1, int año1, int mes2, int año2) {
        // nos ingresaran dos fechas, debemos recorrer los arrays de cobros de los programadores y 
        //sumar todos los cobros entre esas dos fechas, 
        //luego devolver la sumatoria de la plata que han cobrado los programadores entre esas dos fechas
        return 1;
    }
    
    public int horasTrabajadasEn(Programador programador) {
        // devuelve total de horas trabajadas por un programador,
        //ya tenemos esa variable dentro de cada programador
        return 1;
    }
    
    public double empleadoMejorPago(int mes, int año) {
         // nos ingresaran un mes y un año, debemos recorrer los arrays de sueldos de cada empleado }
         //y devolver los que tienen un sueldo en ese mes y año, y de esos devolver cual es el mayor   
        return 1;
    }
}
