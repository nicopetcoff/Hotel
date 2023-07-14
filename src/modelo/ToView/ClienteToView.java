package modelo.ToView;

public class ClienteToView {
	
	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private float descuento;
	
	public ClienteToView(int id, String nombre, String apellido, String dni, float descuento) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.descuento = descuento;
	}
	
	
	
	@Override
	public String toString() {
		return "ClienteToView [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", descuento=" + descuento + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	

}
