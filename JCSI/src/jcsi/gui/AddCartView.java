package jcsi.gui;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddCartView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public AddCartView() {
		super("Adding a Cart");
		this.setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		buildFormArea(new JPanel());
	}
	
	private void buildFormArea(JPanel panel) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unused")
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
