import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import javax.imageio.ImageIO;

public class ImageSorter {
	private List<PixelPicture> listPics;
    private BufferedImage image;
    private PixelPicture[] averages = new PixelPicture[12];
    private String[] sortedFilePaths = new String[12];
    
    class compPixelPicture implements Comparator<PixelPicture>{

		@Override
		public int compare(PixelPicture o1, PixelPicture o2) {
			// TODO Auto-generated method stub
			return o1.getAvg()-o2.getAvg();
		}
    	
    }

	
	public ImageSorter(String folderPath) {
		String[] files = {
	    		"/Users/noaleetz/eclipse-workspace/606LIT/src/res/blue.jpg",
	    		"/Users/noaleetz/eclipse-workspace/606LIT/src/res/bluw2.jpg",
	    		"/Users/noaleetz/eclipse-workspace/606LIT/src/res/green.jpg",
	    		"/Users/noaleetz/eclipse-workspace/606LIT/src/res/green2.jpg",
	    		"/Users/noaleetz/eclipse-workspace/606LIT/src/res/grey.jpg",
	    		"/Users/noaleetz/eclipse-workspace/606LIT/src/res/orange.jpg",
	    		"/Users/noaleetz/eclipse-workspace/606LIT/src/res/pink.jpg",
	    		"/Users/noaleetz/eclipse-workspace/606LIT/src/res/purple.jpg",
	    		"/Users/noaleetz/eclipse-workspace/606LIT/src/res/red.jpg",
	    		"/Users/noaleetz/eclipse-workspace/606LIT/src/res/red2.jpg",
	    		"/Users/noaleetz/eclipse-workspace/606LIT/src/res/white.jpg", 
	    		"/Users/noaleetz/eclipse-workspace/606LIT/src/res/yellow.jpg"
	    		};
		int index = 0;
		for(String filePath:files) {
			
			PixelPicture pic = new PixelPicture(filePath);
			pic.getAveragePixelColor();
			averages[index++]=pic;
			
		}
		int index2 = 0;
		Arrays.sort(averages, new compPixelPicture());
		String[] sortedFilePaths = new String[12];
		for(PixelPicture pic:averages) {
			sortedFilePaths[index2++]=averages[index2].getFileName();
		}
		this.sortedFilePaths = sortedFilePaths;
        

	}
	
	public String[] getSortedFilePaths() {
		return this.sortedFilePaths;
	}
	public static void main(String [ ] args) {
		
	}

}
