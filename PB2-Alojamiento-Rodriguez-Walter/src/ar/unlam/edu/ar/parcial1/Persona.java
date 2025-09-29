package ar.unlam.edu.ar.parcial1;

import java.util.Objects;

public class Persona {

	private Integer dni;
	private String nombre;
	private String apellido;
	private Boolean esFrecuente;

	public Persona(Integer dni, String nombre, String apellido, Boolean esFrecuente) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.esFrecuente = esFrecuente;
	}

	protected Integer getDni() {
		return dni;
	}

	protected String getNombre() {
		return nombre;
	}

	protected Boolean esFrecuente() {
		return esFrecuente;
	}

	protected String getApellido() { // solo los del paquete pueden acceder y las sub clases
		return apellido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni);
	}

}
