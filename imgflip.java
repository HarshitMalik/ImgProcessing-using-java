package flip;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imgflip {

	public static void main(String[] args) {
		 File orgimg = new File("B:\\JAVA\\Images\\h112693.jpg");
	       BufferedImage img = null;
	       try {
			img = ImageIO.read(orgimg);
			BufferedImage buffimg = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_RGB);
			for(int i=0;i<img.getHeight();i++)
			{
				for(int j=0;j<img.getWidth();j++)
				{
					Color c= new Color(img.getRGB(j, i));				
					buffimg.setRGB(img.getWidth()-j-1, i,c.getRGB());
				}
			}
		ImageIO.write(buffimg, "jpg", new File("B:\\JAVA\\Images\\flippedimg.jpg"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}

	}

}
