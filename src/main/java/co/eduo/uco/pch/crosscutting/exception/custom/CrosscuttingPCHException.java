package co.eduo.uco.pch.crosscutting.exception.custom;

import co.eduo.uco.pch.crosscutting.exception.PCHException;
import co.eduo.uco.pch.crosscutting.exception.enums.LugarEnum;

public final class CrosscuttingPCHException extends PCHException {

	private static final long serialVersionUID = 1L;
	private static final LugarEnum lugar = LugarEnum.CROSSCUTTING;

	public CrosscuttingPCHException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}
	
	public CrosscuttingPCHException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico,mensajeUsuario, lugar);
	}
	
	
	public CrosscuttingPCHException(final String mensajeTecnico,final String mensajeUsuario,final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}



}
