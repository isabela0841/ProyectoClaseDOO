package co.eduo.uco.pch.crosscutting.helpers;

public final class ObjectHelper {
	
	private static final ObjectHelper INSTANCE = new ObjectHelper();
 
	private ObjectHelper() {
		super();
	}
	
	public static final ObjectHelper getObjectHelper() {
		return INSTANCE;
		
	}
	
	public <o> boolean isNull (o Objeto) {
		return Objeto == null;
	}
	
	public <o> o getDefaultValue(o Objeto, o valorDefecto) {
		return isNull(Objeto) ? valorDefecto : Objeto;
	}
}
