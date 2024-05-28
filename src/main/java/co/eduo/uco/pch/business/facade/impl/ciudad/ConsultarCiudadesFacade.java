package co.eduo.uco.pch.business.facade.impl.ciudad;

import java.util.List;

import co.eduo.uco.pch.business.assembler.dto.impl.CiudadAssemblerDTO;
import co.eduo.uco.pch.business.facade.FacadeWithReturn;
import co.eduo.uco.pch.business.usecase.impl.ciudad.ConsultarCiudades;
import co.eduo.uco.pch.crosscutting.exception.PCHException;
import co.eduo.uco.pch.crosscutting.exception.custom.BusinessPCHException;
import co.eduo.uco.pch.crosscutting.exception.menssageCatalog.MenssageCatalogStrategy;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.eduo.uco.pch.data.dao.factory.DAOFactory;
import co.eduo.uco.pch.dto.CiudadDTO;

public final class ConsultarCiudadesFacade implements FacadeWithReturn<CiudadDTO, List<CiudadDTO>> {
	
	private DAOFactory daoFactory;
	
	public ConsultarCiudadesFacade() {
		daoFactory = DAOFactory.getFactory();
	}
	

	@Override
	public final List<CiudadDTO> execute(final CiudadDTO dto) {
		
		try {
			var useCase = new ConsultarCiudades(daoFactory);
			var CiudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
			var resultadosDomain = useCase.execute(CiudadDomain);	
			
			return CiudadAssemblerDTO.getInstance().toDTOCollection(resultadosDomain);
		}catch(final PCHException excepcion) {
			throw excepcion;
		}catch(final Exception excepcion) {
			
			var mensajeUsuario = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00032);
			var mensajeTecnico = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00033);
			
			throw new BusinessPCHException(mensajeTecnico, mensajeUsuario, excepcion);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}