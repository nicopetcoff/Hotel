package principal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import controlador.HotelController;
import modelo.Enum.TipoHabitacion;
import modelo.Exception.NoEsHabitualException;
import modelo.Exception.NoExisteClienteException;
import modelo.Exception.NoExisteDescuentoException;
import modelo.Exception.NoExisteHabitacionException;
import modelo.Exception.NoExisteReservaException;

public class main {
	
	public static HotelController h = new HotelController();
	
	public static Scanner sc = new Scanner (System.in);
	
	

	public static void main(String[] args) {

			
		
		int opcion;
		
		do {
			System.out.println("1. \t Ver habitaciones disponibles");
			System.out.println("2. \t Ver precio por Tipo de Habitacion");
			System.out.println("3. \t Ver Descuentos Generales");
			System.out.println("4. \t Agendar Reserva Cliente HABITUAL");
			System.out.println("5. \t Agendar Reserva Cliente ESPORADICO");
			System.out.println("6. \t Ver Restante a pagar de una Reserva");
			System.out.println("Elija opcion: ");
			opcion = sc.nextInt();
			
			switch(opcion){
				case 1:
					verHabitacionesDisponibles();
					break;
				case 2:
					verPrecioHabitacionesPorTipo();
					break;
					
				case 3:
					verDescuentosGenerales();
					break;
					
				case 4:
					agendarReservaHabitual();
					break;
					
				case 5:
					agendarReservaEsporadico();
					break;
					
				case 6:
					verRestanteAPagar();
					break;
					
				default:
					break;
			}
			
			
		System.out.println("\n");
		}while(1!=2);
		
	}

	private static void verRestanteAPagar() {
		System.out.println("Ingrese su DNI: ");
		String dniCliente = sc.next();
		
		System.out.println("ingrese nro Reserva: ");
		int nroReserva = sc.nextInt();
		
		try {
			System.out.println(h.verRestentaReserva(dniCliente, nroReserva));
		} catch (NoExisteClienteException | NoExisteReservaException e) {
			e.printStackTrace();
		}
		
	}

	private static void agendarReservaEsporadico() {
		
		System.out.println("Ingrese su DNI: ");
		String dniCliente = sc.next();
		
		System.out.println("Ingrese nro de Habitacion: ");
		int nroHabitacion = sc.nextInt(); 
		
		System.out.println("Ingrese seña");
		float senia = sc.nextFloat();
		
		System.out.println();
		LocalDate fechaComienzo = pedirFecha();
		
		System.out.println("Diga la cantidad de días: ");
		int nroDias = sc.nextInt();	
		
		try {
			System.out.println("Su numero de reserva es: " +h.agendarReservaEsporaido(dniCliente, nroHabitacion, senia, fechaComienzo, nroDias));
		} catch (NoExisteDescuentoException | NoExisteHabitacionException | NoExisteClienteException
				| NoEsHabitualException e) {
			e.printStackTrace();
		}
	}

	private static void agendarReservaHabitual() {
		
		System.out.println("Ingrese su DNI: ");
		String dniCliente = sc.next();
		
		System.out.println("Ingrese nro de Habitacion: ");
		int nroHabitacion = sc.nextInt(); 
		
		System.out.println("Ingrese nombre del Descuento");
		String descuento = sc.next();
		
		System.out.println();
		LocalDate fechaComienzo = pedirFecha();
		
		System.out.println("Diga la cantidad de días: ");
		int nroDias = sc.nextInt();	
		
		try {
			System.out.println("Su numero de reserva es: " +h.agendarReservaHabitual(dniCliente, nroHabitacion, descuento, fechaComienzo, nroDias));
		} catch (NoExisteDescuentoException | NoExisteHabitacionException | NoExisteClienteException
				| NoEsHabitualException e) {
			e.printStackTrace();
		}
	}

	private static LocalDate pedirFecha() {
		
		Scanner scanner = new Scanner(System.in);
		
        System.out.print("Ingrese la fecha (Formato: AAAAMMDD): ");
        String fechaString = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate fecha = LocalDate.parse(fechaString, formatter);

        return fecha;
    }

	private static void verDescuentosGenerales() {
		
		for (int i = 0; i < h.verDescuentosGenerales().size(); i++) {
			System.out.println(h.verDescuentosGenerales().get(i));
		}
	}

	private static void verPrecioHabitacionesPorTipo() {
		
		
		TipoHabitacion th = obtenerTipoHabitacion();
		
		for (int i = 0; i < h.verHabitacionesDisponibles().size(); i++) {
			if (h.verHabitacionesDisponibles().get(i).getTipoHabitacion().equals(th)) {
				System.out.println("El precio es: " +h.verHabitacionesDisponibles().get(i).getPrecio());
			}			
		}
		
	}

	private static TipoHabitacion obtenerTipoHabitacion() {
		
		TipoHabitacion[] tipos = TipoHabitacion.values();
		
		System.out.println("Seleccione el Tipo de Habitacion");
		
		for (int i = 0; i < tipos.length; i++) {
			System.out.println((i+1) +". " +tipos[i]);
		}
		int opcion = sc.nextInt();
		
		if (opcion >= 1 && opcion<= tipos.length) {
			return tipos[opcion-1];
		}
		
		return null;
	}

	private static  void verHabitacionesDisponibles() {

		for (int i = 0; i < h.verHabitacionesDisponibles().size(); i++) {
			System.out.println(h.verHabitacionesDisponibles().get(i));
		}
	
		
	}

}
