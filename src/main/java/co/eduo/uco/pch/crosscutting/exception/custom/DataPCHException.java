package co.eduo.uco.pch.crosscutting.exception.custom;

import co.eduo.uco.pch.crosscutting.exception.PCHException;
import co.eduo.uco.pch.crosscutting.exception.enums.LugarEnum;

public final class DataPCHException extends PCHException {

	private static final long serialVersionUID = 1L;
	
	private static final LugarEnum lugar = LugarEnum.DATA;

	public DataPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}
	
	public DataPCHException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario, lugar);
	}
	
	public DataPCHException(final String mensajeTecnico,final String mensajeUsuario,final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}



}