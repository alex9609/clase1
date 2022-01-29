package ar.com.educacionit.enums;

import java.util.Scanner;

public class MainLogger {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese una opción del logger:");
		System.out.println("FS");
		System.out.println("CONSOLE");
		
		String opcionLeida = teclado.next();
		
		//Cuando coloco punto me da las opciones del enum
		LoggersEnum fsEnum = LoggersEnum.getEnumFromString(opcionLeida);
		
		ILogger logger = LoggerFactory.getLoggerFromEnum(fsEnum);
		
		logger.loguear();
		
		//Los enum se instancia solos
		
		teclado.close();
	}
	


}
