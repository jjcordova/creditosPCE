/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Juan
 */
public class calculaEdad {
    private String RFC;
    private Calendar FNacimiento;
    private Calendar FActual;
    private int EDAD=0;
    
    public int calculaPorRFC(String vrfc) throws ParseException
    {
        //COZJ7812044v7
        this.RFC=vrfc;
        String ano=RFC.substring(4,6);
        String mes=RFC.substring(6,8);
        String dia=RFC.substring(8,10);
        String strFecha = ano+"-"+mes+"-"+dia;
        Date formatoFecha = new SimpleDateFormat("yy-MM-dd").parse(strFecha);
        FNacimiento = Calendar.getInstance();//= formatoDelTexto.parse(strFecha);
        FActual = Calendar.getInstance();
        FNacimiento.setTime(formatoFecha);
        EDAD = FActual.get(Calendar.YEAR)- FNacimiento.get(Calendar.YEAR);
        int imes =FActual.get(Calendar.MONTH)- FNacimiento.get(Calendar.MONTH);
        int idia = FActual.get(Calendar.DATE)- FNacimiento.get(Calendar.DATE);
        //Se ajusta el año dependiendo el mes y el día
        if(imes<0 || (imes==0 && idia<0)){
            EDAD--;
        }        
        return EDAD;        
    }
    //falta crear un metodo q saque la edad de dos fecha
    
}
