package co.eduo.uco.pch.crosscutting.exception.menssageCatalog;

import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.Mensaje;

public interface MenssageCatalog {
	
	void inicializer();
	String obtenerContenidoMensaje(final CodigoMensaje codigo, String...parametros);
	Mensaje obtenerMnesaje(final CodigoMensaje codigo, String...parametros);


}
