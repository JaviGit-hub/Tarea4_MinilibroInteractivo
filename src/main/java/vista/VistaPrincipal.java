/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
/**
 *
 * @author Maria
 */
public class VistaPrincipal extends javax.swing.JFrame {

    public VistaPrincipal() {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        scrollTexto = new javax.swing.JScrollPane();
        txtContenido = new javax.swing.JTextArea();
        panelBotones = new javax.swing.JPanel();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnResponder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mi primer minilibro - MVC");

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("MI PRIMER MINILIBRO - EL MANGLAR");
        getContentPane().add(lblTitulo, java.awt.BorderLayout.NORTH);

        txtContenido.setEditable(false);
        txtContenido.setColumns(28);
        txtContenido.setRows(10);
        txtContenido.setLineWrap(true);
        txtContenido.setWrapStyleWord(true);
        scrollTexto.setViewportView(txtContenido);

        getContentPane().add(scrollTexto, java.awt.BorderLayout.CENTER);

        btnAnterior.setText("Anterior");
        panelBotones.add(btnAnterior);

        btnSiguiente.setText("Siguiente");
        panelBotones.add(btnSiguiente);

        btnResponder.setText("Responder");
        panelBotones.add(btnResponder);

        getContentPane().add(panelBotones, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents
    // </editor-fold>

    // Registramos el mismo controlador en todos los botones.
    public void addButtonListener(ActionListener listener) {
        btnAnterior.setActionCommand("Anterior");
        btnSiguiente.setActionCommand("Siguiente");
        btnResponder.setActionCommand("Responder");

        btnAnterior.addActionListener(listener);
        btnSiguiente.addActionListener(listener);
        btnResponder.addActionListener(listener);
    }

    // El controlador puede mostrar informacion y habilitar los botones.
    public void mostrarTexto(String texto) {
        txtContenido.setText(texto);
    }

    public void habilitarBotones(boolean anterior, boolean siguiente, boolean responder) {
        btnAnterior.setEnabled(anterior);
        btnSiguiente.setEnabled(siguiente);
        btnResponder.setEnabled(responder);
    }

    // Accesos mantenidos para facilitar la lectura del ejemplo.
    public JButton getBtnAnterior() { return btnAnterior; }
    public JButton getBtnSiguiente() { return btnSiguiente; }
    public JButton getBtnResponder() { return btnResponder; }
    public JTextArea getTxtContenido() { return txtContenido; }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnResponder;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JScrollPane scrollTexto;
    private javax.swing.JTextArea txtContenido;
    // End of variables declaration//GEN-END:variables
}
