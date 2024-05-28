package co.eduo.uco.pch.business.facade.impl.ciudad;

import co.eduo.uco.pch.business.assembler.dto.impl.CiudadAssemblerDTO;
import co.eduo.uco.pch.business.facade.FacadeWithoutReturn;
import co.eduo.uco.pch.business.usecase.impl.ciudad.RegistrarCiudad;
import co.eduo.uco.pch.crosscutting.exception.PCHException;
import co.eduo.uco.pch.crosscutting.exception.custom.BusinessPCHException;
import co.eduo.uco.pch.crosscutting.exception.menssageCatalog.MenssageCatalogStrategy;
import co.eduo.uco.pch.crosscutting.exception.messageCatalog.data.CodigoMensaje;
import co.eduo.uco.pch.data.dao.factory.DAOFactory;
import co.eduo.uco.pch.dto.CiudadDTO;

public final class RegistrarCiudadesFacade implements FacadeWithoutReturn<CiudadDTO> {
	
	private DAOFactory daoFactory;
	
	public RegistrarCiudadesFacade() {
		daoFactory = DAOFactory.getFactory();
	}

	@Override
	public void execute(final CiudadDTO dto) {
		
		daoFactory.iniciarTransaccion();
		
		try {
			var useCase = new RegistrarCiudad(daoFactory);
			var CiudadDomain = CiudadAssemblerDTO.getInstance().toDomain(dto);
			useCase.execute(CiudadDomain);
			
			daoFactory.confirmarTransaccion();
		}catch(final PCHException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		}catch(final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00023);
			var mensajeTecnico = MenssageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00031);
			
			throw new BusinessPCHException(mensajeTecnico, mensajeUsuario, excepcion);
		}finally {
			daoFactory.cerrarConexion();
		}
	}

}
