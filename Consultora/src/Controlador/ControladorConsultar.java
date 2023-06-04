/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Programador;
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
        this.vista.getjButton2().addActionListener(this);
        this.vista.getjButton3().addActionListener(this);
        this.vista.getjButton4().addActionListener(this);
        this.vista.getjComboBox1().addActionListener(this);
        
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
        if(e.getSource() == this.vista.getjButton2()){
            int a = this.cm.consultora.recorrerSueldosProg(this.vista.getjComboBox2().getSelectedIndex()-1,this.vista.getjComboBox3().getSelectedIndex()-1);
            int b = this.cm.consultora.recorrerSueldosAnal(this.vista.getjComboBox2().getSelectedIndex()-1,this.vista.getjComboBox3().getSelectedIndex()-1);
            if (this.cm.consultora.programadores.get(a).getSueldoMes(this.vista.getjComboBox2().getSelectedIndex()-1,this.vista.getjComboBox3().getSelectedIndex()-1)>=this.cm.consultora.analistas.get(b).getSueldoMes(this.vista.getjComboBox2().getSelectedIndex()-1,this.vista.getjComboBox3().getSelectedIndex()-1)) {
                this.vista.getjTextField2().setText(this.cm.consultora.programadores.get(a).getNombre()+" sueldo: "+this.cm.consultora.programadores.get(a).getSueldoMes(this.vista.getjComboBox2().getSelectedIndex()-1,this.vista.getjComboBox3().getSelectedIndex()-1));
            }else{
                this.vista.getjTextField2().setText(this.cm.consultora.analistas.get(b).getNombre()+" sueldo: "+this.cm.consultora.analistas.get(b).getSueldoMes(this.vista.getjComboBox2().getSelectedIndex()-1,this.vista.getjComboBox3().getSelectedIndex()-1));
            }
        }
        
        if(e.getSource() == this.vista.getjButton3()){
            
        }
        if(e.getSource() == this.vista.getjButton4()){
            
            for (Programador prog : this.cm.consultora.programadores) {
                if (prog.getNombre().equals(this.vista.getjComboBox1().getSelectedItem())) {
                    
                this.vista.getjTextField1().setText(Integer.toString(prog.getTiempoTrabajado()));
            }
            }
            
        }
        if(e.getSource() == this.vista.getjTextField1()){
          
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
