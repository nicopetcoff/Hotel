package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Enum.TipoCliente;
import modelo.Exception.NoEsHabitualException;
import modelo.ToView.ClienteToView;

public class Cliente {
	
	private TipoCliente tipoCliente;
	private static int idSiguiente = 1;
	private int id;
	private String nombre;
	private String apellido;	
	private String dni;
	private ArrayList<Reserva> reservas;
	private float descuento;
	
	public Cliente(String nombre, String apellido, String dni) {
		
		this.tipoCliente = TipoCliente.HABITUAL;
		this.id = idSiguiente;
		idSiguiente++;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.reservas = new ArrayList<>();
		this.descuento = 0;
	}
	
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public String getDNI() {
		return this.dni;
	}

	public float getDescuento() {
		return descuento;
	}
	
	public void setDescuento(float descuento) {
		
		if(esHabitual()) {
			this.descuento = descuento;
		}
		
	}
	
	private boolean esHabitual() {
		if (reservas.size()>=6) {
			this.tipoCliente = TipoCliente.HABITUAL;
		}
		return (this.tipoCliente.equals(TipoCliente.HABITUAL));
	}

	public ClienteToView clienteToView() {
		return new ClienteToView(id, nombre, apellido, dni, descuento);		
		
	}
	
	public int crearReservaHabitual(Habitacion hab, Descuento desc, LocalDate fechaComienzo, int nroDias) throws NoEsHabitualException {
		
		if (this.esHabitual()) {
			
			double descuento1;
			
			if (desc.getDescuento()> this.descuento) {
				descuento1 = desc.getDescuento();
			}else {
				descuento1 = this.descuento;
			}
			
			Reserva res = new Reserva(this, hab, fechaComienzo, nroDias, (hab.getPrecio()*descuento1));
			
			reservas.add(res);
			
			hab.setEsAlquilado(true);
			
			return res.getNroReserva();
		}
		throw new NoEsHabitualException("No es un cliente Habitual");
		
		
	}

	public int crearReservaEsporadico(Habitacion hab, Float senia, LocalDate fechaComienzo, int nroDias) {
		Reserva res = new Reserva(this, hab, fechaComienzo, nroDias, hab.getPrecio(), senia);
		reservas.add(res);
		
		hab.setEsAlquilado(true);
		
		return res.getNroReserva();
	}
	
	public float getRestanteReserva(int nroReserva) {
		for(Reserva res: reservas) {
			if (res.getEstadoReserva().equals(EstadoReserva.ACTIVA) && res.getNroReserva() == nroReserva) {
				return (float) (res.getValorReserva() - res.getSenia());
			}
		}
		return 0;
	}
	
	
	
	
		

}
