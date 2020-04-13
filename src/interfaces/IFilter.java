package interfaces;

import java.awt.image.*;

public interface IFilter {
   int  getMargin();
   void applyFilterAtPoint(int x, int y,
                                 BufferedImage imgIn,
                                 BufferedImage imgOut);
} // EndInterface IFilter
