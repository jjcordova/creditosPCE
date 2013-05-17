/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;

import controlador.arrayCreditos;
import controlador.listaAportacionesContables;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class credito {
    public int IdCredito;
    public int NCredito;
    public int ano;
    public int IdEmpleado;
    public int IdAval;
    public double Montos; //monto solicitado
    public double Montoa; //monto sugerido
    public double Aportacion;
    public java.util.Date FCaptura;
    public int  IdCapturista;
    public int Estatus;
    public java.util.Date FValidacion;
    public java.util.Date FDispercion;
    public java.util.Date FDescuento;
 
     public void consultaCreditoEmpleado(int IDEmpleado)
    {
        String vQuery;
        vQuery="select * from credito where idEmpleado="+IDEmpleado;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next())
            {
                IdCredito=cbPCE.resultSet.getInt(1);
                ano=cbPCE.resultSet.getInt(2);
                NCredito=cbPCE.resultSet.getInt(3);
                IdEmpleado=cbPCE.resultSet.getInt(4);
                IdAval=cbPCE.resultSet.getInt(5);
                Montos=cbPCE.resultSet.getDouble(6);
                Montoa=cbPCE.resultSet.getDouble(7);
                Aportacion=cbPCE.resultSet.getDouble(8);
                FCaptura=cbPCE.resultSet.getDate(9);
                IdCapturista=cbPCE.resultSet.getInt(10);
                Estatus=cbPCE.resultSet.getInt(11);
                FValidacion=cbPCE.resultSet.getDate(12);
                FDispercion=cbPCE.resultSet.getDate(13);
                FDescuento=cbPCE.resultSet.getDate(14);
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
    } 
     
   public arrayCreditos[] consultaCreditosEmpleado(int IDEmpleado)
    {
        arrayCreditos[] ACredi=null;
        String vQuery;
        int ncol=0,ni=0;
        vQuery="select * from credito where idEmpleado="+IDEmpleado;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            cbPCE.resultSet.last();
            ncol=cbPCE.resultSet.getRow();
            cbPCE.resultSet.beforeFirst(); 
            ACredi= new arrayCreditos[ncol];
            while (cbPCE.resultSet.next())
            {
                ACredi[ni] = new arrayCreditos();
                ACredi[ni].IdCredito=cbPCE.resultSet.getInt(1);
                ACredi[ni].ano=cbPCE.resultSet.getInt(2);
                ACredi[ni].NCredito=cbPCE.resultSet.getInt(3);
                ACredi[ni].IdEmpleado=cbPCE.resultSet.getInt(4);
                ACredi[ni].IdAval=cbPCE.resultSet.getInt(5);
                ACredi[ni].Montos=cbPCE.resultSet.getDouble(6);
                ACredi[ni].Montoa=cbPCE.resultSet.getDouble(7);
                ACredi[ni].Aportacion=cbPCE.resultSet.getDouble(8);
                ACredi[ni].FCaptura=cbPCE.resultSet.getDate(9);
                ACredi[ni].IdCapturista=cbPCE.resultSet.getInt(10);
                ACredi[ni].Estatus=cbPCE.resultSet.getInt(11);
                ACredi[ni].FValidacion=cbPCE.resultSet.getDate(12);
                ACredi[ni].FDispercion=cbPCE.resultSet.getDate(13);
                ACredi[ni].FDescuento=cbPCE.resultSet.getDate(14);
                ni=ni+1;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return ACredi;
    } 
     
     public void consultaCredito(int idc,int a, int nc)
    {
        String vQuery;
        vQuery="select * from credito where idcredito="+idc+" and ano="+a+" and ncredito="+nc;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next() == true)
            {
                IdCredito=cbPCE.resultSet.getInt(1);
                ano=cbPCE.resultSet.getInt(2);
                NCredito=cbPCE.resultSet.getInt(3);
                IdEmpleado=cbPCE.resultSet.getInt(4);
                IdAval=cbPCE.resultSet.getInt(5);
                Montos=cbPCE.resultSet.getDouble(6);
                Montoa=cbPCE.resultSet.getDouble(7);
                Aportacion=cbPCE.resultSet.getDouble(8);
                FCaptura=cbPCE.resultSet.getDate(9);
                IdCapturista=cbPCE.resultSet.getInt(10);
                Estatus=cbPCE.resultSet.getInt(11);
                FValidacion=cbPCE.resultSet.getDate(12);
                FDispercion=cbPCE.resultSet.getDate(13);
                FDescuento=cbPCE.resultSet.getDate(14);
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
    }  
     
    public boolean existeCredito(int idc,int a, int nc)
    {
        String vQuery;
        boolean vflag=false;
        vQuery="select * from credito where idcredito="+idc+" and ano="+a+" and ncredito="+nc;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            if (cbPCE.resultSet.next() == true)
            {
                vflag=true;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return vflag;
    }
     
    public void autorizaCredito()
      {
        String vQuery;
        vQuery="UPDATE credito set montoa=?, aportacionq=?, fvalidacion=?, estaus=? where idcredito=? and ano=? and ncredito=? ";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        java.util.Date today = new java.util.Date();
        try {
                PreparedStatement pst = cbPCE.connection.prepareStatement(vQuery);
                pst.setDouble(1, Montoa);
                pst.setDouble(2, Aportacion);                
                java.sql.Date timestamp = new java.sql.Date(today.getTime());
                pst.setDate(3, timestamp); //fecha de validación
                pst.setInt(4, Estatus);
                pst.setInt(5,IdCredito);
                pst.setInt(6, ano);
                pst.setInt(7, NCredito);                
                pst.executeUpdate();   
                cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }          
     }           
    
    public void dispersaCredito(int idc, int ano, int ncr, Date fd, int est)
      {
        String vQuery;
        vQuery="UPDATE credito set fdispercion=?, estaus=? where idcredito=? and ano=? and ncredito=? ";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        java.util.Date today = new java.util.Date();
        try {
                PreparedStatement pst = cbPCE.connection.prepareStatement(vQuery);             
                java.sql.Date timestamp = new java.sql.Date(fd.getTime());
                pst.setDate(1, timestamp); //fecha de validación
                pst.setInt(2, est);  
                pst.setInt(3,idc);
                pst.setInt(4, ano);
                pst.setInt(5, ncr);                
                pst.executeUpdate();   
                cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }          
     }  

    public void inicioCobroCredito()
      {
        String vQuery;
        vQuery="UPDATE credito set finicobro=?, estaus=? where idcredito=? and ano=? and ncredito=? ";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        java.util.Date today = new java.util.Date();
        try {
                PreparedStatement pst = cbPCE.connection.prepareStatement(vQuery);             
                java.sql.Date timestamp = new java.sql.Date(FDescuento.getTime());
                pst.setDate(1, timestamp); //fecha de validación
                pst.setInt(2, Estatus);
                pst.setInt(3,IdCredito);
                pst.setInt(4, ano);
                pst.setInt(5, NCredito);                
                pst.executeUpdate();   
                cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }          
     }    
    
     public void capturaCredito()
     {
        String vQuery;
        vQuery="insert into credito values (?,?,?,?,?,?,?,?,?,?,?,null,null,null)";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        java.util.Date today = new java.util.Date();
        try {
                PreparedStatement pst = cbPCE.connection.prepareStatement(vQuery);
                pst.setInt(1,IdCredito);
                pst.setInt(2, ano);
                pst.setInt(3, NCredito);
                pst.setInt(4, IdEmpleado);
                pst.setInt(5, IdAval);
                pst.setDouble(6, Montos);
                pst.setDouble(7, 0);
                pst.setDouble(8, Aportacion);                
                java.sql.Date timestamp = new java.sql.Date(today.getTime());
                pst.setDate(9, timestamp); //fecha de captura
                pst.setInt(10, IdCapturista);
                pst.setInt(11, Estatus);
                //pst.setDate(12, null); //la fecha de  validación va en blanco
                //pst.setDate(13, null); //la fecha de dispeción va en blanco
                //pst.setDate(14, null); //la fecha del primer descuento va en blanco
                pst.executeUpdate();   
                cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        }          
     }
     
     public boolean existeCreditoOldEmpleado(int ida)
     {
        String vQuery;
        boolean vflag=false;
        //Estatus =0 , credito concluido pagado.
        vQuery="select * from prestamos where idAfil="+ida+" and IdEstatusPrestamo=1";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            if (cbPCE.resultSet.next() == true)
            {
                vflag=true;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return vflag;         
     }     
     public boolean existeCreditoEmpleado(int ida)
     {
        String vQuery;
        boolean vflag=false;
        //Estatus =0 , credito concluido pagado.
        vQuery="select * from credito where idEmpleado="+ida+" and estaus in (1,5,6)";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            if (cbPCE.resultSet.next() == true)
            {
                vflag=true;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return vflag;         
     }  
     
     public boolean existeAval(int ida)
     {
        String vQuery;
        boolean vflag=false;
        //Estatus =0 , credito concluido pagado.
        vQuery="select * from credito where idAval="+ida+" and estaus=1";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            if (cbPCE.resultSet.next() == true)
            {
                vflag=true;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return vflag;         
     }   
     
     public boolean existeAvalesOld(int ida)
     {
        String vQuery;
        boolean vflag=false;
        vQuery="select a.* from avales a, prestamos p where a.TipoAval=0 and a.IdAfilAvalado=p.IdAfil and p.IdEstatusPrestamo in (0,1) and a.idAfil="+ida;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            if (cbPCE.resultSet.next() == true)
            {
                vflag=true;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return vflag;         
     }     
     //regresa el numero que corresponde al sig credito segun el tipo y el año
     public int numeroCredito(int idc,int a)
     {
        String vQuery;
        boolean vflag=false;
        int ncredito=1;
        vQuery="select count(*) from credito where idcredito="+idc+" and ano="+a;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next() == true)
            {
                ncredito=cbPCE.resultSet.getInt(1)+1;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return ncredito;         
     }
     
     public int estatusCredito()
     {
      int estatus=0;
      return estatus;
     }
     //estatus
     
     public creditoReporte[] consultaCreditosEstatus(int estatus)
    {
        String vQuery;
        creditoReporte[] ACreditos = null;
        int ncol, ni=0;
        vQuery="select c.*, a.Paterno, a.Materno, a.Nombres from credito c, afiliados a  where c.idEmpleado=a.IdAfil and c.estaus="+estatus+" order by c.idcredito, c.ano, c.ncredito";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            cbPCE.resultSet.last();
            ncol=cbPCE.resultSet.getRow();
            cbPCE.resultSet.beforeFirst();
            ACreditos = new creditoReporte[ncol];
            while (cbPCE.resultSet.next() == true)
            {
                ACreditos[ni] = new creditoReporte();
                ACreditos[ni].IdCredito=cbPCE.resultSet.getInt(1);
                ACreditos[ni].ano=cbPCE.resultSet.getInt(2);
                ACreditos[ni].NCredito=cbPCE.resultSet.getInt(3);
                ACreditos[ni].IdEmpleado=cbPCE.resultSet.getInt(4);
                ACreditos[ni].IdAval=cbPCE.resultSet.getInt(5);
                ACreditos[ni].Montos=cbPCE.resultSet.getDouble(6);
                ACreditos[ni].Montoa=cbPCE.resultSet.getDouble(7);
                ACreditos[ni].Aportacion=cbPCE.resultSet.getDouble(8);
                ACreditos[ni].FCaptura=cbPCE.resultSet.getDate(9);
                ACreditos[ni].IdCapturista=cbPCE.resultSet.getInt(10);
                ACreditos[ni].Estatus=cbPCE.resultSet.getInt(11);
                ACreditos[ni].FValidacion=cbPCE.resultSet.getDate(12);
                ACreditos[ni].FDispercion=cbPCE.resultSet.getDate(13);
                ACreditos[ni].FDescuento=cbPCE.resultSet.getDate(14);
                ACreditos[ni].paterno=cbPCE.resultSet.getString(15);
                ACreditos[ni].materno=cbPCE.resultSet.getString(16);
                ACreditos[ni].nombre=cbPCE.resultSet.getString(17);
                ni=ni+1;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return ACreditos;
    }  
       
     public creditoReporte[] consultaCreditosReporteNuevosC(int estatus, int Dependencia, Date Fini, Date FFin)
    {
        String vQuery, SFini, SFFin;
        creditoReporte[] ACreditos = null;
        int ncol, ni=0;
        java.sql.Date timestamp;
        SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");  
        SFini=sdf.format(Fini);
        SFFin=sdf.format(FFin);
        //si dependencia es 99, etonces regresamos todas las dependencias
        vQuery="select c.*, a.Paterno, a.Materno, a.Nombres, a.IdSector from credito c, afiliados a  "
                + "where c.idEmpleado=a.IdAfil and c.estaus="+estatus+" "
                + "and c.fdispercion >= '"+SFini+"' AND c.fdispercion <= '"+SFFin+"' ";
         //si la dependencia es distinta a 99 se regresa solo la busqueda en la dependencia especifica
        if (Dependencia!=99)
        {
            vQuery=vQuery+ " and a.IdSector="+Dependencia+" ";
        }
                
        vQuery=vQuery+ " order by a.IdSector, c.idcredito, c.ano, c.ncredito";
       
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            cbPCE.resultSet.last();
            ncol=cbPCE.resultSet.getRow();
            cbPCE.resultSet.beforeFirst();
            ACreditos = new creditoReporte[ncol];
            while (cbPCE.resultSet.next() == true)
            {
                ACreditos[ni] = new creditoReporte();
                ACreditos[ni].IdCredito=cbPCE.resultSet.getInt(1);
                ACreditos[ni].ano=cbPCE.resultSet.getInt(2);
                ACreditos[ni].NCredito=cbPCE.resultSet.getInt(3);
                ACreditos[ni].IdEmpleado=cbPCE.resultSet.getInt(4);
                ACreditos[ni].IdAval=cbPCE.resultSet.getInt(5);
                ACreditos[ni].Montos=cbPCE.resultSet.getDouble(6);
                ACreditos[ni].Montoa=cbPCE.resultSet.getDouble(7);
                ACreditos[ni].Aportacion=cbPCE.resultSet.getDouble(8);
                ACreditos[ni].FCaptura=cbPCE.resultSet.getDate(9);
                ACreditos[ni].IdCapturista=cbPCE.resultSet.getInt(10);
                ACreditos[ni].Estatus=cbPCE.resultSet.getInt(11);
                ACreditos[ni].FValidacion=cbPCE.resultSet.getDate(12);
                ACreditos[ni].FDispercion=cbPCE.resultSet.getDate(13);
                ACreditos[ni].FDescuento=cbPCE.resultSet.getDate(14);
                ACreditos[ni].paterno=cbPCE.resultSet.getString(15);
                ACreditos[ni].materno=cbPCE.resultSet.getString(16);
                ACreditos[ni].nombre=cbPCE.resultSet.getString(17);
                ACreditos[ni].IdSector=cbPCE.resultSet.getInt(18);
                ni=ni+1;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return ACreditos;
    }       
     //se cambio fecha de captura por fecha de dispersión 08/04/2013
     public creditoReporte[] reporteCreditosReporteNuevosC(int estatus, int Dependencia, Date Fini, Date FFin)
    {
        String vQuery, SFini, SFFin;
        creditoReporte[] ACreditos = null;
        int ncol, ni=0;
        java.sql.Date timestamp;
        SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");  
        SFini=sdf.format(Fini);
        SFFin=sdf.format(FFin);
        //si dependencia es 99, etonces regresamos todas las dependencias
        vQuery="select c.*, a.Paterno, a.Materno, a.Nombres, a.IdSector from credito c, afiliados a  "
                + "where c.idEmpleado=a.IdAfil and c.estaus="+estatus+" "
                + "and c.fdispercion >= '"+SFini+"' AND c.fdispercion <= '"+SFFin+"' ";
         //si la dependencia es distinta a 99 se regresa solo la busqueda en la dependencia especifica
        if (Dependencia!=99)
        {
            vQuery=vQuery+ " and a.IdSector="+Dependencia+" ";
        }
                
        vQuery=vQuery+ " order by a.IdSector, c.idcredito, c.ano, c.ncredito";
       
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            cbPCE.resultSet.last();
            ncol=cbPCE.resultSet.getRow();
            cbPCE.resultSet.beforeFirst();
            ACreditos = new creditoReporte[ncol];
            while (cbPCE.resultSet.next() == true)
            {
                ACreditos[ni] = new creditoReporte();
                ACreditos[ni].IdCredito=cbPCE.resultSet.getInt(1);
                ACreditos[ni].ano=cbPCE.resultSet.getInt(2);
                ACreditos[ni].NCredito=cbPCE.resultSet.getInt(3);
                ACreditos[ni].IdEmpleado=cbPCE.resultSet.getInt(4);
                ACreditos[ni].IdAval=cbPCE.resultSet.getInt(5);
                ACreditos[ni].Montos=cbPCE.resultSet.getDouble(6);
                ACreditos[ni].Montoa=cbPCE.resultSet.getDouble(7);
                ACreditos[ni].Aportacion=cbPCE.resultSet.getDouble(8);
                ACreditos[ni].FCaptura=cbPCE.resultSet.getDate(9);
                ACreditos[ni].IdCapturista=cbPCE.resultSet.getInt(10);
                ACreditos[ni].Estatus=cbPCE.resultSet.getInt(11);
                ACreditos[ni].FValidacion=cbPCE.resultSet.getDate(12);
                ACreditos[ni].FDispercion=cbPCE.resultSet.getDate(13);
                ACreditos[ni].FDescuento=cbPCE.resultSet.getDate(14);
                ACreditos[ni].paterno=cbPCE.resultSet.getString(15);
                ACreditos[ni].materno=cbPCE.resultSet.getString(16);
                ACreditos[ni].nombre=cbPCE.resultSet.getString(17);
                ACreditos[ni].IdSector=cbPCE.resultSet.getInt(18);
                ni=ni+1;
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
        return ACreditos;
    }     
     
}
