/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;

/**
 *
 * @author Juan
 */
public class capacidadPago {
    private double sbase;
    private double sneto;
    private double deducciones;
    private double monto;
    private boolean isaval;
    private boolean pres;
    private int tprestamo;
    private double cpago;
    public capacidadPago(double sb, double sn, boolean ia )
    {
        sbase=sb;
        sneto=sn;
        isaval=ia;
    }
    
    public double getCapacidadPago()
    {
        cpago=0.3*sbase;
        if (isaval)
        {
            cpago=cpago-cpago*0.2;
        }
        //establecemos un margen de 5% sobre el sueldo neto al 30% del Sueldo Base
        //si el 30% del sueldo base es mayor que el sueldo neto, entonces reduce su CP
        if (cpago>=sneto*1.05) 
        {
            cpago=sneto*0.95;
        }
        return cpago;
    }
    
    public double getCapacidadPagoAval(boolean c, double mp)
    {
        cpago=0.3*sbase;
        //se determina si su credito xssa2qv7higdddddddddddddddddddddddddddddddddddddddddddeyvexl
        if (c)
        {
            cpago=cpago-mp;
        }
        //establecemos un margen de 5% sobre el sueldo neto al 30% del Sueldo Base
        //si el 30% del sueldo base es mayor que el sueldo neto, entonces reduce su CP
        if (cpago>=sneto*1.05) 
        {
            cpago=sneto*0.95;
        }
        return cpago;
    }    
}
