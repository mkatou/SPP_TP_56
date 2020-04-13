package partie_1;
import interfaces.IFilter;
import interfaces.IImageFilteringEngine;


import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class SingleThreadedImageFilteringEngine extends Thread implements IImageFilteringEngine {
	protected BufferedImage inImage;
    protected BufferedImage outImage;

    @Override
    public void loadImage(String inputImage) throws Exception {
        this.inImage = ImageIO.read(new File(inputImage));
        this.outImage = new BufferedImage(inImage.getWidth(), inImage.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void writeOutPngImage(String outFile) throws Exception {
        File file = new File(outFile);
        ImageIO.write(this.outImage, "png", file);
    }

    @Override
    public void setImg(BufferedImage newImg) {
        this.inImage = newImg;
        this.outImage = new BufferedImage(inImage.getWidth(), inImage.getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public BufferedImage getImg() {
        return this.outImage;
    }

    @Override
    public void applyFilter(IFilter someFilter) {
        this.outImage = new BufferedImage(this.inImage.getWidth() - 2 * someFilter.getMargin(),
                this.inImage.getHeight() - 2 * someFilter.getMargin(),
                BufferedImage.TYPE_INT_RGB);

        for(int i_x = someFilter.getMargin(); i_x < this.inImage.getWidth() - someFilter.getMargin(); i_x++) {
            for(int i_y = someFilter.getMargin(); i_y < this.inImage.getHeight() - someFilter.getMargin(); i_y++) {
                someFilter.applyFilterAtPoint(i_x, i_y, this.inImage, this.outImage);
            }
        }
        this.inImage = this.outImage;
    }
}
