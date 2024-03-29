/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.aportaciones;
import controlador.claveCredito;
import controlador.listaAportaciones;
import controlador.listaAportacionesContables;
import creditospce.dependencias;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.JFileChooser;

/**
 *
 * @author Juan
 */
public class frmContabilidad extends javax.swing.JDialog {
    private JFileChooser abrirArchivo;
    private Date Fecha;
    private int QUINCENA;
    private int SECTOR;
    /**
     * Creates new form frmContabilidad
     */
    public frmContabilidad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Fecha=new Date();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAvisos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonAbrir = new javax.swing.JButton();
        cbxDependencias = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbxQuincena = new javax.swing.JComboBox();
        panelControles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtareaAvisos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("DEPENDENCIA:");

        jLabel3.setText("ARCHIVO A LEER:");

        botonAbrir.setText("CREAR ARCHIVO");
        botonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirActionPerformed(evt);
            }
        });

        cbxDependencias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PODER EJECUTIVO", "PODER LEGISLATIVO", "PODER JUDICIAL", "MAGISTERIO", "JUBILADOS Y PENSIONADOS", "PENSIONES CIVILES DEL ESTADO DE TLAXCALA", "MUNICIPIO DE TLAXCALA", "MUNICIPIO DE CHIAUTEMPAN", "MUNICIPIO DE APETATITLAN", "CAPAM", "DIF TLAXCALA", "MUNICIPIO JUAN CUAMATZI", "MUNICIPIO DE TEPEYANCO", "MUNICIPO DE ANTONIO CARBAJAL" }));
        cbxDependencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDependenciasActionPerformed(evt);
            }
        });

        jLabel4.setText("QUINCENA:");

        cbxQuincena.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));

        javax.swing.GroupLayout panelAvisosLayout = new javax.swing.GroupLayout(panelAvisos);
        panelAvisos.setLayout(panelAvisosLayout);
        panelAvisosLayout.setHorizontalGroup(
            panelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvisosLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(76, 76, 76)
                .addGroup(panelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxQuincena, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAbrir)
                    .addComponent(cbxDependencias, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelAvisosLayout.setVerticalGroup(
            panelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAvisosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbxDependencias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxQuincena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelAvisosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(botonAbrir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtareaAvisos.setColumns(20);
        txtareaAvisos.setRows(5);
        jScrollPane1.setViewportView(txtareaAvisos);

        javax.swing.GroupLayout panelControlesLayout = new javax.swing.GroupLayout(panelControles);
        panelControles.setLayout(panelControlesLayout);
        panelControlesLayout.setHorizontalGroup(
            panelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelControlesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panelControlesLayout.setVerticalGroup(
            panelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelControles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAvisos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panelAvisos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirActionPerformed
        // TODO add your handling code here:
        String SDependencia,squincena,SCveC=null;
        claveCredito cvecredit = null;
        dependencias cgDependencias=new dependencias();
        QUINCENA=cbxQuincena.getSelectedIndex()+1;
        SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
        if (QUINCENA<10)
        {
            squincena="0"+Integer.toString(QUINCENA)+sdf.format(Fecha).substring(0, 4);
        }
        else
        {
            squincena=Integer.toString(QUINCENA)+sdf.format(Fecha).substring(0, 4);
        }
        LinkedList<listaAportacionesContables> lAportaciones;// =new LinkedList<listaAportacionesContables>();
        listaAportacionesContables lAp = new listaAportacionesContables();
        aportaciones reporteAportaciones=new aportaciones();
        ListIterator it;
        if( abrirArchivo == null ) {abrirArchivo = new JFileChooser();}
        //Con esto solamente podamos abrir archivos
        abrirArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
        
        int seleccion = abrirArchivo.showSaveDialog( this );
        if( seleccion == JFileChooser.APPROVE_OPTION )
        {
            SDependencia=cbxDependencias.getSelectedItem().toString();
            SECTOR=cgDependencias.IdDependencia(SDependencia);
            FileWriter fichero = null;
            PrintWriter pw = null;
            
            try
            {
                fichero = new FileWriter(abrirArchivo.getSelectedFile());
                lAportaciones=reporteAportaciones.reportaAportaciones(squincena,SECTOR);
                pw = new PrintWriter(fichero);
                //genera el archivi
                String path = abrirArchivo.getSelectedFile().getAbsolutePath();
                txtareaAvisos.append("GUARDANDO ARCHIVO..... \t"+path+"\n");
                //crea cada linea del archivo
                it=lAportaciones.listIterator();
                while (it.hasNext())
                    {
                        lAp=(listaAportacionesContables)it.next();
                        if (lAp.IdCredito==0){SCveC="V-";}
                        if (lAp.IdCredito==1){SCveC="R-";}
                        if (lAp.IdCredito==2){SCveC="H-";}
                        SCveC=SCveC+Integer.toString(lAp.ano)+"-"+String.format("%05d",lAp.NCredito);
                        //SCveC=cvecredit.armaClave(lAp.IdCredito, lAp.ano, lAp.NCredito);
                        pw.println(squincena+","+lAp.nAportacion+","+SCveC+","+lAp.rfc+","+String.valueOf(lAp.idempleado)+","+String.valueOf(lAp.pagoQ)+","+String.valueOf(lAp.pagoCapital)+","+String.valueOf(lAp.pagoInteres));
                        txtareaAvisos.append("Credito: "+SCveC+"\t Descuento:"+ String.valueOf(lAp.nAportacion)+"\t Empleado: "+lAp.rfc+"\n");
                    }
                    

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
               try {
               // Nuevamente aprovechamos el finally para 
               // asegurarnos que se cierra el fichero.
               if (null != fichero)
                  fichero.close();
               } catch (Exception e2) {
                  e2.printStackTrace();
               }
            }              
        }
    }//GEN-LAST:event_botonAbrirActionPerformed

    private void cbxDependenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDependenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDependenciasActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmContabilidad dialog = new frmContabilidad(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAbrir;
    private javax.swing.JComboBox cbxDependencias;
    private javax.swing.JComboBox cbxQuincena;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelAvisos;
    private javax.swing.JPanel panelControles;
    private javax.swing.JTextArea txtareaAvisos;
    // End of variables declaration//GEN-END:variables
}
