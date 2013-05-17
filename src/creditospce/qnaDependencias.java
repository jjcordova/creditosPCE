/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class qnaDependencias {
    public int Dependencia;
    public int Quincena;
    public Date FIniProc;
    public Date FFinProc;
    public Date FPago;
    public Date FEnvio;
    public Date FRecibo;
    
    public qnaDependencias()
    {
        Dependencia=0;
        FIniProc=null;
        FFinProc=null;
        FPago=null;
        FEnvio=null;
        FRecibo=null;
    }
    
    public qnaDependencias(int Dependencia, int Qna, Date FIniProc, Date FFinProc, Date FPago, Date FEnvio, Date FRecibo)
    {
        this.Dependencia=Dependencia;
        this.Quincena=Qna;
        this.FIniProc=FIniProc;
        this.FFinProc=FFinProc;
        this.FPago=FPago;
        this.FEnvio=FEnvio;
        this.FRecibo=FRecibo;    
    }
    
    public void guardaQnaDependencias()
    {
        String vQuery;
        vQuery="replace into qnaDependencia values (?,?,?,?,?,?,?)";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
                java.sql.Date fechaTabla = new java.sql.Date(FIniProc.getTime());
                PreparedStatement pst = cbPCE.connection.prepareStatement(vQuery);
                pst.setInt(1,Dependencia);
                pst.setInt(2,Quincena);
                pst.setDate(3, fechaTabla);
                fechaTabla.setTime(FFinProc.getTime());
                pst.setDate(4, fechaTabla);
                fechaTabla.setTime(FPago.getTime());
                pst.setDate(5,fechaTabla );
                fechaTabla.setTime(FEnvio.getTime());
                pst.setDate(6, fechaTabla);
                fechaTabla.setTime(FRecibo.getTime());
                pst.setDate(7, fechaTabla);
                pst.executeUpdate();   
                pst.close();
                cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }         
    }
    public boolean leerQnaDependencias(int Depen)
    {
        String vQuery;
        boolean vflag=false;
        vQuery="select * from qnaDependencia where Dependencia="+Depen;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            if (cbPCE.resultSet.next() == true)
            {
                vflag=true;
                this.Dependencia=cbPCE.resultSet.getInt(1);
                this.FIniProc=cbPCE.resultSet.getDate(2);
                this.FFinProc=cbPCE.resultSet.getDate(2);
                this.FPago=cbPCE.resultSet.getDate(2);
                this.FEnvio=cbPCE.resultSet.getDate(2);
                this.FRecibo=cbPCE.resultSet.getDate(2);                
                
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return vflag;
    }    
    
    public Date getFIniProc(int Dependencia, int Quincena)
    {
        String vQuery;
        boolean vflag=false;
        vQuery="select * from qnaDependencia where Dependencia="+Dependencia+" "
                + "and qna="+Quincena;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            if (cbPCE.resultSet.next() == true)
            {
                vflag=true;
                this.Dependencia=cbPCE.resultSet.getInt(1);
                this.FIniProc=cbPCE.resultSet.getDate(3);
                this.FFinProc=cbPCE.resultSet.getDate(4);
                this.FPago=cbPCE.resultSet.getDate(5);
                this.FEnvio=cbPCE.resultSet.getDate(6);
                this.FRecibo=cbPCE.resultSet.getDate(7);                
                
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return this.FIniProc;              
    }
    
    public Date getFFinProc(int Dependencia, int Quincena)
    {
        String vQuery;
        boolean vflag=false;
        vQuery="select * from qnaDependencia where Dependencia="+Dependencia+" "
                + "and qna="+Quincena;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            if (cbPCE.resultSet.next() == true)
            {
                vflag=true;
                this.Dependencia=cbPCE.resultSet.getInt(1);
                this.FIniProc=cbPCE.resultSet.getDate(3);
                this.FFinProc=cbPCE.resultSet.getDate(4);
                this.FPago=cbPCE.resultSet.getDate(5);
                this.FEnvio=cbPCE.resultSet.getDate(6);
                this.FRecibo=cbPCE.resultSet.getDate(7);                
                
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return this.FFinProc;              
    }   
    
}
