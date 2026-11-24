/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author javim
 */
public class LibroInteractivo {

    private ArrayList<Pagina> paginas;

    public LibroInteractivo() {
        paginas = new ArrayList<Pagina>();
    }

    public void agregarPagina(Pagina pagina) {
        paginas.add(pagina);
    }

    public Pagina obtenerPagina(int posicion) {
        if (posicion < 0 || posicion >= paginas.size()) {
            JOptionPane.showMessageDialog(null, "La página solicitada no existe");
        }
        return paginas.get(posicion);
    }

    public int cantidadPaginas() {
        return paginas.size();
    }

    public String listarPaginas() {
        String texto = "";

        for (int i = 0; i < paginas.size(); i++) {
            Pagina pagina = paginas.get(i);
            texto += pagina.getNumeroPagina();
        }
        return texto;
    }

    public void cargarPaginasInformativas() {
        //Con esta condición las páginas solo se cargan cuando la colección está vacía
        if (paginas.isEmpty()) {
            agregarPagina(new PaginaInformativa(
                    "Contraseñas seguras", 1,
                    "Una contraseña protege el acceso a tus cuentas digitales.\n\n"
                    + "Es recomendable crear contraseñas largas, difíciles de adivinar "
                    + "y diferentes para cada cuenta.\n\n"
                    + "Evita nombres, fechas de nacimiento y combinaciones como 12345678.\n\n"
                    + "CONSEJO: Utiliza un gestor de contraseñas y activa la "
                    + "autenticación en dos pasos cuando esté disponible."));

            agregarPagina(new PaginaInformativa(
                    "Mensajes sospechosos", 2,
                    "Algunas personas envían mensajes falsos para intentar robar "
                    + "contraseñas o datos personales. Esta práctica se conoce como phishing.\n\n"
                    + "Desconfía de los mensajes que ofrecen premios inesperados, "
                    + "amenazan con bloquear tu cuenta o solicitan datos urgentes.\n\n"
                    + "CONSEJO: Para verificar una cuenta, abre directamente la "
                    + "aplicación o el sitio oficial y evita el enlace del mensaje."));

            agregarPagina(new PaginaInformativa(
                    "Protección de datos personales", 3,
                    "Tu número de teléfono, dirección y ubicación son datos personales.\n\n"
                    + "Compartirlos públicamente o con desconocidos puede ponerte en riesgo. "
                    + "Revisa quién puede ver tus publicaciones y qué información muestras.\n\n"
                    + "CONSEJO: No compartas tu dirección ni tu teléfono con personas "
                    + "desconocidas en redes sociales o videojuegos."));

            agregarPagina(new PaginaActividad(
                    "Actividad: pon a prueba tu seguridad", 4,
                    "1. ¿Cuál contraseña es más segura?\n"
                    + "   1) 12345678\n   2) miclave2026\n   3) Rio-Luna!92_Cielo\n\n"
                    + "2. Un correo te exige verificar una cuenta mediante un enlace. ¿Qué haces?\n"
                    + "   1) Abro el enlace inmediatamente.\n"
                    + "   2) Entro por mi cuenta al sitio web oficial.\n"
                    + "   3) Respondo enviando mi contraseña.\n\n"
                    + "3. Una persona desconocida pide tu dirección en un videojuego. ¿Qué haces?\n"
                    + "   1) La comparto.\n   2) Envío solamente mi teléfono.\n"
                    + "   3) No comparto mis datos y reporto la situación."));
        }

    }
}

