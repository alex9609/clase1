package ar.com.educacionit.generic;

public abstract class BaseFile {

	protected String filePath;
	public BaseFile(String path) {
		if (path == null) {
			throw new IllegalArgumentException("Debe indicar un path de archivo");
		}
		this.filePath = path;
	}

	public String getFilePath() {
		if (filePath == null) {
			// Uso un path por defecto
		}
		return filePath;
	}

}
