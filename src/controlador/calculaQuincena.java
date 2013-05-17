/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Juan
 */
public class calculaQuincena {
    private String quincena;
    private int qna;
    private Date fecha;
    
    public String getquincena(Date fecha)
    {
        int mes,dia,ano;  
        String smes,sdia,sano;
        Calendar myCal = Calendar.getInstance();;
        //Calendar cal=Calendar.getInstance();
        DateFormat format=new SimpleDateFormat("yyyy");
        sano=format.format(fecha);
        /*
        DateFormat format1=new SimpleDateFormat("yyyy");
        format.format(fecha);
        myCal=format.getCalendar();        
        myCal.setTime(fecha);*/
        mes=fecha.getMonth(); //myCal.MONTH;
        dia=fecha.getDay();//myCal.DAY_OF_MONTH;
        ano=Integer.parseInt(sano);//myCal.YEAR;
        if (dia<16)
        {
            qna=((mes+1)*2)-1;
        }
        if (dia>16)
        {
            qna=((mes+1)*2);
        }
        if (qna<10)
        {
            quincena=Integer.toString(ano)+"0";
        }
        quincena=quincena+Integer.toString(qna);
        return quincena;
    }
}
