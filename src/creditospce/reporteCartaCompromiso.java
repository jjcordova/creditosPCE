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
public class reporteCartaCompromiso {
public Map solicitud;
private final String logoTlaxcala="/reportes/icoLOGORECTOR.jpg";
private final String logoPCET="/reportes/icoLOGOPENSIONES.jpg";

    public reporteCartaCompromiso()
    {
        
        //pagosQuincenales=l; 
    }
    //i=tipo de credito (verde, rojo, hipotecario), tp=tipo de empleado (jubiado, empleado)
    // Map s datos que se pasan a la plantilla
    public void generaSolicitud(Map s, int i,int tp, int av) throws JRException
    {
        solicitud=s;
        solicitud.put("logoTlaxcala", this.getClass().getResourceAsStream(logoTlaxcala));
        solicitud.put("logoPCET", this.getClass().getResourceAsStream(logoPCET));
        
        String vArchivo="";
        //tipo empleado
        // 1-5 Servidor Publico
        // 6 Jubilado
        // 7-13 Pensionado
        if (i==0 && ((tp>=6)&&(tp<=13))) { vArchivo="/reportes/CartaCompromisoVerdePensionado.jasper";} //Verde Jubilado
        if (i==0 && ((tp>=1)&&(tp<=5))) { vArchivo="/reportes/CartaCompromisoVerde.jasper";} //Verde Empleado
        if (i==1 && ((tp>=6)&&(tp<=13))) { vArchivo="/reportes/CartaCompromisoVerdePensionado.jasper"; } //Rojo Jubilado, no necesita aval
        if (i==1 && ((tp>=1)&&(tp<=5))&&((av>=1)&&(av<=5))) { vArchivo="/reportes/CartaCompromisoRojoServidorServidor.jasper"; } //Rojo Empleado Empleado
        if (i==1 && ((tp>=1)&&(tp<=5))&&((av>=6)&&(av<=13))) { vArchivo="/reportes/CartaCompromisoRojoServidorJubilado.jasper"; } //Rojo Empleado Jubilado
        //if (i==1 && ((tp>=6)&&(tp<=13))&&((av>=1)&&(av<=5))) { vArchivo="/reportes/CartaCompromisoRojoJubiladoServidor.jasper"; } //Rojo Empleado Empleado        
        //if (i==1 && ((tp>=6)&&(tp<=13))&&((av>=6)&&(av<=13))) { vArchivo="/reportes/CartaCompromisoRojoJubiladoJubilado.jasper"; } //Rojo Empleado Empleado        
        if (i==2) { vArchivo="/reportes/CartaCompromisoHipotecario.jasper";} //Hipotecario
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
