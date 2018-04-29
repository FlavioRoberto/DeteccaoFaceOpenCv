package application;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import util.GeradorDeIMagem;

public class TesteOpenCv {

    public static void main(String[] args) {
        //adicionando biblioteca do OpenCv
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println(Core.VERSION);

        //Convertendo a imagem para uma matriz numérica
        Mat imagemColorida = Imgcodecs.imread("src\\img\\opencv.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);
        GeradorDeIMagem gerador = new GeradorDeIMagem(imagemColorida);
        gerador.Constroi();
    }
}
