package Lab_5_6_LabFiles_2020;


import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class SimpleImageProcessingExample {

  static public void main(String[] args) throws Exception {
    // reading image in
    BufferedImage inImg  = ImageIO.read(new File("TEST_IMAGES/15226222451_5fd668d81a_c.jpg"));
    // creating new image
    BufferedImage outImg = new BufferedImage(inImg.getWidth(),
                                             inImg.getHeight(),
                                             BufferedImage.TYPE_INT_RGB);
    // generating new image from original
    for (int x = 0; x < inImg.getWidth(); x++) {
      for (int y = 0; y < inImg.getHeight(); y++) {
          int rgb    = inImg.getRGB(x,y);
          // extracting red, green and blue components from rgb integer
          int red    = (rgb >> 16) & 0x000000FF;
          int green  = (rgb >>  8) & 0x000000FF;
          int blue   = (rgb      ) & 0x000000FF;
          // computing new color from extracted components
          int newRgb = ( ( (green << 16) | blue ) << 16 ) | red ; // rotating RGB values
          outImg.setRGB(x,y,newRgb);
      } // EndFor y
    } // EndFor x

    // writing out new image
    File f = new File("TEST_IMAGES/tmp.png");
    ImageIO.write(outImg, "png", f);
    
  } // EndMain

} // EndClass SimpleImageProcessingExample
