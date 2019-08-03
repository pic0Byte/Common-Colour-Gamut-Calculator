package common;

import org.eclipse.swt.SWT;
import views.MainWindow;

public class Gamut {
	
	public static final int EMPTY = -1;
	private static final int X = 0;
	private static final int Y = 1;
	private static final double FUDGE = 0.99;
	
	public int rX, rY, gX, gY, bX, bY, drawColour; 
	public double bgM, bgC, grM, grC, rbM, rbC;    //---------Coefficients (M) & constants (C) for slope equations------//
	
	
	public Gamut (int rx, int ry, int gx, int gy, int bx, int by, int dC) {
		
		rX = rx;
		rY = ry;
		gX = gx;
		gY = gy;
		bX = bx;
		bY = by;
		drawColour = dC;
		
	}
	
	
	public static void slope(Gamut gam) {
		
		gam.bgM = (double)(gam.bY - gam.gY) / (gam.bX - gam.gX);
		gam.bgC = (double)gam.bY - (gam.bgM * gam.bX);
		gam.grM = (double)(gam.gY - gam.rY) / (gam.gX - gam.rX);
		gam.grC = (double)gam.gY - (gam.grM * gam.gX);
		gam.rbM = (double)(gam.rY - gam.bY) / (gam.rX - gam.bX);
		gam.rbC = (double)gam.rY - (gam.rbM * gam.rX);
		
	}
	
	
	public static Gamut getCommonArea(Gamut gam1, Gamut gam2) {
		
		Gamut common = new Gamut(EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, SWT.COLOR_WHITE);
		
		//------------------Array of 15 candidate x,y points for the 3 common area triangle corners---------------------//
		//                [0]=BG1/BG2, [1]=BG1/GR2, [2]=BG1/RB2, [3]=GR1/BG2, [4]=GR1/GR2, [5]=GR1/RB2,                 //
		//           [6]=RB1/BG2, [7]=RB1/GR2, [8]=RB1/RB2, [9]=R1, [10]=G1, [11]=B1, [12]=R2, [13]=G2, [14]=B2         //
		//--------------------------------------------------------------------------------------------------------------//
		
		double[][] commonPoints = new double[15][2];
		
		slope(gam1);
		slope(gam2);
		getCommonPoints(gam1, gam2, commonPoints);
		
		MainWindow.lblBg1Bg2X.setText(Double.toString(commonPoints[0][X]));
		MainWindow.lblBg1Gr2X.setText(Double.toString(commonPoints[1][X]));
		MainWindow.lblBg1Rb2X.setText(Double.toString(commonPoints[2][X]));
		MainWindow.lblGr1Bg2X.setText(Double.toString(commonPoints[3][X]));
		MainWindow.lblGr1Gr2X.setText(Double.toString(commonPoints[4][X]));
		MainWindow.lblGr1Rb2X.setText(Double.toString(commonPoints[5][X]));
		MainWindow.lblRb1Bg2X.setText(Double.toString(commonPoints[6][X]));
		MainWindow.lblRb1Gr2X.setText(Double.toString(commonPoints[7][X]));
		MainWindow.lblRb1Rb2X.setText(Double.toString(commonPoints[8][X]));
		MainWindow.lblR1x.setText(Double.toString(commonPoints[9][X]));
		MainWindow.lblG1x.setText(Double.toString(commonPoints[10][X]));
		MainWindow.lblB1x.setText(Double.toString(commonPoints[11][X]));
		MainWindow.lblR2x.setText(Double.toString(commonPoints[12][X]));
		MainWindow.lblG2x.setText(Double.toString(commonPoints[13][X]));
		MainWindow.lblB2x.setText(Double.toString(commonPoints[14][X]));
		
		MainWindow.lblBg1Bg2Y.setText(Double.toString(commonPoints[0][Y]));
		MainWindow.lblBg1Gr2Y.setText(Double.toString(commonPoints[1][Y]));
		MainWindow.lblBg1Rb2Y.setText(Double.toString(commonPoints[2][Y]));
		MainWindow.lblGr1Bg2Y.setText(Double.toString(commonPoints[3][Y]));
		MainWindow.lblGr1Gr2Y.setText(Double.toString(commonPoints[4][Y]));
		MainWindow.lblGr1Rb2Y.setText(Double.toString(commonPoints[5][Y]));
		MainWindow.lblRb1Bg2Y.setText(Double.toString(commonPoints[6][Y]));
		MainWindow.lblRb1Gr2Y.setText(Double.toString(commonPoints[7][Y]));
		MainWindow.lblRb1Rb2Y.setText(Double.toString(commonPoints[8][Y]));
		MainWindow.lblR1y.setText(Double.toString(commonPoints[9][Y]));
		MainWindow.lblG1y.setText(Double.toString(commonPoints[10][Y]));
		MainWindow.lblB1y.setText(Double.toString(commonPoints[11][Y]));
		MainWindow.lblR2y.setText(Double.toString(commonPoints[12][Y]));
		MainWindow.lblG2y.setText(Double.toString(commonPoints[13][Y]));
		MainWindow.lblB2y.setText(Double.toString(commonPoints[14][Y]));
		
		
		solveRed (commonPoints, common, gam1, gam2);
		solveGreen (commonPoints, common, gam1, gam2);
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
			if (!Double.isFinite(commonPoints[i][X])){
				commonPoints[i][X] = 19;
			}
			if (!Double.isFinite(commonPoints[i][Y])){
				commonPoints[i][Y] = 11;
			}
		}
		
	}

	
	private static void solveGreen(double[][] commonPoints, Gamut common, Gamut gam1, Gamut gam2) {
		
		boolean greenSolved = false;
		double discardedYValue = 1000;
		int highYIndex = highestY(commonPoints, discardedYValue);
		double x = (commonPoints[highYIndex][X]);
		double y = (commonPoints[highYIndex][Y]) * FUDGE;
		
		while (!greenSolved) {
			
			/*double bg1 = gam1.bgM * x + gam1.bgC;
			bg1 = checkFinite(bg1, commonPoints[highYIndex][Y]);
			double gr1 = gam1.grM * x + gam1.grM;
			gr1 = checkFinite(gr1, commonPoints[highYIndex][Y]);
			double bg2 = gam2.bgM * x + gam2.bgC;
			bg2 = checkFinite(bg2, commonPoints[highYIndex][Y]);
			double gr2 = gam2.grM * x + gam2.grC;
			gr2 = checkFinite(gr2, commonPoints[highYIndex][Y]);
			*/
			
			System.out.println();
			System.out.println(gam1.bgM * x + gam1.bgC + " is >= to " + y);
			System.out.println(gam1.grM * x + gam1.grC + " is >= to " + y);
			System.out.println(gam2.bgM * x + gam2.bgC + " is >= to " + y);
			System.out.println(gam2.grM * x + gam2.grC + " is >= to " + y);
			
			if ((y <= gam1.bgM * x + gam1.bgC) && (y <= gam1.grM * x + gam1.grC) 
					&& (y <= gam2.bgM * x + gam2.bgC) && (y <= gam2.grM * x + gam2.grC)) {
				
				common.gX = (int) x;
				common.gY = (int) commonPoints[highYIndex][Y];
				greenSolved = true;
			
			} else {
				discardedYValue = commonPoints[highYIndex][Y];
				highYIndex = highestY(commonPoints, discardedYValue);
				x = (commonPoints[highYIndex][X]);
				y = (commonPoints[highYIndex][Y]) * FUDGE;
				System.out.println("Discarded Y " + discardedYValue);
				System.out.println();
			}
		}
		
	}
	
	
	private static void solveRed(double[][] commonPoints, Gamut common, Gamut gam1, Gamut gam2) {
		
		boolean redSolved = false;
		double discardedXValue = 1000;
		int highXIndex = highestX(commonPoints, discardedXValue);
		double x = (commonPoints[highXIndex][X]) * FUDGE;
		double y = (commonPoints[highXIndex][Y]);
		
		while (!redSolved) {
			
			System.out.println();
			System.out.println(x + " is <= to " + (y - gam1.grC) / gam1.grM);
			System.out.println(x + " is <= to " + (y - gam1.rbC) / gam1.rbM);
			System.out.println(x + " is <= to " + (y - gam2.grC) / gam2.grM);
			System.out.println(x + " is <= to " + (y - gam2.rbC) / gam2.rbM);
			
			if ((x <= (y - gam1.grC) / gam1.grM) && (x <= (y - gam1.rbC) / gam1.rbM) && 
					(x <= (y - gam2.grC) / gam2.grM) && (x <= (y - gam2.rbC) / gam2.rbM)){
				
				common.rX = (int) commonPoints[highXIndex][X];
				common.rY = (int) y;
				redSolved = true;
			
			} else {
				discardedXValue = commonPoints[highXIndex][X];
				highXIndex = highestX(commonPoints, discardedXValue);
				x = (commonPoints[highXIndex][X]) * FUDGE;
				y = (commonPoints[highXIndex][Y]);
				System.out.println("Discarded X " + discardedXValue);
				System.out.println();
			}
		}
		
	}
	
	
	private static void solveBlue(double[][] commonPoints, Gamut common, Gamut gam1, Gamut gam2) {
		
		boolean blueSolved = false;
		double discardedXValue = 0;
		int lowXIndex = lowestX(commonPoints, discardedXValue);
		double x = commonPoints[lowXIndex][X];
		double y = commonPoints[lowXIndex][Y];
		
		
		while (!blueSolved) {
			
			System.out.println();
			System.out.println(x + " is >= to " + (y - gam1.bgC) / gam1.bgM);
			System.out.println(y + " is >= to " + (gam1.rbM * x + gam1.rbC));
			System.out.println(x + " is >= to " + (y - gam2.bgC) / gam2.bgM);
			System.out.println(y + " is >= to " + (gam2.rbM * x + gam2.rbC));
			
			if ((x / FUDGE >= (y - gam1.bgC) / gam1.bgM) && (y / FUDGE >= gam1.rbM * x + gam1.rbC) 
					&& (x / FUDGE >= (y - gam2.bgC) / gam2.bgM) && (y / FUDGE >= gam2.rbM * x + gam2.rbC)){
				
				common.bX = (int) commonPoints[lowXIndex][X];
				common.bY = (int) commonPoints[lowXIndex][Y];
				blueSolved = true;
			
			} else {
				discardedXValue = commonPoints[lowXIndex][X];
				lowXIndex = lowestX(commonPoints, discardedXValue);
				x = (commonPoints[lowXIndex][X]);
				y = (commonPoints[lowXIndex][Y]);
				System.out.println("Discarded blue X = " + discardedXValue);
				System.out.println();
			}
		}
		
	}

	private static int highestX(double[][] commonPoints, double discardedXValue) {
		
		double highestSeen = 0;
		int highestIndex = 0;
		
		for (int i=0; i<15; i++) {
			if ((commonPoints[i][X] > highestSeen) && (commonPoints[i][X] < discardedXValue)) {
				highestIndex = i;
				highestSeen = commonPoints[i][X];
			}
		}
		
		return highestIndex;
	}
	
	
	private static int lowestX(double[][] commonPoints, double discardedXValue) {
		
		double lowestSeen = 1000;
		int lowestIndex = 0;
		
		for (int i=0; i<15; i++) {
			if ((commonPoints[i][X] < lowestSeen) && (commonPoints[i][X] > discardedXValue)) {
				lowestIndex = i;
				lowestSeen = commonPoints[i][X];
			}
		}
		
		return lowestIndex;
	}
	
	
	private static int highestY(double[][] commonPoints, double discardedYValue) {
		
		double highestSeen = 0;
		int highestIndex = 0;
		
		for (int i=0; i<15; i++) {
			if ((commonPoints[i][Y] > highestSeen) && (commonPoints[i][Y] < discardedYValue)) {
				highestIndex = i;
				highestSeen = commonPoints[i][Y];
			}
		}
		
		return highestIndex;
	}
	
	private static double checkFinite (double in, double sub) {
			
		if (!Double.isFinite(in)) {
			in = sub;
		}
		
		return in;
	}
	

} //---End of class
