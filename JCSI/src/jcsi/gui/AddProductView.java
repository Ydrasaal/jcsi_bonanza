package jcsi.gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AddProductView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextArea productName;
	private JTextArea price;

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
		buildButton(new JButton(), "Confirm", new Rectangle(340, 5, 100, 45), panel);
		
		productName = new JTextArea();
		productName.setBounds(1, 30, 160, 20);
		
		JLabel nameLabel = new JLabel("Product Name:");
		nameLabel.setBounds(1, 10, 160, 19);
		
		price = new JTextArea();
		price.setBounds(170, 30, 160, 20);
		
		JLabel priceLabel = new JLabel("Price:");
		priceLabel.setBounds(170, 10, 160, 19);
		
		panel.add(productName);
		panel.add(nameLabel);
		panel.add(price);
		panel.add(priceLabel);
		
		this.add(panel);
	}
	
	private void buildButton(JButton button, String name, Rectangle dim , JPanel panel) {
		 button = new JButton(name);
		 button.setBounds(dim);
		 button.addActionListener(this);
		 panel.add(button);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
