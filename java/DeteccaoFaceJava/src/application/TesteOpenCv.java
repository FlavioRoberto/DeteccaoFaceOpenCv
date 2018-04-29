package application;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import util.ConverteImagemColoridaParaCinza;
import util.GeradorDeImagem;

public class TesteOpenCv {

    public static void main(String[] args) {
        //adicionando biblioteca do OpenCv
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println(Core.VERSION);

        //Convertendo a imagem para uma matriz numérica
        Mat imagemColorida = Imgcodecs.imread("src\\img\\opencv.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);
        GeradorDeImagem gerador = new GeradorDeImagem(imagemColorida);
        gerador.Constroi();
        
        Mat imagemCinza = ConverteImagemColoridaParaCinza.converte(imagemColorida);
        GeradorDeImagem gerador2 = new GeradorDeImagem(imagemCinza);
        gerador2.Constroi();
    }
}
