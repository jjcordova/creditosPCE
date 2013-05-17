/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class empleadoBanco {
    private int BANCO;
    private int IdEmpleado;
    private String CLABE;
    
    public empleadoBanco()
    {
        this.BANCO=99;
        this.IdEmpleado=0;
        this.CLABE="";
    }
    
    public void setEpleadoBanco(int IdEmpleado, String CLABE, int BANCO)
    {
        this.BANCO=BANCO;
        this.IdEmpleado=IdEmpleado;
        this.CLABE=CLABE;    
    }
    
    public void capturaBanco()
     {
        String vQuery;
        vQuery="insert into afiliadocuenta values (?,?,?)";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        java.util.Date today = new java.util.Date();
        try {
                PreparedStatement pst = cbPCE.connection.prepareStatement(vQuery);
                pst.setInt(1,IdEmpleado);
                pst.setString(2, CLABE);
                pst.setInt(3, BANCO);
                pst.executeUpdate();   
                cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }          
     }
    
    
    
}
