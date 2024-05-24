package co.eduo.uco.pch.business.assembler;

public interface Assembler<D, K> {
	D toDomain(K data);

}
