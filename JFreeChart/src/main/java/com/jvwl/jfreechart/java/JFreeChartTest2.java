package com.jvwl.jfreechart.java;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class JFreeChartTest2 extends ApplicationFrame
{
	public JFreeChartTest2(String title)
	{
		super(title);

		this.setContentPane(createPanel());
	}

	public static CategoryDataset createDataset()
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.setValue(10, "aa", "管理人员");
		dataset.setValue(20, "bb", "市场人员");
		dataset.setValue(40, "cc", "开发人员");
		dataset.setValue(15, "dd", "其他人员");

		return dataset;
	}

	public static JFreeChart createChart(CategoryDataset dataset)
	{
		JFreeChart chart = ChartFactory.createBarChart3D("hello", "人员分布", "人员数量",
				dataset, PlotOrientation.VERTICAL, true, false, false);

		chart.setTitle(new TextTitle("某公司组织结构图", new Font("宋体", Font.BOLD
				+ Font.ITALIC, 20)));

		CategoryPlot plot = (CategoryPlot) chart.getPlot();

		CategoryAxis categoryAxis = plot.getDomainAxis();

		categoryAxis.setLabelFont(new Font("微软雅黑", Font.BOLD, 12));

		return chart;

	}

	public static JPanel createPanel()
	{
		JFreeChart chart = createChart(createDataset());

		return new ChartPanel(chart);
	}

	public static void main(String[] args)
	{
		JFreeChartTest2 chart = new JFreeChartTest2("某公司组织结构图");

		chart.pack();
		chart.setVisible(true);
	}

}
