package Lab_5_6_LabFiles_2020.partie_1;
import Lab_5_6_LabFiles_2020.interfaces.IFilter;

import java.awt.*;
import java.awt.image.BufferedImage;



public class GaussianContourExtractorFilter implements IFilter {
	
	//margin withdrawal
	@Override 
	public int getMargin() {
		// TODO Auto-generated method stub
		return 5;
	}
	 //Point-by-point Gaussian filter application
	 public void applyFilterAtPoint(int x, int y, BufferedImage imgIn, BufferedImage imgOut) {
	        double dltX = 0; double dltY = 0;

	        for(int i_x = -getMargin(); i_x <= getMargin(); i_x++) {
	            for(int i_y = -getMargin(); i_y <= getMargin(); i_y++) {
	                int rgb = imgIn.getRGB(x + i_x, y + i_y);
	                int blue = (rgb) & 0x000000FF;
	                double V_ = blue * Math.exp(-0.25 * (Math.pow(i_x, 2) + Math.pow(i_y, 2)));
	                dltX += Integer.signum(i_x) * V_;
	                dltY += Integer.signum(i_y) * V_;
	            }
	        }

	        double N_ = Math.sqrt(Math.pow(dltX, 2) + Math.pow(dltY, 2));
	        double V_ = 255.0 - 0.5 * N_;
	        int V_grey = (int) Math.round(Math.max(0.0d, V_));
	        imgOut.setRGB(x - this.getMargin() , y - this.getMargin(), new Color(V_grey, V_grey, V_grey).getRGB());
	    }

}
