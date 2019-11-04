package common;

import org.eclipse.swt.SWT;


public class Gamut {
	
	public static final int EMPTY = -1;
	private static final int X = 0;
	private static final int Y = 1;
	private static final double FUDGE = 0.999;
		
	public int rX, rY, gX, gY, bX, bY, wX, wY, drawColour; 
	public double bgM, bgC, grM, grC, rbM, rbC;    //---------Coefficients (M) & constants (C) for slope equations------//
	//public int rXN, rYN, gXN, gYN, bXN, bYN, wXN, wYN;     //---------Native values
	public int rXO, rYO, gXO, gYO, bXO, bYO, wXO, wYO;     //---------Offset between native & measured values
	public boolean nativeLinked;
	
	public Gamut nat;
	
	//------------------Array of 15 candidate x,y points for the 3 common area triangle corners---------------------//
	//                [0]=BG1/BG2, [1]=BG1/GR2, [2]=BG1/RB2, [3]=GR1/BG2, [4]=GR1/GR2, [5]=GR1/RB2,                 //
	//           [6]=RB1/BG2, [7]=RB1/GR2, [8]=RB1/RB2, [9]=R1, [10]=G1, [11]=B1, [12]=R2, [13]=G2, [14]=B2         //
	//--------------------------------------------------------------------------------------------------------------//

	private static double[][] commonPoints = new double[15][2];

	
	public Gamut (int rX, int rY, int gX, int gY, int bX, int bY, int wX, int wY, int drawColour) {
		
		this.nativeLinked = true;
		
		this.rX = rX;
		this.rY = rY;
		this.gX = gX;
		this.gY = gY;
		this.bX = bX;
		this.bY = bY;
		this.wX = wX;
		this.wY = wY;
		this.drawColour = drawColour;
		
		/*this.rXN = rX;
		this.rYN = rY;
		this.gXN = gX;
		this.gYN = gY;
		this.bXN = bX;
		this.bYN = bY;
		this.wXN = wX;
		this.wYN = wY;
		
		this.rXO = rXN - rX;
		this.rYO = rYN - rY;
		this.gXO = gXN - gX;
		this.gYO = gYN - gY;
		this.bXO = bXN - bX;
		this.bYO = bYN - bY;
		this.wXO = wXN - wX;
		this.wYO = wYN - wY;*/
		
		this.nat = new Gamut(this);
		
	}
	
	
	private Gamut(Gamut gam) {
		
		this.rX = gam.rX;
		this.rY = gam.rY;
		this.gX = gam.gX;
		this.gY = gam.gY;
		this.bX = gam.bX;
		this.bY = gam.bY;
		this.wX = gam.wX;
		this.wY = gam.wY;
		
		this.drawColour = 2;
		
	}
	
	
	public void slope() {
		
		if (this.gX == this.bX) {
			this.bgM = (double)(this.bY - this.gY) / (this.bX - this.gX - 0.00001);
			this.bgC = (double)this.bY - (this.bgM * this.bX);
		} else {
			this.bgM = (double)(this.bY - this.gY) / (this.bX - this.gX);
			this.bgC = (double)this.bY - (this.bgM * this.bX);
		}
		
		this.grM = (double)(this.gY - this.rY) / (this.gX - this.rX);
		this.grC = (double)this.gY - (this.grM * this.gX);
		this.rbM = (double)(this.rY - this.bY) / (this.rX - this.bX);
		this.rbC = (double)this.rY - (this.rbM * this.rX);
		
	}
	
	
	public void updateOffsets() {
		
		this.rXO = this.nat.rX - this.rX;
		this.rYO = this.nat.rY - this.rY;
		this.gXO = this.nat.gX - this.gX;
		this.gYO = this.nat.gY - this.gY;
		this.bXO = this.nat.bX - this.bX;
		this.bYO = this.nat.bY - this.bY;
		this.wXO = this.nat.wX - this.wX;
		this.wYO = this.nat.wY - this.wY;
		
	}
	
	
	public static Gamut getCommonArea(Gamut gam1, Gamut gam2) {
		
		Gamut common = new Gamut(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, 313, 329, SWT.COLOR_WHITE);
		
		gam1.slope();
		gam2.slope();
		
		getCommonPoints(gam1, gam2);
		solveRed (gam1, gam2, common);
		
		getCommonPoints(gam1, gam2);
		solveGreen (gam1, gam2, common);
		
		getCommonPoints(gam1, gam2);
		solveBlue (gam1, gam2, common);
		
	    
		return common;
		
	}
	
	
	private static void getCommonPoints(Gamut gam1, Gamut gam2) {
		
		commonPoints[0][X] = ((gam2.bgC - gam1.bgC) / (gam1.bgM - gam2.bgM));
		commonPoints[0][Y] = ((gam1.bgM * commonPoints[0][X]) + gam1.bgC);
		
		commonPoints[1][X] = ((gam2.grC - gam1.bgC) / (gam1.bgM - gam2.grM));
		commonPoints[1][Y] = ((gam1.bgM * commonPoints[1][X]) + gam1.bgC);
		
		commonPoints[2][X] = ((gam2.rbC - gam1.bgC) / (gam1.bgM - gam2.rbM));
		commonPoints[2][Y] = ((gam1.bgM * commonPoints[2][X]) + gam1.bgC);
		
		commonPoints[3][X] = ((gam2.bgC - gam1.grC) / (gam1.grM - gam2.bgM));
		commonPoints[3][Y] = ((gam1.grM * commonPoints[3][X]) + gam1.grC);
				
		commonPoints[4][X] = ((gam2.grC - gam1.grC) / (gam1.grM - gam2.grM));
		commonPoints[4][Y] = ((gam1.grM * commonPoints[4][X]) + gam1.grC);
		
		commonPoints[5][X] = ((gam2.rbC - gam1.grC) / (gam1.grM - gam2.rbM));
		commonPoints[5][Y] = ((gam1.grM * commonPoints[5][X]) + gam1.grC);
		
		commonPoints[6][X] = ((gam2.bgC - gam1.rbC) / (gam1.rbM - gam2.bgM));
		commonPoints[6][Y] = ((gam1.rbM * commonPoints[6][X]) + gam1.rbC);
		
		commonPoints[7][X] = ((gam2.grC - gam1.rbC) / (gam1.rbM - gam2.grM));
		commonPoints[7][Y] = ((gam1.rbM * commonPoints[7][X]) + gam1.rbC);
		
		commonPoints[8][X] = ((gam2.rbC - gam1.rbC) / (gam1.rbM - gam2.rbM));
		commonPoints[8][Y] = ((gam1.rbM * commonPoints[8][X]) + gam1.rbC);
		
		commonPoints[9][X] = gam1.rX;
		commonPoints[9][Y] = gam1.rY;
		
		commonPoints[10][X] = gam1.gX;
		commonPoints[10][Y] = gam1.gY;
		
		commonPoints[11][X] = gam1.bX;
		commonPoints[11][Y] = gam1.bY;
		
		commonPoints[12][X] = gam2.rX;
		commonPoints[12][Y] = gam2.rY;
		
		commonPoints[13][X] = gam2.gX;
		commonPoints[13][Y] = gam2.gY;
		
		commonPoints[14][X] = gam2.bX;
		commonPoints[14][Y] = gam2.bY;
		
		for (int i = 0; i < 15; i++) {
			if (!Double.isFinite(commonPoints[i][X])) {
				commonPoints[i][X] = 1;
			}
			if (!Double.isFinite(commonPoints[i][Y])) {
				commonPoints[i][Y] = 1;
			}
			
		}
		
	}

	
	private static void solveRed(Gamut gam1, Gamut gam2, Gamut common) {
		
		boolean redSolved = false;
		int highXIndex = highestX();
		double x = (commonPoints[highXIndex][X]);
		double y = (commonPoints[highXIndex][Y]);
		
		while (!redSolved) {
			if (isEnclosedByRed(x, y, gam1) && isEnclosedByRed(x, y, gam2)){
				
				redSolved = true;
				
			} else if (x == EMPTY){
				
				common.rX = 313;
				common.rY = 329;
				redSolved = true;
				
			} else {
				
				commonPoints[highXIndex][X] = EMPTY;
				commonPoints[highXIndex][Y] = EMPTY;
				highXIndex = highestX();
				x = commonPoints[highXIndex][X];
				y = commonPoints[highXIndex][Y];
				
			}
			
			if (redSolved) {
				
				common.rX = (int) x;
				common.rY = (int) y;
				
			}
		}		
	}
		
	
	private static void solveGreen(Gamut gam1, Gamut gam2, Gamut common) {
		
		boolean greenSolved = false;
		int highYIndex = highestY();
		double x = (commonPoints[highYIndex][X]);
		double y = (commonPoints[highYIndex][Y]);
		
		while (!greenSolved) {
			
			if (isEnclosedByGreen(x, y, gam1) && isEnclosedByGreen(x, y, gam2)) {
				
				greenSolved = true;
				
			} else if (x == EMPTY){
				 
				common.gX = 313;
				common.gY = 329;
				greenSolved = true;
				
			} else {
				
				commonPoints[highYIndex][X] = EMPTY;
				commonPoints[highYIndex][Y] = EMPTY;
				
				highYIndex = highestY();
				x = (commonPoints[highYIndex][X]);
				y = (commonPoints[highYIndex][Y]);

			} 
			
			if (greenSolved) {
				
				common.gX = (int) x;
				common.gY = (int) y;
			}
		}

	}
	
	
	private static void solveBlue(Gamut gam1, Gamut gam2, Gamut common) {
		
		boolean blueSolved = false;
		int lowXYIndex = lowestXY();
		double x = commonPoints[lowXYIndex][X];
		double y = commonPoints[lowXYIndex][Y];
		
		while (!blueSolved) {
			
			if (isEnclosedByBlue(x, y, gam1) && isEnclosedByBlue(x, y, gam2)) {
				
				blueSolved = true;
				
			} else if (x == 1000){
				
				common.bX = 313;
				common.bY = 329;
				blueSolved = true;
				
			} else {
				
				commonPoints[lowXYIndex][X] = 1000;
				commonPoints[lowXYIndex][Y] = 1000;
				lowXYIndex = lowestXY();
				x = (commonPoints[lowXYIndex][X]);
				y = (commonPoints[lowXYIndex][Y]);
				
			}
			
			if (blueSolved) {
				
				common.bX = (int) x;
				common.bY = (int) y;

			}
			
		}
	}
	
	
	public static boolean isEnclosedByRed(double x, double y, Gamut gam) {
		
		boolean enclosed = false;
		
		double grX = (y - gam.grC) / gam.grM;
		double rbY = gam.rbM * x + gam.rbC;
		double rbX = (y - gam.rbC) / gam.rbM;
		
		if ((gam.rY > gam.bY) //- RB slope is positive
				&& (x * FUDGE <= grX) && (x * FUDGE <= rbX)){
			
			enclosed = true;
			
		} else if ((gam.rY < gam.bY) //- RB slope is negative
				&& (x * FUDGE <= grX) && (y / FUDGE >= rbY)){

			enclosed = true;
			
		} else if ((gam.rY == gam.bY) //- RB slope is horizontal
				&& (x * FUDGE <= grX) && (y / FUDGE >= gam.rY)){
			
			enclosed = true;
			
		}
		return enclosed;
		
	}
	
	
	public static boolean isEnclosedByGreen(double x, double y, Gamut gam) {
		
		boolean enclosed = false;
		double bgY = gam.bgM * x + gam.bgC;
		double bgX = (y - gam.bgC) / gam.bgM;
		double grY = gam.grM * x + gam.grC;

		if ((gam.gX > gam.bX)  //-BG slope is positive
				&& (y * FUDGE <= bgY) && (y * FUDGE <= grY)) {
			
			enclosed = true;
		
		} else if ((gam.gX < gam.bX) //-BG slope is negative
				&& ((x / FUDGE) >= bgX) && (y * FUDGE <= grY)) {
			
			enclosed = true;
			
		} else if ((gam.gX == gam.bX) //-BG slope is vertical
				&& ((x / FUDGE) > gam.gX) && (y * FUDGE <= grY)) {
			
			enclosed = true;
			
		}
		
		return enclosed;
	}
	
	
	public static boolean isEnclosedByBlue(double x, double y, Gamut gam) {
		
		boolean enclosed = false;
		double bgY = gam.bgM * x + gam.bgC;
		double rbY = gam.rbM * x + gam.rbC;
		
		
		if ((gam.gX > gam.bX)  // BG slope is positive
				&& (y * FUDGE <= bgY) && (y / FUDGE >= rbY)) {
			
			enclosed = true;
			
		} else if ((gam.gX < gam.bX)  // BG slope is negative
				&& (y / FUDGE >= bgY) && (y / FUDGE >= rbY)) {
			
			enclosed = true;
			
		} else if ((gam.gX == gam.bX)  // BG slope is vertical
				&& (x / FUDGE >= gam.bX) && (y / FUDGE >= rbY)) {
			
			enclosed = true;
			
		}
		
		return enclosed;
	}
	
	
	private static int highestX() {
		
		double highestSeen = 0;
		int highestIndex = 0;
		
		for (int i=0; i<15; i++) {
			if ((commonPoints[i][X] > highestSeen)) {
				highestIndex = i;
				highestSeen = commonPoints[i][X];
			}
		}
		
		return highestIndex;
	}
	
	
	private static int highestY() {
		
		double highestSeen = 0;
		int highestIndex = 0;
		
		for (int i=0; i<15; i++) {
			if ((commonPoints[i][Y] > highestSeen)) {
				highestIndex = i;
				highestSeen = commonPoints[i][Y];
			}
		}
		
		return highestIndex;
	}
	
	
	private static int lowestXY() {
		
		double lowestSeen = 1000;
		int lowestIndex = 0;
		
		for (int i=0; i<15; i++) {
			
			double total = commonPoints[i][X] + commonPoints[i][Y];
			
			if (total < lowestSeen) {
				lowestSeen = total;
				lowestIndex = i;
			}
		}
		
		return lowestIndex;
	}
	

} //---End of class
