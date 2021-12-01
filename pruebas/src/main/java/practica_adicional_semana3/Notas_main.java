package practica_adicional_semana3;

import java.util.Scanner;

public class Notas_main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String nombre,apellido;
		int cantidad_alumnos, cantidad_examenes;
		Alumno[] alumnos;
		String estudianteGanador,estudianteUltimo;
		double notaGanador,notaUltimo;
		String[] aprobados, reprobados;
		
		
		//Hacemos el ingreso de la cantidad de alumnos y examenes
		//mediante un bucle while especificamos que los valores sean mayores a 0
		
		//Usamos parseInt para poder cambiar los valores de String a Integer que nos ingrese por teclado el usuario
		System.out.println("Ingrese la cantidad de alumnos: ");
		cantidad_alumnos = Integer.parseInt(teclado.next());
		while(cantidad_alumnos<=0) {
			System.out.println("La cantidad de alumnos debe ser mayor a 0: ");
			cantidad_alumnos = Integer.parseInt(teclado.next());
		}
		
		alumnos = new Alumno[cantidad_alumnos];
		
		System.out.println("Ingrese la cantidad de examenes presentados: ");
		cantidad_examenes = Integer.parseInt(teclado.next());
		
		while(cantidad_examenes<=0) {
			System.out.println("La cantidad de examenes presentados debe ser mayor a 0: ");
			cantidad_examenes = Integer.parseInt(teclado.next());
		}
		
		
		//Ingresamos el nombre de los estudiantes en el vector de alumnos
		
		for(int i = 0; i<cantidad_alumnos;i++) {
			System.out.println("Datos estudiante #"+(i+1) );
			System.out.println("Ingrese nombre del estudiante :");
			nombre = teclado.next();
			
			System.out.println("Ingrese apellido del estudiante");
			apellido = teclado.next();
			
			alumnos[i] = new Alumno(nombre,apellido,cantidad_examenes);			
		}
		
		
		System.out.println("-------- INGRESAREMOS LAS NOTAS DE CADA ESTUDIANTE ---------");
		
		
		for(Alumno user: alumnos) {
			
			//Usamos el metodo de la clase alumno para ingresar las notas
			System.out.println("Ingrese las notas para : " + user.obtener_nombre());
			user.ingresar_nota();
		}
		
		System.out.println("------ NOTA MAS ALTA DE TODOS LOS ESTUDIANTES ----------");
		System.out.println("");
		
		
		notaGanador = -1;
		estudianteGanador = "";
		estudianteUltimo = "";
		notaUltimo = 11;
		
		//Verificamos cuales son los estudiantes con la nota más alta
		//en el caso que sean varios, se ingresan en el mismo string separados por un -
		for(Alumno user: alumnos) {
			if(user.nota_alta() >=  notaGanador) {
				notaGanador = user.nota_alta();
				estudianteGanador += user.obtener_nombre() +" - ";
			}
			if(user.nota_baja() <= notaUltimo) {
				notaUltimo = user.nota_baja();
				estudianteUltimo +=  user.obtener_nombre()+" - ";
			}
		}
		System.out.println("--");
		System.out.println("Los estudiante con la nota más alta fueron: ");
		System.out.println(" ");
		System.out.println(estudianteGanador);
		System.out.println("Nota : "+ notaGanador);
		System.out.println("\"Los estudiante con la nota más baja fueron: ");
		System.out.println(" ");
		System.out.println(estudianteUltimo);
		System.out.println("Nota : "+ notaUltimo);
		
		
		System.out.println("----------- APROBACION ESTUDIANTES -------------");
		System.out.println("");
		
		//Contaremos la cantidad de estudiantes aprobados y reprobados
		//para poder crear el tamaño de los vectores donde se guardaran los nombres de los estudiantes
		
		int cantidadAprobados = 0, cantidadReprobados = 0;
		for(Alumno user: alumnos) {
			if(user.promedio() >= 7) {
				cantidadAprobados +=1;
			}else {
				cantidadReprobados += 1;
			}
		}
		
		aprobados = new String[cantidadAprobados];
		reprobados = new String[cantidadReprobados];
		int indice1 = 0;
		int indice2 = 0;
		for(Alumno user: alumnos) {
			if(user.promedio()>= 7) {
				aprobados[indice1] = user.obtener_nombre()+" "+user.promedio();
				indice1 += 1;
			}else {
				reprobados [indice2] = user.obtener_nombre()+" "+user.promedio();
				indice2 += 1;
			}
		}
		
		System.out.println("Alumnos que aprobaron el programa");
		System.out.println("");
		for(String aprobado:aprobados) {
			System.out.println(aprobado);
		}
		
		System.out.println("  -----------  ");
		System.out.println("Alumnos que reprobaron el programa");
		System.out.println("");
		
		for(String reprobado:reprobados) {
			System.out.println(reprobado);
		}

		
		System.out.println();
		teclado.close();
	}

}
