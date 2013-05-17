/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;

/**
 *
 * @author Juan
 */
public class pagoQuincenal {
    public int quincena;
    public double monto;
    public double pagocapital;
    public double pagointeres;
    public double pagototal;
    public double montofinal;
    //pagoQuincenal(quincena, monto, pagocapital, pagointeres, pagototal, montofinal)
    public pagoQuincenal(int q, double m, double pc, double pi, double pt, double mf)
    {
        quincena=q;
        monto=m;
        pagocapital=pc;
        pagointeres=pi;
        pagototal=pt;
        montofinal=mf;
    }
    
    public void setquincena(int quincena) {
        this.quincena=quincena;
    }
    public int getquincena() {
        return quincena;
    }    
    public void setmonto(double monto) {
        this.monto=monto;
    }
    public double getmonto() {
        return monto;
    }
    public void setpagocapital(double pagocapital) {
        this.pagocapital=pagocapital;
    }   
    public void setpagointeres(double pagointeres) {
        this.pagointeres=pagointeres;
    }    
    public void setpagototal(double pagototal) {
        this.pagototal=pagototal;
    }  
    public void setmontofinal(double montofinal) {
        this.montofinal=montofinal;
    }    
    public double getmontofinal()
    {
        return montofinal;
    }
    public double getpagototal()
    {
        return pagototal;
    }    
    public double getpagointeres()
    {
        return pagointeres;
    }
    
    public double getpagocapital()
    {
        return pagocapital;
    }    
}
