package views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.wb.swt.SWTResourceManager;

import common.Gamut;


public class TabContents {
	
	private static final int LBL_COLUMN1 = 18;
	private static final int LBL_COLUMN2 = 128;
	private static final int SPN_COLUMN1 = 79;
	private static final int ROW1 = 41;
	
	public Label lblRedXTVal, lblRedYTVal, lblGrnXTVal, lblGrnYTVal, lblBluXTVal, lblBluYTVal, lblWhtXTVal, lblWhtYTVal, lblTriangleImage;
	public Spinner spnRX, spnRY, spnGX, spnGY, spnBX, spnBY, spnWX, spnWY;
	public Spinner spnRXN, spnRYN, spnGXN, spnGYN, spnBXN, spnBYN, spnWXN, spnWYN;
	public Button btnLinked;
	public Composite cmp;
	public Gamut gam;
	public Image image;
	public Display display;
	
	public TabContents(Composite cmp, Gamut gam, Display display) {
		
		this.cmp = cmp;
		this.gam = gam;
		this.display = display;
		
		this.layoutSpinners();
		
		this.layoutLabels();

		this.layoutFields();
		
		this.layoutButtons();
		
		this.layoutImage();
		

	}
	
	public void layoutSpinners() {
		
		//-----------------------------Spinners for measured values---------------------------//
		
		this.spnRX = new Spinner(this.cmp, SWT.BORDER);
		this.spnRX.setDigits(3);
		this.spnRX.setMaximum(750);
		this.spnRX.setMinimum(401);
		this.spnRX.setSelection(640);
		this.spnRX.setBounds(SPN_COLUMN1, ROW1, 56, 22);
		
		this.spnRY = new Spinner(this.cmp, SWT.BORDER);
		this.spnRY.setDigits(3);
		this.spnRY.setMaximum(399);
		this.spnRY.setMinimum(211);
		this.spnRY.setSelection(330);
		this.spnRY.setBounds(SPN_COLUMN1, 66, 56, 22);
				
		this.spnGX = new Spinner(this.cmp, SWT.BORDER);
		this.spnGX.setMaximum(399);
		this.spnGX.setMinimum(20);
		this.spnGX.setSelection(300);
		this.spnGX.setDigits(3);
		this.spnGX.setBounds(SPN_COLUMN1, 110, 56, 22);	
		
		this.spnGY = new Spinner(this.cmp, SWT.BORDER);
		this.spnGY.setDigits(3);
		this.spnGY.setMaximum(850);
		this.spnGY.setMinimum(401);
		this.spnGY.setSelection(600);
		this.spnGY.setBounds(SPN_COLUMN1, 135, 56, 22);	
		
		this.spnBX = new Spinner(this.cmp, SWT.BORDER);
		this.spnBX.setMaximum(299);
		this.spnBX.setMinimum(20);
		this.spnBX.setSelection(150);
		this.spnBX.setDigits(3);
		this.spnBX.setBounds(SPN_COLUMN1, 184, 56, 22);
		
		this.spnBY = new Spinner(this.cmp, SWT.BORDER);
		this.spnBY.setMaximum(209);
		this.spnBY.setMinimum(20);
		this.spnBY.setSelection(60);
		this.spnBY.setDigits(3);
		this.spnBY.setBounds(79, 209, 56, 22);
		
		
		this.spnWX = new Spinner(this.cmp, SWT.BORDER);
		this.spnWX.setMaximum(400);
		this.spnWX.setMinimum(250);
		this.spnWX.setSelection(313);
		this.spnWX.setDigits(3);
		this.spnWX.setBounds(79, 258, 56, 22);
		
		
		this.spnWY = new Spinner(this.cmp, SWT.BORDER);
		this.spnWY.setMaximum(400);
		this.spnWY.setMinimum(250);
		this.spnWY.setSelection(329);
		this.spnWY.setDigits(3);
		this.spnWY.setBounds(79, 283, 56, 22);
		
		//----------------------------Spinners for native values-------------------------------------//
		
		this.spnRXN = new Spinner(this.cmp, SWT.BORDER);
		this.spnRXN.setDigits(3);
		this.spnRXN.setMaximum(750);
		this.spnRXN.setMinimum(401);
		this.spnRXN.setSelection(640);
		this.spnRXN.setBounds(179, 41, 56, 22);
		
		this.spnRYN = new Spinner(this.cmp, SWT.BORDER);
		this.spnRYN.setDigits(3);
		this.spnRYN.setMaximum(399);
		this.spnRYN.setMinimum(211);
		this.spnRYN.setSelection(330);
		this.spnRYN.setBounds(179, 66, 56, 22);
		
		this.spnGXN = new Spinner(this.cmp, SWT.BORDER);
		this.spnGXN.setMaximum(399);
		this.spnGXN.setMinimum(20);
		this.spnGXN.setSelection(300);
		this.spnGXN.setDigits(3);
		this.spnGXN.setBounds(179, 110, 56, 22);	
		
		this.spnGYN = new Spinner(this.cmp, SWT.BORDER);
		this.spnGYN.setDigits(3);
		this.spnGYN.setMaximum(850);
		this.spnGYN.setMinimum(401);
		this.spnGYN.setSelection(600);
		this.spnGYN.setBounds(179, 135, 56, 22);
		
		this.spnBXN = new Spinner(this.cmp, SWT.BORDER);
		this.spnBXN.setMaximum(299);
		this.spnBXN.setMinimum(20);
		this.spnBXN.setSelection(150);
		this.spnBXN.setDigits(3);
		this.spnBXN.setBounds(179, 184, 56, 22);

		this.spnBYN = new Spinner(this.cmp, SWT.BORDER);
		this.spnBYN.setMaximum(209);
		this.spnBYN.setMinimum(20);
		this.spnBYN.setSelection(60);
		this.spnBYN.setDigits(3);
		this.spnBYN.setBounds(179, 209, 56, 22);

		this.spnWXN = new Spinner(this.cmp, SWT.BORDER);
		this.spnWXN.setMaximum(400);
		this.spnWXN.setMinimum(250);
		this.spnWXN.setSelection(313);
		this.spnWXN.setDigits(3);
		this.spnWXN.setBounds(179, 258, 56, 22);

		this.spnWYN = new Spinner(this.cmp, SWT.BORDER);
		this.spnWYN.setMaximum(400);
		this.spnWYN.setMinimum(250);
		this.spnWYN.setSelection(329);
		this.spnWYN.setDigits(3);
		this.spnWYN.setBounds(179, 283, 56, 22);
		
	}
	
	
	
	
	public void layoutFields() {
		
		this.lblRedXTVal = new Label(this.cmp, SWT.BORDER);
		this.lblRedXTVal.setAlignment(SWT.LEFT);
		this.lblRedXTVal.setBounds(79, 358, 55, 15);
		
		this.lblRedYTVal = new Label(this.cmp, SWT.BORDER);
		this.lblRedYTVal.setAlignment(SWT.LEFT);
		this.lblRedYTVal.setBounds(79, 382, 55, 15);
		
		this.lblGrnXTVal = new Label(this.cmp, SWT.BORDER);
		this.lblGrnXTVal.setAlignment(SWT.LEFT);
		this.lblGrnXTVal.setBounds(79, 426, 55, 15);
		
		this.lblGrnYTVal = new Label(this.cmp, SWT.BORDER);
		this.lblGrnYTVal.setAlignment(SWT.LEFT);
		this.lblGrnYTVal.setBounds(79, 450, 55, 15);
		
		this.lblBluXTVal = new Label(this.cmp, SWT.BORDER);
		this.lblBluXTVal.setAlignment(SWT.LEFT);
		this.lblBluXTVal.setBounds(185, 358, 55, 15);
		
		this.lblBluYTVal = new Label(this.cmp, SWT.BORDER);
		this.lblBluYTVal.setAlignment(SWT.LEFT);
		this.lblBluYTVal.setBounds(185, 382, 55, 15);
		
		this.lblWhtXTVal = new Label(this.cmp, SWT.BORDER);
		this.lblWhtXTVal.setAlignment(SWT.LEFT);
		this.lblWhtXTVal.setBounds(185, 426, 55, 15);
		
		this.lblWhtYTVal = new Label(this.cmp, SWT.BORDER);
		this.lblWhtYTVal.setAlignment(SWT.LEFT);
		this.lblWhtYTVal.setBounds(185, 450, 55, 15);
		
	}
	
	
	
	
	public void layoutLabels() {
		
		//-----------------Measured & native labels----------------------------------------------------//
		
		Label lblMeasured = new Label(this.cmp, SWT.NONE);
		lblMeasured.setAlignment(SWT.LEFT);
		lblMeasured.setBounds(80, 19, 55, 15);
		lblMeasured.setText("Measured");

		Label lblNative = new Label(this.cmp, SWT.NONE);
		lblNative.setAlignment(SWT.LEFT);
		lblNative.setBounds(180, 19, 55, 15);
		lblNative.setText("Native");
		
		Label lblRedX = new Label(this.cmp, SWT.NONE);
		lblRedX.setAlignment(SWT.RIGHT);
		lblRedX.setBounds(LBL_COLUMN1, 43, 55, 15);
		lblRedX.setText("Red X");

		Label lblRedY = new Label(this.cmp, SWT.NONE);
		lblRedY.setText("Red Y");
		lblRedY.setAlignment(SWT.RIGHT);
		lblRedY.setBounds(LBL_COLUMN1, 68, 55, 15);

		Label lblGrnX = new Label(this.cmp, SWT.NONE);
		lblGrnX.setText("Green X");
		lblGrnX.setAlignment(SWT.RIGHT);
		lblGrnX.setBounds(LBL_COLUMN1, 112, 55, 15);

		Label lblGrnY = new Label(this.cmp, SWT.NONE);
		lblGrnY.setText("Green Y");
		lblGrnY.setAlignment(SWT.RIGHT);
		lblGrnY.setBounds(LBL_COLUMN1, 137, 55, 15);

		Label lblBluX = new Label(this.cmp, SWT.NONE);
		lblBluX.setText("Blue X");
		lblBluX.setAlignment(SWT.RIGHT);
		lblBluX.setBounds(LBL_COLUMN1, 186, 55, 15);

		Label lblBluY = new Label(this.cmp, SWT.NONE);
		lblBluY.setText("Blue Y");
		lblBluY.setAlignment(SWT.RIGHT);
		lblBluY.setBounds(LBL_COLUMN1, 211, 55, 15);

		Label lblWhtX = new Label(this.cmp, SWT.NONE);
		lblWhtX.setText("White X");
		lblWhtX.setAlignment(SWT.RIGHT);
		lblWhtX.setBounds(LBL_COLUMN1, 260, 55, 15);

		Label lblWhtY = new Label(this.cmp, SWT.NONE);
		lblWhtY.setText("White Y");
		lblWhtY.setAlignment(SWT.RIGHT);
		lblWhtY.setBounds(18, 285, 55, 15);
		
		//-------------------Target value labels------------------------------------------------------//
		
		Label lblTVal = new Label(this.cmp, SWT.NONE);
		lblTVal.setAlignment(SWT.LEFT);
		lblTVal.setBounds(80, 334, 170, 15);
		lblTVal.setText("Target Values (offsets)");
		
		Label lblRedXT = new Label(this.cmp, SWT.NONE);
		lblRedXT.setAlignment(SWT.RIGHT);
		lblRedXT.setBounds(LBL_COLUMN1, 358, 55, 15);
		lblRedXT.setText("Red X");
		
		Label lblRedYT = new Label(this.cmp, SWT.NONE);
		lblRedYT.setText("Red Y");
		lblRedYT.setAlignment(SWT.RIGHT);
		lblRedYT.setBounds(LBL_COLUMN1, 382, 55, 15);
		
		Label lblGrnXT = new Label(this.cmp, SWT.NONE);
		lblGrnXT.setText("Green X");
		lblGrnXT.setAlignment(SWT.RIGHT);
		lblGrnXT.setBounds(LBL_COLUMN1, 426, 55, 15);
		
		Label lblGrnYT = new Label(this.cmp, SWT.NONE);
		lblGrnYT.setText("Green Y");
		lblGrnYT.setAlignment(SWT.RIGHT);
		lblGrnYT.setBounds(LBL_COLUMN1, 450, 55, 15);
		
		Label lblBluXT = new Label(this.cmp, SWT.NONE);
		lblBluXT.setText("Blue X");
		lblBluXT.setAlignment(SWT.RIGHT);
		lblBluXT.setBounds(LBL_COLUMN2, 358, 50, 15);
		
		Label lblBluYT = new Label(this.cmp, SWT.NONE);
		lblBluYT.setText("Blue Y");
		lblBluYT.setAlignment(SWT.RIGHT);
		lblBluYT.setBounds(LBL_COLUMN2, 382, 50, 15);
		
		Label lblWhtXT = new Label(this.cmp, SWT.NONE);
		lblWhtXT.setText("White X");
		lblWhtXT.setAlignment(SWT.RIGHT);
		lblWhtXT.setBounds(128, 426, 55, 15);

		Label lblWhtYT = new Label(this.cmp, SWT.NONE);
		lblWhtYT.setText("White Y");
		lblWhtYT.setAlignment(SWT.RIGHT);
		lblWhtYT.setBounds(128, 450, 55, 15);
	}
	
	
	
	
	public void layoutButtons() {
		
		this.btnLinked = new Button(this.cmp, SWT.NONE);
		this.btnLinked.setBounds(145, 41, 25, 22);
		this.btnLinked.setImage(SWTResourceManager.getImage(MainWindow.class, "/resource/link.png"));
		
	}
	
	
	public void layoutImage() {
		
		this.image = new Image(display, MainWindow.class.getResourceAsStream("/resource/cie.gif"));
		this.lblTriangleImage = new Label(this.cmp, SWT.NONE);
		this.lblTriangleImage.setImage(this.image);
		this.lblTriangleImage.setBounds(242, 43, 343, 355); 
		
	}
	
	
	public void setVals() {
		
		this.gam.rX = this.spnRX.getSelection();
		this.gam.rY = this.spnRY.getSelection();
		this.gam.gX = this.spnGX.getSelection();
		this.gam.gY = this.spnGY.getSelection();
		this.gam.bX = this.spnBX.getSelection();
		this.gam.bY = this.spnBY.getSelection();
		this.gam.wX = this.spnWX.getSelection();
		this.gam.wY = this.spnWY.getSelection();
		
		if (this.gam.nativeLinked) {
			
			this.gam.rXN = this.spnRX.getSelection();
			this.spnRXN.setSelection(this.gam.rXN);
			
			this.gam.rYN = this.spnRY.getSelection();
			this.spnRYN.setSelection(this.gam.rYN);
			
			this.gam.gXN = this.spnGX.getSelection();
			this.spnGXN.setSelection(this.gam.gXN);
			
			this.gam.gYN = this.spnGY.getSelection();
			this.spnGYN.setSelection(this.gam.gYN);
			
			this.gam.bXN = this.spnBX.getSelection();
			this.spnBXN.setSelection(this.gam.bXN);
			
			this.gam.bYN = this.spnBY.getSelection();
			this.spnBYN.setSelection(this.gam.bYN);
			
			this.gam.wXN = this.spnWX.getSelection();
			this.spnWXN.setSelection(this.gam.wXN);
			
			this.gam.wYN = this.spnWY.getSelection();
			this.spnWYN.setSelection(this.gam.wYN);
			
		}
	}
	
	
	
	
	public void setNVals() {
		
		this.gam.rXN = this.spnRXN.getSelection();
		this.gam.rYN = this.spnRYN.getSelection();
		this.gam.gXN = this.spnGXN.getSelection();
		this.gam.gYN = this.spnGYN.getSelection();
		this.gam.bXN = this.spnBXN.getSelection();
		this.gam.bYN = this.spnBYN.getSelection();
		this.gam.wXN = this.spnWXN.getSelection();
		this.gam.wYN = this.spnWYN.getSelection();
		
		if (this.gam.nativeLinked) {
			
			this.gam.rX = this.spnRXN.getSelection();
			this.spnRX.setSelection(this.gam.rX);
			
			this.gam.rY = this.spnRYN.getSelection();
			this.spnRY.setSelection(this.gam.rY);
			
			this.gam.gX = this.spnGXN.getSelection();
			this.spnGX.setSelection(this.gam.gX);
			
			this.gam.gY = this.spnGYN.getSelection();
			this.spnGY.setSelection(this.gam.gY);
			
			this.gam.bX = this.spnBXN.getSelection();
			this.spnBX.setSelection(this.gam.bX);
			
			this.gam.bY = this.spnBYN.getSelection();
			this.spnBY.setSelection(this.gam.bY);
			
			this.gam.wX = this.spnWXN.getSelection();
			this.spnWX.setSelection(this.gam.wX);
			
			this.gam.wY = this.spnWYN.getSelection();
			this.spnWY.setSelection(this.gam.wY);
			
		}
	}
	
	
	
	
	public void setOffsets (Gamut comGam) {
		
		this.gam.updateOffsets();
		
		this.lblRedXTVal.setText(Integer.toString(this.gam.rXO + comGam.rX));
		this.lblRedYTVal.setText(Integer.toString(this.gam.rYO + comGam.rY));
		this.lblGrnXTVal.setText(Integer.toString(this.gam.gXO + comGam.gX));
		this.lblGrnYTVal.setText(Integer.toString(this.gam.gYO + comGam.gY));
		this.lblBluXTVal.setText(Integer.toString(this.gam.bXO + comGam.bX));
		this.lblBluYTVal.setText(Integer.toString(this.gam.bYO + comGam.bY));
		this.lblWhtXTVal.setText(Integer.toString(this.gam.wXO + comGam.wX));
		this.lblWhtYTVal.setText(Integer.toString(this.gam.wYO + comGam.wY));
		
	}

}
