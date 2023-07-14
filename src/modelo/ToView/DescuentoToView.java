package modelo.ToView;

public class DescuentoToView {
	
	private String nombreDescuento;
	private double descuento;
	
	public DescuentoToView(String nombreDescuento, double descuento) {
		this.nombreDescuento = nombreDescuento;
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "DescuentoToView [nombreDescuento=" + nombreDescuento + ", descuento=" + descuento + "]";
	}

	public String getNombreDescuento() {
		return nombreDescuento;
	}

	public double getDescuento() {
		return descuento;
	}
	
	

}
