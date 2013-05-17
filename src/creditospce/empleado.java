/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package creditospce;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan Jose Cordova Zamorano
 * DSInteg.com
 */
public class empleado {
    public int IdAfil;
    public String RFC;
    public String RFCCom;
    public String NoEmpleado;
    public String Paterno;
    public String Materno;
    public String Nombres;
    public int IdSexo;
    public String Dir;
    public String Col;
    public String CP;
    public String ciudad;
    public String estado;
    public int IdEstatusAfil;
    public String CIdEstatusAfil; //String de IDEstatus descripcion del catalodo
    public java.util.Date FechaIngreso;
    public Date FechaAlta;
    public int IdTipoEmpleado;
    public String CIdTipoEmpleado;
    public int IdSindicato;
    public String CIdSindicato; //descripcion
    public String UnidadAdministrativa;
    public int IdSector;
    public String CIdSector; //descripcion
    public int NoDependientes;
    public int IdEdoCivil;
    public double SueldoBaseQuincenal;
    public Date FechaNac;
    public String Puesto;
    public String Plaza;
    //nuevos campos q no estan en la tabla afiliado
    //se guardaran en la tabal afiliadocurp
    public String CURP;
    public String TelefonoCasa;
    public String TelefonoCelular;
    public String EMail;
    //campos que almacenan a la tabla filiadobanco

    public boolean consutlaEmpleadoID(int IDEmpleado)
    {
        String vQuery;
        boolean vflag=false;
        vQuery="select af.*, cgsi.NombreSindicato ns, cgs.Sector nsec, te.TipoEmpleado tipoe, pz.Numero plazan from plazas pz, afiliados af, "
                + "sindicatos cgsi, sectores cgs, tipo_empleado te where "
                + " af.IdSindicato=cgsi.IdSindicato and af.IdSector=cgs.IdSector "
                + " and te.IdTipoEmpleado=af.IdTipoEmpleado "
                + " and pz.IdAfil=af.IdAfil "
                + " and af.IdAfil="+IDEmpleado;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            
            while (cbPCE.resultSet.next()== true)
            {
                vflag=true;
                IdAfil=cbPCE.resultSet.getInt(1);
                RFC=cbPCE.resultSet.getString(2);
                RFCCom=cbPCE.resultSet.getString(3);
                NoEmpleado=cbPCE.resultSet.getString(4);
                Paterno=cbPCE.resultSet.getString(5);
                Materno=cbPCE.resultSet.getString(6);
                Nombres=cbPCE.resultSet.getString(7);
                IdSexo=cbPCE.resultSet.getInt(8);
                Dir=cbPCE.resultSet.getString(9);
                Col=cbPCE.resultSet.getString(10);
                CP=cbPCE.resultSet.getString(11);
                ciudad=cbPCE.resultSet.getString(12);
                estado=cbPCE.resultSet.getString(13);
                IdEstatusAfil=cbPCE.resultSet.getInt(14);
                FechaIngreso=cbPCE.resultSet.getDate(15);
                FechaAlta=cbPCE.resultSet.getDate(16);
                IdTipoEmpleado=cbPCE.resultSet.getInt(17);
                IdSindicato=cbPCE.resultSet.getInt(18);
                UnidadAdministrativa=cbPCE.resultSet.getString(19);
                IdSector=cbPCE.resultSet.getInt(20);
                NoDependientes=cbPCE.resultSet.getInt(21);
                IdEdoCivil=cbPCE.resultSet.getInt(22);
                SueldoBaseQuincenal=cbPCE.resultSet.getDouble(23);
                FechaNac=cbPCE.resultSet.getDate(27);
                Puesto=cbPCE.resultSet.getString(28);                   
                CIdSindicato=cbPCE.resultSet.getString("ns"); //descripcion
                CIdSector=cbPCE.resultSet.getString("nsec");
                CIdTipoEmpleado=cbPCE.resultSet.getString("tipoe");
                Plaza=cbPCE.resultSet.getString("plazan");
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
              
        } 
        return vflag;
    } 

    public void consultaEmpleadoRFC(String vRFC)
    {
        String vQuery;
        vQuery="select * from afiliados where "
                + "RFC="+vRFC;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next()== true)
            {
                IdAfil=cbPCE.resultSet.getInt(1);
                RFC=cbPCE.resultSet.getString(2);
                RFCCom=cbPCE.resultSet.getString(3);
                NoEmpleado=cbPCE.resultSet.getString(4);
                Paterno=cbPCE.resultSet.getString(5);
                Materno=cbPCE.resultSet.getString(6);
                Nombres=cbPCE.resultSet.getString(7);
                IdSexo=cbPCE.resultSet.getInt(8);
                Col=cbPCE.resultSet.getString(9);
                CP=cbPCE.resultSet.getString(10);
                ciudad=cbPCE.resultSet.getString(11);
                estado=cbPCE.resultSet.getString(12);
                IdEstatusAfil=cbPCE.resultSet.getInt(13);
                FechaIngreso=cbPCE.resultSet.getDate(14);
                FechaAlta=cbPCE.resultSet.getDate(15);
                IdTipoEmpleado=cbPCE.resultSet.getInt(16);
                IdSindicato=cbPCE.resultSet.getInt(17);
                UnidadAdministrativa=cbPCE.resultSet.getString(18);
                IdSector=cbPCE.resultSet.getInt(19);
                NoDependientes=cbPCE.resultSet.getInt(20);
                IdEdoCivil=cbPCE.resultSet.getInt(21);
                SueldoBaseQuincenal=cbPCE.resultSet.getDouble(22);
                FechaNac=cbPCE.resultSet.getDate(23);
                Puesto=cbPCE.resultSet.getString(24);   
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
              
        } 
    }    
public void guardaEmpleadoCURP()
{
        String vQuery;
        vQuery="insert into afiliadocurp values (?,?,?,?,?)";
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
                PreparedStatement pst = cbPCE.connection.prepareStatement(vQuery);
                pst.setInt(1,IdAfil);
                pst.setString(2, CURP);
                pst.setString(3, TelefonoCasa);
                pst.setString(4, TelefonoCelular);
                pst.setString(5, EMail);
                pst.executeUpdate();   
                cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);        
        } 
}
public void setEmpleadoCURP(int IdA,String C, String TC, String TCel, String EM )
{
    IdAfil=IdA;
    CURP=C;
    TelefonoCasa=TC;
    TelefonoCelular=TCel;
    EMail=EM;
}
 public void consutlaEmpleadoCURP(String vCURP)
    {
        String vQuery;
        vQuery="select * from afiliadocurp where "
                + "CURP="+vCURP;
        conectaBase cbPCE = new conectaBase();
        cbPCE.conecta();
        try {
            cbPCE.statement = cbPCE.connection.createStatement();
            cbPCE.resultSet = cbPCE.statement.executeQuery(vQuery);
            while (cbPCE.resultSet.next()== true)
            {
                IdAfil=cbPCE.resultSet.getInt(1);
                RFC=cbPCE.resultSet.getString(2);
                RFCCom=cbPCE.resultSet.getString(3);
                NoEmpleado=cbPCE.resultSet.getString(4);
                Paterno=cbPCE.resultSet.getString(5);
                Materno=cbPCE.resultSet.getString(6);
                Nombres=cbPCE.resultSet.getString(7);
                IdSexo=cbPCE.resultSet.getInt(8);
                Col=cbPCE.resultSet.getString(9);
                CP=cbPCE.resultSet.getString(10);
                ciudad=cbPCE.resultSet.getString(11);
                estado=cbPCE.resultSet.getString(12);
                IdEstatusAfil=cbPCE.resultSet.getInt(13);
                FechaIngreso=cbPCE.resultSet.getDate(14);
                FechaAlta=cbPCE.resultSet.getDate(15);
                IdTipoEmpleado=cbPCE.resultSet.getInt(16);
                IdSindicato=cbPCE.resultSet.getInt(17);
                UnidadAdministrativa=cbPCE.resultSet.getString(18);
                IdSector=cbPCE.resultSet.getInt(19);
                NoDependientes=cbPCE.resultSet.getInt(20);
                IdEdoCivil=cbPCE.resultSet.getInt(21);
                SueldoBaseQuincenal=cbPCE.resultSet.getDouble(22);
                FechaNac=cbPCE.resultSet.getDate(23);
                Puesto=cbPCE.resultSet.getString(24);   
            }
            cbPCE.cierra();
        } catch (SQLException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
              
        } 
    }  

}