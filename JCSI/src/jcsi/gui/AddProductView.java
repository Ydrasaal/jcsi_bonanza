package jcsi.gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import jcsi.dataAccess.CRUD.CRUDManager;
import jcsi.dataAccess.DAO.CategoryDAO;
import jcsi.exception.DAOException;
import jcsi.log.UniLogger;
import jcsi.orm.entity.Category;
import jcsi.orm.entity.Product;

public class AddProductView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextArea productName;
	private JTextArea price;
	private JTextArea categorName;

	public AddProductView() {
		super("Adding a Product");
		this.setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		buildFormArea(new JPanel());
	}
	
	private void buildFormArea(JPanel panel) {
		panel.setLayout(null);
		panel.setBounds(0, 0, this.getX(), this.getY());
		buildButton(new JButton(), "Confirm", new Rectangle(510, 5, 100, 45), panel);
		
		productName = new JTextArea();
		productName.setBounds(1, 30, 160, 20);
		
		JLabel nameLabel = new JLabel("Product Name:");
		nameLabel.setBounds(1, 10, 160, 19);
		
		price = new JTextArea();
		price.setBounds(170, 30, 160, 20);
		
		JLabel priceLabel = new JLabel("Price:");
		priceLabel.setBounds(170, 10, 160, 19);
		
		categorName = new JTextArea();
		categorName.setBounds(340, 30, 160, 20);
		
		JLabel catNameLabel = new JLabel("Category:");
		catNameLabel.setBounds(340, 10, 160, 19);
		
		panel.add(productName);
		panel.add(nameLabel);
		panel.add(price);
		panel.add(priceLabel);
		panel.add(categorName);
		panel.add(catNameLabel);
		this.add(panel);
	}
	
	private void buildButton(JButton button, String name, Rectangle dim , JPanel panel) {
		 button = new JButton(name);
		 button.setBounds(dim);
		 button.addActionListener(this);
		 panel.add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			Product p = new Product();
			p.setName(this.productName.getText());
			p.setPrice(new Double(this.price.getText()));
			Category c = null;
			try {
				c = CategoryDAO.INSTANCE.getByName(this.categorName.getText());
			} catch(DAOException e) {}
			if (c == null) {
				c = new Category();
				c.setName(this.categorName.getText());
			}
			p.setCategory(c);
			CRUDManager.createOrUpdate(p);
		} catch(DAOException e) {
			UniLogger.INSTANCE.info("Couldn't add new product");
		}
	}

}
