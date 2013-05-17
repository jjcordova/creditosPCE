/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Juan
 */
public class nuevoCreditoReporteJudicial {
    
    public int concepto;
    public String rfc;
    public String paterno;
    public String materno;
    public String nombre;
    public double captotal;//capital total a pagar
    public double abonocapital; //descuento quincenal
    public int numeroquincenas; //numero de quincenas q se aplica el descuento
    nuevoCreditoReporteJudicial(int concepto, String rfc, String paterno, 
            String materno, String nombre, Double captotal, Double abonocapital, 
            int numeroquincenas)
    {
       this.abonocapital=abonocapital;
       this.captotal=captotal;
       this.concepto=concepto;
       this.materno=materno;
       this.nombre=nombre;
       this.numeroquincenas=numeroquincenas;
       this.paterno=paterno;
       this.rfc=rfc;
    }

    nuevoCreditoReporteJudicial() {
        
    }
    public void setConcepto(int concepto)
    {
    this.concepto=concepto;
    }
    public int getConcepto()
    {
    return concepto;
    }
    public void setRfc(String rfc)
    {
        this.rfc=rfc;
    }
    public String getRfc( )
    {
        return rfc;
    }    
    public void setPaterno(String paterno)
    {
        this.paterno=paterno;
    }
    public String getPaterno( )
    {
        return paterno;
    }    
    public void setMaterno(String materno)
    {
        this.materno=materno;
    }
    public String getMaterno( )
    {
        return materno;
    }    
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
    public String getNombre()
    {
        return nombre;
    }    
    public void setNumeroquincenas(int numeroquincenas)
    {
        this.numeroquincenas=numeroquincenas;
    }
    public int getNumeroquincenas()
    {
        return numeroquincenas;
    }    
    public void setcaptotal(double captotal)
    {
        this.captotal=captotal;
    }
     public double getcaptotal()
    {
        return captotal;
    }   
    public void setabonocapital(double abonocapital)
    {
        this.abonocapital=abonocapital;
    }
    public double getabonocapital()
    {
        return abonocapital;
    }    
}
