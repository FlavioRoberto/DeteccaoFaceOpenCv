/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author Admin
 */
public class DetectaFace {
    public static void Detectar(Mat imagemColorida){
        Mat imagemCinza = ConverteImagemColoridaParaCinza.converte(imagemColorida);
        CascadeClassifier classificador = new CascadeClassifier("src\\cascades\\haarcascade_frontalface_default.xml");
        //faz a detecção das com o retangulo
        MatOfRect facesDetectadas = new MatOfRect();
        classificador.detectMultiScale(imagemCinza, facesDetectadas);
        //quantidade de faces detectadas
        System.out.println(facesDetectadas.toArray().length);
        
        //percorrendo a matriz de faces detectadas
        for(Rect faces : facesDetectadas.toArray()){
            //desenhando o retangulo na imagem
            Imgproc.rectangle(imagemColorida, new Point(faces.x,faces.y),
                    new Point(faces.x + faces.width,faces.y + faces.height),
                    new Scalar(0,0,255));
            
        }
    }
}
