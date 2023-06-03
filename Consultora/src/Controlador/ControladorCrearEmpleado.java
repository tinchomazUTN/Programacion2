/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Analista;
import Modelo.Empleado;
import Modelo.Programador;
import Vista.CrearEmpleado;
import Vista.Menu;
import Vista.OpcionCrear;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Flores
 */
public class ControladorCrearEmpleado implements ActionListener{
    private ControladorMenu cm;
    private CrearEmpleado vista;
    private Programador progrmador= new Programador();
    private Analista analista = new Analista();
    
    public ControladorCrearEmpleado(ControladorMenu cm) {
        this.cm= cm;
        this.vista = this.cm.crearEmpleado;
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

