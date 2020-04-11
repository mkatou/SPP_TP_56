package Lab_5_6_LabFiles_2020.tests;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class FilesComparator {
	
	public static boolean sameFileByBytes(String f1, String f2) {
        try {
            byte[] file_by_btes1 = Files.readAllBytes(Paths.get(f1));
            byte[] file_by_btes2 = Files.readAllBytes(Paths.get(f2));
            return Arrays.equals(file_by_btes1, file_by_btes2);
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean sameImageByRGB(String f1, String f2) {
        try {
            BufferedImage image_by_RGB1 = ImageIO.read(new File(f1));
            BufferedImage image_by_RGB2 = ImageIO.read(new File(f2));

            if(image_by_RGB1.getWidth() != image_by_RGB2.getWidth() || image_by_RGB1.getHeight() != image_by_RGB2.getHeight()) {
                return false;
            }

            for(int i_x = 0; i_x < image_by_RGB1.getWidth(); i_x++) {
                for(int i_y = 0; i_y < image_by_RGB1.getHeight(); i_y++) {
                    if(image_by_RGB1.getRGB(i_x, i_y) != image_by_RGB2.getRGB(i_x, i_y)) {
                        new Color(image_by_RGB1.getRGB(i_x, i_y)).toString();
                        new Color(image_by_RGB2.getRGB(i_x, i_y)).toString();
                        return false;
                    }
                }
            }

        } catch (IOException e) {
            return false;
        }
        return true;
    }
	

}
