/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.CrearCliente;
import Vista.CrearEmpleado;
import Vista.Menu;
import Vista.OpcionCrear;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Flores
 */
public class ControladorOpcionCrear implements ActionListener{
    public ControladorMenu cm;
    public  OpcionCrear vista;
    public  CrearEmpleado vistaEmpleado;
    public  CrearCliente vistaCliente;
    
    public ControladorOpcionCrear(ControladorMenu cm) {
        this.cm= cm;
        this.vista = cm.opcionCrear;
        this.vista.getjButton1().addActionListener(this);
        this.vista.getjButton2().addActionListener(this);
        this.vistaEmpleado = cm.crearEmpleado;
        this.vistaCliente = cm.crearCliente;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.getjButton1()){
            this.vistaEmpleado.setVisible(true);
            this.vista.setVisible(false);
        }else if(e.getSource()== vista.getjButton2()){
            this.vistaCliente.setVisible(true);
            this.vista.setVisible(false);
        }
    }
    
}
