package Lab_5_6_LabFiles_2020.partie_2;
import java.util.AbstractMap;

import java.util.ArrayList;
import java.util.List;

import Lab_5_6_LabFiles_2020.interfaces.IFilter;
public class ImageFilteringEngineExe implements Runnable{
	private BufferedImageTools bufferedImage;
    private List<AbstractMap.SimpleEntry<IFilter, Integer>> simpleList;

    public ImageFilteringEngineExe(BufferedImageTools bufferedImage) {
        this.bufferedImage = bufferedImage;
        this.simpleList = new ArrayList<>();
    }

    public synchronized void addWork(IFilter filter, int n) {
        this.simpleList.add(new AbstractMap.SimpleEntry<>(filter, n));
    }

    @Override
    public synchronized void run() {
        for(AbstractMap.SimpleEntry<IFilter, Integer> simple : this.simpleList) {
            for(int i_x = simple.getKey().getMargin(); i_x < this.bufferedImage.getInput().getWidth() - simple.getKey().getMargin(); i_x++) {
            	simple.getKey().applyFilterAtPoint(i_x, simple.getValue(), this.bufferedImage.getInput(), this.bufferedImage.getOutput());
            }
        }
        this.simpleList.clear();
    }

}
