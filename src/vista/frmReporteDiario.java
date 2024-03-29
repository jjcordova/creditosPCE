/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.bolsa;
import controlador.estadisticasCredito;
import creditospce.creditoReporte;
import java.awt.GridBagConstraints;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class frmReporteDiario extends javax.swing.JDialog {
    private JPanel graSolicitadosVerde= new JPanel();
    private JPanel graDispersadosVerde= new JPanel();
    private JPanel graSolicitadosRojo= new JPanel();
    private JPanel graDispersadosRojo= new JPanel();
    private JPanel graSolicitadosHipotecario= new JPanel();
    private JPanel graDispersadosHipotecario= new JPanel();
    private JPanel graTotalDispersados= new JPanel();
    private JPanel graTotalSolicitados= new JPanel();
    private JPanel CreditosDia= new JPanel();
    private JPanel CreditosQuincena= new JPanel();
    private Map<String, Double> DatosGraficaSV = new HashMap<String,Double>();
    private Map<String, Double> DatosGraficaDV = new HashMap<String,Double>();
    private Map<String, Double> DatosGraficaSR = new HashMap<String,Double>();
    private Map<String, Double> DatosGraficaDR = new HashMap<String,Double>();
    private Map<String, Double> DatosGraficaSH = new HashMap<String,Double>();
    private Map<String, Double> DatosGraficaDH = new HashMap<String,Double>();
    private Map<String, Double> DatosGraficaST = new HashMap<String,Double>();
    private Map<String, Double> DatosGraficaDT = new HashMap<String,Double>();
    private GridBagConstraints constraints = new GridBagConstraints();
    private Date fecha;
    private Date FIni= null;
    private Date FFin=null;
    private bolsa creditosBolsa = new bolsa();
    private int PWIDTH=200;
    private int PHEIGHT=200;
    private estadisticasCredito estadisticasC=new estadisticasCredito();
    private DefaultTableModel modelo;
    /**
     * Creates new form frmReporteDiario
     */
    public frmReporteDiario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setModal(false);
        modelo = new DefaultTableModel(); 
        modelo.addColumn("DEPENDENCIA");
        modelo.addColumn("CREDITO");
        modelo.addColumn("F. CAPTURA");
        modelo.addColumn("F. DISPERSIÓN");
        modelo.addColumn("MONTO");
        modelo.addColumn("APORTACIÓN x Q.");
        //modelo.addColumn(encabezados);
        tableReporte.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dateChooserFechaIni = new datechooser.beans.DateChooserCombo();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dateChooserFechaFin = new datechooser.beans.DateChooserCombo();
        botonBuscar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        panelDatos = new javax.swing.JPanel();
        scrolDatos = new javax.swing.JScrollPane();
        tableReporte = new javax.swing.JTable();
        panelVistas = new javax.swing.JPanel();
        labelNumeroCreditosVerdes = new javax.swing.JLabel();
        labelNumeroCreditosRojos = new javax.swing.JLabel();
        labelNumeroCreditosHipotecarios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        dateChooserFechaIni.setCurrentView(new datechooser.view.appearance.AppearancesList("Bordered",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateChooserFechaIni.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
    dateChooserFechaIni.addCommitListener(new datechooser.events.CommitListener() {
        public void onCommit(datechooser.events.CommitEvent evt) {
            dateChooserFechaIniOnCommit(evt);
        }
    });

    jLabel1.setText("Fecha Inicial:");

    jLabel2.setText("Fecha Final:");

    dateChooserFechaFin.setCurrentView(new datechooser.view.appearance.AppearancesList("Bordered",
        new datechooser.view.appearance.ViewAppearance("custom",
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(0, 0, 255),
                true,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 255),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.ButtonPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(128, 128, 128),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(0, 0, 255),
                false,
                true,
                new datechooser.view.appearance.swing.LabelPainter()),
            new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                new java.awt.Color(0, 0, 0),
                new java.awt.Color(255, 0, 0),
                false,
                false,
                new datechooser.view.appearance.swing.ButtonPainter()),
            (datechooser.view.BackRenderer)null,
            false,
            true)));
dateChooserFechaFin.setWeekStyle(datechooser.view.WeekDaysStyle.SHORT);
dateChooserFechaFin.addCommitListener(new datechooser.events.CommitListener() {
    public void onCommit(datechooser.events.CommitEvent evt) {
        dateChooserFechaFinOnCommit(evt);
    }
    });

    botonBuscar.setText("BUSCAR");
    botonBuscar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            botonBuscarActionPerformed(evt);
        }
    });

    jButton1.setText("IMPRIMIR");

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    jLabel3.setText("CRÉDITOS PROCESADOS");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(290, 290, 290)
                    .addComponent(botonBuscar)
                    .addGap(88, 88, 88)
                    .addComponent(jButton1))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(119, 119, 119)
                    .addComponent(jLabel1)
                    .addGap(41, 41, 41)
                    .addComponent(dateChooserFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)
                    .addComponent(jLabel2)
                    .addGap(41, 41, 41)
                    .addComponent(dateChooserFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(284, 284, 284))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jLabel2)
                .addComponent(dateChooserFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1)
                .addComponent(dateChooserFechaIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(botonBuscar)
                .addComponent(jButton1))
            .addContainerGap())
    );

    tableReporte.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    scrolDatos.setViewportView(tableReporte);

    javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
    panelDatos.setLayout(panelDatosLayout);
    panelDatosLayout.setHorizontalGroup(
        panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelDatosLayout.createSequentialGroup()
            .addGap(45, 45, 45)
            .addComponent(scrolDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(37, Short.MAX_VALUE))
    );
    panelDatosLayout.setVerticalGroup(
        panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelDatosLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(scrolDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
            .addContainerGap())
    );

    labelNumeroCreditosVerdes.setText("Número de Creditos Verdes:");

    labelNumeroCreditosRojos.setText("Número de Creditos Rojos:");

    labelNumeroCreditosHipotecarios.setText("Número de Creditos Hipotecarios:");

    javax.swing.GroupLayout panelVistasLayout = new javax.swing.GroupLayout(panelVistas);
    panelVistas.setLayout(panelVistasLayout);
    panelVistasLayout.setHorizontalGroup(
        panelVistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelVistasLayout.createSequentialGroup()
            .addGap(313, 313, 313)
            .addGroup(panelVistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(labelNumeroCreditosHipotecarios)
                .addComponent(labelNumeroCreditosVerdes)
                .addComponent(labelNumeroCreditosRojos))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    panelVistasLayout.setVerticalGroup(
        panelVistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelVistasLayout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(labelNumeroCreditosVerdes)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(labelNumeroCreditosRojos)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(labelNumeroCreditosHipotecarios)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelVistas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(panelVistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateChooserFechaIniOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserFechaIniOnCommit
        // TODO add your handling code here:
        FIni=dateChooserFechaIni.getCurrent().getTime();
    }//GEN-LAST:event_dateChooserFechaIniOnCommit

    private void dateChooserFechaFinOnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserFechaFinOnCommit
        // TODO add your handling code here:
        FFin=dateChooserFechaFin.getCurrent().getTime();
    }//GEN-LAST:event_dateChooserFechaFinOnCommit

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
        int NCreditos=0;
        modelo.setRowCount(0);
        creditoReporte[] creditosVerdes;
        creditoReporte[] creditosRojos;
        creditoReporte[] creditosHipotecarios;
        creditosVerdes=estadisticasC.reportecreditosOtorgados(0, 1, FIni, FFin); //
        creditosRojos=estadisticasC.reportecreditosOtorgados(1, 1, FIni, FFin);
        creditosHipotecarios=estadisticasC.reportecreditosOtorgados(2, 1, FIni, FFin);//.totalCreditosOtorgados(2, 5);
        //llena la JTable con la consulta de los creditos a reportar por dependencia
        NCreditos=creditosVerdes.length;
        Object datos[];
        datos = new Object[6];
        Object datosv[];
        datosv=new Object[6];
        String cveCredito=" ";
        SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");   
        labelNumeroCreditosVerdes.setText("NUMERO DE CREDITOS VERDES: "+Integer.toString(NCreditos) );
        for (int i=0; i<NCreditos; i++)
        { 
            //sector - dependencia
            datos[0]= new Object();
            datos[0]=creditosVerdes[i].IdSector;
            //clave de credito
            if (creditosVerdes[i].IdCredito==0) {cveCredito="V-";}
            if (creditosVerdes[i].IdCredito==1) {cveCredito="R-";}
            if (creditosVerdes[i].IdCredito==2) {cveCredito="H-";}
            cveCredito=cveCredito+String.valueOf(creditosVerdes[i].ano)+"-"+String.valueOf(creditosVerdes[i].NCredito);
            datos[1]= new Object();
            datos[1]=cveCredito;
            //fecha de captura
            datos[2]=sdf.format(creditosVerdes[i].FCaptura);
            //fecha de dispersión
            datos[3]="SIN DISPERSAR";//sdf.format(creditosVerdes[i].FDispercion); 
            //Monto del credito
            datos[4]=creditosVerdes[i].Montoa;
            //Retención Quincenal
            datos[5]=creditosVerdes[i].Aportacion;     
            modelo.addRow(datos);
        }
        NCreditos=creditosRojos.length;
        labelNumeroCreditosRojos.setText("NUMERO DE CREDITOS ROJOS: "+Integer.toString(NCreditos) );
        for (int i=0; i<NCreditos; i++)
        { 
            //sector - dependencia
            datos[0]=creditosRojos[i].IdSector;
            //clave de credito
            if (creditosRojos[i].IdCredito==0) {cveCredito="V-";}
            if (creditosRojos[i].IdCredito==1) {cveCredito="R-";}
            if (creditosRojos[i].IdCredito==2) {cveCredito="H-";}
            cveCredito=cveCredito+String.valueOf(creditosRojos[i].ano)+"-"+String.valueOf(creditosRojos[i].NCredito);
            datos[1]=cveCredito;
            //fecha de captura
            datos[2]=sdf.format(creditosRojos[i].FCaptura);
            //fecha de dispersión
            datos[3]="SIN DISPERSAR";
            //Monto del credito
            datos[4]=creditosRojos[i].Montoa;
            //Retención Quincenal
            datos[5]=creditosRojos[i].Aportacion;     
            modelo.addRow(datos);
        }
        NCreditos=creditosHipotecarios.length;
        labelNumeroCreditosHipotecarios.setText("NUMERO DE CREDITOS ROJOS: "+Integer.toString(NCreditos) );
        for (int i=0; i<NCreditos; i++)
        { 
            //sector - dependencia
            datos[0]=creditosHipotecarios[i].IdSector;
            //clave de credito
            if (creditosHipotecarios[i].IdCredito==0) {cveCredito="V-";}
            if (creditosHipotecarios[i].IdCredito==1) {cveCredito="R-";}
            if (creditosHipotecarios[i].IdCredito==2) {cveCredito="H-";}
            cveCredito=cveCredito+String.valueOf(creditosHipotecarios[i].ano)+"-"+String.valueOf(creditosHipotecarios[i].NCredito);
            datos[1]=cveCredito;
            //fecha de captura
            datos[2]=sdf.format(creditosHipotecarios[i].FCaptura);
            //fecha de dispersión
            datos[3]="SIN DISPERSAR"; 
            //Monto del credito
            datos[4]=creditosHipotecarios[i].Montoa;
            //Retención Quincenal
            datos[5]=creditosHipotecarios[i].Aportacion;     
            modelo.addRow(datos);
        }        
    }//GEN-LAST:event_botonBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(frmReporteDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReporteDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReporteDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReporteDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmReporteDiario dialog = new frmReporteDiario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonBuscar;
    private datechooser.beans.DateChooserCombo dateChooserFechaFin;
    private datechooser.beans.DateChooserCombo dateChooserFechaIni;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNumeroCreditosHipotecarios;
    private javax.swing.JLabel labelNumeroCreditosRojos;
    private javax.swing.JLabel labelNumeroCreditosVerdes;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelVistas;
    private javax.swing.JScrollPane scrolDatos;
    private javax.swing.JTable tableReporte;
    // End of variables declaration//GEN-END:variables
}
