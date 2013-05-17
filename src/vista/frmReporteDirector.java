/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import controlador.bolsa;
import controlador.diagramaCircular;
import controlador.estadisticasCredito;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Juan
 */
public class frmReporteDirector extends javax.swing.JDialog {
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
    private bolsa creditosBolsa = new bolsa();
    private int PWIDTH=200;
    private int PHEIGHT=200;
    private estadisticasCredito estadisticasC=new estadisticasCredito();
    /**
     * Creates new form frmReporteDirector
     */
    public frmReporteDirector(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();   
        this.getContentPane().setLayout (new GridBagLayout());
        //creamos el diagrama circular de Soliciatados vs Bolsa Verde
        fecha= new Date();
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = "2013-01-01"; //se debe poner el año en curso
        
        try {
            FIni=formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            Logger.getLogger(frmReporteDirector.class.getName()).log(Level.SEVERE, null, ex);
        }
        graficaComparaciones();
        graficaEstadisticas();
        graficaEstadisticasDia();
        graficaEstadisticasQuincena();
         pack();
        

    }
    
    private void graficaEstadisticas()
    {
        panelTotalesCredito pTotales = new panelTotalesCredito();
        pTotales.setPreferredSize(new Dimension(507, 90));
        //despliega los datos del total de los creditos otorgados en el año
        Map<Integer,Double> creditosVerdes = new HashMap<>();
        Map<Integer,Double> creditosRojos = new HashMap<>();
        Map<Integer,Double> creditosHipotecarios = new HashMap<>();
        
        creditosVerdes=estadisticasC.totalCreditosOtorgados(0, 5); //
        creditosRojos=estadisticasC.totalCreditosOtorgados(1, 5);
        creditosHipotecarios=estadisticasC.totalCreditosOtorgados(2, 5);

        String amountOut,nCreditos;
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        
        for (Map.Entry<Integer,Double> entry : creditosVerdes.entrySet()) 
        {

            amountOut = n.format(entry.getValue());
            nCreditos= String.format("%d", entry.getKey());
            pTotales.txtTotalVerdes.setText(amountOut);
            pTotales.txtTotalVerdes1.setText(nCreditos);
        }
        for (Map.Entry<Integer,Double> entry : creditosRojos.entrySet()) 
        {
            amountOut = n.format(entry.getValue());
            nCreditos= String.format("%d", entry.getKey());            
            pTotales.txtTotalRojos.setText(amountOut);;
            pTotales.txtTotalRojos1.setText(nCreditos);
        }
        for (Map.Entry<Integer,Double> entry : creditosHipotecarios.entrySet()) 
        {
            amountOut = n.format(entry.getValue());
            nCreditos= String.format("%d", entry.getKey());            
            pTotales.txtTotalHipotecarios.setText(amountOut);
            pTotales.txtTotalHipotecarios1.setText(nCreditos);
        }    
        constraints.gridx = 2; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        //constraints.fill = GridBagConstraints.BOTH;
        getContentPane().add (pTotales, constraints);  
        
    }
    private void graficaEstadisticasDia()
    {
        panelTotalesCredito pTotales = new panelTotalesCredito();
        pTotales.setPreferredSize(new Dimension(507, 90));
        //despliega los datos del total de los creditos otorgados en el año
        Map<Integer,Double> creditosVerdes = new HashMap<>();
        Map<Integer,Double> creditosRojos = new HashMap<>();
        Map<Integer,Double> creditosHipotecarios = new HashMap<>();
        creditosVerdes=estadisticasC.creditosOtorgados(0, 1, fecha, fecha); //
        creditosRojos=estadisticasC.creditosOtorgados(1, 1, fecha, fecha);
        creditosHipotecarios=estadisticasC.creditosOtorgados(2, 1, fecha, fecha);//.totalCreditosOtorgados(2, 5);
        pTotales.labelTitulo.setText("TOTAL DE CREDITOS CAPTURADOS DURANTE EL DIA");
        String amountOut,nCreditos;
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        
        for (Map.Entry<Integer,Double> entry : creditosVerdes.entrySet()) 
        {

            amountOut = n.format(entry.getValue());
            nCreditos= String.format("%d", entry.getKey());
            pTotales.txtTotalVerdes.setText(amountOut);
            pTotales.txtTotalVerdes1.setText(nCreditos);
        }
        for (Map.Entry<Integer,Double> entry : creditosRojos.entrySet()) 
        {
            amountOut = n.format(entry.getValue());
            nCreditos= String.format("%d", entry.getKey());            
            pTotales.txtTotalRojos.setText(amountOut);;
            pTotales.txtTotalRojos1.setText(nCreditos);
        }
        for (Map.Entry<Integer,Double> entry : creditosHipotecarios.entrySet()) 
        {
            amountOut = n.format(entry.getValue());
            nCreditos= String.format("%d", entry.getKey());            
            pTotales.txtTotalHipotecarios.setText(amountOut);
            pTotales.txtTotalHipotecarios1.setText(nCreditos);
        }  
        constraints.gridx = 2; // El área de texto empieza en la columna cero.
        constraints.gridy = 1; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        //constraints.fill = GridBagConstraints.BOTH;
        getContentPane().add (pTotales, constraints);     
    }
  
    private void graficaEstadisticasQuincena()
    {
        panelTotalesCredito pTotales = new panelTotalesCredito();
        pTotales.setPreferredSize(new Dimension(507, 90));
        //despliega los datos del total de los creditos otorgados en el año
        Map<Integer,Double> creditosVerdes = new HashMap<>();
        Map<Integer,Double> creditosRojos = new HashMap<>();
        Map<Integer,Double> creditosHipotecarios = new HashMap<>();
        creditosVerdes=estadisticasC.creditosOtorgados(0, 5, fecha, fecha); //
        creditosRojos=estadisticasC.creditosOtorgados(1, 5, fecha, fecha);
        creditosHipotecarios=estadisticasC.creditosOtorgados(2, 5, fecha, fecha);//.totalCreditosOtorgados(2, 5);
        pTotales.labelTitulo.setText("TOTAL DE CREDITOS DISPERSADOS DURANTE EL DÍA");
        
        String amountOut,nCreditos;
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        
        for (Map.Entry<Integer,Double> entry : creditosVerdes.entrySet()) 
        {

            amountOut = n.format(entry.getValue());
            nCreditos= String.format("%d", entry.getKey());
            pTotales.txtTotalVerdes.setText(amountOut);
            pTotales.txtTotalVerdes1.setText(nCreditos);
        }
        for (Map.Entry<Integer,Double> entry : creditosRojos.entrySet()) 
        {
            amountOut = n.format(entry.getValue());
            nCreditos= String.format("%d", entry.getKey());            
            pTotales.txtTotalRojos.setText(amountOut);;
            pTotales.txtTotalRojos1.setText(nCreditos);
        }
        for (Map.Entry<Integer,Double> entry : creditosHipotecarios.entrySet()) 
        {
            amountOut = n.format(entry.getValue());
            nCreditos= String.format("%d", entry.getKey());            
            pTotales.txtTotalHipotecarios.setText(amountOut);
            pTotales.txtTotalHipotecarios1.setText(nCreditos);
        }   
        constraints.gridx = 2; // El área de texto empieza en la columna cero.
        constraints.gridy = 2; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weightx = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        //constraints.fill = GridBagConstraints.BOTH;
        getContentPane().add (pTotales, constraints);     
    }    
    
    private void graficaComparaciones()
    {
        
        //CALCULA LOS PORCENTAJES DE CREDITOS DISPERSADOS 5
        creditosBolsa.calculaPorcentajeUtilizado(5,FIni, fecha);

        double totalD=creditosBolsa.montoVerdeActual+creditosBolsa.montoRojoActual
                +creditosBolsa.montoHipotecarioActual;  
        double totalB=creditosBolsa.montoBolsaVerde+creditosBolsa.montoBolsaRoja
                +creditosBolsa.montoBolsaHipotecaria;  
        double totalRestaB=totalB-totalD;
        double porcenD=totalD*100/totalB;
        double bolsaV=creditosBolsa.montoBolsaVerde-creditosBolsa.montoVerdeActual;
        double bolsaR=creditosBolsa.montoBolsaRoja-creditosBolsa.montoRojoActual;
        double bolsaH=creditosBolsa.montoBolsaHipotecaria-creditosBolsa.montoHipotecarioActual;
        //GRAFICA TOTAL DISPERSADOS
        DatosGraficaDT.put("Credito Verde Solicitado", porcenD);
        DatosGraficaDT.put("Bolsa Credito Verde", 100.0-porcenD);
        diagramaCircular dCircularDT = new diagramaCircular();
        //ENVIA DATOS DE LA GRAFICA
        dCircularDT.setDatosGrafica(DatosGraficaDT);
        dCircularDT.setTitutloGrafica("TOTALCREDITOS DISPERSADOS");
        graTotalDispersados=dCircularDT.createDemoPanel();
        graTotalDispersados.setPreferredSize(new Dimension(PWIDTH, PHEIGHT));  
   
        
        //GRAFICA VERDES DISPERSADOS
        DatosGraficaDV.put("Credito Verde Dispersado", creditosBolsa.porcentajeVerde);
        DatosGraficaDV.put("Bolsa Credito Verde", 100.0-creditosBolsa.porcentajeVerde);
        diagramaCircular dCircularDV = new diagramaCircular();
        //ENVIA DATOS DE LA GRAFICA
        dCircularDV.setDatosGrafica(DatosGraficaDV);
        dCircularDV.setTitutloGrafica("BOLSA CREDITOS VERDE DISPERSADOS");
        graDispersadosVerde=dCircularDV.createDemoPanel();
        graDispersadosVerde.setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
        
       //GRAFICA ROJOS DISPERSADOS
        DatosGraficaDR.put("Credito Rojo Dispersado", creditosBolsa.porcentajeRojo);
        DatosGraficaDR.put("Bolsa Credito Rojo", 100.0-creditosBolsa.porcentajeRojo);
        diagramaCircular dCircularDR = new diagramaCircular();
        //ENVIA DATOS DE LA GRAFICA
        dCircularDR.setDatosGrafica(DatosGraficaDR);
        dCircularDR.setTitutloGrafica("BOLSA CREDITOS ROJOS DISPERSADOS");
        graDispersadosRojo=dCircularDR.createDemoPanel();
        graDispersadosRojo.setPreferredSize(new Dimension(PWIDTH, PHEIGHT));        
        
       //GRAFICA HIPOTECARIOS DISPERSADOS
        DatosGraficaDH.put("Credito Hipotecario Solicitado", creditosBolsa.porcentajeHipotecario);
        DatosGraficaDH.put("Bolsa Credito Hipotecario", 100.0-creditosBolsa.porcentajeHipotecario);
        diagramaCircular dCircularDH = new diagramaCircular();
        //ENVIA DATOS DE LA GRAFICA
        dCircularDH.setDatosGrafica(DatosGraficaDH);
        dCircularDH.setTitutloGrafica("BOLSA CREDITOS HIPOTECARIOS DISPERSADOS");
        graDispersadosHipotecario=dCircularDH.createDemoPanel();  
        graDispersadosHipotecario.setPreferredSize(new Dimension(PWIDTH, PHEIGHT));        
        
        
        //obtiene datos de creditos SOLICITADOS Y AUN NO DISPERSADOS 0 verificar 03/04/2013
        creditosBolsa.calculaPorcentajeUtilizado(0,FIni, fecha);     
        
        //GRAFICAMOS LOS TOTALES DE LA BOLSA
        //GRAFICA TOTAL SOLICITADOS
        double totalS=creditosBolsa.montoVerdeActual+creditosBolsa.montoRojoActual
                +creditosBolsa.montoHipotecarioActual;
        double porcenS=totalS*100/totalRestaB;
        DatosGraficaST.put("Credito Verde Solicitado", porcenS);
        DatosGraficaST.put("Bolsa Credito Verde", 100.0-porcenS);
        diagramaCircular dCircularST = new diagramaCircular();
        //ENVIA DATOS DE LA GRAFICA
        dCircularST.setDatosGrafica(DatosGraficaST);
        dCircularST.setTitutloGrafica("TOTAL CREDITOS SOLICITADOS");
        graTotalSolicitados=dCircularST.createDemoPanel();
        graTotalSolicitados.setPreferredSize(new Dimension(PWIDTH, PHEIGHT));  
        
         
        
        //GRAFICA VERDES SOLICITADOS
        double porcenSV=creditosBolsa.montoVerdeActual*100/bolsaV;
        DatosGraficaSV.put("Credito Verde Solicitado", porcenSV);
        DatosGraficaSV.put("Bolsa Credito Verde", 100.0-porcenSV);
        diagramaCircular dCircularSV = new diagramaCircular();
        //ENVIA DATOS DE LA GRAFICA
        dCircularSV.setDatosGrafica(DatosGraficaSV);
        dCircularSV.setTitutloGrafica("BOLSA CREDITOS VERDE SOLICITADOS");
        graSolicitadosVerde=dCircularSV.createDemoPanel();
        graSolicitadosVerde.setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
        
       //GRAFICA ROJOS SOLICITADOS
        double porcenSR=creditosBolsa.montoRojoActual*100/bolsaR;
        DatosGraficaSR.put("Credito Rojo Solicitado", porcenSR);
        DatosGraficaSR.put("Bolsa Credito Rojo", 100.0-porcenSR);
        diagramaCircular dCircularSR = new diagramaCircular();
        //ENVIA DATOS DE LA GRAFICA
        dCircularSR.setDatosGrafica(DatosGraficaSR);
        dCircularSR.setTitutloGrafica("BOLSA CREDITOS ROJOS SOLICITADOS");
        graSolicitadosRojo=dCircularSR.createDemoPanel();
        graSolicitadosRojo.setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
        
       //GRAFICA HIPOTECARIOS SOLICITADOS
        double porcenSH=creditosBolsa.montoHipotecarioActual*100/bolsaH;
        DatosGraficaSH.put("Credito Hipotecario Solicitado", porcenSH);
        DatosGraficaSH.put("Bolsa Credito Hipotecario", 100.0-porcenSH);
        diagramaCircular dCircularSH = new diagramaCircular();
        //ENVIA DATOS DE LA GRAFICA
        dCircularSH.setDatosGrafica(DatosGraficaSH);
        dCircularSH.setTitutloGrafica("BOLSA CREDITOS HIPOTECARIOS SOLICITADOS");
        graSolicitadosHipotecario=dCircularSH.createDemoPanel();  
        graSolicitadosHipotecario.setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
        
        
        
        
        //damos las caracteristicas de visualización
        
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        getContentPane().add (graSolicitadosVerde, constraints);  
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 1; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        getContentPane().add (graSolicitadosRojo, constraints);
        //grafica dispersados verdes
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 2; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        getContentPane().add (graSolicitadosHipotecario, constraints);  
        
      //grafica dispersados verdes
        constraints.gridx = 1; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        getContentPane().add (graDispersadosVerde, constraints);    
      //grafica dispersados ROJOS
        constraints.gridx = 1; // El área de texto empieza en la columna cero.
        constraints.gridy = 1; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        getContentPane().add (graDispersadosRojo, constraints);  
      //grafica dispersados HIPOTECARIOS
        constraints.gridx = 1; // El área de texto empieza en la columna cero.
        constraints.gridy = 2; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        getContentPane().add (graDispersadosHipotecario, constraints);     
        
        //grafica TOTALES SOLICITADOS
        constraints.gridx = 4; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        getContentPane().add (graTotalSolicitados, constraints);   
        
        //grafica TOTALES DISPERSADOS
        constraints.gridx = 4; // El área de texto empieza en la columna cero.
        constraints.gridy = 1; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;         
        getContentPane().add (graTotalDispersados, constraints);   
        
        
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        String montob=n.format(totalB);
        JLabel lab1 = new JLabel("TOTAL DE BOLSA: "+montob, JLabel.LEFT);
        montob=n.format(totalRestaB);
        JLabel lab2 = new JLabel("RESTA EN BOLSA: "+montob, JLabel.LEFT);
        JPanel p = new JPanel();
        p.setLayout(new GridLayout (0,1));
        p.add(lab1); 
        p.add(lab2);
        constraints.gridx = 4; // El área de texto empieza en la columna cero.
        constraints.gridy = 2; // El área de texto empieza en la fila cero
        constraints.gridwidth = 1; // El área de texto ocupa dos columnas.
        constraints.gridheight = 1; // El área de texto ocupa 2 filas.
        constraints.weightx = 1.0;
        constraints.fill = GridBagConstraints.BOTH;         
        getContentPane().add (p, constraints); 
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 837, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmReporteDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReporteDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReporteDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReporteDirector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmReporteDirector dialog = new frmReporteDirector(new javax.swing.JFrame(), true);
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
    // End of variables declaration//GEN-END:variables
}
