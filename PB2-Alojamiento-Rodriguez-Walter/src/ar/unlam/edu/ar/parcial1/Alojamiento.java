package ar.unlam.edu.ar.parcial1;

import java.util.List;

public interface Alojamiento {
// aca defino el contrato
	Integer getId();

	String getNombre();

	Integer getCapacidad();

	Boolean estaDisponible();

	Boolean agregarPersona(Persona persona);

	Double calcularPrecioTotal(Integer noches);

	List<Persona> getPersonas();

}
