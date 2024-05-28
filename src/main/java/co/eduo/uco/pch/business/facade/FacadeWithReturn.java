package co.eduo.uco.pch.business.facade;

public interface FacadeWithReturn<T, K> {
	
	K execute(T dto);
	
	

}
