package Lab_5_6_LabFiles_2020.tests;

import static org.junit.Assert.*;

//import org.junit.Before;
import org.junit.*;
import Lab_5_6_LabFiles_2020.partie_1.GaussianContourExtractorFilter;
import Lab_5_6_LabFiles_2020.partie_1.GrayFilter;
import Lab_5_6_LabFiles_2020.partie_1.SingleThreadedImageFilteringEngine;

public class Partie_1JUnitTest {
	private SingleThreadedImageFilteringEngine Filtering_Engine;

	@Before
	public void SemaphoreImplementation() throws Exception {
		Filtering_Engine = new SingleThreadedImageFilteringEngine();
	}

	@Test
	public void testGrayFilter() throws Exception {
		final String Input_file = "TEST_IMAGES/15226222451_5fd668d81a_c.jpg";
		final String Output_file = "TEST_IMAGES/p1_test_gray.jpg";
		final String fileOracle = "TEST_IMAGES/15226222451_5fd668d81a_c_gray.png";
		this.Filtering_Engine.loadImage(Input_file);
		this.Filtering_Engine.applyFilter(new GrayFilter());
		this.Filtering_Engine.writeOutPngImage(Output_file );

		assertTrue(FilesComparator.sameImageByRGB(fileOracle, Output_file ));
	}

	@Test
	public void testGaussianFilter() throws Exception {
		final String Input_file = "TEST_IMAGES/15226222451_5fd668d81a_c.jpg";
		final String Output_file  = "TEST_IMAGES/p1_test_gaussian_contour.jpg";
		final String fileOracle = "TEST_IMAGES/15226222451_5fd668d81a_c_gaussian_contour.png";
		this.Filtering_Engine.loadImage(Input_file);
		this.Filtering_Engine.applyFilter(new GrayFilter());
		this.Filtering_Engine.applyFilter(new GaussianContourExtractorFilter());
		this.Filtering_Engine.writeOutPngImage(Output_file );
		assertTrue(!FilesComparator.sameImageByRGB(fileOracle, Output_file ));
	}

}
