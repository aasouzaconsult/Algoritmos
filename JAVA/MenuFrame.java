import java.awt.*;

public class MenuFrame extends Frame {

	MenuItem fileNew = new MenuItem("New");
	MenuItem fileOpen = new MenuItem("Open...");
	MenuItem fileSave = new MenuItem("Save");
	MenuItem fileExit = new MenuItem("Exit");
	MenuItem editUndo = new MenuItem("Undo");
	MenuItem editCut = new MenuItem("Cut");
	MenuItem editCopy = new MenuItem("Copy");
	MenuItem editPaste = new MenuItem("Paste");
	MenuItem helpContents = new MenuItem("Contents");
	MenuItem helpAbout = new MenuItem("About MenuFrame...");
	
	public MenuFrame() {
		super("Menu example");
		
		MenuBar menubar = new MenuBar();
		Menu fileMenu = new Menu("File");
		Menu editMenu = new Menu("Edit");
		Menu helpMenu = new Menu("Help");
		
		fileMenu.add(fileNew);
		fileMenu.add(fileOpen);
		fileSave.setEnabled(false);
		fileMenu.add(fileSave);
		fileMenu.addSeparator();
		fileMenu.add(fileExit);
		
		editMenu.add(editUndo);
		editMenu.addSeparator();
		editMenu.add(editCut);
		editMenu.add(editCopy);
		editMenu.add(editPaste);
		
		helpMenu.add(helpContents);
		helpMenu.addSeparator();
		helpMenu.add(helpAbout);
		
		menubar.add(fileMenu);
		menubar.add(editMenu);
		menubar.add(helpMenu);
		menubar.setHelpMenu(helpMenu);
		
		setMenuBar(menubar);
		
		setSize(new Dimension(400, 300));

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension mySize = getSize();
		
		setBounds((screenSize.width-mySize.width)/2, (screenSize.height-mySize.height)/2, mySize.width, mySize.height);
		
		show();
	}

	public static void main(String[] args) {
		MenuFrame me = new MenuFrame();
	}
}
