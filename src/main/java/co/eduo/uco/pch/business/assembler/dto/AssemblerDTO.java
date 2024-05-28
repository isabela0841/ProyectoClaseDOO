package co.eduo.uco.pch.business.assembler.dto;

import java.util.List;

import co.eduo.uco.pch.business.assembler.Assembler;

public interface AssemblerDTO<D, K> extends Assembler<D, K>{
	
	K toDTO(D domain);
	
	List<K> toDTOCollection(Object resultadosDomain);

}