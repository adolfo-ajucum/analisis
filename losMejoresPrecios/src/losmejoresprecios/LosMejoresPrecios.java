/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package losmejoresprecios;

import CAPADENEGOCIO.cliente;
import Conection.conectarBD;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author martin
 */
public class LosMejoresPrecios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Hola prro
        //Me hacen falta
        //conectarBD nuevo=new conectarBD();
        Procedimiento();
        
    }
    
    public static String Procedimiento(){
       cliente nv= new cliente(3,"Fabian","Mendez","Quetzaltenango","12345","12345");
        String mensaje=null;
       int numero=0;
        try {
            conectarBD db = new conectarBD();
            Connection cn = db.getConexion();
 
            if (cn == null) {
                mensaje = "No hay conexión a la base de datos...!";
            } else {
                Statement st = cn.createStatement();
          
                CallableStatement sp=cn.prepareCall("{call insertar_empleados(?,?,?,?,?,?,?,?,?,?)}");
               
                sp.setInt(1,nv.getIdclientes());
                //sp.registerOutParameter(1, java.sql.Types.INTEGER); 
                sp.setString(2,nv.getNombre());
                sp.setString(3,nv.getApellido());
                sp.setString(4,nv.getDireccion());
                sp.setInt(5,12345678);
                sp.setString(6,"");
                sp.setString(7,"");
               java.sql.Date sqlDate = new java.sql.Date(0);
                sp.setDate(8,sqlDate);
                sp.setString(9,"");
                sp.setString(10,"delete");
               // sp.registerOutParameter(2,java.sql.Types.VARCHAR);
                // ResultSet resultSet =sp.executeQuery();
                sp.execute();
                
               // numero=sp_CountFilas.getInt(1);
               
                st.close();
                cn.close();
            }
        } catch (SQLException e) {
            mensaje="Error al conectar: "+e;
        } catch (Exception e) {
            mensaje="Error: "+e;
        }
        
        System.out.println(mensaje); 
        return String.valueOf(numero);
                
    }
}

