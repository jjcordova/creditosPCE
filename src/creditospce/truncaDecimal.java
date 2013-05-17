/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 *
 * @author Juan
 */
public class truncaDecimal {
    
    public double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }
    
    public double getDecimal(int numeroDecimales,double decimal)
    {
        decimal = decimal*(java.lang.Math.pow(10, numeroDecimales));
        decimal = java.lang.Math.round(decimal);
        decimal = decimal/java.lang.Math.pow(10, numeroDecimales);
        return decimal;  
    } 
    
    public String verificaDecimales(String cantidad)
    {
        String NuevaCantidad="";
         if(cantidad.indexOf(".")==-1){
            cantidad = cantidad + ".00";
            NuevaCantidad=cantidad;
        }
        if (Pattern.matches("\\d{1,9}.\\d{1,2}", cantidad)) 
        {
            String Num[] = cantidad.split("\\.");
            //verifica si tiene dos digitos los centavos
            //se parte de que en mexico el separador de centacos es "."
            //si el numero no tiene parte decimal, se le agrega .00
            if (Num[1].length()==1)
            {
                Num[1]=Num[1]+"0";
            }  
            NuevaCantidad=Num[0]+"."+Num[1];
        }
        return NuevaCantidad;
    }
    
}
