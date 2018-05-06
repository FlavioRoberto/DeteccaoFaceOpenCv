/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;


public class DetectaObjeto {
    

    public static void Detectar(Mat imagemColorida, IParametrizacao cascade,Scalar cor) {
        
        if(cor == null)
            cor = new Scalar(0,0,255);
        
        if(cascade == null)
            return;
        
        if(cascade.resultadoDeteccao() == null)
            return;
        //percorrendo a matriz de faces detectadas
        for (Rect result : cascade.resultadoDeteccao().toArray()) {
            //desenhando o retangulo na imagem
            Imgproc.rectangle(imagemColorida, new Point(result.x, result.y),
                    new Point(result.x + result.width, result.y + result.height),
                   cor, 2);

        }
    }
    
    public static void Detectar(Mat imagemColorida, IParametrizacao cascade) {
        DetectaObjeto.Detectar(imagemColorida, cascade, null);
    }
}
