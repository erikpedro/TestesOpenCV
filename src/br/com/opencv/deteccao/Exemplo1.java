package br.com.opencv.deteccao;




import static org.opencv.imgcodecs.Imgcodecs.imread;
import static  org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;


public class Exemplo1 {
	
	
	public void faceolho() {
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat imagemColorida = imread("src/pessoas/pessoas3.jpg");
		Mat imagemCinza = new Mat();
		
		Imgproc.cvtColor(imagemColorida, imagemCinza, COLOR_BGR2GRAY);
		
		CascadeClassifier cascadeClassifier = new CascadeClassifier("src/cascades/haarcascade_frontalface_default.xml");
	
		MatOfRect facesDetectadas = new MatOfRect();
		cascadeClassifier.detectMultiScale(imagemCinza, facesDetectadas,
				1.19, // scale factor
				5, // minNeighbors
				0, // flags
				new Size(30,30), // minSize
				new Size(500,500)); // maxSize
		System.out.println(facesDetectadas.toArray().length);
		
		
		for (Rect rect : facesDetectadas.toArray()) {
			System.out.println(rect.x + " " + rect.y + " " + rect.width + " " + rect.height );
			Imgproc.rectangle(imagemColorida, new Point(rect.x, rect.y),
					new Point(rect.x + rect.width, rect.y + rect.height), 
					new Scalar(0,0,255), 2);
		}
		
		Utilitario util = new Utilitario();
		util.mostraImagem(util.convertMatToImage(imagemColorida));
		
	}
	

	
}
