package conexionpostgresql;

import conexionpostgresql.services.MediosPagosService;
import conexionpostgresql.servicesImpl.MediosPagosServiceImpl;

public class ConexionPostgresql {

	public static void main(String[] args) {
		
		MediosPagosService uno = new MediosPagosServiceImpl();
		
		MediosPagos  valor = uno.getOne(1L);
		
		System.out.println(valor.toString());

	}

}
