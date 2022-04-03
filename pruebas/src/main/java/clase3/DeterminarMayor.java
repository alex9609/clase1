package clase3;

import java.util.Scanner;

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
		
		System.out.println("  add mm  ".trim());
		
		int v = 0;
		while(v<=10) {
			v++;
		}
		System.out.println(v);
		
		String valor = "a";
		System.out.println(Long.parseLong(valor));
		
	}
	

}
