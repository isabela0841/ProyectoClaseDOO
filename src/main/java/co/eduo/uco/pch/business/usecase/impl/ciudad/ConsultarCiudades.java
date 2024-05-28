package co.eduo.uco.pch.business.usecase.impl.ciudad;

import java.util.List;

import co.eduo.uco.pch.business.assembler.entity.impl.CiudadAssemblerEntity;
import co.eduo.uco.pch.business.domain.CiudadDomain;
import co.eduo.uco.pch.business.usecase.UseCaseWithReturn;
import co.eduo.uco.pch.crosscutting.exception.custom.BusinessPCHException;
import co.eduo.uco.pch.crosscutting.exception.menssageCatalog.MenssageCatalogStrategy;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.eduo.uco.pch.crosscutting.helpers.ObjectHelper;
import co.eduo.uco.pch.data.dao.factory.DAOFactory;

public class ConsultarCiudades implements UseCaseWithReturn<CiudadDomain, List<CiudadDomain>> {
	
	private DAOFactory factory;
	
	public ConsultarCiudades(final DAOFactory factory) {
		if(ObjectHelper.getObjectHelper().isNull(factory)) {
			var mensajeUsuario = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00029);
			var mensajeTecnico = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00030);
			throw new BusinessPCHException(mensajeTecnico, mensajeUsuario);
		}
		
		this.factory = factory;
	}

	@Override
	public final List<CiudadDomain> execute(final CiudadDomain data) {
		var ciudadEntityFilter = CiudadAssemblerEntity.getInstance().toEntity(data);
		var resultadosEntity = factory.getCiudadDAO().consultar(ciudadEntityFilter);
		
		
		return CiudadAssemblerEntity.getInstance().toDomainCollection(resultadosEntity);;
	}




}
