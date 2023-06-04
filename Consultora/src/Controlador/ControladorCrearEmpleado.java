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
    public ControladorMenu cm;
    private CrearEmpleado vista;
    private Programador programador= new Programador();
    private Analista analista = new Analista();
    
    public ControladorCrearEmpleado(ControladorMenu cm) {
        this.cm= cm;
        this.vista = this.cm.crearEmpleado;
        this.vista.getjButton1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vista.getjButton1()){
            
            if (!this.vista.getjTextField1().getText().equals(null) && !this.vista.getjTextField2().getText().equals(null) && !this.vista.getjTextField3().getText().equals(null) ) {
                if (this.vista.getjComboBox1().getSelectedItem().toString().equals("Programador")) {
                    this.programador.setDocumento(Integer.parseInt(this.vista.getjTextField1().getText()));
                    this.programador.setDomicilio(this.vista.getjTextField2().getText());
                    this.programador.setNombre(this.vista.getjTextField3().getText());
                    this.cm.consultora.agregarProgramador(programador);
    
                }
                if (this.vista.getjComboBox1().getSelectedItem().toString().equals("Analista")) {
                    this.analista.setDocumento(Integer.parseInt(this.vista.getjTextField1().getText()));
                    this.analista.setDomicilio(this.vista.getjTextField2().getText());
                    this.analista.setNombre(this.vista.getjTextField3().getText());
                    this.cm.consultora.agregarAnalista(analista);
 
                }
            }
            
            
            
            this.cm.m.setVisible(true);
            this.vista.setVisible(false);
        }
    }
    
}

