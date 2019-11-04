package views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.wb.swt.SWTResourceManager;

import common.Gamut;
import views.MainWindow;


public class TabContents {
	
	private static final int LBL_COLUMN1 = 18;
	private static final int LBL_COLUMN2 = 128;
	private static final int SPN_COLUMN1 = 79;
	private static final int SPN_COLUMN2 = 179;
	private static final int ROW1 = 41;
	private static final int ROW2 = 66;
	private static final int ROW3 = 110;
	private static final int ROW4 = 135;
	private static final int ROW5 = 184;
	private static final int ROW6 = 209;
	private static final int ROW7 = 258;
	private static final int ROW8 = 283;
	private static final int ROW9 = 358;
	private static final int ROW10 = 382;
	private static final int ROW11 = 426;
	private static final int ROW12 = 450;
	
	final static double XSCALER = 0.316;
	final static double YSCALER = 0.326;
	final static int XOFFSET = 50;
	final static int YOFFSET = 310;

	
	public Label lblRedXTVal, lblRedYTVal, lblGrnXTVal, lblGrnYTVal, lblBluXTVal, lblBluYTVal, lblWhtXTVal, lblWhtYTVal, lblTriangleImage;
	public Spinner spnRX, spnRY, spnGX, spnGY, spnBX, spnBY, spnWX, spnWY;
	public Spinner spnRXN, spnRYN, spnGXN, spnGYN, spnBXN, spnBYN, spnWXN, spnWYN;
	public Button btnLinked;
	public Composite cmp;
	public Gamut gam;
	public Display display;
	public MainWindow mw;
	
	
	public TabContents(Composite cmp, Gamut gam, MainWindow mw) {
		
		this.cmp = cmp;
		this.gam = gam;
		this.mw = mw;
		
		this.layoutSpinners();
		
		this.layoutLabels();

		this.layoutFields();
		
		this.layoutButtons();
		
		this.layoutImage();
		
		this.handleEvents();
		

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
		this.spnRY.setMinimum(150);
		this.spnRY.setSelection(330);
		this.spnRY.setBounds(SPN_COLUMN1, ROW2, 56, 22);
				
		this.spnGX = new Spinner(this.cmp, SWT.BORDER);
		this.spnGX.setMaximum(399);
		this.spnGX.setMinimum(20);
		this.spnGX.setSelection(300);
		this.spnGX.setDigits(3);
		this.spnGX.setBounds(SPN_COLUMN1, ROW3, 56, 22);	
		
		this.spnGY = new Spinner(this.cmp, SWT.BORDER);
		this.spnGY.setDigits(3);
		this.spnGY.setMaximum(850);
		this.spnGY.setMinimum(401);
		this.spnGY.setSelection(600);
		this.spnGY.setBounds(SPN_COLUMN1, ROW4, 56, 22);	
		
		this.spnBX = new Spinner(this.cmp, SWT.BORDER);
		this.spnBX.setMaximum(299);
		this.spnBX.setMinimum(20);
		this.spnBX.setSelection(150);
		this.spnBX.setDigits(3);
		this.spnBX.setBounds(SPN_COLUMN1, ROW5, 56, 22);
		
		this.spnBY = new Spinner(this.cmp, SWT.BORDER);
		this.spnBY.setMaximum(209);
		this.spnBY.setMinimum(20);
		this.spnBY.setSelection(60);
		this.spnBY.setDigits(3);
		this.spnBY.setBounds(SPN_COLUMN1, ROW6, 56, 22);
		
		
		this.spnWX = new Spinner(this.cmp, SWT.BORDER);
		this.spnWX.setMaximum(400);
		this.spnWX.setMinimum(250);
		this.spnWX.setSelection(313);
		this.spnWX.setDigits(3);
		this.spnWX.setBounds(SPN_COLUMN1, ROW7, 56, 22);
		
		
		this.spnWY = new Spinner(this.cmp, SWT.BORDER);
		this.spnWY.setMaximum(400);
		this.spnWY.setMinimum(250);
		this.spnWY.setSelection(329);
		this.spnWY.setDigits(3);
		this.spnWY.setBounds(SPN_COLUMN1, ROW8, 56, 22);
		
		//----------------------------Spinners for native values-------------------------------------//
		
		this.spnRXN = new Spinner(this.cmp, SWT.BORDER);
		this.spnRXN.setDigits(3);
		this.spnRXN.setMaximum(750);
		this.spnRXN.setMinimum(401);
		this.spnRXN.setSelection(640);
		this.spnRXN.setBounds(SPN_COLUMN2, ROW1, 56, 22);
		
		this.spnRYN = new Spinner(this.cmp, SWT.BORDER);
		this.spnRYN.setDigits(3);
		this.spnRYN.setMaximum(399);
		this.spnRYN.setMinimum(211);
		this.spnRYN.setSelection(330);
		this.spnRYN.setBounds(SPN_COLUMN2, ROW2, 56, 22);
		
		this.spnGXN = new Spinner(this.cmp, SWT.BORDER);
		this.spnGXN.setMaximum(399);
		this.spnGXN.setMinimum(20);
		this.spnGXN.setSelection(300);
		this.spnGXN.setDigits(3);
		this.spnGXN.setBounds(SPN_COLUMN2, ROW3, 56, 22);	
		
		this.spnGYN = new Spinner(this.cmp, SWT.BORDER);
		this.spnGYN.setDigits(3);
		this.spnGYN.setMaximum(850);
		this.spnGYN.setMinimum(401);
		this.spnGYN.setSelection(600);
		this.spnGYN.setBounds(SPN_COLUMN2, ROW4, 56, 22);
		
		this.spnBXN = new Spinner(this.cmp, SWT.BORDER);
		this.spnBXN.setMaximum(299);
		this.spnBXN.setMinimum(20);
		this.spnBXN.setSelection(150);
		this.spnBXN.setDigits(3);
		this.spnBXN.setBounds(SPN_COLUMN2, ROW5, 56, 22);

		this.spnBYN = new Spinner(this.cmp, SWT.BORDER);
		this.spnBYN.setMaximum(209);
		this.spnBYN.setMinimum(20);
		this.spnBYN.setSelection(60);
		this.spnBYN.setDigits(3);
		this.spnBYN.setBounds(SPN_COLUMN2, ROW6, 56, 22);

		this.spnWXN = new Spinner(this.cmp, SWT.BORDER);
		this.spnWXN.setMaximum(400);
		this.spnWXN.setMinimum(250);
		this.spnWXN.setSelection(313);
		this.spnWXN.setDigits(3);
		this.spnWXN.setBounds(SPN_COLUMN2, ROW7, 56, 22);

		this.spnWYN = new Spinner(this.cmp, SWT.BORDER);
		this.spnWYN.setMaximum(400);
		this.spnWYN.setMinimum(250);
		this.spnWYN.setSelection(329);
		this.spnWYN.setDigits(3);
		this.spnWYN.setBounds(SPN_COLUMN2, ROW8, 56, 22);
		
	}
	
	
	public void layoutFields() {
		
		this.lblRedXTVal = new Label(this.cmp, SWT.BORDER);
		this.lblRedXTVal.setAlignment(SWT.LEFT);
		this.lblRedXTVal.setBounds(SPN_COLUMN1, 358, 55, 15);
		
		this.lblRedYTVal = new Label(this.cmp, SWT.BORDER);
		this.lblRedYTVal.setAlignment(SWT.LEFT);
		this.lblRedYTVal.setBounds(SPN_COLUMN1, 382, 55, 15);
		
		this.lblGrnXTVal = new Label(this.cmp, SWT.BORDER);
		this.lblGrnXTVal.setAlignment(SWT.LEFT);
		this.lblGrnXTVal.setBounds(SPN_COLUMN1, 426, 55, 15);
		
		this.lblGrnYTVal = new Label(this.cmp, SWT.BORDER);
		this.lblGrnYTVal.setAlignment(SWT.LEFT);
		this.lblGrnYTVal.setBounds(SPN_COLUMN1, 450, 55, 15);
		
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
		lblRedX.setBounds(LBL_COLUMN1, (ROW1 + 2), 55, 15);
		lblRedX.setText("Red X");

		Label lblRedY = new Label(this.cmp, SWT.NONE);
		lblRedY.setText("Red Y");
		lblRedY.setAlignment(SWT.RIGHT);
		lblRedY.setBounds(LBL_COLUMN1, (ROW2 + 2), 55, 15);

		Label lblGrnX = new Label(this.cmp, SWT.NONE);
		lblGrnX.setText("Green X");
		lblGrnX.setAlignment(SWT.RIGHT);
		lblGrnX.setBounds(LBL_COLUMN1, (ROW3 + 2), 55, 15);

		Label lblGrnY = new Label(this.cmp, SWT.NONE);
		lblGrnY.setText("Green Y");
		lblGrnY.setAlignment(SWT.RIGHT);
		lblGrnY.setBounds(LBL_COLUMN1, (ROW4 + 2), 55, 15);

		Label lblBluX = new Label(this.cmp, SWT.NONE);
		lblBluX.setText("Blue X");
		lblBluX.setAlignment(SWT.RIGHT);
		lblBluX.setBounds(LBL_COLUMN1, (ROW5 + 2), 55, 15);

		Label lblBluY = new Label(this.cmp, SWT.NONE);
		lblBluY.setText("Blue Y");
		lblBluY.setAlignment(SWT.RIGHT);
		lblBluY.setBounds(LBL_COLUMN1, (ROW6 + 2), 55, 15);

		Label lblWhtX = new Label(this.cmp, SWT.NONE);
		lblWhtX.setText("White X");
		lblWhtX.setAlignment(SWT.RIGHT);
		lblWhtX.setBounds(LBL_COLUMN1, (ROW7 + 2), 55, 15);

		Label lblWhtY = new Label(this.cmp, SWT.NONE);
		lblWhtY.setText("White Y");
		lblWhtY.setAlignment(SWT.RIGHT);
		lblWhtY.setBounds(LBL_COLUMN1, (ROW8 + 2), 55, 15);
		
		//-------------------Target value labels------------------------------------------------------//
		
		Label lblTVal = new Label(this.cmp, SWT.NONE);
		lblTVal.setAlignment(SWT.LEFT);
		lblTVal.setBounds(80, 334, 170, 15);
		lblTVal.setText("Target Values (offsets)");
		
		Label lblRedXT = new Label(this.cmp, SWT.NONE);
		lblRedXT.setAlignment(SWT.RIGHT);
		lblRedXT.setBounds(LBL_COLUMN1, ROW9, 55, 15);
		lblRedXT.setText("Red X");
		
		Label lblRedYT = new Label(this.cmp, SWT.NONE);
		lblRedYT.setText("Red Y");
		lblRedYT.setAlignment(SWT.RIGHT);
		lblRedYT.setBounds(LBL_COLUMN1, ROW10, 55, 15);
		
		Label lblGrnXT = new Label(this.cmp, SWT.NONE);
		lblGrnXT.setText("Green X");
		lblGrnXT.setAlignment(SWT.RIGHT);
		lblGrnXT.setBounds(LBL_COLUMN1, ROW11, 55, 15);
		
		Label lblGrnYT = new Label(this.cmp, SWT.NONE);
		lblGrnYT.setText("Green Y");
		lblGrnYT.setAlignment(SWT.RIGHT);
		lblGrnYT.setBounds(LBL_COLUMN1, ROW12, 55, 15);
		
		Label lblBluXT = new Label(this.cmp, SWT.NONE);
		lblBluXT.setText("Blue X");
		lblBluXT.setAlignment(SWT.RIGHT);
		lblBluXT.setBounds(LBL_COLUMN2, ROW9, 50, 15);
		
		Label lblBluYT = new Label(this.cmp, SWT.NONE);
		lblBluYT.setText("Blue Y");
		lblBluYT.setAlignment(SWT.RIGHT);
		lblBluYT.setBounds(LBL_COLUMN2, ROW10, 50, 15);
		
		Label lblWhtXT = new Label(this.cmp, SWT.NONE);
		lblWhtXT.setText("White X");
		lblWhtXT.setAlignment(SWT.RIGHT);
		lblWhtXT.setBounds(LBL_COLUMN2, ROW11, 55, 15);

		Label lblWhtYT = new Label(this.cmp, SWT.NONE);
		lblWhtYT.setText("White Y");
		lblWhtYT.setAlignment(SWT.RIGHT);
		lblWhtYT.setBounds(LBL_COLUMN2, ROW12, 55, 15);
	}
	
	
	public void layoutButtons() {
		
		this.btnLinked = new Button(this.cmp, SWT.NONE);
		this.btnLinked.setBounds(145, 41, 25, 22);
		this.btnLinked.setImage(SWTResourceManager.getImage(MainWindow.class, "/resource/link.png"));
		
	}
	
	
	public void layoutImage() {
		
		Image image = new Image(mw.display, MainWindow.class.getResourceAsStream("/resource/cie.gif"));
		this.lblTriangleImage = new Label(this.cmp, SWT.NONE);
		this.lblTriangleImage.setImage(image);
		this.lblTriangleImage.setBounds(242, 43, 343, 355); 
		
	}
	
	
	public void handleEvents() {
		
		
		this.btnLinked.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (gam.nativeLinked) {
					gam.nativeLinked = false;
					btnLinked.setImage(SWTResourceManager.getImage(MainWindow.class, "/resource/broken-link.png"));
				} else {
					gam.nativeLinked = true;
					btnLinked.setImage(SWTResourceManager.getImage(MainWindow.class, "/resource/link.png"));
				}
			}
		});

		this.spnRX.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				updateTab();	
			}
		});
		
		this.spnRY.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				updateTab();
			}
		});

		this.spnGX.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				updateTab();
			}
		});
		
		this.spnGY.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				updateTab();
			}
		});
		
		this.spnBX.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				updateTab();
			}
		});
		
		this.spnBY.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				updateTab();			}
		});

		this.spnWX.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				updateTab();			}
		});

		this.spnWY.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				updateTab();				
			}
		});

		this.spnRXN.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				updateTabN();
			}
		});

		this.spnRYN.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				updateTabN();			}
		});

		this.spnGXN.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				updateTabN();			}
		});

		this.spnGYN.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				updateTabN();			}
		});

		this.spnBXN.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				updateTabN();			}
		});

		this.spnBYN.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				updateTabN();			}
		});

		this.spnWXN.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				updateTabN();			}
		});

		this.spnWYN.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				updateTabN();			}
		});


	}
	
	
	public void updateTab() {
		
		this.setVals();
		mw.getCommon();
		this.setOffsets(mw.comGam);
		this.drawTriangle(mw.comGam);
	}
	
	
	public void updateTabN() {
		
		this.setNVals();
		mw.getCommon();
		this.setOffsets(mw.comGam);
		this.drawTriangle(mw.comGam);
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

	
	protected void drawTriangle(Gamut comGam) {

		double drx = 50 + (this.gam.rX * XSCALER);
		double dry = 310 - (this.gam.rY * YSCALER);
		double dgx = 50 + (this.gam.gX * XSCALER);
		double dgy = 310 - (this.gam.gY * YSCALER);
		double dbx = 50 + (this.gam.bX * XSCALER);
		double dby = 310 - (this.gam.bY * YSCALER);

		double drXn = 50 + (this.gam.rXN * XSCALER);
		double drYn = 310 - (this.gam.rYN * YSCALER);
		double dgXn = 50 + (this.gam.gXN * XSCALER);
		double dgYn = 310 - (this.gam.gYN * YSCALER);
		double dbXn = 50 + (this.gam.bXN * XSCALER);
		double dbYn = 310 - (this.gam.bYN * YSCALER);

		Image image = new Image(this.mw.display, MainWindow.class.getResourceAsStream("/resource/cie.gif"));
		this.lblTriangleImage.setImage(image);

		GC gc = new GC(image);

		int dC = this.gam.drawColour;

		gc.setLineWidth(1);  // Draw native triangle first
	    gc.setForeground(this.mw.display.getSystemColor(SWT.COLOR_BLACK));
	    
	    gc.drawLine((int)drXn, (int)drYn, (int)dgXn, (int)dgYn);
	    gc.drawLine((int)dgXn, (int)dgYn, (int)dbXn, (int)dbYn);
	    gc.drawLine((int)dbXn, (int)dbYn, (int)drXn, (int)drYn);
	    
	    
		gc.setLineWidth(2); // Draw triangle for measured values
	    gc.setForeground(this.mw.display.getSystemColor(dC));
		
	    gc.drawLine((int)drx, (int)dry, (int)dgx, (int)dgy);
	    gc.drawLine((int)dgx, (int)dgy, (int)dbx, (int)dby);
	    gc.drawLine((int)dbx, (int)dby, (int)drx, (int)dry);

	    
	    gc.setLineWidth(1); // Draw target (offset) points
	    gc.setForeground(this.mw.display.getSystemColor(SWT.COLOR_DARK_BLUE));
	    gc.setBackground(this.mw.display.getSystemColor(SWT.COLOR_GRAY));
	    
	    int rXOS = this.gam.rXO + comGam.rX;
	    int rYOS = this.gam.rYO + comGam.rY;
	    int gXOS = this.gam.gXO + comGam.gX;
	    int gYOS = this.gam.gYO + comGam.gY;
	    int bXOS = this.gam.bXO + comGam.bX;
	    int bYOS = this.gam.bYO + comGam.bY;
	    
	    if (!Gamut.isEnclosedByRed(rXOS, rYOS, this.gam)) {
	    	gc.setBackground(this.mw.display.getSystemColor(SWT.COLOR_RED));
	    }
	    
		gc.fillOval((int)((XOFFSET + rXOS * XSCALER) - 2), (int)((YOFFSET - rYOS * YSCALER) - 2), 4, 4);
		
	    gc.setBackground(this.mw.display.getSystemColor(SWT.COLOR_GRAY));
		if (!Gamut.isEnclosedByGreen(gXOS, gYOS, this.gam)) {
	    	gc.setBackground(this.mw.display.getSystemColor(SWT.COLOR_RED));
		}
		
		gc.fillOval((int)((XOFFSET + gXOS * XSCALER) - 2), (int)((YOFFSET - gYOS * YSCALER) - 2), 4, 4);
		
	    gc.setBackground(this.mw.display.getSystemColor(SWT.COLOR_GRAY));
		if (!Gamut.isEnclosedByBlue(bXOS, bYOS, this.gam)) {
	    	gc.setBackground(this.mw.display.getSystemColor(SWT.COLOR_RED));
		}
		
		gc.fillOval((int)((XOFFSET + bXOS * XSCALER) - 2), (int)((YOFFSET - bYOS * YSCALER) - 2), 4, 4);
		gc.drawOval((int)((XOFFSET + rXOS * XSCALER) - 2), (int)((YOFFSET - rYOS * YSCALER) - 2), 4, 4);
		gc.drawOval((int)((XOFFSET + gXOS * XSCALER) - 2), (int)((YOFFSET - gYOS * YSCALER) - 2), 4, 4);
		gc.drawOval((int)((XOFFSET + bXOS * XSCALER) - 2), (int)((YOFFSET - bYOS * YSCALER) - 2), 4, 4);
		
		gc.setBackground(this.mw.display.getSystemColor(SWT.COLOR_DARK_GRAY));
		
		gc.fillOval((int)((XOFFSET + comGam.wX * XSCALER) - 2), (int)((YOFFSET - comGam.wY * YSCALER) - 2), 4, 4);
		gc.drawOval((int)((XOFFSET + comGam.wX * XSCALER) - 2), (int)((YOFFSET - comGam.wY * YSCALER) - 2), 4, 4);

	    
	    gc.setBackground(this.mw.display.getSystemColor(SWT.COLOR_WHITE));
	    
		gc.fillOval((int)((XOFFSET + this.gam.wX * XSCALER) - 2), (int)((YOFFSET - this.gam.wY * YSCALER) - 2), 4, 4);
	    gc.drawOval((int)((XOFFSET + this.gam.wX * XSCALER) - 2), (int)((YOFFSET - this.gam.wY * YSCALER) - 2), 4, 4);
	    
		gc.setLineWidth(2);
	    
		gc.fillOval((int)((XOFFSET + comGam.rX * XSCALER) - 2), (int)((YOFFSET - comGam.rY * YSCALER) - 2), 4, 4);
		gc.fillOval((int)((XOFFSET + comGam.gX * XSCALER) - 2), (int)((YOFFSET - comGam.gY * YSCALER) - 2), 4, 4);
		gc.fillOval((int)((XOFFSET + comGam.bX * XSCALER) - 2), (int)((YOFFSET - comGam.bY * YSCALER) - 2), 4, 4);

		gc.drawOval((int)((XOFFSET + comGam.rX * XSCALER) - 3), (int)((YOFFSET - comGam.rY * YSCALER) - 3), 6, 6);
		gc.drawOval((int)((XOFFSET + comGam.gX * XSCALER) - 3), (int)((YOFFSET - comGam.gY * YSCALER) - 3), 6, 6);
		gc.drawOval((int)((XOFFSET + comGam.bX * XSCALER) - 3), (int)((YOFFSET - comGam.bY * YSCALER) - 3), 6, 6);
		

		
		
	    gc.dispose();

	}
}
