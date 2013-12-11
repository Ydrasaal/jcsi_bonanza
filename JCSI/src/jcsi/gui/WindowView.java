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
import jcsi.dataAccess.DAO.CategoryDAO;
import jcsi.dataAccess.DAO.ClientDAO;
import jcsi.exception.ObjectQueryException;
import jcsi.log.UniLogger;
import jcsi.orm.entity.Category;
import jcsi.orm.entity.Client;

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
		buildButton(new JButton(), "Afficher Categories", new Rectangle(50 + buttonWidth + 10, 0, buttonWidth, buttonHeight), panel);
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
        UniLogger log = UniLogger.getInstance();
        log.info("Adding new Client");
        AddClientView clView = new AddClientView();
        
        clView.setSize(460, 250);
    	clView.setLocation(500, 150);
    	clView.setVisible(true);
    }
	
	public static void AddProduit() {
		UniLogger log = UniLogger.getInstance();
		log.info("Adding new Product");
		AddProductView pView = new AddProductView();
	        
		pView.setSize(640, 100);
		pView.setLocation(500, 150);
		pView.setVisible(true);
	}
	
	public static void AfficherClients() {
		UniLogger log = UniLogger.getInstance();
		log.info("Dumping Clients");
		List<Client> l = ClientDAO.INSTANCE.getAll();
		for (Client c : l) {
			log.info(c.toString());
		}
	}
	
	public static void AfficherCategories() {
		UniLogger log = UniLogger.getInstance();
		log.info("Dumping Categories");
		List<Category> l = CategoryDAO.INSTANCE.getAll();
		for (Category c : l) {
			log.info(c.toString());
		}
		//TODO Remplacer par category
	}

	@SuppressWarnings("rawtypes")
	public static void ConfirmQuery() {
		UniLogger log = UniLogger.getInstance();
		log.info("Requesting Query");
		String sQuery;
		if ((sQuery = query.getText()).length() > 0) {
			System.out.println(sQuery);
			try {
				List l = CRUDManager.query(sQuery);
				log.info(l.toString());
			} catch(ObjectQueryException e) {
				log.error(e.getMessage());
			}
		}
	}
}
