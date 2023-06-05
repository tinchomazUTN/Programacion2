
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    String bd = "Consultora";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "root";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    
    public Conexion() {
    
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd,user,password);
            System.out.println("Conectado a bd");
        } catch (ClassNotFoundException |SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se pudo conectar a la db");
        }
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
<<<<<<< HEAD
    public void iniciar(ControladorMenu cm){
        try {
            Statement stm = cx.createStatement();
            ResultSet resultado = stm.executeQuery("SELECT * FROM programador");
            
            while(resultado.next()){
                Programador pr = new Programador();
                pr.setId(resultado.getInt("idprogramador"));
                pr.setNombre(resultado.getString("nombre"));
                pr.setDomicilio(resultado.getString("domicilio"));
                pr.setDocumento(resultado.getInt("dni"));
                
                cm.consultora.programadores.add(pr);
            }
            
            resultado = null;
            resultado = stm.executeQuery("SELECT * FROM analista");
            
            while(resultado.next()){
                Analista an = new Analista();
                an.setId(resultado.getInt("idanalista"));
                an.setNombre(resultado.getString("nombre"));
                an.setDomicilio(resultado.getString("domicilio"));
                an.setDocumento(resultado.getInt("dni"));
                
                cm.consultora.analistas.add(an);
            }
            
            resultado = null;
            resultado = stm.executeQuery("SELECT * FROM cliente");
            
            while(resultado.next()){
                Cliente cl = new Cliente();
                cl.setId(resultado.getInt("idcliente"));
                cl.setNombre(resultado.getString("nombre"));
                cl.setDireccion(resultado.getString("direccion"));
                cl.setPrecioHora(resultado.getInt("precioHora"));
                
                cm.consultora.clientes.add(cl);
            }
            
            stm.close();
            resultado.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            this.desconectar();
        }
    }
    

}
=======
}
>>>>>>> cf168771ea799751a8210735eecd15a23a0b190d
