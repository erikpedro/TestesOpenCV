package br.com.opencv.deteccao;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;



import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;


public class TesteOpencv {

	public static void main(String[] args) {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.out.println(Core.VERSION);

		Mat imagemBunda = imread("src/br/com/opencv/deteccao/Fo.jpg", IMREAD_COLOR);
		Utilitario util = new Utilitario();
		util.mostraImagem(util.convertMatToImage(imagemBunda));

		Mat imagemCinza = new Mat();
		Imgproc.cvtColor(imagemBunda, imagemCinza, 6 );
		util.mostraImagem(util.convertMatToImage(imagemCinza));

	}

}
