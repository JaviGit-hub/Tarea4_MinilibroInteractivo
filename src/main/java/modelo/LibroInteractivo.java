/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Evaluacion;

/**
 *
 * @author javim
 */
public class LibroInteractivo {

    private ArrayList<Pagina> paginas = new ArrayList<>();
    private int[] respuestasCorrectas = {3, 2, 3};
    private Evaluacion[][] preguntas = new Evaluacion[1][3];
    private int[][] historial = new int[3][3];
    private int intentos = 0;

    public LibroInteractivo() {
        //Con esta condición las páginas solo se cargan cuando la colección está vacía
        if (paginas.isEmpty()) {
            paginas.add(new PaginaInformativa(
                    "Contraseñas seguras", 1,
                    "Una contraseña protege el acceso a tus cuentas digitales.\n"
                    + "Es recomendable crear contraseñas largas, difíciles de adivinar "
                    + "y diferentes para cada cuenta.\n\n"
                    + "Evita nombres, fechas de nacimiento y combinaciones como 12345678.\n\n"
                    + "CONSEJO: Utiliza un gestor de contraseñas y activa la "
                    + "autenticación en dos pasos cuando esté disponible."));

            paginas.add(new PaginaInformativa(
                    "Mensajes sospechosos", 2,
                    "Algunas personas envían mensajes falsos para intentar robar "
                    + "contraseñas o datos personales. Esta práctica se conoce como phishing.\n"
                    + "Desconfía de los mensajes que ofrecen premios inesperados, "
                    + "amenazan con bloquear tu cuenta o solicitan datos urgentes.\n\n"
                    + "CONSEJO: Para verificar una cuenta, abre directamente la "
                    + "aplicación o el sitio oficial y evita el enlace del mensaje."));

            paginas.add(new PaginaInformativa(
                    "Protección de datos personales", 3,
                    "Tu número de teléfono, dirección y ubicación son datos personales.\n"
                    + "Compartirlos públicamente o con desconocidos puede ponerte en riesgo. "
                    + "Revisa quién puede ver tus publicaciones y qué información muestras.\n\n"
                    + "CONSEJO: No compartas tu dirección ni tu teléfono con personas "
                    + "desconocidas en redes sociales o videojuegos."));

            paginas.add(new PaginaInformativa("ACTIVIDAD DE REPASO ", 4, "Responde las preguntas que se te presentan\n"
                    + "Presiona RESPONDER para empezar"));

            preguntas[0][0] = new Evaluacion("1. ¿Cuál contraseña es más segura?\n",
                    new String[]{"1) 12345678\n",
                        "2) miclave2026\n",
                        "3) Rio-Luna!92_Cielo\n\n"});
            preguntas[0][1] = new Evaluacion("2. Un correo te exige verificar una cuenta mediante un enlace. ¿Qué harías?\n",
                    new String[]{"1) Abrir el enlace inmediatamente\n",
                        "2) Entrar por mi cuenta al sitio oficial\n",
                        "3) Responder enviando mi contraseña\n\n"});
            preguntas[0][2] = new Evaluacion("3. Una persona desconocida pide tu dirección en un videojuego. ¿Qué harías?\n",
                    new String[]{"1) La comparto\n",
                        "2) Envio solamente mi teléfono\n",
                        "3) No comparto mis datos y reporto la situación\n\n"});

        }
    }

    public int cantidadPaginas() {
        return paginas.size();
    }

    public Evaluacion obtenerPregunta(int numero) {
        return preguntas[0][numero]; // matriz de objetos
    }

    public Pagina obtenerPagina(int numero) {
        if (numero < 0 || numero >= paginas.size()) {
            JOptionPane.showMessageDialog(null, "La página solicitada no existe");
        }
        return paginas.get(numero);
    }

    public String listarPaginas() {
        String texto = "";

        for (int i = 0; i < paginas.size(); i++) {
            Pagina pagina = paginas.get(i);
            texto += pagina.getNumeroPagina();
        }
        return texto;
    }

    public int getIntentos() {
        return intentos;
    }

    public int registrarRespuestas(int[] respuestas) {
        if (intentos >= 3) {
            throw new IllegalStateException("Sin intentos restantes");
        }
        if (respuestas.length != 3) {
            throw new IllegalArgumentException("Para continuar responde las preguntas");
        }
        int puntos = 0;
        for (int i = 0; i < respuestas.length; i++) {
            historial[intentos][i] = respuestas[i]; // matriz primitiva
            if (respuestas[i] == respuestasCorrectas[i]) {
                puntos++;
            }
        }
        intentos++;
        return puntos;
    }

    public int contarAciertos(int numeroIntento) {
        if (numeroIntento < 1 || numeroIntento > intentos) {
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
        if (numeroIntento < 1 || numeroIntento > intentos) {
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
        if (intentos == 0) {
            return "Todavía no has realizado ningún intento";
        }

        String texto = "HISTORIAL DE INTENTOS\n";
        for (int i = 1; i <= intentos; i++) {
            texto += "Intento " + i + ": " + contarAciertos(i) + " de 3 aciertos\n\n";
        }
        texto += "INTENTOS DISPONIBLES: " + (3 - intentos);
        return texto;
    }
}
