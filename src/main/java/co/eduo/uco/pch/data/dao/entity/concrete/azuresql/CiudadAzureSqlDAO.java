package co.eduo.uco.pch.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.eduo.uco.pch.crosscutting.exception.custom.DataPCHException;
import co.eduo.uco.pch.crosscutting.exception.menssageCatalog.MenssageCatalogStrategy;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.eduo.uco.pch.data.dao.entity.CiudadDAO;
import co.eduo.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.eduo.uco.pch.entity.CiudadEntity;

public final class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO{

	public CiudadAzureSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final CiudadEntity data) {
		final StringBuilder sentenciaSql = new StringBuilder();
		
		sentenciaSql.append("INSERT INTO Ciudad (id, nombre, departamento) ");
		sentenciaSql.append("SELECT ?,?,?");
		
		try(final PreparedStatement sentenciaSqlPreparada = getConexion().prepareStatement(sentenciaSql.toString())) {
			
			sentenciaSqlPreparada.setObject(1, data.getId());
			sentenciaSqlPreparada.setString(2, data.getNombre());
			sentenciaSqlPreparada.setObject(3, data.getDepartamento().getId());
			
			sentenciaSqlPreparada.executeUpdate();
			
		}catch(final SQLException excepcion) {
			var mensajeUsuario = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00023);
			var mensajeTecnico = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00024);
			
			throw new DataPCHException(mensajeTecnico, mensajeUsuario, excepcion);
		}catch(final Exception excepcion) {
			var mensajeUsuario = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00023);
			var mensajeTecnico = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00022);
			
			throw new DataPCHException(mensajeTecnico, mensajeUsuario, excepcion);
		}
		
	}

	@Override
	public List<CiudadEntity> consultar(CiudadEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(CiudadEntity data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
