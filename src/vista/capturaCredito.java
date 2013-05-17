/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import creditospce.Numero_a_Letra;
import creditospce.calculaEdad;
import creditospce.capacidadPago;
import creditospce.credito;
import creditospce.empleado;
import creditospce.empleadoBanco;
import creditospce.pago;
import creditospce.pagoQuincenal;
import creditospce.reporteCapacidadPago;
import creditospce.reporteCartaCompromiso;
import creditospce.reporteContratoVerdeJubilado;
import creditospce.reporteCorridaPagos;
import creditospce.reportePagare;
import creditospce.truncaDecimal;
import java.awt.Color;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Juan
 */
public class capturaCredito extends javax.swing.JFrame {

    /**
     * Creates new form capturaCredito
     */
    public Map solicitudCV;
    public Map solicitudA;
    public Map solicitudC;
    public Integer IdCapturista;
    public Integer IdAval;
    private Integer IdDocto;
    private double CAPACIDADPAGO;
    private double SUELDONETO;
    private double MONTOSOLICITADO;
    private double PAGOQUINCENAL;
    private empleado oempleado; //clase q hace la busqueda del empleado
    private String NOPAGARE;
    private String IDENTIFICACION;
    private Integer TIPOCREDITO;
    private empleado oempleadoA;
    private empleado oempleadoT1, oempleadoT2;
    private double CAPACIDADPAGOAVAL;
    private double SUELDONETOAVAL;
    private String EMPLEADOIDE="CREDENCIAL DE ELECTOR";
    private String TESTIGO1IDE="CREDENCIAL DE ELECTOR";
    private String TESTIGO2IDE="CREDENCIAL DE ELECTOR";
    private int BANCO;
    private String CLABE;
    
    
    public capturaCredito() {
        initComponents();
        solicitudCV = new HashMap();
    	solicitudCV.put("nombre", "");
        solicitudCV.put("paterno", "");
        solicitudCV.put("materno", "");
    	solicitudCV.put("rfc", "");
        solicitudCV.put("curp", "");
    	solicitudCV.put("domicilio", "");
        solicitudCV.put("estado", "");
        solicitudCV.put("municipio", "");
        solicitudCV.put("localidad", "");
        solicitudCV.put("telefono", "");
        solicitudCV.put("nempleado", "");
        solicitudCV.put("setor", "");
        solicitudCV.put("sindicato", "");
        solicitudCV.put("uadministrativa", "");
        solicitudCV.put("tafiliado", "");
        solicitudCV.put("fingreso", "");
        solicitudCV.put("nplaza", "");
        solicitudCV.put("sbase", "");
        solicitudCV.put("importecs", "");
        //cgcredito[] cgcreditos;
          //      bcgcredito cbg = new bcgcredito();
            //    boolean consutlaCreditosID = cbg.consutlaCreditosID();
              //  int ncbg=cbg.cgcreditos.length;      
       IdCapturista=0; 
       IdDocto=0;
       IDENTIFICACION="CREDENCIAL DE ELECTOR";
    }
    
    /**
     *
     */
    public void despliegaAfiliado()
    {
        int vIDA;
        
        oempleado = new empleado();
        vIDA=Integer.parseInt(txtIDAfiliado.getText());
        if (oempleado.consutlaEmpleadoID(vIDA))
        {
            //existe el empleado
            //se llena la forma
            txtRFC.setText(oempleado.RFC);
            //cortamos el RFC solo a los primero 10 carateres
            txtCURP.setText(oempleado.RFC.substring(0,10));
            txtNEmpleado.setText(oempleado.NoEmpleado);
            txtNombre.setText(oempleado.Nombres);
            txtPaterno.setText(oempleado.Paterno);
            txtMaterno.setText(oempleado.Materno);
            txtTEmpleado.setText(oempleado.CIdTipoEmpleado);
            txtSector.setText(oempleado.CIdSector);
            txtSindicato.setText(oempleado.CIdSindicato);
            txtFIngreso.setText(oempleado.FechaIngreso.toString());
            txtUAdministrativa.setText(oempleado.UnidadAdministrativa);
            txtSQuincenal.setText(Double.toString(oempleado.SueldoBaseQuincenal));
            txtDireccion.setText(oempleado.Dir);
            txtEstado.setText(oempleado.estado);
            txtMunicipio.setText(oempleado.ciudad);
            txtLocalidad.setText(oempleado.Col);
            //txtTelefono.setText(oempleado);      
        }
        else {
            //no existe el empleado
            txtIDAfiliado.setText("");
            JOptionPane.showMessageDialog(null, "NO EXISTE EMPLEADO REGISTRADO CON ESE NÚMERO DE EMPLEADO");
        }
    }
    
    public void despliegaTestigo(int numerotestigo)
    {
        int testigo;
            if (numerotestigo==1)
            {  
                testigo=Integer.parseInt(txtIDAfiliadoT1.getText());
                oempleadoT1 = new empleado();
                if (oempleadoT1.consutlaEmpleadoID(testigo))
                {            
                    //existe el empleado, se llena la forma
                    txtNombreT1.setText(oempleadoT1.Nombres);
                    txtPaternoT1.setText(oempleadoT1.Paterno);
                    txtMaternoT1.setText(oempleadoT1.Materno);                     
                }
                else {
                    //no existe el empleado
                    txtIDAfiliadoT1.setText("");
                    JOptionPane.showMessageDialog(null, "NO EXISTE EMPLEADO REGISTRADO CON ESE NÚMERO DE EMPLEADO");
                }
            }
            if (numerotestigo==2)
            {
               testigo=Integer.parseInt(txtIDAfiliadoT2.getText());
               oempleadoT2 = new empleado();
                if (oempleadoT2.consutlaEmpleadoID(testigo))
                {            
                    //existe el empleado, se llena la forma
                    txtNombreT2.setText(oempleadoT2.Nombres);
                    txtPaternoT2.setText(oempleadoT2.Paterno);
                    txtMaternoT2.setText(oempleadoT2.Materno);                     
                }
                else {
                    //no existe el empleado
                    txtIDAfiliadoT2.setText("");
                    JOptionPane.showMessageDialog(null, "NO EXISTE EMPLEADO REGISTRADO CON ESE NÚMERO DE EMPLEADO");
                }                                  
            }            
    }
    
    public void despliegaAval()
    {
        boolean esAval;
        boolean esOldAval;   
        oempleadoA = new empleado();
        IdAval=Integer.parseInt(txtIDAfiliadoA.getText());
        credito verificaAval= new credito();
        esAval=verificaAval.existeAval(IdAval);
        esOldAval=verificaAval.existeAvalesOld(IdAval);
        if (oempleadoA.IdTipoEmpleado>=6)
        {
            JOptionPane.showMessageDialog(null, "JUBILADO O PENSIONANO NO PUEDE SER AVAL");
        }
        else
        {
            if (esAval==true || esOldAval==true)
            {
                limpiaAval();
                JOptionPane.showMessageDialog(null, "EL EMPLEADO YA ES ACTUALMENTE AVAL");
            }
            else
            {
                if (oempleadoA.consutlaEmpleadoID(IdAval))
                {
                    //existe el empleado
                    //se llena la forma
                    txtRFCA.setText(oempleadoA.RFC);
                    txtCURPA.setText(oempleadoA.RFC.substring(0,10));
                    //txtCURP;
                    txtNEmpleadoA.setText(oempleadoA.NoEmpleado);
                    txtNombreA.setText(oempleadoA.Nombres);
                    txtPaternoA.setText(oempleadoA.Paterno);
                    txtMaternoA.setText(oempleadoA.Materno);
                    txtTEmpleadoA.setText(oempleadoA.CIdTipoEmpleado);
                    txtSectorA.setText(oempleadoA.CIdSector);
                    txtSindicatoA.setText(oempleadoA.CIdSindicato);
                    txtFIngresoA.setText(oempleadoA.FechaIngreso.toString());
                    txtUAdministrativaA.setText(oempleadoA.UnidadAdministrativa);
                    txtSQuincenalA.setText(Double.toString(oempleadoA.SueldoBaseQuincenal));
                    txtDireccionA.setText(oempleadoA.Dir);
                    txtEstadoA.setText(oempleadoA.estado);
                    txtMunicipioA.setText(oempleadoA.ciudad);
                    txtLocalidadA.setText(oempleadoA.Col);
                    //txtTelefono.setText(oempleado);      
                }
                else {
                    //no existe el empleado
                    txtIDAfiliado.setText("");
                    JOptionPane.showMessageDialog(null, "NO EXISTE EMPLEADO REGISTRADO CON ESE NÚMERO DE EMPLEADO");
                }        
            }
        }
    }
    public void despliegaConyuge()
    {
        int vIDA;
        empleado oempleadoC;
        oempleadoC = new empleado();
        vIDA=Integer.parseInt(txtIDAfiliadoC.getText());
        if (oempleadoC.consutlaEmpleadoID(vIDA))
        {
            //existe el empleado
            //se llena la forma
            txtRFCA.setText(oempleadoC.RFC);
            //txtCURP;
            txtNEmpleadoA.setText(oempleadoC.NoEmpleado);
            txtNombreA.setText(oempleadoC.Nombres);
            txtPaternoA.setText(oempleadoC.Paterno);
            txtMaternoA.setText(oempleadoC.Materno);
            txtDireccionA.setText(oempleadoC.Dir);
            txtEstadoA.setText(oempleadoC.estado);
            txtMunicipioA.setText(oempleadoC.ciudad);
            //txtLocalidad;
            //txtTelefono.setText(oempleado);      
        }
        else {
            //no existe el empleado
            txtIDAfiliado.setText("");
            JOptionPane.showMessageDialog(null, "NO EXISTE EMPLEADO REGISTRADO CON ESE NÚMERO DE EMPLEADO");
        }
    }
    public void limpiaAfiliado()
    {
            txtIDAfiliado.setText("");
            txtRFC.setText("");
            txtCURP.setText("");
            txtNEmpleado.setText("");
            txtNombre.setText("");
            txtPaterno.setText("");
            txtMaterno.setText("");
            txtTEmpleado.setText("");
            txtSector.setText("");
            txtSindicato.setText("");
            txtFIngreso.setText("");
            txtUAdministrativa.setText("");
            txtSQuincenal.setText("");
            txtDireccion.setText("");
            txtEstado.setText("");
            txtMunicipio.setText("");
            txtLocalidad.setText("");
            txtTelefono.setText("");
            txtTelefonoCel.setText("");
            txtEMail.setText("");
    }
    
    public void limpiaDocumentos()
    {
        cbxCredencialPCET.setSelected(false);
        cbxCPago.setSelected(false);
//        cbxIOficial.setSelected(false);
        cbxCDomicilio.setSelected(false);
        cbxCURP.setSelected(false);
    }
    
    public void limpiaAval()
    {
            txtIDAfiliadoA.setText("");
            txtRFCA.setText("");
            txtCURPA.setText("");
            txtNEmpleadoA.setText("");
            txtNombreA.setText("");
            txtPaternoA.setText("");
            txtMaternoA.setText("");
            txtTEmpleadoA.setText("");
            txtSectorA.setText("");
            txtSindicatoA.setText("");
            txtFIngresoA.setText("");
            txtUAdministrativaA.setText("");
            txtSQuincenalA.setText("");
            txtDireccionA.setText("");
            txtEstadoA.setText("");
            txtMunicipioA.setText("");
            txtLocalidadA.setText("");
            txtTelefonoA.setText("");
            txtTelefonoCelA.setText("");
            txtEMailA.setText("");
    }
        
    public void limpiaConyuge()
    {
            txtIDAfiliadoC.setText("");
            txtRFCC.setText("");
            txtCURPC.setText("");
            txtNombreC.setText("");
            txtPaternoC.setText("");
            txtMaternoC.setText("");
            txtDireccionC.setText("");
            txtEstadoC.setText("");
            txtMunicipioC.setText("");
            txtLocalidadC.setText("");
            txtTelefonoC.setText("");
            txtTelefonoCelC.setText("");
            txtEMailC.setText("");
    }
                
    public double calculapago(int tc, double monto )
    {
        double checamonto;
        double checapago=0;
        int plazo=1;
        double taza;
        pago vpago;
        try
        {
            
            if (tc==0)
            {
                plazo=24;
            }
            if (tc==1)
            {
                plazo=72;
            }
            if (tc==2)
            {
                plazo=360;
            }            
            taza=(double)0.20/(double)24;    
            checamonto=monto;
            vpago=new pago();
            checapago=vpago.cuota(checamonto, taza, plazo);
            truncaDecimal TD = new truncaDecimal();
            DecimalFormat formateador = new DecimalFormat("#######.##");
            String pgp=Double.toString(TD.getDecimal(2, checapago));
            //Este daria a la salida 1,000
            //System.out.println (formateador.format (1000));
            txtPFQuinenal.setText(pgp);
            txtQPlazo.setText(Integer.toString(plazo));
            
        }
        catch(NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(null, "DEBEN DE LLENARSE TODOS LOS CAMPOS");
        }
        return checapago;
    }
    public boolean isllenaformaprincipal()
    {
        boolean vflag=true;
        if ("".equals(txtIDAfiliado.getText())){vflag=false;} 
        if ("".equals(txtRFC.getText())){vflag=false;} 
        if ("".equals(txtCURP.getText())){vflag=false;}
        if ("".equals(txtNEmpleado.getText())){vflag=false;} 
        if ("".equals(txtNombre.getText())){vflag=false;}
        if ("".equals(txtPaterno.getText())){vflag=false;}
        if ("".equals(txtMaterno.getText())){vflag=false;}
        if ("".equals(txtTEmpleado.getText())){vflag=false;}
        if ("".equals(txtSindicato.getText())){vflag=false;}
        if ("".equals(txtSector.getText())){vflag=false;}
        if ("".equals(txtFIngreso.getText())){vflag=false;} 
        if ("".equals(txtUAdministrativa.getText())){vflag=false;} 
        if ("".equals(txtSQuincenal.getText())){vflag=false;} 
        if ("".equals(txtDireccion.getText())){vflag=false;} 
        if ("".equals(txtEstado.getText())){vflag=false;} 
        if ("".equals(txtMunicipio.getText())){vflag=false;}
        if ("".equals(txtLocalidad.getText())){vflag=false;}
        if ("".equals(txtTelefono.getText())){vflag=false;}
        if ("".equals(txtMonto.getText())){vflag=false;}
        if ("".equals(txtQPlazo.getText())){vflag=false;}
        if ("".equals(txtPFQuinenal.getText())){vflag=false;}         
        if ("".equals(txtCLABE.getText())){vflag=false;}  
        return vflag;
    }

    public boolean llenaaval()
    {
        boolean vflag=true;
        if (!"".equals(txtIDAfiliadoA.getText()))
        {
            vflag=true;
            solicitudA.put("nplazaa", txtIDAfiliadoA.getText());
        } 
        if (!"".equals(txtRFCA.getText()))
        {
            vflag=false;
            solicitudA.put("rfca", txtRFCA.getText());
        } 
        if (!"".equals(txtCURPA.getText()))
        {
            vflag=false;
            solicitudA.put("curpa", txtCURPA.getText());
        }
        if (!"".equals(txtNEmpleadoA.getText()))
        {
            vflag=false;
            solicitudA.put("nempleadoa", txtNEmpleadoA.getText());
        } 
        if (!"".equals(txtNombreA.getText()))
        {
            vflag=false;
            solicitudA.put("nombrea", txtNombreA.getText());
        }
        if (!"".equals(txtPaternoA.getText()))
        {
            vflag=false;
            solicitudA.put("paternoa", txtPaternoA.getText());
        }
        if (!"".equals(txtMaternoA.getText()))
        {
            vflag=false;
            solicitudA.put("maternoa", txtMaternoA.getText());
        }
        if (!"".equals(txtTEmpleadoA.getText()))
        {
            vflag=false;
            solicitudA.put("tafiliadoa", txtTEmpleadoA.getText());
        }
        if (!"".equals(txtSindicatoA.getText()))
        {
            vflag=false;
            solicitudA.put("sindicatoa", txtSindicatoA.getText());
        
        }
        if (!"".equals(txtSectorA.getText()))
        {
            vflag=false;
            solicitudA.put("setora", txtSectorA.getText());
        }
        if (!"".equals(txtFIngresoA.getText()))
        {
            vflag=false;
            solicitudA.put("fingresoa", txtFIngresoA.getText());
        } 
        if (!"".equals(txtUAdministrativaA.getText()))
        {
            vflag=false;
            solicitudA.put("uadministrativaa",txtUAdministrativaA.getText());
        } 
        if (!"".equals(txtSQuincenalA.getText()))
        {
            vflag=false;
            solicitudA.put("sbasea", txtSQuincenalA.getText());
        } 
        if (!"".equals(txtDireccionA.getText()))
        {
            vflag=false;
            solicitudA.put("domicilioa", txtDireccionA.getText());
        
        } 
        if (!"".equals(txtEstadoA.getText()))
        {
            vflag=false;
            solicitudA.put("estadoa", txtEstadoA.getText());       
        } 
        if (!"".equals(txtMunicipioA.getText()))
        {
            vflag=false;
            solicitudA.put("municipioa", txtMunicipioA.getText());
        }
        if (!"".equals(txtLocalidadA.getText()))
        {
            vflag=false;
            solicitudA.put("localidada", txtLocalidadA.getText()); 
        }
        if (!"".equals(txtTelefonoA.getText()))
        {
            vflag=false;
            solicitudA.put("telefonoa", txtTelefonoA.getText());
        }
        if (!"".equals(txtTelefonoCelA.getText()))
        {
            vflag=false;
            solicitudA.put("telefonocela", txtTelefonoCelA.getText());
        }
        if (!"".equals(txtEMailA.getText()))
        {
            vflag=false;
            solicitudA.put("emaila", txtEMailA.getText());
        }
        return vflag;
    }
public boolean llenaconyuge()
    {
        boolean vflag=true;
        if (!"".equals(txtIDAfiliadoC.getText()))
        {
            vflag=true;
            solicitudC.put("nplazac", txtIDAfiliadoC.getText());
        } 
        if (!"".equals(txtRFCC.getText()))
        {
            vflag=false;
            solicitudC.put("rfcc", txtRFCC.getText());
        } 
        if (!"".equals(txtCURPC.getText()))
        {
            vflag=false;
            solicitudC.put("curpc", txtCURPC.getText());
        }
        if (!"".equals(txtNombreC.getText()))
        {
            vflag=false;
            solicitudC.put("nombrec", txtNombreC.getText());
        }
        if (!"".equals(txtPaternoC.getText()))
        {
            vflag=false;
            solicitudC.put("paternoc", txtPaternoC.getText());
        }
        if (!"".equals(txtMaternoC.getText()))
        {
            vflag=false;
            solicitudC.put("maternoc", txtMaternoC.getText());
        }
        if (!"".equals(txtDireccionC.getText()))
        {
            vflag=false;
            solicitudC.put("domicilioc", txtDireccionC.getText());
        
        } 
        if (!"".equals(txtEstadoC.getText()))
        {
            vflag=false;
            solicitudC.put("estadoc", txtEstadoC.getText());       
        } 
        if (!"".equals(txtMunicipioC.getText()))
        {
            vflag=false;
            solicitudC.put("municipioc", txtMunicipioC.getText());
        }
        if (!"".equals(txtLocalidadC.getText()))
        {
            vflag=false;
            solicitudC.put("localidadc", txtLocalidadC.getText()); 
        }
        if (!"".equals(txtTelefonoC.getText()))
        {
            vflag=false;
            solicitudC.put("telefonoc", txtTelefonoC.getText());
        }
        if (!"".equals(txtTelefonoCelC.getText()))
        {
            vflag=false;
            solicitudC.put("telefonocelc", txtTelefonoCelC.getText());
        }
        if (!"".equals(txtEMailC.getText()))
        {
            vflag=false;
            solicitudC.put("emailc", txtEMailC.getText());
        }
        return vflag;
    }    
    public boolean llenapricipal()
    {
        boolean vflag=true;
        if (!"".equals(txtIDAfiliado.getText()))
        {
            vflag=true;
            solicitudCV.put("nplaza", oempleado.Plaza);
            solicitudCV.put("rfc", oempleado.RFC);
            solicitudCV.put("curp", oempleado.CURP);
            solicitudCV.put("nempleado", oempleado.NoEmpleado);
            solicitudCV.put("nombre", oempleado.Nombres);
            solicitudCV.put("paterno", oempleado.Paterno);
            solicitudCV.put("materno", oempleado.Materno);
            solicitudCV.put("tafiliado", oempleado.CIdTipoEmpleado);
            solicitudCV.put("sindicato", oempleado.CIdSindicato);
            solicitudCV.put("setor", oempleado.CIdSector);
            solicitudCV.put("fingreso", txtFIngreso.getText());
            solicitudCV.put("uadministrativa", oempleado.UnidadAdministrativa);
            solicitudCV.put("sbase", txtSQuincenal.getText());
            solicitudCV.put("domicilio", oempleado.Dir);
            solicitudCV.put("estado", oempleado.estado);       
            solicitudCV.put("municipio", oempleado.ciudad);
            solicitudCV.put("localidad", oempleado.Col);
            solicitudCV.put("telefono", txtTelefono.getText());
            solicitudCV.put("importecs", txtMonto.getText());
            solicitudCV.put("telefonocel", txtTelefonoCel.getText());
            solicitudCV.put("email", txtEMail.getText());
        }
        return vflag;
    }
    
    
    public boolean isllenaformaaval()
    {
        boolean vflag=true;
        if ("".equals(txtIDAfiliadoA.getText())){vflag=false;} 
        if ("".equals(txtRFCA.getText())){vflag=false;} 
        if ("".equals(txtCURPA.getText())){vflag=false;}
        if ("".equals(txtNEmpleadoA.getText())){vflag=false;} 
        if ("".equals(txtNombreA.getText())){vflag=false;}
        if ("".equals(txtPaternoA.getText())){vflag=false;}
        if ("".equals(txtMaternoA.getText())){vflag=false;}
        if ("".equals(txtTEmpleadoA.getText())){vflag=false;}
        if ("".equals(txtSindicatoA.getText())){vflag=false;}
        if ("".equals(txtSectorA.getText())){vflag=false;}
        if ("".equals(txtFIngresoA.getText())){vflag=false;} 
        if ("".equals(txtUAdministrativaA.getText())){vflag=false;} 
        if ("".equals(txtSQuincenalA.getText())){vflag=false;} 
        if ("".equals(txtDireccionA.getText())){vflag=false;} 
        if ("".equals(txtEstadoA.getText())){vflag=false;} 
        if ("".equals(txtMunicipioA.getText())){vflag=false;}
        if ("".equals(txtLocalidadA.getText())){vflag=false;}
        if ("".equals(txtTelefonoA.getText())){vflag=false;}
        return vflag;
    }
     public boolean isllenaformaconyuge()
    {
        boolean vflag=true;
        if ("".equals(txtIDAfiliadoC.getText())){vflag=false;} 
        if ("".equals(txtRFCC.getText())){vflag=false;} 
        if ("".equals(txtCURPC.getText())){vflag=false;}
        if ("".equals(txtNombreC.getText())){vflag=false;}
        if ("".equals(txtPaternoC.getText())){vflag=false;}
        if ("".equals(txtMaternoC.getText())){vflag=false;} 
        if ("".equals(txtDireccionC.getText())){vflag=false;} 
        if ("".equals(txtEstadoC.getText())){vflag=false;} 
        if ("".equals(txtMunicipioC.getText())){vflag=false;}
        if ("".equals(txtLocalidadC.getText())){vflag=false;}
        if ("".equals(txtTelefonoC.getText())){vflag=false;}
        return vflag;
    }
    public boolean isllenadocumentos()
    {
        boolean vflag=true;
        if (cbxCredencialPCET.isSelected()==false){vflag=false;}
        if (cbxCPago.isSelected()==false){vflag=false;}
        if (cbxCDomicilio.isSelected()==false){vflag=false;}
        if (cbxCURP.isSelected()==false){vflag=false;}
        return vflag;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbngIdentificacion = new javax.swing.ButtonGroup();
        PDCredito = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cbxPrestamo = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtQPlazo = new javax.swing.JTextField();
        txtPFQuinenal = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        PEncabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PBotones = new javax.swing.JPanel();
        btnLimpiaForma = new javax.swing.JButton();
        btnSolicitud = new javax.swing.JButton();
        btnImprimeCalendario = new javax.swing.JButton();
        btnCapacidadPago = new javax.swing.JButton();
        btnPagare = new javax.swing.JButton();
        btnCarta = new javax.swing.JButton();
        MPSolicitud = new javax.swing.JTabbedPane();
        PDLaborales = new javax.swing.JPanel();
        PDTrabajador = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtIDAfiliado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCURP = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtNEmpleado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPaterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMaterno = new javax.swing.JTextField();
        txtSQuincenal = new javax.swing.JTextField();
        txtSindicato = new javax.swing.JTextField();
        txtUAdministrativa = new javax.swing.JTextField();
        txtSector = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtFIngreso = new javax.swing.JTextField();
        txtTEmpleado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtSNetoQ = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        txtCPago = new javax.swing.JTextField();
        PDireccion = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtLocalidad = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtTelefonoCel = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtEMail = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        cbxEmpleadoID = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        cbxBancos = new javax.swing.JComboBox();
        jLabel64 = new javax.swing.JLabel();
        txtCLABE = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        PDAval = new javax.swing.JPanel();
        PAval = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtNombreA = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtMaternoA = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtPaternoA = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtRFCA = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtCURPA = new javax.swing.JTextField();
        txtTEmpleadoA = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtSectorA = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtSindicatoA = new javax.swing.JTextField();
        txtFIngresoA = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtSQuincenalA = new javax.swing.JTextField();
        txtIDAfiliadoA = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtNEmpleadoA = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtUAdministrativaA = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        txtSNetoQA = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        txtCPagoA = new javax.swing.JTextField();
        PDireccion1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtDireccionA = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtTelefonoA = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtEstadoA = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtMunicipioA = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtLocalidadA = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtTelefonoCelA = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        txtEMailA = new javax.swing.JTextField();
        DPEsposa = new javax.swing.JPanel();
        PDConyuge = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtMaternoC = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtPaternoC = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtRFCC = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtCURPC = new javax.swing.JTextField();
        txtIDAfiliadoC = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        PDireccion2 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        txtDireccionC = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtTelefonoC = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txtEstadoC = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtMunicipioC = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtLocalidadC = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtTelefonoCelC = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtEMailC = new javax.swing.JTextField();
        PDocumentacion = new javax.swing.JPanel();
        PDoctos = new javax.swing.JPanel();
        cbxCredencialPCET = new javax.swing.JCheckBox();
        cbxCDomicilio = new javax.swing.JCheckBox();
        cbxCURP = new javax.swing.JCheckBox();
        jLabel34 = new javax.swing.JLabel();
        rbtnIFE = new javax.swing.JRadioButton();
        rbtnPasaporte = new javax.swing.JRadioButton();
        rbtnLicencia = new javax.swing.JRadioButton();
        rbtnCedula = new javax.swing.JRadioButton();
        cbxCPago = new javax.swing.JCheckBox();
        PTestigos = new javax.swing.JPanel();
        PDTestigo1 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        txtNombreT1 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtMaternoT1 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        txtPaternoT1 = new javax.swing.JTextField();
        txtIDAfiliadoT1 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        PDTestigo2 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        txtNombreT2 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtMaternoT2 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        txtPaternoT2 = new javax.swing.JTextField();
        txtIDAfiliadoT2 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel76 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CAPTURA DE SOLICITUD DE CREDITO");
        setBackground(new java.awt.Color(0, 255, 0));
        setName("frmCCredito"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        PDCredito.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setText("CREDITO:");

        cbxPrestamo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CREDITO VERDE", "CREDITO ROJO", "CREDITO HIPOTECARIO" }));
        cbxPrestamo.setName(""); // NOI18N
        cbxPrestamo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPrestamoItemStateChanged(evt);
            }
        });
        cbxPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPrestamoActionPerformed(evt);
            }
        });
        cbxPrestamo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbxPrestamoPropertyChange(evt);
            }
        });

        jLabel16.setText("MONTO:");

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        txtMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMontoFocusLost(evt);
            }
        });
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        jLabel23.setText("Q. PLAZO:");

        txtQPlazo.setEditable(false);

        txtPFQuinenal.setEditable(false);

        jLabel25.setText("P. FIJO QUINCENAL");

        javax.swing.GroupLayout PDCreditoLayout = new javax.swing.GroupLayout(PDCredito);
        PDCredito.setLayout(PDCreditoLayout);
        PDCreditoLayout.setHorizontalGroup(
            PDCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDCreditoLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtQPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPFQuinenal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PDCreditoLayout.setVerticalGroup(
            PDCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDCreditoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbxPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtQPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(txtPFQuinenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PEncabezado.setBackground(new java.awt.Color(0, 255, 0));

        jLabel1.setFont(new java.awt.Font("Trajan Pro", 0, 24)); // NOI18N
        jLabel1.setText("PENSIONES CIVILES DEL ESTADO DE TLAXCALA");

        javax.swing.GroupLayout PEncabezadoLayout = new javax.swing.GroupLayout(PEncabezado);
        PEncabezado.setLayout(PEncabezadoLayout);
        PEncabezadoLayout.setHorizontalGroup(
            PEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PEncabezadoLayout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PEncabezadoLayout.setVerticalGroup(
            PEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PEncabezadoLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(23, 23, 23))
        );

        PBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLimpiaForma.setText("LIMPIAR FORMA");
        btnLimpiaForma.setPreferredSize(new java.awt.Dimension(141, 23));
        btnLimpiaForma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiaFormaActionPerformed(evt);
            }
        });

        btnSolicitud.setText("SOLICITUD");
        btnSolicitud.setActionCommand("");
        btnSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitudActionPerformed(evt);
            }
        });

        btnImprimeCalendario.setText("IMPRIME CALENDARIO");
        btnImprimeCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimeCalendarioActionPerformed(evt);
            }
        });

        btnCapacidadPago.setText("CAPACIDAD DE PAGO");
        btnCapacidadPago.setName("btnCapacidadPago"); // NOI18N
        btnCapacidadPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapacidadPagoActionPerformed(evt);
            }
        });

        btnPagare.setLabel("PAGARE");
        btnPagare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagareActionPerformed(evt);
            }
        });

        btnCarta.setText("CARTA COMROMISO");
        btnCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PBotonesLayout = new javax.swing.GroupLayout(PBotones);
        PBotones.setLayout(PBotonesLayout);
        PBotonesLayout.setHorizontalGroup(
            PBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PBotonesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnLimpiaForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnImprimeCalendario)
                .addGap(18, 18, 18)
                .addComponent(btnCapacidadPago)
                .addGap(18, 18, 18)
                .addComponent(btnCarta)
                .addGap(18, 18, 18)
                .addComponent(btnSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPagare, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        PBotonesLayout.setVerticalGroup(
            PBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLimpiaForma, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btnPagare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimeCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapacidadPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCarta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSolicitud, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        MPSolicitud.setBackground(new java.awt.Color(0, 255, 0));
        MPSolicitud.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        PDLaborales.setBackground(new java.awt.Color(0, 255, 0));
        PDLaborales.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        PDTrabajador.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel17.setText("ID AFILIADO:");

        txtIDAfiliado.setName("txtName"); // NOI18N
        txtIDAfiliado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDAfiliadoActionPerformed(evt);
            }
        });
        txtIDAfiliado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDAfiliadoFocusLost(evt);
            }
        });

        jLabel5.setText("RFC:");

        txtRFC.setEditable(false);
        txtRFC.setName("txtName"); // NOI18N

        jLabel6.setText("CURP:");

        txtCURP.setName("txtName"); // NOI18N
        txtCURP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCURPActionPerformed(evt);
            }
        });
        txtCURP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCURPKeyTyped(evt);
            }
        });

        jLabel18.setText("NO. EMPLEADO:");

        txtNEmpleado.setEditable(false);
        txtNEmpleado.setName("txtName"); // NOI18N
        txtNEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNEmpleadoActionPerformed(evt);
            }
        });

        jLabel2.setText("NOMBRE:");

        txtNombre.setEditable(false);
        txtNombre.setName("txtName"); // NOI18N

        jLabel4.setText("A. PATERNO:");

        txtPaterno.setEditable(false);
        txtPaterno.setName("txtName"); // NOI18N

        jLabel3.setText("A. MATERNO:");

        txtMaterno.setEditable(false);
        txtMaterno.setName("txtName"); // NOI18N

        txtSQuincenal.setEditable(false);
        txtSQuincenal.setName("txtName"); // NOI18N

        txtSindicato.setEditable(false);
        txtSindicato.setName("txtName"); // NOI18N

        txtUAdministrativa.setEditable(false);
        txtUAdministrativa.setName("txtName"); // NOI18N

        txtSector.setEditable(false);
        txtSector.setName("txtName"); // NOI18N

        jLabel10.setText("SECTOR:");

        jLabel12.setText("U. ADMINITRATIVA:");

        txtFIngreso.setEditable(false);
        txtFIngreso.setName("txtName"); // NOI18N

        txtTEmpleado.setEditable(false);
        txtTEmpleado.setName("txtName"); // NOI18N

        jLabel9.setText("T. EMPLEADO:");

        jLabel14.setText("F. INGRESO:");

        jLabel15.setText("SALARIO BASE QUINCENAL:");

        jLabel11.setText("SINDICATO:");

        jLabel52.setText("SALARIO NETO QUINCENAL:");

        txtSNetoQ.setName("txtName"); // NOI18N
        txtSNetoQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSNetoQActionPerformed(evt);
            }
        });
        txtSNetoQ.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSNetoQFocusLost(evt);
            }
        });
        txtSNetoQ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSNetoQKeyTyped(evt);
            }
        });

        jLabel75.setText("CAPACIDAD DE PAGO:");

        txtCPago.setEditable(false);
        txtCPago.setName("txtName"); // NOI18N
        txtCPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPagoActionPerformed(evt);
            }
        });
        txtCPago.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCPagoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout PDTrabajadorLayout = new javax.swing.GroupLayout(PDTrabajador);
        PDTrabajador.setLayout(PDTrabajadorLayout);
        PDTrabajadorLayout.setHorizontalGroup(
            PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDTrabajadorLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PDTrabajadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(PDTrabajadorLayout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtSQuincenal, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel52)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSNetoQ, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel75)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCPago, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PDTrabajadorLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSector, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtUAdministrativa, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PDTrabajadorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PDTrabajadorLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(12, 12, 12)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3))
                        .addGroup(PDTrabajadorLayout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtIDAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PDTrabajadorLayout.setVerticalGroup(
            PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PDTrabajadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel18)
                    .addComponent(txtNEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtTEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSindicato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(txtUAdministrativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSQuincenal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtFIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel52)
                    .addComponent(txtSNetoQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75)
                    .addComponent(txtCPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PDTrabajadorLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtIDAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(9, 9, 9)
                    .addGroup(PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        PDireccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setText("DIRECCION:");

        txtDireccion.setEditable(false);
        txtDireccion.setName("txtName"); // NOI18N

        jLabel8.setText("TELEFONO CASA:");

        txtTelefono.setText("0");
        txtTelefono.setName("txtName"); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel19.setText("ESTADO:");

        txtEstado.setEditable(false);
        txtEstado.setName("txtName"); // NOI18N

        jLabel20.setText("MUNICIPIO:");

        txtMunicipio.setEditable(false);
        txtMunicipio.setName("txtName"); // NOI18N

        jLabel21.setText("LOCALIDAD:");

        txtLocalidad.setEditable(false);
        txtLocalidad.setName("txtName"); // NOI18N

        jLabel45.setText("TELEFONO CELULAR:");

        txtTelefonoCel.setText("0");
        txtTelefonoCel.setName("txtName"); // NOI18N
        txtTelefonoCel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoCelKeyTyped(evt);
            }
        });

        jLabel46.setText("E-MAIL:");

        txtEMail.setText("0");
        txtEMail.setName("txtName"); // NOI18N

        jLabel78.setText("IDENTIFICACIÓN:");

        cbxEmpleadoID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CREDENCIAL DE ELECTOR", "PASAPORTE", "LICENCIA DE CONDUCIR", "CEDULA PROFESIONAL" }));
        cbxEmpleadoID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxEmpleadoIDItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout PDireccionLayout = new javax.swing.GroupLayout(PDireccion);
        PDireccion.setLayout(PDireccionLayout);
        PDireccionLayout.setHorizontalGroup(
            PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDireccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PDireccionLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel78)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxEmpleadoID, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PDireccionLayout.createSequentialGroup()
                        .addGroup(PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PDireccionLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21))
                            .addGroup(PDireccionLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel45)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefonoCel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PDireccionLayout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addGap(18, 18, 18)
                                .addComponent(txtEMail, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PDireccionLayout.setVerticalGroup(
            PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDireccionLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxEmpleadoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel78))
                    .addGroup(PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(txtEMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel45)
                        .addComponent(txtTelefonoCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        cbxBancos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "BBVA BANCOMER", "BANAMEX", "HSBC", "SANTANDER", "SCOTIABANK", "BANCO AZTECA", "BANORTE", "BANCO INBURSA", "BANCO DEL BAJIO", "IXE BANCO", "BANCA MIFEL", "BANCO ACTINVER", " " }));

        jLabel64.setText("BANCO:");

        txtCLABE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCLABEFocusLost(evt);
            }
        });
        txtCLABE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCLABEKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCLABEKeyPressed(evt);
            }
        });

        jLabel65.setText("CLABE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64)
                .addGap(18, 18, 18)
                .addComponent(cbxBancos, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel65)
                .addGap(18, 18, 18)
                .addComponent(txtCLABE, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel65)
                        .addComponent(txtCLABE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbxBancos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel64)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PDLaboralesLayout = new javax.swing.GroupLayout(PDLaborales);
        PDLaborales.setLayout(PDLaboralesLayout);
        PDLaboralesLayout.setHorizontalGroup(
            PDLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDLaboralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PDTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        PDLaboralesLayout.setVerticalGroup(
            PDLaboralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDLaboralesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PDTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        MPSolicitud.addTab("SOLICITUD", PDLaborales);

        PDAval.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PDAval.setToolTipText("DATOS DEL AVAL");

        PAval.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel26.setText("NOMBRE:");

        txtNombreA.setEditable(false);
        txtNombreA.setName("txtName"); // NOI18N

        jLabel27.setText("A. MATERNO:");

        txtMaternoA.setEditable(false);
        txtMaternoA.setName("txtName"); // NOI18N

        jLabel28.setText("A. PATERNO:");

        txtPaternoA.setEditable(false);
        txtPaternoA.setName("txtName"); // NOI18N
        txtPaternoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaternoAActionPerformed(evt);
            }
        });

        jLabel29.setText("RFC:");

        txtRFCA.setEditable(false);
        txtRFCA.setName("txtName"); // NOI18N
        txtRFCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCAActionPerformed(evt);
            }
        });

        jLabel30.setText("CURP:");

        txtCURPA.setName("txtName"); // NOI18N
        txtCURPA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCURPAActionPerformed(evt);
            }
        });

        txtTEmpleadoA.setEditable(false);
        txtTEmpleadoA.setName("txtName"); // NOI18N
        txtTEmpleadoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTEmpleadoAActionPerformed(evt);
            }
        });

        jLabel31.setText("T. EMPLEADO:");

        jLabel32.setText("SECTOR:");

        txtSectorA.setEditable(false);
        txtSectorA.setName("txtName"); // NOI18N
        txtSectorA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSectorAActionPerformed(evt);
            }
        });

        jLabel33.setText("SINDICATO:");

        txtSindicatoA.setEditable(false);
        txtSindicatoA.setName("txtName"); // NOI18N
        txtSindicatoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSindicatoAActionPerformed(evt);
            }
        });

        txtFIngresoA.setEditable(false);
        txtFIngresoA.setName("txtName"); // NOI18N
        txtFIngresoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFIngresoAActionPerformed(evt);
            }
        });

        jLabel35.setText("F. INGRESO:");

        jLabel36.setText("SALARIO QUINCENAL:");

        txtSQuincenalA.setEditable(false);
        txtSQuincenalA.setName("txtName"); // NOI18N
        txtSQuincenalA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSQuincenalAActionPerformed(evt);
            }
        });

        txtIDAfiliadoA.setName("txtName"); // NOI18N
        txtIDAfiliadoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDAfiliadoAActionPerformed(evt);
            }
        });
        txtIDAfiliadoA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDAfiliadoAFocusLost(evt);
            }
        });

        jLabel37.setText("ID AFILIADO:");

        txtNEmpleadoA.setEditable(false);
        txtNEmpleadoA.setName("txtName"); // NOI18N
        txtNEmpleadoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNEmpleadoAActionPerformed(evt);
            }
        });

        jLabel38.setText("NO. EMPLEADO:");

        jLabel53.setText("U. ADMINITRATIVA:");

        txtUAdministrativaA.setEditable(false);
        txtUAdministrativaA.setName("txtName"); // NOI18N

        jLabel73.setText("SALARIO NETO QUINCENAL:");

        txtSNetoQA.setName("txtName"); // NOI18N
        txtSNetoQA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSNetoQAActionPerformed(evt);
            }
        });
        txtSNetoQA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSNetoQAFocusLost(evt);
            }
        });

        jLabel74.setText("CAPACIDAD DE PAGO:");

        txtCPagoA.setEditable(false);
        txtCPagoA.setName("txtName"); // NOI18N
        txtCPagoA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPagoAActionPerformed(evt);
            }
        });
        txtCPagoA.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCPagoAFocusLost(evt);
            }
        });

        javax.swing.GroupLayout PAvalLayout = new javax.swing.GroupLayout(PAval);
        PAval.setLayout(PAvalLayout);
        PAvalLayout.setHorizontalGroup(
            PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PAvalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAvalLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFIngresoA, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel36)
                        .addGap(12, 12, 12)
                        .addComponent(txtSQuincenalA, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel73)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSNetoQA, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel74)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPagoA, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(206, 206, 206))
                    .addGroup(PAvalLayout.createSequentialGroup()
                        .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PAvalLayout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIDAfiliadoA, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRFCA, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(txtCURPA, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNEmpleadoA, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTEmpleadoA, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PAvalLayout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSindicatoA, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSectorA, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel53))
                            .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtUAdministrativaA, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PAvalLayout.createSequentialGroup()
                                    .addComponent(jLabel26)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel28)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPaternoA, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel27)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtMaternoA, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PAvalLayout.setVerticalGroup(
            PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PAvalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtRFCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(txtCURPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(txtIDAfiliadoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel31)
                    .addComponent(txtNEmpleadoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTEmpleadoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtNombreA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(txtPaternoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtMaternoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel53)
                        .addComponent(txtUAdministrativaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(txtSectorA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSindicatoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel33)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(txtFIngresoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(txtSQuincenalA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel73)
                        .addComponent(txtSNetoQA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel74)
                        .addComponent(txtCPagoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        PDireccion1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setText("DIRECCION:");

        txtDireccionA.setEditable(false);
        txtDireccionA.setName("txtName"); // NOI18N

        jLabel24.setText("TELEFONO CASA:");

        txtTelefonoA.setText("0");
        txtTelefonoA.setName("txtName"); // NOI18N

        jLabel54.setText("ESTADO:");

        txtEstadoA.setEditable(false);
        txtEstadoA.setName("txtName"); // NOI18N

        jLabel55.setText("MUNICIPIO:");

        txtMunicipioA.setEditable(false);
        txtMunicipioA.setName("txtName"); // NOI18N

        jLabel56.setText("LOCALIDAD:");

        txtLocalidadA.setEditable(false);
        txtLocalidadA.setName("txtName"); // NOI18N

        jLabel47.setText("TELEFONO CELULAR:");

        txtTelefonoCelA.setText("0");
        txtTelefonoCelA.setName("txtName"); // NOI18N
        txtTelefonoCelA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoCelAActionPerformed(evt);
            }
        });

        jLabel48.setText("E-MAIL:");

        txtEMailA.setText("0");
        txtEMailA.setName("txtName"); // NOI18N

        javax.swing.GroupLayout PDireccion1Layout = new javax.swing.GroupLayout(PDireccion1);
        PDireccion1.setLayout(PDireccion1Layout);
        PDireccion1Layout.setHorizontalGroup(
            PDireccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDireccion1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDireccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PDireccion1Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstadoA, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel55)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMunicipioA, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLocalidadA, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PDireccion1Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccionA, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PDireccion1Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefonoA, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel47)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefonoCelA, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel48)
                        .addGap(18, 18, 18)
                        .addComponent(txtEMailA, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PDireccion1Layout.setVerticalGroup(
            PDireccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDireccion1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDireccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtDireccionA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(PDireccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jLabel55)
                    .addComponent(txtMunicipioA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56)
                    .addComponent(txtLocalidadA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PDireccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PDireccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel47)
                        .addComponent(txtTelefonoCelA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel48)
                        .addComponent(txtEMailA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PDireccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(txtTelefonoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout PDAvalLayout = new javax.swing.GroupLayout(PDAval);
        PDAval.setLayout(PDAvalLayout);
        PDAvalLayout.setHorizontalGroup(
            PDAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PDAvalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PDAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PDireccion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PAval, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addGap(229, 229, 229))
        );
        PDAvalLayout.setVerticalGroup(
            PDAvalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDAvalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(PAval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        MPSolicitud.addTab("DATOS DEL AVAL", PDAval);
        PDAval.getAccessibleContext().setAccessibleName("");

        PDConyuge.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel40.setText("NOMBRE:");

        txtNombreC.setName("txtName"); // NOI18N

        jLabel41.setText("A. MATERNO:");

        txtMaternoC.setName("txtName"); // NOI18N

        jLabel42.setText("A. PATERNO:");

        txtPaternoC.setName("txtName"); // NOI18N
        txtPaternoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaternoCActionPerformed(evt);
            }
        });

        jLabel43.setText("RFC:");

        txtRFCC.setName("txtName"); // NOI18N
        txtRFCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRFCCActionPerformed(evt);
            }
        });

        jLabel44.setText("CURP:");

        txtCURPC.setName("txtName"); // NOI18N
        txtCURPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCURPCActionPerformed(evt);
            }
        });

        txtIDAfiliadoC.setName("txtName"); // NOI18N
        txtIDAfiliadoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDAfiliadoCActionPerformed(evt);
            }
        });

        jLabel51.setText("ID AFILIADO:");

        javax.swing.GroupLayout PDConyugeLayout = new javax.swing.GroupLayout(PDConyuge);
        PDConyuge.setLayout(PDConyugeLayout);
        PDConyugeLayout.setHorizontalGroup(
            PDConyugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 931, Short.MAX_VALUE)
            .addGroup(PDConyugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PDConyugeLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(PDConyugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PDConyugeLayout.createSequentialGroup()
                            .addComponent(jLabel40)
                            .addGap(12, 12, 12)
                            .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel42)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPaternoC, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel41)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMaternoC, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PDConyugeLayout.createSequentialGroup()
                            .addComponent(jLabel51)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtIDAfiliadoC, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel43)
                            .addGap(18, 18, 18)
                            .addComponent(txtRFCC, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel44)
                            .addGap(18, 18, 18)
                            .addComponent(txtCURPC, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 28, Short.MAX_VALUE)))
        );
        PDConyugeLayout.setVerticalGroup(
            PDConyugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
            .addGroup(PDConyugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PDConyugeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PDConyugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel43)
                        .addComponent(txtRFCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44)
                        .addComponent(txtCURPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel51)
                        .addComponent(txtIDAfiliadoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(9, 9, 9)
                    .addGroup(PDConyugeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(txtNombreC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel42)
                        .addComponent(jLabel41)
                        .addComponent(txtMaternoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPaternoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        PDireccion2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel39.setText("DIRECCION:");

        txtDireccionC.setName("txtName"); // NOI18N

        jLabel57.setText("TELEFONO:");

        txtTelefonoC.setName("txtName"); // NOI18N

        jLabel58.setText("ESTADO:");

        txtEstadoC.setName("txtName"); // NOI18N

        jLabel59.setText("MUNICIPIO:");

        txtMunicipioC.setName("txtName"); // NOI18N

        jLabel60.setText("LOCALIDAD:");

        txtLocalidadC.setName("txtName"); // NOI18N

        jLabel49.setText("TELEFONO CELULAR:");

        txtTelefonoCelC.setName("txtName"); // NOI18N

        jLabel50.setText("E-MAIL:");

        txtEMailC.setName("txtName"); // NOI18N

        javax.swing.GroupLayout PDireccion2Layout = new javax.swing.GroupLayout(PDireccion2);
        PDireccion2.setLayout(PDireccion2Layout);
        PDireccion2Layout.setHorizontalGroup(
            PDireccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDireccion2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDireccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PDireccion2Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstadoC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMunicipioC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLocalidadC, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PDireccion2Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PDireccion2Layout.createSequentialGroup()
                        .addComponent(jLabel57)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefonoC, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel49)
                        .addGap(18, 18, 18)
                        .addComponent(txtTelefonoCelC, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel50)
                        .addGap(18, 18, 18)
                        .addComponent(txtEMailC, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PDireccion2Layout.setVerticalGroup(
            PDireccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDireccion2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDireccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtDireccionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(PDireccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59)
                    .addComponent(txtMunicipioC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(txtLocalidadC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PDireccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PDireccion2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(PDireccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(txtTelefonoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PDireccion2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(PDireccion2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(txtTelefonoCelC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)
                            .addComponent(txtEMailC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout DPEsposaLayout = new javax.swing.GroupLayout(DPEsposa);
        DPEsposa.setLayout(DPEsposaLayout);
        DPEsposaLayout.setHorizontalGroup(
            DPEsposaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DPEsposaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DPEsposaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PDireccion2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DPEsposaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PDConyuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        DPEsposaLayout.setVerticalGroup(
            DPEsposaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DPEsposaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(PDConyuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PDireccion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        MPSolicitud.addTab("DATOS DE CONYUGE", DPEsposa);

        cbxCredencialPCET.setText("CREDENCIAL EXPEDIDA POR PCET");
        cbxCredencialPCET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCredencialPCETActionPerformed(evt);
            }
        });

        cbxCDomicilio.setText("COMPROBANTE DE DOMICILIO VIGENTE");

        cbxCURP.setText("COPIA SIMPLE DE LA CLAVE ÚNICA DE REGISTRO DE POBLACIÓN");

        jLabel34.setText("IDENTIFICACIÓN OFICIAL CON FOTOGRAFÍA");

        rbngIdentificacion.add(rbtnIFE);
        rbtnIFE.setSelected(true);
        rbtnIFE.setText("I.F.E.");
        rbtnIFE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnIFEActionPerformed(evt);
            }
        });

        rbngIdentificacion.add(rbtnPasaporte);
        rbtnPasaporte.setText("PASAPORTE");
        rbtnPasaporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnPasaporteActionPerformed(evt);
            }
        });

        rbngIdentificacion.add(rbtnLicencia);
        rbtnLicencia.setText("LICENCIA DE CONDUCIR");
        rbtnLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnLicenciaActionPerformed(evt);
            }
        });

        rbngIdentificacion.add(rbtnCedula);
        rbtnCedula.setText("CEDUAL PROFECIONAL");
        rbtnCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnCedulaActionPerformed(evt);
            }
        });

        cbxCPago.setText("ÚLTIMOS TRES COMPROBANTES DE PAGO");

        javax.swing.GroupLayout PDoctosLayout = new javax.swing.GroupLayout(PDoctos);
        PDoctos.setLayout(PDoctosLayout);
        PDoctosLayout.setHorizontalGroup(
            PDoctosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PDoctosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addGap(105, 105, 105))
            .addGroup(PDoctosLayout.createSequentialGroup()
                .addGroup(PDoctosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PDoctosLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(PDoctosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxCDomicilio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxCredencialPCET, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxCURP, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                            .addComponent(cbxCPago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)))
                    .addGroup(PDoctosLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(PDoctosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbtnIFE)
                            .addComponent(rbtnCedula)
                            .addComponent(rbtnLicencia)
                            .addComponent(rbtnPasaporte))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PDoctosLayout.setVerticalGroup(
            PDoctosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDoctosLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(cbxCPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxCredencialPCET)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxCDomicilio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxCURP)
                .addGap(15, 15, 15)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnIFE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnPasaporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbtnLicencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnCedula)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PDocumentacionLayout = new javax.swing.GroupLayout(PDocumentacion);
        PDocumentacion.setLayout(PDocumentacionLayout);
        PDocumentacionLayout.setHorizontalGroup(
            PDocumentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDocumentacionLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(PDoctos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );
        PDocumentacionLayout.setVerticalGroup(
            PDocumentacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDocumentacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PDoctos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MPSolicitud.addTab("DOCUMENTACIÓN", PDocumentacion);

        PTestigos.setEnabled(false);

        PDTestigo1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel61.setText("NOMBRE:");

        txtNombreT1.setName("txtName"); // NOI18N

        jLabel62.setText("A. MATERNO:");

        txtMaternoT1.setName("txtName"); // NOI18N

        jLabel63.setText("A. PATERNO:");

        txtPaternoT1.setName("txtName"); // NOI18N
        txtPaternoT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaternoT1ActionPerformed(evt);
            }
        });

        txtIDAfiliadoT1.setName("txtName"); // NOI18N
        txtIDAfiliadoT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDAfiliadoT1ActionPerformed(evt);
            }
        });
        txtIDAfiliadoT1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDAfiliadoT1FocusLost(evt);
            }
        });

        jLabel66.setText("ID AFILIADO:");

        jLabel77.setText("IDENTIFICACIÓN:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CREDENCIAL DE ELECTOR", "PASAPORTE", "LICENCIA DE CONDUCIR", "CEDULA PROFESIONAL" }));

        javax.swing.GroupLayout PDTestigo1Layout = new javax.swing.GroupLayout(PDTestigo1);
        PDTestigo1.setLayout(PDTestigo1Layout);
        PDTestigo1Layout.setHorizontalGroup(
            PDTestigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDTestigo1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel77)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
            .addGroup(PDTestigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PDTestigo1Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(PDTestigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PDTestigo1Layout.createSequentialGroup()
                            .addComponent(jLabel61)
                            .addGap(12, 12, 12)
                            .addComponent(txtNombreT1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel63)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPaternoT1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel62)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMaternoT1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PDTestigo1Layout.createSequentialGroup()
                            .addComponent(jLabel66)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtIDAfiliadoT1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 16, Short.MAX_VALUE)))
        );
        PDTestigo1Layout.setVerticalGroup(
            PDTestigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDTestigo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDTestigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel77))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(PDTestigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PDTestigo1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PDTestigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel66)
                        .addComponent(txtIDAfiliadoT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(9, 9, 9)
                    .addGroup(PDTestigo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel61)
                        .addComponent(txtNombreT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel63)
                        .addComponent(jLabel62)
                        .addComponent(txtMaternoT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPaternoT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(32, Short.MAX_VALUE)))
        );

        PDTestigo2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel67.setText("NOMBRE:");

        txtNombreT2.setName("txtName"); // NOI18N

        jLabel68.setText("A. MATERNO:");

        txtMaternoT2.setName("txtName"); // NOI18N

        jLabel69.setText("A. PATERNO:");

        txtPaternoT2.setName("txtName"); // NOI18N
        txtPaternoT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaternoT2ActionPerformed(evt);
            }
        });

        txtIDAfiliadoT2.setName("txtName"); // NOI18N
        txtIDAfiliadoT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDAfiliadoT2ActionPerformed(evt);
            }
        });
        txtIDAfiliadoT2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDAfiliadoT2FocusLost(evt);
            }
        });

        jLabel72.setText("ID AFILIADO:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CREDENCIAL DE ELECTOR", "PASAPORTE", "LICENCIA DE CONDUCIR", "CEDULA PROFESIONAL" }));

        jLabel76.setText("IDENTIFICACIÓN:");

        javax.swing.GroupLayout PDTestigo2Layout = new javax.swing.GroupLayout(PDTestigo2);
        PDTestigo2.setLayout(PDTestigo2Layout);
        PDTestigo2Layout.setHorizontalGroup(
            PDTestigo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDTestigo2Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel76)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(410, Short.MAX_VALUE))
            .addGroup(PDTestigo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PDTestigo2Layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addGroup(PDTestigo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PDTestigo2Layout.createSequentialGroup()
                            .addComponent(jLabel67)
                            .addGap(12, 12, 12)
                            .addComponent(txtNombreT2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel69)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPaternoT2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel68)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMaternoT2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PDTestigo2Layout.createSequentialGroup()
                            .addComponent(jLabel72)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtIDAfiliadoT2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 16, Short.MAX_VALUE)))
        );
        PDTestigo2Layout.setVerticalGroup(
            PDTestigo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDTestigo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDTestigo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(PDTestigo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PDTestigo2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PDTestigo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel72)
                        .addComponent(txtIDAfiliadoT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(9, 9, 9)
                    .addGroup(PDTestigo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel67)
                        .addComponent(txtNombreT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel69)
                        .addComponent(jLabel68)
                        .addComponent(txtMaternoT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPaternoT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(32, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout PTestigosLayout = new javax.swing.GroupLayout(PTestigos);
        PTestigos.setLayout(PTestigosLayout);
        PTestigosLayout.setHorizontalGroup(
            PTestigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PTestigosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PDTestigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(PTestigosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PDTestigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PTestigosLayout.setVerticalGroup(
            PTestigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PTestigosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(PDTestigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PDTestigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        MPSolicitud.addTab("TESTIGOS", PTestigos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(PDCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MPSolicitud, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(PEncabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MPSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PDCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        MPSolicitud.setEnabledAt(0, true);
        MPSolicitud.setEnabledAt(1, false);
        MPSolicitud.setEnabledAt(2, false);
        MPSolicitud.setEnabledAt(3, true);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiaFormaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiaFormaActionPerformed
        // TODO add your handling code here:
        limpiaAfiliado();
        limpiaAval();
        limpiaConyuge();
        limpiaDocumentos();
    }//GEN-LAST:event_btnLimpiaFormaActionPerformed

    private void btnSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitudActionPerformed
        // TODO add your handling code here:
        boolean vp=isllenaformaprincipal();
        boolean va=isllenaformaaval();
        boolean vc=isllenaformaconyuge();
        boolean vd=isllenadocumentos();
        String CURP="";
        String TelCasa="";
        String TelCel="";
        String EMail="";
        int tc=cbxPrestamo.getSelectedIndex();
        String solicitud;
        String fecha;
        int nc;
        Calendar c = new GregorianCalendar();
        Date fecha1 = new Date();
        credito nuevoc= new credito();
        empleado ecurp=new empleado();
        Map map3= new HashMap();
        if (!"".equals(txtCURP.getText())){CURP=txtCURP.getText();}
        if (!"".equals(txtTelefono.getText())){TelCasa=txtTelefono.getText();}
        if (!"".equals(txtTelefonoCel.getText())){TelCel=txtTelefonoCel.getText();}
        if (!"".equals(txtEMail.getText())){EMail=txtEMail.getText();}
        oempleado.EMail=EMail;
        oempleado.CURP=CURP;
        oempleado.TelefonoCasa=TelCasa;
        oempleado.TelefonoCelular=TelCel;
        oempleado.guardaEmpleadoCURP();
        BANCO=cbxBancos.getSelectedIndex();
        empleadoBanco eBanco= new empleadoBanco();
        eBanco.setEpleadoBanco(oempleado.IdAfil, CLABE, BANCO);
        eBanco.capturaBanco();
        double pg;
        if (tc == 0 )
        {
            if (vp=true && vd==true)
            {
                llenapricipal();
                nc=nuevoc.numeroCredito(tc,c.get(Calendar.YEAR));                
                nuevoc.IdCredito=tc;
                nuevoc.ano=c.get(Calendar.YEAR);
                nuevoc.NCredito=nc;
                nuevoc.IdEmpleado=oempleado.IdAfil;
                nuevoc.IdAval=0;
                nuevoc.Montos=Double.parseDouble(txtMonto.getText());
                nuevoc.IdCapturista=IdCapturista;
                nuevoc.Estatus=0; //estatus solicitud pendiente a autorización
                //en este procedimiento actual 21/02/2013
                //los creditos al capturarlos ya estan autorizados, 
                //x lo que ya se guarda su aportación quincenal y montoa
                nuevoc.Montoa=Double.parseDouble(txtMonto.getText()); 
                nuevoc.Aportacion=Double.parseDouble(txtPFQuinenal.getText());
                nuevoc.capturaCredito();
                nuevoc.Estatus=1; //estatus credito autorizado
                nuevoc.autorizaCredito();
                NOPAGARE="V-"+Integer.toString(c.get(Calendar.YEAR))+"-"+String.format("%05d",nc);
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                fecha=formateador.format(fecha1);
                //falta checar q no esten null
                ecurp.setEmpleadoCURP(Integer.getInteger(txtIDAfiliado.getText()), CURP, TelCasa, TelCel, EMail);
                solicitudCV.put("nsolicitud", NOPAGARE);
                solicitudCV.put("fsolicitud", fecha);
                //reporteSolicitud reps = new reporteSolicitud(solicitudCV);
                try {
                    //reps.generaSolicitud(tc);
                    limpiaAfiliado();
                    limpiaAval();
                    limpiaConyuge();
                    limpiaDocumentos();                    
                } 
                catch (Exception ex) {
                    Logger.getLogger(capturaCredito.class.getName()).log(Level.SEVERE, null, ex);
                }       
            }
            else
            {
            JOptionPane.showMessageDialog(null, "LA FORMA NO ESTA LLENADA ADECUADAMENTE");
            }
        }
        if ((tc == 1) )      
        {
            if(oempleado.IdTipoEmpleado>=6){va=true;}
            if (vp=true && vd==true && va==true  )
            {
                llenapricipal();
                //llenaaval();
                nc=nuevoc.numeroCredito(tc,c.get(Calendar.YEAR)); 
                nuevoc.IdCredito=tc;
                nuevoc.ano=c.get(Calendar.YEAR);
                nuevoc.NCredito=nc;
                nuevoc.IdEmpleado=oempleado.IdAfil;
                if(oempleado.IdTipoEmpleado>=6)
                {
                    nuevoc.IdAval=0;
                }
                else
                {
                    nuevoc.IdAval=Integer.parseInt(txtIDAfiliadoA.getText());
                }
                
                nuevoc.Montos=Double.parseDouble(txtMonto.getText());
                nuevoc.IdCapturista=IdCapturista;
                nuevoc.Estatus=0; //estatus pendiente de solicitud
                //en este procedimiento actual 21/02/2013
                //los creditos al capturarlos ya estan autorizados, 
                //x lo que ya se guarda su aportación quincenal y montoa
                nuevoc.Montoa=Double.parseDouble(txtMonto.getText()); 
                nuevoc.Aportacion=Double.parseDouble(txtPFQuinenal.getText());
                nuevoc.capturaCredito();
                nuevoc.Estatus=1; //estatus credito autorizado
                nuevoc.autorizaCredito();                
                nuevoc.capturaCredito();
                NOPAGARE="R-"+Integer.toString(c.get(Calendar.YEAR))+"-"+String.format("%05d",nc);
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                fecha=formateador.format(fecha1);
                solicitudCV.put("nsolicitud", NOPAGARE);
                solicitudCV.put("fsolicitud", fecha);                
                map3.putAll(solicitudCV);
                map3.putAll(solicitudA);
                //reporteSolicitud reps = new reporteSolicitud(map3);
                try {
                    //reps.generaSolicitud(tc);
                    limpiaAfiliado();
                    limpiaAval();
                    limpiaConyuge();
                    limpiaDocumentos();                    
                } 
                catch (Exception ex) {
                    Logger.getLogger(capturaCredito.class.getName()).log(Level.SEVERE, null, ex);
                }       
            } 
            else
            {
                JOptionPane.showMessageDialog(null, "LA FORMA NO ESTA LLENADA ADECUADAMENTE");
            }            
        }
        if (tc == 2 )
        {
            if (vp=true && vd==true && vc==true )
            {
                llenapricipal();
                llenaconyuge();
                nc=nuevoc.numeroCredito(tc,c.get(Calendar.YEAR)); 
                nuevoc.IdCredito=tc;
                nuevoc.ano=c.get(Calendar.YEAR);
                nuevoc.NCredito=nc;
                nuevoc.IdEmpleado=oempleado.IdAfil;
                nuevoc.IdAval=0;
                nuevoc.Montos=Double.parseDouble(txtMonto.getText());
                nuevoc.IdCapturista=IdCapturista;
                nuevoc.Estatus=0; //estatus solicitud
                nuevoc.capturaCredito();
                NOPAGARE="H-"+Integer.toString(c.get(Calendar.YEAR))+"-"+String.format("%05d",nc);
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                fecha=formateador.format(fecha1);
                solicitudCV.put("nsolicitud", NOPAGARE);
                solicitudCV.put("fsolicitud", fecha);                  
                map3.putAll(solicitudCV);
                map3.putAll(solicitudC);                
                //reporteSolicitud reps = new reporteSolicitud(map3);
                try {
                    //reps.generaSolicitud(tc);
                    limpiaAfiliado();
                    limpiaAval();
                    limpiaConyuge();
                    limpiaDocumentos();
                } 
                catch (Exception ex) {
                    Logger.getLogger(capturaCredito.class.getName()).log(Level.SEVERE, null, ex);
                }       
            } 
            else
            {
                JOptionPane.showMessageDialog(null, "LA FORMA NO ESTA LLENADA ADECUADAMENTE");
            }            
        }
    }//GEN-LAST:event_btnSolicitudActionPerformed

    private void btnImprimeCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimeCalendarioActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        boolean vp=isllenaformaprincipal();
        double taza;     
        truncaDecimal trdec=new truncaDecimal();
        LinkedList<pagoQuincenal> pQ;
        double vmontos=Double.parseDouble(txtMonto.getText());
        int plazo=0;
        int tc=cbxPrestamo.getSelectedIndex();
           // checapago=vpago.cuota(checamonto, taza, plazo);
        if (tc==0){plazo=24;}
        if (tc==1){plazo=72;}
        if (tc==2){plazo=360;}
        taza=(double)0.20/24;//(double)plazo; 
        String solicitud;
        String fecha;
        int nc;
        Calendar c = new GregorianCalendar();
        Date fecha1 = new Date();
        credito nuevoc= new credito();
        Map mapx= new HashMap();
        pago np= new pago();
        double totalInteres=0;
        double totalTotal;
        double pg;//MONTOSOLICITADO
        pagoQuincenal pqui=new pagoQuincenal(0,0,0,0,0,0);
            if (vp=true)
            {
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                fecha=formateador.format(fecha1);
                mapx.put("nombre", oempleado.Nombres+" "+oempleado.Paterno+" "+oempleado.Materno);
                 //pquincenales(monto, taza, plazo, quincena)
                pQ=np.pquincenales(vmontos, taza, plazo,0);
                //PAGOQUINCENAL=pQ.
                int j=pQ.size();           
                for (int l=0;l<j;l++)
                {
                    pqui=pQ.get(l);
                    totalInteres=totalInteres+pqui.getpagointeres();  
                }
                totalInteres=trdec.getDecimal(2, totalInteres);
                totalTotal=MONTOSOLICITADO+totalInteres;
                mapx.put("totalInteres", totalInteres);
                mapx.put("totalTotal", totalTotal);
                mapx.put("totalCapital", MONTOSOLICITADO);
                reporteCorridaPagos reps = new reporteCorridaPagos(mapx,pQ);
                try {
                    reps.generaSolicitud(0);
                } 
                catch (Exception ex) {
                    Logger.getLogger(capturaCredito.class.getName()).log(Level.SEVERE, null, ex);
                }       
            }
            else
            {
                JOptionPane.showMessageDialog(null, "LA FORMA NO ESTA LLENADA ADECUADAMENTE");
            }          
    }//GEN-LAST:event_btnImprimeCalendarioActionPerformed
    private void accionMonto()
{
        TIPOCREDITO=cbxPrestamo.getSelectedIndex();
        int cv=6;
        int cr=16;
        int ch=37;
        double mcr=75000;
        double mch=300000;
        double maxmsb=0;
        double maxmax=0;
        double pg;
        double sn;
        double montoCP;
        txtPFQuinenal.setForeground(Color.BLACK);
        txtMonto.setForeground(Color.BLACK);
        DecimalFormat formateador = new DecimalFormat("#######.##");
        try
        {
            MONTOSOLICITADO= Double.parseDouble(txtMonto.getText());
            if (TIPOCREDITO == 0 ) {
                maxmsb=(double)cv*oempleado.SueldoBaseQuincenal;
                maxmax=maxmsb;
            }
            if (TIPOCREDITO == 1 ) {
                maxmsb=(double)cr*oempleado.SueldoBaseQuincenal;
                maxmax=mcr;
                if (oempleado.IdTipoEmpleado>=6)
                {
                    cr=12;//Para un Jubilado o Pensionado el limite son
                    maxmsb=(double)cr*oempleado.SueldoBaseQuincenal;
                } 
            } 
            if (TIPOCREDITO == 2 ) {
                maxmsb=(double)ch*oempleado.SueldoBaseQuincenal;
                maxmax=mch;
            }            
            if (MONTOSOLICITADO>maxmsb || MONTOSOLICITADO>maxmax)
            {
                JOptionPane.showMessageDialog(null, "EL MONTO SOLICITADO REBASA LAS CARACTERISTICAS DEL TIPO DE CREDITO"); 
                //txtMonto.setText(formateador.format(MONTOSOLICITADO));
                txtMonto.setForeground(Color.red);
            }
            else
            {
                pg=calculapago(TIPOCREDITO,MONTOSOLICITADO);
                //verificar si es aval y ajustar su capacidad de pago
                //si es aval puede acceder a un credito pero se ajusta su capacidad de pago
                if (CAPACIDADPAGO<pg) //(sb*0.3)
                {
                    JOptionPane.showMessageDialog(null, "EL MONTO SOLICITADO REBASA SU CAPACIDAD DE PAGO: $"+formateador.format(CAPACIDADPAGO));
                    //txtPFQuinenal.setText(formateador.format(pg));
                    txtPFQuinenal.setForeground(Color.red);
                }            
            } //felse
        }//ftry
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "EL MONTO DEBE SER UN NUMERO CON FORMATO ###.##");
        }
}
    private void btnCapacidadPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapacidadPagoActionPerformed
        boolean vp=isllenaformaprincipal();
        boolean va=true;

        //necesito valor global para capacidad de pago 
        String Tipocredito="";
        String fecha;
        String cpago;
        String monto;
        Numero_a_Letra ML = new Numero_a_Letra();
        truncaDecimal TD = new truncaDecimal();
        TIPOCREDITO=cbxPrestamo.getSelectedIndex();
           // checapago=vpago.cuota(checamonto, taza, plazo);
        if (TIPOCREDITO==0){Tipocredito="VERDE";}
        if (TIPOCREDITO==1){Tipocredito="ROJO";}
        if (TIPOCREDITO==2){Tipocredito="HIPOTECARIO";}
        if (TIPOCREDITO==1)
        {
            if (oempleado.IdTipoEmpleado>=6)
            {
                va=true; //Los Jubilados y Pencionados no requieren Aval
            }
            else
            {
                va=isllenaformaaval();
            }
            
        }
        
        String solicitud;
        monto=TD.verificaDecimales(String.valueOf(MONTOSOLICITADO)) ;
        cpago=TD.verificaDecimales(String.valueOf(CAPACIDADPAGO));
        Calendar c = new GregorianCalendar();
        Date fecha1 = new Date();
        Map mapx= new HashMap();
        Map mapxa= new HashMap();
            if (vp=true)
            {
                SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'del ' YYYY");
                fecha=formateador.format(fecha1);
                mapx.put("Tipocredito", Tipocredito);
                mapx.put("nombre", oempleado.Nombres);
                mapx.put("paterno", oempleado.Paterno);
                mapx.put("materno", oempleado.Materno);
                
                mapx.put("fecha", fecha);
                mapx.put("cpago", cpago);
                mapx.put("cpagoletras", ML.Convertir(cpago,true));
                mapx.put("Montocredito", monto);
                mapx.put("Montoletra", ML.Convertir(monto, true));               
                reporteCapacidadPago reps = new reporteCapacidadPago();
                try {
                    reps.generaSolicitud(mapx,0);//EMPLEADO
                    if (TIPOCREDITO==1 && va==true) //se requiere AVAL en este tipo de credito
                    {
                        //datos de carta compromiso de credito rojo de aval
                        //nombre, paterno, materno, fecha, nombreaval, paternoaval, maternoaval
                        //cpago,cpagoletras
                        cpago=TD.verificaDecimales(String.valueOf(CAPACIDADPAGOAVAL));
                        mapxa.put("Tipocredito", Tipocredito);
                        mapxa.put("nombre", oempleado.Nombres);
                        mapxa.put("paterno", oempleado.Paterno);
                        mapxa.put("materno", oempleado.Materno);
                        mapxa.put("nombreaval", oempleadoA.Nombres);
                        mapxa.put("paternoaval", oempleadoA.Paterno);
                        mapxa.put("maternoaval", oempleadoA.Materno);
                        mapxa.put("fecha", fecha);
                        mapxa.put("cpago", cpago);
                        mapxa.put("cpagoletras", ML.Convertir(cpago,true));
                        //mapxa.put("Montocredito", monto);
                        //mapxa.put("Montoletra", ML.Convertir(monto, true));  
                        reps.generaSolicitud(mapxa,1);//AVAL
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "LA FORMA DE AVAL NO ESTÁ LLENADA ADECUADAMENTE");
                    }
                    
                } 
                catch (Exception ex) {
                    Logger.getLogger(capturaCredito.class.getName()).log(Level.SEVERE, null, ex);
                }       
            }
            else
            {
            JOptionPane.showMessageDialog(null, "LA FORMA NO ESTA LLENADA ADECUADAMENTE");
            }         // TODO add your handling code here:
    }//GEN-LAST:event_btnCapacidadPagoActionPerformed

    private void btnPagareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagareActionPerformed
        // TODO add your handling code here:
        //fecha, NoPagare, importe, importeletra
        //nombre, paterno, materno, domicilio, localidad, municipio, estado 
        boolean vp=isllenaformaprincipal();
        String fecha;
        String cpago;
        String monto;
        Numero_a_Letra ML = new Numero_a_Letra();
        truncaDecimal TD = new truncaDecimal();
        TIPOCREDITO=cbxPrestamo.getSelectedIndex();
        BANCO=cbxBancos.getSelectedIndex();
        monto=TD.verificaDecimales(String.valueOf(MONTOSOLICITADO)) ;
        cpago=TD.verificaDecimales(String.valueOf(CAPACIDADPAGO));
        Calendar c = new GregorianCalendar();
        Date fecha1 = new Date();
        Map mapx= new HashMap();
            if (vp=true)
            {
                SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'del' YYYY");
                fecha=formateador.format(fecha1);
                mapx.put("NoPagare", NOPAGARE);
                mapx.put("nombre", oempleado.Nombres);
                mapx.put("paterno", oempleado.Paterno);
                mapx.put("materno", oempleado.Materno);
                mapx.put("fecha", fecha);
                mapx.put("importe", monto);
                mapx.put("importeletra", ML.Convertir(monto, true));  
                mapx.put("domicilio", oempleado.Dir);
                mapx.put("localidad", oempleado.Col);
                mapx.put("municipio", oempleado.ciudad);
                mapx.put("estado", oempleado.estado);
                mapx.put("cp",oempleado.CP);//necesitamos cambiar por codigo postal
                //si es credito rojo Y EL DEUDOR NO ES JUBILADO PENSIONADO 
                //se necesitan datos del aval
                if ((TIPOCREDITO==1)&&((oempleado.IdTipoEmpleado>=1)&&(oempleado.IdTipoEmpleado<=5)))
                {
                        mapx.put("nombreaval", oempleadoA.Nombres);
                        mapx.put("paternoaval", oempleadoA.Paterno);
                        mapx.put("maternoaval", oempleadoA.Materno);
                        mapx.put("domicilioaval", oempleadoA.Dir);
                        mapx.put("localidadaval", oempleadoA.Col);
                        mapx.put("municipioaval", oempleadoA.ciudad);
                        mapx.put("estadoaval", oempleadoA.estado);                     
                }
                reportePagare reps = new reportePagare(mapx);
                try {
                    reps.generaSolicitud(TIPOCREDITO,oempleado.IdTipoEmpleado);
                } 
                catch (Exception ex) {
                    Logger.getLogger(capturaCredito.class.getName()).log(Level.SEVERE, null, ex);
                }   
                //llenamos los datos para la carta compromiso
                //
                String tipoEmpleado="";
                if(oempleado.IdTipoEmpleado>=6){tipoEmpleado="Jubilado o Pensionado";}
                if(oempleado.IdTipoEmpleado<6){tipoEmpleado="Servidor Público";}
                calculaEdad edadT = new calculaEdad();
                int edad=0;
                try {
                    edad = edadT.calculaPorRFC(oempleado.RFC);
                } catch (ParseException ex) {
                    Logger.getLogger(capturaCredito.class.getName()).log(Level.SEVERE, null, ex);
                }
                String aportacionQ=TD.verificaDecimales(txtPFQuinenal.getText());
                mapx.put("Tiposolicitante",tipoEmpleado);
                mapx.put("edad",edad);
                mapx.put("identificacion",EMPLEADOIDE);
                mapx.put("edocivil",estadoCivilE(oempleado.IdEdoCivil));
                mapx.put("domicilio",oempleado.Dir);
                mapx.put("localidad",oempleado.Col);
                mapx.put("municipio",oempleado.ciudad);
                mapx.put("estado",oempleado.estado);
                mapx.put("importe", monto);
                mapx.put("importeletra", ML.Convertir(monto, true)); 
                mapx.put("importedescuento", aportacionQ);
                mapx.put("importedescuentoletra",ML.Convertir(aportacionQ, true)); 
                mapx.put("nombreT1",oempleadoT1.Nombres);
                mapx.put("paternoT1",oempleadoT1.Paterno);
                mapx.put("maternoT1",oempleadoT1.Materno);
                try {
                    edad = edadT.calculaPorRFC(oempleadoT1.RFC);
                } catch (ParseException ex) {
                    Logger.getLogger(capturaCredito.class.getName()).log(Level.SEVERE, null, ex);
                }
                mapx.put("edadT1",edad);
                mapx.put("identificacionT1",TESTIGO1IDE);
                mapx.put("edocivilT1",estadoCivilE(oempleadoT1.IdEdoCivil));
                mapx.put("domicilioT1",oempleadoT1.Dir);
                mapx.put("localidadT1",oempleadoT1.Col);
                mapx.put("municipioT1",oempleadoT1.ciudad);
                mapx.put("estadoT1",oempleadoT1.estado);
                if(oempleadoT1.IdTipoEmpleado>=6){tipoEmpleado="Jubilado o Pensionado";}
                if(oempleadoT1.IdTipoEmpleado<6){tipoEmpleado="Servidor Público";}                
                mapx.put("ocupacionT1",tipoEmpleado);
                //datos del segundo testigo
                mapx.put("nombreT2",oempleadoT2.Nombres);
                mapx.put("paternoT2",oempleadoT2.Paterno);
                mapx.put("maternoT2",oempleadoT2.Materno);
                try {
                    edad = edadT.calculaPorRFC(oempleadoT2.RFC);
                } catch (ParseException ex) {
                    Logger.getLogger(capturaCredito.class.getName()).log(Level.SEVERE, null, ex);
                }
                mapx.put("edadT2",edad);
                mapx.put("identificacionT2",TESTIGO2IDE);
                mapx.put("edocivilT2",estadoCivilE(oempleadoT2.IdEdoCivil));
                mapx.put("domicilioT2",oempleadoT2.Dir);
                mapx.put("localidadT2",oempleadoT2.Col);
                mapx.put("municipioT2",oempleadoT2.ciudad);
                mapx.put("estadoT2",oempleadoT2.estado);
                if(oempleadoT2.IdTipoEmpleado>=6){tipoEmpleado="Jubilado o Pensionado";}
                if(oempleadoT2.IdTipoEmpleado<6){tipoEmpleado="Servidor Público";}                
                mapx.put("ocupacionT2",tipoEmpleado);
               //datos de la cuenta
                mapx.put("numcuenta",CLABE);
                mapx.put("numclabe",CLABE);
                mapx.put("banco",cbxBancos.getSelectedItem().toString());
                mapx.put("numcheque"," ");
                mapx.put("fechaletra",fecha);
                reporteContratoVerdeJubilado repContrato = new reporteContratoVerdeJubilado();
            try {
                repContrato.generaSolicitud(mapx,TIPOCREDITO,oempleado.IdTipoEmpleado);
            } catch (JRException ex) {
                Logger.getLogger(capturaCredito.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "LA FORMA NO ESTA LLENADA ADECUADAMENTE");
            }         // TODO add your handling code here:           
    }//GEN-LAST:event_btnPagareActionPerformed
    private String estadoCivilE(int IdEdoCivil)
    {
        String vEC="";
                if (IdEdoCivil==0){vEC="Soltero(a)";}
                if (IdEdoCivil==1){vEC="Casado(a)";}
                if (IdEdoCivil==2){vEC="Viudo(a)";}
                if (IdEdoCivil==3){vEC="Divorciado(a)";}
                if (IdEdoCivil==4){vEC="No definido";}
                if (IdEdoCivil==5){vEC="Union libre";}
                return vEC;
    }
    
    private void reporteCartaCompromiso(Map mapaReporte)
    {

             
    }
    private void btnCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartaActionPerformed
        // TODO add your handling code here:
        //CartaCompromisoVerde.jasper
        //Son cinco diversos tipos de carta compromiso, 
        //CC C. Hipotecario
        //CC C. Rojo, tiene Aval y hay dos tipos, para Jubilado y para Empleado
        //CC C. Verde, No hay Aval y hay dos tipos, Jubilado y Empleado
        //oempleadoA.NoEmpleado
        //tipo empleado
        // 1-5 Servidor Publico
        // 6 Jubilado
        // 7-13 Pensionado
        
        boolean vp=isllenaformaprincipal();
        String fecha;
        String vEC=" ";
        Numero_a_Letra ML = new Numero_a_Letra();
        TIPOCREDITO=cbxPrestamo.getSelectedIndex();
        int av=0;
        Date fecha1 = new Date();
        Map mapx= new HashMap();
            if (vp=true)
            {
                //datos de carta compromiso de credito verde para empleado
                //NombreDirector,nombre,paterno,materno,Identificacion,EdoCivil,
                //Institucion,rfc,nempleado,nplaza,domicilio,localidad,municipio,estado,fecha
                
                //datos de carta compromiso de credito verde para jubilado o pensionado
                //NombreDirector, nombre, paterno, materno, Identificacion, EdoCivil, 
                //Institucion,rfc,nempleado,nplaza,domicilio,localidad,municipio,estado,fecha
                
                if (oempleado.IdEdoCivil==0){vEC="Soltero(a)";}
                if (oempleado.IdEdoCivil==1){vEC="Casado(a)";}
                if (oempleado.IdEdoCivil==2){vEC="Viudo(a)";}
                if (oempleado.IdEdoCivil==3){vEC="Divorciado(a)";}
                if (oempleado.IdEdoCivil==4){vEC="No definido";}
                if (oempleado.IdEdoCivil==5){vEC="Union libre";}                
                SimpleDateFormat formateador = new SimpleDateFormat("dd 'dias del mes de' MMMM 'del año' YYYY");
                fecha=formateador.format(fecha1);
                mapx.put("NombreDirector", "LEONARDO ERNESTO ORDOÑEZ CARRERA");
                mapx.put("nombre", oempleado.Nombres);
                mapx.put("paterno", oempleado.Paterno);
                mapx.put("materno", oempleado.Materno);
                mapx.put("Identificacion", IDENTIFICACION);
                mapx.put("EdoCivil",vEC );
                mapx.put("Institucion", oempleado.UnidadAdministrativa);
                mapx.put("rfc", oempleado.RFC);
                mapx.put("nempleado", oempleado.NoEmpleado);
                mapx.put("nplaza", oempleado.Plaza); //investigar numero de plaza
                mapx.put("fecha", fecha);
                mapx.put("domicilio", oempleado.Dir);
                mapx.put("localidad", oempleado.Col);
                mapx.put("municipio", oempleado.ciudad);
                mapx.put("estado", oempleado.estado);
                //caracteristicas de las diferentes cartas compromisos
                //credito ROJO 
                //caso 1: Deudor Empleado Aval Empleado
                //caso 2: Deudor Jubilado Aval Empleado
                //caso 3: Deudor Jubilado Aval Jubilado
                if ((TIPOCREDITO==1)&&(oempleado.IdTipoEmpleado<6))
                {
                        if (oempleadoA.IdEdoCivil==0){vEC="Soltero(a)";}
                        if (oempleadoA.IdEdoCivil==1){vEC="Casado(a)";}
                        if (oempleadoA.IdEdoCivil==2){vEC="Viudo(a)";}
                        if (oempleadoA.IdEdoCivil==3){vEC="Divorciado(a)";}
                        if (oempleadoA.IdEdoCivil==4){vEC="No definido";}
                        if (oempleadoA.IdEdoCivil==5){vEC="Union libre";}                      
                        //Se capturan los dato del aval que es un empleado
                        mapx.put("nombre_aval", oempleadoA.Nombres);
                        mapx.put("paterno_aval", oempleadoA.Paterno);
                        mapx.put("materno_aval", oempleadoA.Materno);
                        mapx.put("Identificacion_aval", IDENTIFICACION);
                        mapx.put("EdoCivil_aval",vEC );
                        mapx.put("Institucion_aval", oempleadoA.UnidadAdministrativa);
                        mapx.put("rfc_aval", oempleadoA.RFC);
                        mapx.put("nempleado_aval", oempleadoA.NoEmpleado);
                        mapx.put("nplaza_aval", oempleadoA.Plaza); //investigar numero de plaza
                        mapx.put("domicilio_aval", oempleadoA.Dir);
                        mapx.put("localidad_aval", oempleadoA.Col);
                        mapx.put("municipio_aval", oempleado.ciudad);
                        mapx.put("estado_aval", oempleado.estado);  
                        av=oempleadoA.IdTipoEmpleado;
                }
                reporteCartaCompromiso reps = new reporteCartaCompromiso();
                try {
                    //
                    reps.generaSolicitud(mapx, TIPOCREDITO,oempleado.IdTipoEmpleado,av);
                } 
                catch (Exception ex) {
                    Logger.getLogger(capturaCredito.class.getName()).log(Level.SEVERE, null, ex);
                }       
            }
            else
            {
                JOptionPane.showMessageDialog(null, "LA FORMA NO ESTA LLENADA ADECUADAMENTE");
            }         // TODO add your handling code here:        
    }//GEN-LAST:event_btnCartaActionPerformed

    private void rbtnCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnCedulaActionPerformed
        // TODO add your handling code here:
        IdDocto=3;
        IDENTIFICACION="CEDULA PROFESIONAL";
    }//GEN-LAST:event_rbtnCedulaActionPerformed

    private void cbxCredencialPCETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCredencialPCETActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCredencialPCETActionPerformed

    private void txtIDAfiliadoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDAfiliadoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDAfiliadoCActionPerformed

    private void txtCURPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCURPCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCURPCActionPerformed

    private void txtRFCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCCActionPerformed

    private void txtPaternoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaternoCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaternoCActionPerformed

    private void txtTelefonoCelAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoCelAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoCelAActionPerformed

    private void txtNEmpleadoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNEmpleadoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNEmpleadoAActionPerformed

    private void txtIDAfiliadoAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDAfiliadoAFocusLost
        // TODO add your handling code here:
        despliegaAval();
    }//GEN-LAST:event_txtIDAfiliadoAFocusLost

    private void txtIDAfiliadoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDAfiliadoAActionPerformed
        // TODO add your handling code here:
        despliegaAval();
    }//GEN-LAST:event_txtIDAfiliadoAActionPerformed

    private void txtSQuincenalAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSQuincenalAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSQuincenalAActionPerformed

    private void txtFIngresoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFIngresoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFIngresoAActionPerformed

    private void txtSindicatoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSindicatoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSindicatoAActionPerformed

    private void txtSectorAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSectorAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSectorAActionPerformed

    private void txtTEmpleadoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTEmpleadoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTEmpleadoAActionPerformed

    private void txtCURPAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCURPAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCURPAActionPerformed

    private void txtRFCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRFCAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRFCAActionPerformed

    private void txtPaternoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaternoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaternoAActionPerformed

    private void txtMontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoFocusLost
        // TODO add your handling code here:
        truncaDecimal TD=new truncaDecimal();
        String SSueldo;
        SSueldo=txtMonto.getText();
        if (!"".equals(SSueldo))
        {
            //verifica tenda dos digitos en centavos #.00
            SSueldo=TD.verificaDecimales(SSueldo);
            txtMonto.setText(SSueldo);
            accionMonto();
        }
        
    }//GEN-LAST:event_txtMontoFocusLost

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
        accionMonto();
    }//GEN-LAST:event_txtMontoActionPerformed

    private void cbxPrestamoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbxPrestamoPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_cbxPrestamoPropertyChange

    private void cbxPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPrestamoActionPerformed

    private void cbxPrestamoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPrestamoItemStateChanged
        // TODO add your handling code here:
        int tc=cbxPrestamo.getSelectedIndex();
        double pg;
        if (tc == 0 )
        {
            PEncabezado.setBackground(Color.GREEN);
            PDLaborales.setBackground(Color.GREEN);
            MPSolicitud.setEnabledAt(0, true);
            MPSolicitud.setEnabledAt(1, false);
            MPSolicitud.setEnabledAt(2, false);
            MPSolicitud.setEnabledAt(3, true);
            MPSolicitud.setEnabledAt(4, false);
        }
        //para el caso de Jubilados y Pensionados no hay Aval
        if (tc == 1 )
        {
            PEncabezado.setBackground(Color.red);
            PDLaborales.setBackground(Color.red);
            MPSolicitud.setEnabledAt(0, true);
            MPSolicitud.setEnabledAt(1, true);
            if(oempleado.IdTipoEmpleado>=6) 
            {
                MPSolicitud.setEnabledAt(1, false);
            }
            MPSolicitud.setEnabledAt(2, false);
            MPSolicitud.setEnabledAt(3, true);
            MPSolicitud.setEnabledAt(4, true);
        }
        if (tc == 2 )
        {
            PEncabezado.setBackground(Color.yellow);
            PDLaborales.setBackground(Color.yellow);
            MPSolicitud.setEnabledAt(0, true);
            MPSolicitud.setEnabledAt(1, false);
            MPSolicitud.setEnabledAt(2, true);
            MPSolicitud.setEnabledAt(3, true);
            MPSolicitud.setEnabledAt(4, true);
        }
        if (!"".equals(txtMonto.getText()))
        {
            double m= Double.parseDouble(txtMonto.getText());
            pg=calculapago(tc, m );
        }
    }//GEN-LAST:event_cbxPrestamoItemStateChanged
    //Evento de perdida de foco en el campo captura del Salario Neto Quincenal
    private void txtSNetoQFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSNetoQFocusLost
        // TODO add your handling code here:
        //calculamos la capacidad de pago del deudor, siempre y cuando
        //este lleno sueldo base
        boolean esAval;
        boolean esOldAval;
        credito verificaAval= new credito();
        capacidadPago cPago;
        truncaDecimal TD=new truncaDecimal();
        String SSueldo;
        SSueldo=txtSNetoQ.getText();
        if (!"".equals(SSueldo))
        {
            //verifica tenda dos digitos en centavos #.00
            SSueldo=TD.verificaDecimales(SSueldo);
            txtSNetoQ.setText(SSueldo);
            SUELDONETO=Double.parseDouble(SSueldo);
            esAval=verificaAval.existeAval(oempleado.IdAfil);
            esOldAval=verificaAval.existeAvalesOld(oempleado.IdAfil);
            boolean boAval=esAval || esOldAval;
            cPago = new capacidadPago(oempleado.SueldoBaseQuincenal,SUELDONETO,boAval);
            //trunca a dos decimales
            CAPACIDADPAGO=TD.getDecimal(2,cPago.getCapacidadPago() );
            SSueldo=Double.toString(CAPACIDADPAGO);
            //verifica tenda dos digitos en centavos #.00
            SSueldo=TD.verificaDecimales(SSueldo);
            txtCPago.setText(SSueldo);
            
        }
    }//GEN-LAST:event_txtSNetoQFocusLost

    private void txtSNetoQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNetoQActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSNetoQActionPerformed

    private void txtNEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNEmpleadoActionPerformed

    private void txtCURPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCURPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCURPActionPerformed

    private void txtIDAfiliadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDAfiliadoFocusLost
        // TODO add your handling code here:
        credito nuevoc= new credito();
        if (nuevoc.existeCreditoEmpleado(Integer.parseInt(txtIDAfiliado.getText()))||(nuevoc.existeCreditoOldEmpleado(Integer.parseInt(txtIDAfiliado.getText()))))
        {
            JOptionPane.showMessageDialog(null, "YA EXISTE UN CREDITO ACTIVO");
        }
        else
        {
            despliegaAfiliado();
            
        }        
    }//GEN-LAST:event_txtIDAfiliadoFocusLost

    private void txtIDAfiliadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDAfiliadoActionPerformed
        // TODO add your handling code here:
        credito nuevoc= new credito();
        if (nuevoc.existeCreditoEmpleado(Integer.parseInt(txtIDAfiliado.getText()))||(nuevoc.existeCreditoOldEmpleado(Integer.parseInt(txtIDAfiliado.getText()))))
        {
            JOptionPane.showMessageDialog(null, "YA EXISTE UN CREDITO ACTIVO");
        }
        else
        {
            despliegaAfiliado();
        } 
    }//GEN-LAST:event_txtIDAfiliadoActionPerformed

    private void txtPaternoT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaternoT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaternoT1ActionPerformed

    private void txtIDAfiliadoT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDAfiliadoT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDAfiliadoT1ActionPerformed

    private void txtPaternoT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaternoT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaternoT2ActionPerformed

    private void txtIDAfiliadoT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDAfiliadoT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDAfiliadoT2ActionPerformed

    private void rbtnPasaporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnPasaporteActionPerformed
        // TODO add your handling code here:
        IdDocto=1;
        IDENTIFICACION="PASAPORTE";
    }//GEN-LAST:event_rbtnPasaporteActionPerformed

    private void rbtnLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnLicenciaActionPerformed
        // TODO add your handling code here:
        IdDocto=2;
        IDENTIFICACION="LICENCIA DE CONDUCIR";
    }//GEN-LAST:event_rbtnLicenciaActionPerformed

    private void rbtnIFEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnIFEActionPerformed
        // TODO add your handling code here:
        IdDocto=0;
            IDENTIFICACION="CREDENCIAL DE ELECTOR";
    }//GEN-LAST:event_rbtnIFEActionPerformed

    private void txtSNetoQAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNetoQAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSNetoQAActionPerformed

    private void txtSNetoQAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSNetoQAFocusLost
        // TODO add your handling code here:
                // TODO add your handling code here:
        //calculamos la capacidad de pago del AVAL, siempre y cuando
        //SE VERIFICA SI EL AVAL TIENE UN CREDITO SI ES ASÍ SU CAPACIDAD DE PAGO BAJA
        //VERIFICA QUE TENGA LA MISMA CAPACIDAD DE PAGO QUE EL DEUDOR
        boolean esAval;
        boolean esOldAval;
        boolean esDeudor;
        double deudapq=0;
        credito verificaAval= new credito();
        capacidadPago cPago;
        truncaDecimal TD=new truncaDecimal();
        if (!"".equals(txtSNetoQ.getText()))
        {
            SUELDONETOAVAL=Double.parseDouble(txtSNetoQA.getText());
            esAval=verificaAval.existeAval(oempleadoA.IdAfil);
            esOldAval=verificaAval.existeAvalesOld(oempleadoA.IdAfil);
            esDeudor=verificaAval.existeCreditoEmpleado(oempleadoA.IdAfil);
            if(esDeudor)
            {
                verificaAval.consultaCreditoEmpleado(oempleadoA.IdAfil);
            }
            cPago = new capacidadPago(oempleadoA.SueldoBaseQuincenal,SUELDONETOAVAL,esAval);
            CAPACIDADPAGOAVAL=TD.getDecimal(2,cPago.getCapacidadPagoAval(esDeudor,verificaAval.Aportacion) );
            
            txtCPagoA.setText(TD.verificaDecimales(Double.toString(CAPACIDADPAGOAVAL)));
            //EL CALCULO DE LA CAPACIDAD DE PAGO DEL AVAL ESTÁ EN FUNCIÓN DE UNA PROPORCIÓN DE LA 
            //CAPACIDAD DE PAGO DEL SOLICITANTE DEL CREDITO
            if(CAPACIDADPAGOAVAL<CAPACIDADPAGO*0.3)
            {
                    txtIDAfiliadoA.setText("");
                    JOptionPane.showMessageDialog(null, "EL AVAL NO TIENE LA CAPACIDAD DE PAGO");
            }
        }
    }//GEN-LAST:event_txtSNetoQAFocusLost

    private void txtCPagoAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPagoAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPagoAActionPerformed

    private void txtCPagoAFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPagoAFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPagoAFocusLost

    private void txtCPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPagoActionPerformed

    private void txtCPagoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPagoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPagoFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.txtIDAfiliado.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

    private void txtIDAfiliadoT2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDAfiliadoT2FocusLost
        // TODO add your handling code here:
        despliegaTestigo(2);
    }//GEN-LAST:event_txtIDAfiliadoT2FocusLost

    private void txtIDAfiliadoT1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDAfiliadoT1FocusLost
        // TODO add your handling code here:
        despliegaTestigo(1);        
    }//GEN-LAST:event_txtIDAfiliadoT1FocusLost

    private void cbxEmpleadoIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEmpleadoIDItemStateChanged
        // TODO add your handling code here:
        
        EMPLEADOIDE=cbxEmpleadoID.getSelectedItem().toString();//"CREDENCIAL DE ELECTOR";
    }//GEN-LAST:event_cbxEmpleadoIDItemStateChanged

    private void txtCLABEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCLABEFocusLost
        // TODO add your handling code here:
        if (txtCLABE.getText().length()==18)
        {
            String cuenta = txtCLABE.getText().substring(6,17);
            CLABE=txtCLABE.getText();
        }
        if ((txtCLABE.getText().length()!=11)&&(txtCLABE.getText().length()!=18))
        {
            JOptionPane.showMessageDialog(null, "LA CLABE BANCARIA DEBE SER NUMERICA DE 18 DÍGITOS Ó EL NÚMERO DE CUENTA DE 11 DÍGITOS");
        }
        if (txtCLABE.getText().length()==11)
        {
            CLABE=txtCLABE.getText();
        }
    }//GEN-LAST:event_txtCLABEFocusLost

    private void txtCLABEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCLABEKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) &&
        (caracter != '\b' /*corresponde a BACK_SPACE*/))
        {
            evt.consume();  // ignorar el evento de teclado
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtCLABEKeyTyped

    private void txtCLABEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCLABEKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCLABEKeyPressed

    private void txtCURPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCURPKeyTyped
        // TODO add your handling code here:
        //convierte en mayusculas
        char caracter = evt.getKeyChar();
        if (Character.isDigit(caracter) || Character.isLetter(caracter))
        {
            String texto = txtCURP.getText()+caracter;
            txtCURP.setText(texto.toUpperCase());
            evt.consume();
            this.repaint();            
        }
        else
        {
            getToolkit().beep();
            evt.consume();        
        }       
    }//GEN-LAST:event_txtCURPKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        //solo acepta números
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter))
        {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtTelefonoCelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoCelKeyTyped
        // TODO add your handling code here:
        //solo acepta números
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter))
        {
            getToolkit().beep();
            evt.consume();
        }        
    }//GEN-LAST:event_txtTelefonoCelKeyTyped

    private void txtSNetoQKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSNetoQKeyTyped
        // TODO add your handling code here:
        //solo acepta numeros y el simbolo "." como separador
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter))
        {
            if (caracter!='.')
            {
                getToolkit().beep();
                evt.consume();            
            }

        }         
    }//GEN-LAST:event_txtSNetoQKeyTyped

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        // TODO add your handling code here:
        //solo acepta numeros y el simbolo "." como separador
        char caracter = evt.getKeyChar();
        if (!Character.isDigit(caracter))
        {
            if (caracter!='.')
            {
                getToolkit().beep();
                evt.consume();            
            }

        }        
    }//GEN-LAST:event_txtMontoKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(capturaCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
                        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new capturaCredito().setVisible(true);             
            }
        });
                

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DPEsposa;
    private javax.swing.JTabbedPane MPSolicitud;
    private javax.swing.JPanel PAval;
    private javax.swing.JPanel PBotones;
    private javax.swing.JPanel PDAval;
    private javax.swing.JPanel PDConyuge;
    private javax.swing.JPanel PDCredito;
    private javax.swing.JPanel PDLaborales;
    private javax.swing.JPanel PDTestigo1;
    private javax.swing.JPanel PDTestigo2;
    private javax.swing.JPanel PDTrabajador;
    private javax.swing.JPanel PDireccion;
    private javax.swing.JPanel PDireccion1;
    private javax.swing.JPanel PDireccion2;
    private javax.swing.JPanel PDoctos;
    private javax.swing.JPanel PDocumentacion;
    private javax.swing.JPanel PEncabezado;
    private javax.swing.JPanel PTestigos;
    private javax.swing.JButton btnCapacidadPago;
    private javax.swing.JButton btnCarta;
    private javax.swing.JButton btnImprimeCalendario;
    private javax.swing.JButton btnLimpiaForma;
    private javax.swing.JButton btnPagare;
    private javax.swing.JButton btnSolicitud;
    private javax.swing.JComboBox cbxBancos;
    private javax.swing.JCheckBox cbxCDomicilio;
    private javax.swing.JCheckBox cbxCPago;
    private javax.swing.JCheckBox cbxCURP;
    private javax.swing.JCheckBox cbxCredencialPCET;
    private javax.swing.JComboBox cbxEmpleadoID;
    private javax.swing.JComboBox cbxPrestamo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.ButtonGroup rbngIdentificacion;
    private javax.swing.JRadioButton rbtnCedula;
    private javax.swing.JRadioButton rbtnIFE;
    private javax.swing.JRadioButton rbtnLicencia;
    private javax.swing.JRadioButton rbtnPasaporte;
    private javax.swing.JTextField txtCLABE;
    private javax.swing.JTextField txtCPago;
    private javax.swing.JTextField txtCPagoA;
    private javax.swing.JTextField txtCURP;
    private javax.swing.JTextField txtCURPA;
    private javax.swing.JTextField txtCURPC;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionA;
    private javax.swing.JTextField txtDireccionC;
    private javax.swing.JTextField txtEMail;
    private javax.swing.JTextField txtEMailA;
    private javax.swing.JTextField txtEMailC;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtEstadoA;
    private javax.swing.JTextField txtEstadoC;
    private javax.swing.JTextField txtFIngreso;
    private javax.swing.JTextField txtFIngresoA;
    private javax.swing.JTextField txtIDAfiliado;
    private javax.swing.JTextField txtIDAfiliadoA;
    private javax.swing.JTextField txtIDAfiliadoC;
    private javax.swing.JTextField txtIDAfiliadoT1;
    private javax.swing.JTextField txtIDAfiliadoT2;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtLocalidadA;
    private javax.swing.JTextField txtLocalidadC;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtMaternoA;
    private javax.swing.JTextField txtMaternoC;
    private javax.swing.JTextField txtMaternoT1;
    private javax.swing.JTextField txtMaternoT2;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtMunicipioA;
    private javax.swing.JTextField txtMunicipioC;
    private javax.swing.JTextField txtNEmpleado;
    private javax.swing.JTextField txtNEmpleadoA;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreA;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNombreT1;
    private javax.swing.JTextField txtNombreT2;
    private javax.swing.JTextField txtPFQuinenal;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtPaternoA;
    private javax.swing.JTextField txtPaternoC;
    private javax.swing.JTextField txtPaternoT1;
    private javax.swing.JTextField txtPaternoT2;
    private javax.swing.JTextField txtQPlazo;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextField txtRFCA;
    private javax.swing.JTextField txtRFCC;
    private javax.swing.JTextField txtSNetoQ;
    private javax.swing.JTextField txtSNetoQA;
    private javax.swing.JTextField txtSQuincenal;
    private javax.swing.JTextField txtSQuincenalA;
    private javax.swing.JTextField txtSector;
    private javax.swing.JTextField txtSectorA;
    private javax.swing.JTextField txtSindicato;
    private javax.swing.JTextField txtSindicatoA;
    private javax.swing.JTextField txtTEmpleado;
    private javax.swing.JTextField txtTEmpleadoA;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoA;
    private javax.swing.JTextField txtTelefonoC;
    private javax.swing.JTextField txtTelefonoCel;
    private javax.swing.JTextField txtTelefonoCelA;
    private javax.swing.JTextField txtTelefonoCelC;
    private javax.swing.JTextField txtUAdministrativa;
    private javax.swing.JTextField txtUAdministrativaA;
    // End of variables declaration//GEN-END:variables
}
