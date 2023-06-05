/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BD.Conexion;
import Vista.Menu;


/**
 *
 * @author Flores
 */
public class Consultora {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args){
        Conexion conexionBd = new Conexion();
        Menu m = new Menu();
        ControladorMenu controlador = new ControladorMenu(m,conexionBd);  
        conexionBd.iniciar(controlador);
    }
   
 
}
