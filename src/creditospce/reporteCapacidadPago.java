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
public class reporteCapacidadPago {
    public Map solicitud;
    private final String logoTlaxcala="/reportes/icoLOGORECTOR.jpg";
    private final String logoPCET="/reportes/icoLOGOPENSIONES.jpg";
    public reporteCapacidadPago()
    {
        
    }
    //tp=0 EMPLEADO; tp=1 AVAL
    public void generaSolicitud(Map s, int tp) throws JRException
    {
        solicitud=s;
        String vArchivo="/reportes/DictamenCapacidadPago.jasper";
        solicitud.put("logoTlaxcala", this.getClass().getResourceAsStream(logoTlaxcala));
        solicitud.put("logoPCET", this.getClass().getResourceAsStream(logoPCET));
        //Map.Entry()
        if (tp==0){ vArchivo="/reportes/DictamenCapacidadPago.jasper";}
        if (tp==1){ vArchivo="/reportes/DictamenCapacidadPagoAval.jasper";}
        URL in=this.getClass().getResource(vArchivo);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, solicitud,new JREmptyDataSource());//JREmptyDataSource
        JRExporter exporter = new JRPdfExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("./x.pdf"));
        exporter.exportReport();
        JasperViewer.viewReport(jasperPrint, false);
    }
}
