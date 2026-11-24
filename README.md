## Fundamentos de Programación | Tarea 4
Javier Martinez Torres C6J031

## DESCRIPCIÓN
Navega Seguro es un libro interactivo educativo que enseñará conceptos fundamentales de seguridad digital mediante 
capítulos breves, ejemplos de situaciones cotidianas, recomendaciones, actividades y evaluaciones.

## INSTRUCCIONES
1. Utiliza los botones "Anterior" y "Siguiente" ubicados en la parte inferior de la ventana para desplazarte por las páginas de contenido.
2. Cuando termines de leer el contenido, presiona "Responder" para desplegar la sección de Evaluación
   2.1. Se desplegarán ventanas con las preguntas. Para cada una selecciona su posible respuesta correcta.
3. Al terminar la Evaluación se desplegarán los resultados del intento. Si deseas volver a realizar la actividad presiona el botón
   "Responder" nuevamente para comenzar un nuevo intento.
   3.1. Después de 3 intentos se despliegan los resultados finales con la cantidad de aciertos de cada intento.
4. Para cerrar el libro presiona la X ubicada en la parte superior de la ventana.

## PRINCIPALES CLASES

- *Página:* Clase abstracta del proyecto. Guarda los atributos principales de las páginas del libro y contiene el método abstracto
que permite mostrar el contenido.
- *LibroInteractivo:* Contiene los arreglos y métodos principales para crear las páginas, guardar las respuestas correctas y
registrar el historial y los intentos realizados.
- *ControladorLibro:* Establece la conexión entre las clases de paquete modelo con los elementos de la vista.
- *Principal:* Crea la instancia al controlador y ejecuta el proyecto.
