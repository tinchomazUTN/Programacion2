/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import BD.Conexion;
import Vista.Menu;
<<<<<<< HEAD

=======
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> cf168771ea799751a8210735eecd15a23a0b190d

/**
 *
 * @author Flores
 */
public class Consultora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       // Conexion conexionBd = new Conexion();
        Menu m = new Menu();
        ControladorMenu controlador = new ControladorMenu(m);  
        //llenar(conexionBd.conectar(),conexionBd,controlador);
        //conexionBd.desconectar();
    }
    public static void llenar(Connection con,Conexion BD,ControladorMenu cm) throws SQLException{
        try {
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery("SELECT * FROM programador");
            
            while(resultado.next()){
                System.out.println(resultado.getString("nombre") + " " + resultado.getString("domicilio")+ " " + resultado.getString("dni"));
            }
            stm.close();
            resultado.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.close();
        }
    }
}
