/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Menu;
import Vista.TerminarTrabajo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juanm
 */
public class ControladorTerminarTrabajo implements ActionListener{
    private ControladorMenu cm;
    private TerminarTrabajo vista;

    public ControladorTerminarTrabajo(ControladorMenu cm) {
        this.cm = cm;
        this.vista = cm.terminarTrabajo;
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
