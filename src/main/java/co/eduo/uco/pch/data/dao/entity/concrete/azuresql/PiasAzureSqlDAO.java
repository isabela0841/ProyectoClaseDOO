package co.eduo.uco.pch.data.dao.entity.concrete.azuresql;

import java.sql.Connection;
import java.util.List;

import co.eduo.uco.pch.data.dao.entity.PaisDAO;
import co.eduo.uco.pch.data.dao.entity.concrete.SqlConnection;
import co.eduo.uco.pch.entity.PaisEntity;

public class PiasAzureSqlDAO extends SqlConnection implements PaisDAO{
	
	public PiasAzureSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public List<PaisEntity> consultar(PaisEntity data) {
		// TODO Auto-generated method stub
		return null;
	}

}
