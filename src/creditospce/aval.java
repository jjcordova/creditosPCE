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
public class aval {
    private int IDAVAL;
    private int IDAFILIADO;
    private int IdCredito;
    private int NCredito;
    private int ano;
    private double Montoa; //monto sugerido
    private double Aportacion;
    
    aval()
    {
        this.IDAVAL=0;
        this.IDAFILIADO=0;
        this.IdCredito=0;
        this.NCredito=0;
        this.ano=0;
        this.Montoa=0; //monto sugerido
        this.Aportacion=0;    
    }
    
    aval(int IDAVAL)
    {
        this.IDAVAL=IDAVAL;
    }
    
    
public boolean existeAval()
     {
        String vQuery;
        boolean vflag=false;
        //Estatus =0 , credito concluido pagado.
        vQuery="select * from credito where idAval="+IDAVAL+" and estaus=1";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            if (cbPCE.resultSet.next() == true)
            {
                vflag=true;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return vflag;         
     }   
     
     public boolean existeAvalesOld()
     {
        String vQuery;
        boolean vflag=false;
        vQuery=""+IDAVAL;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            if (cbPCE.resultSet.next() == true)
            {
                vflag=true;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return vflag;         
     }  
     
     public boolean avalOldPrestamo()
     {
        String vQuery;
        boolean vflag=false;
        vQuery="select a.*, p.totalcapital, p.pagocapital+p.pagointeres as descuento"
                + " from avales a, prestamos p where a.TipoAval=0 and a.IdAfilAvalado=p.IdAfil "
                + "and a.refprestamo=p.refprestamo and and p.IdEstatusPrestamo in (0,1) "
                + "and a.idAfil="+IDAVAL;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            if (cbPCE.resultSet.next() == true)
            {
                vflag=true;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return vflag;                  
     }
     
     public boolean avalprestamo()
     {
        String vQuery;
        boolean vflag=false;
        //Estatus =0 , credito concluido pagado.
        vQuery="select * from credito where idAval="+IDAVAL+" and estaus=1";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            if (cbPCE.resultSet.next() == true)
            {
                vflag=true;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return vflag;         
     }             
    
    
}
