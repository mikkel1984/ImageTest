import java.util.LinkedList;


public class Borderlines {

	public static int borderLineRight(LinkedList<int[]> Borders){ 
		int Line=-1; //defining borders of track
		boolean LineBool = false;
		int i=0;
		while(!LineBool){	//go through until finding an x border
			if(Borders.get(i) != null){	//list null check			
				int[] temp1 = (int[]) Borders.get(i);
				for( int k = 1 ;k<10 ; k++){	//looking at 10 x locations next to each other
					
					if (Borders.get(i+k) != null){ //list null check
						int[] temp2 = (int[]) Borders.get(i+k);
						if ( temp1[0]!=temp2[0] && temp1[1]==temp2[1]){
							LineBool = true;
						}else { LineBool = false; }
					}else { LineBool = false; }
					if (k==9 && LineBool){
						Line = temp1[1];
					}
				}
				
			}
			i++;
		}
		if (Line != -1) { return Line;}
		else return -1;
	}
	public static int borderLineDown(LinkedList<int[]> Borders){ 
		
		//re structure so that use contains on the list instead, on all of these functions in this class
		
		
		int Line=-1; //defining borders of track
		boolean LineBool = false;
		int i=0;
		int hits=0;
		while(!LineBool){	//go through until finding an x border
			if(Borders.get(i) != null){	//list null check			
					int[] temp1 = (int[]) Borders.get(i);
				for( int k = 1 ;k<Borders.size()/2 ; k++){	//looking at 5 x locations next to each other
					if (Borders.get(i+k) != null){ //list null check
						int[] temp2 = (int[]) Borders.get(i+k);
						if ( temp1[0]==temp2[0] && temp1[1]!=temp2[1]){
							hits++;
							LineBool = true;
						}else { LineBool = false; }
					}else { LineBool = false; }
					if (k==9 && LineBool){
						Line = temp1[0];
					}
				}
				
			}
			i++;
		}
		if (Line != -1) { return Line;}
		else return -1;
	}
	public static int borderLineUp(LinkedList<int[]> Borders){ 
		int Line=-1; //defining borders of track
		boolean LineBool = false;
		int i=Borders.size()-1;
		while(!LineBool){	//go through until finding an x border
			if(Borders.get(i) != null){	//list null check			
					int[] temp1 = (int[]) Borders.get(i);
				for( int k = 1 ;k<10 ; k++){	//looking at 5 x locations next to each other
					
					if (Borders.get(i-k-MainClass.width) != null){ //list null check
						int[] temp2 = (int[]) Borders.get(i-k-MainClass.width);
						if ( temp1[0]==temp2[0] && temp1[1]!=temp2[1]){
							LineBool = true;
						}else { LineBool = false; }
					}else { LineBool = false; }
					if (k==4 && LineBool){
						Line = temp1[0];
					}
				}
				
			}
			i--;
		}
		if (Line != -1) { return Line;}
		else return -1;
	}
	public static int borderLineLeft(LinkedList<int[]> Borders){ 
		int Line=-1; //defining borders of track
		boolean LineBool = false;
		int i=Borders.size()-1;
		while(!LineBool){	//go through until finding an x border
			if(Borders.get(i) != null){	//list null check			
					int[] temp1 = (int[]) Borders.get(i);
				for( int k = 1 ;k<10 ; k++){	//looking at 5 x locations next to each other
					
					if (Borders.get(i-k) != null){ //list null check
						int[] temp2 = (int[]) Borders.get(i-k);
						if ( temp1[0]!=temp2[0] && temp1[1]==temp2[1]){
							LineBool = true;
						}else { LineBool = false; }
					}else { LineBool = false; }
					if (k==4 && LineBool){
						Line = temp1[1];
					}
				}
				
			}
			i--;
		}
		if (Line != -1) { return Line;}
		else return -1;
	}
}
