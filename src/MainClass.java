import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class MainClass
{
	private static int[][] redA = new int[2][9];
	private static int[][] yellowA = new int[2][9];
	private static int[][] blueA = new int[2][9];
	private static int redP=0,yellowP=0, blueP=0;
	
	private static int[] blueC = new int[2];
	private static int[] redC = new int[2];
	private static int[] greenC = new int[2];
	private static int[] yellowC = new int[2];
	
	public static void main( String[] args )
	{

		//      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
		//      Mat mat = Mat.eye( 3, 3, CvType.CV_8UC1 );
		//      System.out.println( "mat = " + mat.dump() );

		BufferedImage bfImage;
		try {
			bfImage = ImageIO.read(new File("testImg.png"));
			int height = bfImage.getHeight();
			int width = bfImage.getWidth();
			for(int i=0; i<height; i++){
				//System.out.println("");
				for(int j=0; j<width; j++){
					
					Color c = new Color(bfImage.getRGB(i,j));
					int red = c.getRed();
					int green = c.getGreen();
					int blue = c.getBlue();

					if(red==255 && green==0 && blue==0){ redA[0][redP]=j; redA[1][redP]=i; redP++;}
					if(red==255 && green==255 && blue==0){ yellowA[0][yellowP]=j; yellowA[1][yellowP]=i; yellowP++;}
					if(red==0 && green==0 && blue==255){ blueA[0][blueP]=j; blueA[1][blueP]=i; blueP++;}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		redC = findC(redA);
		yellowC = findC(yellowA);
		blueC = findC(blueA);
		
		//printP();

		double direcRobot = getAngle(yellowC, blueC);
		System.out.println(direcRobot);
		double direcBall = getAngle(redC, yellowC);
		System.out.println(direcBall);
		double diff=0;

		diff = direcBall - direcRobot;
		if(diff > 180) { diff = diff - 360; }
		if(diff < -180) { diff = diff + 360; }
		System.out.println(diff);

	}
	
	public static void printP(){
//		for(int i = 0 ; i<redA.length; i++){
//			System.out.println("x coord = "+redA[i]+" y coord = "+redA[i+1]);
//			i++;
//		}
		System.out.println("center of blue is: x="+blueC[0]+" y="+blueC[1]);
		System.out.println("center of red is: x="+redC[0]+" y="+redC[1]);
		System.out.println("center of yellow: x="+yellowC[0]+" y="+yellowC[1]);
	}
	
	public static int[] findC(int[][] Array){
		int x = 0, y = 0;
		
		for(int i = 0; i < 9 ; i++){
			x = x + Array[0][i]; 
			y = y + Array[1][i];
		}
		x = x/9; y = y/9;
		int[] Center = {x,y};
		return Center;
	}
	
	public static double getAngle(int[] target1, int[] target2){
		double angle = Math.toDegrees(Math.atan2(target1[0] - target2[0], target1[1] - target2[1]));
		return angle;
	}
}