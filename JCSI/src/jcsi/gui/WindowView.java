package jcsi.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class WindowView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JDesktopPane	desk;	
	private JToolBar	toolBar;
	private JMenuBar	menuBar;
	private JMenu menuAbout;
	private JMenuItem menuAboutContent;
	public JButton clientButton;

	public WindowView() {
		super("JCSI");
		buildDesktopPane();
		buildToolbarAndMenu();
		buildButton(clientButton, "Add Client");
	}
	
	public void buildButton(JButton button, String name) {
		 button = new JButton(name);
		 button.setVerticalAlignment(AbstractButton.CENTER);
		 button.setHorizontalAlignment(AbstractButton.LEFT);
		 button.setMnemonic(KeyEvent.VK_D);
		 this.add(button);
	}
	
	public void buildDesktopPane()
	{	 
		this.desk = new JDesktopPane();
		this.getContentPane().add(desk, BorderLayout.CENTER);
		//desk.putClientProperty("JDesktopPane.dragMode", "faster");
		this.addWindowListener(new WindowController(this));
	}
	
	public void buildToolbarAndMenu()
	{
		this.menuBar = new JMenuBar();
		this.toolBar = new JToolBar(SwingConstants.HORIZONTAL);

		toolBar.putClientProperty("JToolbar.isRollover", Boolean.TRUE);

		menuAbout = new JMenu("About");	
		menuAboutContent = new JMenuItem("About JCSI");
		
		menuAbout.add(menuAboutContent);
		menuBar.add(menuAbout);				
		
		this.setJMenuBar(menuBar);
		this.getContentPane().add(toolBar, BorderLayout.NORTH);	
		menuAboutContent.addActionListener(new ActionListener()	{
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getParent(), "L'objectif est de contrôler vos capacités à "
						+ "implémenter de façon cohérente une architecture objet et pour ce premier projet Java,\n"
						+ "une couche d'accès à la base de données.\nEn quelque sorte, cela revient à préparer la couche "
						+ "d'accès aux données de votre futur projet EpiMarket,\nmême si jCSI se veut être un projet autonome."); 
			}
		});
		
		
	}

}
