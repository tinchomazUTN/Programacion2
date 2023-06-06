/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Analista;
import Modelo.Cliente;
import Modelo.Programador;
import Vista.Menu;
import Vista.Modificar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author juanm
 */
public class ControladorModificar implements ActionListener{
    private ControladorMenu cm;
    private Modificar vista;
    
    
    public ControladorModificar(ControladorMenu cm) {
        this.cm = cm;
        this.vista = cm.modificar;
        this.vista.getjButton1().addActionListener(this);
        this.vista.getjComboBox1().addActionListener(this);
        this.vista.getjComboBox2().addActionListener(this);
        this.vista.getjComboBox3().addActionListener(this);
        this.vista.getjComboBox4().addActionListener(this);
        this.vista.getjComboBox5().addActionListener(this);
        this.vista.getjButton2().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vista.getjButton2()){
            this.cm.m.setVisible(true);
            this.vista.setVisible(false);
        }
        if(e.getSource()== this.vista.getjButton1()){
            if(this.vista.getjComboBox2().getSelectedItem() != null){
                for (Programador var : this.cm.consultora.programadores) {
                    for (Cliente var2 : this.cm.consultora.getClientes()) {
                        if(var2.getNombre().equals(this.vista.getjComboBox2().getSelectedItem()) 
                           && var.getNombre().equals(this.vista.getjComboBox1().getSelectedItem() )){
                            var.setCliente(var2);
                            cm.conexion.modificarClienteBD(var,var2);  
                            JOptionPane.showMessageDialog(vista, "Datos Guardados en programador");
                        }
                    }
                } 
            }
            if(this.vista.getjComboBox4().getSelectedItem() != null){
                for (Analista var : this.cm.consultora.analistas) {
                   if(var.getNombre().equals(this.vista.getjComboBox3().getSelectedItem())){
                       var.setCategoria(this.vista.getjComboBox4().getSelectedItem().toString());
                       cm.conexion.modificarCategoriaBD(var, this.vista.getjComboBox4().getSelectedItem().toString());
                       JOptionPane.showMessageDialog(vista, "Datos Guardados en analista");
                   }
                }
            }
            if(!this.vista.getjTextField1().getText().isEmpty()){
                for(Cliente var : this.cm.consultora.clientes){
                    if(var.getNombre().equals(this.vista.getjComboBox5().getSelectedItem())){
                        var.setPrecioHora(Integer.parseInt(this.vista.getjTextField1().getText()));
                        cm.conexion.modificarPrecioHoraBD(var,Integer.parseInt(this.vista.getjTextField1().getText()));
                        JOptionPane.showMessageDialog(vista, "Datos Guardados en cliente");
                    }
                }
            }
            this.cm.m.setVisible(true);
            this.vista.setVisible(false);
        }
}
}