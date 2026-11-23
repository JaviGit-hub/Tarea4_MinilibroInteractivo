/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author javim
 */
public class PaginaActividad extends Pagina {

    public PaginaActividad(String titulo, int numeroPagina, String contenido) {
        super(titulo, numeroPagina, contenido);
    }

    @Override
    public String mostrarContenido() {
        return "Pagina " + getNumeroPagina() + ": " + getTitulo()
                + "Lee las tres preguntas y selecciona una opción para cada una.\n\n"
                + getContenido();
    }

}
