import org.knowm.xchart.XYChart;

public interface ExampleChart<T> {
	public XYChart getChart(double[] time, double []brute, double [] KMP, double [] Moore);
}
