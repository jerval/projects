package com.jvwl.jfreechart.java;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class JFreeChartTest3 {
	public static void main(String[] args) throws Exception {
		JFreeChart chart = ChartFactory.createPieChart("某公司组织结构图",
				getDataset(), true, false, false);

		chart.setTitle(new TextTitle("某公司组织结构图", new Font("宋体", Font.BOLD,
						22)));

		LegendTitle legend = chart.getLegend(0);

		legend.setItemFont(new Font("微软雅黑", Font.BOLD, 14));

		PiePlot plot = (PiePlot) chart.getPlot();

		plot.setLabelFont(new Font("隶书", Font.BOLD, 16));

		OutputStream os = new FileOutputStream("company.jpeg");

		ChartUtilities.writeChartAsJPEG(os, chart, 600, 400);

		os.close();

	}

	private static DefaultPieDataset getDataset() {
		DefaultPieDataset dpd = new DefaultPieDataset();

		dpd.setValue("管理人员", 25);
		dpd.setValue("市场人员", 25);
		dpd.setValue("开发人员", 45);
		dpd.setValue("其他人员", 10);

		return dpd;
	}

}
