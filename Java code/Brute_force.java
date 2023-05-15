
import org.apache.commons.lang3.RandomStringUtils; 
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import java.util.Scanner;
public class Brute_force  {
	   
// Brute-force string search method        N 			  M
	    public long stringSearch(String T, String P) {
        	long start=System.nanoTime();
        	 int i, j, m, n;

             n = T.length();
             m = P.length();
             i = 0;
             j = 0;

             for ( i = 0; i < n-m; i++ )
             {
                if ( P.equals( T.substring(i, i+m) )  )
                {
                 System.out.println("index: "+i);            // Found P at position i in T     
                }
             }
             long end=System.nanoTime()-start;
             return end;
          }
		/*
		 * public static void main(String[] args) { Brute_force BF = new Brute_force();
		 * double arrtime[]=new double[100],arrBrute[]=new double[100]; double avgBrute
		 * = 0; Scanner in=new Scanner(System.in); String text;
		 * System.out.print("Enter a pattern: "); String pat=in.next(); for(int
		 * i=100;i<=10000;i=i+100) { for(int j=1;j<=1000;j++) { text =
		 * RandomStringUtils.randomAlphanumeric(i); avgBrute+=BF.stringSearch(text,
		 * pat);
		 * 
		 * } System.out.println(avgBrute/1000); arrtime[(i/100)-1]=i;
		 * arrBrute[(i/100)-1]=avgBrute/1000; avgBrute=0;
		 * 
		 * 
		 * } XYChart chart = QuickChart.getChart("BF", "X", "Y", "y(x)", arrtime,
		 * arrBrute); new SwingWrapper(chart).displayChart(); }
		 */
	}

