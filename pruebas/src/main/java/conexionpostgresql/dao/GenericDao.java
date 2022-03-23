package conexionpostgresql.dao;

public interface GenericDao<T> {
	
	public T getOne(Long i);
	
}
