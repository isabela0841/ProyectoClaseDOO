package co.eduo.uco.pch.crosscutting.exception.menssageCatalog;

import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.Mensaje;

public interface MenssageCatalog {
	
	void inicializar();
	String obtenerContenidoMensaje(final CodigoMensaje codigo, String...parametros);
	Mensaje obtenerMensaje(final CodigoMensaje codigo, String...parametros);
	
}
