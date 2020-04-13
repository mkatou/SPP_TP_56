package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import partie_1.GaussianContourExtractorFilter;
import partie_1.GrayFilter;
import partie_1.SingleThreadedImageFilteringEngine;
import partie_2.MultiThreaded_ImageFilteringEngine;

public class Partie_2JUnitTest {
	private final int[] thread_Nbr = { 1, 2, 4, 8, 16, 32 };
	private SingleThreadedImageFilteringEngine Filtering_Engine;
	

	@Test
	public void testGrayFilterMultiThreaded() throws Exception {
		for (int t : thread_Nbr) {
			this.Filtering_Engine = new MultiThreaded_ImageFilteringEngine(t);
			testGrayFilter();
		}

	}

	@Test
	public void testGaussianFilterMultiThreaded() throws Exception {
		for (int t : thread_Nbr) {
			this.Filtering_Engine = new MultiThreaded_ImageFilteringEngine(t);
			testGaussianFilter();
		}
	}

	public void testGrayFilter() throws Exception {
		final String Input_file = "TEST_IMAGES/15226222451_5fd668d81a_c.jpg";
		final String Output_file  = "TEST_IMAGES/p1_test_gray.jpg";
		final String Oracle_file = "TEST_IMAGES/15226222451_5fd668d81a_c_gray.png";
		this.Filtering_Engine.loadImage(Input_file);
		this.Filtering_Engine.applyFilter(new GrayFilter());
		this.Filtering_Engine.writeOutPngImage(Output_file );
		assertTrue(FilesComparator.sameImageByRGB(Oracle_file, Output_file ));

	}

	public void testGaussianFilter() throws Exception {
		final String Input_file = "TEST_IMAGES/15226222451_5fd668d81a_c.jpg";
		final String Output_file  = "TEST_IMAGES/p1_test_gaussian_contour.jpg";
		final String Oracle_file = "TEST_IMAGES/15226222451_5fd668d81a_c_gaussian_contour.png";
		this.Filtering_Engine.loadImage(Input_file);
		this.Filtering_Engine.applyFilter(new GrayFilter());
		this.Filtering_Engine.applyFilter(new GaussianContourExtractorFilter());
		this.Filtering_Engine.writeOutPngImage(Output_file );
		assertTrue(!FilesComparator.sameImageByRGB(Oracle_file, Output_file ));
	}

}
