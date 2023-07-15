package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;

import modelo.ToView.*;

import controlador.HotelController;

import javax.swing.*;
import javax.swing.table.*;

public class VistaOfertasDisponibles extends JFrame{
	
	HotelController controlador = new HotelController();
	
	public VistaOfertasDisponibles() {
		super("Ofertas Disponibles");
		setSize(200, 120);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout());
		
		JTable tablaOfertas = new JTable();
		
		DefaultTableModel modeloTablaOfertas = new DefaultTableModel();
				
		Object[] titulos = {"NombreDescuento", "Decuento"};
		
		modeloTablaOfertas.setColumnIdentifiers(titulos);
		
		ArrayList<DescuentoToView> descuentos = controlador.verDescuentosGenerales();
		
		for(DescuentoToView desc : descuentos) {
			Object[] fila = new Object[2];
			fila[0] = desc.getNombreDescuento();
			fila[1] = desc.getDescuento();
			modeloTablaOfertas.addRow(fila);
		}
		
		tablaOfertas.setModel(modeloTablaOfertas);
		
		JScrollPane scrollTable = new JScrollPane(tablaOfertas);
		
		panel.add(scrollTable, BorderLayout.CENTER);
		
		
		
		
		
	}

}
