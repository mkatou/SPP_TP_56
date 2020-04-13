package partie_1;

public class Main {
	static public void main(String[] args) throws Exception {
		SingleThreadedImageFilteringEngine Image_Filtering_Engine;
		Image_Filtering_Engine = new SingleThreadedImageFilteringEngine();

		Image_Filtering_Engine.loadImage("TEST_IMAGES/15226222451_5fd668d81a_c.jpg");
		Image_Filtering_Engine.applyFilter(new GrayFilter());
		Image_Filtering_Engine.applyFilter(new GaussianContourExtractorFilter());
		Image_Filtering_Engine.writeOutPngImage("TEST_IMAGES/tmp_gauss.jpg");
	}

}
