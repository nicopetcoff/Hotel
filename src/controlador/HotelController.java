package controlador;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Hotel;
import modelo.Exception.NoEsHabitualException;
import modelo.Exception.NoExisteClienteException;
import modelo.Exception.NoExisteDescuentoException;
import modelo.Exception.NoExisteHabitacionException;
import modelo.ToView.DescuentoToView;
import modelo.ToView.HabitacionToView;

public class HotelController {
	
	Hotel hotel = Hotel.getInstancia();
	
	public ArrayList<HabitacionToView> verHabitacionesDisponibles() {
		
		return hotel.verHabitacionesDisponibles();
		
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
	
	public double verRestentaReserva(String dniCliente, int nroReserva) throws NoExisteClienteException {
		double restante = hotel.verRestanteAAPagar(dniCliente, nroReserva);
		return restante;
	}
	
	

}
