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
    
    String[] años =  {"2020","2021", "2022"};
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
        
        for (int i = 0; i < 3; i++) {
        this.vista.getjComboBox3().addItem(años[i]);
        this.vista.getjComboBox5().addItem(años[i]);
        this.vista.getjComboBox7().addItem(años[i]);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //Boton para volver al Menu Principal
        if(e.getSource() == this.vista.getjButton1()){
            this.cm.m.setVisible(true);
            this.vista.setVisible(false);
        }
        //Boton para ver el empleado mejor pago del mes-año seleccionado
        if(e.getSource() == this.vista.getjButton2()){
            int mes = this.vista.getjComboBox2().getSelectedIndex()-1;
            int año = this.vista.getjComboBox3().getSelectedIndex()-1;
            //devuelve la posicion donde esta el mayor sueldo de cada uno
            int prog;
            if(!this.cm.consultora.programadores.isEmpty()){
            prog = this.cm.consultora.recorrerSueldosProg(mes,año);
            }else{
                prog = 0;
            }
            int anali;
            if(!this.cm.consultora.analistas.isEmpty()){
            anali = this.cm.consultora.recorrerSueldosAnal(mes,año);
            }else{
                anali = 0;
            }
            //si no hay empleados en programador y analistas
            if(this.cm.consultora.programadores.isEmpty() && this.cm.consultora.analistas.isEmpty()){
            this.vista.getjTextField2().setText("No hay empleados");
            }
            //si solo hay analistas
            else if(this.cm.consultora.programadores.isEmpty()){
                this.vista.getjTextField2().setText("Analista " + this.cm.consultora.analistas.get(anali).getNombre() + " Sueldo : " + this.cm.consultora.analistas.get(anali).getSueldoMes(mes,año));
            }else if(this.cm.consultora.analistas.isEmpty()){
                this.vista.getjTextField2().setText("Programador " + this.cm.consultora.programadores.get(prog).getNombre() + " Sueldo : " + this.cm.consultora.programadores.get(anali).getSueldoMes(mes,año));
            }else{
            //Funcion para devolver al mayor programador o analista segun la posicion conseguida antes
                this.vista.getjTextField2().setText(this.cm.consultora.programadores.get(prog).getNombre() + this.cm.consultora.mayorSueldo(mes, año, anali, prog));
            }
            
        }
        //Boton para ver la suma de los sueldos en dos periodos
        if(e.getSource() == this.vista.getjButton3()){
            int mes1 = this.vista.getjComboBox4().getSelectedIndex()-1;
            int año1= this.vista.getjComboBox5().getSelectedIndex()-1;
            int mes2 = this.vista.getjComboBox6().getSelectedIndex()-1;
            int año2= this.vista.getjComboBox7().getSelectedIndex()-1;
            this.vista.getjTextField3().setText(Integer.toString(this.cm.consultora.sumatoriaSueldos(mes1,año1,mes2,año2)));
        }
        //Boton para poner el tiempo de trabajo total de un programador
        if(e.getSource() == this.vista.getjButton4()){
            for (Programador prog : this.cm.consultora.programadores) {
                if (prog.getNombre().equals(this.vista.getjComboBox1().getSelectedItem())) {  
                this.vista.getjTextField1().setText(Integer.toString(prog.getTiempoTrabajadoTotal()));
                }
            }            
        }

    }
    
}
