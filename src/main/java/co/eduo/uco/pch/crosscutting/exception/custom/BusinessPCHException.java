package co.eduo.uco.pch.crosscutting.exception.custom;

import co.eduo.uco.pch.crosscutting.exception.PCHException;
import co.eduo.uco.pch.crosscutting.exception.enums.LugarEnum;

public class BusinessPCHException extends PCHException {
	
	private static final long serialVersionUID = 1L;
	private static final LugarEnum lugar = LugarEnum.BUSINESS;

	public BusinessPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}
	
	public BusinessPCHException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario, lugar);
	}
	
	public BusinessPCHException(final String mensajeTecnico,final String mensajeUsuario,final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}

}
