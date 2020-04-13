package partie_3;

import partie_1.GaussianContourExtractorFilter;
import partie_1.GrayFilter;
import partie_1.SingleThreadedImageFilteringEngine;
import partie_2.MultiThreaded_ImageFilteringEngine;

public class Main {

	private static final int THREAD_LIMIT = 10;
	private static final String IMAGE__TEST = "TEST_IMAGES/15226222451_a49b1a624b_h.jpg" ;

	public static void main(String[] args) throws Exception {
		
		System.out.println("Single Threaded Engine");
		SingleThreadedImageFilteringEngine single_thread = new SingleThreadedImageFilteringEngine();
		single_thread.loadImage(IMAGE__TEST);
		System.out.println("Gray filter : " + PerformanceAnalysis.preformance_time(single_thread, new GrayFilter()) + " s");
		System.out.println("Gaussian filter : " + PerformanceAnalysis.preformance_time(single_thread, new GaussianContourExtractorFilter()) + " s");
		System.out.println("\n");

		//Threads array
		System.out.println("Multi Threaded Engine");
		double[] gray_time = new double[THREAD_LIMIT + 1];
		double[] gaussian_time = new double[THREAD_LIMIT + 1];
		MultiThreaded_ImageFilteringEngine multi_thread;
		
		// thread by thread performance computing
		for (int i = 1; i <= THREAD_LIMIT; i++) {
			System.out.println("\n thread " + i);
			multi_thread = new MultiThreaded_ImageFilteringEngine(i);
			multi_thread.loadImage("TEST_IMAGES/15226222451_5fd668d81a_c.jpg");

			gray_time[i] = PerformanceAnalysis.preformance_time(multi_thread, new GrayFilter());
			gaussian_time[i] = PerformanceAnalysis.preformance_time(multi_thread, new GaussianContourExtractorFilter());
			
			// time display 
			System.out.println("Gray filter : " + gray_time[i] + " s");
			System.out.println("Gaussian filter : " + gaussian_time[i] + " s");
		}
		// CSV file output
		PerformanceAnalysis.CSVOutput("gray.csv", gray_time);
		PerformanceAnalysis.CSVOutput("gaussian.csv", gaussian_time);
	}


} //Main
