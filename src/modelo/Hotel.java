package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Enum.TipoHabitacion;
import modelo.Exception.NoEsHabitualException;
import modelo.Exception.NoExisteClienteException;
import modelo.Exception.NoExisteDescuentoException;
import modelo.Exception.NoExisteHabitacionException;
import modelo.Exception.NoExisteReservaException;
import modelo.ToView.ClienteToView;
import modelo.ToView.DescuentoToView;
import modelo.ToView.HabitacionToView;

public class Hotel {
	
	private static Hotel instancia;
	
	private ArrayList<Cliente> clientes;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Descuento> descuentosGenerales;
	
	private Hotel(){
		
		this.clientes = new ArrayList<>();
		this.habitaciones  = new ArrayList<>();
		this.descuentosGenerales = new ArrayList<>();
		
		
		
		habitaciones.add(new Habitacion(TipoHabitacion.SIMPLE, 1, 1, 20000));
		habitaciones.add(new Habitacion(TipoHabitacion.SIMPLE, 2, 1, 20000));
		
		habitaciones.add(new Habitacion(TipoHabitacion.DOBLE, 3, 2, 30000));
		habitaciones.add(new Habitacion(TipoHabitacion.DOBLE, 4, 2, 30000));
		
		habitaciones.add(new Habitacion(TipoHabitacion.MATRIMONIAL, 5, 3, 60000));
		habitaciones.add(new Habitacion(TipoHabitacion.MATRIMONIAL, 6, 3, 60000));
		
		descuentosGenerales.add(new Descuento("Base", 0.1));
		descuentosGenerales.add(new Descuento("Premier", 0.2));
		descuentosGenerales.add(new Descuento("Super Oferta", 0.3));
		
		clientes.add(new Cliente("Nicolas", "Apellido1", "123"));
		clientes.add(new Cliente("Pedro", "Apellido2", "456"));
		
		
		
	}
	
	public static Hotel getInstancia() {
        if (instancia == null) {
           
            instancia = new Hotel();
        }
        return instancia;
    }
	
	public ArrayList<HabitacionToView> verHabitacionesDisponibles() {
		
		ArrayList<HabitacionToView> habitacionesToView = new ArrayList<>();
		
		for(Habitacion h: habitaciones) {
			if (!h.isEsAlquilado()) {
				habitacionesToView.add(h.toView());
			}			
		}
		
		return habitacionesToView;
	}

	public ArrayList<DescuentoToView> getDescuentos() {
		
		ArrayList<DescuentoToView> descuentos = new ArrayList<>();
		
		for(Descuento descuento: descuentosGenerales) {
			descuentos.add(descuento.descuentoToView());
		}
		
		return descuentos;
	}
	
	public ArrayList<ClienteToView> getClientes(){
		
		ArrayList<ClienteToView> clientesToView = new ArrayList<>();
		
		for(Cliente clie: clientes)
			clientesToView.add(clie.clienteToView());
		
		return clientesToView;
	}
	
	public int crearReservaHabitual(String dniCliente, int nroHabitacion, String descuento, LocalDate fechaComienzo, 
			int nroDias) throws NoExisteDescuentoException, NoExisteHabitacionException, NoExisteClienteException, NoEsHabitualException {
		Cliente c = tengoEseCliente(dniCliente);
		Habitacion hab = tengoEsaHabitacion(nroHabitacion);
		Descuento desc = tengoEseDescuento(descuento);
		
		if (c!=null) {
			if (hab!=null) {
				if (desc != null) {
					return c.crearReservaHabitual(hab, desc, fechaComienzo, nroDias);
				}else {
					throw new NoExisteDescuentoException("No existe el descuento ingresado");
				}
				
			}else {
				throw new NoExisteHabitacionException("No existe la habitacion o esta alquilada");
			}
			
		}else {
			throw new NoExisteClienteException("No existe el cliente");
		} 
	}
	
	public int crearReservaEsporadico(String dniCliente, int nroHabitacion, Float senia, LocalDate fechaComienzo, 
			int nroDias) throws NoExisteDescuentoException, NoExisteHabitacionException, NoExisteClienteException, NoEsHabitualException {
		Cliente c = tengoEseCliente(dniCliente);
		Habitacion hab = tengoEsaHabitacion(nroHabitacion);
		
		if (c!=null) {
			if (hab!=null) {
				
				return c.crearReservaEsporadico(hab, senia, fechaComienzo, nroDias);
				
			}else {
				throw new NoExisteHabitacionException("No existe la habitacion o esta alquilada");
			}
			
		}else {
			throw new NoExisteClienteException("No existe el cliente");
		} 
	}

	private Descuento tengoEseDescuento(String descuento) {
		for(Descuento des: descuentosGenerales) {
			if (des.getNombreDescuento().equals(descuento)) {
				return des;
			}
		}
		return null;
	}

	private Habitacion tengoEsaHabitacion(int nroHabitacion) {
		
		for(Habitacion hab: habitaciones) {
			if (hab.getNroHabitacion() == nroHabitacion && !hab.isEsAlquilado()) {
				return hab;
			}
		}
		return null;
	}

	private Cliente tengoEseCliente(String dniCliente) {
		
		for(Cliente cliente: clientes) {

			if (cliente.getDNI().equals(dniCliente)) {
				return cliente;
			}
		}
		return null;
	}

	public double verRestanteAAPagar(String dniCliente, int nroReserva) throws NoExisteClienteException, NoExisteReservaException {
		
		Cliente c = tengoEseCliente(dniCliente);
		if (c!=null) {
			return c.getRestanteReserva(nroReserva);
		}else {
			throw new NoExisteClienteException("No existe el cliente");
		}
	}

	public ArrayList<HabitacionToView> verHabitacionesDisponiblesPorTipo(TipoHabitacion tipo) {
		
		ArrayList<HabitacionToView> habitacionesDisponibles = new ArrayList<>();
		
		for(Habitacion hab: habitaciones) {
			if (hab.getTipoHabitacion().equals(tipo)) {
				
				habitacionesDisponibles.add(hab.toView());
			}
		}
		
		return habitacionesDisponibles;
	}

	public void cambiarEstadoATomada(String dni, int nroReserva, float montoAbona) throws NoExisteClienteException, NoExisteReservaException {
		
		Cliente clie = tengoEseCliente (dni);
		
		if (clie!=null) {
			clie.cambiarATomada(nroReserva, montoAbona);
		}else {
			throw new NoExisteClienteException("No existe el cliente");
		}
	}

	public void liberarReserva(String dni, int nroReserva) throws NoExisteClienteException, NoExisteReservaException, ReservaImpagaException {
		
		Cliente clie = tengoEseCliente (dni);
		
		if (clie!=null) {
			clie.liberarReserva(nroReserva);
		}else {
			throw new NoExisteClienteException("No existe el cliente");
		}
	}
	

}
