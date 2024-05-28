package co.eduo.uco.pch.crosscutting.exception.menssageCatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.eduo.uco.pch.crosscutting.exception.custom.CrosscuttingPCHException;
import co.eduo.uco.pch.crosscutting.exception.menssageCatalog.MenssageCatalog;
import co.eduo.uco.pch.crosscutting.exception.menssageCatalog.MenssageCatalogStrategy;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.Mensaje;
import co.eduo.uco.pch.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogExternalService implements MenssageCatalog {
	
	private final Map<String, Mensaje> mensajes = new HashMap<>();

	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00007.getIdentificador(), new Mensaje(CodigoMensaje.M00007, "la transaccion se ha completgado de forma satisfactoria"));

		
	}

	@Override
	public final String obtenerContenidoMensaje(final CodigoMensaje codigo,final String... parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public final  Mensaje obtenerMensaje(final CodigoMensaje codigo,final String... parametros) {
		if(ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario=MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		
		if(codigo.esBase()) {
			var mensajeUsuario= MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005, codigo.getIdentificador());
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		
		if(!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario= MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00006, codigo.getIdentificador());
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		
		return mensajes.get(codigo.getIdentificador());
	}

}


