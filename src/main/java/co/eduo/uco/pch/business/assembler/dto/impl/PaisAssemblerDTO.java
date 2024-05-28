package co.eduo.uco.pch.business.assembler.dto.impl;

import co.eduo.uco.pch.dto.PaisDTO;

import static co.eduo.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

import co.eduo.uco.pch.business.assembler.dto.AssemblerDTO;
import co.eduo.uco.pch.business.domain.PaisDomain;

public final class PaisAssemblerDTO implements AssemblerDTO<PaisDomain, PaisDTO>{
	
	private static final AssemblerDTO<PaisDomain, PaisDTO> instance = new PaisAssemblerDTO();
	
	private PaisAssemblerDTO() {
		super();
	}
	
	public static final AssemblerDTO<PaisDomain, PaisDTO> getInstance(){
		return instance;
	}

	@Override
	public final PaisDomain toDomain(final PaisDTO data) {
		var paisDtoTmp = getObjectHelper().getDefaultValue(data, PaisDTO.build());
		return PaisDomain.build(paisDtoTmp.getId(), paisDtoTmp.getNombre());
	}

	@Override
	public final PaisDTO toDTO(final PaisDomain domain) {
		var paisDomainTmp = getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		// TODO Auto-generated method stub
		return PaisDTO.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
	}

}
