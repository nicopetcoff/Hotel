package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class vistaMenu extends JFrame{

	public vistaMenu(){
		setTitle("Hotel");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		add(panel);
		
		panel.setLayout(new BorderLayout());
		
		JLabel titulo = new JLabel("Bievenido al Hotel", SwingConstants.CENTER);
		panel.add(titulo, BorderLayout.NORTH);
		
		Container cont = new Container();
		cont.setLayout(new FlowLayout());
		
		JButton verHabitacionesDisponibles = new JButton("Ver Habitaciones Disponibles");
		cont.add(verHabitacionesDisponibles);
		verHabitacionesDisponibles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VistaHabitacionesDisponibles vista = new VistaHabitacionesDisponibles();
				vista.setVisible(true);
				
			}
		});
		
		JButton verOfertasDisponibles = new JButton("Ver Ofertas Disponibles");
		cont.add(verOfertasDisponibles);
		
		panel.add(cont, BorderLayout.CENTER);
		

		
		
		
		
	}
}