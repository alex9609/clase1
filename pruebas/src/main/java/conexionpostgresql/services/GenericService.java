package conexionpostgresql.services;

import conexionpostgresql.MediosPagos;

public interface GenericService<T> {
	public T getOne(Long i);

}
