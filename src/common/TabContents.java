package common;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class TabContents {
	
	private static final int COLUMN1 = 79;
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
			this.spnRX.setBounds(COLUMN1, ROW1, 56, 22);
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
			this.spnRY.setBounds(COLUMN1, 66, 56, 22);
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
			this.spnGX.setBounds(COLUMN1, 110, 56, 22);	
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
			this.spnGY.setBounds(COLUMN1, 135, 56, 22);	
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
			this.spnBX.setBounds(COLUMN1, 184, 56, 22);
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
	
	public void layoutLabels() {
		
		if (this.lblRedXTVal !=null) {
			this.lblRedXTVal.setAlignment(SWT.LEFT);
			this.lblRedXTVal.setBounds(79, 358, 55, 15);
		}
		
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
	
	public void updateVals(Gamut gam) {
		
		
		
	}

}
