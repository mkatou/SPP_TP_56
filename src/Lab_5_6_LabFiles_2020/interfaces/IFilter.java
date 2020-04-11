package Lab_5_6_LabFiles_2020.interfaces;

import java.awt.image.*;

public interface IFilter {
   int  getMargin();
   void applyFilterAtPoint(int x, int y,
                                 BufferedImage imgIn,
                                 BufferedImage imgOut);
} // EndInterface IFilter
