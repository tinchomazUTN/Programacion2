/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BD.Conexion;
import Modelo.Analista;
import Modelo.Cliente;
import Modelo.Programador;
import Modelo.Consultora;
import Vista.Consultar;
import Vista.CrearCliente;
import Vista.CrearEmpleado;
import Vista.Menu;
import Vista.Modificar;
import Vista.OpcionCrear;
import Vista.TerminarTrabajo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Flores
 */
public class ControladorMenu implements ActionListener {

    public Menu m;
    public Consultora consultora = new Consultora();
    public Conexion conexion;

    //vistas
    public Consultar consultar = new Consultar();
    public OpcionCrear opcionCrear = new OpcionCrear();
    public CrearCliente crearCliente = new CrearCliente();
    public CrearEmpleado crearEmpleado = new CrearEmpleado();
    public Modificar modificar = new Modificar();
    public TerminarTrabajo terminarTrabajo = new TerminarTrabajo();

    //controladores
    public ControladorConsultar controladorConsultar = new ControladorConsultar(this);
    public ControladorOpcionCrear controladorOpcionCrear = new ControladorOpcionCrear(this);
    public ControladorCrearCliente controladorCrearCliente = new ControladorCrearCliente(this);
    public ControladorCrearEmpleado controladorCrearEmpleado = new ControladorCrearEmpleado(this);
    public ControladorModificar controladorModificar = new ControladorModificar(this);
    public ControladorTerminarTrabajo controladorTerminarTrabajo = new ControladorTerminarTrabajo(this);

    public ControladorMenu(Menu m,Conexion con) {
        //this.conexion=con;
        this.m = m;
        this.m.getjButton1().addActionListener(this);
        this.m.getjButton2().addActionListener(this);
        this.m.getjButton3().addActionListener(this);
        this.m.getjButton4().addActionListener(this);
        this.m.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == m.getjButton1()) {
            consultar.getjComboBox1().removeAllItems();
            consultar.getjComboBox1().addItem(null);
            for (Programador pr : consultora.programadores) {
                consultar.getjComboBox1().addItem(pr.getNombre());
            }
            this.consultar.setVisible(true);
            this.m.setVisible(false);
        } else if (e.getSource() == m.getjButton2()) {
            this.opcionCrear.setVisible(true);
            this.m.setVisible(false);
        } else if (e.getSource() == m.getjButton3()) {
              modificar.getjComboBox1().removeAllItems();
              modificar.getjComboBox2().removeAllItems();
              modificar.getjComboBox3().removeAllItems();
              modificar.getjComboBox4().removeAllItems();
              modificar.getjComboBox5().removeAllItems();
              ////////////////////////////////////////////
              modificar.getjComboBox1().addItem(null);
              modificar.getjComboBox2().addItem(null);
              modificar.getjComboBox3().addItem(null);
              modificar.getjComboBox4().addItem(null);
              modificar.getjComboBox5().addItem(null);
              modificar.getjComboBox4().addItem("Junior");
              modificar.getjComboBox4().addItem("Senior");
              modificar.getjComboBox4().addItem("Semi Senior");
            for (Programador pr : consultora.programadores) {
                modificar.getjComboBox1().addItem(pr.getNombre());
            }
            for (Analista an : consultora.analistas) {
                modificar.getjComboBox3().addItem(an.getNombre());
            }
            for (Cliente cl : consultora.clientes) {
                modificar.getjComboBox2().addItem(cl.getNombre());
                modificar.getjComboBox5().addItem(cl.getNombre());
            }
            this.modificar.setVisible(true);
            this.m.setVisible(false);
        } else if (e.getSource() == m.getjButton4()) {
            terminarTrabajo.getjComboBox1().removeAllItems();
            terminarTrabajo.getjComboBox1().addItem(null);
            terminarTrabajo.getjComboBox2().removeAllItems();
            terminarTrabajo.getjComboBox2().addItem(null);
            for (Programador pr : consultora.programadores) {
                terminarTrabajo.getjComboBox1().addItem(pr.getNombre());
            }
            for (Analista an : consultora.analistas) {
                terminarTrabajo.getjComboBox2().addItem(an.getNombre());
            }
            this.terminarTrabajo.setVisible(true);
            this.m.setVisible(false);
        }
    }

}
