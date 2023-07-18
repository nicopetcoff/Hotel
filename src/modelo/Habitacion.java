package modelo;

import modelo.Enum.TipoHabitacion;
import modelo.ToView.HabitacionToView;

public class Habitacion {

	private TipoHabitacion tipoHabitacion;
	private int nroHabitacion;
	private int piso;
	private double precio;
	private boolean esAlquilado;

	public Habitacion(TipoHabitacion tipoHabitacion, int nroHabitacion, int piso, double precio) {

		this.tipoHabitacion = tipoHabitacion;
		this.nroHabitacion = nroHabitacion;
		this.piso = piso;
		this.precio = precio;
		this.esAlquilado = false;
	}

	@Override
	public String toString() {
		return "Habitacion [tipoHabitacion=" + tipoHabitacion + ", nroHabitacion=" + nroHabitacion + ", piso=" + piso
				+ ", precio=" + precio + "]";
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

	public HabitacionToView toView() {

		return new HabitacionToView(this.tipoHabitacion, this.nroHabitacion,this.piso, this.precio, this.esAlquilado);
	}
	
	
	

}
