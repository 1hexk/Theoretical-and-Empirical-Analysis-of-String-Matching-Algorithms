import org.apache.commons.lang3.RandomStringUtils; 
import org.apache.commons.lang3.time.StopWatch;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.style.Styler.LegendPosition;

import com.google.common.base.Stopwatch;



 
public class main implements ExampleChart<XYChart> {
	public static void main(String[] args) {
		Brute_force BF = new Brute_force();
		KMP kmp=new KMP();
		Boyer_Moores BM=new Boyer_Moores();
		long startCpu,endCpu;
		double arrtime[]=new double[100],arrBrute[]=new double[100], arrKMP [] = new double[100],arrMoore [] = new double[100];
		ExampleChart<XYChart> exampleChart = new main();

	       
	       double avgBrute = 0;    
	       double avgKMP = 0;
	       double avgMoore = 0;
		String text;
		String pat; 
			for(int i=100;i<=10000;i=i+100) {
			for(int j=1;j<=5;j++) {
			text = RandomStringUtils.randomAlphanumeric(i);
			pat=RandomStringUtils.randomAlphanumeric(i/100);
			avgBrute+=BF.stringSearch(text, pat); 
			avgKMP+= kmp.KMPSearch(pat,text);
			avgMoore+=BM.Boyer_Moores(text, pat);
		    
			}
			/*
			 * System.out.println(avgBrute/5); System.out.println(avgKMP/5);
			 */
			arrtime[(i/100)-1]=i;
			arrKMP[(i/100)-1]=avgKMP/5;
			avgKMP = 0;
			arrMoore[(i/100)-1]=avgMoore/5;
			avgMoore = 0;
			arrBrute[(i/100)-1]=avgBrute/5;
			avgBrute=0;
		}
		XYChart c=null;
		try {
			c = exampleChart.getChart(arrtime,arrBrute,arrKMP,arrMoore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    new SwingWrapper<XYChart>(c).displayChart();

	}

	@Override
	public XYChart getChart(double[] time, double[] brute, double[] KMP, double[] Moore) {
		// Create Chart
	    XYChart chart = new XYChartBuilder().width(800).height(600).title(getClass().getSimpleName()).xAxisTitle("Size").yAxisTitle("Time").build();

	    // Customize Chart
	    chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
	   // chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
	    //chart.getStyler().setYAxisLabelAlignment(Styler.TextAlignment.Right);
	   // chart.getStyler().setYAxisDecimalPattern("");
	   // chart.getStyler().setPlotMargin(0);
	   // chart.getStyler().setPlotContentSize(.95);

	    // Series
	    // @formatter:off
	   
	    // @formatter:on

	//    XYSeries seriesLiability = chart.addSeries("Time", time, yLiability);
	  //  seriesLiability.setXYSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Area);
	 //   seriesLiability.setMarker(SeriesMarkers.NONE);

	    chart.addSeries("Brute", time, brute);
	    chart.addSeries("KMP", time, KMP);
	   chart.addSeries("Moore", time, Moore);

	    return chart;
	  }

	}

