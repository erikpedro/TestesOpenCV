package br.com.opencv.deteccao;

import static org.opencv.imgcodecs.Imgcodecs.IMREAD_COLOR;
import static org.opencv.imgcodecs.Imgcodecs.imread;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class ConversorImagen {
	
	public void imagenParaCinza() {
		
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
