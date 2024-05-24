package co.eduo.uco.pch.crosscutting.exception.menssageCatalog.impl;

import co.eduo.uco.pch.crosscutting.exception.menssageCatalog.MenssageCatalog;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.eduo.uco.pch.crosscutting.helpers.ObjectHelper;

public final class MessageCatalogBase implements MenssageCatalog{
	
	private final Map<String, Mensaje> mensajes = new HashMap<>();
	
	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00001.getIdentificador(), new Mensaje(CodigoMensaje.M00001, "El codigo del mensaje que se quiere obtener del catalogo de mensajes llego nulo"));
		mensajes.put(CodigoMensaje.M00002.getIdentificador(), new Mensaje(CodigoMensaje.M00002, "Se ha presentado un problema tratando de llevar a cabo la operacion deseada"));
		mensajes.put(CodigoMensaje.M00003.getIdentificador(), new Mensaje(CodigoMensaje.M00003, "El identificador del mensaje \"${1}\" que se intento obtener no esta en el catalogo de mensajes base"));
		mensajes.put(CodigoMensaje.M00004.getIdentificador(), new Mensaje(CodigoMensaje.M00004, "El mensaje con identificador \"${1}\"  no esta configurado para residir en el catalogo de mensajes base"));
		mensajes.put(CodigoMensaje.M00005.getIdentificador(), new Mensaje(CodigoMensaje.M00005, "El mensaje con identificador \"${1}\"  no esta configurado para residir en el catalogo de mensajes externos"));
		mensajes.put(CodigoMensaje.M00006.getIdentificador(), new Mensaje(CodigoMensaje.M00006, "El identificador del mensaje \"${1}\" que se intento obtener no esta en el catalogo de mensajes externos"));
		
	}
	
	@Override
	public final String obtenerContenidoMensaje(final CodigoMensaje codigo, final String...parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
		
	}
	
	@Override
	public final Mensaje obtenerMensaje(final CodigoMensaje codigo, final String...parametros) {
		
		if(ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario=obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico=obtenerContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
			
		}
		
		if(!codigo.esBase()) {
			var mensajeUsuario=obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico=obtenerContenidoMensaje(CodigoMensaje.M00004, codigo.getIdentificador());
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
			
		}
		
		if(!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario=obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico=obtenerContenidoMensaje(CodigoMensaje.M00003, codigo.getIdentificador());
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
			
		}
		return mensajes.get(codigo.getIdentificador());
	}
	
	
	

}
