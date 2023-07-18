package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.HotelController;
import modelo.Exception.NoExisteClienteException;
import modelo.Exception.NoExisteReservaException;

public class VistaIngresarHuespedAHabitacion extends JFrame{
	
	HotelController controlador = new HotelController();
	
	public VistaIngresarHuespedAHabitacion () {
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridLayout(3,2,10,10));
		
		add(panel);
		
		JLabel dniLabel = new JLabel("Ingrese DNI: ");
		JTextField dniField = new JTextField(10);
		
		JLabel reservaLabel = new JLabel("Ingrese Nro Reserva: ");
		JTextField reservaField = new JTextField(10);
		
		JButton aceptar = new JButton("Aceptar");
		
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dni = dniField.getText();
				int nroReserva = Integer.parseInt(reservaField.getText());
				
				try {
					controlador.cambiarEstadoTomada(dni, nroReserva);
					JOptionPane.showMessageDialog(null, "Se ha cambiado Estado", "Exito", JOptionPane.INFORMATION_MESSAGE);
				} catch (NoExisteClienteException | NoExisteReservaException e1) {
					
					JOptionPane.showMessageDialog(null, "No se ha cambiado estado", "Error", JOptionPane.ERROR_MESSAGE);
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
