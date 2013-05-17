/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import creditospce.conectaBase;
import creditospce.credito;
import creditospce.creditoReporte;
import creditospce.empleado;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class estadisticasCredito {
    private int tipoCredito;
    private Date FIniCredito;
    private Date FFinCredito;
    
    
    //se despliegan los creditos que se han otorgado durante un periodo del 
    //un año en curso, dependiendo el estatus    
    public Map<Integer,Double> totalCreditosOtorgados(int tipoCredito, int estatus)
    {
        int totalC=0;
        double totalM=0.0;
        Map <Integer,Double> totalCO = new HashMap<Integer,Double>();
        String vQuery;
        Date fechaActual;
        fechaActual=new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy");
        String sano = formateador.format(fechaActual);
        int ano=Integer.valueOf(sano);
        vQuery="select count(*), sum(montoa) from credito where idcredito="+tipoCredito+" and ano="+ano+" and estaus="+estatus;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next() == true)
            {
                totalC=cbPCE.resultSet.getInt(1);
                totalM=cbPCE.resultSet.getDouble(2);
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }   
        totalCO.put(totalC, totalM); 
        return totalCO;
    }
    
    
    //se da el total de creditos, dependiendo el estatus
     public Map<Integer,Double> creditosOtorgados(int tipoCredito, int estatus, Date FIni, Date FFin)
    {
        String vQuery, SFini, SFFin;
        int totalC=0;
        String STipoCredito="";
        double totalM=0.0;
        Map <Integer,Double> totalCO = new HashMap<Integer,Double>();
        int ncol, ni=0;
        java.sql.Date timestamp;
        SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");  
        SFini=sdf.format(FIni);
        SFFin=sdf.format(FFin);
        //si dependencia es 99, etonces regresamos todas las dependencias
        vQuery="select count(*), sum(montoa) from credito where idcredito="+tipoCredito+" "
                + "and estaus="+estatus+" "
                + "and fdispercion >= '"+SFini+"' AND fdispercion <= '"+SFFin+"'";
       
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            cbPCE.resultSet.last();
            ncol=cbPCE.resultSet.getRow();
            cbPCE.resultSet.beforeFirst();
            while (cbPCE.resultSet.next() == true)
            {
                totalC=cbPCE.resultSet.getInt(1);
                totalM=cbPCE.resultSet.getDouble(2);
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        totalCO.put(totalC, totalM); 
        return totalCO;
    }    

    //se da el total de creditos, dependiendo el estatus
     public Double montoCreditosOtorgados(int tipoCredito, int estatus, Date FIni, Date FFin)
    {
        String vQuery, SFini, SFFin;
        int totalC=0;
        double totalM=0.0;
        SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");  
        SFini=sdf.format(FIni);
        SFFin=sdf.format(FFin);
        //si dependencia es 99, etonces regresamos todas las dependencias
        vQuery="select count(*), sum(montoa) from credito where idcredito="+tipoCredito+" "
                + "and estaus="+estatus+" "
                + "and fdispercion >= '"+SFini+"' AND fdispercion <= '"+SFFin+"'";
       
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next() == true)
            {
                totalC=cbPCE.resultSet.getInt(1);
                totalM=cbPCE.resultSet.getDouble(2);
            }
            cbPCE.cierra();
        } 
        catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return totalM;
    }  
     
     public creditoReporte[] reportecreditosOtorgados(int tipoCredito, int estatus, Date FIni, Date FFin)
    {
        String vQuery, SFini, SFFin;
        creditoReporte[] ACreditos = null;
        int ncol, ni=0;
        SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");  
        SFini=sdf.format(FIni);
        SFFin=sdf.format(FFin);
        //si dependencia es 99, etonces regresamos todas las dependencias
        vQuery="select c.*, a.Paterno, a.Materno, a.Nombres, a.IdSector from credito c, afiliados a"
                + " where c.idEmpleado=a.IdAfil and c.idcredito="+tipoCredito+" "
                + "and c.estaus="+estatus+" "
                + "and c.fcaptura >= '"+SFini+"' AND c.fcaptura <= '"+SFFin+"'";
       
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            cbPCE.resultSet.last();
            ncol=cbPCE.resultSet.getRow();
            cbPCE.resultSet.beforeFirst();
            ACreditos = new creditoReporte[ncol];
            while (cbPCE.resultSet.next() == true)
            {
                ACreditos[ni] = new creditoReporte();
                ACreditos[ni].IdCredito=cbPCE.resultSet.getInt(1);
                ACreditos[ni].ano=cbPCE.resultSet.getInt(2);
                ACreditos[ni].NCredito=cbPCE.resultSet.getInt(3);
                ACreditos[ni].IdEmpleado=cbPCE.resultSet.getInt(4);
                ACreditos[ni].IdAval=cbPCE.resultSet.getInt(5);
                ACreditos[ni].Montos=cbPCE.resultSet.getDouble(6);
                ACreditos[ni].Montoa=cbPCE.resultSet.getDouble(7);
                ACreditos[ni].Aportacion=cbPCE.resultSet.getDouble(8);
                ACreditos[ni].FCaptura=cbPCE.resultSet.getDate(9);
                ACreditos[ni].IdCapturista=cbPCE.resultSet.getInt(10);
                ACreditos[ni].Estatus=cbPCE.resultSet.getInt(11);
                ACreditos[ni].FValidacion=cbPCE.resultSet.getDate(12);
                ACreditos[ni].FDispercion=cbPCE.resultSet.getDate(13);
                ACreditos[ni].FDescuento=cbPCE.resultSet.getDate(14);
                ACreditos[ni].paterno=cbPCE.resultSet.getString(15);
                ACreditos[ni].materno=cbPCE.resultSet.getString(16);
                ACreditos[ni].nombre=cbPCE.resultSet.getString(17);
                ACreditos[ni].IdSector=cbPCE.resultSet.getInt(18);
                ni=ni+1;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return ACreditos;
    }        
    
}
