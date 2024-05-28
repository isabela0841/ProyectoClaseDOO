package co.eduo.uco.pch.crosscutting.exception.menssageCatalog;

import co.eduo.uco.pch.crosscutting.exception.custom.CrosscuttingPCHException;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.Mensaje;
import co.eduo.uco.pch.crosscutting.exception.menssageCatalog.impl.MessageCatalogBase;
import co.eduo.uco.pch.crosscutting.exception.menssageCatalog.impl.MessageCatalogExternalService;
import co.eduo.uco.pch.crosscutting.helpers.ObjectHelper;

public final class MenssageCatalogStrategy {
	
	private static final MenssageCatalog base = new MessageCatalogBase();
	private static final MenssageCatalog externalService = new MessageCatalogExternalService();
	
	static {
		inicializar();
	}
	
	private MenssageCatalogStrategy() {
		super();
	}
	
	public static void inicializar() {
		base.inicializar();
		externalService.inicializar();
	}
	
	private static final MenssageCatalog getStrategy(final boolean esBase) {
		return esBase? base: externalService;
	}
	
	public static final Mensaje getMensaje(final CodigoMensaje codigo, final String...parametros) {
		
		if(ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario=MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscuttingPCHException(mensajeTecnico, mensajeUsuario);
		}
		
		return getStrategy(codigo.esBase()).obtenerMensaje(codigo, parametros);
	}
	
	public static final String  getContenidoMensaje(final CodigoMensaje codigo, final String...parametros) {
		return getMensaje(codigo, parametros).getContenido();
	}
	
	public static void main(String[] args) {
		System.out.println(getContenidoMensaje(CodigoMensaje.M00007));
	}

}
