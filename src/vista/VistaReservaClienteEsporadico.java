package vista;

import controlador.HotelController;
import modelo.Exception.NoEsHabitualException;
import modelo.Exception.NoExisteClienteException;
import modelo.Exception.NoExisteDescuentoException;
import modelo.Exception.NoExisteHabitacionException;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class VistaReservaClienteEsporadico extends JFrame{
	
	HotelController controlador = new HotelController();
	
	public VistaReservaClienteEsporadico() {
		
		super("Reserva Cliente Esporadico");
		setSize(200,300);
		setLocationRelativeTo(null);		
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,2,10,10));
		
		add(panel);
		
		JLabel campoDni = new JLabel("Ingrese DNI: ");		
		JTextField dniField = new JTextField(10);
		
		JLabel campoNroHabitacion = new JLabel("Ingrese Nro de Habitacion: ");
		JTextField nroHabitacionField = new JTextField(10);
		
		JLabel campoSenia = new JLabel("Ingrese monton de seña: ");
		JTextField seniaField = new JTextField(10);
		
		JLabel campoFecha = new JLabel("Ingrese Fecha (AAAAMMDD): ");
		JTextField fechaField = new JTextField(10);
		
		JLabel campoDias = new JLabel("Ingrese cantidad de dias");
		JTextField diasField = new JTextField(10);
		
		JButton aceptar = new JButton("Aceptar");
		
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dni = dniField.getText();
				int nroHabitacion = Integer.parseInt(nroHabitacionField.getText());
				float senia = Float.parseFloat(seniaField.getText());
				
				DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyyMMdd");				
				LocalDate fechaComienzo = LocalDate.parse(fechaField.getText(), formatter);
				
				int cantDias = Integer.parseInt(diasField.getText());
				
				try {
					int nroReserva = controlador.agendarReservaEsporaido(dni, nroHabitacion, senia, fechaComienzo, cantDias);
					JOptionPane.showMessageDialog(null, "Se ha registrado la reserva nro: " +nroReserva, "Exito", JOptionPane.INFORMATION_MESSAGE);
				} catch (NoExisteDescuentoException | NoExisteHabitacionException | NoExisteClienteException
						| NoEsHabitualException e1) {
					JOptionPane.showMessageDialog(null,"No pudo ralizarce la reserva", "Error", JOptionPane.ERROR_MESSAGE );
					e1.printStackTrace();
				}		
				
				dispose();
			}
			
		});
		
		panel.add(campoDni);
		panel.add(dniField);
		panel.add(campoNroHabitacion);
		panel.add(nroHabitacionField);
		panel.add(campoSenia);
		panel.add(seniaField);
		panel.add(campoFecha);
		panel.add(fechaField);
		panel.add(campoDias);
		panel.add(diasField);
		panel.add(aceptar);
		
		
	}

}
