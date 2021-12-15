package practica_adicional_semana6;

import java.util.Date;

public class BancoMain {

	public static void main(String[] args) {
		
		Date fecha = new Date();
		Cliente nuevo_cliente = new Cliente("Alex Rodriguez",1019115,"alameda","Bogota");
		Empleado nuevo_empleado = new Empleado("Alex Rodri",12412,32013431,fecha,"Empleado");
		
		Sucursal suc_bogota = new Sucursal(1,"Bogota");
		Administracion admin_bog = new Administracion(1,12412);
		
		Producto cuenta_A = new Producto(121212,"Ahorro",15000,fecha);
		
		Object[] Banco = new Object[5];
		
		Banco[0] = nuevo_cliente;
		Banco[1] = nuevo_empleado;
		Banco[2] = suc_bogota;
		Banco[3] = admin_bog;
		Banco[4] = cuenta_A;
		
		for(Object obj: Banco) {
			if(obj instanceof Cliente) {	
				
			}
			if(obj instanceof Empleado) {
				cadena(obj);
			}
			if(obj instanceof Sucursal) {	
				cadena(obj);
			}
			if(obj instanceof Administracion) {	
				cadena(obj);
			}
			if(obj instanceof Producto) {	
				cadena(obj);
			}
			if(obj instanceof Cliente) {	
				cadena(obj);
			}
			
			System.out.println("-------------------");
			
		}
	}
	
	public static void cadena(Object obj) {
		System.out.println(obj.toString());
	}

}
