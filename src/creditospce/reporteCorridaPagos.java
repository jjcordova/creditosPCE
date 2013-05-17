/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;
import java.net.URL;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Juan
 */
public class reporteCorridaPagos {
    public Map solicitud;
    private final String logoTlaxcala="/reportes/icoLOGORECTOR.jpg";
    private final String logoPCET="/reportes/icoLOGOPENSIONES.jpg";

    public List<pagoQuincenal> pagosQuincenales;
    public reporteCorridaPagos(Map s, List l)
    {
        solicitud=s;
        pagosQuincenales=l; 
    }

    public reporteCorridaPagos() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
    
    public void generaSolicitud(int i) throws JRException
    {
        solicitud.put("logoTlaxcala", this.getClass().getResourceAsStream(logoTlaxcala));
        solicitud.put("logoPCET", this.getClass().getResourceAsStream(logoPCET));
        
        String vArchivo="";
        if (i==0) {
            vArchivo="/reportes/reporteCorridaPagos.jasper";
            
        }
        if (i==1) {
            vArchivo="/reportes/solicitudCreditoR.jasper";
        }
        if (i==2) {
            vArchivo="/reportes/solicitudCreditoH.jasper";
        }
        URL in=this.getClass().getResource(vArchivo);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, solicitud,new JRBeanCollectionDataSource(pagosQuincenales));//JREmptyDataSource

    JRExporter exporter = new JRPdfExporter();
    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
    //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("./x.pdf"));
    //exporter.exportReport();
    JasperViewer.viewReport(jasperPrint, false);
    }

    void generaSolicitud(Map solicitudCV) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}    