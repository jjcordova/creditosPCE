/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;

import java.net.URL;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Juan
 */
public class reportePagare {
    public Map solicitud;
    private final String logoTlaxcala="/reportes/icoLOGORECTOR.jpg";
    private final String logoPCET="/reportes/icoLOGOPENSIONES.jpg";
    public reportePagare(Map s)
    {
        solicitud=s;
        //pagosQuincenales=l; 
    }
    public void generaSolicitud(int i,int te) throws JRException
    {
        solicitud.put("logoTlaxcala", this.getClass().getResourceAsStream(logoTlaxcala));
        solicitud.put("logoPCET", this.getClass().getResourceAsStream(logoPCET));        
        String vArchivo="";
        if (i==0) {
            vArchivo="/reportes/PagareVerde.jasper";
            
        }
        if ((i==1)&&((te>=1)&&(te<=5))) {
            vArchivo="/reportes/PagareRojoServidor.jasper";
        }
        if ((i==1)&&(te>=6)) {
            vArchivo="/reportes/PagareVerde.jasper";
        }
        if (i==2) {
            vArchivo="/reportes/PagareHipotecario.jasper";
        }
        URL in=this.getClass().getResource(vArchivo);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, solicitud,new JREmptyDataSource());//new JRBeanCollectionDataSource(pagosQuincenales)
    JRExporter exporter = new JRPdfExporter();
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("./x.pdf"));
    exporter.exportReport();
    JasperViewer.viewReport(jasperPrint, false);
    }    
}
