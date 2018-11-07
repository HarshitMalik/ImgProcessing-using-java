package img;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgRead {

	public static void main(String[] args) {
		
       File orgimg = new File("test1.jpg");
       BufferedImage img = null;
       try {
		img = ImageIO.read(orgimg);
		BufferedImage greyscaleimg = new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_INT_RGB);
		for(int i=0;i<img.getHeight();i++)
		{
			for(int j=0;j<img.getWidth();j++)
			{
				Color c= new Color(img.getRGB(j, i));
				int r=c.getRed();
				int g=c.getGreen();
				int b=c.getBlue();
				int a=c.getAlpha();
				int gr= (r+g+b)/3;
				Color grc= new Color(gr,gr,gr,a);
				greyscaleimg.setRGB(j, i, grc.getRGB());
			}
		}
	ImageIO.write(greyscaleimg, "jpg", new File("greyscaleimg.jpg"));
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	}

}
