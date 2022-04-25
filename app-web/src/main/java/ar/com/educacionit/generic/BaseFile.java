package ar.com.educacionit.generic;

import javax.servlet.http.Part;

public abstract class BaseFile {

	protected String filePath;
	protected Part filePart;
	
	public BaseFile(String path) {
		if (path == null) {
			throw new IllegalArgumentException("Debe indicar un path de archivo");
		}
		this.filePath = path;
	}
	
	public BaseFile(Part filePart) {
		if(filePart == null) {
			throw new IllegalArgumentException("Debe ingresar un parth valido ");
		}
		this.filePart = filePart;
		
	}

	public String getFilePath() {
		if (filePath == null) {
			// Uso un path por defecto
		}
		return filePath;
	}

}
