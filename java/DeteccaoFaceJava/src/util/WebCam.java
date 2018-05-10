/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class WebCam extends javax.swing.JFrame {

    private final int ID_DISPOSITIVO = 0;
    private VideoCapture captura;

    public WebCam() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
        //carregando a biblioteca do openCV
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        WebCam janela = new WebCam();

        //definindo configuração dos parametros
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

        janela.exibeVideo();

    }

    private void exibeVideo() {
        Mat video = new Mat();
        VideoCapture captura = new VideoCapture(ID_DISPOSITIVO);

        if (!captura.isOpened()) {
            return;
        }

        while (true) {
            new Runnable() {
                @Override
                public void run() {

                    captura.read(video);
                    if (!video.empty()) {
                        DetectaObjeto.Detectar(video, new ParametrizacaoCascadeWebCam(video));
                        setSize(video.width() + 25, video.height() + 50);
                        GeradorDeImagem gerenDeImagem = new GeradorDeImagem(video);
                        BufferedImage imagemConvertida = gerenDeImagem.ConverteMatParaImagem();
                        Graphics grafico = jPanel1.getGraphics();
                        grafico.drawImage(imagemConvertida, 0, 0, imagemConvertida.getWidth(),
                                imagemConvertida.getHeight(), null);
                    }
                }
            }.run();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        captura.release();
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
