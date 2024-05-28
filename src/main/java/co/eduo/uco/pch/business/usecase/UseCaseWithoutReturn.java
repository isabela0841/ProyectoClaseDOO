package co.eduo.uco.pch.business.usecase;

public interface UseCaseWithoutReturn<T> {
	
	void execute(T data);
}
