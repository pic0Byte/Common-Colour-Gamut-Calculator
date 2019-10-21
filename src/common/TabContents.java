package common;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;


public class TabContents {
	
	private static final int LBL_COLUMN1 = 18;
	private static final int LBL_COLUMN2 = 128;
	private static final int SPN_COLUMN1 = 79;
	private static final int ROW1 = 41;
	
	public Label lblRedXTVal, lblRedYTVal, lblGrnXTVal, lblGrnYTVal, lblBluXTVal, lblBluYTVal, lblWhtXTVal, lblWhtYTVal;
	public Spinner spnRX, spnRY, spnGX, spnGY, spnBX, spnBY, spnWX, spnWY;
	public Spinner spnRXN, spnRYN, spnGXN, spnGYN, spnBXN, spnBYN, spnWXN, spnWYN;
	
	public TabContents() {
		
	}
	
	public void layoutSpinners() {
		
		if (this.spnRX != null) {
			
			this.spnRX.setDigits(3);
			this.spnRX.setMaximum(750);
			this.spnRX.setMinimum(401);
			this.spnRX.setSelection(640);
			this.spnRX.setBounds(SPN_COLUMN1, ROW1, 56, 22);
		}
		
		if (this.spnRXN != null){
			
			this.spnRXN.setDigits(3);
			this.spnRXN.setMaximum(750);
			this.spnRXN.setMinimum(401);
			this.spnRXN.setSelection(640);
			this.spnRXN.setBounds(179, 41, 56, 22);
		}
		
		if (this.spnRY != null){
			
			this.spnRY.setDigits(3);
			this.spnRY.setMaximum(399);
			this.spnRY.setMinimum(211);
			this.spnRY.setSelection(330);
			this.spnRY.setBounds(SPN_COLUMN1, 66, 56, 22);
		}
		
		if (this.spnRYN != null) {
			
			this.spnRYN.setDigits(3);
			this.spnRYN.setMaximum(399);
			this.spnRYN.setMinimum(211);
			this.spnRYN.setSelection(330);
			this.spnRYN.setBounds(179, 66, 56, 22);
		}
		
		if (this.spnGX != null) {
			
			this.spnGX.setMaximum(399);
			this.spnGX.setMinimum(20);
			this.spnGX.setSelection(300);
			this.spnGX.setDigits(3);
			this.spnGX.setBounds(SPN_COLUMN1, 110, 56, 22);	
		}
		
		if (this.spnGXN != null) {
			
			this.spnGXN.setMaximum(399);
			this.spnGXN.setMinimum(20);
			this.spnGXN.setSelection(300);
			this.spnGXN.setDigits(3);
			this.spnGXN.setBounds(179, 110, 56, 22);	
		}
		
		if (this.spnGY != null) {
			
			this.spnGY.setDigits(3);
			this.spnGY.setMaximum(850);
			this.spnGY.setMinimum(401);
			this.spnGY.setSelection(600);
			this.spnGY.setBounds(SPN_COLUMN1, 135, 56, 22);	
		}
		
		if (this.spnGYN != null){
			
			this.spnGYN.setDigits(3);
			this.spnGYN.setMaximum(850);
			this.spnGYN.setMinimum(401);
			this.spnGYN.setSelection(600);
			this.spnGYN.setBounds(179, 135, 56, 22);
		}
		
		if (this.spnBX != null) {
			
			this.spnBX.setMaximum(299);
			this.spnBX.setMinimum(20);
			this.spnBX.setSelection(150);
			this.spnBX.setDigits(3);
			this.spnBX.setBounds(SPN_COLUMN1, 184, 56, 22);
		}
		
		if (this.spnBXN != null) {
			
			this.spnBXN.setMaximum(299);
			this.spnBXN.setMinimum(20);
			this.spnBXN.setSelection(150);
			this.spnBXN.setDigits(3);
			this.spnBXN.setBounds(179, 184, 56, 22);
		}
		
		if (this.spnBY != null) {
			
			this.spnBY.setMaximum(209);
			this.spnBY.setMinimum(20);
			this.spnBY.setSelection(60);
			this.spnBY.setDigits(3);
			this.spnBY.setBounds(79, 209, 56, 22);
		}
		
		if (this.spnBYN != null) {
			
			this.spnBYN.setMaximum(209);
			this.spnBYN.setMinimum(20);
			this.spnBYN.setSelection(60);
			this.spnBYN.setDigits(3);
			this.spnBYN.setBounds(179, 209, 56, 22);
		}
		
		if (this.spnWX != null) {
			
			this.spnWX.setMaximum(400);
			this.spnWX.setMinimum(250);
			this.spnWX.setSelection(313);
			this.spnWX.setDigits(3);
			this.spnWX.setBounds(79, 258, 56, 22);
		}
		
		if (this.spnWXN != null) {
			
			this.spnWXN.setMaximum(400);
			this.spnWXN.setMinimum(250);
			this.spnWXN.setSelection(313);
			this.spnWXN.setDigits(3);
			this.spnWXN.setBounds(179, 258, 56, 22);
		}
		
		if (this.spnWY != null) {
			
			this.spnWY.setMaximum(400);
			this.spnWY.setMinimum(250);
			this.spnWY.setSelection(329);
			this.spnWY.setDigits(3);
			this.spnWY.setBounds(79, 283, 56, 22);
		}
		
		if (this.spnWYN != null) {
			
			this.spnWYN.setMaximum(400);
			this.spnWYN.setMinimum(250);
			this.spnWYN.setSelection(329);
			this.spnWYN.setDigits(3);
			this.spnWYN.setBounds(179, 283, 56, 22);
		}
		
	}
	
	public void layoutFields(Composite cmpNewGamut) {
		
		this.lblRedXTVal = new Label(cmpNewGamut, SWT.BORDER);
		this.lblRedXTVal.setAlignment(SWT.LEFT);
		this.lblRedXTVal.setBounds(79, 358, 55, 15);
		
		if (this.lblRedYTVal != null) {
			lblRedYTVal.setAlignment(SWT.LEFT);
			lblRedYTVal.setBounds(79, 382, 55, 15);
		}
		
		if (this.lblGrnXTVal != null) {
			lblGrnXTVal.setAlignment(SWT.LEFT);
			lblGrnXTVal.setBounds(79, 426, 55, 15);
		}
		
		if (this.lblGrnYTVal != null) {
			lblGrnYTVal.setAlignment(SWT.LEFT);
			lblGrnYTVal.setBounds(79, 450, 55, 15);
		}
		
		if (this.lblBluXTVal != null) {
			lblBluXTVal.setAlignment(SWT.LEFT);
			lblBluXTVal.setBounds(185, 358, 55, 15);
		}
		
		if (this.lblBluYTVal != null) {
			lblBluYTVal.setAlignment(SWT.LEFT);
			lblBluYTVal.setBounds(185, 382, 55, 15);
		}
		
		if (this.lblWhtXTVal != null) {
			lblWhtXTVal.setAlignment(SWT.LEFT);
			lblWhtXTVal.setBounds(185, 426, 55, 15);
		}
		
		if (this.lblWhtYTVal != null) {
			lblWhtYTVal.setAlignment(SWT.LEFT);
			lblWhtYTVal.setBounds(185, 450, 55, 15);
		}
	}
	
	public void layoutLabels(Composite cmpNewGamut) {
		
		
		
		Label lblMeasured = new Label(cmpNewGamut, SWT.NONE);
		lblMeasured.setAlignment(SWT.LEFT);
		lblMeasured.setBounds(80, 19, 55, 15);
		lblMeasured.setText("Measured");

		Label lblNative = new Label(cmpNewGamut, SWT.NONE);
		lblNative.setAlignment(SWT.LEFT);
		lblNative.setBounds(180, 19, 55, 15);
		lblNative.setText("Native");

		Label lblDesVal = new Label(cmpNewGamut, SWT.NONE);
		lblDesVal.setAlignment(SWT.LEFT);
		lblDesVal.setBounds(80, 334, 170, 15);
		lblDesVal.setText("Target Values (offsets)");
		
		Label lblRedX = new Label(cmpNewGamut, SWT.NONE);
		lblRedX.setAlignment(SWT.RIGHT);
		lblRedX.setBounds(LBL_COLUMN1, 43, 55, 15);
		lblRedX.setText("Red X");

		Label lblRedXT = new Label(cmpNewGamut, SWT.NONE);
		lblRedXT.setAlignment(SWT.RIGHT);
		lblRedXT.setBounds(LBL_COLUMN1, 358, 55, 15);
		lblRedXT.setText("Red X");

		Label lblRedY = new Label(cmpNewGamut, SWT.NONE);
		lblRedY.setText("Red Y");
		lblRedY.setAlignment(SWT.RIGHT);
		lblRedY.setBounds(LBL_COLUMN1, 68, 55, 15);

		Label lblRedYT = new Label(cmpNewGamut, SWT.NONE);
		lblRedYT.setText("Red Y");
		lblRedYT.setAlignment(SWT.RIGHT);
		lblRedYT.setBounds(LBL_COLUMN1, 382, 55, 15);

		Label lblGrnX = new Label(cmpNewGamut, SWT.NONE);
		lblGrnX.setText("Green X");
		lblGrnX.setAlignment(SWT.RIGHT);
		lblGrnX.setBounds(LBL_COLUMN1, 112, 55, 15);

		Label lblGrnXT = new Label(cmpNewGamut, SWT.NONE);
		lblGrnXT.setText("Green X");
		lblGrnXT.setAlignment(SWT.RIGHT);
		lblGrnXT.setBounds(LBL_COLUMN1, 426, 55, 15);

		Label lblGrnY = new Label(cmpNewGamut, SWT.NONE);
		lblGrnY.setText("Green Y");
		lblGrnY.setAlignment(SWT.RIGHT);
		lblGrnY.setBounds(LBL_COLUMN1, 137, 55, 15);

		Label lblGrnYT = new Label(cmpNewGamut, SWT.NONE);
		lblGrnYT.setText("Green Y");
		lblGrnYT.setAlignment(SWT.RIGHT);
		lblGrnYT.setBounds(LBL_COLUMN1, 450, 55, 15);

		Label lblBluX = new Label(cmpNewGamut, SWT.NONE);
		lblBluX.setText("Blue X");
		lblBluX.setAlignment(SWT.RIGHT);
		lblBluX.setBounds(LBL_COLUMN1, 186, 55, 15);

		Label lblBluXT = new Label(cmpNewGamut, SWT.NONE);
		lblBluXT.setText("Blue X");
		lblBluXT.setAlignment(SWT.RIGHT);
		lblBluXT.setBounds(LBL_COLUMN2, 358, 50, 15);

		Label lblBluY = new Label(cmpNewGamut, SWT.NONE);
		lblBluY.setText("Blue Y");
		lblBluY.setAlignment(SWT.RIGHT);
		lblBluY.setBounds(LBL_COLUMN1, 211, 55, 15);

		Label lblBluYT = new Label(cmpNewGamut, SWT.NONE);
		lblBluYT.setText("Blue Y");
		lblBluYT.setAlignment(SWT.RIGHT);
		lblBluYT.setBounds(LBL_COLUMN2, 382, 50, 15);

		Label lblWhtX = new Label(cmpNewGamut, SWT.NONE);
		lblWhtX.setText("White X");
		lblWhtX.setAlignment(SWT.RIGHT);
		lblWhtX.setBounds(LBL_COLUMN1, 260, 55, 15);

		Label lblWhtXT = new Label(cmpNewGamut, SWT.NONE);
		lblWhtXT.setText("White X");
		lblWhtXT.setAlignment(SWT.RIGHT);
		lblWhtXT.setBounds(128, 426, 55, 15);

		Label lblWhtY = new Label(cmpNewGamut, SWT.NONE);
		lblWhtY.setText("White Y");
		lblWhtY.setAlignment(SWT.RIGHT);
		lblWhtY.setBounds(18, 285, 55, 15);

		Label lblWhtYT = new Label(cmpNewGamut, SWT.NONE);
		lblWhtYT.setText("White Y");
		lblWhtYT.setAlignment(SWT.RIGHT);
		lblWhtYT.setBounds(128, 450, 55, 15);
	}
	
	public void setVals(Gamut tabGam) {
		
		tabGam.rX = spnRX.getSelection();
		tabGam.rY = spnRY.getSelection();
		tabGam.gX = spnGX.getSelection();
		tabGam.gY = spnGY.getSelection();
		tabGam.bX = spnBX.getSelection();
		tabGam.bY = spnBY.getSelection();
		tabGam.wX = spnWX.getSelection();
		tabGam.wY = spnWY.getSelection();
		
		if (tabGam.nativeLinked) {
			
			tabGam.rXN = spnRX.getSelection();
			spnRXN.setSelection(tabGam.rXN);
			
			tabGam.rYN = spnRY.getSelection();
			spnRYN.setSelection(tabGam.rYN);
			
			tabGam.gXN = spnGX.getSelection();
			spnGXN.setSelection(tabGam.gXN);
			
			tabGam.gYN = spnGY.getSelection();
			spnGYN.setSelection(tabGam.gYN);
			
			tabGam.bXN = spnBX.getSelection();
			spnBXN.setSelection(tabGam.bXN);
			
			tabGam.bYN = spnBY.getSelection();
			spnBYN.setSelection(tabGam.bYN);
			
			tabGam.wXN = spnWX.getSelection();
			spnWXN.setSelection(tabGam.wXN);
			
			tabGam.wYN = spnWY.getSelection();
			spnWYN.setSelection(tabGam.wYN);
			
		}
	}
	
	public void setNVals(Gamut tabGam) {
		
		tabGam.rXN = spnRXN.getSelection();
		tabGam.rYN = spnRYN.getSelection();
		tabGam.gXN = spnGXN.getSelection();
		tabGam.gYN = spnGYN.getSelection();
		tabGam.bXN = spnBXN.getSelection();
		tabGam.bYN = spnBYN.getSelection();
		tabGam.wXN = spnWXN.getSelection();
		tabGam.wYN = spnWYN.getSelection();
		
		if (tabGam.nativeLinked) {
			
			tabGam.rX = spnRXN.getSelection();
			spnRX.setSelection(tabGam.rX);
			
			tabGam.rY = spnRYN.getSelection();
			spnRY.setSelection(tabGam.rY);
			
			tabGam.gX = spnGXN.getSelection();
			spnGX.setSelection(tabGam.gX);
			
			tabGam.gY = spnGYN.getSelection();
			spnGY.setSelection(tabGam.gY);
			
			tabGam.bX = spnBXN.getSelection();
			spnBX.setSelection(tabGam.bX);
			
			tabGam.bY = spnBYN.getSelection();
			spnBY.setSelection(tabGam.bY);
			
			tabGam.wX = spnWXN.getSelection();
			spnWX.setSelection(tabGam.wX);
			
			tabGam.wY = spnWYN.getSelection();
			spnWY.setSelection(tabGam.wY);
			
		}
	}
	
	public void setOffsets (Gamut tabGam, Gamut comGam) {
		
		tabGam.updateOffsets();
		
		lblRedXTVal.setText(Integer.toString(tabGam.rXO + comGam.rX));
		lblRedYTVal.setText(Integer.toString(tabGam.rYO + comGam.rY));
		lblGrnXTVal.setText(Integer.toString(tabGam.gXO + comGam.gX));
		lblGrnYTVal.setText(Integer.toString(tabGam.gYO + comGam.gY));
		lblBluXTVal.setText(Integer.toString(tabGam.bXO + comGam.bX));
		lblBluYTVal.setText(Integer.toString(tabGam.bYO + comGam.bY));
		lblWhtXTVal.setText(Integer.toString(tabGam.wXO + comGam.wX));
		lblWhtYTVal.setText(Integer.toString(tabGam.wYO + comGam.wY));
		
	}

}
