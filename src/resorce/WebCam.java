package resorce;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import br.com.opencv.deteccao.Utilitario;

import java.awt.FlowLayout;

public class WebCam extends JFrame {

	private JPanel contentPane;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebCam frame = new WebCam();
					frame.setVisible(true);
					frame.mostraVideo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WebCam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JPanel panel =  new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		contentPane.add(panel, BorderLayout.CENTER);
	}
	
	
	
	public void mostraVideo() {
		Mat video = new Mat();
		VideoCapture capture = new VideoCapture(0);
		if(capture.isOpened()) {
			while (true) {
				capture.read(video);
				if(!video.empty()) {
					setSize(video.width() + 50, video.height() + 70);
					BufferedImage image = new Utilitario().convertMatToImage(video);
					Graphics g = contentPane.getGraphics();
					g.drawImage(image, 10, 10, image.getWidth(), image.getHeight(), null);
					
				}
			}
		}
	}

}
