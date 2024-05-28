package co.eduo.uco.pch.business.assembler.entity.impl;

import static co.eduo.uco.pch.crosscutting.helpers.ObjectHelper.getObjectHelper;

import co.eduo.uco.pch.business.assembler.entity.AssemblerEntity;
import co.eduo.uco.pch.business.domain.PaisDomain;
import co.eduo.uco.pch.entity.PaisEntity;

public class PaisAssemblerEntity implements AssemblerEntity<PaisDomain, PaisEntity> {
	
	private static final AssemblerEntity<PaisDomain, PaisEntity> instance = new PaisAssemblerEntity();
	private PaisAssemblerEntity() {
		super();
	}
	
	public static final AssemblerEntity<PaisDomain, PaisEntity> getInstance(){
		return instance;
	}

	@Override
	public final PaisDomain toDomain(final PaisEntity data) {
		var paisEntityTmp = getObjectHelper().getDefaultValue(data, PaisEntity.build());
		return PaisDomain.build(paisEntityTmp.getId(), paisEntityTmp.getNombre());
	}

	@Override
	public final  PaisEntity toEntity(final PaisDomain domain) {
		var paisDomainTmp = getObjectHelper().getDefaultValue(domain, PaisDomain.build());
		return PaisEntity.build().setId(paisDomainTmp.getId()).setNombre(paisDomainTmp.getNombre());
	}

}