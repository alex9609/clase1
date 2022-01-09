package ar.com.educacionit.exceptions;

public class Conexion {
	
	public boolean open;
	public boolean error;
	
	public void open() throws ConnectionIsAlreadyOpenException {
		if(open) {
			throw new ConnectionIsAlreadyOpenException();
		}else {
			open = true;
		}
		
	}

	public void close() throws ConnectionIsNotOpenException {
		if(!open) {
			throw new ConnectionIsNotOpenException();
		}else {
			open = false;
		}
	}
	
	public void commit() {
		if(!open) {
			throw new CommitException("No se ha establecido conexión");			
		}
		if(error) {
			throw new CommitException("Error:");
		}
		System.out.println("Commiting changes");
	}
	
	public void rollback() {
		
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	
	
}
