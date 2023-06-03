/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Menu;
import Vista.Modificar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.vista.getjButton1()){
            this.cm.m.setVisible(true);
            this.vista.setVisible(false);
        }
        if(e.getSource()== this.vista.getjComboBox1()){
            
        }
        if(e.getSource()== this.vista.getjComboBox2()){
            
        }
        if(e.getSource()== this.vista.getjComboBox3()){
            
        }
        if(e.getSource()== this.vista.getjComboBox4()){
            
        }
        if(e.getSource()== this.vista.getjComboBox5()){
            
        }
    }
    
}
