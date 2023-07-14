package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class vistaMenu extends JFrame{

	public vistaMenu() {
		super("Vista Hotel");
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		JPanel panel1=new JPanel();
		panel1.setLayout(new GridLayout(1,1,2,2));
		this.add(panel1, BorderLayout.CENTER);
		
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		
		
		panel1.add(new JLabel("Hotel"));
		panel1.add(panel2);
		
		JButton verHabitacionesDisponibles = new JButton("Ver habitaciones ");
		
		panel2.add(new JButton("Random"));
		panel2.add(new JButton("Random"));
		panel2.add(new JButton("Random"));
		panel2.add(new JButton("Random"));
		panel2.add(new JButton("Random"));
		panel2.add(new JButton("Random"));
		
		
		
		
	}
}
