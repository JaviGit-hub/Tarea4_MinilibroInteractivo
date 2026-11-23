/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author javim
 */
public class Evaluacion {

    private String texto;
    private String[] opciones;

    public Evaluacion(String texto, String[] opciones) {
        this.texto = texto;
        this.opciones = opciones;
    }

    public String getTexto() {
        return texto;
    }

    public String[] getOpciones() {
        return opciones;
    }
}
