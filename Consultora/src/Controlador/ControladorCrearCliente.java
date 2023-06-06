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
import javax.swing.JOptionPane;

/**
 *
 * @author juanm
 */
public class ControladorCrearCliente implements ActionListener{
    private ControladorMenu cm;
    private CrearCliente vista;
    
    
    public ControladorCrearCliente(ControladorMenu cm) {
        
        this.cm = cm;
        this.vista = cm.crearCliente;
        this.vista.getjButton1().addActionListener(this);
        this.vista.getjButton2().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Cliente cliente = new Cliente();
        if(e.getSource() == this.vista.getjButton2()){
            this.cm.m.setVisible(true);
            this.vista.setVisible(false);
        }
        //Boton guardar cambios,si faltan campos no guarda nada
        if(e.getSource()== this.vista.getjButton1()){
            if (!this.vista.getjTextField1().getText().isEmpty() && !this.vista.getjTextField2().getText().isEmpty() && !this.vista.getjTextField3().getText().isEmpty() ) {
                cliente.setId(cm.conexion.obtenerUltimoIdCliente());
                cliente.setNombre(this.vista.getjTextField1().getText());
                cliente.setDireccion(this.vista.getjTextField3().getText());
                cliente.setPrecioHora(Integer.parseInt(this.vista.getjTextField2().getText()));
                this.cm.consultora.agregarCliente(cliente);
                cm.conexion.agregarClienteBD(cliente);
                JOptionPane.showMessageDialog(vista, "Datos Guardados");
            }else{
                JOptionPane.showMessageDialog(vista, "Datos Vacios,volviendo al Menu");
            }
            this.cm.m.setVisible(true);
            this.vista.setVisible(false); 
        }
        
        
    }
    
}