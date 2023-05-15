import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import java.lang.Math;
import com.google.common.base.Stopwatch;

public class Boyer_Moores { 
	/* Java Program for Bad Character Heuristic of Boyer
	Moore String Matching Algorithm */
	     static int NO_OF_CHARS = 256;
	      
	    //A utility function to get maximum of two integers
	     static int max (int a, int b) { return (a > b)? a: b; }
	 
	     //The preprocessing function for Boyer Moore's
	     //bad character heuristic
	     static void badCharHeuristic( String string, int size,int badchar[])
	     {
	 
	    	// Initialize all occurrences as -1
		      for (int i = 0; i < NO_OF_CHARS; i++)
		           badchar[i] = -1;
		 
		      // Fill the actual value of last occurrence
		      // of a character (indices of table are ascii and values are index of occurrence)
		      for (int i = 0; i < size; i++)
		           badchar[(int) string.charAt(i)] = i;
		     }
		 
		     /* A pattern searching function that uses Bad
		     Character Heuristic of Boyer Moore Algorithm */
		     static long  Boyer_Moores( String text,  String string)
		     {
		    	 long st=System.nanoTime();
		    	 //StopWatch watch=new StopWatch();
		    	 //watch.start();
		      int m = string.length();
		      int n = text.length();
		 
		      int badchar[] = new int[NO_OF_CHARS];
		 
		      /* Fill the bad character array by calling
		         the preprocessing function badCharHeuristic()
		         for given pattern */
		      badCharHeuristic(string, m, badchar);
		 
		      int s = 0;  // s is shift of the pattern with
		                  // respect to text
		       //there are n-m+1 potential alignments
		      while(s <= (n - m))
		      {
		          int j = m-1;
		 
		          /* Keep reducing index j of pattern while
		             characters of pattern and text are
		             matching at this shift s */
		          while(j >= 0 && string.charAt(j) == text.charAt(s+j))
		              j--;
		 
		          /* If the pattern is present at current
		             shift, then index j will become -1 after
		             the above loop */
		          if (j < 0)
		          {
		            
		              s += (s+m < n)? m-badchar[text.charAt(s+m)] : 1;
		 
		          }
		 
		          else
		             
		              s += max(1, j - badchar[text.charAt(s+j)]);
		      } 
		     // watch.stop();
		      long end=System.nanoTime() -st;
		      return end;
	}
		     public static void main(String[] args) {
		    	 
		    	 double arrtime[]=new double[100],arrBoyer[]=new double[100];      
				    double avgBoyer = 0;   
				    Scanner in=new Scanner(System.in);
					String text;
					System.out.print("Enter a pattern: ");
					String pat=in.next();
					for(int i=100;i<=10000;i=i+100) {
						for(int j=1;j<=5;j++) {
						text = RandomStringUtils.randomAlphanumeric(i);
						avgBoyer+=Boyer_Moores(text, pat);
					    
						}
						System.out.println(avgBoyer/5); 
						arrtime[(i/100)-1]=i; 
						arrBoyer[(i/100)-1]=avgBoyer/5;
						avgBoyer=0;
						
						
					}
					XYChart chart = QuickChart.getChart("Boyer moores", "X", "Y", "y(x)", arrtime, arrBoyer);
					new SwingWrapper(chart).displayChart();
				}

	}  
