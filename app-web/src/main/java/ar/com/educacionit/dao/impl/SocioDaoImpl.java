package ar.com.educacionit.dao.impl;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.domain.Socios;

public class SocioDaoImpl extends JdbcDaoBase<Socios> implements SociosDao {

	public SocioDaoImpl() {
		super("Socios"); // es la tabla
	}

	@Override
	public String getSaveSQL(Socios entity) {
			//Lo particupar del sql
		//(campo1, campo2, campoN)
		//values
		//(value1,value2,valueN)

		return ("(nombre,apellido,email,direccion,paises_id) values("+entity.getNombre() +  "," + entity.getApellido() + 
				"," + entity.getEmail() + "," + entity.getDireccion()+ ","+entity.getPaisesId()+")"); 
	}

	@Override
	
	public String getUpdateSQL(Socios entity) {
		String sql = "nombre='"+entity.getNombre()+"',"
		+"apellido='"+entity.getApellido()+"',"
		+"email='"+entity.getEmail()+"',";
		if(entity.getPaisesId() != null) {
			sql += "paises='"+entity.getPaisesId()+"'";			
		}
		return sql;
	} 

	//lo partiruclar de sql de socio
	
	
	/*
	public Socios save(Socios socio) {
		
		
		 *
		//Long id, String nombre, String apellido, String email, String direccion, Long paisesId
		
		
		//Ctrl + f = Para cambiar la puntuacion de algunos valores
		String sql = "INSERT INTO SOCIOS(VALORES),DATOS";
		System.out.println("Ejecutando sql: " + sql);
		return new Socios("Alex", "Rodriguez", "alexander10rodriguez@hotmail.com", "Bogota", 2L);
	}

	public Socios getOne(Long id) {
		
		String sql = "SELECT * FROM articulos WHERE ID=2;";
		System.out.println("Se ha encontrado el socio con id: " + id);
		return null;
	}

	public Socios[] findAll() {
		String sql = "select * from socios";
		//Varios row 0 > n
		
		System.out.println("Ejecutando sql:" + sql);
		
		Socios socio1 = new Socios(1l, "carlos", "lopez", "krloss@gmail.com", "av siempre viva 46", 1l);
		Socios socio2 = new Socios(2l, "carlos 1", "lopez", "krloss@gmail.com", "av siempre viva 46", 1l);
		Socios socio3 = new Socios(2l, "carlos 1", "lopez", "krloss@gmail.com", "av siempre viva 46", 1l);
		
		return new Socios[] {socio1,socio2,socio3};
	}


	public void delete(Long id) {
		String sql = "DELETE FROM socios WHERE id = 1";
		System.out.println();
	}

	public void update(Socios entity) {
		String sql = "UPDATE socios" +
		"SET direccion = 'Alameda170', APELLIDO = 'Rodriguez', paises_id = 2" + 
		"WHERE id = 1";
		System.out.println(sql);
		 */	
	/*public Socios selectCustom() {
		String sql = "select nombre, apellido from socios";
		System.out.println("Ejecutando sql: " + sql);
		return new Socios(1l, "carlos", "lopez", "krloss@gmail.com", "av siempre viva 46", 1l);
		
	}*/


}
