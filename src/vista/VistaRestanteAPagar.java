package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.HotelController;
import modelo.Exception.NoExisteClienteException;
import modelo.Exception.NoExisteReservaException;

public class VistaRestanteAPagar extends JFrame{
	
	HotelController controlador = new HotelController();
	
	public VistaRestanteAPagar() {
		setLocationRelativeTo(null);
		setSize(500, 200);
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel(new GridLayout(3,2,10,10));
		add(panel);
		
		JLabel nroReservaLabel = new JLabel("Ingrese nro Reserva: ");
		JTextField nroReservaField = new JTextField(10);
		
		JLabel dniClienteLabel = new JLabel("Ingrese su DNI: ");
		JTextField dniClienteField = new JTextField(10);
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String dni = dniClienteField.getText();
				int nroReserva = Integer.parseInt(nroReservaField.getText());
				
				try {
					double restanteAPagar = controlador.verRestentaReserva(dni, nroReserva);
					
					JOptionPane.showMessageDialog(null, "El restante a pagar es: " +restanteAPagar, "Exito", JOptionPane.INFORMATION_MESSAGE);
				} catch (NoExisteClienteException | NoExisteReservaException e1) {
					
					JOptionPane.showMessageDialog(null, "El Operacion no valida", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				
				dispose();
			}
		});
		
		panel.add(dniClienteLabel);
		panel.add(dniClienteField);
		panel.add(nroReservaLabel);
		panel.add(nroReservaField);
		panel.add(aceptar);
		
	}

}
