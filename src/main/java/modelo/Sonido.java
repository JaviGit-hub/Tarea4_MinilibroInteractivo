/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.Toolkit;

/**
 *
 * @author Maria
 */

// Ejemplo elemental de concurrencia: un sonido desde otro hilo.
public class Sonido extends Thread {

    @Override
    public void run() {
        Toolkit.getDefaultToolkit().beep();
    }
}
