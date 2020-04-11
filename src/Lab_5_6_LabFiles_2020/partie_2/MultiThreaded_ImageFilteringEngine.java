package Lab_5_6_LabFiles_2020.partie_2;

import Lab_5_6_LabFiles_2020.interfaces.BufferedImageTools;
import Lab_5_6_LabFiles_2020.interfaces.IFilter;
import Lab_5_6_LabFiles_2020.partie_1.SingleThreadedImageFilteringEngine;

import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreaded_ImageFilteringEngine extends SingleThreadedImageFilteringEngine implements BufferedImageTools {
	private ImageFilteringEngineExe[] engines;

	public MultiThreaded_ImageFilteringEngine(int nThread) {
		this.engines = new ImageFilteringEngineExe[nThread];
		for (int i = 0; i < this.engines.length; i++) {
			this.engines[i] = new ImageFilteringEngineExe(this);
		}
	}

	public void applyFilter(IFilter flt) {
		ExecutorService executor_service = Executors.newCachedThreadPool();
		this.outImage = new BufferedImage(this.inImage.getWidth() - 2 * flt.getMargin(),
		this.inImage.getHeight() - 2 * flt.getMargin(), BufferedImage.TYPE_INT_RGB);

		int engine = 0;
		for (int i_y = flt.getMargin(); i_y < this.inImage.getHeight() - flt.getMargin(); i_y++) {
			this.engines[engine].addWork(flt, i_y);
			executor_service.execute(this.engines[engine]);
			engine++;
			if (engine >= this.engines.length)
				engine = 0;
		}

		executor_service.shutdown();
		try {
			executor_service.awaitTermination(365, TimeUnit.DAYS); // No timeout
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.inImage = this.outImage;
	}

	@Override
	public BufferedImage getInput() {
		// TODO Auto-generated method stub
		return this.inImage;
	}

	@Override
	public void setInput(BufferedImage newInput) {
		// TODO Auto-generated method stub
		this.inImage = newInput;

	}

	@Override
	public BufferedImage getOutput() {
		// TODO Auto-generated method stub
		return this.outImage;
	}

	@Override
	public void setOutput(BufferedImage newOutput) {
		// TODO Auto-generated method stub
		this.outImage = newOutput;
	}

}
