package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class VistaReservaClienteEsporadico extends JFrame{
	
	public VistaReservaClienteEsporadico() {
		
		super("Reserva Cliente Esporadico");
		setSize(200,300);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		add(panel);
		
		Container cont = new Container();
		cont.setLayout(new GridLayout(5,1,10,10));
		
		cont.add(new JLabel("Ingrese DNI"));
		
		JTextField dni = new JTextField();
		cont.add(dni);
		
		panel.add(cont, BorderLayout.CENTER);
		
		
		
	}

}
