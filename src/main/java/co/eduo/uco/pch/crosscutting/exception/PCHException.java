package co.eduo.uco.pch.crosscutting.exception;

import co.eduo.uco.pch.crosscutting.exception.enums.LugarEnum;
import co.eduo.uco.pch.crosscutting.helpers.ObjectHelper;
import co.eduo.uco.pch.crosscutting.helpers.TextHelpers;

public class PCHException extends RuntimeException {

	private static final long serialVersionUID = 1L;
    protected String mensajeUsuario;
    protected LugarEnum lugar;
    
	public PCHException(String mensajeTecnico, String mensajeUsuario, LugarEnum lugar, Throwable excepcionRaiz) {
		super(mensajeTecnico, excepcionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}
	
	public PCHException(final String mensajeTecnico, final LugarEnum lugar) {
		super(mensajeTecnico, new Exception());
		setMensajeUsuario(mensajeUsuario);
		setLugar(lugar);
	}

	public final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = TextHelpers.applyTrim(mensajeUsuario);
	}

	public final void setLugar(final LugarEnum lugar) {
		this.lugar = ObjectHelper.getObjectHelper().getDefaultValue(lugar, LugarEnum.DEFAULT);
	}

	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public final LugarEnum getLugar() {
		return lugar;
	}
	
	
	
}
