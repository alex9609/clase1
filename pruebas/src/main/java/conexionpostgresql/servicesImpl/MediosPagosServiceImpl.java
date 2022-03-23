package conexionpostgresql.servicesImpl;

import conexionpostgresql.MediosPagos;
import conexionpostgresql.dao.GenericDao;
import conexionpostgresql.daoImpl.MediosPagosDaoImpl;
import conexionpostgresql.services.MediosPagosService;

public class MediosPagosServiceImpl implements MediosPagosService {

	GenericDao<MediosPagos> dao = new MediosPagosDaoImpl();


	@Override
	public MediosPagos getOne(Long i) {
		MediosPagos valor = dao.getOne(i);
		return valor;
	}


}
