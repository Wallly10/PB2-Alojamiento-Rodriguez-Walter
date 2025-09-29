package ar.unlam.edu.ar.parcial1;

public class Habitacion extends AlojamientoBase {

	private static final Double PRECIO_POR_NOCHE = 125.0;

	public Habitacion(Integer id, String nombre, Integer capacidad) {
		super(id, nombre, capacidad);
	}

	@Override
	public Double calcularPrecioTotal(Integer noches) {
		Double total = 0.0;
		for (Persona persona : personas) {
			total += calcularPrecioPorPersona(persona, noches, PRECIO_POR_NOCHE);
		}

		return total;
	}

}
