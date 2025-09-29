package ar.unlam.edu.ar.parcial1;

import java.util.ArrayList;
import java.util.List;

public abstract class AlojamientoBase implements Alojamiento {

	protected Integer id;
	protected String nombre;
	protected Integer capacidad;
	protected List<Persona> personas;

	public AlojamientoBase(Integer id, String nombre, Integer capacidad) {
		this.id = id;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.personas = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public Boolean estaDisponible() {
		return personas.size() < capacidad;
	}

	public Boolean agregarPersona(Persona persona) {
		if (!estaDisponible()) {
			return false;
		}
		for (Persona p : personas) {
			if (p.getDni().equals(persona.getDni())) {
				return false;
			}
		}
		personas.add(persona);
		return true;
	}

	protected Double calcularPrecioPorPersona(Persona persona, Integer noches, Double precioBase) {
		Double precio = precioBase * noches;
		if (persona.esFrecuente() == true) {
			precio *= 0.9;
		}
		return precio;
	}
}
