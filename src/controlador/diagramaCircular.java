/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Font;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Juan
 */
public class diagramaCircular {
    //mapa que contiene los datos de la grafia
    private Map<String, Double> DatosGrafica;
    //variable que tiene el titulo de la grafica
    private String TituloGrafica;
    
    //se da el titulo de la grafica
    public void setTitutloGrafica(String TituloGrafica)
    {
        this.TituloGrafica=TituloGrafica;
    }
    //Se envian los datos de la grafica
    public void setDatosGrafica(Map<String, Double> DatosGrafica)
    {
        this.DatosGrafica=DatosGrafica;
    }
    
    //
    private PieDataset createDataset(Map<String, Double> DatosGrafica) {
        //Map<String,Double> DG= new HashMap<String, Double>();
        DefaultPieDataset dataset = new DefaultPieDataset();                
        int i=DatosGrafica.size();
        Iterator it=DatosGrafica.entrySet().iterator();
        /**Set<Map.Entry<String, Double>> set = DatosGrafica.entrySet();
        for (Map.Entry<String, Double> me : set) {
            dataset.setValue(me.getKey(),me.getValue());
        }**/
        while(it.hasNext()){
           Map.Entry<String, Double>  e=(Map.Entry)it.next();
           dataset.setValue(e.getKey(),e.getValue());
        }
        return dataset;            
    }
        
    private  JFreeChart createChart(PieDataset dataset, String TituloGrafica) {
        
        JFreeChart chart = ChartFactory.createPieChart(
            TituloGrafica,  // chart title
            dataset,             // data
            true,               // include legend
            true,
            false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
    }   
        //regresa un Panel que contiene la grafica
    public JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset(DatosGrafica),TituloGrafica);
        return new ChartPanel(chart);
    }        
    
}
