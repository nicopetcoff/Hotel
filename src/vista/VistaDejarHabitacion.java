package vista;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.HotelController;
import modelo.ReservaImpagaException;
import modelo.Exception.NoExisteClienteException;
import modelo.Exception.NoExisteReservaException;

public class VistaDejarHabitacion extends JFrame{
	
	HotelController controlador = new HotelController();
	
	public VistaDejarHabitacion() {
		setSize(200, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridLayout(3,2,10,10));
		
		add(panel);
		
		JLabel dniLabel = new JLabel ("Ingrese DNI: ");
		JTextField dniField = new JTextField(10);
		
		JLabel reservaLabel = new JLabel ("Ingrese nro de Reserva: ");
		JTextField reservaField = new JTextField(10);
		
		JButton aceptar = new JButton("Aceptar");
		
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dni = dniField.getText();
				
				int nroReserva = Integer.parseInt(reservaField.getText());
				
				try {
					try {
						controlador.LiberarHabitacion(dni, nroReserva);
						JOptionPane.showMessageDialog(null, "Reserva Cumplida", "", JOptionPane.INFORMATION_MESSAGE);
					} catch (ReservaImpagaException e1) {
						JOptionPane.showMessageDialog(null, "Adeuda Saldo a Pagar", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}					
				} catch (NoExisteClienteException | NoExisteReservaException e1) {
					
					JOptionPane.showMessageDialog(null, "No se ha podido cumplir la reserva", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				dispose();
			}
		});
		
		panel.add(dniLabel);
		panel.add(dniField);
		panel.add(reservaLabel);
		panel.add(reservaField);		
		panel.add(aceptar);
		
	}

}
