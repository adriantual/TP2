package restaurant;

public abstract class Articulo {

	private String nombre;
	private double precio;

	public Articulo(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public String nombre() {
		return nombre;
	}

	public double precio(int descuento) {

		double total = 0;
		total = this.precio * (1 - (descuento / 100));

		return total;
	}

}
