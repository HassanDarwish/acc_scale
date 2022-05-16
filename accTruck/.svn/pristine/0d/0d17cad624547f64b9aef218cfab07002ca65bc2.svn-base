package truck_scale.interfaces;

import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import observer.Logger;

public interface getIcon {


	public final ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	
	public default ImageIcon get_Icon(String img,Logger log) {
	 	 
		URL url=classloader.getResource(img);
		
		if(url==null) {
			url=classloader.getResource("resources/"+img);
		} 
		
		java.awt.image.BufferedImage Bimg = null;
		try {
			Bimg = ImageIO.read(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.update(e.toString());
			e.printStackTrace();

		}
	
	
	return new ImageIcon(Bimg);
}
}
