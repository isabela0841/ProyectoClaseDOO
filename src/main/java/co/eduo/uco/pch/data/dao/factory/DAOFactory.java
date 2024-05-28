package co.eduo.uco.pch.data.dao.factory;

import co.eduo.uco.pch.data.dao.entity.CiudadDAO;
import co.eduo.uco.pch.data.dao.entity.DepartamentoDAO;
import co.eduo.uco.pch.data.dao.entity.PaisDAO;
import co.eduo.uco.pch.data.dao.factory.concrete.AzureSQLDAOFactory;

public interface DAOFactory {
	
	static DAOFactory getFactory() {
		return new AzureSQLDAOFactory();
	}
	
	void abrirConexion();
	void cerrarConexion();
	void iniciarTransaccion();
	void confirmarTransaccion();
	void cancelarTransaccion();
	
	PaisDAO getPaisDAO();
	DepartamentoDAO getDepartamentoDAO();
	CiudadDAO getCiudadDAO();

}