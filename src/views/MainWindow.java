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
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.wb.swt.SWTResourceManager;


public class MainWindow {


	final static double XSCALER = 0.316;
	final static double YSCALER = 0.326;
	final static int XOFFSET = 50;
	final static int YOFFSET = 310;
	
	public MainWindow mw = this;
	private Shell shlCCGC;
	public Display display;
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


	public Gamut comGam, gam1, gam2, gam3, gam4, gam5, gam6, gam7, gam8, gam9, gam10;
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


	private void open() {
		display = Display.getDefault();
		createContents();
		shlCCGC.open();
		shlCCGC.layout();
		handleEvents();
		newGamut();
		while (!shlCCGC.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}


	private void createContents() {
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


	private void handleEvents() {

		btnNewGamut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				newGamut();
			}
		});


	}


	private void makeGamuts() {

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


	private void newGamut() {

		CTabItem tbtGam;

		for (int keySuffix = 1; keySuffix < 11; keySuffix++) {

			testKey = keyPrefix + keySuffix;

			if (hm.get(testKey).rX == Gamut.EMPTY) {
				

				tbtGam = new CTabItem(tabFolder, SWT.CLOSE);
				Composite cmpNewGamut = new Composite(tabFolder, SWT.NONE);
				tbtGam.setControl(cmpNewGamut);
				tbtGam.setText(testKey);
				
				
				TabContents tabContents = new TabContents(cmpNewGamut, (hm.get(testKey)), mw);								
				Gamut refGam = hm.get(testKey);

				
				tabContents.setVals();
				getCommon();
				tabContents.setOffsets(comGam);
				tabContents.drawTriangle(comGam);    
				tabFolder.setSelection(tbtGam);

				//--------------------------------add event handlers ---------------------//

				tabFolder.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						if (tabFolder.getSelection() == tbtGam) {
							
							tabContents.updateTab();
						}
					}
				});

				tbtGam.addDisposeListener(new DisposeListener() {           //----set gamut back to all zero values if tab is closed----//
					public void widgetDisposed(DisposeEvent arg0) {
						refGam.rX = Gamut.EMPTY;
						refGam.rY = Gamut.EMPTY;
						refGam.gX = Gamut.EMPTY;
						refGam.gY = Gamut.EMPTY;
						refGam.bX = Gamut.EMPTY;
						refGam.bY = Gamut.EMPTY;
						refGam.wX = Gamut.EMPTY;
						refGam.wY = Gamut.EMPTY;
						refGam.nativeLinked = true;

					}
				});

				//----------------------------------------------------------------------------------------------------------------------//

				break;

			} else if (keySuffix == 10){

				MessageBox mb = new MessageBox(shlCCGC, SWT.ICON_WARNING);
				mb.setMessage("You have angered Satan!");
				mb.open();
			}

		}

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


	private void drawCommon(Label label) {


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
				gc.setLineWidth(2);
			    gc.drawLine((int)drx, (int)dry, (int)dgx, (int)dgy);
			    gc.drawLine((int)dgx, (int)dgy, (int)dbx, (int)dby);
			    gc.drawLine((int)dbx, (int)dby, (int)drx, (int)dry);
			    gc.setLineWidth(1);
			    gc.setForeground(display.getSystemColor(SWT.COLOR_DARK_BLUE));
			    gc.fillOval((int)((XOFFSET + hm.get(testKey).wX * XSCALER) - 2), (int)((YOFFSET - hm.get(testKey).wY * YSCALER) - 2), 4, 4);
			    gc.drawOval((int)((XOFFSET + hm.get(testKey).wX * XSCALER) - 2), (int)((YOFFSET - hm.get(testKey).wY * YSCALER) - 2), 4, 4);

			    avgX = avgX + hm.get(testKey).wX;
			    avgY = avgY + hm.get(testKey).wY;
			    count ++;


			}
		}

		gc.setForeground(display.getSystemColor(SWT.COLOR_DARK_BLUE));
		gc.fillOval((int)((XOFFSET + comGam.rX * XSCALER) - 2), (int)((YOFFSET - comGam.rY * YSCALER) - 2), 4, 4);
		gc.fillOval((int)((XOFFSET + comGam.gX * XSCALER) - 2), (int)((YOFFSET - comGam.gY * YSCALER) - 2), 4, 4);
		gc.fillOval((int)((XOFFSET + comGam.bX * XSCALER) - 2), (int)((YOFFSET - comGam.bY * YSCALER) - 2), 4, 4);
		gc.setLineWidth(2);
		gc.drawOval((int)((XOFFSET + comGam.rX * XSCALER) - 3), (int)((YOFFSET - comGam.rY * YSCALER) - 3), 6, 6);
		gc.drawOval((int)((XOFFSET + comGam.gX * XSCALER) - 3), (int)((YOFFSET - comGam.gY * YSCALER) - 3), 6, 6);
		gc.drawOval((int)((XOFFSET + comGam.bX * XSCALER) - 3), (int)((YOFFSET - comGam.bY * YSCALER) - 3), 6, 6);

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
