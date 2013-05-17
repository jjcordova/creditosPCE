/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


/**
 *
 * @author Juan
 */
public class claveCredito {
  //  public int IdCredito;
  //  public int NCredito;
  //  public int ano;
  //  public String CLAVE;
    
    
    
    public String armaClave(int idc, int ano, int ncred)
    {
        String cve="";
        if (idc==0){cve="V-";}
        if (idc==1){cve="R-";}
        if (idc==2){cve="H-";}
        cve=cve+Integer.toString(ano)+"-"+String.format("%05d",ncred);
    //    CLAVE=cve;
        return cve;
    }
    
}
