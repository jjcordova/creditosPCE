/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import creditospce.conectaBase;
import creditospce.credito;
import creditospce.empleado;
import creditospce.pago;
import creditospce.pagoQuincenal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class aportaciones {
    
    public boolean leearchivo(String Archivo)
    {
        boolean flag=true;
        
        return flag;
    }
    public boolean formatocorrecto(String Archivo)
    {
        boolean flag=true;
        
        return flag;
    }
    
    public boolean existeAportaciones(String Quincena, int sector)
    {
        boolean flag=false;
        int ncol=0;
        String vQuery;
        vQuery="select f.idsector,f.IdAfil,a.rfc,a.idcredito,a.ano,a.ncredito,c.montoa,c.aportacionq,a.acumulado "
                + "from aportaciones a, credito c, afiliados f "
                + "where a.idcredito=c.idcredito and a.ano=c.ano and a.ncredito=c.ncredito and "
                + "c.idEmpleado=f.IdAfil and f.idSector="+sector+" and "
                + "a.ncredito=c.ncredito and c.estaus=6 and "
                + "a.acumulado like '%"+Quincena+"%'";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            cbPCE.resultSet.last();
            ncol=cbPCE.resultSet.getRow();
            cbPCE.cierra();   
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }   
        if (ncol!=0){flag=true;}
        return flag;
    }
    
public LinkedList reportaAportacionesCredito(int idCredito, int ano, int ncredito)
    {
        LinkedList<listaAportacionesCalendario> lAportaciones =  new LinkedList<>();
        listaAportacionesCalendario[] laport = null;
        Double monto=0.0, pagoQ=0.0;
        pago pagosq = new pago();
        String [] aportaciones;
        String [] aportacion;
        pagoQuincenal pagosQ=null ;
        double taza;
        String acumulado=null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        taza=(double)0.20/24;
        int plazo=0,IdCredito=0;
        String vQuery;
        vQuery="select f.idsector,f.IdAfil,a.rfc,a.idcredito,a.ano,a.ncredito,c.montoa,c.aportacionq,a.acumulado "
                + "from aportaciones a, credito c, afiliados f "
                + "where a.idcredito=c.idcredito and a.ano=c.ano and a.ncredito=c.ncredito and "
                + "c.idEmpleado=f.IdAfil and "
                + "a.ncredito=c.ncredito and c.estaus=6 and "
                + "a.idcredito="+idCredito+" and "
                + "a.ano="+ano+" and "
                + "a.ncredito="+ncredito;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next())
            {
                acumulado=cbPCE.resultSet.getString(9);
                monto=cbPCE.resultSet.getDouble(7);
                pagoQ=cbPCE.resultSet.getDouble(8); 
                IdCredito=cbPCE.resultSet.getInt(4);
            }
            cbPCE.cierra();   
            if (IdCredito==0){plazo=24;}
            if (IdCredito==1){plazo=72;}
            if (IdCredito==2){plazo=360;}
            aportaciones=acumulado.split("@");
            laport=new listaAportacionesCalendario[aportaciones.length];
            //se debe hacer la división por quincenas
            //hace falta poder filtrar y regresar solo la quincena seleccionada
            for (int j=0; j<aportaciones.length; j++)
            {
                aportacion=aportaciones[j].split("\\|"); 
                laport[j]=new listaAportacionesCalendario();
                try {
                    laport[j].fecha=formatoFecha.parse(aportacion[2]);
                } catch (ParseException ex) {
                    Logger.getLogger(aportaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
                laport[j].IdCredito=IdCredito;
                laport[j].nAportacion=  Integer.parseInt(aportacion[1]); 
                laport[j].Quincena=aportacion[0];
                laport[j].monto=monto;
                laport[j].pagoQ=pagoQ;
                pagosQ=pagosq.pagoQuincena(laport[j].monto, taza, plazo, laport[j].nAportacion);
                laport[j].pagoCapital=pagosQ.pagocapital;
                laport[j].pagoInteres=pagosQ.pagointeres;  
                laport[j].montoInicial=pagosQ.monto;
                laport[j].montoFinal=pagosQ.montofinal;
                lAportaciones.add(laport[j]); 
            }   

        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }             
        return lAportaciones;
    }    
    
    public LinkedList reportaAportaciones(String Quincena, int sector)
    {
        LinkedList<listaAportacionesContables> lAportaciones =  new LinkedList<listaAportacionesContables>();
        listaAportacionesContables[] laport = null;
        pago pagosq = new pago();
        String [] aportaciones;
        String [] aportacion;
        String apo = null;
        int ncol,ni=0;
        pagoQuincenal pagosQ=null;
        double taza;
        String acumulado=null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        taza=(double)0.20/24;
        int plazo=0;
        String vQuery;
        vQuery="select f.idsector,f.IdAfil,a.rfc,a.idcredito,a.ano,a.ncredito,c.montoa,c.aportacionq,a.acumulado "
                + "from aportaciones a, credito c, afiliados f "
                + "where a.idcredito=c.idcredito and a.ano=c.ano and a.ncredito=c.ncredito and "
                + "c.idEmpleado=f.IdAfil and f.idSector="+sector+" and "
                + "a.ncredito=c.ncredito and c.estaus=6 and "
                + "a.acumulado like '%"+Quincena+"%'";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            cbPCE.resultSet.last();
            ncol=cbPCE.resultSet.getRow();
            cbPCE.resultSet.beforeFirst();
            laport = new listaAportacionesContables[ncol];
            while (cbPCE.resultSet.next())
            {
                laport[ni]=new listaAportacionesContables();
                laport[ni].sector=cbPCE.resultSet.getInt(1);
                laport[ni].idempleado=cbPCE.resultSet.getInt(2);
                laport[ni].rfc=cbPCE.resultSet.getString(3);
                laport[ni].IdCredito=cbPCE.resultSet.getInt(4);
                laport[ni].ano=cbPCE.resultSet.getInt(5);
                laport[ni].NCredito=cbPCE.resultSet.getInt(6);
                laport[ni].monto=cbPCE.resultSet.getDouble(7);
                laport[ni].pagoQ=cbPCE.resultSet.getDouble(8);
                //pagoQuincena(double monto, double taza, int plazo, int quincena)
                if (laport[ni].IdCredito==0){plazo=24;}
                if (laport[ni].IdCredito==1){plazo=72;}
                if (laport[ni].IdCredito==2){plazo=360;}
                acumulado=cbPCE.resultSet.getString(9);
                aportaciones=acumulado.split("@");
                //se debe hacer la división por quincenas
                //hace falta poder filtrar y regresar solo la quincena seleccionada
                for (int j=0; j<aportaciones.length; j++)
                {
                    if (Quincena.equals(aportaciones[j].substring(0, 5)))
                    {
                        apo=aportaciones[j];   
                    }
                }
                aportacion =apo.split("\\|");      
                try {
                    laport[ni].fecha=formatoFecha.parse(aportacion[2]);
                } catch (ParseException ex) {
                    Logger.getLogger(aportaciones.class.getName()).log(Level.SEVERE, null, ex);
                }
                laport[ni].nAportacion=  Integer.parseInt(aportacion[1]);  
                pagosQ=pagosq.pagoQuincena(laport[ni].monto, taza, plazo, laport[ni].nAportacion);
                laport[ni].pagoCapital=pagosQ.pagocapital;
                laport[ni].pagoInteres=pagosQ.pagointeres;                
                lAportaciones.add(laport[ni]); 
                ni=ni+1;
            }
            cbPCE.cierra();   
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }             
        return lAportaciones;
    }
    
    public LinkedList analizaAportaciones(String Archivo, Date fecha)
    {
        LinkedList<listaAportaciones> lAportaciones =new LinkedList<listaAportaciones>();
        listaAportaciones laport= new listaAportaciones();
        //laport = null;
        File farchivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String[] arrayLectura;
 
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            farchivo = new File (Archivo);
            fr = new FileReader (farchivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            int intflag;
            while((linea=br.readLine())!=null) {
                 arrayLectura=linea.split(",");
                 //listaAportaciones:= rfc,idcredito,ncredito,ano,fecha,nAportación,monto
                 //numeroAportacion(rfc,monto);
                 intflag=correctaAportacion(arrayLectura[0],Double.valueOf(arrayLectura[1]));
                 laport=armaAportacion(arrayLectura[0],Double.valueOf(arrayLectura[1]),fecha);
                 lAportaciones.add(laport);
                 //System.out.println(linea);
             }
         }
         catch(Exception e){
            e.printStackTrace();
         }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try{                    
               if( null != fr ){   
                  fr.close();     
               }                  
            }catch (Exception e2){ 
               e2.printStackTrace();
            }
         }       
        return lAportaciones;
    }
    
    public int correctaAportacion(String rfc, double monto)
    {
        int flag=0;
        
        return flag;
    }
    
    public int numeroAportacion(String rfc, int idcredito, int ano, int ncredito, Date Fecha)
    {
       //tabla aportaciones; rfc,idcredito,ano,ncredito,acumulado 
       //listaAportaciones[] lA=null;
       String arfc="",aporta="";
       int aidc=0,aano=0,ancredito=0;
       String [] aportaciones;
       int naportaciones=0,n=0;
        String vQuery;
        vQuery="select a.rfc,a.idcredito,a.ano,a.ncredito,a.acumulado "
                + "from aportaciones a, credito c "
                + "where a.idcredito=c.idcredito and a.ano=c.ano and "
                + "a.ncredito=c.ncredito and c.estaus IN (5,6) and "
                + "a.rfc='"+rfc+"'";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next())
            {
                arfc=cbPCE.resultSet.getString(1);
                aidc=cbPCE.resultSet.getInt(2);
                aano=cbPCE.resultSet.getInt(3);
                ancredito=cbPCE.resultSet.getInt(4);
                aporta=cbPCE.resultSet.getString(5);
                n=n+1;
            }
            cbPCE.cierra();
            if (n==0)
            {
                //Es la primera aportación
                //crea el espacio para la nueva aportación
                nuevaAportacion(rfc,idcredito,ano,ncredito);
                naportaciones=0; 
                //Se da la fecha a partir de la cual se inicia a cobrar
                credito caporta = new credito();
                caporta.IdCredito=idcredito;
                caporta.ano=ano;
                caporta.NCredito=ncredito;
                caporta.Estatus=6; //estatus de credito que se está cobrando
                caporta.FDescuento=Fecha;
                caporta.inicioCobroCredito();
            }
            if (n!=0)
            {
                aportaciones=aporta.split("@");
                naportaciones=aportaciones.length;   
                //lA = new listaAportaciones[naportaciones];
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }        
       return naportaciones+1;
    }    

        public int numeroAportacionesIDAfil(int IDAfil, int idcredito, int ano, int ncredito)
    {
       //tabla aportaciones; rfc,idcredito,ano,ncredito,acumulado 
       //listaAportaciones[] lA=null;
       String aporta="";
       String [] aportaciones;
       int naportaciones=0,n=0;
        String vQuery;
        vQuery="select a.rfc,a.idcredito,a.ano,a.ncredito,a.acumulado "
                + "from aportaciones a, credito c "
                + "where a.idcredito=c.idcredito and a.ano=c.ano and "
                + "a.ncredito=c.ncredito and c.estaus IN (5,6) and "
                + "c.idEmpleado="+IDAfil;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next())
            {
                n=n+1;
            }
            cbPCE.cierra();
            if (n==0)
            {
                //No hay aportaciones
                naportaciones=0; 
            }
            if (n!=0)
            {
                aportaciones=aporta.split("@");
                naportaciones=aportaciones.length;  
            }

        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }        
       return naportaciones;
    }   

    public void nuevaAportacion(String rfc, int idcredito, int ano, int ncredito)
    {
        String vQuery;
        vQuery="insert into aportaciones values (?,?,?,?,?)";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
         try {
                PreparedStatement pst = cbPCE.connection.prepareStatement(vQuery);             
                //java.sql.Date timestamp = new java.sql.Date(today.getTime());
                pst.setString(1, rfc); 
                pst.setInt(2, idcredito);
                pst.setInt(3, ano);
                pst.setInt(4, ncredito);
                pst.setString(5, "");
                pst.executeUpdate();   
                cbPCE.cierra();
         } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
    
    }
    
    public void guardaAportacion(String rfc, int idcredito, int ano, int ncredito, int naportacion, Double descuento,Date fecha,String Quincena)
    {
       //tabla aportaciones; rfc,idcredito,ano,ncredito,acumulado 
       listaAportaciones lA=null;
       String aporta="";
       SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
        String vQuery;
        vQuery="select a.acumulado "
                + "from aportaciones a "
                + "where a.idcredito="+idcredito+" and "
                + "a.ano="+ano+" and "
                + "a.ncredito="+ncredito+" and "
                + "a.rfc='"+rfc+"'";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next())
            {
                aporta=cbPCE.resultSet.getString(1);
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
         vQuery="update aportaciones set acumulado=? where "
                + "idcredito="+idcredito+" and "
                + "ano="+ano+" and "
                + "ncredito="+ncredito+" and "
                + "rfc='"+rfc+"'";
         //squincena=Integer.toString(Quincena)+sdf.format(fecha).substring(0, 4);
         aporta=Quincena+"|"+Integer.toString(naportacion)+"|"+sdf.format(fecha)+"|"+descuento.toString()+"@"+aporta;
         
         
         cbPCE.conecta();
         try {
                PreparedStatement pst = cbPCE.connection.prepareStatement(vQuery);             
                //java.sql.Date timestamp = new java.sql.Date(today.getTime());
                pst.setString(1, aporta); //fecha de validación
                pst.executeUpdate();   
                cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
    } 
    
    public listaAportaciones armaAportacion(String rfc, double monto, Date fecha)
    {
        
       listaAportaciones lA=new listaAportaciones();
        String vQuery;
        vQuery="select c.idcredito,c.ano,c.ncredito,c.montoa,a.rfc from "
                + "credito c, afiliados a "
                + "where c.idEmpleado=a.idAfil and a.rfc='"+rfc+ "' "
                + "order by c.idcredito,c.ano,c.ncredito ";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next())
            {
                lA.IdCredito=cbPCE.resultSet.getInt(1);
                lA.ano=cbPCE.resultSet.getInt(2);
                lA.NCredito=cbPCE.resultSet.getInt(3);
                lA.fecha=fecha;
                lA.monto=monto;//cbPCE.resultSet.getDouble(4);
                lA.nAportacion=numeroAportacion(rfc,cbPCE.resultSet.getInt(1),cbPCE.resultSet.getInt(2),cbPCE.resultSet.getInt(3), fecha);
                lA.rfc=cbPCE.resultSet.getString(5);
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
       return lA;
    }
    //ordena las aportaciones por el tipo de credito, numero de credito 
    //y numero de aportaciones, se separan 
    public List<listaAportaciones> ordenaAportaciones(List<listaAportaciones> lA)
    {
        List<listaAportaciones> listaA=null;
        Iterator it= lA.iterator();
        while (it.hasNext())
        {
            
        }
        
        return listaA;
    }
    
}
