package Hilos;

public class Hilo extends Thread {
	
	private String nombre;
	
	public Hilo() {
		
	}
	
	
	public Hilo(String nombre) {
		this.nombre = nombre;
		
	}
	@Override
	public void run() {
		for(int i =0; i<100; i++) {
			System.out.println(nombre + i);
		}
	}
}
