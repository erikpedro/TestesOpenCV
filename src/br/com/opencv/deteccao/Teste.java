package br.com.opencv.deteccao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Teste {

	public static void alteraLinha(String palavraAntiga, String palavraNova) throws IOException {
	    String arquivo = "D:\\Fotos\\arquivo.txt";
	    String arquivoTmp = "D:\\Fotos\\arquivo-tmp";

	    BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
	    BufferedReader reader = new BufferedReader(new FileReader(arquivo));
	    
//	    String[] texto = palavraAntiga.split("\n");
//	    System.out.println(Arrays.toString(texto));
	    
	    
	    

	    
	    
	    String linha;
	    while ((linha = reader.readLine()) != null) {
	    	
	    	String[] chave = {linha};
	    	String[] word = {palavraNova}; 

	    	if(chave[0].equals(word[0]))//se as Strings forem iguais
	    	{
	    		System.out.println("ok!");
	    	    }else{
	    	    	linha = linha.replace(palavraAntiga, palavraNova);
	    	}
	    	
	    	
//	        if (linha.contains(palavraAntiga) && !linha.startsWith("#") ) {
//	        	if(palavraAntiga.contains("1920x1200")) {
//	        		linha = linha.replace(palavraAntiga, palavraNova);
//	        	}else if (palavraAntiga.contains("1280x1024")) {
//	        		linha = linha.replace(palavraAntiga, palavraNova);
//				}else if (palavraAntiga.contains("1024x768")) {
//					
//				}else if(palavraAntiga.contains("640x480")) {
//					linha = linha.replace(palavraAntiga, palavraNova);
//				}else {
//					System.out.println("Esta no padrao");
//				}
//	        }
	        writer.write(linha + "\n");
	    }

	    writer.close();        
	    reader.close();

	    new File(arquivo).delete();
	    new File(arquivoTmp).renameTo(new File(arquivo));
	}
	
	
	
	public static void main(String[] args) throws IOException {
		alteraLinha("\"800x600\"", "\"800x600\"");
	}
	
	

}
