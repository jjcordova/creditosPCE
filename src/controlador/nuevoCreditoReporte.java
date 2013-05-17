/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Juan
 */
public class nuevoCreditoReporte {
        //campos de los reportes para magisterio
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
    public String qnaaplica; //quincena de inicio del credito
    public String estado;
    
    nuevoCreditoReporte(String rfc,String noempleado,int concepto,double captotal,
                    double inttotal,double abonocapital,double abonointeres,
                    double saldocapital,double saldointeres,int quincena,
                    String qnaaplica,String estado )
    {
        this.rfc=rfc;
        this.noempleado=noempleado;
        this.concepto=concepto;
        this.captotal=captotal;
        this.inttotal=inttotal;
        this.abonocapital=abonocapital; //descuento quincenal
        this.abonointeres=abonointeres;
        this.saldocapital=saldocapital;
        this.saldointeres=saldointeres;
        this.quincena=quincena; 
        this.qnaaplica=qnaaplica; //quincena de inicio del credito
        this.estado=estado;    
    }

    nuevoCreditoReporte() {
        
    }
    public String getrfc()
    {
        return rfc;
    }
    public void setrfc(String rfc)
    {
        this.rfc=rfc;
    }
    public String getnoempleado()
    {
        return noempleado;
    }
    public int getconcepto()
    {
        return concepto;
    }
    public double getcaptotal()
    {
        return captotal;
    }
    public double getinttotal()
    {
        return inttotal;
    }
    public double getabonocapital()
    {
        return abonocapital;
    }
    public double getabonointeres()
    {
        return abonointeres;
    }
    public double getsaldocapital()
    {
    return saldocapital;
    }
    public double getsaldointeres()
    {
        return saldointeres;
    }
    public int getquincena()
    {
        return quincena;
    }
    public String getqnaaplica()
    {
        return qnaaplica;
    }//quincena de inicio del credito
    public String getestado()
    {
        return estado;
    }
    public void setnoempleado(String noempleado)
    {
        this.noempleado=noempleado;
    }
    public void setconcepto(int concepto)
    {
        this.concepto=concepto;
    }
    public void setcaptotal(double captotal)
    {
        this.captotal=captotal;
    }
    public void setinttotal(double inttotal)
    {
        this.inttotal=inttotal;
    }
    public void setabonocapital(double abonocapital)
    {
        this.abonocapital=abonocapital;
    }
    public void setabonointeres(double abonointeres)
    {
        this.abonointeres=abonointeres;
    }
    public void setsaldocapital(double saldocapital)
    {
        this.saldocapital=saldocapital;
    }
    public void setsaldointeres(double saldointeres)
    {
        this.saldointeres=saldointeres;
    }
    public void setquincena(int quincena)
    {
        this.quincena=quincena;
    }
    public void setqnaaplica(String qnaaplica)
    {
        this.qnaaplica=qnaaplica;
    }//quincena de inicio del credito
    public void setestado(String estado)
    {
        this.estado=estado;
    }    
}
