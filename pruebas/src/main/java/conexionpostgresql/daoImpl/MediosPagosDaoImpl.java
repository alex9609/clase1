package conexionpostgresql.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexionpostgresql.Conexion;
import conexionpostgresql.MediosPagos;
import conexionpostgresql.dao.MediosPagosDao;

public class MediosPagosDaoImpl implements MediosPagosDao {

	@Override
	public MediosPagos getOne(Long i) {
		//Generar conexion a base de datos
		MediosPagos obj = new MediosPagos();
		
		Conexion con = new Conexion();
		
		String sql ="SELECT * FROM medios_pagos where id="+i;
		PreparedStatement estatuto;
		try {
			estatuto = con.obtenerConexion().prepareStatement(sql);
			estatuto.execute();
			ResultSet resul = estatuto.getResultSet();
			
			if(resul.next()) {
				System.out.println("Exitoso");
				obj.setId(resul.getLong("Id"));
				obj.setDescripcion(resul.getString("descripcion"));
				obj.setDescripcion_corta(resul.getString("descripcion_corta"));
				obj.setCodigo(resul.getString("codigo"));
				obj.setHabilitada(resul.getLong("habilitada"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return obj;
	}

}
