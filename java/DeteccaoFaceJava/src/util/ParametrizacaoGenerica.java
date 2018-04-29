package util;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.objdetect.CascadeClassifier;


public class ParametrizacaoGenerica implements IParametrizacao{
    private MatOfRect itensDetectados = new MatOfRect();

    public ParametrizacaoGenerica(Mat imagemColorida, String localCascade) {
        Mat imagemCinza = ConverteImagemColoridaParaCinza.converte(imagemColorida);
        CascadeClassifier classificador = new CascadeClassifier(localCascade);
        classificador.detectMultiScale(imagemCinza, itensDetectados);
    }

    @Override
    public MatOfRect resultadoDeteccao() {
        return itensDetectados;
    }
}
