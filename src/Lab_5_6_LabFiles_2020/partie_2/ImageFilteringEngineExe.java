package Lab_5_6_LabFiles_2020.partie_2;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import Lab_5_6_LabFiles_2020.interfaces.IFilter;
public class ImageFilteringEngineExe implements Runnable{
	private BufferedImageTools buffers;
    private List<AbstractMap.SimpleEntry<IFilter, Integer>> works;

    public ImageFilteringEngineExe(BufferedImageTools buffers) {
        this.buffers = buffers;
        this.works = new ArrayList<>();
    }

    public synchronized void addWork(IFilter filter, int y) {
        this.works.add(new AbstractMap.SimpleEntry<>(filter, y));
    }

    @Override
    public synchronized void run() {
        for(AbstractMap.SimpleEntry<IFilter, Integer> work : this.works) {
            for(int x = work.getKey().getMargin(); x < this.buffers.getInput().getWidth() - work.getKey().getMargin(); x++) {
                work.getKey().applyFilterAtPoint(x, work.getValue(), this.buffers.getInput(), this.buffers.getOutput());
            }
        }
        this.works.clear();
    }

}
