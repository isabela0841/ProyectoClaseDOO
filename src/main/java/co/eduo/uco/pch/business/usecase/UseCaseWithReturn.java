package co.eduo.uco.pch.business.usecase;

public interface UseCaseWithReturn<T, R> {
	
	void execute(T data);

}
