package ar.com.educacionit.files;

import java.io.File;

//El file de java es el io

public class FileMain {

	public static void main(String[] args) {

		//Ruta de referencia donde se encuentra una carpeta
		File afile = new File("c:/carpeta"); //Esto es un puntero
		
		boolean exists = afile.exists();
		System.out.println(exists);
		
		
		System.out.println(afile.isDirectory()); //Es un directoria
		
		//Investigar algoritmo recursivo para mostrar los archivos de las carpetas
		//tiene un caso base que hace recortar el algoritmo recursivo
		System.out.println(afile.isFile()); //Pregunta si es una carpeta
	}
	
		public File recorrer(File f) {
			
			if(!f.isDirectory()) {
				System.out.println(f.getName());
			}else {
				recorrer(f);
			}
			return f;
		}

}
