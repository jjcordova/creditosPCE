/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import creditospce.conectaBase;
import creditospce.creditoReporte;
import creditospce.empleado;
import creditospce.pago;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
//se cambio fecha de captura por fecha de dispersión 08/04/2013
public class generaReporteNuevosCreditos {
    private LinkedList<nuevoCreditoReporte> repMagisterio;
    private LinkedList<nuevoCreditoReporteEjecutivo> repEjecutivo;
    private LinkedList<nuevoCreditoReporteJudicial> repJudicial;
    private int Dependencia;
    private Date FIniProc;
    private Date FFinProc;
    /*
            public String rfc;
            public String noempleado;
            public int concepto;
            public double captotal;
            public double inttotal;
            public double abonocapital; //descuento quincenal
            public double abonointeres;
            public double saldocapital;
            public double saldointeres;
            public int quincena; 
            public int qnaaplica; //quincena de inicio del credito
            public String estado;
     */
    //genera listado de nuevos creditos otorgados a magisterio
    public LinkedList<nuevoCreditoReporte> generaReporteNuevosCreditosMagisterio(int Dependencia, Date FIniProc, Date FFinProc)
    {
        String vQuery, SFini, SFFin;
        Date fecha;        
        LinkedList<nuevoCreditoReporte> listaNCM = new LinkedList<>();
        String estatus="5"; //estatus de credito dispersado y aun no inicia a cobrar
        int tc=0, plazo=0, concepto=0, ncol=0, ni=0;
        double taza=(double)0.20/24;
        double totalMonto=0.0;
        pago pagoC = new pago();
        SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");  
        SFini=sdf.format(FIniProc);
        SFFin=sdf.format(FFinProc);
        //preguntar que fecha es la que se muestra en el reporte
        vQuery="select a.RFC, a.NoEmpleado, c.idcredito, c.montoa, c.aportacionq,"
                + " c.fdispercion from credito c, afiliados a  "
                + "where c.idEmpleado=a.IdAfil and c.estaus="+estatus+" "
                + "and c.fdispercion >= '"+SFini+"' AND c.fdispercion <= '"+SFFin+"' ";
        vQuery=vQuery+ " and a.IdSector="+Dependencia+" ";
        vQuery=vQuery+ " order by a.IdSector, c.idcredito, c.ano, c.ncredito";

        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            cbPCE.resultSet.last();
            ncol=cbPCE.resultSet.getRow();
            cbPCE.resultSet.beforeFirst();            
            nuevoCreditoReporte[] ncRM = new nuevoCreditoReporte[ncol];
            while (cbPCE.resultSet.next() == true)
            {
                
                ncRM[ni]=new nuevoCreditoReporte();
                ncRM[ni].rfc=cbPCE.resultSet.getString(1);
                ncRM[ni].noempleado=cbPCE.resultSet.getString(2);
                //numero de concepto asignado en su sistema de nomina (123 credito rojo, 122 credito verde)
                tc=cbPCE.resultSet.getInt(3);
                if (tc==0)
                {
                    plazo=24;
                    concepto=122;
                }
                if (tc==1)
                {
                    plazo=72;
                    concepto=123;
                }
                if (tc==2)
                {
                    plazo=360;
                    concepto=124;
                }   
                totalMonto=pagoC.totalaPagar(cbPCE.resultSet.getDouble(4),taza,plazo);
                ncRM[ni].concepto=cbPCE.resultSet.getInt(3);
                //es el importe total del credito ( importe + interes)
                ncRM[ni].captotal=totalMonto;
                ncRM[ni].inttotal=0.0;//sin dato
                //es el importe del descuento (se envia el importe de mensual del descuento)
                ncRM[ni].abonocapital=cbPCE.resultSet.getDouble(5)*2;
                ncRM[ni].abonointeres=0.0;//sin dato
                ncRM[ni].saldocapital=cbPCE.resultSet.getDouble(4);
                ncRM[ni].saldointeres=0.0;//sin dato
                //quincenas totales a descontar, depende del tipo de credito
                ncRM[ni].quincena=plazo;
                //quincena de inicio de aplicación ejem 201301
                calculaQuincena qna = new calculaQuincena();
                fecha=new Date(cbPCE.resultSet.getDate(6).getTime());
                
                //quincena=qna.getquincena(cbPCE.resultSet.getInt(11));
                ncRM[ni].qnaaplica=qna.getquincena(fecha);
                
                ncRM[ni].estado="A";
                listaNCM.add(ncRM[ni]);   
                ni=ni+1;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }     
        repMagisterio=listaNCM;
        return repMagisterio;
    }
    
    /*
     *      public String rfc;
            public String rfccom;
            public int concepto;
            public double abonocapital; //descuento quincenal
            public double capitotal; //cantidad total a descontar
            public double importepordescontar; //cantidad total a descontar
            public int quincenasadescontar; //quincenas que dura el credito
            public int quincenasdescontadas; //quincenas q restan por descontar
            public String fechainicio;//fecha de inicio de descuento
            public String estatus; //estado del descuento
     */
    public LinkedList<nuevoCreditoReporteEjecutivo> generaReporteNuevosCreditosEjecutivo(int Dependencia, Date FIniProc, Date FFinProc)
    {
        String vQuery, SFini, SFFin;
        LinkedList<nuevoCreditoReporteEjecutivo> listaNCE = new LinkedList<>();
        String estatus="5"; //estatus de credito dispersado y aun no inicia a cobrar
        int tc=0, plazo=0, concepto=0, ncol=0, ni=0;
        double taza=(double)0.20/24;
        double totalMonto=0.0;
        pago pagoC = new pago();
        SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");  
        SFini=sdf.format(FIniProc);
        SFFin=sdf.format(FFinProc);
        
        //preguntar que fecha es la que se muestra en el reporte
        vQuery="select a.RFC, a.RFCCom, c.idcredito, c.aportacionq, c.montoa,"
                + " c.fdispercion from credito c, afiliados a  "
                + "where c.idEmpleado=a.IdAfil and c.estaus="+estatus+" "
                + "and c.fdispercion >= '"+SFini+"' AND c.fdispercion <= '"+SFFin+"' ";
        vQuery=vQuery+ " and a.IdSector="+Dependencia+" ";
        vQuery=vQuery+ " order by a.IdSector, c.idcredito, c.ano, c.ncredito";

        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            cbPCE.resultSet.last();
            ncol=cbPCE.resultSet.getRow();
            cbPCE.resultSet.beforeFirst(); 
            nuevoCreditoReporteEjecutivo[] ncRM = new nuevoCreditoReporteEjecutivo[ncol];
            while (cbPCE.resultSet.next() == true)
            {
                ncRM[ni] = new nuevoCreditoReporteEjecutivo();
                ncRM[ni].rfc=cbPCE.resultSet.getString(1);
                ncRM[ni].rfccom=cbPCE.resultSet.getString(2);
                //numero de concepto asignado en su sistema de nomina (107 credito rojo, 106 credito verde)
                //if concepto
                tc=cbPCE.resultSet.getInt(3);
                if (tc==0)
                {
                    plazo=24;
                    concepto=106;
                }
                if (tc==1)
                {
                    plazo=72;
                    concepto=107;
                }
                if (tc==2)
                {
                    plazo=360;
                    concepto=108;
                }       
                totalMonto=pagoC.totalaPagar(cbPCE.resultSet.getDouble(4),taza,plazo);
                ncRM[ni].concepto=concepto;
                //es el importe del descuento quincenal
                ncRM[ni].abonocapital=cbPCE.resultSet.getDouble(4);
                //es el importe total del credito ( importe + interes)
                ncRM[ni].capitotal=totalMonto;
                //es el importe total del credito ( importe + interes)
                ncRM[ni].importepordescontar=totalMonto;                
                ncRM[ni].quincenasadescontar=plazo;//sin dato
                ncRM[ni].quincenasdescontadas=0;
                ncRM[ni].estatus="A";
                listaNCE.add(ncRM[ni]);   
                ni=ni+1;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }     
        repEjecutivo=listaNCE;        
        return repEjecutivo;
    }
    public LinkedList<nuevoCreditoReporteJudicial> generaReporteNuevosCreditosJudicial(int Dependencia, Date FIniProc, Date FFinProc)
    {
        String vQuery, SFini, SFFin;
        LinkedList<nuevoCreditoReporteJudicial> listaNCE = new LinkedList<>();
        String estatus="5"; //estatus de credito dispersado y aun no inicia a cobrar
        int tc=0, plazo=0, concepto=0, ncol=0, ni=0;
        double taza=(double)0.20/24;
        double totalMonto=0.0;
        pago pagoC = new pago();
        SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");  
        SFini=sdf.format(FIniProc);
        SFFin=sdf.format(FFinProc);
        //preguntar que fecha es la que se muestra en el reporte
        vQuery="select a.RFC, a.RFCCom, c.idcredito, c.aportacionq, c.montoa,"
                + " c.fdispercion from credito c, afiliados a  "
                + "where c.idEmpleado=a.IdAfil and c.estaus="+estatus+" "
                + "and c.fdispercion >= '"+SFini+"' AND c.fdispercion <= '"+SFFin+"' ";
        vQuery=vQuery+ " and a.IdSector="+Dependencia+" ";
        vQuery=vQuery+ " order by a.IdSector, c.idcredito, c.ano, c.ncredito";
        
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            cbPCE.resultSet.last();
            ncol=cbPCE.resultSet.getRow();
            cbPCE.resultSet.beforeFirst();             
            nuevoCreditoReporteJudicial[] ncRM = new nuevoCreditoReporteJudicial[ncol];
            while (cbPCE.resultSet.next() == true)
            {
                ncRM[ni] = new nuevoCreditoReporteJudicial();    
                ncRM[ni].rfc=cbPCE.resultSet.getString(1);
                ncRM[ni].paterno=cbPCE.resultSet.getString(2);
                ncRM[ni].materno=cbPCE.resultSet.getString(3);
                ncRM[ni].nombre=cbPCE.resultSet.getString(4);
                //numero de concepto asignado en su sistema de nomina (107 credito rojo, 106 credito verde)
                //if concepto
                tc=cbPCE.resultSet.getInt(5);
                if (tc==0)
                {
                    plazo=24;
                    concepto=106;
                }
                if (tc==1)
                {
                    plazo=72;
                    concepto=107;
                }
                if (tc==2)
                {
                    plazo=360;
                    concepto=108;
                }  
                totalMonto=pagoC.totalaPagar(cbPCE.resultSet.getDouble(4),taza,plazo);
                ncRM[ni].concepto=concepto;
                //es el importe del descuento quincenal
                ncRM[ni].abonocapital=cbPCE.resultSet.getDouble(4);
                //es el importe total del credito ( importe + interes)
                ncRM[ni].captotal=totalMonto;                
                ncRM[ni].numeroquincenas=plazo;//sin dato
                listaNCE.add(ncRM[ni]);    
                ni=ni+1;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }     
        repJudicial=listaNCE;
        return repJudicial;
    }
}
