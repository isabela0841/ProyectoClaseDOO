package co.eduo.uco.pch.business.assembler.dto.impl;

import co.eduo.uco.pch.dto.DepartamentoDTO;
import co.eduo.uco.pch.dto.PaisDTO;

import static co.eduo.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

import co.eduo.uco.pch.business.assembler.dto.AssemblerDTO;
import co.eduo.uco.pch.business.domain.DepartamentoDomain;
import co.eduo.uco.pch.business.domain.PaisDomain;

public final class DepartamentoAssemblerDTO implements AssemblerDTO<DepartamentoDomain, DepartamentoDTO>{
	
	private static final AssemblerDTO<PaisDomain, PaisDTO> paisAssembler = PaisAssemblerDTO.getInstance();
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> instance = new DepartamentoAssemblerDTO();
	
	private DepartamentoAssemblerDTO() {
		super();
	}
	
	public final static AssemblerDTO<DepartamentoDomain, DepartamentoDTO> getInstance(){
		return instance;
	}

	@Override
	public final DepartamentoDomain toDomain(final DepartamentoDTO data) {
		var departamentoDtoTmp = getObjectHelper().getDefaultValue(data, DepartamentoDTO.build());
		var paisDomain = paisAssembler.toDomain(departamentoDtoTmp.getPais());
		return DepartamentoDomain.build(departamentoDtoTmp.getId(), departamentoDtoTmp.getNombre(), paisDomain);
	}

	@Override
	public final DepartamentoDTO toDTO(final DepartamentoDomain domain) {
		var departamentoDomainTmp = getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
		var paisDto = paisAssembler.toDTO(departamentoDomainTmp.getPais());
		return DepartamentoDTO.build().setId(departamentoDomainTmp.getId()).setNombre(departamentoDomainTmp.getNombre()).setPais(paisDto);
	}

}