/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Date;

/**
 *
 * @author Juan
 */
public class panelAltaQna extends javax.swing.JPanel {

    /**
     * Creates new form panelAltaQna
     */
    public panelAltaQna() {
        initComponents();
    }
    
    public void setNQna(int NQna)
    {
        txtQna.setText(String.valueOf(NQna));
    }
    
    public int getNQna()
    {
        int NQna=0;
        NQna=Integer.getInteger( txtQna.getText());
        return NQna;
    }
    
    public Date getFEnvio()
    {
        Date FEnvio=null;
        FEnvio=dateChooserFEnvio.getCurrent().getTime();
        return FEnvio;
    }
    public Date getFIniProc()
    {
        Date FIniProc=null;
        FIniProc=dateChooserFIniProc.getCurrent().getTime();
        return FIniProc;        
    }
    public Date getFFinProc()
    {
        Date FFinProc=null;
        FFinProc=dateChooserFFInProc.getCurrent().getTime();
        return FFinProc;        
    }
    public Date getFRecibimos()
    {
        Date FRecibimos=null;
        FRecibimos=dateChooserFRecibimos.getCurrent().getTime();
        return FRecibimos;        
    }
    public Date getFPago()
    {
        Date FPago=null;
        FPago=dateChooserFPago.getCurrent().getTime();
        return FPago;        
    }    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtQna = new javax.swing.JTextField();
        dateChooserFIniProc = new datechooser.beans.DateChooserCombo();
        dateChooserFFInProc = new datechooser.beans.DateChooserCombo();
        dateChooserFEnvio = new datechooser.beans.DateChooserCombo();
        dateChooserFRecibimos = new datechooser.beans.DateChooserCombo();
        dateChooserFPago = new datechooser.beans.DateChooserCombo();

        txtQna.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtQna, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateChooserFIniProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateChooserFFInProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateChooserFEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateChooserFRecibimos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dateChooserFPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtQna, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dateChooserFIniProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dateChooserFFInProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dateChooserFEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dateChooserFRecibimos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(dateChooserFPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo dateChooserFEnvio;
    private datechooser.beans.DateChooserCombo dateChooserFFInProc;
    private datechooser.beans.DateChooserCombo dateChooserFIniProc;
    private datechooser.beans.DateChooserCombo dateChooserFPago;
    private datechooser.beans.DateChooserCombo dateChooserFRecibimos;
    private javax.swing.JTextField txtQna;
    // End of variables declaration//GEN-END:variables
}
