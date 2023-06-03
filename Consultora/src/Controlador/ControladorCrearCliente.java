/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Cliente;
import Vista.CrearCliente;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juanm
 */
public class ControladorCrearCliente implements ActionListener{
    private ControladorMenu cm;
    private CrearCliente vista;
    private Cliente cliente = new Cliente();
    
    public ControladorCrearCliente(ControladorMenu cm) {
        this.cm= cm;
        this.vista = cm.crearCliente;
        this.vista.getjButton1().addActionListener(this);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.vista.getjButton1()){
            if (!this.vista.getjTextField1().getText().equals(null) && !this.vista.getjTextField2().getText().equals(null) && !this.vista.getjTextField3().getText().equals(null) ) {
                this.cliente.setNombre(this.vista.getjTextField1().getText());
                this.cliente.setDireccion(this.vista.getjTextField3().getText());
                this.cliente.setPrecioHora(Double.parseDouble(this.vista.getjTextField2().getText()));
                
            }       
            this.cm.m.setVisible(true);
            this.vista.setVisible(false); 
        }
        
        
    }
    
}