package ar.com.educacionit.web.enums;

public enum ViewKeysEnum implements Enumerable{
	USERNAME("username"),
	PASSWORD("password"),
	ERROR_GENERAL("error"),
	USUARIO_PASSWORD_INVALIDADO("Usuario/Password incorrectos"),
	USER("user"),
	UPLOAD_FILE("uploadfile"),
	UPLOAD_PREVIEW_KEY("upload_preview_key"),
	ARTICULOS_FAIL("articulos_fails"),
	ARTICULOS_OKS("articulos_oks"),
	FORMATO("formato");
	
	
	private String param;

	private ViewKeysEnum(String param) {
		this.param = param;
	}
	
	public String getParam() {
		return this.param;
	}
}
