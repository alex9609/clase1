package ar.com.educacionit.exceptions;

import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class MenuMain {
	
	public static void main(String[] args) {
		//try {
			Integer op = MenuOption.getMenu();
			System.out.println("Ejecutando accion para el " + op);
		//}catch(InvalidMenuException e) {
		//	e.printStackTrace();
		//	System.exit(0);
		//}
		
		
	}
	
	
	
}
