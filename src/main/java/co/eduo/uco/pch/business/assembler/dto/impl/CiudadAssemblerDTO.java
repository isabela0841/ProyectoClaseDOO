package co.eduo.uco.pch.business.assembler.dto.impl;

import static co.eduo.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

import co.eduo.uco.pch.business.assembler.dto.AssemblerDTO;
import co.eduo.uco.pch.business.domain.CiudadDomain;
import co.eduo.uco.pch.business.domain.DepartamentoDomain;
import co.eduo.uco.pch.dto.CiudadDTO;
import co.eduo.uco.pch.dto.DepartamentoDTO;

public final class CiudadAssemblerDTO implements AssemblerDTO<CiudadDomain, CiudadDTO> {
	
	private static final AssemblerDTO<DepartamentoDomain, DepartamentoDTO> departamentoAssembler = DepartamentoAssemblerDTO.getInstance();
	private static final AssemblerDTO<CiudadDomain, CiudadDTO> instance = new CiudadAssemblerDTO();
	
	private CiudadAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<CiudadDomain, CiudadDTO> getInstance(){
		return instance;
	}

	@Override
	public final CiudadDomain toDomain(final CiudadDTO data) {
		var ciudadDtoTmp = getObjectHelper().getDefaultValue(data, CiudadDTO.build());
		var departamentoDomain = departamentoAssembler.toDomain(ciudadDtoTmp.getDepartamento());
		return CiudadDomain.build(ciudadDtoTmp.getId(), ciudadDtoTmp.getNombre(), departamentoDomain);
	}

	@Override
	public final CiudadDTO toDTO(CiudadDomain domain) {
		var ciudadDomainTmp = getObjectHelper().getDefaultValue(domain, CiudadDomain.build());
		var departamentoDto = departamentoAssembler.toDTO(ciudadDomainTmp.getDepartamento());
		return CiudadDTO.build().setId(ciudadDomainTmp.getId()).setNombre(ciudadDomainTmp.getNombre()).setDepartamento(departamentoDto);
	}

}
