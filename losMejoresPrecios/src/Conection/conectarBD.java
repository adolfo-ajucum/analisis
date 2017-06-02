package Conection;

/*
 *Este metodo Permite la conexion con una Base de datos de MySQL
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conectarBD {
//Datos para la conexion
    private Connection con=null;
    Connection conexion=null;
    private String lastError=null;
    private Usuario pers=new Usuario();
    
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
    //--MARLON LIBRERIAS----------------------------------------------------------------------------
    public boolean conectar(String bd, String usuario,String clave){
        try{
            //un formulario donde este el driver
            Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost/" + bd + "?user=" + "&password=" + clave);
            con=DriverManager.getConnection("jdbc:mysql://analisis.cxlcq8r3vcp4.us-west-2.rds.amazonaws.com:3306/" + bd + "?user=" + usuario + "&password=" + clave);
            return true;
        }catch(ClassNotFoundException cnfe){
            lastError= cnfe.getMessage();
            return false;
        }
    catch(SQLException sqle)
    {
        lastError= sqle.getMessage();
            return false;
    }
    }//--------------------------------------------------------------------------
     public boolean desconectar()
    {
        try{
            if(con!=null)
                con.close();
            con=null;
            return true;
        }catch(SQLException e)
        {
            lastError= e.getMessage();
            return false;
        }
    }
    public Object [][] select(String table, String fields, String where){
      int registros = 0;  
                        
      String colname[] = fields.split(",");

      //Consultas SQL
                            //
      String q ="SELECT " + fields + " FROM " + table;
      String q2 = "SELECT count(*) as total FROM " + table;
      if(where!=null)
      {
          q+= " WHERE " + where;
          q2+= " WHERE " + where;
      }
       try{
         PreparedStatement pstm = con.prepareStatement(q2);
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
       //se crea una matriz con tantas filas y columnas que necesite
    Object[][] data = new String[registros][fields.split(",").length];
    //realizamos la consulta sql y llenamos los datos en la matriz "Object"
      try{
         PreparedStatement pstm = con.prepareStatement(q);
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            for(int j=0; j<=fields.split(",").length-1;j++){
                data[i][j] = res.getString( colname[j].trim() );
            }
            i++;         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 } 
     //---------------------------------------------------------------------------
    public boolean ingresaralsistema(String user, String contra)
    {        
                                 //nombre de la tabla
        Object[][] res = this.select("usuariosistema", " nikuser , passuser ", " nikuser='"+user+"' AND passuser='"+contra+"' ");
        if( res.length > 0)
        {
            pers.setNombre( res[0][0].toString() );
            pers.setContraseña( res[0][1].toString() );
            
            return true;
        }        
        else
            return false;
    } 
     
     //---FIN DE LA MODIFICACION MARLON---------------------------------------------------
    
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
   
  