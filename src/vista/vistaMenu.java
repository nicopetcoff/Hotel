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
		
		JButton verHabitacionesDiposniblesPorTipo = new JButton("Ver Habitaciones Disponibles por Tipo");
		cont.add(verHabitacionesDiposniblesPorTipo);
		
		verHabitacionesDiposniblesPorTipo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VistaHabitacionesDisponiblesPorTipo vista = new VistaHabitacionesDisponiblesPorTipo();
				vista.setVisible(true);
			}
		});
		
		
		JButton verOfertasDisponibles = new JButton("Ver Ofertas Disponibles");
		cont.add(verOfertasDisponibles);
		
		verOfertasDisponibles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				VistaOfertasDisponibles vistaOfertas = new VistaOfertasDisponibles();
				vistaOfertas.setVisible(true);
				
			}
		});	
		
		JButton agendarEsporadico = new JButton("Reserva Cliente Esporadico");
		cont.add(agendarEsporadico);
		
		agendarEsporadico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				VistaReservaClienteEsporadico vista = new VistaReservaClienteEsporadico();
				vista.setVisible(true);
				
			}
		});
		
		JButton verRestanteAPagar = new JButton("Ver restante a pagar");
		cont.add(verRestanteAPagar);
		
		verRestanteAPagar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VistaRestanteAPagar vista = new VistaRestanteAPagar();
				
				vista.setVisible(true);
			}
		});
		
		JButton IngresarAHabitacion = new JButton("Ingresa Huesped a Habitacion");
		cont.add(IngresarAHabitacion);
		
		IngresarAHabitacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VistaIngresarHuespedAHabitacion vista= new VistaIngresarHuespedAHabitacion();
				
				vista.setVisible(true);
			}
		});
		
		panel.add(cont, BorderLayout.CENTER);
		
		JButton dejarHabitacion = new JButton("Retirar Huesped de Habitación");		
		cont.add(dejarHabitacion);
		
		dejarHabitacion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VistaDejarHabitacion vista = new VistaDejarHabitacion();
				
				vista.setVisible (true);
			}
		});
		

		
		
		
		
	}
}