import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.imageio.ImageIO;


public class Circles {

	private static LinkedList<int[]> circles = new LinkedList<int[]>();
	private static int setSize=10; //this determines minimum size of our circle pixel radius
	public static boolean right=false;
	public static boolean left=false;
	public static boolean top=false;
	public static boolean bottom=false;
	private static LinkedList<int[]> Borders;

	public Circles(LinkedList<int[]> Borders){
		Circles.Borders = Borders;
	}

	public static LinkedList<int[]> detectCircles(LinkedList<int[]> Borders) throws IOException{
		//look at pixels around around supposed center of circle

		BufferedImage frame;
		frame = ImageIO.read(new File("saved.png"));

		int[] radius = {27,28,29};
		//run through all white areas of drawn image to look for circular object with approximate radius of ping pong ball
		for(int[] borders : Borders){
			for (int i = 0 ; i<Borders.size(); i++){
				int[] temp = Borders.get(i);
				for (int k = 0 ; k<radius.length; k++){
					if((borders[0]+radius[k]*2) == temp[0] || (borders[0]+radius[k]*2 - 1) == temp[0]){//check if x coord has diameter match
						for (int l = 0 ; l<Borders.size(); l++){
							int[] temp2 = Borders.get(l);
							for (int j = 0 ; j<radius.length; j++){ //run through radiuses on y coord
								if((borders[0]+radius[j]) == temp[1] || (borders[0]+radius[j] - 1) == temp[1]){}
							}
						}
					}
				}
			}
		}

		return circles;
		//		
		//		int[] current = new int[2];
		//		for(int c = 0; c<Borders.size(); c++){	
		//			current = Borders.get(c);
		//			
		//			for(int j = 1; j<setSize; j++){
		//				int pos = c+j;
		//				if (pos >= Borders.size()) { pos = Borders.size()-1; }
		//				if(current[1]==Borders.get(pos)[1] && Borders.get(pos)[0]<=current[0]+j){ right = true;}
		//				else { right = false;}
		//			}
		//				if (right) { getLeft(current, c, Borders); }
		//				if (left) { getTop(current, c, Borders); }
		//				if (top) { getBottom(current, c, Borders); }
		//				if (bottom) { 
		//					circles.add(current); 							//add this position as possible circle center
		//					right = false;left=false;top=false;bottom=false;
		//			} 
		//		}							
		//		return circles;
		//	}
		//
		//	public static void getLeft(int[] current, int c, LinkedList<int[]> Borders){
		//		for(int j = 1; j<setSize; j++){								
		//			int pos = c-j;
		//			if (pos<=0) { pos = 0;}	
		//			if(current[1]==Borders.get(pos)[1] && Borders.get(pos)[0]>=current[0]-j){ left = true;}
		//			else { left = false;}			
		//		}
		//	}
		//	public static void getTop(int[] current, int c, LinkedList<int[]> Borders){
		//		int counter=0;
		//		for(int j = 1; j<Borders.size(); j++){
		//			if(counter>0){System.out.println(counter+": "+ current[0]+ ","+current[1]);}
		//			int pos = c-j;
		//			if(current[1]-j<0) { break; }
		//			if (pos<0) { pos = 0;}
		//			if(current[0]==Borders.get(pos)[0] && ((current[1]-setSize-1<=Borders.get(pos)[1]))){counter++;}
		//			if(counter == setSize-1){
		//				top = true;break;
		//			}
		//			else { top = false;}			
		//		}
		//	}
		//	public static void getBottom(int[] current, int c, LinkedList<int[]> Borders){
		//
		//		int counter=0;
		//		for(int j = 1; j<Borders.size(); j++){								
		//			int pos = c+j;
		//			if(current[1]+j>= Borders.size()) { break; }
		//			if (pos>=Borders.size()) { pos = Borders.size()-1;}								
		//			if(current[0]==Borders.get(pos)[0] && ((current[1]+setSize-1)>=Borders.get(pos)[1])){counter++;}
		//			if(counter == setSize-1){
		//				bottom = true; break;
		//			}
		//			else { bottom = false;}			
		//		}
		//	}
		//}
	}
}