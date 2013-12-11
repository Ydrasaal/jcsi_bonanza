package jcsi.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

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

import jcsi.dataAccess.CRUD.CRUDManager;
import jcsi.dataAccess.DAO.ClientDAO;
import jcsi.dataAccess.DAO.ProductDAO;
import jcsi.exception.DAOException;
import jcsi.log.UniLogger;
import jcsi.orm.entity.Client;
import jcsi.orm.entity.Product;

public class WindowView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final int buttonWidth = 150;
	private final int buttonHeight = 50;
	
	private static HashMap<JButton, Method> buttonMap;
	private JDesktopPane	desk;	
	private static JTextArea query;
	private JToolBar	toolBar;
	private JMenuBar	menuBar;
	private JMenu menuAbout;
	private JMenuItem menuAboutContent;
	public JTextArea log;
	private JScrollPane scroll; 
	
	public WindowView() {
		super("JCSI");

		buttonMap = new HashMap<JButton, Method>();
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
		buildButton(new JButton(), "Afficher Produits", new Rectangle(50 + buttonWidth + 10, 0, buttonWidth, buttonHeight), panel);
		this.add(panel);
	}

	private void buildHeadPanel(JPanel panel) {
		panel.setLayout(null);
		panel.setBounds(0, 0, this.getX(), 55);
		buildButton(new JButton(), "Add Client", new Rectangle(100, 0, buttonWidth, buttonHeight), panel);
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
		 button.addActionListener(this);
		 try {
			System.out.println(button.getText().replaceAll("\\s+",""));
			buttonMap.put(button, WindowView.class.getMethod(button.getText().replaceAll("\\s+","")));
		 } catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		 }
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

	@Override
	public synchronized void actionPerformed(ActionEvent event) {
		try {
			buttonMap.get(event.getSource()).invoke(null);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	public static void AddClient() {
        UniLogger.INSTANCE.info("Adding new Client");
        AddClientView clView = new AddClientView();
        
        clView.setSize(460, 250);
    	clView.setLocation(500, 150);
    	clView.setVisible(true);
    }
	
	public static void AddProduit() {
		UniLogger.INSTANCE.info("Adding new Product");
		AddProductView pView = new AddProductView();
	        
		pView.setSize(640, 100);
		pView.setLocation(500, 150);
		pView.setVisible(true);
	}
	
	public static void AfficherClients() {
		try {
			UniLogger.INSTANCE.info("Dumping Clients");
			List<Client> l = ClientDAO.INSTANCE.getAll();
			for (Client c : l) {
				UniLogger.INSTANCE.info(c.toString());
			}
		} catch(DAOException e) {
			UniLogger.INSTANCE.error("Couldn't display client list");
		}
	}
	
	public static void AfficherProduits() {
		try {
			UniLogger.INSTANCE.info("Dumping Products");
			List<Product> l = ProductDAO.INSTANCE.getAll();
			for (Product c : l) {
				UniLogger.INSTANCE.info(c.toString());
			}
		} catch(DAOException e) {
			UniLogger.INSTANCE.error("Couldn't display product list");
		}

	}

	@SuppressWarnings("rawtypes")
	public static void ConfirmQuery() {
		UniLogger.INSTANCE.info("Requesting Query");
		String sQuery;
		if ((sQuery = query.getText()).length() > 0) {
			System.out.println(sQuery);
			try {
				List l = CRUDManager.query(sQuery);
				UniLogger.INSTANCE.info(l.toString());
			} catch(Exception e) {
				UniLogger.INSTANCE.error(e.getMessage());
			}
		}
	}
}
