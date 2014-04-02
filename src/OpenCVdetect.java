import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class OpenCVdetect {

	public static void ProcessImage() throws IOException
	{
		BufferedImage frame;
		frame = ImageIO.read(new File("testImage.jpg"));
		//create the detector
		CannyEdgeDetector detector = new CannyEdgeDetector();

		//adjust its parameters as desired
		detector.setLowThreshold(0.5f);
		detector.setHighThreshold(1f);

		//apply it to an image
		detector.setSourceImage(frame);
		detector.process();
		BufferedImage edges = detector.getEdgesImage();
	    File outputfile = new File("saved.png");
	    ImageIO.write(edges, "png", outputfile);

	}
	
}