/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.aportaciones;
import controlador.arrayCreditos;
import creditospce.credito;
import creditospce.empleado;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class frmEstadoCredito extends javax.swing.JDialog {
    private credito CREDITO;
    private empleado EMPLEADO;
    private arrayCreditos[] ACREDITOS;
    private DefaultTableModel modelo;
    /**
     * Creates new form frmEstadoCredito
     */
    public frmEstadoCredito(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        CREDITO= new credito();
        EMPLEADO= new empleado();
        modelo = new DefaultTableModel(); 
        modelo.addColumn("CREDITO");
        modelo.addColumn("ESTATUS");
        modelo.addColumn("F. CAPTURA");
        modelo.addColumn("F. DISPERSIÓN");
        modelo.addColumn("MONTO");
        modelo.addColumn("APORTACIÓN x Q.");
        modelo.addColumn("NÚMERO DE A.");
        //modelo.addColumn(encabezados);
        tablaCreditos.setModel(modelo);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PDTrabajador = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtIDAfiliado = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbxPrestamo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cbxAno = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtNCredito = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        PCreditos = new javax.swing.JPanel();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCreditos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtAreaEmpleado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        PDTrabajador.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        jLabel13.setText("PRESTAMO:");

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

        jLabel1.setText("AÑO:");

        cbxAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2014" }));

        jLabel2.setText("N. CREDITO:");

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PDTrabajadorLayout = new javax.swing.GroupLayout(PDTrabajador);
        PDTrabajador.setLayout(PDTrabajadorLayout);
        PDTrabajadorLayout.setHorizontalGroup(
            PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDTrabajadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIDAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnBuscar)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        PDTrabajadorLayout.setVerticalGroup(
            PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PDTrabajadorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(cbxPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(cbxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtNCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar))
                    .addGroup(PDTrabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtIDAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PCreditos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaCreditos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Credito", "Estatus", "Fecha de Captura", "Fecha de Dispersión", "Monto", "Aportación Q.", "Número de A."
            }
        ));
        jScrollPane1.setViewportView(tablaCreditos);

        scrollPane1.add(jScrollPane1);

        javax.swing.GroupLayout PCreditosLayout = new javax.swing.GroupLayout(PCreditos);
        PCreditos.setLayout(PCreditosLayout);
        PCreditosLayout.setHorizontalGroup(
            PCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PCreditosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PCreditosLayout.setVerticalGroup(
            PCreditosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PCreditosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAreaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtAreaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PDTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PCreditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(PDTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDAfiliadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDAfiliadoFocusLost
        // TODO add your handling code here:
        //verifica que no este vacio el campo de IDEmpleado
        aportaciones aportacion=new aportaciones();
        txtAreaEmpleado.setText(" ");
        if (txtIDAfiliado.getText().isEmpty()==false)
        {
            modelo.setRowCount(0);
            //verifica que exista el afiliado
            if(EMPLEADO.consutlaEmpleadoID(Integer.parseInt(txtIDAfiliado.getText())))
            {
                //se buscan que creditos tiene este empleado así como su estatus
                 ACREDITOS=CREDITO.consultaCreditosEmpleado(EMPLEADO.IdAfil);
                 //HAY CREDITOS CON ESTE USUARIO
                 if (ACREDITOS.length>0)
                 {
                     Object datos[]=new Object[7];
                     String cveCredito=" ", estatus="";
                     SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");
                     //DESPLIEGA LOS CREDITOS
                    for (int i=0; i<ACREDITOS.length; i++)
                    {
                        //clave de credito
                        if (ACREDITOS[i].IdCredito==0) {cveCredito="V-";}
                        if (ACREDITOS[i].IdCredito==1) {cveCredito="R-";}
                        if (ACREDITOS[i].IdCredito==2) {cveCredito="H-";}
                        //clave de estatus
                        if (ACREDITOS[i].Estatus==0) {estatus="PENDIENTE";}
                        if (ACREDITOS[i].Estatus==1) {estatus="ACTIVO";}
                        if (ACREDITOS[i].Estatus==2) {estatus="PAGADO";}                        
                        if (ACREDITOS[i].Estatus==3) {estatus="CANCELADO";}
                        if (ACREDITOS[i].Estatus==4) {estatus="TODOS";}
                        if (ACREDITOS[i].Estatus==5) {estatus="DISPERSADO";}
                        if (ACREDITOS[i].Estatus==6) {estatus="COBRANDO";}
                        cveCredito=cveCredito+String.valueOf(ACREDITOS[i].ano)+"-"+String.valueOf(ACREDITOS[i].NCredito);
                        datos[0]=cveCredito;
                        //estatus del credito
                        datos[1]=estatus;
                        //fecha de captura
                        datos[2]=sdf.format(ACREDITOS[i].FCaptura);
                        //fecha de dispersión
                        datos[3]=sdf.format(ACREDITOS[i].FDispercion); 
                        //Monto del credito
                        datos[4]=ACREDITOS[i].Montoa;
                        //Retención Quincenal
                        datos[5]=ACREDITOS[i].Aportacion;     
                        //numeroAportacionesIDAfil(int IDAfil, int idcredito, int ano, int ncredito)
                        datos[6]=aportacion.numeroAportacionesIDAfil(EMPLEADO.IdAfil, ACREDITOS[i].IdCredito, ACREDITOS[i].ano, ACREDITOS[i].NCredito);
                        modelo.addRow(datos);
                        txtAreaEmpleado.setText("ID: "+String.valueOf(EMPLEADO.IdAfil)+" : "+EMPLEADO.Nombres+" "+EMPLEADO.Paterno+" "+EMPLEADO.Materno );
                    }                       
                 }
                 //EL CLIENTE NO TIENE CREDITOS
                 else
                 {
                     JOptionPane.showMessageDialog(null, "EL EMPLEADO NO TIENE CREDITOS");
                 }
               
                
            }
            //no existe el afiliado
            else
            {
                txtIDAfiliado.setText("");
                JOptionPane.showMessageDialog(null, "NO EXISTE EL EMPLEADO");
            }
            
        }
        
        //despliega empleado
        //busca los creditos concluidos que ha tenido y tiene
        //en un panel despliega los creditos con sus estatus
    }//GEN-LAST:event_txtIDAfiliadoFocusLost

    private void txtIDAfiliadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDAfiliadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDAfiliadoActionPerformed

    private void cbxPrestamoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPrestamoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPrestamoItemStateChanged

    private void cbxPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPrestamoActionPerformed

    private void cbxPrestamoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbxPrestamoPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPrestamoPropertyChange

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        aportaciones aportacion=new aportaciones();
        int IdCredito=0, ano=0, NCredito=0;
        IdCredito=cbxPrestamo.getSelectedIndex();
        String A=(String) cbxAno.getSelectedItem();
        ano=Integer.parseInt(A);
        NCredito=Integer.parseInt(txtNCredito.getText());
        txtAreaEmpleado.setText(" ");
        txtIDAfiliado.setText("");
        if (txtNCredito.getText().isEmpty()==false)
        {
            modelo.setRowCount(0);
            //verifica que exista el credito
            if(CREDITO.existeCredito(IdCredito, ano, NCredito))
            {
                //se busca el creditos 
                CREDITO.consultaCredito(IdCredito, ano, NCredito);
                EMPLEADO.consutlaEmpleadoID(CREDITO.IdEmpleado);
                Object datos[]=new Object[7];
                String cveCredito=" ", estatus="";
                SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");
                //DESPLIEGA LOS CREDITOS                
                        if (CREDITO.IdCredito==0) {cveCredito="V-";}
                        if (CREDITO.IdCredito==1) {cveCredito="R-";}
                        if (CREDITO.IdCredito==2) {cveCredito="H-";}
                        //clave de estatus
                        if (CREDITO.Estatus==0) {estatus="PENDIENTE";}
                        if (CREDITO.Estatus==1) {estatus="ACTIVO";}
                        if (CREDITO.Estatus==2) {estatus="PAGADO";}                        
                        if (CREDITO.Estatus==3) {estatus="CANCELADO";}
                        if (CREDITO.Estatus==4) {estatus="TODOS";}
                        if (CREDITO.Estatus==5) {estatus="DISPERSADO";}
                        if (CREDITO.Estatus==6) {estatus="COBRANDO";}
                        cveCredito=cveCredito+String.valueOf(CREDITO.ano)+"-"+String.valueOf(CREDITO.NCredito);
                        datos[0]=cveCredito;
                        //estatus del credito
                        datos[1]=estatus;
                        //fecha de captura
                        datos[2]=sdf.format(CREDITO.FCaptura);
                        //fecha de dispersión
                        datos[3]=sdf.format(CREDITO.FDispercion); 
                        //Monto del credito
                        datos[4]=CREDITO.Montoa;
                        //Retención Quincenal
                        datos[5]=CREDITO.Aportacion;     
                        //numeroAportacionesIDAfil(int IDAfil, int idcredito, int ano, int ncredito)
                        datos[6]=aportacion.numeroAportacionesIDAfil(EMPLEADO.IdAfil, CREDITO.IdCredito, CREDITO.ano, CREDITO.NCredito);
                        modelo.addRow(datos);  
                        txtAreaEmpleado.setText("ID: "+String.valueOf(EMPLEADO.IdAfil)+" : "+EMPLEADO.Nombres+" "+EMPLEADO.Paterno+" "+EMPLEADO.Materno );
            }
            //no existe el afiliado
            else
            {
                JOptionPane.showMessageDialog(null, "NO EXISTE ESE CREDITO");
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(frmEstadoCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEstadoCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEstadoCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEstadoCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmEstadoCredito dialog = new frmEstadoCredito(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel PCreditos;
    private javax.swing.JPanel PDTrabajador;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox cbxAno;
    private javax.swing.JComboBox cbxPrestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTable tablaCreditos;
    private javax.swing.JTextField txtAreaEmpleado;
    private javax.swing.JTextField txtIDAfiliado;
    private javax.swing.JTextField txtNCredito;
    // End of variables declaration//GEN-END:variables
}
