package BD;

import Controlador.ControladorMenu;
import Modelo.Analista;
import Modelo.Cliente;
import Modelo.Consultora;
import Modelo.Programador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    //La funcion conectar() abre la conexion con la base de datos
    public Connection conectar() {
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, user, password);
            System.out.println("Conectado a bd");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se pudo conectar a la db");
        }
        return cx;
    }
    //Esta funcion cierra la conexion con la base de datos
    public void desconectar() {
        try {
            cx.close();
            System.out.println("desconectado de bd");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //La funcion iniciar llena los arrays de clientes,programadores y analistas
    //Asi se puede trabajar con las entidades que estan en la base de datos
    public void iniciar(ControladorMenu cm) {
        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            ResultSet resultado = stm.executeQuery("SELECT * FROM programador");

            while (resultado.next()) {
                Programador pr = new Programador();
                pr.setId(resultado.getInt("idprogramador"));
                pr.setNombre(resultado.getString("nombre"));
                pr.setDomicilio(resultado.getString("domicilio"));
                pr.setDocumento(resultado.getInt("dni"));
                pr.setSueldoMes(llenarSueldoProgramador(pr));
                cm.consultora.programadores.add(pr);
            }

            resultado = null;
            resultado = stm.executeQuery("SELECT * FROM analista");

            while (resultado.next()) {
                Analista an = new Analista();
                an.setId(resultado.getInt("idanalista"));
                an.setNombre(resultado.getString("nombre"));
                an.setDomicilio(resultado.getString("domicilio"));
                an.setDocumento(resultado.getInt("dni"));
                an.setCategoria(resultado.getString("categoria"));
                an.setSueldoMes(llenarSueldoAnalista(an));
                cm.consultora.analistas.add(an);
            }

            resultado = null;
            resultado = stm.executeQuery("SELECT * FROM cliente");

            while (resultado.next()) {
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
        } finally {
            this.desconectar();
        }
    }

    //Esta funcion rellena la matriz del sueldo de las entidades que la tienen en la base de datos
    public int[][] llenarSueldoProgramador(Programador programador) {
        int[][] sueldoProgramador = new int[12][3];
        try {
            Statement stmS = cx.createStatement();
            ResultSet resultado = stmS.executeQuery("SELECT * FROM sueldomes"
                    + " WHERE idprogramador = " + programador.getId());
            while (resultado.next()) {
                switch (resultado.getInt("anio")) {
                    case 2020:
                        sueldoSegunAnio(resultado, 0, sueldoProgramador);
                        break;
                    case 2021:
                        sueldoSegunAnio(resultado, 1, sueldoProgramador);
                        break;
                    case 2022:
                        sueldoSegunAnio(resultado, 2, sueldoProgramador);
                        break;
                }
            }

            resultado.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sueldoProgramador;
    }
    //Idem anterior
    public int[][] llenarSueldoAnalista(Analista analista) {
        int[][] sueldoAnalista = new int[12][3];
        try {
            Statement stmS = cx.createStatement();
            ResultSet resultado = stmS.executeQuery("SELECT * FROM sueldomes"
                    + " WHERE idanalista = " + analista.getId());
            while (resultado.next()) {
                switch (resultado.getInt("anio")) {
                    case 2020:
                        sueldoSegunAnio(resultado, 0, sueldoAnalista);
                        break;
                    case 2021:
                        sueldoSegunAnio(resultado, 1, sueldoAnalista);
                        break;
                    case 2022:
                        sueldoSegunAnio(resultado, 2, sueldoAnalista);
                        break;
                }
            }

            resultado.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sueldoAnalista;
    }

    public void sueldoSegunAnio(ResultSet resultado, Integer anio, int[][] sueldo) {
        try {
            sueldo[0][anio] = resultado.getInt("enero");
            sueldo[1][anio] = resultado.getInt("febrero");
            sueldo[2][anio] = resultado.getInt("marzo");
            sueldo[3][anio] = resultado.getInt("abril");
            sueldo[4][anio] = resultado.getInt("mayo");
            sueldo[5][anio] = resultado.getInt("junio");
            sueldo[6][anio] = resultado.getInt("julio");
            sueldo[7][anio] = resultado.getInt("agosto");
            sueldo[8][anio] = resultado.getInt("septiembre");
            sueldo[9][anio] = resultado.getInt("octubre");
            sueldo[10][anio] = resultado.getInt("noviembre");
            sueldo[11][anio] = resultado.getInt("diciembre");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Se realiza un update para modificar el campo cliente del programador
    public void modificarClienteBD(Programador programador, Cliente cliente) {

        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            stm.executeUpdate("UPDATE programador SET"
                    + "`cliente` = " + cliente.getId()
                    + " WHERE `idprogramador` = " + programador.getId());

            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }
    }
    //Se realiza un update para modificar el campo precioHora del cliente
    public void modificarPrecioHoraBD(Cliente cliente, Integer precioHora) {

        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            stm.executeUpdate("UPDATE cliente SET"
                    + "`precioHora` = " + precioHora
                    + " WHERE `idcliente` = " + cliente.getId());

            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }
    }
    //Se realiza un update para modificar el categoria de analista en la base de datos
    public void modificarCategoriaBD(Analista analista, String categoria) {
        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            stm.executeUpdate("UPDATE analista SET "
                    + "`categoria` = \"" + categoria + "\""
                    + " WHERE `idanalista` = " + analista.getId());

            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }
    }
    //Se obtiene el ultimo id de la base de datos +1 para setear el atributo al nuevo cliente a crear
    public int obtenerUltimoIdCliente() {
        int id = 0;
        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            ResultSet resultado = stm.executeQuery("SELECT MAX(idcliente +1) as id FROM cliente");
            if (resultado.next()) {
                id = resultado.getInt("id");
            }
            resultado.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }
        return id;
    }
    //Idem anterior
    public int obtenerUltimoIdProgramador() {
        int id = 0;
        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            ResultSet resultado = stm.executeQuery("SELECT MAX(idprogramador +1) as id FROM programador");
            if (resultado.next()) {
                id = resultado.getInt("id");
            }
            resultado.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }
        return id;
    }
    //Idem anterior
    public int obtenerUltimoIdAnalista() {
        int id = 0;
        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            ResultSet resultado = stm.executeQuery("SELECT MAX(idanalista +1) as id FROM analista");
            if (resultado.next()) {
                id = resultado.getInt("id");
            }
            resultado.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }
        return id;
    }
    //Agregamos el nuevo cliente con la sentencia insert into
    public void agregarClienteBD(Cliente cliente) {
        System.out.println("INSERT INTO cliente(`nombre`,`direccion`,`precioHora`) "
                + "VALUES(\"" + cliente.getNombre()
                + "\",\"" + cliente.getDireccion()
                + "\"," + cliente.getPrecioHora() + ")");
        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            stm.executeUpdate("INSERT INTO cliente(`nombre`,`direccion`,`precioHora`) "
                    + "VALUES(\"" + cliente.getNombre()
                    + "\",\"" + cliente.getDireccion()
                    + "\"," + cliente.getPrecioHora() + ")");

            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }

    }
    //Agregamos el nuevo programador con la sentencia insert into
    public void agregarProgramadorBD(Programador programador) {

        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            stm.executeUpdate("INSERT INTO programador(`nombre`,`domicilio`,`dni`,`tiempoTrabajado`,`tiempoTrabajadoTotal`)"
                    + "VALUES(\"" + programador.getNombre() + "\",\""
                    + programador.getDomicilio() + "\"," + programador.getDNI()
                    + ",0,0);");

            int anio = 2020;
            for (int i = 0; i < 3; i++) {
                stm.executeUpdate("INSERT INTO sueldomes(`enero`,`febrero`,`marzo`,`abril`,`mayo`,`junio`,`julio`,`agosto`,`septiembre`,`octubre`,`noviembre`,`diciembre`,`anio`,`idprogramador`)"
                        + "VALUES(0,0,0,0,0,0,0,0,0,0,0,0," + (anio + i) + "," + programador.getId() + ");");
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }

    }
    //Agregamos el nuevo analista con la sentencia insert into
    public void agregarAnalistaBD(Analista analista) {

        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            stm.executeUpdate("INSERT INTO analista(`nombre`,`domicilio`,`dni`)"
                    + "VALUES(\"" + analista.getNombre() + "\",\""
                    + analista.getDomicilio() + "\"," + analista.getDNI()
                    + ");");

            int anio = 2020;
            for (int i = 0; i < 3; i++) {
                stm.executeUpdate("INSERT INTO sueldomes(`enero`,`febrero`,`marzo`,`abril`,`mayo`,`junio`,`julio`,`agosto`,`septiembre`,`octubre`,`noviembre`,`diciembre`,`anio`,`idanalista`)"
                        + "VALUES(0,0,0,0,0,0,0,0,0,0,0,0," + (anio + i) + "," + analista.getId() + ");");
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }

    }
    //Se realiza una sentencia uodate para modificar el atributo de programador
    public void agregarHorasProgramadorBD(Programador programador, Integer horas) {
        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            stm.executeUpdate("UPDATE programador SET "
                    + "`tiempoTrabajadoTotal` = " + (programador.getTiempoTrabajadoTotal() + horas)
                    + " WHERE `idprogramador` = " + programador.getId());

            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }
    }
    //Se realiza una sentencia uodate para modificar el atributo de programador
    public void agregarSueldoProgramadorBD(Programador programador, int mes, int anio, int sueldo) {
        String[] anios = {"2020", "2021", "2022"};
        String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        System.out.println("UPDATE sueldomes SET"
                + "`" + meses[mes] + "` = " + (sueldo * programador.getCliente().getPrecioHora())
                + " WHERE `anio` = " + anios[anio] + " `idprogramador` = " + programador.getId());
        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            stm.executeUpdate("UPDATE sueldomes SET "
                    + "`" + meses[mes] + "` = " + (sueldo * programador.getCliente().getPrecioHora())
                    + " WHERE `anio` = " + anios[anio] + " and `idprogramador` = " + programador.getId());

            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }
    }
    //Se realiza una sentencia uodate para modificar el atributo de analista
    public void agregarSueldoAnalistaBD(Analista analista, int mes, int anio) {
        System.out.println("Entre en analista");
        String[] anios = {"2020", "2021", "2022"};
        String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        System.out.println("UPDATE sueldomes SET"
                + "`" + meses[mes] + "` = " + analista.categoriaRemunerada(analista.getCategoria())
                + " WHERE `anio` = " + anios[anio] + " `idanalista` = " + analista.getId());
        
        try {
            this.cx = this.conectar();
            Statement stm = cx.createStatement();
            stm.executeUpdate("UPDATE sueldomes SET "
                + "`" + meses[mes] + "` = " + analista.categoriaRemunerada(analista.getCategoria())
                + " WHERE `anio` = " + anios[anio] + " and `idanalista` = " + analista.getId());

            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consultora.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }
    }
}
