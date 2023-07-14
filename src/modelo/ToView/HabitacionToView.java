package modelo.ToView;

import modelo.Enum.TipoHabitacion;

public class HabitacionToView {
	
	private TipoHabitacion tipoHabitacion;
	private int nroHabitacion;
	private int piso;
	private double precio;
	private boolean esAlquilado;

	public HabitacionToView(TipoHabitacion tipoHabitacion, int piso, double precio, boolean esAlquilado) {
		this.tipoHabitacion = tipoHabitacion;
		this.nroHabitacion = nroHabitacion;
		this.piso = piso;
		this.precio = precio;
		this.esAlquilado = esAlquilado;
		
	}

	@Override
	public String toString() {
		return "HabitacionToView [tipoHabitacion=" + tipoHabitacion + ", nroHabitacion=" + nroHabitacion + ", piso="
				+ piso + ", precio=" + precio + "]";
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public int getNroHabitacion() {
		return nroHabitacion;
	}

	public void setNroHabitacion(int nroHabitacion) {
		this.nroHabitacion = nroHabitacion;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isEsAlquilado() {
		return esAlquilado;
	}

	public void setEsAlquilado(boolean esAlquilado) {
		this.esAlquilado = esAlquilado;
	}
	
	
	
	

}
