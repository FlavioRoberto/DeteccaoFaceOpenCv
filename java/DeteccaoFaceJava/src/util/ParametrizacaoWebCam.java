/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Size;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author Admin
 */
public class ParametrizacaoWebCam implements IParametrizacao {

   private String localCascade = "src\\cascades\\haarcascade_frontalface_default.xml";
    private MatOfRect facesDetectadas = new MatOfRect();

    public ParametrizacaoWebCam(Mat imagemColorida) {
        Mat imagemCinza = ConverteImagemColoridaParaCinza.converte(imagemColorida);
        CascadeClassifier classificador = new CascadeClassifier(localCascade);
        classificador.detectMultiScale(imagemCinza, facesDetectadas,
                1.02, // scale factor - quando faces estão perto da camera elas serão maiores que a do fundo
                1, //viznihos mínimos, neste caso quanto maior melhor a precisão
                0, //flags recomneda-se 0 pois o harrs cascade é um método ultrapassado
                new Size(100, 100), new Size(1200, 1200));
    }

    @Override
    public MatOfRect resultadoDeteccao() {
        return facesDetectadas;
    }
    
}
