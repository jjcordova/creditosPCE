/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Juan
 */
public class bcgcredito {
    public cgcredito[] cgcreditos;
    public boolean consutlaCreditosID()
    {
        String vQuery;
        boolean vflag=false;
        int i=0;
        vQuery="select * from cgcredito";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            cgcredito[] cgc = new cgcredito[3]; 
            while (cbPCE.resultSet.next()== true)
            {
                cgc[i] = new cgcredito(cbPCE.resultSet.getInt(1),cbPCE.resultSet.getString(2),cbPCE.resultSet.getInt(3),cbPCE.resultSet.getDouble(4),cbPCE.resultSet.getString(5));
                vflag=true;
                i=i+1;
            }
            cbPCE.cierra();
            cgcreditos=cgc;
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
              
        } 
        return vflag;
    } 
    
}
