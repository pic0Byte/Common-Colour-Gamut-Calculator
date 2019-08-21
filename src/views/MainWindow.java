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


public class MainWindow {

	
	final static double XSCALER = 0.316;
	final static double YSCALER = 0.326;
	final static int XOFFSET = 50;
	final static int YOFFSET = 310;
	
	private Shell shlTabby;
	private Display display;
	private Button btnNewGamut;
	private Button btnUpdate;
	private CTabFolder tabFolder;
	//private int numClass = 0;
	protected Gamut comGam, gam1, gam2, gam3, gam4, gam5, gam6, gam7, gam8, gam9, gam10;
	private HashMap<String, Gamut> hm;
	private Label lblCommonTriangle;
	private String keyPrefix = "Display ";
	private String testKey;
	private Label lblBluYComVal;
	private Label lblBluXComVal;
	private Label lblGrnYComVal;
	private Label lblGrnXComVal;
	private Label lblRedYComVal;
	private Label lblRedXComVal;
	private Label lblGamut;
	private Label lblBgY;
	private Label lblGam1BgmVal;
	private Label lblGam1BxVal;
	private Label label_1;
	private Label lblGam1BgcVal;
	private Label lblGrY;
	private Label lblGam1GrmVal;
	private Label lblGam1GxVal;
	private Label label_5;
	private Label lblGam1GrcVal;
	private Label lblRbY;
	private Label lblGam1RbmVal;
	private Label lblGam1RxVal;
	private Label label_10;
	private Label lblGam1RbcVal;
	private Label lblGamut_1;
	private Label label_3;
	private Label label_4;
	private Label label_6;
	private Label lblGam2BgmVal;
	private Label lblGam2GrmVal;
	private Label lblGam2RbmVal;
	private Label lblGam2BxVal;
	private Label lblGam2GxVal;
	private Label lblGam2RxVal;
	private Label label_14;
	private Label label_15;
	private Label label_16;
	private Label lblGam2BgcVal;
	private Label lblGam2GrcVal;
	private Label lblGam2RbcVal;
	public static Label lblBg1Bg2Y;
	public static Label lblBg1Gr2Y;
	public static Label lblBg1Rb2Y;
	public static Label lblGr1Bg2Y;
	public static Label lblGr1Gr2Y;
	public static Label lblGr1Rb2Y;
	public static Label lblRb1Bg2Y;
	public static Label lblRb1Gr2Y;
	public static Label lblRb1Rb2Y;
	public static Label lblR1y;
	public static Label lblG1y;
	public static Label lblB1y;
	public static Label lblR2y;
	public static Label lblG2y;
	public static Label lblB2y;
	public static Label lblBg1Bg2X;
	public static Label lblBg1Gr2X;
	public static Label lblBg1Rb2X;
	public static Label lblGr1Bg2X;
	public static Label lblGr1Gr2X;
	public static Label lblGr1Rb2X;
	public static Label lblRb1Bg2X;
	public static Label lblRb1Gr2X;
	public static Label lblRb1Rb2X;
	public static Label lblR1x;
	public static Label lblG1x;
	public static Label lblB1x;
	public static Label lblR2x;
	public static Label lblG2x;
	public static Label lblB2x;

	
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
		shlTabby.open();
		shlTabby.layout();
		handleEvents();
		newGamut();
		while (!shlTabby.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	
	protected void createContents() {
		shlTabby = new Shell();
		shlTabby.setSize(1234, 914);
		shlTabby.setText("Tabby2");
		shlTabby.setLayout(new FormLayout());
		
		Composite composite = new Composite(shlTabby, SWT.NONE);
		composite.setLayout(new FormLayout());
		FormData fd_composite = new FormData();
		fd_composite.left = new FormAttachment(0);
		fd_composite.right = new FormAttachment(100);
		fd_composite.top = new FormAttachment(0);
		fd_composite.bottom = new FormAttachment(0, 65);
		composite.setLayoutData(fd_composite);
		
		tabFolder = new CTabFolder(shlTabby, SWT.BORDER);
		FormData fd_tabFolder = new FormData();
		fd_tabFolder.left = new FormAttachment(composite, 10, SWT.LEFT);
		fd_tabFolder.top = new FormAttachment(composite, 2);
		fd_tabFolder.bottom = new FormAttachment(100);
		fd_tabFolder.right = new FormAttachment(100, -540);
		
		
		btnNewGamut = new Button(composite, SWT.NONE);
		FormData fd_btnNewGamut = new FormData();
		fd_btnNewGamut.top = new FormAttachment(0, 10);
		fd_btnNewGamut.left = new FormAttachment(0, 10);
		btnNewGamut.setLayoutData(fd_btnNewGamut);
		btnNewGamut.setText("Add Gamut");
		
		btnUpdate = new Button(composite, SWT.NONE);
		FormData fd_btnUpdate = new FormData();
		fd_btnUpdate.top = new FormAttachment(btnNewGamut, 0, SWT.TOP);
		fd_btnUpdate.left = new FormAttachment(btnNewGamut, 21);
		btnUpdate.setLayoutData(fd_btnUpdate);
		btnUpdate.setText("Update");
		tabFolder.setLayoutData(fd_tabFolder);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		/*Composite cmpCommon = new Composite(tabFolder, SWT.NONE);
		tbtmCommon.setControl(cmpCommon);
		
		tabFolder.setSelection(tbtmCommon);
		
		lblCommonImage = new Label(cmpCommon, SWT.NONE);
		lblCommonImage.setImage(image);
		lblCommonImage.setBounds(242, 43, 343, 355);
		
		Label lblRedX = new Label(cmpCommon, SWT.NONE);
		lblRedX.setAlignment(SWT.RIGHT);
		lblRedX.setBounds(18, 43, 55, 15);
		lblRedX.setText("Red X");
		
		Label lblRedY = new Label(cmpCommon, SWT.NONE);
		lblRedY.setText("Red Y");
		lblRedY.setAlignment(SWT.RIGHT);
		lblRedY.setBounds(18, 68, 55, 15);
		
		Label lblGrnX = new Label(cmpCommon, SWT.NONE);
		lblGrnX.setText("Green X");
		lblGrnX.setAlignment(SWT.RIGHT);
		lblGrnX.setBounds(18, 112, 55, 15);
		
		Label lblGrnY = new Label(cmpCommon, SWT.NONE);
		lblGrnY.setText("Green Y");
		lblGrnY.setAlignment(SWT.RIGHT);
		lblGrnY.setBounds(18, 137, 55, 15);
		
		Label lblBluX = new Label(cmpCommon, SWT.NONE);
		lblBluX.setText("Blue X");
		lblBluX.setAlignment(SWT.RIGHT);
		lblBluX.setBounds(18, 186, 55, 15);
		
		Label lblBluY = new Label(cmpCommon, SWT.NONE);
		lblBluY.setText("Blue Y");
		lblBluY.setAlignment(SWT.RIGHT);
		lblBluY.setBounds(18, 211, 55, 15);*/
		
		Composite cmpCom = new Composite(shlTabby, SWT.NONE);
		FormData fd_cmpCom = new FormData();
		fd_cmpCom.left = new FormAttachment(tabFolder, 6);
		fd_cmpCom.right = new FormAttachment(100);
		fd_cmpCom.top = new FormAttachment(composite, 6);
		fd_cmpCom.bottom = new FormAttachment(100, -6);
		cmpCom.setLayoutData(fd_cmpCom);
		
		Image image = new Image(display, MainWindow.class.getResourceAsStream("/resource/cie.gif"));
		
		lblCommonTriangle = new Label(cmpCom, SWT.NONE);
		lblCommonTriangle.setImage(image);
		lblCommonTriangle.setBounds(10, 10, 329, 346);
		
		Label lblCommonColourGamut = new Label(cmpCom, SWT.NONE);
		lblCommonColourGamut.setBounds(44, 383, 148, 15);
		lblCommonColourGamut.setText("Common Colour Gamut:");
		
		Label lblRedXCom = new Label(cmpCom, SWT.NONE);
		lblRedXCom.setAlignment(SWT.RIGHT);
		lblRedXCom.setBounds(44, 414, 55, 15);
		lblRedXCom.setText("Red X");
		
		Label lblRedYCom = new Label(cmpCom, SWT.NONE);
		lblRedYCom.setAlignment(SWT.RIGHT);
		lblRedYCom.setBounds(44, 434, 55, 15);
		lblRedYCom.setText("Red Y");
		
		Label lblGrnXCom = new Label(cmpCom, SWT.NONE);
		lblGrnXCom.setText("Green X");
		lblGrnXCom.setAlignment(SWT.RIGHT);
		lblGrnXCom.setBounds(44, 464, 55, 15);
		
		Label lblGrnYCom = new Label(cmpCom, SWT.NONE);
		lblGrnYCom.setText("Green Y");
		lblGrnYCom.setAlignment(SWT.RIGHT);
		lblGrnYCom.setBounds(44, 484, 55, 15);
		
		Label lblBluXCom = new Label(cmpCom, SWT.NONE);
		lblBluXCom.setText("Blue X");
		lblBluXCom.setAlignment(SWT.RIGHT);
		lblBluXCom.setBounds(44, 514, 55, 15);
		
		Label lblBluYCom = new Label(cmpCom, SWT.NONE);
		lblBluYCom.setText("Blue Y");
		lblBluYCom.setAlignment(SWT.RIGHT);
		lblBluYCom.setBounds(44, 534, 55, 15);
		
		lblRedXComVal = new Label(cmpCom, SWT.BORDER);
		lblRedXComVal.setBounds(105, 414, 55, 15);
		
		lblRedYComVal = new Label(cmpCom, SWT.BORDER);
		lblRedYComVal.setBounds(105, 434, 55, 15);
		
		lblGrnXComVal = new Label(cmpCom, SWT.BORDER);
		lblGrnXComVal.setBounds(105, 464, 55, 15);
		
		lblGrnYComVal = new Label(cmpCom, SWT.BORDER);
		lblGrnYComVal.setBounds(105, 484, 55, 15);
		
		lblBluXComVal = new Label(cmpCom, SWT.BORDER);
		lblBluXComVal.setBounds(105, 514, 55, 15);
		
		lblBluYComVal = new Label(cmpCom, SWT.BORDER);
		lblBluYComVal.setBounds(105, 534, 55, 15);
		
		lblGamut = new Label(cmpCom, SWT.NONE);
		lblGamut.setBounds(208, 383, 55, 15);
		lblGamut.setText("Gamut 1:");
		
		lblBgY = new Label(cmpCom, SWT.NONE);
		lblBgY.setAlignment(SWT.RIGHT);
		lblBgY.setBounds(193, 414, 55, 15);
		lblBgY.setText("BG: y = ");
		
		lblGam1BgmVal = new Label(cmpCom, SWT.BORDER);
		lblGam1BgmVal.setBounds(250, 414, 28, 15);
		
		lblGam1BxVal = new Label(cmpCom, SWT.BORDER);
		lblGam1BxVal.setBounds(284, 414, 28, 15);
		
		label_1 = new Label(cmpCom, SWT.NONE);
		label_1.setBounds(320, 414, 8, 15);
		label_1.setText("+");
		
		lblGam1BgcVal = new Label(cmpCom, SWT.BORDER);
		lblGam1BgcVal.setBounds(330, 414, 34, 15);
		
		lblGrY = new Label(cmpCom, SWT.NONE);
		lblGrY.setText("GR: y = ");
		lblGrY.setAlignment(SWT.RIGHT);
		lblGrY.setBounds(192, 434, 55, 15);
		
		lblGam1GrmVal = new Label(cmpCom, SWT.BORDER);
		lblGam1GrmVal.setBounds(250, 433, 28, 15);
		
		lblGam1GxVal = new Label(cmpCom, SWT.BORDER);
		lblGam1GxVal.setBounds(283, 434, 28, 15);
		
		label_5 = new Label(cmpCom, SWT.NONE);
		label_5.setText("+");
		label_5.setBounds(319, 434, 8, 15);
		
		lblGam1GrcVal = new Label(cmpCom, SWT.BORDER);
		lblGam1GrcVal.setBounds(329, 434, 34, 15);
		
		lblRbY = new Label(cmpCom, SWT.NONE);
		lblRbY.setText("RB: y = ");
		lblRbY.setAlignment(SWT.RIGHT);
		lblRbY.setBounds(193, 455, 55, 15);
		
		lblGam1RbmVal = new Label(cmpCom, SWT.BORDER);
		lblGam1RbmVal.setBounds(250, 455, 28, 15);
		
		lblGam1RxVal = new Label(cmpCom, SWT.BORDER);
		lblGam1RxVal.setBounds(284, 455, 28, 15);
		
		label_10 = new Label(cmpCom, SWT.NONE);
		label_10.setText("+");
		label_10.setBounds(320, 455, 8, 15);
		
		lblGam1RbcVal = new Label(cmpCom, SWT.BORDER);
		lblGam1RbcVal.setBounds(330, 455, 34, 15);
		
		lblGamut_1 = new Label(cmpCom, SWT.NONE);
		lblGamut_1.setText("Gamut 2:");
		lblGamut_1.setBounds(209, 487, 55, 15);
		
		label_3 = new Label(cmpCom, SWT.NONE);
		label_3.setText("BG: y = ");
		label_3.setAlignment(SWT.RIGHT);
		label_3.setBounds(194, 518, 55, 15);
		
		label_4 = new Label(cmpCom, SWT.NONE);
		label_4.setText("GR: y = ");
		label_4.setAlignment(SWT.RIGHT);
		label_4.setBounds(193, 538, 55, 15);
		
		label_6 = new Label(cmpCom, SWT.NONE);
		label_6.setText("RB: y = ");
		label_6.setAlignment(SWT.RIGHT);
		label_6.setBounds(194, 559, 55, 15);
		
		lblGam2BgmVal = new Label(cmpCom, SWT.BORDER);
		lblGam2BgmVal.setBounds(251, 518, 28, 15);
		
		lblGam2GrmVal = new Label(cmpCom, SWT.BORDER);
		lblGam2GrmVal.setBounds(251, 537, 28, 15);
		
		lblGam2RbmVal = new Label(cmpCom, SWT.BORDER);
		lblGam2RbmVal.setBounds(251, 559, 28, 15);
		
		lblGam2BxVal = new Label(cmpCom, SWT.BORDER);
		lblGam2BxVal.setBounds(285, 518, 28, 15);
		
		lblGam2GxVal = new Label(cmpCom, SWT.BORDER);
		lblGam2GxVal.setBounds(284, 538, 28, 15);
		
		lblGam2RxVal = new Label(cmpCom, SWT.BORDER);
		lblGam2RxVal.setBounds(285, 559, 28, 15);
		
		label_14 = new Label(cmpCom, SWT.NONE);
		label_14.setText("+");
		label_14.setBounds(321, 518, 8, 15);
		
		label_15 = new Label(cmpCom, SWT.NONE);
		label_15.setText("+");
		label_15.setBounds(320, 538, 8, 15);
		
		label_16 = new Label(cmpCom, SWT.NONE);
		label_16.setText("+");
		label_16.setBounds(321, 559, 8, 15);
		
		lblGam2BgcVal = new Label(cmpCom, SWT.BORDER);
		lblGam2BgcVal.setBounds(331, 518, 34, 15);
		
		lblGam2GrcVal = new Label(cmpCom, SWT.BORDER);
		lblGam2GrcVal.setBounds(330, 538, 34, 15);
		
		lblGam2RbcVal = new Label(cmpCom, SWT.BORDER);
		lblGam2RbcVal.setBounds(331, 559, 34, 15);
		
		Label lblNewLabel = new Label(cmpCom, SWT.NONE);
		lblNewLabel.setBounds(345, 52, 55, 15);
		lblNewLabel.setText("BG1/BG2");
		
		Label lblBggr = new Label(cmpCom, SWT.NONE);
		lblBggr.setText("BG1/GR2");
		lblBggr.setBounds(345, 73, 55, 15);
		
		Label lblBgrb = new Label(cmpCom, SWT.NONE);
		lblBgrb.setText("BG1/RB2");
		lblBgrb.setBounds(345, 95, 55, 15);
		
		Label lblGrbg = new Label(cmpCom, SWT.NONE);
		lblGrbg.setText("GR1/BG2");
		lblGrbg.setBounds(345, 116, 55, 15);
		
		Label lblGrgr = new Label(cmpCom, SWT.NONE);
		lblGrgr.setText("GR1/GR2");
		lblGrgr.setBounds(345, 137, 55, 15);
		
		Label lblGrrb = new Label(cmpCom, SWT.NONE);
		lblGrrb.setText("GR1/RB2");
		lblGrrb.setBounds(345, 158, 55, 15);
		
		Label lblRbbg = new Label(cmpCom, SWT.NONE);
		lblRbbg.setText("RB1/BG2");
		lblRbbg.setBounds(345, 179, 55, 15);
		
		Label lblRbgr = new Label(cmpCom, SWT.NONE);
		lblRbgr.setText("RB1/GR2");
		lblRbgr.setBounds(345, 200, 55, 15);
		
		Label lblRbrb = new Label(cmpCom, SWT.NONE);
		lblRbrb.setText("RB1/RB2");
		lblRbrb.setBounds(345, 221, 55, 15);
		
		Label lblRx = new Label(cmpCom, SWT.NONE);
		lblRx.setText("RX 1");
		lblRx.setBounds(345, 242, 55, 15);
		
		Label lblGx = new Label(cmpCom, SWT.NONE);
		lblGx.setText("GX 1");
		lblGx.setBounds(345, 263, 55, 15);
		
		Label lblBx = new Label(cmpCom, SWT.NONE);
		lblBx.setText("BX 1");
		lblBx.setBounds(345, 284, 55, 15);
		
		Label lblRx_1 = new Label(cmpCom, SWT.NONE);
		lblRx_1.setText("RX 2");
		lblRx_1.setBounds(345, 305, 55, 15);
		
		Label lblGx_1 = new Label(cmpCom, SWT.NONE);
		lblGx_1.setText("GX 2");
		lblGx_1.setBounds(345, 326, 55, 15);
		
		Label lblBx_1 = new Label(cmpCom, SWT.NONE);
		lblBx_1.setText("BX 2");
		lblBx_1.setBounds(345, 347, 55, 15);
		
		lblBg1Bg2X = new Label(cmpCom, SWT.BORDER);
		lblBg1Bg2X.setBounds(406, 52, 42, 15);
		
		lblBg1Gr2X = new Label(cmpCom, SWT.BORDER);
		lblBg1Gr2X.setBounds(406, 73, 42, 15);
		
		lblBg1Rb2X = new Label(cmpCom, SWT.BORDER);
		lblBg1Rb2X.setBounds(406, 95, 42, 15);
		
		lblGr1Bg2X = new Label(cmpCom, SWT.BORDER);
		lblGr1Bg2X.setBounds(406, 116, 42, 15);
		
		lblGr1Gr2X = new Label(cmpCom, SWT.BORDER);
		lblGr1Gr2X.setBounds(406, 137, 42, 15);
		
		lblGr1Rb2X = new Label(cmpCom, SWT.BORDER);
		lblGr1Rb2X.setBounds(406, 158, 42, 15);
		
		lblRb1Bg2X = new Label(cmpCom, SWT.BORDER);
		lblRb1Bg2X.setBounds(406, 179, 42, 15);
		
		lblRb1Gr2X = new Label(cmpCom, SWT.BORDER);
		lblRb1Gr2X.setBounds(406, 200, 42, 15);
		
		lblRb1Rb2X = new Label(cmpCom, SWT.BORDER);
		lblRb1Rb2X.setBounds(406, 221, 42, 15);
		
		lblR1x = new Label(cmpCom, SWT.BORDER);
		lblR1x.setBounds(406, 242, 42, 15);
		
		lblG1x = new Label(cmpCom, SWT.BORDER);
		lblG1x.setBounds(406, 263, 42, 15);
		
		lblB1x = new Label(cmpCom, SWT.BORDER);
		lblB1x.setBounds(406, 284, 42, 15);
		
		lblR2x = new Label(cmpCom, SWT.BORDER);
		lblR2x.setBounds(406, 305, 42, 15);
		
		lblG2x = new Label(cmpCom, SWT.BORDER);
		lblG2x.setBounds(406, 326, 42, 15);
		
		lblB2x = new Label(cmpCom, SWT.BORDER);
		lblB2x.setBounds(406, 347, 42, 15);
		
		lblBg1Bg2Y = new Label(cmpCom, SWT.BORDER);
		lblBg1Bg2Y.setBounds(466, 52, 42, 15);
		
		lblBg1Gr2Y = new Label(cmpCom, SWT.BORDER);
		lblBg1Gr2Y.setBounds(466, 73, 42, 15);
		
		lblBg1Rb2Y = new Label(cmpCom, SWT.BORDER);
		lblBg1Rb2Y.setBounds(466, 95, 42, 15);
		
		lblGr1Bg2Y = new Label(cmpCom, SWT.BORDER);
		lblGr1Bg2Y.setBounds(466, 116, 42, 15);
		
		lblGr1Gr2Y = new Label(cmpCom, SWT.BORDER);
		lblGr1Gr2Y.setBounds(466, 137, 42, 15);
		
		lblGr1Rb2Y = new Label(cmpCom, SWT.BORDER);
		lblGr1Rb2Y.setBounds(466, 158, 42, 15);
		
		lblRb1Bg2Y = new Label(cmpCom, SWT.BORDER);
		lblRb1Bg2Y.setBounds(466, 179, 42, 15);
		
		lblRb1Gr2Y = new Label(cmpCom, SWT.BORDER);
		lblRb1Gr2Y.setBounds(466, 200, 42, 15);
		
		lblRb1Rb2Y = new Label(cmpCom, SWT.BORDER);
		lblRb1Rb2Y.setBounds(466, 221, 42, 15);
		
		lblR1y = new Label(cmpCom, SWT.BORDER);
		lblR1y.setBounds(466, 242, 42, 15);
		
		lblG1y = new Label(cmpCom, SWT.BORDER);
		lblG1y.setBounds(466, 263, 42, 15);
		
		lblB1y = new Label(cmpCom, SWT.BORDER);
		lblB1y.setBounds(466, 284, 42, 15);
		
		lblR2y = new Label(cmpCom, SWT.BORDER);
		lblR2y.setBounds(466, 305, 42, 15);
		
		lblG2y = new Label(cmpCom, SWT.BORDER);
		lblG2y.setBounds(466, 326, 42, 15);
		
		lblB2y = new Label(cmpCom, SWT.BORDER);
		lblB2y.setBounds(466, 347, 42, 15);
		
		
		
		

	}

	
	protected void handleEvents() {
		
		btnNewGamut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				newGamut();
			}
		});
		
		/*tabFolder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (tabFolder.getSelection() == tbtmCommon) {
					comGam = Gamut.getCommonArea(gam1, gam2);
					drawCommon(lblCommonTriangle);
				}
			}
		});*/
		
		btnUpdate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comGam = Gamut.getCommonArea(gam1, gam2);
				drawCommon(lblCommonTriangle);
			}
		});
	}
	
	
	protected void makeGamuts() {
		
		comGam = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, SWT.COLOR_WHITE);
		
		hm = new HashMap<String, Gamut>();
		
		gam1 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, SWT.COLOR_CYAN);
		hm.put("Display 1", gam1);
		
		gam2 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, SWT.COLOR_MAGENTA);
		hm.put("Display 2", gam2);
		
		gam3 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, SWT.COLOR_YELLOW);
		hm.put("Display 3", gam3);
		
		gam4 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, 0x3);
		hm.put("Display 4", gam4);
		
		gam5 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, 0x4);
		hm.put("Display 5", gam5);
		
		gam6 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, 0x5);
		hm.put("Display 6", gam6);
		
		gam7 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, 0x1a);
		hm.put("Display 7", gam7);
		
		gam8 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, 0x8);
		hm.put("Display 8", gam8);
		
		gam9 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, 0x9);
		hm.put("Display 9", gam9);
		
		gam10 = new Gamut(Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, Gamut.EMPTY, 
				Gamut.EMPTY, Gamut.EMPTY, 0x10);
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
				
				Spinner spnRY = new Spinner(cmpNewGamut, SWT.BORDER);
				spnRY.setDigits(3);
				spnRY.setMaximum(399);
				spnRY.setMinimum(211);
				spnRY.setSelection(330);
				spnRY.setBounds(79, 66, 56, 22);
				
				Spinner spnGX = new Spinner(cmpNewGamut, SWT.BORDER);
				spnGX.setMaximum(399);
				spnGX.setMinimum(20);
				spnGX.setSelection(300);
				spnGX.setDigits(3);
				spnGX.setBounds(79, 110, 56, 22);
				
				Spinner spnGY = new Spinner(cmpNewGamut, SWT.BORDER);
				spnGY.setDigits(3);
				spnGY.setMaximum(850);
				spnGY.setMinimum(401);
				spnGY.setSelection(600);
				spnGY.setBounds(79, 135, 56, 22);
				
				Spinner spnBX = new Spinner(cmpNewGamut, SWT.BORDER);
				spnBX.setMaximum(299);
				spnBX.setMinimum(20);
				spnBX.setSelection(150);
				spnBX.setDigits(3);
				spnBX.setBounds(79, 184, 56, 22);
				
				Spinner spnBY = new Spinner(cmpNewGamut, SWT.BORDER);
				spnBY.setMaximum(209);
				spnBY.setMinimum(20);
				spnBY.setSelection(60);
				spnBY.setDigits(3);
				spnBY.setBounds(79, 209, 56, 22);
				
				Label lblRedX = new Label(cmpNewGamut, SWT.NONE);
				lblRedX.setAlignment(SWT.RIGHT);
				lblRedX.setBounds(18, 43, 55, 15);
				lblRedX.setText("Red X");
				
				Label lblRedY = new Label(cmpNewGamut, SWT.NONE);
				lblRedY.setText("Red Y");
				lblRedY.setAlignment(SWT.RIGHT);
				lblRedY.setBounds(18, 68, 55, 15);
				
				Label lblGrnX = new Label(cmpNewGamut, SWT.NONE);
				lblGrnX.setText("Green X");
				lblGrnX.setAlignment(SWT.RIGHT);
				lblGrnX.setBounds(18, 112, 55, 15);
				
				Label lblGrnY = new Label(cmpNewGamut, SWT.NONE);
				lblGrnY.setText("Green Y");
				lblGrnY.setAlignment(SWT.RIGHT);
				lblGrnY.setBounds(18, 137, 55, 15);
				
				Label lblBluX = new Label(cmpNewGamut, SWT.NONE);
				lblBluX.setText("Blue X");
				lblBluX.setAlignment(SWT.RIGHT);
				lblBluX.setBounds(18, 186, 55, 15);
				
				Label lblBluY = new Label(cmpNewGamut, SWT.NONE);
				lblBluY.setText("Blue Y");
				lblBluY.setAlignment(SWT.RIGHT);
				lblBluY.setBounds(18, 211, 55, 15);
				
				//-----------------------------------------------------end of create tab layout-----------------------------------------//
				
				//-------------------------------------------set gamut to initial spinner values----------------------------------------// 
				hm.get(testKey).rX = spnRX.getSelection();
				hm.get(testKey).rY = spnRY.getSelection();
				hm.get(testKey).gX = spnGX.getSelection();
				hm.get(testKey).gY = spnGY.getSelection();
				hm.get(testKey).bX = spnBX.getSelection();
				hm.get(testKey).bY = spnBY.getSelection();
				//Gamut.slope(hm.get(testKey));
				//----------------------------------------------------------------------------------------------------------------------//
				
				
				Image image = new Image(display, MainWindow.class.getResourceAsStream("/resource/cie.gif"));
				Label lblTriangleImage = new Label(cmpNewGamut, SWT.NONE);
				lblTriangleImage.setImage(image);
				lblTriangleImage.setBounds(242, 43, 343, 355);    //------Draw the CIE chart & gamut triangle---------------------------//
				drawTriangle(lblTriangleImage, hm.get(testKey));       //-----for the first time, & set focus on the tab---------------------//
				tabFolder.setSelection(tbtGam);
				
				final String bm = testKey;            //--testKey needs to be converted to a 'final' to be used in event handler methods//
				
				//--------------------------------add event handlers to update gamut values when spinners are changed-------------------//
				
				spnRX.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						hm.get(bm).rX = spnRX.getSelection();
						drawTriangle(lblTriangleImage, hm.get(bm));
						getCommon();
					}
				});
				
				spnRY.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						hm.get(bm).rY = spnRY.getSelection();
						drawTriangle(lblTriangleImage, hm.get(bm));
						getCommon();
					}
				});
				
				spnGX.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						hm.get(bm).gX = spnGX.getSelection();
						drawTriangle(lblTriangleImage, hm.get(bm));
						getCommon();
					}
				});
				
				spnGY.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						hm.get(bm).gY = spnGY.getSelection();
						drawTriangle(lblTriangleImage, hm.get(bm));
						getCommon();
					}
				});
				
				spnBX.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						hm.get(bm).bX = spnBX.getSelection();
						drawTriangle(lblTriangleImage, hm.get(bm));
						getCommon();
					}
				});
				
				spnBY.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						hm.get(bm).bY = spnBY.getSelection();
						drawTriangle(lblTriangleImage, hm.get(bm));
						getCommon();
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
			    
			}	
		}
		
		gc.setForeground(display.getSystemColor(comGam.drawColour));
		gc.fillOval((int)(XOFFSET + comGam.rX * XSCALER), (int)(YOFFSET - comGam.rY * YSCALER), 4, 4);
		gc.fillOval((int)(XOFFSET + comGam.gX * XSCALER), (int)(YOFFSET - comGam.gY * YSCALER), 4, 4);
		gc.fillOval((int)(XOFFSET + comGam.bX * XSCALER), (int)(YOFFSET - comGam.bY * YSCALER), 4, 4);
		
	
		gc.dispose();
		
		lblRedXComVal.setText(Integer.toString(comGam.rX));
		lblRedYComVal.setText(Integer.toString(comGam.rY));
		lblGrnXComVal.setText(Integer.toString(comGam.gX));
		lblGrnYComVal.setText(Integer.toString(comGam.gY));
		lblBluXComVal.setText(Integer.toString(comGam.bX));
		lblBluYComVal.setText(Integer.toString(comGam.bY));
		
		lblGam1BgmVal.setText(Double.toString(gam1.bgM));
		lblGam1GrmVal.setText(Double.toString(gam1.grM));
		lblGam1RbmVal.setText(Double.toString(gam1.rbM));
		lblGam2BgmVal.setText(Double.toString(gam2.bgM));
		lblGam2GrmVal.setText(Double.toString(gam2.grM));
		lblGam2RbmVal.setText(Double.toString(gam2.rbM));
		
		lblGam1BxVal.setText(Integer.toString(gam1.bX));
		lblGam1GxVal.setText(Integer.toString(gam1.gX));
		lblGam1RxVal.setText(Integer.toString(gam1.rX));
		lblGam2BxVal.setText(Integer.toString(gam2.bX));
		lblGam2GxVal.setText(Integer.toString(gam2.gX));
		lblGam2RxVal.setText(Integer.toString(gam2.rX));
		
		lblGam1BgcVal.setText(Double.toString(gam1.bgC));
		lblGam1GrcVal.setText(Double.toString(gam1.grC));
		lblGam1RbcVal.setText(Double.toString(gam1.rbC));
		lblGam2BgcVal.setText(Double.toString(gam2.bgC));
		lblGam2GrcVal.setText(Double.toString(gam2.grC));
		lblGam2RbcVal.setText(Double.toString(gam2.rbC));
		
		
		
	}


} //end of class
