/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;
import java.net.URL;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Juan
 */
public class reporteContratoVerdeJubilado {
    public Map solicitud;
    private final String logoTlaxcala="/reportes/icoLOGORECTOR.jpg";
    private final String logoPCET="/reportes/icoLOGOPENSIONES.jpg";
/**
 * 
 * @param contrato
 * @param tipoCredito
 * @param tipoEmpleado
 * @throws JRException 
 * nombre
 * paterno
 * materno
 * Numerocontrato
 * Tiposolicitante
 * edad
 * identificacion
 * edocivil
 * domicilio
 * localidad
 * municipio
 * estado
 * importe
 * importeletra
 * importedescuento
 * importedescuentoletra
 * nombreT1
 * paternoT1
 * maternoT1
 * edadT1
 * identificacionT1
 * edocivilT1
 * domicilioT1
 * localidadT1
 * municipioT1
 * estadoT1
 * ocupacionT1
 * nombreT2
 * paternoT2
 * maternoT2
 * edadT2
 * identificacionT2
 * edocivilT2
 * domicilioT2
 * localidadT2
 * municipioT2
 * estadoT2
 * ocupacionT2
 * numcuenta
 * numclabe
 * banco
 * numcheque
 * cp
 * fechaletra
 */
public void generaSolicitud(Map contrato, int tipoCredito,int tipoEmpleado) throws JRException
    {
        solicitud=contrato;
        solicitud.put("logoTlaxcala", this.getClass().getResourceAsStream(logoTlaxcala));
        solicitud.put("logoPCET", this.getClass().getResourceAsStream(logoPCET));
        
        String vArchivo="";
        //tipoEmpleado
        // 1-5 Servidor Publico
        // 6 Jubilado
        // 7-13 Pensionado
        if (tipoCredito==0 && ((tipoEmpleado>=6)&&(tipoEmpleado<=13))) { vArchivo="/reportes/ContratoVerdeJubiladoPensionado.jasper";} //Verde Jubilado
        if (tipoCredito==0 && ((tipoEmpleado>=1)&&(tipoEmpleado<=5))) {  vArchivo="/reportes/ContratoVerdeServidorPublico.jasper";} //Verde Empleado
        if (tipoCredito==1 && ((tipoEmpleado>=6)&&(tipoEmpleado<=13))) { vArchivo="/reportes/CartaCompromisoVerdePensionado.jasper"; } //Rojo Jubilado
        if (tipoCredito==1 && ((tipoEmpleado>=1)&&(tipoEmpleado<=5))) { vArchivo="/reportes/CartaCompromisoRojoServidorServidor.jasper"; } //Rojo Empleado Empleado
        //if (i==1 && ((tp>=6)&&(tp<=13))&&((av>=1)&&(av<=5))) { vArchivo="/reportes/CartaCompromisoRojoJubiladoServidor.jasper"; } //Rojo Empleado Empleado        
        //if (i==1 && ((tp>=6)&&(tp<=13))&&((av>=6)&&(av<=13))) { vArchivo="/reportes/CartaCompromisoRojoJubiladoJubilado.jasper"; } //Rojo Empleado Empleado        
        if (tipoCredito==2) { vArchivo="/reportes/CartaCompromisoHipotecario.jasper";} //Hipotecario
        URL in=this.getClass().getResource(vArchivo);
        JasperReport reporte = (JasperReport) JRLoader.loadObject(in);
        JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, solicitud,new JREmptyDataSource());//new JRBeanCollectionDataSource(pagosQuincenales)
        //JRExporter exporter = new JRPdfExporter();
        //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        //exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("./x.pdf"));
        //exporter.exportReport();
        JasperViewer.viewReport(jasperPrint, false);
    }
}
