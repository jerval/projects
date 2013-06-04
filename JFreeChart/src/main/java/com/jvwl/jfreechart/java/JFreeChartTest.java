package com.jvwl.jfreechart.java;

import javax.swing.JDialog;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartTest {

	public static void main(String[] args) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("������Ա", 54);
		dataset.setValue("������Ա", 32);
		dataset.setValue("������Ա", 12);
		dataset.setValue("�г���Ա", 21);

		JFreeChart jFreeChart = ChartFactory.createPieChart3D("Title", dataset,
				true, true, false);

		// ChartFrame chartFrame = new ChartFrame("��˾��Ա�ṹͼ", jFreeChart);
		ChartPanel chartPanel = new ChartPanel(jFreeChart);
		//JFrame chartFrame = new JFrame("tet");
		JDialog chartFrame = new JDialog();
		chartFrame.add(chartPanel);
		chartFrame.pack();
		chartFrame.setVisible(true);
	}

}
