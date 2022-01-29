package Hilos;

public class HilosMain {

	public static void main(String[] args) {
		
		//Los hilos brinda la facilidad de trabajar varios procesos a la vez
		
		//Metodo disponible ya que estamos heredando
		//de la clase padre thread
		Hilo hilo1 = new Hilo("UNO");
		hilo1.start();
		
		Hilo hilo2 = new Hilo("DOS");
		hilo2.start();
	}

}
