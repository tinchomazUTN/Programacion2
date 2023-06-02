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
    private List<Programador> programadores;
    private List<Analista> analistas;
    private List<Cliente> clientes;
    // Agrega otros atributos según sea necesario

    public Consultora(List<Programador> programadores, List<Analista> analistas, List<Cliente> clientes) {
        this.programadores = programadores;
        this.analistas = analistas;
        this.clientes = clientes;
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
    
    public double liquidacionDesde(int dia, int hasta) {
        // Implementa la lógica para calcular la liquidación desde el día 'dia' hasta el día 'hasta'
        double total = 0.0;
        // ...
        return total;
    }
    
    public int horasTrabajadasEn(Programador programador, Date fechaIngreso) {
        // Implementa la lógica para calcular las horas trabajadas por un programador desde su fecha de ingreso
        int horasTrabajadas = 0;
        // ...
        return horasTrabajadas;
    }
    
    public Empleado empleadoMejorPago(int mes, int año) {
        // Implementa la lógica para encontrar al empleado de mejor pago en el mes y año indicados
        Empleado empleado = null;
        // ...
        return empleado;
    }
}
