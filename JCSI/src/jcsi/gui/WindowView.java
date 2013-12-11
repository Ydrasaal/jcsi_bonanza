package jcsi.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;

import org.apache.log4j.Logger;

public class WindowView extends JFrame {

	private static final long serialVersionUID = 1L;
	private final int buttonWidth = 150;
	private final int buttonHeight = 50;
	
	private static HashMap<String, JButton> buttonMap;
	private JDesktopPane	desk;	
	private JTextArea query;
	private JToolBar	toolBar;
	private JMenuBar	menuBar;
	private JMenu menuAbout;
	private JMenuItem menuAboutContent;
	public JTextArea log;
	private JScrollPane scroll; 
	
	public WindowView() {
		super("JCSI");

		buttonMap = new HashMap<String, JButton>();
		this.setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		buildHeadPanel(new JPanel());
		buildDataPanel(new JPanel());
		buildDesktopPane();
		buildLogPanel(new JPanel());
		buildToolbarAndMenu();
		buildQueryArea(new JPanel());
	}
	
	private void buildLogPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBounds(0, 300, this.getX(), 225);
		log = new JTextArea();
		DefaultCaret caret = (DefaultCaret)log.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		log.setEditable(false);
		log.setBounds(10, 10, 780, 260);
		log.setBorder(new LineBorder(Color.GRAY, 1, false));
		panel.add(log);
		scroll = new JScrollPane(log);
		scroll.setBounds(10, 10, 780, 210);
		panel.add(scroll);
		this.add(panel);
	}

	private void buildDataPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBounds(0, 60, this.getX(), 55);
		buildButton(new JButton(), "Afficher Clients", new Rectangle(50, 0, buttonWidth, buttonHeight), panel);
		buildButton(new JButton(), "Afficher Paniers", new Rectangle(50 + buttonWidth + 10, 0, buttonWidth, buttonHeight), panel);
		this.add(panel);
	}

	private void buildHeadPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBounds(0, 0, this.getX(), 55);
		buildButton(new JButton(), "Add Client", new Rectangle(100, 0, buttonWidth, buttonHeight), panel);
		buildButton(new JButton(), "Add Panier", new Rectangle(100 + buttonWidth + 10, 0, buttonWidth, buttonHeight), panel);
		buildButton(new JButton(), "Add Produit", new Rectangle(100 + (2 * (buttonWidth + 10)), 0, buttonWidth, buttonHeight), panel);
		this.add(panel);
	}

	private void buildQueryArea(JPanel panel) {
		panel.setLayout(null);
		panel.setBounds(0, 130, this.getX(), 100);
		buildButton(new JButton(), "Confirm Query", new Rectangle(500, 0, buttonWidth, buttonHeight), panel);
		query = new JTextArea();
		query.setBounds(100, 0, 380, 80);
		panel.add(query);
		this.add(panel);
	}

	public void buildButton(JButton button, String name, Rectangle dim , JPanel panel) {
		 button = new JButton(name);
		 button.setBounds(dim);
		 buttonMap.put(name, button);
		 panel.add(button);
	}
	
	public void buildDesktopPane()
	{	 
		this.desk = new JDesktopPane();
		this.getContentPane().add(desk, BorderLayout.CENTER);
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
	
	public void buildListeners() {
		buttonMap.get("Confirm Query").addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(query.getText());
				Logger logg = Logger.getLogger(this.getClass().getName());
				logg.info("Event !!");
			}
			
		});
	}
	
}
