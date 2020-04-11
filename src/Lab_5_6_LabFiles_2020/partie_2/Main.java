package Lab_5_6_LabFiles_2020.partie_2;

import Lab_5_6_LabFiles_2020.partie_1.GaussianContourExtractorFilter;
import Lab_5_6_LabFiles_2020.partie_1.GrayFilter;

public class Main {
	public static void main(String [] args) throws Exception {
        MultiThreaded_ImageFilteringEngine engine = new MultiThreaded_ImageFilteringEngine(6);
        engine.loadImage("TEST_IMAGES/15226222451_5fd668d81a_c.jpg");
        engine.applyFilter(new GrayFilter());
        engine.applyFilter(new GaussianContourExtractorFilter());
        engine.writeOutPngImage("TEST_IMAGES/tmp_gauss.jpg");
    }

}
