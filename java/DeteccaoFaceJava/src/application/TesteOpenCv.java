package application;

import java.lang.reflect.Parameter;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import util.ConverteImagemColoridaParaCinza;
import util.DetectaObjeto;
import util.GeradorDeImagem;
import util.ParametrizacaoCascadeFace;
import util.ParametrizacaoCascadeOlhos;

public class TesteOpenCv {

    public static void main(String[] args) {
        //adicionando biblioteca do OpenCv
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println(Core.VERSION);

        Mat imagemColorida = Imgcodecs.imread("src\\img\\pessoas\\pessoas4.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);
        ParametrizacaoCascadeFace parametroFace = new ParametrizacaoCascadeFace(imagemColorida);
        DetectaObjeto.Detectar(imagemColorida, parametroFace);
        ParametrizacaoCascadeOlhos parametroOlho = new ParametrizacaoCascadeOlhos(imagemColorida);
        DetectaObjeto.Detectar(imagemColorida, parametroOlho,new Scalar(0,255,255));

        GeradorDeImagem gerador = new GeradorDeImagem(imagemColorida);
        gerador.Constroi();
    }
}
