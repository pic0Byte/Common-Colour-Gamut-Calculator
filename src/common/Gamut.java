package common;

import org.eclipse.swt.SWT;


public class Gamut {
	
	public static final int EMPTY = -1;
	private static final int X = 0;
	private static final int Y = 1;
	private static final double FUDGE = 0.999;
	
	public int rX, rY, gX, gY, bX, bY, wX, wY, drawColour; 
	public double bgM, bgC, grM, grC, rbM, rbC;    //---------Coefficients (M) & constants (C) for slope equations------//
	public int rXN, rYN, gXN, gYN, bXN, bYN, wXN, wYN;     //---------Native values
	public int rXO, rYO, gXO, gYO, bXO, bYO, wXO, wYO;     //---------Offset between native & measured values
	
	
	public Gamut (int rX, int rY, int gX, int gY, int bX, int bY, int wX, int wY, int drawColour) {
		
		this.rX = rX;
		this.rY = rY;
		this.gX = gX;
		this.gY = gY;
		this.bX = bX;
		this.bY = bY;
		this.wX = wX;
		this.wY = wY;
		this.drawColour = drawColour;
		
		this.rXN = rX;
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
		this.wYO = wYN - wY;
		
		
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
		
		this.rXO = this.rXN - this.rX;
		this.rYO = this.rYN - this.rY;
		this.gXO = this.gXN - this.gX;
		this.gYO = this.gYN - this.gY;
		this.bXO = this.bXN - this.bX;
		this.bYO = this.bYN - this.bY;
		this.wXO = this.wXN - this.wX;
		this.wYO = this.wYN - this.wY;
		
	}
	
	
	public static Gamut getCommonArea(Gamut gam1, Gamut gam2) {
		
		Gamut common = new Gamut(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, 313, 329, SWT.COLOR_WHITE);
		
		//------------------Array of 15 candidate x,y points for the 3 common area triangle corners---------------------//
		//                [0]=BG1/BG2, [1]=BG1/GR2, [2]=BG1/RB2, [3]=GR1/BG2, [4]=GR1/GR2, [5]=GR1/RB2,                 //
		//           [6]=RB1/BG2, [7]=RB1/GR2, [8]=RB1/RB2, [9]=R1, [10]=G1, [11]=B1, [12]=R2, [13]=G2, [14]=B2         //
		//--------------------------------------------------------------------------------------------------------------//
		
		double[][] commonPoints = new double[15][2];
		
		gam1.slope();
		gam2.slope();
		
		getCommonPoints(gam1, gam2, commonPoints);
		solveRed (commonPoints, common, gam1, gam2);
		
		getCommonPoints(gam1, gam2, commonPoints);
		solveGreen (commonPoints, common, gam1, gam2);
		
		getCommonPoints(gam1, gam2, commonPoints);
		solveBlue (commonPoints, common, gam1, gam2);
		
	    
		return common;
		
	}
	
	
	private static void getCommonPoints(Gamut gam1, Gamut gam2, double[][] commonPoints) {
		
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

	
	private static void solveRed(double[][] commonPoints, Gamut common, Gamut gam1, Gamut gam2) {
		
		boolean redSolved = false;
		int highXIndex = highestX(commonPoints);
		double x = (commonPoints[highXIndex][X]);
		double y = (commonPoints[highXIndex][Y]);
		
		
		
		while (!redSolved) {
			
			
			double grX1 = (y - gam1.grC) / gam1.grM;
			double grX2 = (y - gam2.grC) / gam2.grM;
			double rbY1 = gam1.rbM * x + gam1.rbC;
			double rbX1 = (y - gam1.rbC) / gam1.rbM;
			double rbY2 = gam2.rbM * x + gam2.rbC;
			double rbX2 = (y - gam2.rbC) / gam2.rbM; 
			
			if ((gam1.rY > gam1.bY) && (gam2.rY > gam2.bY) //- RB1 & RB2 slopes are both positive
					&& (x * FUDGE <= grX1) && (x * FUDGE <= rbX1) && (x * FUDGE <= grX2) && (x * FUDGE <= rbX2)){
				
				redSolved = true;
				
			} else if ((gam1.rY < gam1.bY) && (gam2.rY > gam2.bY) //- RB1 slope is negative, RB2 is positive
					&& (x * FUDGE <= grX1) && (y / FUDGE >= rbY1) && (x * FUDGE <= grX2) && (x * FUDGE <= rbX2)){
				
				redSolved = true;	
				
			} else if ((gam1.rY > gam1.bY) && (gam2.rY < gam2.bY) //- RB1 slope is positive, RB2 is negative
					&& (x * FUDGE <= grX1) && (x * FUDGE <= rbX1) && (x * FUDGE <= grX2) && (y / FUDGE >= rbY2)){
				
				redSolved = true;	
				
			} else if ((gam1.rY < gam1.bY) && (gam2.rY < gam2.bY) //- RB1 & RB2 slopes are both negative
					&& (x * FUDGE <= grX1) && (y / FUDGE >= rbY1) && (x * FUDGE <= grX2) && (y / FUDGE >= rbY2)){
				
				redSolved = true;
				
			} else if ((gam1.rY == gam1.bY) && (gam2.rY > gam2.bY) //- RB1 slope is horizontal, RB2 is positive
					&& (x * FUDGE <= grX1) && (y / FUDGE >= gam1.rY) && (x * FUDGE <= grX2) && (x * FUDGE <= rbX2)){
				
				redSolved = true;
				
			} else if ((gam1.rY > gam1.bY) && (gam2.rY == gam2.bY) //- RB1 slope is positive, RB2 is horizontal
					&& (x * FUDGE <= grX1) && (x * FUDGE <= rbX1) && (x * FUDGE <= grX2) && (y / FUDGE >= gam2.rY)){
				
				redSolved = true;
				
			} else if ((gam1.rY == gam1.bY) && (gam2.rY < gam2.bY) //- RB1 slope is horizontal, RB2 is negative
					&& (x * FUDGE <= grX1) && (y / FUDGE >= gam1.rY) && (x * FUDGE <= grX2) && (y / FUDGE >= rbY2)){
				
				redSolved = true;
				
			} else if ((gam1.rY < gam1.bY) && (gam2.rY == gam2.bY) //- RB1 slope is negative, RB2 is horizontal
					&& (x * FUDGE <= grX1) && (y / FUDGE >= rbY1) && (x * FUDGE <= grX2) && (y / FUDGE >= gam2.rY)){
				
				redSolved = true;
				
			} else if ((gam1.rY == gam1.bY) && (gam2.rY == gam2.bY) //- RB1 & RB2 slopes are both horizontal
					&& (x * FUDGE <= grX1) && (y / FUDGE >= gam1.rX) && (x * FUDGE <= grX2) && (y / FUDGE >= gam2.rY)){
				
				redSolved = true;
			
			} else if (x == EMPTY){
				
				common.rX = 313;
				common.rY = 329;
				redSolved = true;
				
			} else {
				
				commonPoints[highXIndex][X] = EMPTY;
				commonPoints[highXIndex][Y] = EMPTY;
				highXIndex = highestX(commonPoints);
				x = commonPoints[highXIndex][X];
				y = commonPoints[highXIndex][Y];
				
			}
			
			if (redSolved) {
				
				common.rX = (int) x;
				common.rY = (int) y;
				
			}
		}
		
	}
	
	
	private static void solveGreen(double[][] commonPoints, Gamut common, Gamut gam1, Gamut gam2) {
		
		boolean greenSolved = false;
		int highYIndex = highestY(commonPoints);
		double x = (commonPoints[highYIndex][X]);
		double y = (commonPoints[highYIndex][Y]);
		
		while (!greenSolved) {
			
			double bgY1 = gam1.bgM * x + gam1.bgC;
			double bgX1 = (y - gam1.bgC) / gam1.bgM;
			double grY1 = gam1.grM * x + gam1.grC;
			double bgY2 = gam2.bgM * x + gam2.bgC;
			double bgX2 = (y - gam2.bgC) / gam2.bgM;
			double grY2 = gam2.grM * x + gam2.grC;
			
			
			if ((gam1.gX > gam1.bX) && (gam2.gX > gam2.bX)     //-Both bg slopes are positive
					&& (y * FUDGE <= bgY1) && (y * FUDGE <= grY1) && (y * FUDGE <= bgY2) && (y * FUDGE <= grY2)) {
				
				greenSolved = true;
			
			} else if ((gam1.gX < gam1.bX) && (gam2.gX > gam2.bX)  //-BG1 slope is negative
					&& ((x / FUDGE) >= bgX1) && (y * FUDGE <= grY1) && (y * FUDGE <= bgY2) && (y * FUDGE <= grY2)) {
				
				greenSolved = true;
				
			} else if ((gam1.gX > gam1.bX) && (gam2.gX < gam2.bX)  //-BG2 slope is negative
					&& (y * FUDGE <= bgY1) && (y * FUDGE <= grY1) && ((x / FUDGE) >= bgX2) && (y * FUDGE <= grY2)) {
				
				greenSolved = true;
				
			} else if ((gam1.gX < gam1.bX) && (gam2.gX < gam2.bX)  //-BG1 & BG2 slopes are both negative
					&& ((x / FUDGE) >= bgX1) && (y * FUDGE <= grY1) && ((x / FUDGE) >= bgX2) && (y * FUDGE <= grY2)) {
				
				greenSolved = true;
				
			} else if ((gam1.gX == gam1.bX) && (gam2.gX < gam2.bX)  //-BG1 is vertical & BG2 is negative
					&& ((x / FUDGE) > gam1.gX) && (y * FUDGE <= grY1) && ((x / FUDGE) >= bgX2) && (y * FUDGE <= grY2)) {
				
				greenSolved = true; 
				
			} else if ((gam1.gX == gam1.bX) && (gam2.gX > gam2.bX)  //-BG1 is vertical & BG2 is positive
					&& ((x / FUDGE) > gam1.gX) && (y * FUDGE <= grY1) && (y * FUDGE <= bgY2) && (y * FUDGE <= grY2)) {
				
				greenSolved = true;
				
			} else if ((gam1.gX > gam1.bX) && (gam2.gX == gam2.bX)  //-BG1 is positive & BG2 is vertical
					&& (y * FUDGE <= bgY1) && (y * FUDGE <= grY1) && (x / FUDGE > gam2.gX) && (y * FUDGE <= grY2)) {
				
				greenSolved = true;
				
			} else if ((gam1.gX < gam1.bX) && (gam2.gX == gam2.bX)  //-BG1 is negative & BG2 is vertical
					&& ((x / FUDGE) >= bgX1) && (y * FUDGE <= grY1) && (x / FUDGE > gam2.gX) && (y * FUDGE <= grY2)) {
				
				greenSolved = true;
				
			} else if ((gam1.gX == gam1.bX) && (gam2.gX == gam2.bX)  //-BG1 & BG2 are vertical
					&& ((x / FUDGE) > gam1.gX) && (y * FUDGE <= grY1) && (x / FUDGE > gam2.gX) && (y * FUDGE <= grY2)) {
						
				greenSolved = true;
				
			} else if (x == EMPTY){
				 
				common.gX = 313;
				common.gY = 329;
				greenSolved = true;
				
			} else {
				
				commonPoints[highYIndex][X] = EMPTY;
				commonPoints[highYIndex][Y] = EMPTY;
				
				highYIndex = highestY(commonPoints);
				x = (commonPoints[highYIndex][X]);
				y = (commonPoints[highYIndex][Y]);

			} 
			
			if (greenSolved) {
				
				common.gX = (int) x;
				common.gY = (int) y;
			}
				
		}
		
	}
	
	
	private static void solveBlue(double[][] commonPoints, Gamut common, Gamut gam1, Gamut gam2) {
		
		boolean blueSolved = false;
		int lowXYIndex = lowestXY(commonPoints);
		double x = commonPoints[lowXYIndex][X];
		double y = commonPoints[lowXYIndex][Y];
		
		while (!blueSolved) {
			
			double bgY1 = gam1.bgM * x + gam1.bgC;
			double rbY1 = gam1.rbM * x + gam1.rbC;
			double bgY2 = gam2.bgM * x + gam2.bgC;
			double rbY2 = gam2.rbM * x + gam2.rbC;
			
			
			if ((gam1.gX > gam1.bX) && (gam2.gX > gam2.bX) // Both BG slopes are positive
					&& (y * FUDGE <= bgY1) && (y / FUDGE >= rbY1) && (y * FUDGE <= bgY2) && (y / FUDGE >= rbY2)) {
				
				blueSolved = true;
				
			} else if ((gam1.gX < gam1.bX) && (gam2.gX > gam2.bX) // BG1 slope is negative, BG2 is positive
					&& (y / FUDGE >= bgY1) && (y / FUDGE >= rbY1) && (y * FUDGE <= bgY2) && (y / FUDGE >= rbY2)) {
				
				blueSolved = true;
				
			} else if ((gam1.gX > gam1.bX) && (gam2.gX < gam2.bX) // BG1 slope is positive, BG2 is negative
					&& (y * FUDGE <= bgY1) && (y / FUDGE >= rbY1) && (y / FUDGE >= bgY2) && (y / FUDGE >= rbY2)) {
				
				blueSolved = true;
				
			} else if ((gam1.gX < gam1.bX) && (gam2.gX < gam2.bX) // BG1 & BG2 slopes are both negative
					&& (y / FUDGE >= bgY1) && (y / FUDGE >= rbY1) && (y / FUDGE >= bgY2) && (y / FUDGE >= rbY2)) {
				
				blueSolved = true;
				
			} else if ((gam1.gX == gam1.bX) && (gam2.gX > gam2.bX) // BG1 slope is vertical, BG2 is positive
					&& (x / FUDGE >= gam1.bX ) && (y / FUDGE >= rbY1) && (y * FUDGE <= bgY2) && (y / FUDGE >= rbY2)) {
				
				blueSolved = true;
				
			} else if ((gam1.gX == gam1.bX) && (gam2.gX < gam2.bX) // BG1 slope is vertical, BG2 is negative
					&& (x / FUDGE >= gam1.bX ) && (y / FUDGE >= rbY1) && (y / FUDGE >= bgY2) && (y / FUDGE >= rbY2)) {
				
				blueSolved = true;
				
			} else if ((gam1.gX > gam1.bX) && (gam2.gX == gam2.bX) // BG1 slope is positive, BG2 is vertical
					&& (y * FUDGE <= bgY1) && (y / FUDGE >= rbY1) && (x / FUDGE >= gam2.bX) && (y / FUDGE >= rbY2)) {
				
				blueSolved = true;
				
			} else if ((gam1.gX < gam1.bX) && (gam2.gX == gam2.bX) // BG1 slope is negative, BG2 is vertical
					&& (y / FUDGE >= bgY1) && (y / FUDGE >= rbY1) && (x / FUDGE >= gam2.bX) && (y / FUDGE >= rbY2)) {
				
				blueSolved = true;
				
			} else if ((gam1.gX == gam1.bX) && (gam2.gX == gam2.bX) // BG1 & BG2 slopes are both vertical
					&& (x / FUDGE >= gam1.bX) && (y / FUDGE >= rbY1) && (x / FUDGE >= gam2.bX) && (y / FUDGE >= rbY2)) {
				
				blueSolved = true;
				
			} else if (x == 1000){
				
				common.bX = 313;
				common.bY = 329;
				blueSolved = true;
				
			} else {
				
				commonPoints[lowXYIndex][X] = 1000;
				commonPoints[lowXYIndex][Y] = 1000;
				lowXYIndex = lowestXY(commonPoints);
				x = (commonPoints[lowXYIndex][X]);
				y = (commonPoints[lowXYIndex][Y]);
				
			}
			
			if (blueSolved) {
				
				common.bX = (int) x;
				common.bY = (int) y;

			}
		}
		
	}

	
	private static int highestX(double[][] commonPoints) {
		
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
	
	
	private static int highestY(double[][] commonPoints) {
		
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
	
	
	private static int lowestXY(double[][] commonPoints) {
		
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
