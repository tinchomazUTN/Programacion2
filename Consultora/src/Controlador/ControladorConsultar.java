/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Consultar;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juanm
 */
public class ControladorConsultar implements ActionListener{
    ControladorMenu cm;
    Consultar vista;

    public ControladorConsultar(ControladorMenu cm) {
        this.cm = cm;
        this.vista = cm.consultar;
        this.vista.getjButton1().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vista.getjButton1()){
            this.cm.m.setVisible(true);
            this.vista.setVisible(false);
        }
    }
    
}
