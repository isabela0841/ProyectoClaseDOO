package co.eduo.uco.pch.business.usecase.impl.ciudad;

import java.util.UUID;


import co.eduo.uco.pch.business.assembler.entity.impl.DepartamentoAssemblerEntity;
import co.eduo.uco.pch.business.domain.CiudadDomain;
import co.eduo.uco.pch.business.usecase.UseCaseWithoutReturn;
import co.eduo.uco.pch.crosscutting.exception.custom.BusinessPCHException;
import co.eduo.uco.pch.crosscutting.exception.menssageCatalog.MenssageCatalogStrategy;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.eduo.uco.pch.crosscutting.helpers.ObjectHelper;
import co.eduo.uco.pch.crosscutting.helpers.UUIDHelper;
import co.eduo.uco.pch.data.dao.factory.DAOFactory;
import co.eduo.uco.pch.entity.CiudadEntity;
import co.eduo.uco.pch.entity.DepartamentoEntity;

public final class RegistrarCiudad implements UseCaseWithoutReturn<CiudadDomain>{
	
	private DAOFactory factory;
	
	public RegistrarCiudad(final DAOFactory factory) {
		if(ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00023);
			var mensajeTecnico = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00025);
			throw new BusinessPCHException(mensajeTecnico, mensajeUsuario);
		}
		
		this.factory = factory;
	}

	@Override
	public void execute(final CiudadDomain data) {
		
		validarCiudadMismoNombreMismoDepartamento(data.getNombre(), data.getDepartamento().getId());
		
		var ciudadEntity = CiudadEntity.build().setId(generarIdentificadorCiudad()).setNombre(data.getNombre())
				.setDepartamento(DepartamentoAssemblerEntity.getInstance().toEntity(data.getDepartamento()));
		
		factory.getCiudadDAO().crear(ciudadEntity);
	}
	
	private final UUID generarIdentificadorCiudad() {
		UUID id = UUIDHelper.generate();
		boolean existeId = true;
		
		while(!existeId) {
			id = UUIDHelper.generate();
			var ciudadEntity = CiudadEntity.build().setId(id);
			var resultados = factory.getCiudadDAO().consultar(ciudadEntity);
			existeId = !resultados.isEmpty();
		}
		
		return id;
	}
	
	private final void validarCiudadMismoNombreMismoDepartamento(final String nombreCiudad, final UUID idDepartamento) {
		var ciudadEntity = CiudadEntity.build().setNombre(nombreCiudad).setDepartamento(DepartamentoEntity.build().setId(idDepartamento));
		var resultados = factory.getCiudadDAO().consultar(ciudadEntity);
		
		if(!resultados.isEmpty()) {
			var mensajeUsuario = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00026);
			throw new BusinessPCHException(mensajeUsuario);
		}
	}

}
