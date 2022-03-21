package ar.com.educacionit.web.enums;

public enum ViewEnums {
	
	LOGIN("/login.jsp"),
	LOGIN_SUCCESS("/loginSuccess.jsp"),
	HOME("/index.jsp"),
	ERROR_GENERAL("/errorGeneral.jsp");	
	
	private String view;
	private ViewEnums(String view) {
		this.view = view;
	}
	
	public String getView() {
		return this.view;
	}

}