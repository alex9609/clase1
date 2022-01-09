package ar.com.educacionit.exceptions;

public class ConnectionMain {

	public static void main(String[] args) {
		
		
		Conexion c = new Conexion();
		//c.commit();
		
		
		try {
			c.open();
			c.close();
			//c.open();
			c.commit();
		} catch (ConnectionIsAlreadyOpenException|ConnectionIsNotOpenException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (ConnectionIsNotOpenException e) {
				e.printStackTrace();
			}
		}
		
	}

}
