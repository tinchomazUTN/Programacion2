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
    String[] años =  {"2020","2021", "2022", "2023", "2024"};
    String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};  

    public ControladorConsultar(ControladorMenu cm) {
        this.cm = cm;
        this.vista = cm.consultar;
        this.vista.getjButton1().addActionListener(this);
        this.vista.getjComboBox1().addActionListener(this);//hay que poner los empleados
        
        this.vista.getjComboBox2().addItem(null);
        this.vista.getjComboBox3().addItem(null);
        this.vista.getjComboBox4().addItem(null);
        this.vista.getjComboBox5().addItem(null);
        this.vista.getjComboBox6().addItem(null);
        this.vista.getjComboBox7().addItem(null);

        for (int i = 0; i < 12; i++) {
         this.vista.getjComboBox2().addItem(meses[i]);
         this.vista.getjComboBox4().addItem(meses[i]);
         this.vista.getjComboBox6().addItem(meses[i]);
        }
        
        for (int i = 0; i < 5; i++) {
        this.vista.getjComboBox3().addItem(años[i]);
        this.vista.getjComboBox5().addItem(años[i]);
        this.vista.getjComboBox7().addItem(años[i]);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vista.getjButton1()){
            this.cm.m.setVisible(true);
            this.vista.setVisible(false);
        }
        if(e.getSource() == this.vista.getjComboBox1()){
           
        }
        if(e.getSource() == this.vista.getjComboBox2()){
           
        }
        if(e.getSource() == this.vista.getjComboBox3()){
           
        }
        if(e.getSource() == this.vista.getjComboBox4()){
           
        }
        if(e.getSource() == this.vista.getjComboBox5()){
           
        }
        if(e.getSource() == this.vista.getjComboBox6()){
           
        }
        if(e.getSource() == this.vista.getjComboBox7()){
           
        }
    }
    
}