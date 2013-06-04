package com.jvwl.jfreechart.java;

import javax.swing.JDialog;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartTest {

	public static void main(String[] args) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("开发人员", 54);
		dataset.setValue("管理人员", 32);
		dataset.setValue("其它人员", 12);
		dataset.setValue("市场人员", 21);

		JFreeChart jFreeChart = ChartFactory.createPieChart3D("Title", dataset,
				true, true, false);

		// ChartFrame chartFrame = new ChartFrame("公司人员结构图", jFreeChart);
		ChartPanel chartPanel = new ChartPanel(jFreeChart);
		//JFrame chartFrame = new JFrame("tet");
		JDialog chartFrame = new JDialog();
		chartFrame.add(chartPanel);
		chartFrame.pack();
		chartFrame.setVisible(true);
	}

}
