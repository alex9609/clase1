package clase6.OOP;

public class Auto {
	String marca;
	String modelo;
	float velocidad;//Por defecto es 0.0
	boolean encendido;//Por defecto es false
	float velocidadMaxima;

	Auto(String marca,String modelo, float velocidadMaxima){
		this.marca = marca;
		this.modelo = modelo;
		this.velocidadMaxima = velocidadMaxima;
		this.velocidad = 0;
		this.encendido = true;
		
		//ctr+shift+i ejecuta la linea que quiero ver
		
		//f5 o f6
		
	}
	//Metodos que hacen que un auto cambie su estado
	void encender() {
		if(encendido == false) {
			encendido = true;
		}else {
			System.out.println("Ya estpa encendido");
		}
	}
	
	void apagar() {
		if(encendido == true) {
			encendido = false;
		}
	}
	
	void acelerar() {
		if(encendido) {
			if(velocidad < velocidadMaxima) {
				velocidad += 1;
			}else {
				System.out.println("Velocidad máxima alcanzada");
			}
		}else {
			System.out.println("Encience el auto");
		}
	}
	
	void frenar() {
		if(encendido) {
			if(velocidad > 0) {
				velocidad -= 1;
			}else {
				System.out.println("El auto ya esta frenado");
			}
		}else {
			System.out.println("Encienda el auto primero");
		}
	}

}
