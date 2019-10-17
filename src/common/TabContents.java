package common;

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
	
	public void layout () {
		
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
		
		
	}
	
	public void updateVals (Gamut gam) {
		
		
		
	}

}
