/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;

/**
 *
 * @author Juan
 */
public class cgcredito {
    public int idcredito;
    public String credito;
    public int quincenas;
    public double tasaanual;
    public String descripcion;   
    
    public cgcredito()
    {
    idcredito=0;
    credito="";
    quincenas=0;
    tasaanual=0;
    descripcion="";
    }
    public cgcredito(int id,String c,int q, double ta, String d)
    {
    idcredito=id;
    credito=c;
    quincenas=q;
    tasaanual=ta;
    descripcion=d;
    }    
}
