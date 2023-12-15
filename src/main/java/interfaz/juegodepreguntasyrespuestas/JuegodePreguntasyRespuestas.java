/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package interfaz.juegodepreguntasyrespuestas;

import java.util.Random;
import java.util.Scanner;

public class JuegodePreguntasyRespuestas {

    public static void main(String[] args) {
        // Creamos la clase scanner para las entradas de las respuestas del usuario
        Scanner sc = new Scanner(System.in);

        // Creamos la clase random para, mas adelante, ir mostrando las preguntas en orden aleatorio
        Random rm = new Random();

        // Creamos la variable de tipo entero de la puntuacion que el usuario va a ir acumulando a lo largo del juego
        int puntuacion = 0;

        // Creamos 2 arrays, uno con las preguntas y otro con las respuestas
        String[] preguntas = {
            // Preguntas Juan A.
            "¿Cuál es la capital de Francia?",
            "¿Cuál es el símbolo químico del hierro?",
            "¿Cuál es el planeta más cercano al Sol?",
            "¿Cuál es la raíz cuadrada de 25?",
            "¿De qué país es capital Roma?",
            "Cual es la capital de España?",
            "¿Cuanto le mide el pito a Enrique?"
            // Preguntas Enrique
        };

        String[] respuestas = {
            // Respuestas Juan A.
            "Paris",
            "Fe",
            "Mercurio",
            "5",
            "Italia",
            "Madrid",
            "2metros",
            
            // Respuestas Enrique
        };

        // Creamos un bucle para ir intercambiando las preguntas y sus correspondientes respuestas de manera aleatoria conforme se van contestando
        for (int i = 0; i < preguntas.length; i++) {
            int numRandom = rm.nextInt(preguntas.length);

            // Intercambiamos las preguntas
            String rmPregunta = preguntas[i];
            preguntas[i] = preguntas[numRandom];
            preguntas[numRandom] = rmPregunta;

            // Intercambiamos las respuestas correspondientes a sus preguntas
            String rmRespuesta = respuestas[i];
            respuestas[i] = respuestas[numRandom];
            respuestas[numRandom] = rmRespuesta;
        }

        // Creamos un bucle para ir alternando las preguntas y sus respectivas respuestas conforme el usuario las va contestando
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println("Pregunta " + (i + 1) + ":");
            System.out.println(preguntas[i]);

            // Obtenemos la respuesta del usuario
            System.out.println("Tu respuesta: ");
            String respuestaUsuario = sc.nextLine();

            // Verificamos si la respuesta dada por el usuario es correcta
            if (respuestaUsuario.equalsIgnoreCase(respuestas[i])) {
                System.out.println("¡Correcto!");
                puntuacion++;
            } else {
                System.out.println("Incorrecto. La respuesta correcta es: " + respuestas[i]);
            }
            // Creamos una salida para crear un salto de linea en blanco y mejorar la visibilidad del programa
            System.out.println();
        }

        // Mostramos la puntuación final del usuario y dependiendo de si ha acertado correctamente 5 preguntas o más se le indicara que ha ganado y si ha acertado menos de 5 preguntas se le indicara que ha perdido.
        if (puntuacion >= 5) {
            System.out.println("¡Enhorabuena, has ganado! - Tu puntuación final es de: " + puntuacion + " puntos.");
        } else if (puntuacion < 5) {
            System.out.println("¡Qué pena, has perdido! - Tu puntuación final es de: " + puntuacion + " puntos.");
        }

        // Cerramos el scanner
        sc.close();
    }
}
