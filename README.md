# 🏡 Trabajo Práctico: Sistema de Reservas de Alojamientos

## 📖 Introducción
El presente trabajo práctico tiene como objetivo desarrollar un **sistema de reservas de alojamientos** aplicando los conceptos de **Programación Orientada a Objetos en Java**.  

Se busca modelar la gestión de **casas y habitaciones**, permitiendo registrar personas, verificar disponibilidad, calcular precios y aplicar descuentos a clientes frecuentes.

---

## 🎯 Objetivos del trabajo
- Implementar clases, herencia, interfaces y polimorfismo en Java.
- Modelar el dominio de un sistema de reservas de alojamientos.
- Aplicar encapsulamiento y validaciones en los objetos creados.
- Desarrollar pruebas unitarias con **JUnit 4** para validar el correcto funcionamiento.

---

## 🛠️ Herramientas utilizadas
- **Lenguaje**: Java 8+
- **Entorno**: Eclipse IDE
- **Testing**: JUnit 4

---

## 📂 Estructura del proyecto

El sistema se compone de las siguientes clases principales:

- **Dominio**
  - `Persona`: representa a un cliente con DNI, nombre, apellido y estado de cliente frecuente o no.
  - `Alojamiento` *(interfaz)*: establece las operaciones comunes a cualquier alojamiento.
  - `AlojamientoBase`: clase abstracta que concentra la lógica compartida entre casas y habitaciones (capacidad, lista de personas, validaciones).
  - `Casa`: tipo de alojamiento con un costo base de **$250 por persona por noche**.
  - `Habitacion`: tipo de alojamiento con un costo base de **$125 por persona por noche**.

- **Test**
  - `TestSistemaReservas`: conjunto de pruebas unitarias que validan la funcionalidad del sistema.

---

## ⚙️ Funcionamiento del sistema

1. **Registro de personas**  
   - Una persona se identifica con su **DNI** (único).  
   - Puede ser **cliente frecuente** (obtiene un 10% de descuento).  

2. **Gestión de alojamientos**  
   - Los alojamientos tienen una **capacidad máxima de personas**.  
   - Se controla que **no se repitan DNIs** y que no se supere la capacidad.  
   - Un alojamiento está **disponible** si aún puede recibir personas.  

3. **Cálculo de precios**  
   - Casa: $250 por persona por noche.  
   - Habitación: $125 por persona por noche.  
   - Si una persona es frecuente, se le aplica un **10% de descuento** en su precio.  
   - El precio total se obtiene multiplicando el costo por la cantidad de noches.  

---

## ✅ Casos de prueba destacados

Ejemplos validados con JUnit:

- **Agregar personas a un alojamiento**  
  - No permite duplicados por DNI.  
  - No permite superar la capacidad.  

- **Cálculo de precios**  
  - Casa con 2 personas no frecuentes por 2 noches → **$1000**.  
  - Casa con 2 personas no frecuentes + 2 personas frecuentes por 1 noche → **$950**.  

---

## 🚀 Ejecución del trabajo práctico
1. Importar el proyecto en **Eclipse IDE**.  
2. Compilar las clases del paquete `dominio`.  
3. Ejecutar los tests de la clase `TestSistemaReservas` para validar los casos implementados.  

---

## 📌 Conclusión
El sistema implementado permite modelar de manera clara la gestión de reservas en alojamientos, contemplando la capacidad, la validación de clientes y el cálculo correcto de precios con descuentos.  

Este trabajo práctico refuerza el uso de **POO en Java**, la importancia de las validaciones de negocio y la utilidad de las **pruebas unitarias** para garantizar la calidad del software.

---
