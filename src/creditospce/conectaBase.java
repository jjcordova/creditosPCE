/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Juan
 */

public class conectaBase {
    public Statement statement;
    public ResultSet resultSet;
    
    //static final String DATABASE_URL="jdbc:mysql://192.168.1.2/pensionesciviles";
    //static final String USUARIO="Credito";//
    //static final String PASSWORD="creditosistema";//  
    static final String USUARIO="root";//"Credito";//
    static final String PASSWORD="hijo";//"creditosistema";//
    static final String DATABASE_URL="jdbc:mysql://127.0.0.1/pce";
  
    public Connection connection;
    
    public conectaBase() {}
    @SuppressWarnings("CallToThreadDumpStack")
    public void conecta()
    {
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(DATABASE_URL,USUARIO,PASSWORD);       
          
    }
    catch (ClassNotFoundException | SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }   
    
    public void cierra()
    {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(conectaBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public boolean accesoUsuario(String usuariox, String passwordx)
   {
       
       boolean vsalida;
       String vQuery="";
       vsalida=false;
        try {   
            Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(DATABASE_URL,USUARIO,PASSWORD); 
            statement = connection.createStatement();
        vQuery="select IdUsuario from usuarios  where IdUsuario="+usuariox+" and Password='"+passwordx+"'";
        resultSet = statement.executeQuery(vQuery);
        //resultSet.next();
        if (resultSet.next() ) {
                vsalida=true;
            }        
       } catch (ClassNotFoundException ex) {
            Logger.getLogger(conectaBase.class.getName()).log(Level.SEVERE, null, ex);
        }
       catch (SQLException sqlException)
       {
           sqlException.printStackTrace();
       }
        return vsalida;
   }
   
   

}
