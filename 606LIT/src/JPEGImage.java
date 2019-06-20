import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class JPEGImage {
	int width;
	int height;
	File file;
	BufferedImage image;
	public JPEGImage(String filepath) throws IOException {
		File file= new File("/606LIT/src/res/blue.jpg");
		BufferedImage image = ImageIO.read(file);
		width = image.getWidth();
		height = image.getHeight();
	}
	


}
