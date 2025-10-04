package ar.unlam.edu.ar.intefaz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//import java.util.Scanner;

import org.junit.Test;

import ar.unlam.edu.ar.dominio.Alojamiento;
import ar.unlam.edu.ar.dominio.Casa;
import ar.unlam.edu.ar.dominio.Habitacion;
import ar.unlam.edu.ar.dominio.Persona;

public class TestSistemaReservas {
//	private static Scanner teclado = new Scanner(System.in);

//Crear Persona comun
	@Test
	public void dadoQueNoExistenPersonasAlCrearUnaPersonaConDniNombreYApellidoYSiEsFrecuenteSePuedeObtenerElDniNombreYApellidoYSiEsFrecuente() {

//		Integer dni = ingresarInteger("Ingrese su dni: ");
//		String nombre = ingresarString("Ingrese su nombre: ");	
//		String apellido = ingresarString("Ingrese su apellido: ");
//		Boolean esFrecuente = ingresarBoolean("Ingrese si es frecuente: ");
//		Boolean valido = true;
//		do {
//			if (dni == 0 && nombre == "" && apellido == "") {
//				valido = false;
//			}
//		} while (!valido);
//
//		Persona persona = new Persona(dni, nombre, apellido, esFrecuente);
		Persona persona = new Persona(12345678, "Juan", "Perez", false);

		assertEquals(Integer.valueOf(12345678), persona.getDni());
		assertEquals("Juan", persona.getNombre());
		assertEquals("Perez", persona.getApellido());
		assertFalse(persona.esFrecuente());

	}

//	private static Integer ingresarInteger(String mensaje) {
//		System.out.println(mensaje);
//		return teclado.nextInt();
//	}
//
//	private static String ingresarString(String mensaje) {
//		System.out.println(mensaje);
//		return teclado.next();
//	}
//
//	private static Boolean ingresarBoolean(String mensaje) {
//		System.out.println(mensaje);
//		return teclado.nextBoolean();
//	}

//Crear alojamiento
	@Test
	public void dadoQueNoExisteUnAlojamientoAlCrearUnAlojamientoCasaConIdNomreYCapacidadPara4PersonasPuedoConsultarSuDisponibilidadConResultadoPositivo

	() {
		// Capacida : (número de personas que puede alojar)
		Alojamiento casa = new Casa(1, "Casa 1", 4); // como creo una casa a heredando de una interfaz los primeros 3
														// parametros son propias de la clase y los otros 3 los hereda
														// porque es un tipo de alojamiento

		assertEquals(Integer.valueOf(1), casa.getId());
		assertEquals("Casa 1", casa.getNombre());
		assertEquals((Integer) 4, casa.getCapacidad());
		assertTrue(casa.estaDisponible());
	}

	@Test
	public void dadoQueNoExisteUnAlojamientoAlCrearUnAlojamientoHabitacionConIdNomreYCapacidadPara2PersonasPuedoConsultarSuDisponibilidadConResultadoPositivo() {
		// Capacida : (número de personas que puede alojar)

		Alojamiento hab = new Habitacion(1, "Habitacion 1", 2);

		assertEquals(Integer.valueOf(1), hab.getId());
		assertEquals("Habitacion 1", hab.getNombre());
		assertEquals((Integer) 2, hab.getCapacidad());
		assertTrue(hab.estaDisponible());
	}

//cargarPersonasALAlojamiento
	@Test
	public void dadoQueExisteUnAlojamientoCasaConCapacidadPara4PersonasSePuedenAgregar2PersonasConResultadosPositivos() {

		Alojamiento casa = new Casa(1, "Casa 2", 4);
		Persona persona1 = new Persona(12344321, "Juan", "Perez", false);
		Persona persona2 = new Persona(12344322, "Jose", "Perez", true);

		assertTrue(casa.agregarPersona(persona1));
		assertTrue(casa.agregarPersona(persona2));
	}

//No permite Agregar con dni Duplicado
	@Test
	public void dadoQueExisteUnAlojamientoCasaConCapacidadPara4PersonasAlAgregarUnaPersonaConDniDuplicadoObtengoUnResultadoNegativo() {

		Alojamiento casa = new Casa(1, "Casa 2", 4);
		Persona persona1 = new Persona(12344321, "Juan", "Perez", false);
		Persona persona2 = new Persona(12344321, "Jose", "Perez", true);

		assertTrue(casa.agregarPersona(persona1));
		assertFalse(casa.agregarPersona(persona2));

	}

//no Registrar mas personas de lo permitdo	
	@Test
	public void dadoQueExisteUnAlojamientoCasaConCapacidadPara4PersonasAlAgregarUnaQuintaPersonaObtengoUnResultadoNegativo() {
		Alojamiento casa = new Casa(1, "Casa 2", 4);

		Persona persona1 = new Persona(12344321, "Juan", "Perez", false);
		Persona persona2 = new Persona(12344322, "Jose", "Perez", true);
		Persona persona3 = new Persona(12344323, "Raul", "Perez", true);
		Persona persona4 = new Persona(12344324, "Ernesto", "Perez", true);
		Persona persona5 = new Persona(12344325, "Roman", "Perez", false);

		casa.agregarPersona(persona1);
		casa.agregarPersona(persona2);
		casa.agregarPersona(persona3);
		casa.agregarPersona(persona4);
		Boolean noEntra = casa.agregarPersona(persona5);

		assertFalse(noEntra);
		System.out.println("\nNo tendria que entrar la quinta persona\t: " + noEntra);

	}

	@Test
	public void dadoQueExisteUnAlojamientoCasaConCapacidadPara4PersonasYCon2PersonasNoFrecuentesAgregadasCuandoOtengoElPrecioTotalPara2Personas2NochesObtengo1000() {
		// PrecioPorNoche por persona: $ 250
		// Valor de casa: PrecioPorNoche * cantidad de personas alojadas
		Alojamiento casa = new Casa(1, "Casa 1", 4);
		Persona persona1 = new Persona(12344321, "Juan", "Perez", false);
		Persona persona2 = new Persona(12344322, "Jose", "Perez", false);

		casa.agregarPersona(persona1);
		casa.agregarPersona(persona2);

		Double precioTotal = casa.calcularPrecioTotal(2);
		assertEquals(1000, precioTotal, 0.01);
		System.out.println("\nElPrecioTotalPara2Personas2NochesObtengo1000: " + precioTotal);

	}

	@Test
	public void dadoQueExisteUnAlojamientoHabitacionConCapacidadPara2PersonasYCon2PersonasNoFrecuentesAgregadasCuandoOtengoElPrecioTotalObtengo250() {
		// PrecioPorNoche por persona: $ 125
		// Valor de casa: PrecioPorNoche * cantidad de personas alojadas
		Alojamiento hab = new Habitacion(1, "Hab 1", 4);
		Persona persona1 = new Persona(12344321, "Juan", "Perez", false);
		Persona persona2 = new Persona(12344322, "Jose", "Perez", false);

		hab.agregarPersona(persona1);
		hab.agregarPersona(persona2);

		Double precioTotal = hab.calcularPrecioTotal(1);
		assertEquals(250, precioTotal, 0.01);
		System.out.println("\nElPrecioTotalObtengo250: " + precioTotal);
	}

	@Test
	public void dadoQueExisteUnAlojamientoCasaConCapacidadPara4PersonasYCon2PersonasNoFrecuentesY2PersonasFrecuentesAgregadasCuandoObtengoElPrecioTotalPor2NochesCadaUnoObtengo950() {
		// Personas frecuentes tinen un 10% de descuento por noche
		Alojamiento casa = new Casa(1, "Casa 1", 4);
		Persona persona1 = new Persona(12344321, "Juan", "Perez", false);
		Persona persona2 = new Persona(1235322, "Jose", "Perez", false);
		Persona persona3 = new Persona(123323, "Ramon", "Perez", true);
		Persona persona4 = new Persona(12424, "Pepe", "Perez", true);

		casa.agregarPersona(persona1);
		casa.agregarPersona(persona2);
		casa.agregarPersona(persona3);
		casa.agregarPersona(persona4);

		Double precioTotal = casa.calcularPrecioTotal(1);
		assertEquals(950, precioTotal, 0.1);
		System.out.println("\nElPrecioTotalPor2NochesCadaUnoObtengo950: " + precioTotal);

	}

}
