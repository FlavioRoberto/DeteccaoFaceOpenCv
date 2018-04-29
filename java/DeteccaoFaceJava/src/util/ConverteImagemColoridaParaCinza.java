/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author Admin
 */
public class ConverteImagemColoridaParaCinza {
    public static Mat converte(Mat imagemColorida){
        if(imagemColorida == null)
             return null;
        
        Mat imagemCinza = new Mat();
        Imgproc.cvtColor(imagemColorida, imagemCinza, Imgproc.COLOR_BGR2GRAY);
        return imagemCinza;
    }
}
