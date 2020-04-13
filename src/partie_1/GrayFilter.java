package partie_1;

import java.awt.*;
import java.awt.image.BufferedImage;

import interfaces.IFilter;

public class GrayFilter implements IFilter {
	
	//margin withdrawal
	@Override
	public int getMargin() {
		// TODO Auto-generated method stub
		return 0;
	}
	 //Point-by-point Gray filter application
	@Override
    public void applyFilterAtPoint(int x, int y, BufferedImage imgIn, BufferedImage imgOut) {
        int rgb    = imgIn.getRGB(x,y);
        Color color = new Color(rgb);
        int grey = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
        imgOut.setRGB(x , y, new Color(grey, grey, grey).getRGB());
    }

}
