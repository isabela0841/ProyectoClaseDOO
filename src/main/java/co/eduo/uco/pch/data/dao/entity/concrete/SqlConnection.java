package co.eduo.uco.pch.data.dao.entity.concrete;

import java.sql.Connection;

import co.eduo.uco.pch.crosscutting.exception.custom.DataPCHException;
import co.eduo.uco.pch.crosscutting.exception.menssageCatalog.MenssageCatalogStrategy;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.eduo.uco.pch.crosscutting.helpers.SQLHelper;

public class SqlConnection {
	
	private Connection conexion;
	
	protected SqlConnection(final Connection conexion) {
		setConexion(conexion);
	}
	
	protected SqlConnection() {
		super();
	}

	protected final Connection getConexion() {
		return conexion;
	}

	protected final void setConexion(final Connection conexion) {
		
		if(!SQLHelper.isOpen(conexion)) {
			var mensajeUsuario = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00012);
			
			throw new DataPCHException(mensajeTecnico, mensajeUsuario);
		}
		
		this.conexion = conexion;
	}
	
	

}