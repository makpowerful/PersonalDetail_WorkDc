package NAL_JavaQuestions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.mail.FetchProfile;

public class _44_imageHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			File file = new File(System.getProperty("user.dir") +"\\Resources\\TestIMG.png");
			BufferedImage image =  ImageIO.read(file);
			//ImageIO.write(image, "jpg", ".\\Image\\TestIMG.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ImageIO.write(image, "jpg", ".\\Image\\TestIMG.jpg");
	}
	
	//Unable to write hence not running this program

}
