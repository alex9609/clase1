package clase3;

public class DeterminarMayor {

	public static void main(String[] args) {
		
		double a,b,c;
		
		a = 10;
		b = 60;
		c = 60;
		
		if (a > b && a > c) {
			System.out.println("A es mayor");
		}else if ( b > c) {
			System.out.println("B es mayor");
		}else {
			System.out.println("C es mayor");
		}
	}

}
