import java.lang.management.ManagementFactory;
import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import com.sun.management.OperatingSystemMXBean;

public class KMP {
		// Driver code
	   
	// JAVA program for implementation of KMP pattern
	// searching algorithm
	    public long KMPSearch(String p, String S) 
		{ 
	    	long start=System.nanoTime();
			int m = p.length(); 
			int n = S.length(); 

			// creating lps array
			int lps[] = new int[m]; 
			int j = 0; 

			// finding prefix table
			computeLPSArray(p, m, lps); 

			int i = 0;  
			while (i < n) { 
				if (p.charAt(j) == S.charAt(i)) { 
					j++; 
					i++; 
				} 
				if (j == m) { 
					System.out.println("Pattern found at location: "+ (i - j)); 
					j = lps[j - 1]; 
				} 

				// mismatch case 
				else if (i < n && p.charAt(j) != S.charAt(i)) { 
					// Skip matching lps[0..lps[j-1]] characters 
					
					if (j != 0) 
						j = lps[j - 1]; 
					else
						i = i + 1; 
				} 
			} 
		
	    	long end=System.nanoTime();

	        //return watch.getStopTime();
	    	return end-start;
	    }
	 
	     void computeLPSArray(String pat, int M, int lps[])
	    {
	        // length of the previous longest prefix suffix
	        int len = 0;
	        int i = 1;
	        lps[0] = 0; // lps[0] is always 0
	 
	        // the loop calculates lps[i] for i = 1 to M-1
	        while (i < M) {
	            if (pat.charAt(i) == pat.charAt(len)) {
	                len++;
	                lps[i] = len;
	                i++;
	            }
	            else // (pat[i] != pat[len])
	            {
	                // This is tricky. Consider the example.
	                // AAACAAAA and i = 7. The idea is similar
	                // to search step.
	                if (len != 0) {
	                    len = lps[len - 1];
	 
	                    // Also, note that we do not increment
	                    // i here
	                }
	                else // if (len == 0)
	                {
	                    lps[i] = len;
	                    i++;
	                }
	            }
	        }
	    }
	 
	    public static void main(String[] args) {
			KMP kmp=new KMP();
			double arrtime[]=new double[100],arrKMP[]=new double[100];      
		    double avgKMP = 0;   
		    Scanner in=new Scanner(System.in);
			String text;
			System.out.print("Enter a pattern: ");
			String pat=in.next();
			for(int i=100;i<=10000;i=i+100) {
				for(int j=1;j<=5;j++) {
				text = RandomStringUtils.randomAlphanumeric(i);
				avgKMP+=kmp.KMPSearch(text, pat);
			    
				}
				System.out.println(avgKMP/5); 
				arrtime[(i/100)-1]=i;
				arrKMP[(i/100)-1]=avgKMP/5;
				avgKMP=0;
				
				
			}
			XYChart chart = QuickChart.getChart("KMP", "X", "Y", "y(x)", arrtime, arrKMP);
			new SwingWrapper(chart).displayChart();
		}
	}
