# ejercicioV
# Análisis de Circuito Verde

## propósito del sistema

* **Objetivo principal:** Desarrollar un simulador educativo interactivo de lógica digital y compuertas lógicas implementado en Java sobre el framework LibGDX.
* **Entorno del juego:** Proporciona un espacio donde el usuario interactúa con componentes electrónicos virtuales, evalúa estados lógicos y gestiona el flujo de señales dentro de un circuito digital.
* **Calidad del diseño:** Lo fundamentamos en el patrón Modelo-Vista-Controlador para asegurar la escalabilidad, mantenibilidad y prueba del código.

## Aplicación del Patrón modelo vista controlador

* **Capa del Modelo:**
* Encapsula la representación de los componentes del circuito y todas las reglas de juego.
* Contiene la jerarquía de compuertas lógicas y las estructuras de datos que almacenan los estados de las señales electrónicas.
* Funciona de forma completamente autónoma, sin referencias a librerías de gráficos ni a la interfaz de usuario.


* **Capa de la Vista:**
* Renderiza gráficamente el simulador utilizando los módulos visuales de LibGDX.
* Muestra en pantalla las entradas, salidas y el estado visual de cada compuerta del circuito.
* Actúa como un reflejo visual pasivo, sin tomar decisiones lógicas ni procesar cálculos de señales.


* **Capa del Controlador:**
* Intermedia el flujo de comunicación entre el usuario, la vista y el modelo.
* Captura los eventos e interacciones del operador (clics de ratón, teclas) y los traduce en instrucciones para actualizar el modelo.
* Notifica a la vista cuando debe refrescar la pantalla para reflejar los cambios realizados en el modelo.



## Jerarquía de clases, herencia y polimorfismo

* **Clase base abstracta (`CompuertaLogica`):**
* Define los atributos compartidos por todos los componentes, como las terminales de entrada (`entradaA`, `entradaB`) y de resultado (`salida`).
* Declara el método abstracto `evaluar()`, obligando a las clases hijas a definir su propio comportamiento lógico.


* **Especialización de compuertas (`CompuertaAND`, `CompuertaOR`, `CompuertaXOR`):**
* Heredan directamente de `CompuertaLogica` e implementan la lógica de sus respectivas tablas de verdad dentro del método `evaluar()`.


* **Polimorfismo aplicado:**
* Permite que las clases gestoras del tablero traten a cualquier componente de forma genérica como un objeto de tipo `CompuertaLogica`.
* Ejecuta la evaluación lógica sin necesidad de verificar el tipo concreto de compuerta en tiempo de ejecución, facilitando la adición futura de nuevas compuertas (como NOT o NAND).



## como funciona el circuito

* **Clase `TableroCircuito`:**
* Administra el estado global del circuito almacenando una lista dinámica (`List<CompuertaLogica>`) de componentes.
* Coordina la conexión de nodos y activa las evaluaciones en cadena cuando el usuario modifica una señal de entrada.


* **Clase `GestorJSON`:**
* Responsable de la persistencia del progreso mediante la serialización del estado del tablero hacia un archivo en formato JSON.
* Reconstruye la sesión guardada al iniciar el juego, instanciando nuevamente la colección polimórfica del tablero de forma independiente a la capa visual.