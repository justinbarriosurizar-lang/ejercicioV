# Circuito Verde

Mini juego/simulador educativo desarrollado en Java con LibGDX para poner en práctica la lógica digital, la arquitectura MVC y los conceptos de POO.


## ¿De qué trata el proyecto?

La idea principal fue hacer un simulador interactivo donde podemos ir armando circuitos en un tablero digital, probando compuertas lógicas y viendo cómo fluye la señal de entrada a salida. 

Para que el proyecto no se volviera un desastre a nivel de código y fuera fácil de mantener, organizamos todo usando la arquitectura **Modelo-Vista-Controlador (MVC)**:

* **Modelo:** Es la lógica pura del juego. Aquí están las clases de las compuertas y los valores booleanos. No sabe nada de gráficos ni de LibGDX, solo procesa datos.
* **Vista:** Se encarga únicamente de dibujar el tablero y las compuertas en pantalla usando LibGDX. No calcula resultados, solo muestra lo que el modelo le indica.
* **Controlador:** Detecta lo que hace el usuario, le avisa al modelo para que actualice los datos y le dice a la vista que vuelva a pintar.

## Clases principales y cómo están conectadas

### CompuertaLogica
Es la clase padre de todas las compuertas. 
* **Atributos:** Tiene las entradas `-boolean entradaA`, `-boolean entradaB` y la `-boolean salida`.
* **Métodos:** Incluye el método abstracto `+evaluar(): boolean`, que obliga a cada compuerta a calcular su propio resultado.

### CompuertaAND, CompuertaOR, CompuertaXOR (Subclases)
Heredan directamente de `CompuertaLogica`. Cada una sobreescribe el método `+evaluar(): boolean` según su tabla de verdad. Gracias al polimorfismo, el programa maneja cualquier compuerta de forma genérica sin importar de qué tipo sea.

### CircuitoVerdeGame
Es la clase principal que extiende de `<<LibGDX>> Game`. Se encarga de gestionar las pantallas (`+setScreen()`, `+getScreen()`) y mantener el ciclo de vida de la aplicación.

### TableroCircuito
Es la clase donde pasa la magia del juego.
* **Atributos:** Guarda una lista de compuertas (`-List<CompuertaLogica> compuertas`).
* **Métodos:** Permite agregar/eliminar compuertas (`+agregarCompuerta()`, `+eliminarCompuerta()`) y recalcular las señales cuando algo cambia (`+actualizarCircuito()`).

### GestorJSON
Clase dedicada a guardar y cargar partidas.
* **Métodos:** `+guardarProgreso()` y `+cargarProgreso()`. Lee y escribe el estado del tablero en un archivo JSON para no perder el avance al cerrar la aplicación.

## ¿Cómo funciona el juego al final?

Básicamente entras a la aplicación, colocas tus compuertas (`AND`, `OR`, `XOR`) en el `TableroCircuito`, cambias los interruptores de entrada y el sistema evalúa la señal en cadena. Si quieres pausar o seguir después, el `GestorJSON` guarda la configuración de tus compuertas en un archivo local para recuperar tu partida en cualquier momento.
