package ar.com.educacionit.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//El file de java es el io

public class FileMain2 {

	public static void main(String[] args) {

		//Ruta de referencia donde se encuentra una carpeta
		File afile = new File("c:/carpeta/texto.txt"); //Esto es un puntero
		
		if(afile.exists()) {
			
			//Lector de archivo
			
			try (FileReader fr = new FileReader(afile);){
				int dato = fr.read();
				
				while((dato = fr.read()) != -1) {
					System.out.print((char) dato);
				}
			} catch (Exception e) {
				System.err.println(e);
			}		
			
		}
		
	}
	

}
