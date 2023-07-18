package controlador;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Hotel;
import modelo.ReservaImpagaException;
import modelo.Enum.TipoHabitacion;
import modelo.Exception.NoEsHabitualException;
import modelo.Exception.NoExisteClienteException;
import modelo.Exception.NoExisteDescuentoException;
import modelo.Exception.NoExisteHabitacionException;
import modelo.Exception.NoExisteReservaException;
import modelo.ToView.DescuentoToView;
import modelo.ToView.HabitacionToView;

public class HotelController {
	
	Hotel hotel = Hotel.getInstancia();
	
	public ArrayList<HabitacionToView> verHabitacionesDisponibles() {
		
		return hotel.verHabitacionesDisponibles();
		
	}
	
	public ArrayList<HabitacionToView> verHabitacionesDisponiblesPorTipo (String tipoHabitacion){
		
		TipoHabitacion tipo = obtenerTipoHabitacion(tipoHabitacion); 
		
		return hotel.verHabitacionesDisponiblesPorTipo(tipo);
		
	}

	private TipoHabitacion obtenerTipoHabitacion(String tipoHabitacion) {
		
		TipoHabitacion[] tipos = TipoHabitacion.values();
		
		for(TipoHabitacion tipo : tipos) {
			if (tipo.name().equals(tipoHabitacion)) {
				return tipo;
			} 
		}
		
		return null;
	}

	public ArrayList<DescuentoToView> verDescuentosGenerales() {
		
		return hotel.getDescuentos();
	}
	
	
	public int agendarReservaHabitual(String dniCliente, int nroHabitacion, String descuento, LocalDate fechaComienzo, 
			int nroDias) throws NoExisteDescuentoException, NoExisteHabitacionException, NoExisteClienteException, NoEsHabitualException {
		
		int nroReserva =hotel.crearReservaHabitual(dniCliente, nroHabitacion, descuento, fechaComienzo, nroDias);
		
		return nroReserva;
		
	}

	public int agendarReservaEsporaido(String dniCliente, int nroHabitacion, float senia, LocalDate fechaComienzo,
			int nroDias) throws NoExisteDescuentoException, NoExisteHabitacionException, NoExisteClienteException, NoEsHabitualException {
		
		int nroReserva = hotel.crearReservaEsporadico(dniCliente, nroHabitacion, senia, fechaComienzo, nroDias);
		
		return nroReserva;
	}
	
	public double verRestentaReserva(String dniCliente, int nroReserva) throws NoExisteClienteException, NoExisteReservaException {
		double restante = hotel.verRestanteAAPagar(dniCliente, nroReserva);
		return restante;
	}

	public void cambiarEstadoTomada(String dni, int nroReserva, float montoAbona) throws NoExisteClienteException, NoExisteReservaException {
		
		hotel.cambiarEstadoATomada(dni, nroReserva, montoAbona);
	}

	public void LiberarHabitacion(String dni, int nroReserva) throws NoExisteClienteException, NoExisteReservaException, ReservaImpagaException {
		
		hotel.liberarReserva(dni, nroReserva);
	}
	
	

}
