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
public class ParametrizacaoCascadeOlhos implements IParametrizacao{
    private String localCascade = "src\\cascades\\haarcascade_eye.xml";
    private MatOfRect olhosDetectados = new MatOfRect();

    public ParametrizacaoCascadeOlhos(Mat imagemColorida) {
        Mat imagemCinza = ConverteImagemColoridaParaCinza.converte(imagemColorida);
        CascadeClassifier classificador = new CascadeClassifier(localCascade);
        classificador.detectMultiScale(imagemCinza, olhosDetectados);
    }

    @Override
    public MatOfRect resultadoDeteccao() {
        return olhosDetectados;
    }
}
