package Lab_5_6_LabFiles_2020.partie_2;

import Lab_5_6_LabFiles_2020.interfaces.IFilter;
import Lab_5_6_LabFiles_2020.partie_1.SingleThreadedImageFilteringEngine;

import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreaded_ImageFilteringEngine extends SingleThreadedImageFilteringEngine implements BufferedImageTools {
	private ImageFilteringEngineExe[] workers;

	public MultiThreaded_ImageFilteringEngine(int numberWorkerThread) {
		this.workers = new ImageFilteringEngineExe[numberWorkerThread];
		for (int i = 0; i < this.workers.length; i++) {
			this.workers[i] = new ImageFilteringEngineExe(this);
		}
	}

	public void applyFilter(IFilter someFilter) {
		ExecutorService es = Executors.newCachedThreadPool();
		this.outImage = new BufferedImage(this.inImage.getWidth() - 2 * someFilter.getMargin(),
		this.inImage.getHeight() - 2 * someFilter.getMargin(), BufferedImage.TYPE_INT_RGB);

		int workerInd = 0;
		for (int y = someFilter.getMargin(); y < this.inImage.getHeight() - someFilter.getMargin(); y++) {
			this.workers[workerInd].addWork(someFilter, y);
			es.execute(this.workers[workerInd]);
			workerInd++;
			if (workerInd >= this.workers.length)
				workerInd = 0;
		}

		es.shutdown();
		try {
			es.awaitTermination(365, TimeUnit.DAYS); // No timeout
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
