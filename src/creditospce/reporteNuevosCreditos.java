/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;
import controlador.generaReporteNuevosCreditos;
import controlador.nuevoCreditoReporte;
import controlador.nuevoCreditoReporteEjecutivo;
import controlador.nuevoCreditoReporteJudicial;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Juan
 */
public class reporteNuevosCreditos {
    private Map solicitud=new HashMap<>();
    private final String logoTlaxcala="/reportes/icoLOGORECTOR.jpg";
    private final String logoPCET="/reportes/icoLOGOPENSIONES.jpg";
    private List<nuevoCreditoReporte> repMagisterio;
    private List<nuevoCreditoReporteEjecutivo> repEjecutivo;
    private List<nuevoCreditoReporteJudicial> repJudicial;
    private int Dependencia;
    private Date FIniProc;
    private Date FFinProc;
    
    public reporteNuevosCreditos(int Dependencia, Date FIniProc, Date FFinProc)
    {
        this.Dependencia=Dependencia;
        this.FFinProc=FFinProc;
        this.FIniProc=FIniProc;
    }
    /*
     *  0	PODER EJECUTIVO
        1	PODER LEGISLATIVO
        2	PODER JUDICIAL
        3	MAGISTERIO
        4	JUBILADOS Y PENSIONADOS
        5	PENSIONES CIVILES DEL ESTADO DE TLAXCALA
        6	MUNICIPIO DE TLAXCALA
        7	MUNICIPIO DE CHIAUTEMPAN
        8	MUNICIPIO DE APETATITLAN
        9	CAPAM
        10	DIF TLAXCALA
        11	MUNICIPIO JUAN CUAMATZI
        12	MUNICIPIO DE TEPEYANCO
        13	MUNICIPO DE ANTONIO CARBAJAL
     * 
     */
    
        public void generaSolicitud() throws JRException
    {
        generaReporteNuevosCreditos repNuevo=new generaReporteNuevosCreditos();
        solicitud.put("logoTlaxcala", this.getClass().getResourceAsStream(logoTlaxcala));
        solicitud.put("logoPCET", this.getClass().getResourceAsStream(logoPCET));
        dependencias dep = new dependencias();
        String dependencia=dep.descripcionDependencia(Dependencia); 
        Date fecha1 = new Date();
        String fecha;
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'del' YYYY");
        fecha=formateador.format(fecha1);
        solicitud.put("dependencia", dependencia);
        solicitud.put("fecha", fecha);
        
        if (Dependencia==3)
        {
            String vArchivo="/reportes/reporteNuevoCreditoMagisterio.jasper";        
            URL in=this.getClass().getResource(vArchivo);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            repMagisterio=repNuevo.generaReporteNuevosCreditosMagisterio(Dependencia,FIniProc,FFinProc);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, solicitud,new JRBeanCollectionDataSource(repMagisterio));//JREmptyDataSource
            JasperViewer.viewReport(jasperPrint, false);
        }
        if (Dependencia==0)
        {
            String vArchivo="/reportes/reporteNuevoCreditoEjecutivo.jasper";        
            URL in=this.getClass().getResource(vArchivo);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            repEjecutivo=repNuevo.generaReporteNuevosCreditosEjecutivo(Dependencia,FIniProc,FFinProc);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, solicitud,new JRBeanCollectionDataSource(repEjecutivo));//JREmptyDataSource
            JasperViewer.viewReport(jasperPrint, false);
        }
        if ((Dependencia==2)||(Dependencia==1)||(Dependencia>3))
        {
            String vArchivo="/reportes/reporteNuevoCreditoJudicial.jasper";        
            URL in=this.getClass().getResource(vArchivo);
            JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
            repJudicial=repNuevo.generaReporteNuevosCreditosJudicial(Dependencia,FIniProc,FFinProc);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, solicitud,new JRBeanCollectionDataSource(repJudicial));//JREmptyDataSource
            JasperViewer.viewReport(jasperPrint, false);
        }


        
        //JRExporter exporter = new JRPdfExporter();
        //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("./x.pdf"));
        //exporter.exportReport();
        
    }
}
