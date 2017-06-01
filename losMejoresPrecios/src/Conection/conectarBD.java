package Conection;

/*
 *Este metodo Permite la conexion con una Base de datos de MySQL
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conectarBD {
//Datos para la conexion
    Connection conexion=null;
  private String database="losMejoresPrecios";
  private String url="";
  private String usuario="usuario";
  private String password="1490Martin";
   //Funcion conectar
    public conectarBD(){
      try {
            Class.forName("com.mysql.jdbc.Driver");

            url="jdbc:mysql://"+"analisis.cxlcq8r3vcp4.us-west-2.rds.amazonaws.com:3306"+"/"+database;
            conexion=(Connection) DriverManager.getConnection(url,usuario,password);
            System.out.println("Conexion a Base de Datos "+url+" . . . . .Ok");
         }
        catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
    public Connection getConexion(){
        return conexion;
    }
    
    /**
     * Permite Instertar Registros a la BD
     * @param Codigo
     * @param Nombre
     * @param Sexo
     * @param Parentesco
     * @return
     */
    public boolean insertardatos(Integer Codigo, String Nombre, String Sexo,String Parentesco){  
        try{
         String sentenciaingresar="INSERT INTO " + "personas " + " VALUES ("
                 + "\""+Codigo+"\","
                + "\""+Nombre+"\","
                 + "\""+Sexo+"\","
                + "\""+Parentesco+"\")";  
        Statement st=getConexion().createStatement();
       // System.out.println(sentenciaingresar);
        st.executeUpdate(sentenciaingresar);
        return true; //"Datos almacenados correctamente";
   
        }catch(SQLException ex){
  
            return false; //"Error en el almacenamiento de datos"+ex;
        }
   }

    /**
     * Permite Editar Un Registro en la BD
     * @param codigo
     * @param nuevonombre
     * @return
     */
    public boolean EditarR(Integer codigo,String nuevonombre){
        
       try {
              String realizarAvance="UPDATE "+ " datos_arbol.personas " + " SET nombre ='"  + nuevonombre+ "' WHERE "+" codigo="+codigo;
            Statement st =(Statement) getConexion().createStatement();
            st.executeUpdate(realizarAvance);
            return true;
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           
          return false;

        }
    }
 
    /**
     * Realiza la elimiacion de un registro
     * @param codigo
     * @return
     */
    public boolean Elminiar(Integer codigo) {
        try {
            String eliminarnodo="DELETE FROM " + "datos_arbol.personas" + " WHERE codigo = " + codigo;
            //String eliminarProy = "DELETE FROM " + table_name + " WHERE codigoProyecto = \"" + codigo + "\"";
            Statement st =(Statement) getConexion().createStatement();
            st.executeUpdate(eliminarnodo); 
            return true;
 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           // JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
          return false;

        }
    }
 
}
   
  