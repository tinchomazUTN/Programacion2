/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Analista;
import Modelo.Programador;
import Vista.Menu;
import Vista.TerminarTrabajo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTerminarTrabajo implements ActionListener {

    private ControladorMenu cm;
    private TerminarTrabajo vista;
    String[] años = {"2020", "2021", "2022"};
    String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

    public ControladorTerminarTrabajo(ControladorMenu cm) {

        this.cm = cm;
        this.vista = cm.terminarTrabajo;
        this.vista.getjButton1().addActionListener(this);
        this.vista.getjButton2().addActionListener(this);
        this.vista.getjComboBox1().addActionListener(this);
        this.vista.getjComboBox2().addActionListener(this);
        this.vista.getjComboBox3().addActionListener(this);
        this.vista.getjComboBox4().addActionListener(this);
        this.vista.getjComboBox5().addActionListener(this);
        this.vista.getjComboBox6().addActionListener(this);
        this.vista.getjComboBox3().addItem(null);
        this.vista.getjComboBox5().addItem(null);
        for (int i = 0; i < 12; i++) {
            this.vista.getjComboBox3().addItem(meses[i]);
            this.vista.getjComboBox5().addItem(meses[i]);
        }
        this.vista.getjComboBox4().addItem(null);
        this.vista.getjComboBox6().addItem(null);
        for (int i = 0; i < 3; i++) {
            this.vista.getjComboBox4().addItem(años[i]);
            this.vista.getjComboBox6().addItem(años[i]);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vista.getjButton1()) {
            if ((this.vista.getjComboBox1().getSelectedItem() != null) && (this.vista.getjTextField1().getText() != null)
                    && (this.vista.getjComboBox3().getSelectedItem() != null) && (this.vista.getjComboBox4().getSelectedItem() != null)) {
                for (Programador prog : this.cm.consultora.programadores) {
                    if (prog.getNombre().equals(this.vista.getjComboBox1().getSelectedItem().toString())) {
                        prog.aumentarHoras(Integer.parseInt(this.vista.getjTextField1().getText()));
                        cm.conexion.agregarHorasProgramadorBD(prog,Integer.parseInt(this.vista.getjTextField1().getText()));
                        prog.setSueldoMes(this.vista.getjComboBox3().getSelectedIndex() - 1, this.vista.getjComboBox4().getSelectedIndex() - 1, Integer.parseInt(this.vista.getjTextField1().getText()));
                        cm.conexion.agregarSueldoProgramadorBD(prog,this.vista.getjComboBox3().getSelectedIndex() - 1,this.vista.getjComboBox4().getSelectedIndex() - 1,Integer.parseInt(this.vista.getjTextField1().getText()));
                    }
                }
            }
            if ((this.vista.getjComboBox2().getSelectedItem() != null) && (this.vista.getjComboBox5().getSelectedItem() != null) && (this.vista.getjComboBox6().getSelectedItem() != null)) {
                for (Analista anal : this.cm.consultora.analistas) {
                    if (anal.getNombre().equals(this.vista.getjComboBox2().getSelectedItem().toString())) {
                        anal.setSueldoMes(this.vista.getjComboBox5().getSelectedIndex() - 1, this.vista.getjComboBox6().getSelectedIndex() - 1);
                        cm.conexion.agregarSueldoAnalistaBD(anal, this.vista.getjComboBox5().getSelectedIndex() - 1, this.vista.getjComboBox6().getSelectedIndex() - 1);
                                
                    }
                }
            }
            this.cm.m.setVisible(true);
            this.vista.setVisible(false);
        }
        if (e.getSource() == this.vista.getjButton2()) {
            this.cm.m.setVisible(true);
            this.vista.setVisible(false);
        }
    }

}
