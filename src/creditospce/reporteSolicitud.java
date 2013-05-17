/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;

import java.util.List;
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
public class reporteSolicitud {
    public Map solicitud;
    public List<pagoQuincenal> pagosQuincenales;
    reporteSolicitud(Map s)
    {
        solicitud=s;
        //pagosQuincenales=l; 
    }

    reporteSolicitud() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
    
    public void generaSolicitud(int i) throws JRException
    {
        String vArchivo="";
        if (i==0) {
            vArchivo="solicitudCredito.jasper";
            
        }
        if (i==1) {
            vArchivo="solicitudCreditoR.jasper";
        }
        if (i==2) {
            vArchivo="solicitudCreditoH.jasper";
        }
        JasperReport reporte = (JasperReport) JRLoader.loadObject(vArchivo);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, solicitud,new JREmptyDataSource());//new JRBeanCollectionDataSource(pagosQuincenales)
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("./x.pdf"));
        exporter.exportReport();
        JasperViewer.viewReport(jasperPrint, false);
    }

    void generaSolicitud(Map solicitudCV) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
    
}
