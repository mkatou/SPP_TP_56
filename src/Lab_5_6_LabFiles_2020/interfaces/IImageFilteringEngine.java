package Lab_5_6_LabFiles_2020.interfaces;

import java.awt.image.*;

public interface IImageFilteringEngine {

  public void loadImage(String inputImage) throws Exception ;
  public void writeOutPngImage(String outFile) throws Exception ;
  public void setImg(BufferedImage newImg) ;
  public BufferedImage getImg() ;
  public void applyFilter(IFilter someFilter) ;
  
} // EndInterface IImageFilteringEngine
