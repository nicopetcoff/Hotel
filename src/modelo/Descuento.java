package modelo;

import modelo.ToView.DescuentoToView;

public class Descuento {
	
	private static int idSiguiente = 1;
	private int id;
	private String nombreDescuento;
	private double descuento;
	
	public Descuento(String nombreDescuento, double descuento) {
		this.id = idSiguiente;
		idSiguiente++;
		this.nombreDescuento = nombreDescuento;
		this.descuento = descuento;
	}
		
	public DescuentoToView descuentoToView() {
		return new DescuentoToView(nombreDescuento, descuento);
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public String getNombreDescuento() {
		return nombreDescuento;
	}
	
	


	
	

}
