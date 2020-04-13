package partie_2;

import partie_1.GaussianContourExtractorFilter;
import partie_1.GrayFilter;

public class Main {
	public static void main(String [] args) throws Exception {
        MultiThreaded_ImageFilteringEngine FilteringEngine = new MultiThreaded_ImageFilteringEngine(10);
        FilteringEngine.loadImage("TEST_IMAGES/15226222451_5fd668d81a_c.jpg");
        FilteringEngine.applyFilter(new GrayFilter());
        FilteringEngine.applyFilter(new GaussianContourExtractorFilter());
        FilteringEngine.writeOutPngImage("TEST_IMAGES/tmp_gauss.jpg");
    }

}
