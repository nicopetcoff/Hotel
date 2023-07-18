package modelo;

import java.time.LocalDate;

public class Reserva {
	
	private Cliente cliente;
	private Habitacion habitacion;
	private LocalDate fechaComienzo;
	private int numeroDias;
	private double valorReserva;
	private double senia;
	private EstadoReserva estadoReserva;
	private static int nroReservaSig = 1;
	private int nroReserva;
	
	public Reserva(Cliente cliente, Habitacion habitacion, LocalDate fechaComienzo, int numeroDias, double valorReserva,
			double senia) {
		this.cliente = cliente;
		this.habitacion = habitacion;
		this.fechaComienzo = fechaComienzo;
		this.numeroDias = numeroDias;
		this.valorReserva = valorReserva;
		this.senia = senia;
		this.estadoReserva = EstadoReserva.ACTIVA;
		this.nroReserva = nroReservaSig;
		nroReservaSig++;
	}

	public Reserva(Cliente cliente, Habitacion habitacion, LocalDate fechaComienzo, int numeroDias, double valorReserva) {
		this.cliente = cliente;
		this.habitacion = habitacion;
		this.fechaComienzo = fechaComienzo;
		this.numeroDias = numeroDias;
		this.valorReserva = valorReserva;
		this.estadoReserva = EstadoReserva.ACTIVA;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public LocalDate getFechaComienzo() {
		return fechaComienzo;
	}

	public int getNumeroDias() {
		return numeroDias;
	}

	public double getValorReserva() {
		return valorReserva;
	}

	public double getSenia() {
		return senia;
	}

	public EstadoReserva getEstadoReserva() {
		return estadoReserva;
	}

	public int getNroReserva() {
		return nroReserva;
	}

	public void setEstadoReserva(EstadoReserva estado) {
		
		this.estadoReserva = estado;
	}

	
	
	

	
}
