package ar.com.educacionit.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//El file de java es el io

public class FileMain3 {

	public static void main(String[] args) throws IOException {

		//Ruta de referencia donde se encuentra una carpeta
		File afile = new File("c:/carpeta/Binario.docx"); //Esto es un puntero
		
		if(afile.exists()) {
			
			InputStream is =new FileInputStream(afile);	
			OutputStream os = new FileOutputStream("c:/carpeta/BinarioCopia.docx");
			
			int length;
			byte[] buffer = new byte[1024];
			
			while((length = is.read(buffer)) > 0) {
				os.write(buffer,0,length);
			}
			is.close();
			os.close();
			
		}
		
	}
	

}
