package ru.gavryushkin.parser;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import ru.gavryushkin.parser.model.Point;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class LineChart1 extends JFrame {
    static CategoryDataset dataset;
    private static final long serialVersionUID = 1L;

    public LineChart1(final String title)
    {
        super(title);
         dataset    = Datasetp.createDataset1();
        final JFreeChart chart      = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        //chartPanel.setPreferredSize(new Dimension(330, 280));
        //chartPanel.setPreferredSize(new Dimension(330, 280));

        setContentPane(chartPanel);
    }

    private JFreeChart createChart(final CategoryDataset dataset)
    {
        final JFreeChart chart = ChartFactory.createLineChart(
                "",       // chart title
                "Цена входа",                      // domain axis label
                "Доходнодность в пунктах",                // range axis label
                dataset,                   // data
                PlotOrientation.VERTICAL,  // orientation
                false,                      // include legend
                true,                      // tooltips
                false                      // urls
        );

        chart.setBackgroundPaint(new Color(224,224,224));

        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(4, 179, 215, 98));
        plot.setRangeGridlinePaint(Color.black);

        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(
                NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);

        LineAndShapeRenderer renderer;
        renderer = (LineAndShapeRenderer) plot.getRenderer();
        int y=1;
        if(y>0)
            renderer.setSeriesPaint  (0, new Color(112,128,144));
        renderer.setSeriesStroke (0, new BasicStroke(2.0f));
        return chart;
    }

    void create_graphics() {
        {
            final LineChart1 demo = new LineChart1("Equity");
            demo.pack();
            demo.setBounds(1000,230,350,280);
            demo.setIconImage(new ImageIcon("graph.png").getImage());
            demo.setVisible(true);
        }
    }

    public static List<Point> getList() {
        return Datasetp.getList();
    }
}