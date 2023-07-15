package vista;


import modelo.ToView.HabitacionToView;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.HotelController;

public class VistaHabitacionesDisponibles extends JFrame{
	
	HotelController controlador = new HotelController();
	
	public VistaHabitacionesDisponibles() {
		super("Habitaciones Disponibles");
		setSize(300, 200);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		add(panel);
		
		panel.setLayout(new BorderLayout());
		
		ArrayList<HabitacionToView> habitaciones = new ArrayList<HabitacionToView>();		
		
		habitaciones = controlador.verHabitacionesDisponibles();
		
		JTable tablaHabitaciones = new JTable();
		
		DefaultTableModel modeloTablaHabitaciones = new DefaultTableModel();
		Object[] titulos = {"Nro Habitacion", "Piso", "Precio", "TipoHabitacion"};
		modeloTablaHabitaciones.setColumnIdentifiers(titulos);		
		
		
		for(HabitacionToView hab: habitaciones) {
			Object[] fila = new Object[4];
			fila[0] = hab.getNroHabitacion();
			fila[1]= hab.getPiso();
			fila[2]=hab.getPrecio();
			fila[3]= hab.getTipoHabitacion();
			modeloTablaHabitaciones.addRow(fila);	
			
		}
		
		tablaHabitaciones.setModel(modeloTablaHabitaciones);
		JScrollPane scrollTabla = new JScrollPane(tablaHabitaciones);
		
		panel.add(scrollTabla, BorderLayout.CENTER);
		
		
		
	}

}
