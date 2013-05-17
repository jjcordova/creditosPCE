/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Juan
 */
public class nuevoCreditoReporteEjecutivo {
    public String rfc;
    public String rfccom;
    public int concepto;
    public double abonocapital; //descuento quincenal
    public double capitotal; //cantidad total a descontar
    public double importepordescontar; //cantidad total a descontar
    public int quincenasadescontar; //quincenas que dura el credito
    public int quincenasdescontadas; //quincenas q restan por descontar
    public String fechainicio;//fecha de inicio de descuento
    public String estatus; //estado del descuento

    nuevoCreditoReporteEjecutivo(String rfc,String rfccom,int concepto,
            double abonocapital,double capitotal,double importepordescontar,
            int quincenasadescontar,int quincenasdescontadas,String fechainicio,
            String estatus)
    {
        this.rfc=rfc;
        this.rfccom=rfccom;
        this.concepto=concepto;
        this.abonocapital=abonocapital; //descuento quincenal
        this.capitotal=capitotal; //cantidad total a descontar
        this.importepordescontar=importepordescontar; //cantidad total a descontar
        this.quincenasadescontar=quincenasadescontar; //quincenas que dura el credito
        this.quincenasdescontadas=quincenasdescontadas; //quincenas q restan por descontar
        this.fechainicio=fechainicio;//fecha de inicio de descuento
        this.estatus=estatus; //estado del descuento    
    }

    nuevoCreditoReporteEjecutivo() {
        
    }
    public String getrfc()
    {
        return rfc;
    }
    public String getrfccom()
    {
        return rfccom;
    }
    public int getconcepto()
    {
        return concepto;
    }
    public double getabonocapital()
    {
        return abonocapital;
    }
    public double getcapitotal()
    {
        return capitotal;
    }//cantidad total a descontar
    public double getimportepordescontar()
    {
        return importepordescontar;
    }//cantidad total a descontar
    public int getquincenasadescontar()
    {
        return quincenasadescontar;
    }
    public int getquincenasdescontadas()
    {
        return quincenasadescontar;
    }
    public String getfechainicio()
    {
        return fechainicio;
    }
    public String getestatus()
    {
        return estatus;
    }
    public void setrfc(String rfc)
    {
        this.rfc=rfc;
        
    }
    public void setrfccom(String rfccom)
    {
        this.rfccom=rfccom;
        
    }
    public void setconcepto(int concepto)
    {
        this.concepto=concepto;
    
    }
    public void setabonocapital(double abonocapital)
    {
        this.abonocapital=abonocapital; //descuento quincenal
   
    }//descuento quincenal
    public void setcapitotal(double capitotal)
    {
        this.capitotal=capitotal; //cantidad total a descontar
   
    }
    public void setimportepordescontar(double importepordescontar)
    {
        this.importepordescontar=importepordescontar; //cantidad total a descontar
    
    }
    public void setquincenasadescontar(int quincenasadescontar)
    {
        this.quincenasadescontar=quincenasadescontar; //quincenas que dura el credito
     
    }
    public void setquincenasdescontadas(int quincenasdescontadas)
    {
        this.quincenasdescontadas=quincenasdescontadas; //quincenas q restan por descontar
        
    }
    public void setfechainicio(String fechainicio)
    {
        this.fechainicio=fechainicio;//fecha de inicio de descuento
 
    }
    public void setestatus(String estatus)
    {
        this.estatus=estatus; //estado del descuento        
    }
}