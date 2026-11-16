/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.JOptionPane;

/**
 *
 * @author javim
 */
public class Evaluacion {

    private int[] respuestasCorrectas;
    private int[] respuestasSeleccionadas;
    private int[][] historial;
    private int intentosRealizados;

    public Evaluacion() {
        respuestasCorrectas = new int[]{1, 3, 2};
        respuestasSeleccionadas = new int[3];
        historial = new int[3][3];
        intentosRealizados = 0;
    }

    public int getIntentosRealizados() {
        return intentosRealizados;
    }

    public int registrarIntento(int[] respuestas) {
        if (intentosRealizados >= 3) {
            JOptionPane.showMessageDialog(null, "Ya realizaste los 3 intentos permitidos");
            return -1;
        }

        if (respuestas == null || respuestas.length != 3) {
            JOptionPane.showMessageDialog(null, "Debes responder las preguntas");
            return -1;
        }

        for (int i = 0; i < 3; i++) {
            if (respuestas[i] < 1 || respuestas[i] > 3) {
                JOptionPane.showMessageDialog(null, "Selecciona una respuesta a cada pregunta");
                return -1;
            }
        }

        for (int i = 0; i < 3; i++) {
            respuestasSeleccionadas[i] = respuestas[i];
            historial[intentosRealizados][i] = respuestasSeleccionadas[i];

        }
        intentosRealizados++;
        return contarAciertos(intentosRealizados);
    }

    public int contarAciertos(int numeroIntento) {
        if (numeroIntento < 1 || numeroIntento > intentosRealizados) {
            JOptionPane.showMessageDialog(null, "El intento indicado no existe");
            return -1;
        }

        int aciertos = 0;
        for (int i = 0; i < 3; i++) {
            if (historial[numeroIntento - 1][i] == respuestasCorrectas[i]) {
                aciertos++;
            }

        }
        return aciertos;
    }

    public String consultarIntento(int numeroIntento) {
        if (numeroIntento < 1 || numeroIntento > intentosRealizados) {
          return "El intento indicado NO EXISTE";
        }

        String texto = "INTENTO" + numeroIntento + "\n\n";
        for (int i = 0; i < 3; i++) {
            texto += "Pregunta " + (i + 1) + "opción"
                    + historial[numeroIntento - 1][i] + "\n";
        }
        texto += "\nRESPUESTAS CORRECTAS: " + contarAciertos(numeroIntento) + " de 3";
        return texto;
    }

    public String obtenerHistorial() {
        if (intentosRealizados == 0) {
            return "Todavía no has realizado ningún intento";
        }

        String texto = "HISTORIAL DE INTENTOS\n\n";
        for (int i = 1; i <= intentosRealizados; i++) {
            texto += "Intento " + i + ": " + contarAciertos(i) + " de 3 aciertos\n";
        }
        texto += "INTENTOS DISPONIBLES: " + (3 - intentosRealizados);
        return texto;
    }
}
