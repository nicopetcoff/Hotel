package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import controlador.HotelController;
import modelo.ToView.HabitacionToView;

public class VistaHabitacionesDisponiblesPorTipo extends JFrame{
	
	HotelController controlador = new HotelController();
	protected DefaultTableModel modeloTablaHabitaciones;
	
	public VistaHabitacionesDisponiblesPorTipo() {
		
		setSize(300, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel(new BorderLayout());
		add(panel);
		
		JComboBox<String> comboTipo = new JComboBox<>();
		comboTipo.addItem("SIMPLE");
		comboTipo.addItem("DOBLE");
		comboTipo.addItem("MATRIMONIAL");
				
		JButton aceptar = new JButton("Aceptar");
		
		Container cont = new Container();
		cont.setLayout(new GridLayout(2,1,5,5));
		cont.add(comboTipo);
		cont.add(aceptar);
		
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String tipo = (String) comboTipo.getSelectedItem();
				
				llenarTabla(modeloTablaHabitaciones, tipo);
			}
		});
		
		JTable tablaHabitaciones = new JTable();
		
		modeloTablaHabitaciones = new DefaultTableModel();
		
		
		Object[] titulos = {"TipoHabitacion","NroHabitacion", "Piso", "Precio"};
		
		modeloTablaHabitaciones.setColumnIdentifiers(titulos);
		
		tablaHabitaciones.setModel(modeloTablaHabitaciones);
		
		
		
		JScrollPane scrollTable = new JScrollPane(tablaHabitaciones);
		
		panel.add(scrollTable, BorderLayout.CENTER);
		panel.add(cont, BorderLayout.NORTH);
		
	}

	protected void llenarTabla(DefaultTableModel modeloTablaHabitaciones2, String tipo) {
		
		ArrayList<HabitacionToView> habitacionesDisponibles = controlador.verHabitacionesDisponiblesPorTipo(tipo);
		
		for(HabitacionToView  hab : habitacionesDisponibles) {
			Object[] fila = new Object[4];
			fila[0] = hab.getTipoHabitacion();
			fila[1] = hab.getNroHabitacion();
			fila[2] = hab.getPiso();
			fila[3] = hab.getPrecio();
			
			modeloTablaHabitaciones2.addRow(fila);
		}
		
	}

}
