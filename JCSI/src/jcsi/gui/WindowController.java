package jcsi.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowController extends WindowAdapter {

	private WindowView 	view;
	
	public WindowController(WindowView view) {
		setView(view);
	}
	
	public WindowView getView() {
		return view;
	}

	public void setView(WindowView view) {
		this.view = view;
	}
	
	@Override
	public void windowClosing (WindowEvent e) 
	{
		view.setVisible(false);
		view.dispose();		
		//System.exit(0);
	}
	
}
