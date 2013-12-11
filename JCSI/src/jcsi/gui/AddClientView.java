package jcsi.gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AddClientView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextArea firstName;
	private JTextArea lastName;
	private JTextArea tel;
	private JTextArea mail;

	public AddClientView() {
		super("Adding a Client");
		this.setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		buildFormArea(new JPanel());
	}
	
	private void buildFormArea(JPanel panel) {
		panel.setLayout(null);
		panel.setBounds(0, 0, this.getX(), this.getY());
		buildButton(new JButton(), "Confirm", new Rectangle(340, 12, 100, 50), panel);
		
		firstName = new JTextArea();
		firstName.setBounds(1, 30, 160, 20);
		
		JLabel fNameLabel = new JLabel("First Name:");
		fNameLabel.setBounds(1, 10, 160, 19);
		
		lastName = new JTextArea();
		lastName.setBounds(170, 30, 160, 20);
		
		JLabel lNameLabel = new JLabel("Last Name:");
		lNameLabel.setBounds(170, 10, 160, 19);
		
		tel = new JTextArea();
		tel.setBounds(1, 74, 160, 20);
		
		JLabel telLabel = new JLabel("Tel:");
		telLabel.setBounds(1, 54, 160, 19);
		
		mail = new JTextArea();
		mail.setBounds(170, 74, 160, 20);
		
		JLabel mailLabel = new JLabel("Mail:");
		mailLabel.setBounds(170, 54, 160, 19);
		
		panel.add(firstName);
		panel.add(fNameLabel);
		panel.add(lastName);
		panel.add(lNameLabel);
		panel.add(tel);
		panel.add(telLabel);
		panel.add(mail);
		panel.add(mailLabel);
		
		this.add(panel);
	}
	
	private void buildButton(JButton button, String name, Rectangle dim , JPanel panel) {
		 button = new JButton(name);
		 button.setBounds(dim);
		 button.addActionListener(this);
		 panel.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
