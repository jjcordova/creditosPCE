/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;
import java.util.LinkedList;
/**
 *
 * @author Juan
 */
public class pago {
    public double montocuota;            //monto del prestamo
    public double pagoperiodo;      //pago periodico
    public int nperiodos;           //numero de periodos de pago
    public int periodo;
    public double interesperiodo;   //interes por periodo
    public double totalPagar;
    
   //cuota(monto, taza, plazo); 
    public double cuota(double c, double i, int n)
    {
        double x;
        double y;
        x=(c*i*Math.pow((1+i),(double)n));
        y=(Math.pow((1+i),(double)(n)))-1;
        montocuota=x/y;
        return montocuota;
    }
    //amortizacion(pagoquincenalfijo, taza, plazo,quincena); 
    public double amortizacion(double c, double i, int n, int k)
    {
        double amortiza;
        amortiza=c/(Math.pow(i+1, n-k+1));
        return amortiza;
    }
    //pquincenales(monto, taza, plazo, quincena)
    public LinkedList pquincenales(double c, double i, int n, int k)
    {
          LinkedList<pagoQuincenal> pagosQ;
          pagosQ = new LinkedList<>();
          double pq;
          double cu;
          double cuotap;
          double am;
          
          int j;
          pagoQuincenal[] paq = new pagoQuincenal[n+1];
          cu=c;
          cuotap=cuota(c,i,n);
          truncaDecimal TD = new truncaDecimal();
          for (j=1; j<=n; j++)
          {
              //amortizacion(monto, taza, plazo,quincena); 
              am=amortizacion(TD.getDecimal(2,cuotap),i,n,j);
              //pagoQuincenal(quincena, monto, pagocapital, pagointeres, pagototal, montofinal)
              cu=TD.getDecimal(2,cu);
              am=TD.getDecimal(2,am);  
              paq[j] = new pagoQuincenal(j,cu,am,TD.getDecimal(2,i*cu),TD.getDecimal(2,am+i*cu),TD.getDecimal(2,cu-am));
              pagosQ.add(paq[j]);
              cu=cu-am;
          }
          return pagosQ;    
     }  
    
    //pagoQuincena(monto, taza, plazo, quincena)
    //(double c, double i, int n, int k)
    //Es la situación de el pago en una quincena determinada
    
    public pagoQuincenal pagoQuincena(double monto, double taza, int plazo, int quincena)
    {
          pagoQuincenal pagosQ=null ;
          //pagosQ = new LinkedList<>();
          double pq;
          double cu;
          double cuotap;
          double am;
          
          int j;
          pagoQuincenal[] paq = new pagoQuincenal[plazo+1];
          cu=monto;
          cuotap=cuota(monto,taza,plazo);
          truncaDecimal TD = new truncaDecimal();
          for (j=1; j<=quincena; j++)
          {
              //amortizacion(monto, taza, plazo,quincena); 
              am=amortizacion(TD.getDecimal(2,cuotap),taza,plazo,j);
              //pagoQuincenal(quincena, monto, pagocapital, pagointeres, pagototal, montofinal)
              cu=TD.getDecimal(2,cu);
              am=TD.getDecimal(2,am);  
              paq[j] = new pagoQuincenal(j,cu,am,TD.getDecimal(2,taza*cu),TD.getDecimal(2,am+taza*cu),TD.getDecimal(2,cu-am));
              pagosQ=paq[j];
              cu=cu-am;
          }
          return pagosQ;    
     }  
    
    //totalaPagar(monto, taza, plazo)
    public Double totalaPagar(double c, double i, int n)
    {
          double totalP=0;
          double cu;
          double cuotap;
          double am;
          double totalInteres=0;
          
          int j;
          cu=c;
          cuotap=cuota(c,i,n);
          truncaDecimal TD = new truncaDecimal();
          for (j=1; j<=n; j++)
          {
              //amortizacion(monto, taza, plazo,quincena); 
              am=amortizacion(TD.getDecimal(2,cuotap),i,n,j);
              //pagoQuincenal(quincena, monto, pagocapital, pagointeres, pagototal, montofinal)
              cu=TD.getDecimal(2,cu);
              am=TD.getDecimal(2,am);  
              totalInteres=totalInteres+TD.getDecimal(2,i*cu);
              cu=cu-am;
              
          }
        totalP=TD.getDecimal(2, totalInteres+c);
        totalPagar=totalP;
        return totalPagar;
    }
   
}