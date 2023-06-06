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
import javax.swing.JOptionPane;

/**
 *
 * @author Flores
 */
public class ControladorCrearEmpleado implements ActionListener{
    public ControladorMenu cm;
    private CrearEmpleado vista;

    
    public ControladorCrearEmpleado(ControladorMenu cm) {
       
        this.cm= cm;
        this.vista = this.cm.crearEmpleado;
        this.vista.getjButton1().addActionListener(this);
         this.vista.getjButton2().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Programador programador = new Programador();
        Analista analista = new Analista();
        if(e.getSource() == this.vista.getjButton2()){
            this.cm.m.setVisible(true);
            this.vista.setVisible(false);
        }
        if(e.getSource() == this.vista.getjButton1()){
            //Guardar datos,si falta alguno manda mensaje de error
            if (!this.vista.getjTextField1().getText().isEmpty() && !this.vista.getjTextField2().getText().isEmpty() && !this.vista.getjTextField3().getText().isEmpty()){
                if (this.vista.getjComboBox1().getSelectedItem().toString().equals("Programador")) {
                    programador.setId(cm.conexion.obtenerUltimoIdProgramador());
                    programador.setDocumento(Integer.parseInt(this.vista.getjTextField1().getText()));
                    programador.setDomicilio(this.vista.getjTextField2().getText());
                    programador.setNombre(this.vista.getjTextField3().getText());
                    this.cm.consultora.programadores.add(programador);
                    cm.conexion.agregarProgramadorBD(programador);
                    JOptionPane.showMessageDialog(vista, "Datos Guardados");
                }
                if (this.vista.getjComboBox1().getSelectedItem().toString().equals("Analista")) {
                    analista.setId(cm.conexion.obtenerUltimoIdAnalista());
                    analista.setDocumento(Integer.parseInt(this.vista.getjTextField1().getText()));
                    analista.setDomicilio(this.vista.getjTextField2().getText());
                    analista.setNombre(this.vista.getjTextField3().getText());
                    this.cm.consultora.agregarAnalista(analista);
                    cm.conexion.agregarAnalistaBD(analista);
                    JOptionPane.showMessageDialog(vista, "Datos Guardados");
                }
            }else{
                JOptionPane.showMessageDialog(vista, "Datos Vacios,volviendo al Menu");
            }
            this.cm.m.setVisible(true);
            this.vista.setVisible(false);
        }
    }
    
}

