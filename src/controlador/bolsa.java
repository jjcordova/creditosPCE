/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import creditospce.conectaBase;
import creditospce.empleado;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class bolsa {
    
    public int tipoCredito;
    public double montoBolsaVerde;
    public double montoBolsaRoja;
    public double montoBolsaHipotecaria;
    public double montoVerdeActual;
    public double montoRojoActual;
    public double montoHipotecarioActual;
    public double porcentajeVerde;
    public double porcentajeRojo;
    public double porcentajeHipotecario;
    
    public bolsa()
    {
        tipoCredito=99;
        montoBolsaVerde=100.0;
        montoBolsaRoja=100.0;
        montoBolsaHipotecaria=100.0;
        montoVerdeActual=0.0;
        montoRojoActual=0.0;
        montoHipotecarioActual=0.0;
        porcentajeVerde=0.0;
        porcentajeRojo=0.0;
        porcentajeHipotecario=0.0;
    }
    
    private void montoPorcentajeUtilizado(int estatus, Date FIni, Date FFin)
    {
        estadisticasCredito estC=new estadisticasCredito();
        montoVerdeActual=estC.montoCreditosOtorgados(0, estatus, FIni, FFin);
        montoRojoActual=estC.montoCreditosOtorgados(1, estatus, FIni, FFin);
        montoHipotecarioActual=estC.montoCreditosOtorgados(2, estatus, FIni, FFin);     
        porcentajeVerde=montoVerdeActual*100/montoBolsaVerde;
        porcentajeRojo=montoRojoActual*100/montoBolsaRoja;
        porcentajeHipotecario=montoHipotecarioActual*100/montoBolsaHipotecaria;
    }
    
    public void montoBolsa()
    {
        String vQuery;
        vQuery="select * from montoBolsa";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next())
            {
                montoBolsaVerde=cbPCE.resultSet.getDouble(1);
                montoBolsaRoja=cbPCE.resultSet.getDouble(2);
                montoBolsaHipotecaria=cbPCE.resultSet.getDouble(3);
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }   
    }
    
    public void calculaPorcentajeUtilizado(int estatus, Date FIni, Date FFin)
    {
        montoBolsa();
        montoPorcentajeUtilizado(estatus,FIni, FFin);
    }
    
}
