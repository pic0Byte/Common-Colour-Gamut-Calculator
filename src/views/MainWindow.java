package views;

import common.*;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.DisposeEvent;
import java.util.HashMap;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.CLabel;


public class MainWindow {

	
	final static double XSCALER = 0.316;
	final static double YSCALER = 0.326;
	final static int XOFFSET = 50;
	final static int YOFFSET = 310;
	
	private Shell shlCCGC;
	private Display display;
	private Button btnNewGamut;
	private CTabFolder tabFolder;
	
	private Label lblCommonTriangle;

	private Label lblRedXComVal;
	private Label lblRedYComVal;
	private Label lblGrnXComVal;
	private Label lblGrnYComVal;
	private Label lblBluXComVal;
	private Label lblBluYComVal;
	private Label lblWhtXComVal;
	private Label lblWhtYComVal;
	
	
	protected Gamut comGam, gam1, gam2, gam3, gam4, gam5, gam6, gam7, gam8, gam9, gam10;
	private HashMap<String, Gamut> hm;
	private String keyPrefix = "Display ";
	private String testKey;
	

	
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.makeGamuts();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void open() {
		display = Display.getDefault();
		createContents();
		shlCCGC.open();
		shlCCGC.layout();
		handleEvents();
		newGamut();
		getCommon();
		while (!shlCCGC.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	
	protected void createContents() {
		shlCCGC = new Shell();
		shlCCGC.setSize(1106, 720);
		shlCCGC.setText("Common Colour Gamut Calculator");
		shlCCGC.setLayout(new FormLayout());
		
		Composite composite = new Composite(shlCCGC, SWT.NONE);
		composite.setLayout(new FormLayout());
		FormData fd_composite = new FormData();
		fd_composite.left = new FormAttachment(0);
		fd_composite.right = new FormAttachment(100);
		fd_composite.top = new FormAttachment(0);
		fd_composite.bottom = new FormAttachment(0, 65);
		composite.setLayoutData(fd_composite);
		
		tabFolder = new CTabFolder(shlCCGC, SWT.BORDER);
		FormData fd_tabFolder = new FormData();
		fd_tabFolder.left = new FormAttachment(composite, 10, SWT.LEFT);
		fd_tabFolder.top = new FormAttachment(composite, 2);
		fd_tabFolder.bottom = new FormAttachment(100);
		
		
		btnNewGamut = new Button(composite, SWT.NONE);
		FormData fd_btnNewGamut = new FormData();
		fd_btnNewGamut.top = new FormAttachment(0, 10);
		fd_btnNewGamut.left = new FormAttachment(0, 10);
		btnNewGamut.setLayoutData(fd_btnNewGamut);
		btnNewGamut.setText("Add Display");
		
		
		tabFolder.setLayoutData(fd_tabFolder);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		Composite cmpCom = new Composite(shlCCGC, SWT.NONE);
		fd_tabFolder.right = new FormAttachment(cmpCom, -6);
		FormData fd_cmpCom = new FormData();
		fd_cmpCom.left = new FormAttachment(0, 717);
		fd_cmpCom.right = new FormAttachment(100);
		fd_cmpCom.top = new FormAttachment(composite, 6);
		fd_cmpCom.bottom = new FormAttachment(100, -6);
		cmpCom.setLayoutData(fd_cmpCom);
		
		Image image = new Image(display, MainWindow.class.getResourceAsStream("/resource/cie.gif"));
		
		lblCommonTriangle = new Label(cmpCom, SWT.NONE);
		lblCommonTriangle.setImage(image);
		lblCommonTriangle.setBounds(10, 66, 329, 346);
		
		Label lblCommonColourGamut = new Label(cmpCom, SWT.NONE);
		lblCommonColourGamut.setFont(SWTResourceManager.getFont("Segoe UI", 14, SWT.BOLD | SWT.ITALIC));
		lblCommonColourGamut.setBounds(51, 10, 254, 31);
		lblCommonColourGamut.setText("Common Colour Gamut:");
		
		Label lblRedXCom = new Label(cmpCom, SWT.NONE);
		lblRedXCom.setAlignment(SWT.RIGHT);
		lblRedXCom.setBounds(45, 418, 55, 15);
		lblRedXCom.setText("Red X");
		
		Label lblRedYCom = new Label(cmpCom, SWT.NONE);
		lblRedYCom.setAlignment(SWT.RIGHT);
		lblRedYCom.setBounds(45, 439, 55, 15);
		lblRedYCom.setText("Red Y");
		
		Label lblGrnXCom = new Label(cmpCom, SWT.NONE);
		lblGrnXCom.setText("Green X");
		lblGrnXCom.setAlignment(SWT.RIGHT);
		lblGrnXCom.setBounds(45, 474, 55, 15);
		
		Label lblGrnYCom = new Label(cmpCom, SWT.NONE);
		lblGrnYCom.setText("Green Y");
		lblGrnYCom.setAlignment(SWT.RIGHT);
		lblGrnYCom.setBounds(45, 495, 55, 15);
		
		Label lblBluXCom = new Label(cmpCom, SWT.NONE);
		lblBluXCom.setText("Blue X");
		lblBluXCom.setAlignment(SWT.RIGHT);
		lblBluXCom.setBounds(190, 418, 55, 15);
		
		Label lblBluYCom = new Label(cmpCom, SWT.NONE);
		lblBluYCom.setText("Blue Y");
		lblBluYCom.setAlignment(SWT.RIGHT);
		lblBluYCom.setBounds(190, 439, 55, 15);
		
		Label lblWhtXCom = new Label(cmpCom, SWT.NONE);
		lblWhtXCom.setText("White X");
		lblWhtXCom.setAlignment(SWT.RIGHT);
		lblWhtXCom.setBounds(190, 474, 55, 15);
		
		Label lblWhtYCom = new Label(cmpCom, SWT.NONE);
		lblWhtYCom.setText("White Y");
		lblWhtYCom.setAlignment(SWT.RIGHT);
		lblWhtYCom.setBounds(190, 495, 55, 15);
		
		lblRedXComVal = new Label(cmpCom, SWT.BORDER);
		lblRedXComVal.setBounds(106, 418, 55, 15);
		
		lblRedYComVal = new Label(cmpCom, SWT.BORDER);
		lblRedYComVal.setBounds(106, 438, 55, 15);
		
		lblGrnXComVal = new Label(cmpCom, SWT.BORDER);
		lblGrnXComVal.setBounds(106, 473, 55, 15);
		
		lblGrnYComVal = new Label(cmpCom, SWT.BORDER);
		lblGrnYComVal.setBounds(106, 494, 55, 15);
		
		lblBluXComVal = new Label(cmpCom, SWT.BORDER);
		lblBluXComVal.setBounds(251, 418, 55, 15);
		
		lblBluYComVal = new Label(cmpCom, SWT.BORDER);
		lblBluYComVal.setBounds(251, 438, 55, 15);
		
		lblWhtXComVal = new Label(cmpCom, SWT.BORDER);
		lblWhtXComVal.setBounds(251, 473, 55, 15);
		
		lblWhtYComVal = new Label(cmpCom, SWT.BORDER);
		lblWhtYComVal.setBounds(251, 494, 55, 15);
		
		

	}

	
	protected void handleEvents() {
		
		btnNewGamut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				newGamut();
			}
		});
		
		
	}
	
	
	protected void makeGamuts() {
		
		comGam = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, SWT.COLOR_WHITE);
		
		hm = new HashMap<String, Gamut>();
		
		gam1 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, SWT.COLOR_CYAN);
		hm.put("Display 1", gam1);
		
		gam2 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, SWT.COLOR_MAGENTA);
		hm.put("Display 2", gam2);
		
		gam3 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, SWT.COLOR_YELLOW);
		hm.put("Display 3", gam3);
		
		gam4 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 0x3);
		hm.put("Display 4", gam4);
		
		gam5 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 0x4);
		hm.put("Display 5", gam5);
		
		gam6 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 0x5);
		hm.put("Display 6", gam6);
		
		gam7 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 0x1a);
		hm.put("Display 7", gam7);
		
		gam8 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 0x8);
		hm.put("Display 8", gam8);
		
		gam9 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 0x9);
		hm.put("Display 9", gam9);
		
		gam10 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 0x10);
		hm.put("Display 10", gam10);
	}
	
	
	protected void newGamut() {
		
		CTabItem tbtGam;
		
		for (int keySuffix = 1; keySuffix < 11; keySuffix++) {
			
			testKey = keyPrefix + keySuffix;
		
			if (hm.get(testKey).rX == Gamut.EMPTY) {
				
				
				//---------------------------------Create Tab layout--------------------------------------------------------------------//
				
				tbtGam = new CTabItem(tabFolder, SWT.CLOSE);
				Composite cmpNewGamut = new Composite(tabFolder, SWT.NONE);
				tbtGam.setControl(cmpNewGamut);
				tbtGam.setText(testKey);
				
				Spinner spnRX = new Spinner(cmpNewGamut, SWT.BORDER);
				spnRX.setDigits(3);
				spnRX.setMaximum(750);
				spnRX.setMinimum(401);
				spnRX.setSelection(640);
				spnRX.setBounds(79, 41, 56, 22);
				
				Button btnLinkRx = new Button(cmpNewGamut, SWT.NONE);
				btnLinkRx.setBounds(145, 41, 25, 22);
				btnLinkRx.setImage(SWTResourceManager.getImage(MainWindow.class, "/resource/link.png"));
				
				Spinner spnRXN = new Spinner(cmpNewGamut, SWT.BORDER);
				spnRXN.setDigits(3);
				spnRXN.setMaximum(750);
				spnRXN.setMinimum(401);
				spnRXN.setSelection(640);
				spnRXN.setBounds(179, 41, 56, 22);
				
				Spinner spnRY = new Spinner(cmpNewGamut, SWT.BORDER);
				spnRY.setDigits(3);
				spnRY.setMaximum(399);
				spnRY.setMinimum(211);
				spnRY.setSelection(330);
				spnRY.setBounds(79, 66, 56, 22);
				
				Spinner spnRYN = new Spinner(cmpNewGamut, SWT.BORDER);
				spnRYN.setDigits(3);
				spnRYN.setMaximum(399);
				spnRYN.setMinimum(211);
				spnRYN.setSelection(330);
				spnRYN.setBounds(179, 66, 56, 22);
				
				Spinner spnGX = new Spinner(cmpNewGamut, SWT.BORDER);
				spnGX.setMaximum(399);
				spnGX.setMinimum(20);
				spnGX.setSelection(300);
				spnGX.setDigits(3);
				spnGX.setBounds(79, 110, 56, 22);
				
				Spinner spnGXN = new Spinner(cmpNewGamut, SWT.BORDER);
				spnGXN.setMaximum(399);
				spnGXN.setMinimum(20);
				spnGXN.setSelection(300);
				spnGXN.setDigits(3);
				spnGXN.setBounds(179, 110, 56, 22);
				
				Spinner spnGY = new Spinner(cmpNewGamut, SWT.BORDER);
				spnGY.setDigits(3);
				spnGY.setMaximum(850);
				spnGY.setMinimum(401);
				spnGY.setSelection(600);
				spnGY.setBounds(79, 135, 56, 22);
				
				Spinner spnGYN = new Spinner(cmpNewGamut, SWT.BORDER);
				spnGYN.setDigits(3);
				spnGYN.setMaximum(850);
				spnGYN.setMinimum(401);
				spnGYN.setSelection(600);
				spnGYN.setBounds(179, 135, 56, 22);
				
				Spinner spnBX = new Spinner(cmpNewGamut, SWT.BORDER);
				spnBX.setMaximum(299);
				spnBX.setMinimum(20);
				spnBX.setSelection(150);
				spnBX.setDigits(3);
				spnBX.setBounds(79, 184, 56, 22);
				
				Spinner spnBXN = new Spinner(cmpNewGamut, SWT.BORDER);
				spnBXN.setMaximum(299);
				spnBXN.setMinimum(20);
				spnBXN.setSelection(150);
				spnBXN.setDigits(3);
				spnBXN.setBounds(179, 184, 56, 22);
				
				Spinner spnBY = new Spinner(cmpNewGamut, SWT.BORDER);
				spnBY.setMaximum(209);
				spnBY.setMinimum(20);
				spnBY.setSelection(60);
				spnBY.setDigits(3);
				spnBY.setBounds(79, 209, 56, 22);
				
				Spinner spnBYN = new Spinner(cmpNewGamut, SWT.BORDER);
				spnBYN.setMaximum(209);
				spnBYN.setMinimum(20);
				spnBYN.setSelection(60);
				spnBYN.setDigits(3);
				spnBYN.setBounds(179, 209, 56, 22);
				
				Spinner spnWX = new Spinner(cmpNewGamut, SWT.BORDER);
				spnWX.setMaximum(400);
				spnWX.setMinimum(250);
				spnWX.setSelection(313);
				spnWX.setDigits(3);
				spnWX.setBounds(79, 258, 56, 22);
				
				Spinner spnWXN = new Spinner(cmpNewGamut, SWT.BORDER);
				spnWXN.setMaximum(400);
				spnWXN.setMinimum(250);
				spnWXN.setSelection(313);
				spnWXN.setDigits(3);
				spnWXN.setBounds(179, 258, 56, 22);
				
				Spinner spnWY = new Spinner(cmpNewGamut, SWT.BORDER);
				spnWY.setMaximum(400);
				spnWY.setMinimum(250);
				spnWY.setSelection(329);
				spnWY.setDigits(3);
				spnWY.setBounds(79, 283, 56, 22);
				
				Spinner spnWYN = new Spinner(cmpNewGamut, SWT.BORDER);
				spnWYN.setMaximum(400);
				spnWYN.setMinimum(250);
				spnWYN.setSelection(329);
				spnWYN.setDigits(3);
				spnWYN.setBounds(179, 283, 56, 22);
				
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
				lblRedX.setBounds(18, 43, 55, 15);
				lblRedX.setText("Red X");
				
				Label lblRedXT = new Label(cmpNewGamut, SWT.NONE);
				lblRedXT.setAlignment(SWT.RIGHT);
				lblRedXT.setBounds(18, 358, 55, 15);
				lblRedXT.setText("Red X");
				
				Label lblRedXTVal = new Label(cmpNewGamut, SWT.BORDER);
				lblRedXTVal.setAlignment(SWT.LEFT);
				lblRedXTVal.setBounds(79, 358, 55, 15);
				
				Label lblRedY = new Label(cmpNewGamut, SWT.NONE);
				lblRedY.setText("Red Y");
				lblRedY.setAlignment(SWT.RIGHT);
				lblRedY.setBounds(18, 68, 55, 15);
				
				Label lblRedYT = new Label(cmpNewGamut, SWT.NONE);
				lblRedYT.setText("Red Y");
				lblRedYT.setAlignment(SWT.RIGHT);
				lblRedYT.setBounds(18, 382, 55, 15);
				
				Label lblRedYTVal = new Label(cmpNewGamut, SWT.BORDER);
				lblRedYTVal.setAlignment(SWT.LEFT);
				lblRedYTVal.setBounds(79, 382, 55, 15);
				
				Label lblGrnX = new Label(cmpNewGamut, SWT.NONE);
				lblGrnX.setText("Green X");
				lblGrnX.setAlignment(SWT.RIGHT);
				lblGrnX.setBounds(18, 112, 55, 15);
				
				Label lblGrnXT = new Label(cmpNewGamut, SWT.NONE);
				lblGrnXT.setText("Green X");
				lblGrnXT.setAlignment(SWT.RIGHT);
				lblGrnXT.setBounds(18, 426, 55, 15);
				
				Label lblGrnXTVal = new Label(cmpNewGamut, SWT.BORDER);
				lblGrnXTVal.setAlignment(SWT.LEFT);
				lblGrnXTVal.setBounds(79, 426, 55, 15);
				
				Label lblGrnY = new Label(cmpNewGamut, SWT.NONE);
				lblGrnY.setText("Green Y");
				lblGrnY.setAlignment(SWT.RIGHT);
				lblGrnY.setBounds(18, 137, 55, 15);
				
				Label lblGrnYT = new Label(cmpNewGamut, SWT.NONE);
				lblGrnYT.setText("Green Y");
				lblGrnYT.setAlignment(SWT.RIGHT);
				lblGrnYT.setBounds(18, 450, 55, 15);
				
				Label lblGrnYTVal = new Label(cmpNewGamut, SWT.BORDER);
				lblGrnYTVal.setAlignment(SWT.LEFT);
				lblGrnYTVal.setBounds(79, 450, 55, 15);
				
				Label lblBluX = new Label(cmpNewGamut, SWT.NONE);
				lblBluX.setText("Blue X");
				lblBluX.setAlignment(SWT.RIGHT);
				lblBluX.setBounds(18, 186, 55, 15);
				
				Label lblBluXT = new Label(cmpNewGamut, SWT.NONE);
				lblBluXT.setText("Blue X");
				lblBluXT.setAlignment(SWT.RIGHT);
				lblBluXT.setBounds(130, 358, 50, 15);
				
				Label lblBluXTVal = new Label(cmpNewGamut, SWT.BORDER);
				lblBluXTVal.setAlignment(SWT.LEFT);
				lblBluXTVal.setBounds(185, 358, 55, 15);
				
				Label lblBluY = new Label(cmpNewGamut, SWT.NONE);
				lblBluY.setText("Blue Y");
				lblBluY.setAlignment(SWT.RIGHT);
				lblBluY.setBounds(18, 211, 55, 15);
				
				Label lblBluYT = new Label(cmpNewGamut, SWT.NONE);
				lblBluYT.setText("Blue X");
				lblBluYT.setAlignment(SWT.RIGHT);
				lblBluYT.setBounds(130, 382, 50, 15);
				
				Label lblBluYTVal = new Label(cmpNewGamut, SWT.BORDER);
				lblBluYTVal.setAlignment(SWT.LEFT);
				lblBluYTVal.setBounds(185, 382, 55, 15);
				
				Label lblWhtX = new Label(cmpNewGamut, SWT.NONE);
				lblWhtX.setText("White X");
				lblWhtX.setAlignment(SWT.RIGHT);
				lblWhtX.setBounds(18, 285, 55, 15);
				
				Label lblWhtXT = new Label(cmpNewGamut, SWT.NONE);
				lblWhtXT.setText("White X");
				lblWhtXT.setAlignment(SWT.RIGHT);
				lblWhtXT.setBounds(128, 426, 55, 15);
				
				Label lblWhtXTVal = new Label(cmpNewGamut, SWT.BORDER);
				lblWhtXTVal.setAlignment(SWT.LEFT);
				lblWhtXTVal.setBounds(185, 426, 55, 15);
				
				Label lblWhtY = new Label(cmpNewGamut, SWT.NONE);
				lblWhtY.setText("White Y");
				lblWhtY.setAlignment(SWT.RIGHT);
				lblWhtY.setBounds(18, 260, 55, 15);
				
				Label lblWhtYT = new Label(cmpNewGamut, SWT.NONE);
				lblWhtYT.setText("White Y");
				lblWhtYT.setAlignment(SWT.RIGHT);
				lblWhtYT.setBounds(128, 450, 55, 15);
				
				Label lblWhtYTVal = new Label(cmpNewGamut, SWT.BORDER);
				lblWhtYTVal.setAlignment(SWT.LEFT);
				lblWhtYTVal.setBounds(185, 450, 55, 15);
				
				//-----------------------------------------------------end of create tab layout-----------------------------------------//
				
				//-------------------------------------------set gamut to initial spinner values----------------------------------------// 
				hm.get(testKey).rX = spnRX.getSelection();
				hm.get(testKey).rY = spnRY.getSelection();
				hm.get(testKey).gX = spnGX.getSelection();
				hm.get(testKey).gY = spnGY.getSelection();
				hm.get(testKey).bX = spnBX.getSelection();
				hm.get(testKey).bY = spnBY.getSelection();
				hm.get(testKey).wX = spnWX.getSelection();
				hm.get(testKey).wY = spnWY.getSelection();
				
				hm.get(testKey).rXN = spnRXN.getSelection();
				hm.get(testKey).rYN = spnRYN.getSelection();
				hm.get(testKey).gXN = spnGXN.getSelection();
				hm.get(testKey).gYN = spnGYN.getSelection();
				hm.get(testKey).bXN = spnBXN.getSelection();
				hm.get(testKey).bYN = spnBYN.getSelection();
				hm.get(testKey).wXN = spnWXN.getSelection();
				hm.get(testKey).wYN = spnWYN.getSelection();
				
				//getCommon();
				
				Gamut.updateNative(hm.get(testKey));
				lblRedXTVal.setText(Integer.toString(hm.get(testKey).rXO + comGam.rX));
				lblRedYTVal.setText(Integer.toString(hm.get(testKey).rYO + comGam.rY));
				lblGrnXTVal.setText(Integer.toString(hm.get(testKey).gXO + comGam.gX));
				lblGrnYTVal.setText(Integer.toString(hm.get(testKey).gYO + comGam.gY));
				lblBluXTVal.setText(Integer.toString(hm.get(testKey).bXO + comGam.bX));
				lblBluYTVal.setText(Integer.toString(hm.get(testKey).bYO + comGam.bX));
				//----------------------------------------------------------------------------------------------------------------------//
				
				
				Image image = new Image(display, MainWindow.class.getResourceAsStream("/resource/cie.gif"));
				Label lblTriangleImage = new Label(cmpNewGamut, SWT.NONE);
				lblTriangleImage.setImage(image);
				lblTriangleImage.setBounds(242, 43, 343, 355);    //------Draw the CIE chart & gamut triangle---------------------------//
				drawTriangle(lblTriangleImage, hm.get(testKey));       //-----for the first time, & set focus on the tab---------------------//
				tabFolder.setSelection(tbtGam);
				
				final String bm = testKey;            //--testKey needs to be converted to a 'final' to be used in event handler methods//
				Gamut eventGam = hm.get(testKey);
				
				//--------------------------------add event handlers to update gamut values when spinners are changed-------------------//
				
		
				tabFolder.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						if (tabFolder.getSelection() == tbtGam) {
							eventGam.rXN = spnRXN.getSelection();
							eventGam.rYN = spnRYN.getSelection();
							eventGam.gXN = spnGXN.getSelection();
							eventGam.gYN = spnGYN.getSelection();
							eventGam.bXN = spnBXN.getSelection();
							eventGam.bYN = spnBYN.getSelection();
							Gamut.updateNative(eventGam);
							lblRedXTVal.setText(Integer.toString(eventGam.rXO + comGam.rX));
							lblRedYTVal.setText(Integer.toString(eventGam.rYO + comGam.rY));
							lblGrnXTVal.setText(Integer.toString(eventGam.gXO + comGam.gX));
							lblGrnYTVal.setText(Integer.toString(eventGam.gYO + comGam.gY));
							lblBluXTVal.setText(Integer.toString(eventGam.bXO + comGam.bX));
							lblBluYTVal.setText(Integer.toString(eventGam.bYO + comGam.bX));
						}
					}
				});
				
				spnRX.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.rX = spnRX.getSelection();
						eventGam.rXN = spnRXN.getSelection();
						Gamut.updateNative(eventGam);
						lblRedXTVal.setText(Integer.toString(eventGam.rXO + comGam.rX));
						drawTriangle(lblTriangleImage, eventGam);
						getCommon();
					}
				});
				
				
				spnRY.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.rY = spnRY.getSelection();
						eventGam.rYN = spnRYN.getSelection();
						Gamut.updateNative(eventGam);
						lblRedYTVal.setText(Integer.toString(eventGam.rYO + comGam.rY));
						drawTriangle(lblTriangleImage, eventGam);
						getCommon();
					}
				});
				
				spnGX.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.gX = spnGX.getSelection();
						eventGam.gXN = spnGXN.getSelection();
						Gamut.updateNative(eventGam);
						lblGrnXTVal.setText(Integer.toString(eventGam.gXO + comGam.gX));
						drawTriangle(lblTriangleImage, eventGam);
						getCommon();
					}
				});
				
				spnGY.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.gY = spnGY.getSelection();
						eventGam.gYN = spnGYN.getSelection();
						Gamut.updateNative(eventGam);
						lblGrnYTVal.setText(Integer.toString(eventGam.gYO + comGam.gY));
						drawTriangle(lblTriangleImage, eventGam);
						getCommon();
					}
				});
				
				spnBX.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.bX = spnBX.getSelection();
						eventGam.bXN = spnBXN.getSelection();
						Gamut.updateNative(eventGam);
						lblBluXTVal.setText(Integer.toString(eventGam.bXO + comGam.bX));
						drawTriangle(lblTriangleImage, eventGam);
						getCommon();
					}
				});
				
				spnBY.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.bY = spnBY.getSelection();
						eventGam.bYN = spnBYN.getSelection();
						Gamut.updateNative(eventGam);
						lblBluYTVal.setText(Integer.toString(eventGam.bYO + comGam.bY));
						drawTriangle(lblTriangleImage, eventGam);
						getCommon();
					}
				});
				
				spnWX.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.wX = spnWX.getSelection();
						eventGam.wXN = spnWXN.getSelection();
						Gamut.updateNative(eventGam);
						lblWhtXTVal.setText(Integer.toString(eventGam.wXO + comGam.wX));
						drawTriangle(lblTriangleImage, eventGam);
						getCommon();
					}
				});
				
				spnWY.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.wY = spnWY.getSelection();
						eventGam.wYN = spnWYN.getSelection();
						Gamut.updateNative(eventGam);
						lblWhtYTVal.setText(Integer.toString(eventGam.wYO + comGam.wY));
						drawTriangle(lblTriangleImage, eventGam);
						getCommon();
					}
				});
				
				spnRXN.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.rXN = spnRXN.getSelection();
						Gamut.updateNative(eventGam);
						lblRedXTVal.setText(Integer.toString (eventGam.rXO + comGam.rX));
					}
				});
				
				spnRYN.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.rYN = spnRYN.getSelection();
						Gamut.updateNative(eventGam);
						lblRedYTVal.setText(Integer.toString (eventGam.rYO + comGam.rY));
					}
				});
				
				spnGXN.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.gXN = spnGXN.getSelection();
						Gamut.updateNative(eventGam);
						lblGrnXTVal.setText(Integer.toString (eventGam.gXO + comGam.gX));
					}
				});
				
				spnGYN.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.gYN = spnGYN.getSelection();
						Gamut.updateNative(eventGam);
						lblGrnYTVal.setText(Integer.toString (eventGam.gYO + comGam.gY));
					}
				});
				
				spnBXN.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.bXN = spnBXN.getSelection();
						Gamut.updateNative(eventGam);
						lblBluXTVal.setText(Integer.toString (eventGam.bXO + comGam.bX));
					}
				});
				
				spnBYN.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						eventGam.bYN = spnBYN.getSelection();
						Gamut.updateNative(eventGam);
						lblBluYTVal.setText(Integer.toString (eventGam.bYO + comGam.bY));
					}
				});
				//----------------------------------------------------------------------------------------------------------------------//
				
				
				
				tbtGam.addDisposeListener(new DisposeListener() {           //----set gamut back to all zero values if tab is closed----//
					public void widgetDisposed(DisposeEvent arg0) {
						hm.get(bm).rX = Gamut.EMPTY;
						hm.get(bm).rY = Gamut.EMPTY;
						hm.get(bm).gX = Gamut.EMPTY;
						hm.get(bm).gY = Gamut.EMPTY;
						hm.get(bm).bX = Gamut.EMPTY;
						hm.get(bm).bY = Gamut.EMPTY;
						
					}
				});
				
				break;
				
			}
			
		}
		
		//MessageBox mb = new MessageBox(shlTabby, SWT.ICON_WARNING);
	}
	
	
	protected void drawTriangle(Label label, Gamut gam) {
		
		double drx = 50 + (gam.rX * 0.316);
		double dry = 310 - (gam.rY * 0.326);
		double dgx = 50 + (gam.gX * 0.316);
		double dgy = 310 - (gam.gY * 0.326);
		double dbx = 50 + (gam.bX * 0.316);
		double dby = 310 - (gam.bY * 0.326);
		
		Image image = new Image(display, MainWindow.class.getResourceAsStream("/resource/cie.gif"));
		label.setImage(image);

		GC gc = new GC(image);
		
		int dC = gam.drawColour;
		
		gc.setForeground(display.getSystemColor(dC));
	    gc.drawLine((int)drx, (int)dry, (int)dgx, (int)dgy);
	    gc.drawLine((int)dgx, (int)dgy, (int)dbx, (int)dby);
	    gc.drawLine((int)dbx, (int)dby, (int)drx, (int)dry);
	    
	    //image.dispose();
	    gc.dispose();
		
	}
	
	
	protected void getCommon() {
		
		boolean firstGamut = true;
		
		for (int keySuffix = 1; keySuffix < 11; keySuffix++) {
			
			testKey = keyPrefix + keySuffix;
		
			if (hm.get(testKey).rX != Gamut.EMPTY) {
				
				if (firstGamut) {
					comGam = hm.get(testKey);
					firstGamut = false;
					
				} else {
					
					comGam = Gamut.getCommonArea(comGam, hm.get(testKey));
				}
			}
		}
		drawCommon(lblCommonTriangle);
	}
	
	
	protected void drawCommon(Label label) {
		
		
		Image image = new Image(display, MainWindow.class.getResourceAsStream("/resource/cie.gif"));
		label.setImage(image);
		GC gc = new GC(image);
		
		int avgX = 0;
		int avgY = 0;
		int count = 0;
		
		for (int keySuffix = 1; keySuffix < 11; keySuffix++) {
			
			testKey = keyPrefix + keySuffix;
		
			if (hm.get(testKey).rX != Gamut.EMPTY) {
				
				double drx = 50 + (hm.get(testKey).rX * 0.316);
				double dry = 310 - (hm.get(testKey).rY * 0.326);
				double dgx = 50 + (hm.get(testKey).gX * 0.316);
				double dgy = 310 - (hm.get(testKey).gY * 0.326);
				double dbx = 50 + (hm.get(testKey).bX * 0.316);
				double dby = 310 - (hm.get(testKey).bY * 0.326);
				
				int x = hm.get(testKey).drawColour;
				
				gc.setForeground(display.getSystemColor(x));
			    gc.drawLine((int)drx, (int)dry, (int)dgx, (int)dgy);
			    gc.drawLine((int)dgx, (int)dgy, (int)dbx, (int)dby);
			    gc.drawLine((int)dbx, (int)dby, (int)drx, (int)dry);
			    gc.setForeground(display.getSystemColor(SWT.COLOR_DARK_BLUE));
			    gc.fillOval((int)(XOFFSET + hm.get(testKey).wX * XSCALER), (int)(YOFFSET - hm.get(testKey).wY * YSCALER), 4, 4);
			    gc.drawOval((int)(XOFFSET + hm.get(testKey).wX * XSCALER), (int)(YOFFSET - hm.get(testKey).wY * YSCALER), 4, 4);
			    
			    avgX = avgX + hm.get(testKey).wX;
			    avgY = avgY + hm.get(testKey).wY;
			    count ++;
			   
			    
			}	
		}
		
		gc.setForeground(display.getSystemColor(SWT.COLOR_DARK_BLUE));
		gc.fillOval((int)((XOFFSET + comGam.rX * XSCALER) - 2), (int)((YOFFSET - comGam.rY * YSCALER) - 2), 4, 4);
		gc.fillOval((int)((XOFFSET + comGam.gX * XSCALER) - 2), (int)((YOFFSET - comGam.gY * YSCALER) - 2), 4, 4);
		gc.fillOval((int)((XOFFSET + comGam.bX * XSCALER) - 2), (int)((YOFFSET - comGam.bY * YSCALER) - 2), 4, 4);
		gc.drawOval((int)((XOFFSET + comGam.rX * XSCALER) - 2), (int)((YOFFSET - comGam.rY * YSCALER) - 2), 4, 4);
		gc.drawOval((int)((XOFFSET + comGam.gX * XSCALER) - 2), (int)((YOFFSET - comGam.gY * YSCALER) - 2), 4, 4);
		gc.drawOval((int)((XOFFSET + comGam.bX * XSCALER) - 2), (int)((YOFFSET - comGam.bY * YSCALER) - 2), 4, 4);
	
		gc.dispose();
		
		
		comGam.wX = avgX / count;
		comGam.wY = avgY / count;
		
		lblRedXComVal.setText(Integer.toString(comGam.rX));
		lblRedYComVal.setText(Integer.toString(comGam.rY));
		lblGrnXComVal.setText(Integer.toString(comGam.gX));
		lblGrnYComVal.setText(Integer.toString(comGam.gY));
		lblBluXComVal.setText(Integer.toString(comGam.bX));
		lblBluYComVal.setText(Integer.toString(comGam.bY));
		lblWhtXComVal.setText(Integer.toString(comGam.wX));
		lblWhtYComVal.setText(Integer.toString(comGam.wY));
		
		
	}
} //end of class
