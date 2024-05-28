package co.eduo.uco.pch.business.assembler.entity.impl;

import static co.eduo.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

import co.eduo.uco.pch.business.assembler.entity.AssemblerEntity;
import co.eduo.uco.pch.business.domain.DepartamentoDomain;
import co.eduo.uco.pch.business.domain.PaisDomain;
import co.eduo.uco.pch.entity.DepartamentoEntity;
import co.eduo.uco.pch.entity.PaisEntity;

public final class DepartamentoAssemblerEntity implements AssemblerEntity<DepartamentoDomain, DepartamentoEntity> {
	
	private static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> instance = new DepartamentoAssemblerEntity();
	private static final AssemblerEntity<PaisDomain, PaisEntity> paisAssembler = PaisAssemblerEntity.getInstance();
	
	private DepartamentoAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity<DepartamentoDomain, DepartamentoEntity> getInstance(){
		return instance;
	}

	@Override
	public final DepartamentoDomain toDomain(final DepartamentoEntity data) {
		var departamentoEntityTmp = getObjectHelper().getDefaultValue(data, DepartamentoEntity.build());
		var paisDomain = paisAssembler.toDomain(departamentoEntityTmp.getPais());
		return DepartamentoDomain.build(departamentoEntityTmp.getId(), departamentoEntityTmp.getNombre(), paisDomain);
	}

	@Override
	public final DepartamentoEntity toEntity(final DepartamentoDomain domain) {
		var departamentoDomainTmp = getObjectHelper().getDefaultValue(domain, DepartamentoDomain.build());
		var paisEntity = paisAssembler.toEntity(departamentoDomainTmp.getPais());
		return DepartamentoEntity.build().setId(departamentoDomainTmp.getId()).setNombre(departamentoDomainTmp.getNombre()).setPais(paisEntity);
	}

}