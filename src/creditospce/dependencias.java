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
public class dependencias {
    private cgdependencias cgdepend;
    private cgdependencias[] ALCGDependencis;
    private int IdDependencia;
    private String Descripcion;  

     public cgdependencias[] catalogoDependencias( )
     {
        String vQuery;
        vQuery="select * from sectores order by IdSectores";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        int j=0;
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next() == true)
            {
                ALCGDependencis[j]=new cgdependencias();
                ALCGDependencis[j].IdDependencia=cbPCE.resultSet.getInt(1);
                ALCGDependencis[j].Descripcion=cbPCE.resultSet.getString(2);
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return ALCGDependencis;         
     }  
     
     public String descripcionDependencia(int IdDependencia)
     {
        String vQuery;
        vQuery="select * from sectores where IdSector="+IdDependencia;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        int j=0;
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next() == true)
            {
                this.IdDependencia=cbPCE.resultSet.getInt(1);
                this.Descripcion=cbPCE.resultSet.getString(2);
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return this.Descripcion;        
     }
     
     public int IdDependencia(String Descripcion)
     {
        String vQuery;
        vQuery="select * from sectores where Sector='"+Descripcion+"'";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        int j=0;
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next() == true)
            {
                this.IdDependencia=cbPCE.resultSet.getInt(1);
                this.Descripcion=cbPCE.resultSet.getString(2);
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return this.IdDependencia;        
     }     
}
