/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Mat;

/**
 *
 * @author Admin
 */
public class GeradorDeImagem {
    private Mat matrizImagem;


    public GeradorDeImagem(Mat matrizImagem) {
        this.matrizImagem = matrizImagem;
    }

    public BufferedImage ConverteMatParaImagem(){
        if(matrizImagem == null)
            return null;
        int type = BufferedImage.TYPE_BYTE_GRAY;
        if (matrizImagem.channels() > 1) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }

        int bufferSize = matrizImagem.channels() * matrizImagem.cols() * matrizImagem.rows();
        byte[] bytes = new byte[bufferSize];
        matrizImagem.get(0, 0, bytes);
        BufferedImage imagem = new BufferedImage(matrizImagem.cols(), matrizImagem.rows(), type);
        byte[] targetPixels = ((DataBufferByte) imagem.getRaster().getDataBuffer()).getData();
        System.arraycopy(bytes, 0, targetPixels, 0, bytes.length);
        return imagem;
    }
    
    public void Constroi(){
        BufferedImage imagemConvertida = ConverteMatParaImagem();
        if(imagemConvertida == null)
            return;
        ImageIcon icon = new ImageIcon(imagemConvertida);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(imagemConvertida.getWidth() + 50, imagemConvertida.getHeight() + 50);
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
