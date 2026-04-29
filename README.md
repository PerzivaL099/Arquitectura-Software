# 🏛️ Arquitectura de Software - Patrones de Diseño

Bienvenido al repositorio de **Arquitectura de Software**. Este espacio contiene las tareas, implementaciones y trabajos prácticos desarrollados para la materia de arquitectura de software.

El objetivo principal de este repositorio es demostrar la aplicación práctica de los **Patrones de Diseño (Design Patterns)** propuestos por el *Gang of Four (GoF)* utilizando **Java** como lenguaje principal.

## 🚀 Tecnologías Utilizadas
* **Lenguaje:** Java 100% ☕
* **Paradigma:** Programación Orientada a Objetos (POO)
* **Enfoque:** Arquitectura limpia, encapsulamiento y principios SOLID.

---

## 📂 Contenido del Repositorio

El repositorio está organizado en carpetas individuales por cada patrón de diseño implementado. A continuación se categorizan según su propósito arquitectónico:

### 🏭 Patrones Creacionales
Se enfocan en los mecanismos de creación de objetos, buscando delegar y encapsular la lógica de instanciación.
* 📁 `PatronFabrica` (Factory Method): Define una interfaz para crear un objeto, pero deja que las subclases decidan qué clase instanciar.
* 📁 `PatronFabricaAbstracta` (Abstract Factory): Proporciona una interfaz para crear familias de objetos relacionados o dependientes sin especificar sus clases concretas.

### 🌉 Patrones Estructurales
Se ocupan de cómo se combinan las clases y objetos para formar estructuras más grandes, manteniendo la flexibilidad y eficiencia.
* 📁 `Patron-Composicion` (Composite): Compone objetos en estructuras de árbol para representar jerarquías de parte-todo.
* 📁 `Patron-Decorador` (Decorator): Añade responsabilidades adicionales a un objeto de forma dinámica sin modificar su estructura base.
* 📁 `PatronFachada` / `PatronFachada (1)` (Facade): Proporciona una interfaz unificada y simplificada para un subsistema complejo.
* 📁 `PatronProxy` (Proxy): Proporciona un sustituto o representante para otro objeto para controlar el acceso a este.

### ⚙️ Patrones de Comportamiento
Se centran en la comunicación, asignación de responsabilidades y algoritmos entre objetos.
* 📁 `Patron-Observador` (Observer): Define una dependencia de uno a muchos entre objetos, para que cuando uno cambie de estado, los dependientes sean notificados.
* 📁 `Patron-iterador` (Iterator): Proporciona una forma de acceder secuencialmente a los elementos de un objeto agregado sin exponer su representación subyacente.
* 📁 `PatronEstado` (State): Permite a un objeto alterar su comportamiento cuando su estado interno cambia.
* 📁 `PatronPlantilla` (Template Method): Define el esqueleto de un algoritmo en una operación, delegando algunos pasos a las subclases.

---

## 💻 Cómo ejecutar los ejemplos

Cada carpeta contiene su propio conjunto de clases y, por lo general, una clase de prueba (TestDrive o Main). Para ejecutar cualquier patrón desde la terminal:

1. Navega a la carpeta del patrón deseado:
   ```bash
   cd NombreDeLaCarpeta