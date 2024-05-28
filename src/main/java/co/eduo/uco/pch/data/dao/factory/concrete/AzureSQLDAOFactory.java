package co.eduo.uco.pch.data.dao.factory.concrete;

import java.sql.DriverManager;
import java.sql.SQLException;

import co.eduo.uco.pch.crosscutting.helpers.SQLHelper;
import co.eduo.uco.pch.data.dao.entity.CiudadDAO;
import co.eduo.uco.pch.data.dao.entity.DepartamentoDAO;
import co.eduo.uco.pch.data.dao.entity.PaisDAO;
import co.eduo.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.eduo.uco.pch.data.dao.entity.concrete.azuresql.CiudadAzureSqlDAO;
import co.eduo.uco.pch.data.dao.entity.concrete.azuresql.DepartamentoAzureSqlDAO;
import co.eduo.uco.pch.data.dao.entity.concrete.azuresql.PiasAzureSqlDAO;
import co.eduo.uco.pch.data.dao.factory.DAOFactory;

public final class AzureSQLDAOFactory extends SqlConnection implements DAOFactory{
	
	

	public AzureSQLDAOFactory() {
		super();
		abrirConexion();
	}

	@Override
	public void abrirConexion() {
		try {
			String connectionString = "";
			setConexion(DriverManager.getConnection(connectionString));
		}catch(final SQLException excepcion) {
			
		}catch(final Exception excepcion) {
			
		}
		
	}

	@Override
	public void cerrarConexion() {
		SQLHelper.close(getConexion());

	}

	@Override
	public void iniciarTransaccion() {
		SQLHelper.initTransaction(getConexion());
		
	}

	@Override
	public void confirmarTransaccion() {
		SQLHelper.commit(getConexion());
		
	}

	@Override
	public void cancelarTransaccion() {
		SQLHelper.rollback(getConexion());
		
	}

	@Override
	public PaisDAO getPaisDAO() {
		return new PiasAzureSqlDAO(getConexion());
	}

	@Override
	public DepartamentoDAO getDepartamentoDAO() {
		return new DepartamentoAzureSqlDAO(getConexion());
	}

	@Override
	public CiudadDAO getCiudadDAO() {
		return new CiudadAzureSqlDAO(getConexion());
	}

}