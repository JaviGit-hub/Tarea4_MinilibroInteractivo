/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Evaluacion;
import modelo.LibroInteractivo;
import modelo.PaginaActividad;
import modelo.Sonido;
import vista.VistaPrincipal;

/**
 *
 * @author javim
 */
public class ControladorLibro implements ActionListener {

    private LibroInteractivo modelo;
    private PaginaActividad pagina;
    private VistaPrincipal vista;
    private int posicion = 0;

    public ControladorLibro() {
        modelo = new LibroInteractivo();
        vista = new VistaPrincipal();
        vista.addButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String opcion = e.getActionCommand();

        switch (opcion) {
            case "Anterior":
                anterior();
                break;
            case "Siguiente":
                siguiente();
                break;
            case "Responder":
                responder();
                break;
        }
    }

    private void mostrarPagina() {
        vista.mostrarTexto(modelo.obtenerPagina(posicion).mostrarContenido());
        vista.habilitarBotones(
                posicion > 0,
                posicion < modelo.cantidadPaginas() - 1,
                posicion == modelo.cantidadPaginas() - 1);
    }

    private void anterior() {
        if (posicion > 0) {
            posicion--;
            mostrarPagina();
        }
    }

    private void siguiente() {
        if (posicion < modelo.cantidadPaginas() - 1) {
            posicion++;
            mostrarPagina();
        }
    }

    private void responder() {
        if (modelo.getIntentos() >= 3) {
            JOptionPane.showMessageDialog(vista, "Ya utilizo los tres intentos.");
            return;
        }

        int[] respuestas = new int[3]; // arreglo unidimensional primitivo
        for (int i = 0; i < 3; i++) {
            Evaluacion evaluacion = modelo.obtenerPregunta(i);
            int respuesta = JOptionPane.showOptionDialog(vista, evaluacion.getTexto(),
                    "Pregunta " + (i + 1), JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, evaluacion.getOpciones(),
                    evaluacion.getOpciones()[0]);
            if (respuesta == -1) {
                JOptionPane.showMessageDialog(vista, "Actividad cancelada. No se guardo el intento.");
                return;
            }
            respuestas[i] = respuesta;
        }

        try {
            int puntos = modelo.registrarRespuestas(respuestas);
            new Sonido().start(); // hilo de sonido: ejemplo basico de concurrencia
            JOptionPane.showMessageDialog(vista,
                    "Respuestas correctas: " + puntos + " de 3\n\n" + modelo.obtenerHistorial());
        } catch (IllegalArgumentException | IllegalStateException ex) {
            JOptionPane.showMessageDialog(vista, ex.getMessage());
        }
    }

    public void iniciar() {
        mostrarPagina();
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
    }

}
