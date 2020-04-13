package interfaces;

import java.awt.image.BufferedImage;

public interface BufferedImageTools {
	
	BufferedImage getInput();
	BufferedImage getOutput();
	
    void setInput(BufferedImage newInput);
    void setOutput(BufferedImage newOutput);

}
