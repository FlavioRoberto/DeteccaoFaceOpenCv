
package application;

import org.opencv.core.Core;

public class TesteOpenCv {
    public static void main(String[] args) {
      //adicionando biblioteca do OpenCv
      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
      System.out.println(Core.VERSION);
    }
}
